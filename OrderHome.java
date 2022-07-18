import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderHome {

	private JFrame frame;
	private JTextField orderText;
	private JTextField orderAmountText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderHome window = new OrderHome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public OrderHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 615, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel orderName = new JLabel("Order Name");
		orderName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_orderName = new GridBagConstraints();
		gbc_orderName.insets = new Insets(0, 0, 5, 5);
		gbc_orderName.anchor = GridBagConstraints.EAST;
		gbc_orderName.gridx = 0;
		gbc_orderName.gridy = 1;
		frame.getContentPane().add(orderName, gbc_orderName);
		
		orderText = new JTextField();
		orderText.setText("Enter order");
		GridBagConstraints gbc_orderText = new GridBagConstraints();
		gbc_orderText.insets = new Insets(0, 0, 5, 0);
		gbc_orderText.fill = GridBagConstraints.HORIZONTAL;
		gbc_orderText.gridx = 2;
		gbc_orderText.gridy = 1;
		frame.getContentPane().add(orderText, gbc_orderText);
		orderText.setColumns(10);
		
		JLabel orderAmount = new JLabel("Order Amount");
		orderAmount.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_orderAmount = new GridBagConstraints();
		gbc_orderAmount.insets = new Insets(0, 0, 5, 5);
		gbc_orderAmount.gridx = 0;
		gbc_orderAmount.gridy = 4;
		frame.getContentPane().add(orderAmount, gbc_orderAmount);
		
		orderAmountText = new JTextField();
		orderAmountText.setText("Enter quantity ");
		GridBagConstraints gbc_orderAmountText = new GridBagConstraints();
		gbc_orderAmountText.insets = new Insets(0, 0, 5, 0);
		gbc_orderAmountText.fill = GridBagConstraints.HORIZONTAL;
		gbc_orderAmountText.gridx = 2;
		gbc_orderAmountText.gridy = 4;
		frame.getContentPane().add(orderAmountText, gbc_orderAmountText);
		orderAmountText.setColumns(10);
		
		JButton orderDoneButton = new JButton("Done");
		orderDoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		orderDoneButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_orderDoneButton = new GridBagConstraints();
		gbc_orderDoneButton.insets = new Insets(0, 0, 0, 5);
		gbc_orderDoneButton.gridx = 1;
		gbc_orderDoneButton.gridy = 9;
		frame.getContentPane().add(orderDoneButton, gbc_orderDoneButton);
	}

}
