package ds.examples.history;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.examples.history.HistoryServiceGrpc.HistoryServiceImplBase;
import ds.examples.history.DisplayRequest;
import ds.examples.history.DisplayResponse;
import ds.examples.history.RecentRequest;
import ds.examples.history.RecentResponse;
import ds.examples.history.HistoryServer;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class HistoryServer extends HistoryServiceImplBase {

	public static void main(String[] args) {
		
		HistoryServer historyServer = new HistoryServer();
		Properties prop = historyServer.getProperties();
		
		historyServer.registerService(prop);
		int port = Integer.valueOf(prop.getProperty("service_port"));
		
		try {
			Server thirdserver = ServerBuilder.forPort(port)
					.addService(historyServer)
					.build()
					.start();

			System.out.println("The History Server started, listening on " + port);

			thirdserver.awaitTermination();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

	private Properties getProperties() {
		Properties prop = null;
		
		try(InputStream historyfile = new FileInputStream("src/main/resources/history.properties")){
			prop = new Properties();
			prop.load(historyfile);
			
			System.out.println("History Service properies:\n Service_type: " + prop.getProperty("service_type") +
					"\n service_name: " + prop.getProperty("service_name") + "\n service_description: " + prop.getProperty("service_description") + 
					"\n service_port: " +prop.getProperty("service_port"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	//register service
	private void registerService(Properties prop) {
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local."
	            String service_name = prop.getProperty("service_name")  ;// "history_service"
	            int service_port = Integer.valueOf( prop.getProperty("service_port"));// #.50053;
	            String service_description_properties = prop.getProperty("service_description")  ;
	            
	            // Register a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registrering service with type %s \n", service_type);
	            
	            // Wait a bit
	            Thread.sleep(1000);

	            // Unregister all services 
	            //could be used for changing GUI services
	            //jmdns.unregisterAllServices();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				e.printStackTrace();
			}

	}
	
		public void displayTransaction(DisplayRequest request, 
				StreamObserver<DisplayResponse> responseObserver) {
			
			System.out.printf("getting groups: %d \n", request.getTransactionIdStart());
			Random rand = new Random();
			int numId = 0;
			for(int i=0; i<request.getTransactionIdEnd(); i++) {
				
				int spend_history = rand.nextInt(1000 - 1);
				numId = numId +1;
				
				DisplayResponse reply = DisplayResponse.newBuilder().setTransactionId(numId).setTransactionAmount(spend_history).build();

				responseObserver.onNext(reply);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			responseObserver.onCompleted();
		}
	
		public StreamObserver<RecentRequest> recentTransactions(
				StreamObserver<RecentResponse> responseObserver) {


			return new StreamObserver<RecentRequest>() {
				
				int amount = 0;
				
				
				@Override
				public void onNext(RecentRequest request) {
					
					
					if(request.getNumberId() == 1) {
						amount = amount + 140;
					}
					else if(request.getNumberId() == 2) {
						amount = amount +299;
					}
					else if(request.getNumberId() == 3) {
						amount = amount +25;
					}
					else if(request.getNumberId() == 4) {
						amount = amount +40;
					}
					else if(request.getNumberId() == 5) {
						amount = amount +230;
					}
					else if(request.getNumberId() == 6) {
						amount = amount +125;
					}
					else if(request.getNumberId() == 7) {
						amount = amount +110;
					}
					else if(request.getNumberId() == 8) {
						amount = amount +320;
					}
					else if(request.getNumberId() == 9) {
						amount = amount +600;
					}
					else if(request.getNumberId() == 10) {
						amount = amount +700;
					}
					else {
						amount = amount +0;
					}
					
					System.out.println("receiving Id: "+ request.getNumberId());
				
				}
				

				@Override
				public void onError(Throwable t) {
				}

				@Override
				public void onCompleted() {
					System.out.printf("receiving averageValues method complete \n" );
					
					RecentResponse reply = RecentResponse.newBuilder().setTransactionValue(amount).build();

					responseObserver.onNext(reply);
					
					responseObserver.onCompleted();		
				}


			};

		}
		
}
