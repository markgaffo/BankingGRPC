package ds.examples.history;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.examples.history.HistoryServiceGrpc.HistoryServiceImplBase;
import ds.examples.history.HistoryServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;

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
}
