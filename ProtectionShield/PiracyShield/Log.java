package PiracyShield;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.time.LocalDate;
import java.io.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

class Log
{
	private JFrame window;
	private JTextPane textPane;
	private Date d;

	public Log()
	{
		window = new JFrame();
		window.setResizable(false);
		window.setAlwaysOnTop(true);
		window.setResizable(false);
		window.setBounds(420, 544, 700, 250);
		window.getContentPane().setLayout(null);
		d = new Date();
		
		try { 
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel"); 
	        //UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel"); 
	        //UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
	    } catch(Exception ignored){}
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 675, 160);
		window.getContentPane().add(scrollPane);

		textPane = new JTextPane();
		textPane.setFont(new Font("Georgia", Font.PLAIN, 18));
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setForeground(Color.WHITE);
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);

		JButton btnNewButton = new JButton("Close");
		btnNewButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				window.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(588, 181, 95, 32);
		window.getContentPane().add(btnNewButton);

		JButton btnSaveLogs = new JButton("Save Logs");
		btnSaveLogs.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent me)
			{
				
				String time = LocalDate.now().toString();
				String filename = "src/Logs/"+time+".txt";
				try
				{
					File file = new File(filename);
					FileWriter f = new FileWriter(file);
					f.write(textPane.getText());
					f.close();
				} catch (IOException e)
				{
					System.out.println("Problem while writing into file.");
					e.printStackTrace();
				}
			}
		});
		btnSaveLogs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSaveLogs.setBounds(10, 179, 136, 32);
		window.getContentPane().add(btnSaveLogs);
		//window.setVisible(true);
	}
	public void displayLog()
	{
		window.setVisible(true);
	}
	public void hideLog()
	{
		window.setVisible(false);
	}
	public boolean isVisible()
	{
		return window.isVisible();
	}
	public void destroy()
	{
		window.dispose();
	}
	public void writeLog(String text)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
	    Date date = new Date();
		String time = formatter.format(date).toString();
		text = textPane.getText() + "\n" + time + " : " + text;
		textPane.setText(text);
		window.repaint();
	}
}