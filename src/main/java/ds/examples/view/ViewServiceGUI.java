package ds.examples.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ds.examples.gui.BankingMenuGUI;
import ds.examples.view.ViewServiceGrpc.ViewServiceBlockingStub;
import ds.examples.view.ViewServiceGrpc.ViewServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewServiceGUI {
	private static ViewServiceBlockingStub blockingStub;
	private static ViewServiceStub asyncStub;
	private ServiceInfo viewServiceInfo;
	
	private JFrame frame;
	private JTextField accIdText;
	private JTextField groupIdText;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewServiceGUI window = new ViewServiceGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ViewServiceGUI() {
		
		String view_service_type = "_view._tcp.local.";
		discoverViewService(view_service_type);
		String host = viewServiceInfo.getHostAddresses()[0];
		int port = viewServiceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		blockingStub = ViewServiceGrpc.newBlockingStub(channel);

		asyncStub = ViewServiceGrpc.newStub(channel);
		
		initialize();
	}

	
	private void discoverViewService(String service_type) {
		
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());		
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("View Service resolved: " + event.getInfo());

					viewServiceInfo = event.getInfo();

					int port = viewServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties: ");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t host: " + viewServiceInfo.getHostAddresses()[0]);
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("View Service removed: " + event.getInfo());					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("View Service added: " + event.getInfo());
				}
			});
			
			// wait
			Thread.sleep(2500);
			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				BankingMenuGUI maingui = new BankingMenuGUI();
				maingui.main(null);
			}
		});
		btnBack.setBounds(10, 327, 66, 23);
		frame.getContentPane().add(btnBack);
		
		accIdText = new JTextField();
		accIdText.setBounds(228, 42, 86, 20);
		frame.getContentPane().add(accIdText);
		accIdText.setColumns(10);
		
		groupIdText = new JTextField();
		groupIdText.setBounds(228, 91, 86, 20);
		frame.getContentPane().add(groupIdText);
		groupIdText.setColumns(10);
		
		JTextArea ServerResponseArea = new JTextArea();
		ServerResponseArea.setBounds(228, 122, 363, 201);
		frame.getContentPane().add(ServerResponseArea);
		
		JLabel lblEnterA = new JLabel("Enter an account ID:");
		lblEnterA.setBounds(101, 45, 117, 14);
		frame.getContentPane().add(lblEnterA);
		
		JLabel lblEnter = new JLabel("Enter a contact group ID to view:");
		lblEnter.setBounds(32, 94, 186, 14);
		frame.getContentPane().add(lblEnter);
		
		JButton btnSubmitAccId = new JButton("Submit");
		btnSubmitAccId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int accID = Integer.parseInt(accIdText.getText());

				AccountNameRequest request = AccountNameRequest.newBuilder().setAccId(accID).build();

				AccountNameResponse response = blockingStub.accountName(request);
				
				ServerResponseArea.append("Account name: "+ response.getAccName() + " who is "+ response.getAccAge() + " years old."+ "\n");
				
				System.out.println("Sever response: " + response.getAccName() + " : " + response.getAccAge());
			}
		});
		btnSubmitAccId.setBounds(362, 41, 89, 23);
		frame.getContentPane().add(btnSubmitAccId);
		
		JButton btnSubmitGroupId = new JButton("Submit");
		btnSubmitGroupId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int groupID = Integer.parseInt(groupIdText.getText());

				ContactsRequest request = ContactsRequest.newBuilder().setContactGroup(groupID).build();

				StreamObserver<ContactsResponse> responseObserver = new StreamObserver<ContactsResponse>() {

					@Override
					public void onNext(ContactsResponse value) {
						System.out.println("Contact name: "+ value.getContactDetails() + " ID:"+ value.getContactId()+ "\n");
						ServerResponseArea.append("Contact name: "+ value.getContactDetails() + " ID:"+ value.getContactId()+ "\n");
					}

					@Override
					public void onError(Throwable t) {
					}

					@Override
					public void onCompleted() {
						ServerResponseArea.append("\n Group complete"+ "\n");	
					}
					
				};
				
				asyncStub.viewContacts(request, responseObserver);
				
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSubmitGroupId.setBounds(362, 90, 89, 23);
		frame.getContentPane().add(btnSubmitGroupId);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 634, 90);
		frame.getContentPane().add(panel);
		
		JLabel lblViewAccountDetails = new JLabel("View Account Details");
		panel.add(lblViewAccountDetails);
	}
}
