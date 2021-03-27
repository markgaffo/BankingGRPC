package ds.examples.transfer;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ds.examples.gui.BankingMenuGUI;
import ds.examples.transfer.TransferServiceGrpc.TransferServiceBlockingStub;
import ds.examples.transfer.TransferServiceGrpc.TransferServiceStub;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TransferServiceGUI {
	private static TransferServiceBlockingStub blockingStub;
	private static TransferServiceStub asyncStub;
	private ServiceInfo transferServiceInfo;

	private JFrame frame;
	private JTextField deposit;
	private JTextField deduct;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferServiceGUI window = new TransferServiceGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TransferServiceGUI() {
		
		String transfer_service_type = "_transfer._tcp.local.";
		discoverTransferService(transfer_service_type);
		String host = transferServiceInfo.getHostAddresses()[0];
		int port = transferServiceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		blockingStub = TransferServiceGrpc.newBlockingStub(channel);

		asyncStub = TransferServiceGrpc.newStub(channel);
		
		initialize();
	}

	private void discoverTransferService(String service_type) {
		
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());		
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Transfer Service resolved: " + event.getInfo());

					transferServiceInfo = event.getInfo();

					int port = transferServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties: ");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t host: " + transferServiceInfo.getHostAddresses()[0]);
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Transfer Service removed: " + event.getInfo());					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Transfer Service added: " + event.getInfo());
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
		
		ArrayList<Integer> moneyStream = new ArrayList();
		ArrayList<Integer> deductStream = new ArrayList();
		
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
		
		JTextArea ServerResponseText = new JTextArea();
		ServerResponseText.setBounds(86, 156, 538, 176);
		frame.getContentPane().add(ServerResponseText);
		
		deposit = new JTextField();
		deposit.setBounds(220, 12, 86, 20);
		frame.getContentPane().add(deposit);
		deposit.setColumns(10);
		
		deduct = new JTextField();
		deduct.setBounds(220, 69, 86, 20);
		frame.getContentPane().add(deduct);
		deduct.setColumns(10);
		

		JButton btnDepositCom = new JButton("submit");
		btnDepositCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StreamObserver<DepositResponse> responseObserver = new StreamObserver<DepositResponse>() {

					@Override
					public void onNext(DepositResponse value) {
						ServerResponseText.append("The new balance is: "+value.getDepositTotal()+"\n");
					}

					@Override
					public void onError(Throwable t) {
						
					}

					@Override
					public void onCompleted() {
						ServerResponseText.append("Completed adding deposit now..."+"\n");
					}
					
				};
				
				StreamObserver<DepositRequest> requestObserver = asyncStub.depositFunds(responseObserver);
				try {
					for(int i = 0; i <= moneyStream.size()-1; i++) {
						requestObserver.onNext(DepositRequest.newBuilder().setDepositAmount(moneyStream.get(i)).build());
					}
					moneyStream.clear();
					requestObserver.onCompleted();
					Thread.sleep(10000);
					
				}catch (RuntimeException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {			
					e1.printStackTrace();
				}
				

			}
		});
		btnDepositCom.setBounds(434, 11, 89, 23);
		frame.getContentPane().add(btnDepositCom);
		
		JButton btnDeposit = new JButton("Add");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int money = Integer.parseInt(deposit.getText());
				
				moneyStream.add(money);
				deposit.setText("");
				
				ServerResponseText.append("The Adding: "+ money +" to balance"+"\n");
			}
		});
		btnDeposit.setBounds(316, 11, 89, 23);
		frame.getContentPane().add(btnDeposit);
		
		JButton btnDeductCom = new JButton("Finished");
		btnDeductCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StreamObserver<DeductResponse> responseObserver = new StreamObserver<DeductResponse>() {
					int counter = 0;
					@Override
					public void onNext(DeductResponse value) {
						counter = counter +1;
							ServerResponseText.append("Dedction "+counter+" complete, the new balance is: "+value.getDeductTotal()+"\n");
					}

					@Override
					public void onError(Throwable t) {					
					}

					@Override
					public void onCompleted() {
						ServerResponseText.append("Completed deductions");
					}
					
				};
				
				StreamObserver<DeductRequest> requestObserver = asyncStub.deductFunds(responseObserver);
				
				try {
					for(int i = 0; i <= deductStream.size()-1; i++) {
						requestObserver.onNext(DeductRequest.newBuilder().setDeductAmount(deductStream.get(i)).build());
					}
					moneyStream.clear();
					requestObserver.onCompleted();
					
					Thread.sleep(1000);
					
				}catch (RuntimeException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {			
					e1.printStackTrace();
				}
				
				
			}
		});
		btnDeductCom.setBounds(434, 68, 89, 23);
		frame.getContentPane().add(btnDeductCom);
		

		JButton btnDedcut = new JButton("Remove");
		btnDedcut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int money = Integer.parseInt(deduct.getText());
				
				deductStream.add(money);
				deduct.setText("");
				
				ServerResponseText.append("Removing: "+ money +" from the balance"+"\n");
			}
		});
		btnDedcut.setBounds(316, 68, 89, 23);
		frame.getContentPane().add(btnDedcut);
		

		
		JButton btnSavings = new JButton("Show Balance");
		btnSavings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SavingRequest request = SavingRequest.newBuilder().setViewSaving(true).build();
				
				SavingResponse response = blockingStub.savingsFund(request);
				
				ServerResponseText.append("\n"+"Account balanace is: "+response.getSavingTotal());
				System.out.println("Sever response: "+response.getSavingTotal());
			}
		});
		btnSavings.setBounds(96, 125, 109, 23);
		frame.getContentPane().add(btnSavings);

		JLabel lblEnterAmountTo = new JLabel("Enter amount to Add to account:");
		lblEnterAmountTo.setBounds(42, 15, 163, 14);
		frame.getContentPane().add(lblEnterAmountTo);
		
		JLabel lblEnterAmountTo_2 = new JLabel("Enter amount to remove from account:");
		lblEnterAmountTo_2.setBounds(16, 72, 194, 14);
		frame.getContentPane().add(lblEnterAmountTo_2);
	}

}
