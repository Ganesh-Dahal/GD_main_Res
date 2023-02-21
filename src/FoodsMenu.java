import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class FoodsMenu extends JFrame
{
	private JPanel contentPane;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					FoodsMenu frmDessertMenu = new FoodsMenu();
					frmDessertMenu.setVisible(true);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}


	public FoodsMenu()
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
				FoodsMenu.this.dispose();
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
				FoodsMenu.this.dispose();
				DrinksMenu frmCoffeeMenu = new DrinksMenu();
				frmCoffeeMenu.setVisible(true);
			}
		});
		pnlBack.setLayout(null);
		pnlBack.setBackground(new Color(98, 54, 39));
		pnlBack.setBounds(10, 463, 109, 24);
		contentPane.add(pnlBack);

		JLabel lblBack = new JLabel("<<  BACK");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		lblBack.setBounds(21, 0, 66, 24);
		pnlBack.add(lblBack);

		//NEXT BUTTON
		JPanel pnlNext = new JPanel();
		pnlNext.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				FoodsMenu.this.dispose();
				Receipt frmReceipt = new Receipt();
				frmReceipt.setVisible(true);
			}
		});
		pnlNext.setLayout(null);
		pnlNext.setBackground(new Color(98, 54, 39));
		pnlNext.setBounds(381, 463, 109, 24);
		contentPane.add(pnlNext);

		JLabel lblNext = new JLabel("NEXT >>");
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setForeground(Color.WHITE);
		lblNext.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		lblNext.setBounds(21, 0, 66, 24);
		pnlNext.add(lblNext);

	//---------------------------------------------------------------------------------------------------------------//

		//DESSERT MENU
		JLabel lblDessertMenu = new JLabel("");
		lblDessertMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDessertMenu.setBounds(38, 28, 412, 400);
		lblDessertMenu.setSize(420, 380);
		lblDessertMenu.setIcon(new ImageIcon("images\\Food Menu.png"));
		contentPane.add(lblDessertMenu);

	//---------------------------------------------------------------------------------------------------------------//

		//PLACE AN ORDER
		JPanel pnlOrder = new JPanel();
		pnlOrder.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				FoodsMenu.this.dispose();
				FoodOrder frmDessertOrder= new FoodOrder();
				frmDessertOrder.setVisible(true);
			}
		});

		pnlOrder.setBounds(145, 408, 206, 44);
		pnlOrder.setBackground(new Color(0x7d4b3b));
		contentPane.add(pnlOrder);
		pnlOrder.setLayout(null);

		JLabel lblOrder = new JLabel("Place an Order");
		lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrder.setBounds(28, 11, 146, 25);
		lblOrder.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblOrder.setForeground(Color.WHITE);
		pnlOrder.add(lblOrder);


	//---------------------------------------------------------------------------------------------------------------//
	}

}
