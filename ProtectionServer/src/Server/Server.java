package Server;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Server
{
	private static Memory m;
	private JFrame window;
	private JTable table;
	private DefaultTableModel tableModel;
	private int serial;
	private boolean running;
	private API api;
	public Server()
	{
		new FontSetup();
		
		serial = 0;
		running = false;
		
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (Exception ignored)
		{
		}
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rect = ge.getMaximumWindowBounds();
		window = new JFrame("Software Piracy Protection System");
		window.getContentPane().setBackground(new Color(102, 153, 255));
		int sl = rect.width;
		int sb = rect.height;
		int wl = 1000;
		int wb = 700;
		int x = ((sl/2)-(wl/2));
		int y = ((sb/2)-(wb/2));
		window.setBounds(x, y, wl, wb);
		window.setResizable(false);
		window.setIconImage(Toolkit.getDefaultToolkit().getImage(Server.class.getResource("/Images/shield.png")));
		window.getContentPane().setLayout(null);

		Object data[][] = {};
		String col[] = { "Serial No", "MAC Address", "License Key", "Status" };
		table = new JTable();
		tableModel = new DefaultTableModel(data, col)
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		
		table.setModel(tableModel);
		table.setBounds(2, 2, 970, 510);

		JScrollPane sp = new JScrollPane(table);
		sp.setFont(new Font("Alice", Font.PLAIN, 12));
		sp.setBounds(10, 87, 974, 517);
		sp.setBorder(new LineBorder(Color.BLACK, 2, true));
		window.getContentPane().add(sp);
		sp.setVisible(true);

		JButton btnShowDatabase = new JButton("Show Database");
		btnShowDatabase.setFont(new Font("Alice", Font.BOLD, 16));
		btnShowDatabase.setBounds(12, 615, 150, 40);
		window.getContentPane().add(btnShowDatabase);

		btnShowDatabase.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(!running)
				{
					m.sd = new ShowDatabase(m);
				}
			}
		});
		
		JButton btnStartServer = new JButton("Start Server");
		window.getContentPane().setBackground(Color.RED);
		btnStartServer.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (btnStartServer.getText().equals("Start Server"))
				{
					// init goes here
					running = true;
					api = new API(m);
					api.start();
					btnShowDatabase.setEnabled(false);
					btnStartServer.setText("Stop Server");
					window.getContentPane().setBackground(new Color(102, 153, 255));
					window.repaint();
				} else
				{
					running = false;
					btnShowDatabase.setEnabled(true);
					api.stopServer();
					btnStartServer.setText("Start Server");
					window.getContentPane().setBackground(Color.RED);
					window.repaint();
				}
			}
		});
		btnStartServer.setFont(new Font("Alice", Font.BOLD, 22));
		btnStartServer.setBounds(822, 25, 159, 46);
		window.getContentPane().add(btnStartServer);

		JLabel lblProtectionServer = new JLabel("PROTECTION SERVER");
		lblProtectionServer.setFont(new Font("Alice", Font.BOLD, 40));
		lblProtectionServer.setForeground(Color.WHITE);
		lblProtectionServer.setBounds(130, 18, 451, 57);
		window.getContentPane().add(lblProtectionServer);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Server.class.getResource("/Images/servericon.png")));
		label.setBounds(18, 5, 100, 75);
		window.getContentPane().add(label);

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Alice", Font.BOLD, 16));
		btnExit.setBounds(832, 615, 150, 40);
		window.getContentPane().add(btnExit);
		btnExit.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				window.dispose();
			}
		});
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	public void insertTable(String mac, String key, String status)
	{
		serial++;
		Object[] rowData = {serial, mac, key, status};
		tableModel.addRow(rowData);
	}
	public static void main(String args[])
	{
		m = new Memory();
		m.s = new Server();
	}
}