package ds.examples.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;


import ds.examples.history.HistoryServiceGUI;
import ds.examples.transfer.TransferServiceGUI;
import ds.examples.view.ViewServiceGUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankingMenuGUI {

	private JFrame frame;

	//launch
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankingMenuGUI window = new BankingMenuGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//create
	public BankingMenuGUI() {
		initialize();
	}

	
	//set pramas
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnViewAccountService = new JButton("View Details");
		btnViewAccountService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   frame.dispose();
			   ViewServiceGUI viewgui = new ViewServiceGUI();
			   viewgui.main(null);
			}
		});
		btnViewAccountService.setBounds(20, 67, 135, 61);
		frame.getContentPane().add(btnViewAccountService);
		
		JButton btnTransferService = new JButton("Transfer Funds");
		btnTransferService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			    TransferServiceGUI transfergui = new TransferServiceGUI();
			    transfergui.main(null);
			}
		});
		btnTransferService.setBounds(190, 67, 135, 61);
		frame.getContentPane().add(btnTransferService);
		
		JButton btnHistoryService = new JButton("Spending History");
		btnHistoryService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			    HistoryServiceGUI historygui = new HistoryServiceGUI();
			    historygui.main(null);
			}
		});
		btnHistoryService.setBounds(360, 67, 135, 61);
		frame.getContentPane().add(btnHistoryService);
	}
}
