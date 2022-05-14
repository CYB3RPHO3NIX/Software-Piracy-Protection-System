package PiracyShield;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

class FirstPage
{
	private JFrame window;
	private Log log;
	public FirstPage(Memory memory)
	{
		log = memory.log;
		window = memory.window;
		
//		window = new JFrame();
//		window.setTitle("Software Piracy Protection System");
//		window.getContentPane().setBackground(Color.WHITE);
//		window.setResizable(false);
//		window.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Images/shield.png")));
//		window.getContentPane().setLayout(null);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setBounds(420, 50, 700, 500);
//		log = new Log();
//		log.writeLog("Setup Started");
		
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(233, 10, 13, 366);
		window.getContentPane().add(separator);

		JButton CancelBtn = new JButton("Exit");
		CancelBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("Terminate Setup");
				log.destroy();
				window.dispose();
			}
		});
		CancelBtn.setFont(new Font("Alice", Font.BOLD, 16));
		CancelBtn.setBounds(579, 410, 95, 27);
		window.getContentPane().add(CancelBtn);

		JButton btnNext = new JButton("Next >");
		btnNext.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("Goto Next Page");
				window.getContentPane().removeAll();
				window.repaint();
				new SecondPage(memory);
			}
		});
		btnNext.setFont(new Font("Alice", Font.BOLD, 16));
		btnNext.setBounds(474, 410, 95, 27);
		window.getContentPane().add(btnNext);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 397, 664, 13);
		window.getContentPane().add(separator_1);

		JLabel LeftHeader = new JLabel("Piracy Shield");
		LeftHeader.setFont(new Font("Alice", Font.BOLD, 32));
		LeftHeader.setBounds(10, 10, 213, 45);
		window.getContentPane().add(LeftHeader);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FirstPage.class.getResource("/Images/robo.jpg")));
		lblNewLabel.setBounds(10, 65, 213, 311);
		window.getContentPane().add(lblNewLabel);

		JTextPane txtpnWelcomeToThe = new JTextPane();
		txtpnWelcomeToThe.setEditable(false);
		txtpnWelcomeToThe.setFont(new Font("Alice", Font.BOLD, 20));
		txtpnWelcomeToThe.setText("Welcome to the PiracyShield Wizard for \r\nSerial number Validation and Online Activation.");
		txtpnWelcomeToThe.setBounds(256, 31, 418, 77);
		window.getContentPane().add(txtpnWelcomeToThe);

		JTextPane txtpnThePiracyshieldWizard = new JTextPane();
		txtpnThePiracyshieldWizard.setFont(new Font("Alice", Font.PLAIN, 18));
		txtpnThePiracyshieldWizard.setText(
				"The PiracyShield Wizard will Register and Install the Client Software Application on your machine, please make sure that the machine is connected to the internet.\r\n\r\nTo Continue, Click Next");
		txtpnThePiracyshieldWizard.setBounds(256, 120, 403, 242);
		window.getContentPane().add(txtpnThePiracyshieldWizard);

		JButton logButton = new JButton("Log");
		logButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(log.isVisible())
				{
					log.hideLog();
				}
				else
				{
					log.displayLog();
				}
			}
		});
		logButton.setFont(new Font("Alice", Font.BOLD, 16));
		logButton.setBounds(10, 409, 95, 27);
		window.getContentPane().add(logButton);
		window.setVisible(true);
	}
}