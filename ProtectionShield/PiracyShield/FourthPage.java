package PiracyShield;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

class FourthPage
{
	private JTextField fnameField;
	private JTextField lnameField;
	private Log log;
	private JFrame window;
	private String license;
	private Registration reg;
	private Memory m;
	private MacDecrypt md;
	private HashFunction hf;
	private String accessCode;
	private JButton btnNext;
	private JButton btnRegister;
	private MAC mac;
	@SuppressWarnings("deprecation")
	public FourthPage(Memory memory)
	{
		m = memory;
		window = m.window;
		log = m.log;
		license = m.LicenseKey;
		mac = new MAC();
		log = new Log();
		hf = new HashFunction();
		md = new MacDecrypt();
//		JFrame window = new JFrame();
//		window.setTitle("Software Piracy Protection System");
//		window.getContentPane().setBackground(Color.WHITE);
//		window.setResizable(false);
//		window.getContentPane().setLayout(null);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setBounds(420, 50, 700, 500);
		mac.inititalize();
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 88, 664, 8);
		window.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 399, 664, 8);
		window.getContentPane().add(separator_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SecondPage.class.getResource("/Images/shieldIcon.png")));
		lblNewLabel_2.setBounds(594, 10, 80, 70);
		window.getContentPane().add(lblNewLabel_2);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("Terminate Application");
				window.dispose();
			}
		});
		btnCancel.setFont(new Font("Alice", Font.BOLD, 16));
		btnCancel.setBounds(572, 417, 95, 27);
		window.getContentPane().add(btnCancel);

		btnNext = new JButton("Next >");
		btnNext.setEnabled(false);
		btnNext.setVisible(false);
		btnNext.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("Registration successful");
				window.getContentPane().removeAll();
				window.repaint();
				new FifthPage(m);
			}
		});

		btnNext.setFont(new Font("Alice", Font.BOLD, 16));
		btnNext.setBounds(460, 417, 95, 27);
		window.getContentPane().add(btnNext);

		JButton button_1 = new JButton("< Back");
		button_1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("Go back");
				window.getContentPane().removeAll();
				window.repaint();
				new ThirdPage(memory);
			}
		});
		button_1.setFont(new Font("Alice", Font.BOLD, 16));
		button_1.setBounds(348, 417, 95, 27);
		window.getContentPane().add(button_1);

		JLabel lblNewLabel = new JLabel("Product Registration");
		lblNewLabel.setFont(new Font("Alice", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 10, 572, 34);
		window.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter your information to register the product.");
		lblNewLabel_1.setFont(new Font("Alice", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 42, 572, 34);
		window.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setFont(new Font("Alice", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(30, 122, 115, 24);
		window.getContentPane().add(lblNewLabel_3);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Alice", Font.PLAIN, 18));
		lblLastName.setBounds(348, 122, 115, 24);
		window.getContentPane().add(lblLastName);

		fnameField = new JTextField();
		fnameField.setFont(new Font("Orbitron", Font.PLAIN, 18));
		fnameField.setBounds(143, 116, 193, 30);
		window.getContentPane().add(fnameField);
		fnameField.setColumns(10);

		lnameField = new JTextField();
		lnameField.setFont(new Font("Orbitron", Font.PLAIN, 18));
		lnameField.setColumns(10);
		lnameField.setBounds(456, 116, 193, 30);
		window.getContentPane().add(lnameField);

		JLabel lblKey = new JLabel("License Key");
		lblKey.setFont(new Font("Alice", Font.PLAIN, 18));
		lblKey.setBounds(30, 180, 115, 24);
		window.getContentPane().add(lblKey);

		LicenseKey lk = new LicenseKey(license);

		JLabel keylabel = new JLabel("");
		keylabel.setBackground(Color.WHITE);
		keylabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		keylabel.setBounds(143, 180, 506, 26);
		keylabel.setFont(new Font("Orbitron", Font.PLAIN, 18));
		keylabel.setHorizontalAlignment(JLabel.CENTER);
		license = license.toUpperCase();
		keylabel.setText(lk.getKey());
		window.getContentPane().add(keylabel);

		JLabel lblIpAddress = new JLabel("IP Address");
		lblIpAddress.setFont(new Font("Alice", Font.PLAIN, 18));
		lblIpAddress.setBounds(30, 235, 115, 24);
		window.getContentPane().add(lblIpAddress);

		JLabel lblMacAddress = new JLabel("MAC");
		lblMacAddress.setFont(new Font("Alice", Font.PLAIN, 18));
		lblMacAddress.setBounds(30, 286, 115, 24);
		window.getContentPane().add(lblMacAddress);

		JLabel label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label.setBackground(Color.WHITE);
		label.setBounds(143, 233, 506, 26);
		label.setText(mac.getIP());
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Orbitron", Font.PLAIN, 18));
		window.getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(143, 284, 506, 26);
		m.MacAddress = mac.getMAC();
		label_1.setText(mac.getMAC());
		label_1.setHorizontalAlignment(JLabel.CENTER);
		label_1.setFont(new Font("Orbitron", Font.PLAIN, 18));
		window.getContentPane().add(label_1);

		btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("Registration process Started");
				if (checkConnectivity())
				{
					log.writeLog("Connected");
					if (!fnameField.getText().equals("") && !lnameField.getText().equals(""))
					{
						String hash, mac, fname, lname;
						hash = hf.getMd5(license);
						mac = m.MacAddress;
						fname = fnameField.getText();
						lname = lnameField.getText();
						reg = new Registration(hash, mac, fname, lname);
						String code = reg.sendRequest();
						
						if(code.equals("offline"))
						{}
						else if(code.equals("AccessDenied"))
						{
							log.writeLog("Server refused");
							JOptionPane.showMessageDialog(null,
									"Your Product cannot be Registered.\nPossible Reasons:\n1. Fake License Key\n2. Stolen License Key",
									"Registration Unsuccessful", JOptionPane.ERROR_MESSAGE);
						}
						else if (isValidCode(code))
						{
							log.writeLog("Access code is Valid");
							writeCred(license, code);
							// isRegistered = true;
							JOptionPane.showMessageDialog(window, "Product Registration Successful", "Registered",
									JOptionPane.INFORMATION_MESSAGE);
							btnNext.setVisible(true);
							btnNext.setEnabled(true);

						}
					} else
					{
						log.writeLog("Fields are empty");
						JOptionPane.showMessageDialog(window, "Please enter first name and last name", "Empty Fields",
								JOptionPane.ERROR_MESSAGE);
					}
				} else
				{
					log.writeLog("No internet");
					JOptionPane.showMessageDialog(null, "Your computer is not connected to the internet", "No Internet",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRegister.setFont(new Font("Alice", Font.BOLD, 16));
		btnRegister.setBounds(554, 340, 95, 27);
		window.getContentPane().add(btnRegister);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Alice", Font.PLAIN, 18));
		lblDate.setBounds(30, 341, 115, 24);
		window.getContentPane().add(lblDate);

		Date date = new Date();
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Orbitron", Font.PLAIN, 18));
		label_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(143, 339, 376, 26);
		label_2.setText(date.toLocaleString());
		window.getContentPane().add(label_2);

		window.setVisible(true);
	}

	private boolean isValidCode(String enc)
	{
		enc = md.decrypt(enc, license);

		if (m.MacAddress.equals(enc))
		{
			accessCode = enc;
			return true;
		} else
		{
			return false;
		}
	}

	private void writeCred(String license, String code)
	{
		m.credentials = license + "#" + code;
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