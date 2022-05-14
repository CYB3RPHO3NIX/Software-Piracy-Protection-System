package PiracyShield;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

class Registration
{
	private String hash;
	private String mac;
	private String fname;
	private String lname;
	private DataOutputStream output;
	private DataInputStream input;
	public Registration(String h, String m, String f, String l)
	{
		DataOutputStream output = null;
		DataInputStream input = null;
		hash = h;
		mac = m;
		fname = f;
		lname = l;
	}
	public String sendRequest()
	{
		String reply="";
		String msg = hash+"@"+mac+"@"+fname+"@"+lname;
		try
		{
			Socket s = new Socket("127.0.0.1", 6464);
			output = new DataOutputStream(s.getOutputStream());
			input = new DataInputStream(s.getInputStream());
			output.writeUTF(msg);
			reply = input.readUTF();
			s.close();
		} catch (ConnectException e)
		{
			JOptionPane.showMessageDialog(null, "Server is Offline", "Offline Server", JOptionPane.ERROR_MESSAGE);
			reply = "offline";
		}
		catch(UnknownHostException ue)
		{
			JOptionPane.showMessageDialog(null, "Unable to reach the destination", "Unknown Host", JOptionPane.ERROR_MESSAGE);
			reply = "offline";
		}
		catch(IOException ioe)
		{
			JOptionPane.showMessageDialog(null, "Data Input/Output Stream error", "Input/Output Error", JOptionPane.ERROR_MESSAGE);
			reply = "offline";
		}
		return reply;
	}

}