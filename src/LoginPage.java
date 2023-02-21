import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class LoginPage extends JFrame
{
	JPanel contentPane;
	JTextField txtUsername;
	JPasswordField pwfPassword;
	static String strUsername, strPassword;
	JLabel lblError = new JLabel("Please Enter a Username");

	// Launch the application.
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					LoginPage frmLoginPage = new LoginPage();
					frmLoginPage.setVisible(true);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	// Create the frame.
	public LoginPage()
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
				LoginPage.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(Color.WHITE);
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);

		//LOGO
		JLabel lblLogo = new JLabel(" ");
		lblLogo.setBounds(94, 51, 295, 211);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("images\\Logo.png"));
	//---------------------------------------------------------------------------------------------------------------//

		//USERNAME
		JLabel lblUsername = new JLabel("U S E R N A M E");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblUsername.setBounds(179, 257, 124, 16);
		contentPane.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(119, 284, 251, 31);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		//PASSWORD
		JLabel lblPassword = new JLabel("P A S S W O R D");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblPassword.setBounds(190, 326, 124, 16);
		contentPane.add(lblPassword);

		pwfPassword = new JPasswordField();
		pwfPassword.setBounds(119, 345, 251, 31);
		contentPane.add(pwfPassword);

	//---------------------------------------------------------------------------------------------------------------//

		//LOG IN PANEL BUTTON
		JPanel pnlLogin = new JPanel();
		pnlLogin.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				strUsername = txtUsername.getText();
				strPassword = pwfPassword.getText();

				if(strUsername.isEmpty())
				{
					lblError.setForeground(Color.WHITE);
					lblError.setFont(new Font("Arial", Font.ITALIC, 12));
					lblError.setHorizontalAlignment(SwingConstants.CENTER);
					lblError.setBounds(119, 387, 251, 16);
					contentPane.add(lblError);
				}
				else
				{
					LoginPage.this.dispose();
	            	MainMenu frmMainMenu = new MainMenu();
	            	frmMainMenu.setVisible(true);
				}
	        }
		});

		pnlLogin.setBounds(119, 408, 251, 36);
		pnlLogin.setBackground(new Color(0x623627));
		contentPane.add(pnlLogin);
		pnlLogin.setLayout(null);

		JLabel lblLogin = new JLabel("LOG IN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(89, 11, 81, 25);
		lblLogin.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblLogin.setForeground(Color.WHITE);
		pnlLogin.add(lblLogin);

	//---------------------------------------------------------------------------------------------------------------//

	}
}
