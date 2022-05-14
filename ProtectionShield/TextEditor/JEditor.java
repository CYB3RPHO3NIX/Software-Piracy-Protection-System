package TextEditor;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.GraphicsEnvironment;
import javax.swing.border.SoftBevelBorder;
import TextEditor.Data.InitSequence;
import java.awt.Font;

public class JEditor
{
	private JFrame window;

	/**
	 * @wbp.parser.entryPoint
	 */
	public JEditor()
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rect = ge.getMaximumWindowBounds();
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

		window = new JFrame("JEditor");
		window.setFont(new Font("Alice", Font.PLAIN, 16));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		window.setResizable(false);
		int sl = rect.width;
		int sb = rect.height;
		int wl = 1024;
		int wb = 720;
		int x = ((sl / 2) - (wl / 2));
		int y = ((sb / 2) - (wb / 2));
		window.setBounds(x, y, wl, wb);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 630, 1024, 30);
		window.getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 0, 1000, 623);
		window.getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Alice", Font.PLAIN, 15));
		scrollPane.setViewportView(textArea);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Alice", Font.BOLD, 16));
		window.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Alice", Font.BOLD, 16));
		menuBar.add(mnFile);

		JMenuItem mntmNewFile = new JMenuItem("New File");
		mntmNewFile.setFont(new Font("Alice", Font.PLAIN, 16));
		mnFile.add(mntmNewFile);

		JMenuItem mntmOpenFile = new JMenuItem("Open File");
		mntmOpenFile.setFont(new Font("Alice", Font.PLAIN, 16));
		mnFile.add(mntmOpenFile);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setFont(new Font("Alice", Font.PLAIN, 16));
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.setFont(new Font("Alice", Font.PLAIN, 16));
		mnFile.add(mntmSaveAs);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Alice", Font.PLAIN, 16));
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Alice", Font.BOLD, 16));
		menuBar.add(mnEdit);

		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.setFont(new Font("Alice", Font.PLAIN, 16));
		mnEdit.add(mntmCut);

		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setFont(new Font("Alice", Font.PLAIN, 16));
		mnEdit.add(mntmCopy);

		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.setFont(new Font("Alice", Font.PLAIN, 16));
		mnEdit.add(mntmPaste);

		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.setFont(new Font("Alice", Font.PLAIN, 16));
		mnEdit.add(mntmUndo);

		JMenuItem mntmRedo = new JMenuItem("Redo");
		mntmRedo.setFont(new Font("Alice", Font.PLAIN, 16));
		mnEdit.add(mntmRedo);

		JMenuItem mntmFind = new JMenuItem("Find");
		mntmFind.setFont(new Font("Alice", Font.PLAIN, 16));
		mnEdit.add(mntmFind);

		JMenuItem mntmFindreplace = new JMenuItem("Find/Replace");
		mntmFindreplace.setFont(new Font("Alice", Font.PLAIN, 16));
		mnEdit.add(mntmFindreplace);

		JMenu mnView = new JMenu("View");
		mnView.setFont(new Font("Alice", Font.BOLD, 16));
		menuBar.add(mnView);

		JMenuItem mntmFont = new JMenuItem("Font");
		mntmFont.setFont(new Font("Alice", Font.PLAIN, 16));
		mnView.add(mntmFont);

		JMenuItem mntmThemes = new JMenuItem("Themes");
		mntmThemes.setFont(new Font("Alice", Font.PLAIN, 16));
		mnView.add(mntmThemes);

		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.setFont(new Font("Alice", Font.PLAIN, 16));
		mnView.add(mntmSettings);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Alice", Font.BOLD, 16));
		menuBar.add(mnHelp);

		JMenuItem mntmHelpContents = new JMenuItem("Help Contents");
		mntmHelpContents.setFont(new Font("Alice", Font.PLAIN, 16));
		mnHelp.add(mntmHelpContents);

		JMenuItem mntmRegistration = new JMenuItem("Registration");
		mntmRegistration.setFont(new Font("Alice", Font.PLAIN, 16));
		mnHelp.add(mntmRegistration);

		JMenuItem mntmAboutJeditor = new JMenuItem("About JEditor");
		mntmAboutJeditor.setFont(new Font("Alice", Font.PLAIN, 16));
		mnHelp.add(mntmAboutJeditor);
		window.setVisible(true);
	}

	public static void main(String args[])
	{
		InitSequence is = new InitSequence();
		if (is.authentication())
		{
			is.window.dispose();
			new JEditor();
		}
		else
		{
			is.window.dispose();
		}
	}
}