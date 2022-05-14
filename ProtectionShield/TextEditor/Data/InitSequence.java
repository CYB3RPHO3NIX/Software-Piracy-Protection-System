package TextEditor.Data;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public class InitSequence extends JPanel
{
	public JFrame window;
	private JProgressBar bar;
	private String license;
	private String code;
	private int value = 0;
	private MAC mac;
	private MacDecrypt md;
	public InitSequence()
	{
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rect = ge.getMaximumWindowBounds();
		window = new JFrame();
		window.setUndecorated(true);
		window.getContentPane().setLayout(null);
		window.getContentPane().add(this);
		window.getContentPane().setBackground(Color.BLACK);
		
		mac = new MAC();
		md = new MacDecrypt();
		
		bar = new JProgressBar();
		bar.setBounds(150, 380, 400, 15);
		bar.setForeground(new Color(0 , 191, 254));
		bar.setBackground(Color.WHITE);
		bar.setValue(0);
		
		super.setBackground(Color.BLACK);
		super.setLayout(null);
		super.setBounds(0, 0, 600, 490);
		super.add(bar);
		
		int sl = rect.width;
		int sb = rect.height;
		int wl = 600;
		int wb = 500;
		int x = ((sl/2)-(wl/2));
		int y = ((sb/2)-(wb/2));
		window.setBounds(x, y, wl, wb);
		
		JLabel lb1 = new JLabel();
		lb1.setText("Powered by Protection Shield");
		lb1.setBounds(25, 420, 500, 35);
		lb1.setForeground(new Color(0 , 191, 254));
		lb1.setFont(new Font("Alice", Font.PLAIN, 35));
		super.add(lb1);
		
		JLabel lb2 = new JLabel();
		lb2.setText("by Software Piracy Protection Solutions");
		lb2.setBounds(25, 460, 500, 25);
		lb2.setForeground(new Color(0 , 191, 254));
		lb2.setFont(new Font("Alice", Font.PLAIN, 25));
		super.add(lb2);
		
		JLabel lb3 = new JLabel();
		lb3.setText("JEditor");
		lb3.setBounds(20, 125, 500, 45);
		lb3.setForeground(Color.WHITE);
		lb3.setFont(new Font("Orbitron", Font.BOLD, 45));
		super.add(lb3);
		
		JLabel lb4 = new JLabel();
		lb4.setText("A Simple and Stable Text Editor.");
		lb4.setBounds(20, 250, 500, 30);
		lb4.setForeground(Color.WHITE);
		lb4.setFont(new Font("Orbitron", Font.BOLD, 25));
		super.add(lb4);
		
		JLabel lb5 = new JLabel();
		lb5.setText("Loading");
		lb5.setBounds(30, 380, 200, 20);
		lb5.setForeground(Color.WHITE);
		lb5.setFont(new Font("Orbitron", Font.BOLD, 20));
		super.add(lb5);
		
		window.setVisible(true);
	}
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(0 , 191, 254));
		for(int i = 0 ; i < 600 ; i=i+10)
		{
			if(350 <= i && i <= 390)
			{
				continue;
			}
			if(470 <= i && i <= 500)
			{
				continue;
			}
			g.drawRect(0, 0, i, i-230);
		}
		int x1= 230,y2=370;
		g.setColor(Color.BLACK);
		for(int i = 0 ; i < 200 ; i++)
		{
			g.drawLine(x1, 0, 600, y2);
			x1=x1+5;
			y2=y2-5;
		}
	} 
	public void incrementProgress()
	{
		try
		{
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		value = value+5;
		bar.setValue(value);
	}
	public boolean readData()
	{
		incrementProgress();//progress 1
		boolean isFine = false;
		incrementProgress();//progress 2
		File file = new File("TextEditor/Data/Variables.dat");//for real
		//File file = new File("TextEditor/Data/Variables.dat");//for testing
		incrementProgress();//progress 3
		try
		{
			incrementProgress();//progress 4
			
			FileReader fr = new FileReader(file);
			incrementProgress();//progress 5
			
			char key[] = new char[38];
			incrementProgress();//progress 6
			
			fr.read(key);
			incrementProgress();//progress 7
			
			String rec = new String(key);
			incrementProgress();//progress 8
			
			String var[] = rec.split("#");
			incrementProgress();//progress 9
			
			license = var[0];
			incrementProgress();//progress 10
			
			code = var[1];
			incrementProgress();//progress 11
			
			isFine = true;
			incrementProgress();//progress 12
			
		} catch (Exception e)
		{
			e.printStackTrace();
			isFine = false;
		}
		incrementProgress();//progress 13
		return isFine;
	}
	public boolean authentication()
	{
		incrementProgress();//progress 14
		readData();
		incrementProgress();//progress 15
		String regMac = md.decrypt(code, license);
		incrementProgress();//progress 16
		String genMac = mac.getMAC();
		incrementProgress();//progress 17
		
		if(regMac.equals(genMac))
		{
			incrementProgress();//progress 18
			incrementProgress();//progress 19
			incrementProgress();//progress 20
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(window, "Invalid Product Key", "Authentication failed", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}