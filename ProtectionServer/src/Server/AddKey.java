package Server;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


class AddKey
{
	private JFrame window;
	private JTextField textField;
	private KeyGenerator keygen;
	private HashFunction h;
	private Database db;
	private String key;

	public AddKey(Memory m)
	{
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception ignored)
		{
		}
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rect = ge.getMaximumWindowBounds();
		
		window = new JFrame("Add License Key");
		window.setIconImage(Toolkit.getDefaultToolkit().getImage(ShowDatabase.class.getResource("/Images/shield.png")));
		int sl = rect.width;
		int sb = rect.height;
		int wl = 500;
		int wb = 300;
		int x = ((sl/2)-(wl/2));
		int y = ((sb/2)-(wb/2));
		window.setBounds(x, y, wl, wb);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setResizable(false);
		window.getContentPane().setLayout(null);

		JLabel status = new JLabel("");
		status.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setFont(new Font("Alice", Font.BOLD, 24));
		status.setBounds(132, 173, 235, 38);
		window.getContentPane().add(status);

		JLabel lblInsertANew = new JLabel("Insert a New License Key into the Database");
		lblInsertANew.setFont(new Font("Alice", Font.PLAIN, 20));
		lblInsertANew.setBounds(47, 24, 405, 22);
		window.getContentPane().add(lblInsertANew);

		keygen = new KeyGenerator();
		h = new HashFunction();
		db = new Database();

		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setFont(new Font("Alice", Font.BOLD, 20));
		textField.setBounds(47, 65, 405, 30);
		window.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnGenerateKey = new JButton("Generate Key");
		btnGenerateKey.setFont(new Font("Alice", Font.BOLD, 20));
		btnGenerateKey.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				key = keygen.getKey().toUpperCase();
				textField.setText(keygen.getFormattedKey(key).toUpperCase());
			}
		});
		btnGenerateKey.setBounds(47, 118, 164, 38);
		window.getContentPane().add(btnGenerateKey);

		JButton btnInsert = new JButton("Add");
		btnInsert.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String hash = h.getMd5(key);
				if (db.insertKey(key, hash))
				{
					Random r = new Random();
					status.setForeground(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
					status.setText("Successful");
					m.sd.init();
				} else
				{
					status.setForeground(Color.RED);
					status.setText("Unsuccessful");
				}
			}
		});
		btnInsert.setFont(new Font("Alice", Font.BOLD, 20));
		btnInsert.setBounds(288, 118, 164, 38);
		window.getContentPane().add(btnInsert);

		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				m.sd.init();
				window.dispose();
			}
		});
		btnExit.setFont(new Font("Alice", Font.BOLD, 20));
		btnExit.setBounds(200, 223, 100, 38);
		window.getContentPane().add(btnExit);

		window.setVisible(true);
	}
}