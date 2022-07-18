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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class InventoryHome {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryHome window = new InventoryHome();
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
	public InventoryHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 566, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel productName = new JLabel("Product Name");
		productName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_productName = new GridBagConstraints();
		gbc_productName.insets = new Insets(0, 0, 5, 5);
		gbc_productName.gridx = 1;
		gbc_productName.gridy = 1;
		frame.getContentPane().add(productName, gbc_productName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel productQuantity = new JLabel("Product Quantity");
		productQuantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_productQuantity = new GridBagConstraints();
		gbc_productQuantity.fill = GridBagConstraints.BOTH;
		gbc_productQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_productQuantity.gridx = 1;
		gbc_productQuantity.gridy = 2;
		frame.getContentPane().add(productQuantity, gbc_productQuantity);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton productDoneButton = new JButton("Done");
		productDoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prodName = textField.getText();
				String prodQuantity = textField_1.getText();
				//int prodQuantity = Integer.parseInt(productQuantity.getText());
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "Bubka1997~");
//					PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement("insert into inventory (productName, productQuantity) values (\"?\", ?);");
                    Statement stmt = conn.createStatement();
                    
					String q = "insert into inventory (productName, productQuantity) values (\""+prodName+"\", "+prodQuantity+");";
//					q = "insert into inventory (productName, productQuantity) values(\"shampoo\", 8)";
//					q = "SELECT * FROM inventory";
					System.out.println(q);
					stmt.executeUpdate(q);
					

					
//					st.setString(1, prodName);
//			
//					st.setString(2, prodQuantity);
//					st.executeQuery();
					conn.close();
					
				} catch(SQLException sqlexception) {
					sqlexception.printStackTrace();
				}
				frame.dispose();
			}
		});
		productDoneButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_productDoneButton = new GridBagConstraints();
		gbc_productDoneButton.insets = new Insets(0, 0, 0, 5);
		gbc_productDoneButton.gridx = 2;
		gbc_productDoneButton.gridy = 3;
		frame.getContentPane().add(productDoneButton, gbc_productDoneButton);
	}

}
