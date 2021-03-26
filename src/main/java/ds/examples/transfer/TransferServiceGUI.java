package ds.examples.transfer;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ds.examples.gui.BankingMenuGUI;
import ds.examples.transfer.TransferServiceGrpc.TransferServiceBlockingStub;
import ds.examples.transfer.TransferServiceGrpc.TransferServiceStub;
import ds.examples.view.ViewServiceGrpc.ViewServiceBlockingStub;
import ds.examples.view.ViewServiceGrpc.ViewServiceStub;

import javax.jmdns.ServiceInfo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransferServiceGUI {
	private static TransferServiceBlockingStub blockingStub;
	private static TransferServiceStub asyncStub;
	private ServiceInfo transferServiceInfo;

	private JFrame frame;

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
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubmit1 = new JButton("submit");
		btnSubmit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit1.setBounds(35, 45, 89, 23);
		frame.getContentPane().add(btnSubmit1);
		
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
	}

}
