package ds.examples.history;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ds.examples.gui.BankingMenuGUI;
import ds.examples.history.HistoryServiceGrpc.HistoryServiceBlockingStub;
import ds.examples.history.HistoryServiceGrpc.HistoryServiceStub;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HistoryServiceGUI {
	
	private static HistoryServiceBlockingStub blockingStub;
	private static HistoryServiceStub asyncStub;
	private ServiceInfo historyServiceInfo;

	private JFrame frame;
	private JTextField startId;
	private JTextField endId;
	private JTextField recentText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryServiceGUI window = new HistoryServiceGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HistoryServiceGUI() {
		
		String history_service_type = "_history._tcp.local.";
		discoverHistoryService(history_service_type);
		String host = historyServiceInfo.getHostAddresses()[0];
		int port = historyServiceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		blockingStub = HistoryServiceGrpc.newBlockingStub(channel);

		asyncStub = HistoryServiceGrpc.newStub(channel);
		
		initialize();
	}

private void discoverHistoryService(String service_type) {
		
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());		
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("History Service resolved: " + event.getInfo());

					historyServiceInfo = event.getInfo();

					int port = historyServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties: ");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t host: " + historyServiceInfo.getHostAddresses()[0]);
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("History Service removed: " + event.getInfo());					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("History Service added: " + event.getInfo());
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
		
		ArrayList<Integer> groupId = new ArrayList();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				BankingMenuGUI maingui = new BankingMenuGUI();
				maingui.main(null);
			}
		});
		btnBack.setBounds(10, 327, 70, 23);
		frame.getContentPane().add(btnBack);
		
		startId = new JTextField();
		startId.setBounds(75, 49, 86, 20);
		frame.getContentPane().add(startId);
		startId.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(81, 142, 429, 196);
		frame.getContentPane().add(textArea);
		
		endId = new JTextField();
		endId.setBounds(206, 49, 86, 20);
		frame.getContentPane().add(endId);
		endId.setColumns(10);
		
		
		recentText = new JTextField();
		recentText.setBounds(58, 98, 86, 20);
		frame.getContentPane().add(recentText);
		recentText.setColumns(10);
		
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//displayTransaction
				int num1 = Integer.parseInt(startId.getText());
				int num2 = Integer.parseInt(endId.getText());
				DisplayRequest request = DisplayRequest.newBuilder().setTransactionIdStart(num1).setTransactionIdEnd(num2).build();
				
				StreamObserver<DisplayResponse> responseObserver = new StreamObserver<DisplayResponse>() {

					@Override
					public void onNext(DisplayResponse value) {
						textArea.append("Transaction ID: "+value.getTransactionId()+" amount spend: " + value.getTransactionAmount()+"\n");

					}

					@Override
					public void onError(Throwable t) {
					}

					@Override
					public void onCompleted() {
						textArea.append("Transaction group complete"+"\n");
					}
					
				};
				asyncStub.displayTransaction(request, responseObserver);
				
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDisplay.setBounds(302, 48, 89, 23);
		frame.getContentPane().add(btnDisplay);
		
		JLabel lblNewLabel = new JLabel("Insert a start and end transaction ID");
		lblNewLabel.setBounds(63, 24, 222, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblStartId = new JLabel("Start ID");
		lblStartId.setBounds(27, 52, 46, 14);
		frame.getContentPane().add(lblStartId);
		
		JLabel lblNewLabel_1 = new JLabel("End ID");
		lblNewLabel_1.setBounds(170, 52, 37, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JButton btnSearch = new JButton("Search group");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//recentTransactions RecentRequest numberId transactionValue
				
				StreamObserver<RecentResponse> responseObserver = new StreamObserver<RecentResponse>() {

					@Override
					public void onNext(RecentResponse value) {
						textArea.append("Total of value of the ID's searched is: "+value.getTransactionValue()+"\n");
					}

					@Override
					public void onError(Throwable t) {
					}

					@Override
					public void onCompleted() {
						textArea.append("Search complete"+"\n");
					}
				};
				StreamObserver<RecentRequest> requestObserver = asyncStub.recentTransactions(responseObserver);
			
				try {
					for(int i = 0; i <= groupId.size()-1; i++) {
						requestObserver.onNext(RecentRequest.newBuilder().setNumberId(groupId.get(i)).build());
					}
					groupId.clear();
					requestObserver.onCompleted();
					Thread.sleep(1000);
					
				}catch (RuntimeException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {			
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnAdd = new JButton("Add to group");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(recentText.getText());
				
				groupId.add(id);
				recentText.setText("");
				
				textArea.append("ID: "+id+" added to group"+"\n");
			}
		});
		btnAdd.setBounds(158, 97, 117, 23);
		frame.getContentPane().add(btnAdd);

		btnSearch.setBounds(285, 97, 130, 23);
		frame.getContentPane().add(btnSearch);

		JLabel lblSearchForRecent = new JLabel("Total a group of recent transactions by adding their ID's to the search");
		lblSearchForRecent.setBounds(46, 82, 369, 14);
		frame.getContentPane().add(lblSearchForRecent);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(32, 101, 24, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblTransactionHistory = new JLabel("Transaction History");
		lblTransactionHistory.setBounds(294, 11, 158, 14);
		frame.getContentPane().add(lblTransactionHistory);

	}
}
