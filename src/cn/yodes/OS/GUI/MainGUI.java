package cn.yodes.OS.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
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
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 614, 402);
	}

}
