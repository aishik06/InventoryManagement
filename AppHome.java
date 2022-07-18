import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppHome {

	private JFrame Warehouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppHome window = new AppHome();
					window.Warehouse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Warehouse = new JFrame();
		Warehouse.setTitle("Warehouse");
		Warehouse.setBounds(100, 100, 450, 300);
		Warehouse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Warehouse.getContentPane().setLayout(gridBagLayout);
		
		JButton placeOrder = new JButton("Place Order");
		placeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderHome order = new OrderHome();
				order.getFrame().setVisible(true);
			}
		});
		placeOrder.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_placeOrder = new GridBagConstraints();
		gbc_placeOrder.insets = new Insets(0, 0, 5, 0);
		gbc_placeOrder.gridx = 4;
		gbc_placeOrder.gridy = 1;
		Warehouse.getContentPane().add(placeOrder, gbc_placeOrder);
		
		JButton addToInventory = new JButton("Add to Inventory");
		addToInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InventoryHome product = new InventoryHome();
				product.getFrame().setVisible(true);
			}
		});
		addToInventory.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_addToInventory = new GridBagConstraints();
		gbc_addToInventory.insets = new Insets(0, 0, 5, 0);
		gbc_addToInventory.gridx = 4;
		gbc_addToInventory.gridy = 5;
		Warehouse.getContentPane().add(addToInventory, gbc_addToInventory);
	}

}
