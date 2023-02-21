import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class MainMenu extends JFrame
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
					MainMenu frmMainMenu = new MainMenu();
					frmMainMenu.setVisible(true);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}


	public MainMenu()
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
				MainMenu.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(Color.WHITE);
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);

		//LOGO
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("images\\Alternate Logo.png"));
		lblLogo.setBounds(107, 11, 260, 140);
		contentPane.add(lblLogo);

		//HEADINGS
		JLabel lblWelcome = new JLabel("Hey, " + LoginPage.strUsername  +" Welcome!" );
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("-------", Font.PLAIN, 26));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(0, 162, 500, 36);
		contentPane.add(lblWelcome);

	//---------------------------------------------------------------------------------------------------------------//
		//COFFEE MENU
		JPanel pnlCoffeeMenu = new JPanel();
		pnlCoffeeMenu.setBorder(new LineBorder(new Color(0x7d4b3b)));
		pnlCoffeeMenu.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				MainMenu.this.dispose();
				DrinksMenu frmCoffeeMenu = new DrinksMenu();
	            frmCoffeeMenu.setVisible(true);
	        }
		});

		pnlCoffeeMenu.setBounds(116, 229, 251, 69);
		pnlCoffeeMenu.setBackground(new Color(0x8f6050));
		contentPane.add(pnlCoffeeMenu);
		pnlCoffeeMenu.setLayout(null);

		JLabel lblCoffeeMenu = new JLabel("Drinks Menu");
		lblCoffeeMenu.setBounds(23, 0, 206, 80);
		pnlCoffeeMenu.add(lblCoffeeMenu);
		lblCoffeeMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoffeeMenu.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		lblCoffeeMenu.setForeground(Color.WHITE);

		//DESSERTS MENU
		JPanel pnlDessertMenu = new JPanel();
		pnlDessertMenu.setLayout(null);
		pnlDessertMenu.setBorder(new LineBorder(new Color(0x7d4b3b)));
		pnlDessertMenu.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				MainMenu.this.dispose();
				FoodsMenu frmDessertMenu = new FoodsMenu();
	            frmDessertMenu.setVisible(true);
	        }
		});
		pnlDessertMenu.setBackground(new Color(143, 96, 80));
		pnlDessertMenu.setBounds(116, 318, 251, 69);
		contentPane.add(pnlDessertMenu);

		JLabel lblDessertMenu = new JLabel("Foods Menu");
		lblDessertMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDessertMenu.setForeground(Color.WHITE);
		lblDessertMenu.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		lblDessertMenu.setBounds(23, 0, 206, 80);
		pnlDessertMenu.add(lblDessertMenu);

	//---------------------------------------------------------------------------------------------------------------//

	}

}
