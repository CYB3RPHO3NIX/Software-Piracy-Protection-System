package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

class RequestHandler extends Thread
{
	private Database db;
	private AccessCode ac;
	private DataInputStream input;
	private DataOutputStream output;
	private Socket socket;
	private String md5;
	private String mac;
	private String fname;
	private String lname;
	private Date date;
	private Memory memory;

	public RequestHandler(Socket s, Memory m)
	{
		memory = m;
		date = new Date();
		db = new Database();
		ac = new AccessCode();
		socket = s;
		try
		{
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		getRequest();
	}

	@SuppressWarnings("deprecation")
	public void getRequest()
	{
		String reply = "";
		try
		{
			String key = "";
			String text = input.readUTF();
			String arr[] = text.split("@");

			md5 = arr[0];
			mac = arr[1];
			fname = arr[2];
			lname = arr[3];

			if (db.isKeyPresent(md5))
			{
				key = db.getKey(md5);
				if (!db.isMacAssociated(md5))
				{
					if (db.updateCredentials(key, mac, fname, lname, date.toGMTString()))
					{
						reply = ac.getAccessCode(key, mac);
						memory.s.insertTable(mac, key, "Genuine/Registered");
						output.writeUTF(reply);
					}
				}
				else if (db.isMacAssociated(md5))
				{
					if (db.isSameMac(mac, md5))
					{
						if (db.updateCred(key, fname, lname))
						{
							reply = ac.getAccessCode(key, mac);
							memory.s.insertTable(mac, key, "Genuine/Updated");
							output.writeUTF(reply);
						}

					} else
					{
						reply = ac.getAccessCode(key, mac);
						memory.s.insertTable(mac, key, "Fake/Stolen Key");
						output.writeUTF(reply);
					}
				}
			} else
			{
				reply = "AccessDenied";
				memory.s.insertTable(mac, key, "Fake/Key not Present");
				output.writeUTF(reply);
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}