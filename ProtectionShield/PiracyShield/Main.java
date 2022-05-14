package PiracyShield;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.*;

class Main
{
	public static void main(String args[])
	{
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
		
		new FontSetup();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rect = ge.getMaximumWindowBounds();
		
		JFrame window = new JFrame();
		window.setTitle("Software Piracy Protection System");
		window.getContentPane().setBackground(Color.WHITE);
		window.setResizable(false);
		window.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Images/shield.png")));
		window.getContentPane().setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int sl = rect.width;
		int sb = rect.height;
		int wl = 700;
		int wb = 500;
		int x = ((sl/2)-(wl/2));
		int y = ((sb/2)-(wb/2));
		window.setBounds(x, y, wl, wb);
		Log log = new Log();
		log.writeLog("Setup Started");
			
		Memory m = new Memory();
		m.window = window;
		m.log = log;

		new FirstPage(m);
	}
}