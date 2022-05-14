package Server;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

class RemoveKey
{
	private JFrame window;
	private Database db;
	private JComboBox comboBox;
	private KeyGenerator keygen;

	public RemoveKey(Memory m)
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
		window.getContentPane().setForeground(Color.BLACK);
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

		db = new Database();
		keygen = new KeyGenerator();

		JLabel label = new JLabel("");
		label.setFont(new Font("Alice", Font.BOLD, 20));
		label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label.setBounds(35, 106, 430, 35);
		label.setHorizontalAlignment(JLabel.CENTER);
		window.getContentPane().add(label);

		JLabel lblSelectTheLicense = new JLabel("Select the License Key to remove from the Database");
		lblSelectTheLicense.setFont(new Font("Alice", Font.PLAIN, 20));
		lblSelectTheLicense.setBounds(12, 12, 476, 35);
		window.getContentPane().add(lblSelectTheLicense);

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent arg0)
			{
				if (arg0.getStateChange() == ItemEvent.SELECTED)
				{
					String index = comboBox.getSelectedItem().toString();
					index = db.getKeyOfIndex(index);
					label.setText(keygen.getFormattedKey(index));
				}
			}
		});
		comboBox.setEditable(true);
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Alice", Font.BOLD, 17));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		comboBox.setBounds(375, 59, 90, 35);
		window.getContentPane().add(comboBox);

		init();// to initialize and load items in the ComboBox.

		JLabel status = new JLabel("");
		status.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		status.setBounds(35, 200, 281, 35);
		status.setHorizontalAlignment(JLabel.CENTER);
		status.setFont(new Font("Alice", Font.BOLD, 20));
		window.getContentPane().add(status);

		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (comboBox.getSelectedIndex() >= 0)
				{
					if (removeRow())
					{
						status.setForeground(Color.GREEN);
						status.setText("Key Removed");
						status.repaint();
						init();
						m.sd.init();
					} else
					{
						status.setForeground(Color.RED);
						status.setText("Operation Unsuccessful");
						status.repaint();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Alice", Font.BOLD, 16));
		btnNewButton.setBounds(199, 153, 114, 35);
		window.getContentPane().add(btnNewButton);

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
		btnExit.setFont(new Font("Alice", Font.BOLD, 16));
		btnExit.setBounds(351, 200, 114, 35);
		window.getContentPane().add(btnExit);

		JLabel lblSelectTheIndex = new JLabel("Select the index of the license key.");
		lblSelectTheIndex.setFont(new Font("Alice", Font.PLAIN, 18));
		lblSelectTheIndex.setBounds(35, 59, 331, 35);
		window.getContentPane().add(lblSelectTheIndex);
		window.setVisible(true);
	}

	public void init()
	{
		comboBox.removeAllItems();
		int[] k = null;
		k = sort(db.getAllIndex());
		for (int i = 0; i < k.length; i++)
		{
			comboBox.addItem(k[i]);
		}
	}
	public int[] sort(int arr[])
	{
		int temp;
		for(int i = 0 ; i < arr.length-1 ; i++)
		{
			for(int j = i+1 ; j < arr.length ; j++)
			{
				if(arr[i] > arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	public boolean removeRow()
	{
		String text = comboBox.getSelectedItem().toString();
		if (db.removeRow(text))
		{
			return true;
		} else
		{
			return false;
		}
	}

}