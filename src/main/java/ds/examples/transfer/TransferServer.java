package ds.examples.transfer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.examples.transfer.TransferServiceGrpc.TransferServiceImplBase;
import ds.examples.transfer.DepositResponse;
import ds.examples.transfer.DepositRequest;
import ds.examples.transfer.TransferServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class TransferServer extends TransferServiceImplBase {

	public static void main(String[] args) {

		TransferServer transferServer = new TransferServer();
		Properties prop = transferServer.getProperties();
		
		transferServer.registerService(prop);
		int port = Integer.valueOf(prop.getProperty("service_port"));
		
		try {
			Server secondserver = ServerBuilder.forPort(port)
					.addService(transferServer)
					.build()
					.start();

			System.out.println("The Transfer Server started, listening on " + port);

			secondserver.awaitTermination();


		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	private Properties getProperties() {
		Properties prop = null;
		
		try(InputStream transferfile = new FileInputStream("src/main/resources/transfer.properties")){
			prop = new Properties();
			prop.load(transferfile);
			
			System.out.println("Transfer Service properies:\n Service_type: " + prop.getProperty("service_type") +
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
	            String service_name = prop.getProperty("service_name")  ;// "transfer_service"
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
	
	public StreamObserver<DepositRequest> depositFunds(
			StreamObserver<DepositResponse> responseObserver){
		
		return new StreamObserver<DepositRequest>() {
			
			int total = 0;
			@Override
			public void onNext(DepositRequest request) {
				
				
				
			}

			@Override
			public void onError(Throwable t) {
			}

			@Override
			public void onCompleted() {
				
				DepositResponse reply = DepositResponse.newBuilder().setDepositTotal(total).build();
				
				responseObserver.onNext(reply);

				responseObserver.onCompleted();
			}
			
		};
	}

}
