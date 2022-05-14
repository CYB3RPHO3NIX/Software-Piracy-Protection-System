package Server;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

class ShowDatabase
{
	private JFrame window;
	private JTextField textField;
	private DefaultTableModel tableModel;
	private JTable table;
	private Database db;
	private JScrollPane scrollPane;

	public ShowDatabase(Memory m)
	{
		db = new Database();
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
		{}
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rect = ge.getMaximumWindowBounds();
		
		window = new JFrame("License Key Database");
		window.getContentPane().setBackground(new Color(230, 230, 250));
		int sl = rect.width;
		int sb = rect.height;
		int wl = 1000;
		int wb = 700;
		int x = ((sl/2)-(wl/2));
		int y = ((sb/2)-(wb/2));
		window.setBounds(x, y, wl, wb);
		window.setResizable(false);

		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		scrollPane.setBounds(12, 105, 972, 490);
		window.getContentPane().add(scrollPane);

		if (db.getNumberOfRows() != 0)
		{
			init();
		}

		JLabel lblListOfAll = new JLabel("List of all License keys present in the database.");
		lblListOfAll.setFont(new Font("Alice", Font.PLAIN, 22));
		lblListOfAll.setBounds(22, 12, 759, 34);
		window.getContentPane().add(lblListOfAll);

		JButton btnBack = new JButton("BACK");
		btnBack.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				window.dispose();
			}
		});
		btnBack.setFont(new Font("Alice", Font.BOLD, 23));
		btnBack.setBounds(12, 607, 114, 36);
		window.getContentPane().add(btnBack);

		JButton btnAddLicenseKey = new JButton("Add Key");
		btnAddLicenseKey.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				new AddKey(m);
			}
		});
		btnAddLicenseKey.setFont(new Font("Alice", Font.BOLD, 23));
		btnAddLicenseKey.setBounds(632, 607, 170, 36);
		window.getContentPane().add(btnAddLicenseKey);

		JButton btnRemoveLicenseKey = new JButton("Remove Key");
		btnRemoveLicenseKey.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				new RemoveKey(m);
			}
		});
		btnRemoveLicenseKey.setFont(new Font("Alice", Font.BOLD, 23));
		btnRemoveLicenseKey.setBounds(814, 607, 170, 36);
		window.getContentPane().add(btnRemoveLicenseKey);

		textField = new JTextField();
		textField.setFont(new Font("Alice", Font.BOLD, 26));
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textField.setBounds(165, 58, 637, 34);
		textField.addCaretListener(new CaretListener()
		{
			public void caretUpdate(CaretEvent e)
			{
				if (!textField.getText().equals(""))
				{
					searchData(textField.getText());
				}
				if(e.getDot() == 0)
				{
					init();
				}
			}
		});
		window.getContentPane().add(textField);

		JLabel lblSearch = new JLabel("Search String");
		lblSearch.setFont(new Font("Alice", Font.BOLD, 20));
		lblSearch.setBounds(22, 58, 147, 35);
		window.getContentPane().add(lblSearch);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				init();
			}
		});
		btnRefresh.setFont(new Font("Alice", Font.BOLD, 23));
		btnRefresh.setBounds(814, 56, 170, 36);
		window.getContentPane().add(btnRefresh);
		window.setIconImage(Toolkit.getDefaultToolkit().getImage(ShowDatabase.class.getResource("/Images/shield.png")));
		window.setVisible(true);
	}

	public void init()
	{
		Object data[][] = db.fetchAll();
		setupTable(data);
	}

	private void setupTable(Object[][] data)
	{
		if (data != null)
		{
			String col[] =
			{ "Index No", "License Key", "First Name", "Last Name", "Registration Date" };
			table = new JTable();
			tableModel = new DefaultTableModel(data, col)
			{
//				@Override
//				public boolean isCellEditable(int row, int column)
//				{
//					return false;
//				}
			};
			table = new JTable(tableModel);
			scrollPane.setViewportView(table);
		}
	}

	public void searchData(String txt)
	{
		Object[][] data = db.search(txt);
		setupTable(data);
	}
}