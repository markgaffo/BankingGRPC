package ds.examples.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.examples.view.AccountNameRequest;
import ds.examples.view.AccountNameResponse;
import ds.examples.view.ViewServiceGrpc.ViewServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ViewServer extends ViewServiceImplBase{

	public static void main(String[] args) {
		ViewServer viewServer = new ViewServer();
		Properties prop = viewServer.getProperties();
		
		viewServer.registerService(prop);
		int port = Integer.valueOf(prop.getProperty("service_port"));
		
		try {
			Server firstserver = ServerBuilder.forPort(port)
					.addService(viewServer)
					.build()
					.start();

			System.out.println("The View Server started, listening on " + port);

			firstserver.awaitTermination();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	
	private Properties getProperties() {
		Properties prop = null;
		
		try(InputStream viewfile = new FileInputStream("src/main/resources/view.properties")){
			prop = new Properties();
			prop.load(viewfile);
			
			System.out.println("View Service properies:\n Service_type: " + prop.getProperty("service_type") +
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
	            String service_name = prop.getProperty("service_name")  ;// "view_service"
	            int service_port = Integer.valueOf( prop.getProperty("service_port"));// #.50052;
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
	
	public void accountName(AccountNameRequest request, 
			StreamObserver<AccountNameResponse> responseObserver) {
		
		String name= "";
		int age = 0;
		
		if(request.getAccId() == 1) {
			name = "Mark Gaffney";
			age = 22;
		}
		else if(request.getAccId() == 2) {
			name = "Steve Peterson";
			age = 51;
		}
		else if(request.getAccId() == 3) {
			name = "John Tool";
			age = 44;
		}
		else if(request.getAccId() == 4) {
			name = "Emma Buckly";
			age = 19;
		}
		else if(request.getAccId() == 5) {
			name = "Shawn Murphy";
			age = 27;
		}
		else if(request.getAccId() == 6) {
			name = "Peter Maru";
			age = 34;
		}
		else if(request.getAccId() == 7) {
			name = "Kevin O'Brien";
			age = 39;
		}
		else {
			name = "No account found.";
			age = 0;
		}
		
		AccountNameResponse reply = AccountNameResponse.newBuilder().setAccName(name).setAccAge(age).build();

		responseObserver.onNext(reply);

		responseObserver.onCompleted();
	}
	
	public void viewContacts(ContactsRequest request, 
			StreamObserver<ContactsResponse> responseObserver) {
		
		System.out.printf("receiving contact group: %d \n", request.getContactGroup());
		int IdCount = 0;
		int IdCount2 = 5;
		int IdCount3 = 9;
		String name = "";
		
		ArrayList<String> listGroup1 = new ArrayList();
		ArrayList<String> listGroup2 = new ArrayList();
		ArrayList<String> listGroup3 = new ArrayList();
		
		listGroup1.add("Mark");
		listGroup1.add("Jon");
		listGroup1.add("Steve");
		
		listGroup2.add("Peter");
		listGroup2.add("Steve");
		listGroup2.add("Ella");
		
		
		listGroup3.add("Stella");
		listGroup3.add("Mark");
		listGroup3.add("Anna");
		
		if(request.getContactGroup() == 1) {
			for(int i=0; i <= listGroup1.size()-1; i++) {
				IdCount = IdCount + 1;
				
				name = listGroup1.get(i);
				
				ContactsResponse reply = ContactsResponse.newBuilder().setContactDetails(name).setContactId(IdCount).build();
				
				responseObserver.onNext(reply);
			}
		}
		else if(request.getContactGroup() == 2) {
			for(int i=0; i <= listGroup2.size()-1; i++) {
				IdCount2 = IdCount2 + 1;
				
				name = listGroup2.get(i);
				
				ContactsResponse reply = ContactsResponse.newBuilder().setContactDetails(name).setContactId(IdCount2).build();
				
				responseObserver.onNext(reply);
			}
		}
		else if(request.getContactGroup() == 3) {
			for(int i=0; i <= listGroup3.size()-1; i++) {
				IdCount3 = IdCount3 + 1;
				
				name = listGroup3.get(i);
				
				ContactsResponse reply = ContactsResponse.newBuilder().setContactDetails(name).setContactId(IdCount3).build();
				
				responseObserver.onNext(reply);
			}
		}
		else {
			IdCount = 000;
			
			name = "No Group found, try another group number";
			
			ContactsResponse reply = ContactsResponse.newBuilder().setContactDetails(name).setContactId(IdCount).build();
			
			responseObserver.onNext(reply);
		}
		
		responseObserver.onCompleted();
	}
	
}
