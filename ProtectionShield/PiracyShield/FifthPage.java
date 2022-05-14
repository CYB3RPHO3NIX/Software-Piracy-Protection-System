package PiracyShield;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JProgressBar;

class FifthPage
{
	private JFrame window;
	private JTextField textField;
	private JFileChooser filechooser;
	private JProgressBar progressBar;
	private CopyFile cp;
	private Memory m;
	private Log log;
	private String path;
	public FifthPage(Memory memory)
	{
		m = memory;
		log = m.log;
		window = m.window;
		path = "";
		
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		Rectangle rect = ge.getMaximumWindowBounds();
//		try
//		{
//			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//			// UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
//			// UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//			// UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//			// UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//			// UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//			// UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//			// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//			// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//			// UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
//			// UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//			// UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
//		} catch (Exception ignored)
//		{
//		}
//
//		JFrame window = new JFrame();
//		window.setTitle("Software Piracy Protection System");
//		window.getContentPane().setBackground(Color.WHITE);
//		window.setResizable(false);
//		window.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Images/shield.png")));
//		window.getContentPane().setLayout(null);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		int sl = rect.width;
//		int sb = rect.height;
//		int wl = 700;
//		int wb = 500;
//		int x = ((sl / 2) - (wl / 2));
//		int y = ((sb / 2) - (wb / 2));
//		window.setBounds(x, y, wl, wb);

		filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(Color.DARK_GRAY);
		progressBar.setBounds(25, 284, 640, 20);
		progressBar.setValue(0);
		progressBar.setVisible(true);
		window.getContentPane().add(progressBar);
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(15, 88, 664, 8);
		window.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(15, 399, 664, 8);
		window.getContentPane().add(separator_1);

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

		JButton btnNext = new JButton("Install");
		btnNext.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				if(btnNext.getText().equals("Install"))
				{
					log.writeLog("Install");
					if(!path.equals(""))
					{
						log.writeLog("Extracting files");
						try
						{
							extractFiles(path);
							progressBar.setValue(100);
						} catch (Exception e1)
						{
							e1.printStackTrace();
						}
						btnNext.setText("Finish");
						log.writeLog("Extraction Done");
					}
					else
					{
						log.writeLog("Empty Path");
						JOptionPane.showMessageDialog(null, "Please select a destination path", "Path not selected", JOptionPane.ERROR_MESSAGE);
					}	
				}
				else if(btnNext.getText().equals("Finish"))
				{
					window.dispose();
				}
			}
		});
		btnNext.setFont(new Font("Alice", Font.BOLD, 16));
		btnNext.setBounds(460, 417, 95, 27);
		window.getContentPane().add(btnNext);

		JLabel lblNewLabel = new JLabel("Select Destination Location");
		lblNewLabel.setFont(new Font("Alice", Font.BOLD, 24));
		lblNewLabel.setBounds(20, 12, 413, 39);
		window.getContentPane().add(lblNewLabel);

		JLabel lblWhereShouldThe = new JLabel("Where should My Product be installed.");
		lblWhereShouldThe.setFont(new Font("Alice", Font.PLAIN, 16));
		lblWhereShouldThe.setBounds(20, 50, 363, 27);
		window.getContentPane().add(lblWhereShouldThe);

		JLabel lblSetupWillInstall = new JLabel("Setup will install the Product in the Following given Location");
		lblSetupWillInstall.setFont(new Font("Alice", Font.BOLD, 16));
		lblSetupWillInstall.setBounds(25, 108, 537, 27);
		window.getContentPane().add(lblSetupWillInstall);

		JLabel lblToContinueClick = new JLabel(
				"To Continue, click Next, If you would like to select a different folder, click Browse");
		lblToContinueClick.setFont(new Font("Alice", Font.PLAIN, 16));
		lblToContinueClick.setBounds(25, 147, 600, 27);
		window.getContentPane().add(lblToContinueClick);

		textField = new JTextField();
		textField.setBounds(25, 198, 530, 27);
		window.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.writeLog("Browse Triggered");
				int opt = filechooser.showOpenDialog(window);
				if(opt == JFileChooser.APPROVE_OPTION)
				{
					
					File file = filechooser.getSelectedFile();
					path = file.getPath();
					textField.setText(path);
				}
			}
		});
		btnBrowse.setFont(new Font("Alice", Font.BOLD, 16));
		btnBrowse.setBounds(570, 198, 95, 27);
		window.getContentPane().add(btnBrowse);

		JLabel lblAtLeast = new JLabel("At least 2 MB of Free disk space is required.");
		lblAtLeast.setFont(new Font("Alice", Font.PLAIN, 16));
		lblAtLeast.setBounds(25, 360, 600, 27);
		window.getContentPane().add(lblAtLeast);
//		window.setVisible(true);
	}
	public void extractFiles(String path) throws Exception
	{
		cp = new CopyFile();
		
		//Now the Directory is done
		File file1 = new File("TextEditor/JEditor.class");
		File file2 = new File("TextEditor/Data/Constants.class");
		File file3 = new File("TextEditor/Data/Decryption.class");
		File file4 = new File("TextEditor/Data/InitSequence.class");
		File file5 = new File("TextEditor/Data/LicenseKey.class");
		File file6 = new File("TextEditor/Data/MacDecrypt.class");
		//File file7 = new File("TextEditor/Data/Variables.dat");
		File file8 = new File("TextEditor/Data/MAC.class");
		
		File imp1 = new File("Tools/classpath");
		File imp2 = new File("Tools/project");
		File run = new File("Tools/run.sh");
		
		File des;
		des = new File(path+"/Product/");
		des.mkdir();
		des = new File(path+"/Product/TextEditor/");
		des.mkdir();
		des = new File(path+"/Product/.classpath");
		cp.copyFile(imp1, des);
		des = new File(path+"/Product/.project");
		
		cp.copyFile(imp2, des);
		des = new File(path+"/Product/run.sh");
		cp.copyFile(run	, des);
		des = new File(path+"/Product/TextEditor/JEditor.class");
		cp.copyFile(file1, des);
		des = new File(path+"/Product/TextEditor/Data/");
		des.mkdir();
		
		des = new File(path+"/Product/TextEditor/Data/Constants.class");
		cp.copyFile(file2, des);
		des = new File(path+"/Product/TextEditor/Data/Decryption.class");
		cp.copyFile(file3, des);
		des = new File(path+"/Product/TextEditor/Data/InitSequence.class");
		cp.copyFile(file4, des);
		des = new File(path+"/Product/TextEditor/Data/LicenseKey.class");
		cp.copyFile(file5, des);
		des = new File(path+"/Product/TextEditor/Data/MacDecrypt.class");
		cp.copyFile(file6, des);
		//des = new File(path+"/Product/TextEditor/Data/Variables.dat");
		//cp.copyFile(file7, des);
		des = new File(path+"/Product/TextEditor/Data/MAC.class");
		cp.copyFile(file8, des);
		
		writeCred(path, m.credentials);
		
	}
	private boolean writeCred(String path, String code)
	{
		boolean isTrue = false;
		//System.out.println("before Path "+path);
		File file = new File(path+"/Product/TextEditor/Data/Variables.dat");
		FileWriter fw;
		//System.out.println("After Path : "+file.getPath());
		String text = "";
		try
		{
			if (file.createNewFile())
			{
				fw = new FileWriter(file);
				text = code;
				fw.write(text);
				fw.close();
				isTrue = true;
			} else
			{
				fw = new FileWriter(file);
				text = code;
				fw.write(text);
				fw.close();
				isTrue = true;
			}
		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(window, " Exception occured ", "Exception", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			isTrue = false;
		}
		return isTrue;
	}
	public void updateProgress(int value)
	{
		progressBar.setValue(value);
	}
}