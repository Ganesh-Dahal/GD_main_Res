import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.lang.*;

public class Receipt extends JFrame
{
	JPanel contentPane;
	DefaultListModel<String> dlmPrice = new DefaultListModel();

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Receipt frmReceipt = new Receipt();
					frmReceipt.setVisible(true);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}


	public Receipt()
	{
	//-----------------------------------------------------------------------------------------------------------//
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

		//CLOSE BUTTON
		JLabel lblCloseButton = new JLabel("x");
		lblCloseButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Receipt.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(Color.WHITE);
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);

		//BACK BUTTON
		JPanel pnlBack = new JPanel();
		pnlBack.setBorder(new LineBorder(Color.WHITE));
		pnlBack.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Receipt.this.dispose();
				MainMenu frmMainMenu = new MainMenu();
				frmMainMenu.setVisible(true);
			}
		});
		pnlBack.setLayout(null);
		pnlBack.setBackground(new Color(98, 54, 39));
		pnlBack.setBounds(151, 464, 186, 25);
		contentPane.add(pnlBack);

		JLabel lblBack = new JLabel("BACK TO MAIN MENU");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 13));
		lblBack.setBounds(10, 0, 166, 31);
		pnlBack.add(lblBack);

		//LOGO
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("images\\Alternate Logo.png"));
		lblLogo.setBounds(107, 0, 260, 140);
		contentPane.add(lblLogo);

		//RECEIPT HEADINGS
		JLabel lblHeadings = new JLabel(" ");
		lblHeadings.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadings.setIcon(new ImageIcon("images\\Receipt.png"));
		lblHeadings.setBounds(33, 121, 430, 55);
		contentPane.add(lblHeadings);

	//-----------------------------------------------------------------------------------------------------------//

		//ITEMS
		JPanel pnlItems = new JPanel();
		pnlItems.setBounds(26, 187, 256, 24);
		contentPane.add(pnlItems);
		pnlItems.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlItems.setBackground(new Color(0x7d4b3b));

		JLabel lblItems = new JLabel("Items");
		lblItems.setForeground(Color.WHITE);
		lblItems.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		pnlItems.add(lblItems);

		JList lstItem = new JList(MainProgram.objItem.toArray());
		lstItem.setFont(new Font("Arial", Font.BOLD, 12));
		lstItem.setPreferredSize(new Dimension(250,147));
		lstItem.setBackground(Color.WHITE);
		lstItem.setBounds(26, 210, 256, 172);
		lstItem.setVisible(true);

		//PreMade
		if(MainProgram.objIngredients.size() == 0)
		{
			int intItemsIndex = 0;
			DefaultListModel<String> dlmItems = new DefaultListModel();

			while(intItemsIndex < MainProgram.objItem.size())
			{
				dlmItems.addElement("  " + MainProgram.objItem.get(intItemsIndex) +
										 " (" + MainProgram.objQuantity.get(intItemsIndex) + " Orders)");
				intItemsIndex++;
			}

			JList lstIngredients = new JList(dlmItems);

			lstIngredients.setFont(new Font("Arial", Font.BOLD, 12));
			lstIngredients.setPreferredSize(new Dimension(250,147));
			lstIngredients.setBackground(Color.WHITE);
			lstIngredients.setBounds(26, 210, 256, 172);
			lstIngredients.setVisible(true);

			contentPane.add(lstIngredients);
		}

		//Create Your Own
		else
		{
			int intIndex = 0, intIngredientsIndex = 0, intCounterIndex = 0;
			DefaultListModel<String> dlmIngredient = new DefaultListModel();

			while(intIndex < MainProgram.objCups.size())
			{
				String strOrder = (MainProgram.objCups.get(intIndex).toString().toUpperCase());
				intIndex++;
				dlmIngredient.addElement(strOrder + " (DIY CUP)");

				if(intCounterIndex != 0)
				{
				}
				intCounterIndex++;
			}

			JList lstIngredients = new JList(dlmIngredient);

			lstIngredients.setFont(new Font("Arial", Font.BOLD, 12));
			lstIngredients.setPreferredSize(new Dimension(250,147));
			lstIngredients.setBackground(Color.WHITE);
			lstIngredients.setBounds(26, 210, 256, 172);
			lstIngredients.setVisible(true);

			contentPane.add(lstIngredients);
		}

		//UNIT PRICE
		JPanel pnlUnitPrice = new JPanel();
		pnlUnitPrice.setBackground(new Color(125, 75, 59));
		pnlUnitPrice.setBounds(292, 187, 86, 24);
		contentPane.add(pnlUnitPrice);
		pnlUnitPrice.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setForeground(Color.WHITE);
		lblUnitPrice.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		pnlUnitPrice.add(lblUnitPrice);

		JList lstUnitPrice = new JList(MainProgram.objPrice.toArray());
		lstUnitPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		lstUnitPrice.setBounds(292, 210, 86, 172);

		if(MainProgram.objIngredients.size() == 0)
			contentPane.add(lstUnitPrice);
		else
		{
			int intIndex1 = 0, intIngredientsIndex1 = 0, intCounterIndex1 = 0;


			while(intIndex1 < MainProgram.objCups.size())
			{
				intIndex1++;
				dlmPrice.addElement(" ");

				if(intCounterIndex1 != 0)
				{
				}
				intCounterIndex1++;
			}

			lstUnitPrice = new JList(dlmPrice);
			lstUnitPrice.setFont(new Font("Arial", Font.PLAIN, 12));
			lstUnitPrice.setBounds(292, 210, 86, 172);
			contentPane.add(lstUnitPrice);
		}

		//TOTAL
		JPanel pnlTotal = new JPanel();
		pnlTotal.setBackground(new Color(125, 75, 59));
		pnlTotal.setBounds(388, 187, 86, 24);
		pnlTotal.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(pnlTotal);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		pnlTotal.add(lblTotal);

		JList lstTotal = new JList(MainProgram.objTotal.toArray());
		lstTotal.setFont(new Font("Arial", Font.PLAIN, 12));
		lstTotal.setBounds(388, 210, 86, 170);

		if(MainProgram.objIngredients.size() == 0)
			contentPane.add(lstTotal);
		else
		{


			lstTotal = new JList(dlmPrice);
			lstTotal.setFont(new Font("Arial", Font.PLAIN, 12));
			lstTotal.setBounds(388, 210, 86, 170);
			System.out.print(dlmPrice.size());
			contentPane.add(lstTotal);
		}


		//GRAND TOTAL
		JPanel pnlGrandTotal = new JPanel();
		pnlGrandTotal.setBackground(new Color(125, 75, 59));
		pnlGrandTotal.setBounds(26, 404, 449, 38);
		contentPane.add(pnlGrandTotal);
		pnlGrandTotal.setLayout(null);

		float fltGrandTotal = 0f;

		if(MainProgram.objIngredients.size() == 0)
		{
			for(float i : MainProgram.objTotal)
				fltGrandTotal+= i;
		}

		else
		{
			for(float i : MainProgram.objIngrPrice)
				fltGrandTotal+= i;
		}

		JLabel lblGrandTotal = new JLabel("G R A N D   T O T A L : "+fltGrandTotal);
		lblGrandTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrandTotal.setForeground(Color.WHITE);
		lblGrandTotal.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblGrandTotal.setBounds(0, 11, 439, 25);
		pnlGrandTotal.add(lblGrandTotal);


		setLocationRelativeTo(null);
	}
}
