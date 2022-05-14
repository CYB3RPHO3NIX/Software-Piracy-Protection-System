package PiracyShield;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

class ThirdPage
{
	private JFrame window;
	private JTextField textField;
	private Log log;
	private boolean isCorrect=false;
	private Memory m;
	private MAC mac;
	public ThirdPage(Memory memory)
	{
		m = memory;
		log = m.log;
		window = m.window;
		mac = new MAC();
//		window = new JFrame();
//		log = new Log();
//		window.setTitle("Software Piracy Protection System");
//		window.getContentPane().setBackground(Color.WHITE);
//		window.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstPage.class.getResource("/Images/shield.png")));
//		window.getContentPane().setLayout(null);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setBounds(420, 50, 700, 500);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 88, 664, 8);
		window.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 399, 664, 8);
		window.getContentPane().add(separator_1);

		JLabel lblNewLabel = new JLabel("License Key Validation");
		lblNewLabel.setFont(new Font("Alice", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 10, 459, 27);
		window.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter your License Key to Register/Activate your product");
		lblNewLabel_1.setFont(new Font("Alice", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 47, 559, 27);
		window.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SecondPage.class.getResource("/Images/shieldIcon.png")));
		lblNewLabel_2.setBounds(594, 10, 80, 70);
		window.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Internet Connectivity :");
		lblNewLabel_3.setFont(new Font("Alice", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(20, 171, 214, 34);
		window.getContentPane().add(lblNewLabel_3);

		JLabel status = new JLabel("");
		status.setFont(new Font("Alice", Font.BOLD, 18));
		status.setBounds(246, 171, 284, 34);
		status.setHorizontalAlignment(JLabel.CENTER);
		status.setBorder(new LineBorder(Color.GRAY, 2 , true));
		window.getContentPane().add(status);

		JButton btnNewButton = new JButton("Check");
		btnNewButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(!mac.getRoutableAddress().equals("null"))
				{
					log.writeLog("Checking Internet Connectivity.");
					status.setText("Internet Connected");
					status.setForeground(Color.GREEN);
					status.repaint();
					log.writeLog("Internet is available.");
				}
				else
				{
					log.writeLog("Internet is not available.");
					status.setText("Internet Disconnected");
					status.setForeground(Color.RED);
					status.repaint();
				}
			}
		});
		btnNewButton.setFont(new Font("Alice", Font.BOLD, 16));
		btnNewButton.setBounds(555, 173, 95, 30);
		window.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_4 = new JLabel("Piracy Shield will install SPPS client Application on your computer");
		lblNewLabel_4.setFont(new Font("Alice", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(20, 106, 622, 27);
		window.getContentPane().add(lblNewLabel_4);

		JLabel lblMakeSureThat = new JLabel("Make sure that your computer is connected to the internet");
		lblMakeSureThat.setFont(new Font("Alice", Font.PLAIN, 18));
		lblMakeSureThat.setBounds(20, 134, 622, 27);
		window.getContentPane().add(lblMakeSureThat);

		JLabel lblLicenseKey = new JLabel("License Key Validation : ");
		lblLicenseKey.setFont(new Font("Alice", Font.PLAIN, 18));
		lblLicenseKey.setBounds(20, 230, 510, 34);
		window.getContentPane().add(lblLicenseKey);
		
		JLabel lstatus = new JLabel("");
		lstatus.setFont(new Font("Alice", Font.BOLD, 16));
		lstatus.setBounds(540, 267, 134, 34);
		window.getContentPane().add(lstatus);
		
		JButton btnNext = new JButton("Next >");
		btnNext.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("");
				if(btnNext.isEnabled())
				{
					if(checkConnectivity())
					{
						if(isCorrect)
						{
							btnNext.setEnabled(true);
							log.writeLog("Goto Fourth Page");
							m.LicenseKey = textField.getText();
							window.getContentPane().removeAll();
							window.repaint();
							new FourthPage(m);
						}
						else
						{
							JOptionPane.showMessageDialog(window, "Please enter a valid license key", "Invalid Key",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(window, "Registration requires internet connection", "No internet",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnNext.setFont(new Font("Alice", Font.BOLD, 16));
		btnNext.setBounds(474, 410, 95, 27);
		btnNext.setEnabled(false);
		window.getContentPane().add(btnNext);
		
		textField = new JTextField();
		textField.addCaretListener(new CaretListener()
		{
			public void caretUpdate(CaretEvent e)
			{
				if(checkLicense())
				{
					log.writeLog("Entered license key is Valid");
					isCorrect = true;
					btnNext.setEnabled(true);
					lstatus.setText("Valid Key");
					lstatus.setForeground(Color.GREEN);
					lstatus.repaint();
				}else
				{
					log.writeLog("Entered license key is not valid");
					isCorrect = false;
					btnNext.setEnabled(false);
					lstatus.setText("Invalid Key");
					lstatus.setForeground(Color.RED);
					lstatus.repaint();
				}
			}
		});
		textField.setBorder(new LineBorder(Color.GRAY, 2 , true));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Alice", Font.PLAIN, 26));
		textField.setBackground(Color.WHITE);
		textField.setBounds(20, 267, 510, 34);
		window.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblPleaseEnterThe = new JLabel("Please enter the correct license key to continue");
		lblPleaseEnterThe.setFont(new Font("Alice", Font.PLAIN, 18));
		lblPleaseEnterThe.setBounds(20, 306, 637, 19);
		window.getContentPane().add(lblPleaseEnterThe);

		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("Terminate Application");
				log.destroy();
				window.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Alice", Font.BOLD, 16));
		btnNewButton_1.setBounds(579, 410, 95, 27);
		window.getContentPane().add(btnNewButton_1);

		

		JButton button_1 = new JButton("< Back");
		button_1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("Back Page");
				window.getContentPane().removeAll();
				window.repaint();
				new SecondPage(m);
			}
		});
		button_1.setFont(new Font("Alice", Font.BOLD, 16));
		button_1.setBounds(369, 410, 95, 27);
		window.getContentPane().add(button_1);
		window.setVisible(true);
	}
	private boolean checkLicense()
	{
		log.writeLog("Checking license key.");
		String text = textField.getText();
		if(text.length() <= 24)
		{
			LicenseKey inputkey = new LicenseKey(text);
			return inputkey.isValid();
		}
		else
		{
			return false;
		}
	}
	private boolean checkConnectivity()
	{
		boolean isConnected = false;
		if(!mac.getRoutableAddress().equals("null"))
		{
			isConnected = true;
		}
		else
		{
			isConnected = false;
		}
		return isConnected;
	}
}