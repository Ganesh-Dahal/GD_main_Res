import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class PreMadeOrder extends JFrame
{
	private JPanel contentPane;
	DefaultListModel dlmPreMade;
	JTextField txtQuantity;
	JComboBox<String> cmbPreMade;

    static String[] objPreMade = {"Coca Cola", "Fanta", "Pepsi", "Sprite",
			  "7-Up", "Mountain Dew", "Tumba","Diet Coke", "Diet Pepsi",
			  "Desi Cola", "Diet Pepsi"};

    static Float objPrices[] = {160.00f, 140.00f, 150.00f, 120.00f,
    							145.00f, 130.00f, 160.00f, 125.00f,
    							170.00f, 150.00f, 155.00f, 130.00f,
    							165.00f, 140.00f, 150.00f, 125.00f,
    							150.00f, 135.00f, 155.00f, 130.00f};

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					PreMadeOrder frmPreMadeOrder = new PreMadeOrder();
					frmPreMadeOrder.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public PreMadeOrder()
	{
	//---------------------------------------------------------------------------------------------------------------//
		//CONTENT PANE
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xad7c6d));
		contentPane.setBorder(new LineBorder(new Color(0x623627), 3));
		contentPane.setLayout(null);

		//FRAMES
		setContentPane(contentPane);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setLocationRelativeTo(null);

		//CLOSE BUTTON
		JLabel lblCloseButton = new JLabel("x");
		lblCloseButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				PreMadeOrder.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(Color.WHITE);
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);

		//BACK BUTTON
		JPanel pnlBack = new JPanel();
		pnlBack.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				PreMadeOrder.this.dispose();
				MainMenu frmMainMenu = new MainMenu();
				frmMainMenu.setVisible(true);
			}
		});
		pnlBack.setLayout(null);
		pnlBack.setBackground(new Color(98, 54, 39));
		pnlBack.setBounds(10, 463, 109, 24);
		contentPane.add(pnlBack);

		JLabel lblBack = new JLabel("<<  BACK TO MENU");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		lblBack.setBounds(21, 0, 66, 24);
		pnlBack.add(lblBack);

		//LOGO
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("Images\\Alternate Logo.png"));
		lblLogo.setBounds(107, 11, 260, 140);
		contentPane.add(lblLogo);

		//HEADINGS
		JLabel lblHeadings = new JLabel(" ");
		lblHeadings.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadings.setIcon(new ImageIcon("Images\\Orders.png"));
		lblHeadings.setBounds(34, 119, 430, 80);
		contentPane.add(lblHeadings);

	//---------------------------------------------------------------------------------------------------------------//

		//SELECT PREMADE
		JLabel lblSelectPreMade = new JLabel("Select a Drink");
		lblSelectPreMade.setForeground(Color.WHITE);
		lblSelectPreMade.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectPreMade.setFont(new Font("Arial", Font.BOLD, 12));
		lblSelectPreMade.setBounds(10, 197, 235, 31);
		contentPane.add(lblSelectPreMade);

		//COMBOBOX PREMADE
		DefaultComboBoxModel<String> cmbModel = new DefaultComboBoxModel<String>(objPreMade);
		cmbPreMade = new JComboBox<String> (cmbModel);
		cmbPreMade.setForeground(Color.WHITE);
		cmbPreMade.setToolTipText("");
		cmbPreMade.setMaximumRowCount(12);
		cmbPreMade.setBackground(new Color(0x8f6050));
		cmbPreMade.setBounds(32, 224, 183, 38);
		contentPane.add(cmbPreMade);

	//---------------------------------------------------------------------------------------------------------------//

		//ENTER QUANTITY
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Arial", Font.BOLD, 12));
		lblQuantity.setBounds(89, 273, 59, 21);
		contentPane.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setBounds(30, 295, 185, 45);
		contentPane.add(txtQuantity);

	//---------------------------------------------------------------------------------------------------------------//

		//LIST OF PREMADE ORDERS
		dlmPreMade = new DefaultListModel();
		JList lstList = new JList(dlmPreMade);
		lstList.setPreferredSize(new Dimension(250,147));
		lstList.setBackground(Color.WHITE);
		lstList.setBounds(237, 224, 227, 116);
		lstList.setVisible(true);
		contentPane.add(lstList);

		JLabel lblListofPreMade = new JLabel("List of Drinks Orders");
		lblListofPreMade.setHorizontalAlignment(SwingConstants.CENTER);
		lblListofPreMade.setForeground(Color.WHITE);
		lblListofPreMade.setFont(new Font("Arial", Font.BOLD, 12));
		lblListofPreMade.setBounds(270, 197, 167, 31);
		contentPane.add(lblListofPreMade);

	//---------------------------------------------------------------------------------------------------------------//

		//ADD CUPS
		JPanel pnlAddPreMade = new JPanel();

		pnlAddPreMade.setLayout(null);
		pnlAddPreMade.setBackground(new Color(0x7d4b3b));
		pnlAddPreMade.setBounds(30, 376, 185, 36);
		pnlAddPreMade.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(txtQuantity.toString().isEmpty())
				{

					JLabel lblError = new JLabel("Please enter amount");
				}
            	else
				{
					int intIndex = cmbPreMade.getSelectedIndex();
					int intAmount = Integer.parseInt(txtQuantity.getText());
					Float fltPrice = objPrices[intIndex];
					Float fltTotal = fltPrice * intAmount;
					JLabel lblError = new JLabel();
					lblError.setText("");

					dlmPreMade.addElement(objPreMade[intIndex] + " (" + intAmount + " orders) = NRP " + fltTotal + "0");

					MainProgram.objItem.add(objPreMade[intIndex]);
					MainProgram.objQuantity.add(Integer.parseInt(txtQuantity.getText()));
					MainProgram.objPrice.add(objPrices[intIndex]);
					MainProgram.objTotal.add(fltTotal);
				}
			}
		});
		contentPane.add(pnlAddPreMade);

		JLabel lblAddPreMade = new JLabel("Add Drink");
		lblAddPreMade.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddPreMade.setForeground(Color.WHITE);
		lblAddPreMade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddPreMade.setBounds(21, 11, 143, 14);
		pnlAddPreMade.add(lblAddPreMade);

	//---------------------------------------------------------------------------------------------------------------//
		//PLACE ORDER
		JPanel pnlPlaceOrder = new JPanel();
		pnlPlaceOrder.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				PreMadeOrder.this.dispose();
				Receipt frmReceipt = new Receipt();
				frmReceipt.setVisible(true);
	        }
		});

		pnlPlaceOrder.setBounds(237, 376, 227, 36);
		pnlPlaceOrder.setBackground(new Color(0x7d4b3b));
		contentPane.add(pnlPlaceOrder);
		pnlPlaceOrder.setLayout(null);

		JLabel lblPlaceOrder = new JLabel("Place Order");
		lblPlaceOrder.setBounds(20, 11, 185, 14);
		pnlPlaceOrder.add(lblPlaceOrder);
		lblPlaceOrder.setForeground(Color.WHITE);
		lblPlaceOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlaceOrder.setHorizontalAlignment(SwingConstants.CENTER);


	}

}
