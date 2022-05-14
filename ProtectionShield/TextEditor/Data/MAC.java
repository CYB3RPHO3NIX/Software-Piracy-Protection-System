package TextEditor.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

class MAC
{
	private String MacAddress = "";
	private String IpAddress = "";

	public MAC()
	{
		String ip;
		try
		{
			ip = getRoutableAddress();
			IpAddress = getRoutableAddress();
			MacAddress = getMacAddress(ip);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getRoutableAddress() throws Exception
	{
		String ip = "";
		ArrayList<String> arr = new ArrayList<String>();

		Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();

		for (NetworkInterface netint : Collections.list(nets))
		{
			Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();

			for (InetAddress inetAddress : Collections.list(inetAddresses))
			{
				arr.add(inetAddress.toString().substring(1));
			}
		}
		for(String txt : arr)
		{
			if(isIP(txt))
			{
				ip = txt;
				break;
			}
		}
		return ip;
	}
	private boolean isIP(String text)
	{
		boolean isTrue;
		int count = 0 ;
		for(int i = 0 ; i < text.length() ; i++)
		{
			if(text.charAt(i) == '.')
			{
				count = count+1;
			}
		}
		if(count == 3 && !text.equals("127.0.0.1"))
		{
			isTrue = true;
		}
		else
		{
			isTrue = false;
		}
		return isTrue;
	}
	public String getMacAddress(String ipAddr) throws UnknownHostException, SocketException
	{
		InetAddress addr = InetAddress.getByName(ipAddr);
		NetworkInterface ni = NetworkInterface.getByInetAddress(addr);
		if (ni == null)
			return null;

		byte[] mac = ni.getHardwareAddress();
		if (mac == null)
			return null;

		StringBuilder sb = new StringBuilder(18);
		for (byte b : mac)
		{
			if (sb.length() > 0)
				sb.append(':');
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	public ArrayList<String> getAllMac() throws Exception
	{
		ProcessBuilder builder = new ProcessBuilder("ifconfig");
		builder.redirectErrorStream(true);
		Process process = builder.start();
		InputStream is = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		String line = null;
		String o = "";
		while ((line = reader.readLine()) != null)
		{
			o = o + line;
		}
		
		ArrayList<String> macList = new ArrayList<String>();
		line = "";
		int x;
		for(int i = 0 ; i < o.length()-6 ; i++)
		{
			if(o.charAt(i) == 'e' && o.charAt(i+1) == 't' && o.charAt(i+2) == 'h' && o.charAt(i+3) == 'e' && o.charAt(i+4) == 'r')
			{
				x = i+6;
				while(o.charAt(x)!=' ')
				{
					line = line+o.charAt(x);
					x=x+1;
				}
				macList.add(line);
				line = "";
			}
		}
		return macList;
	}
	public String getMAC()
	{
		return MacAddress.toUpperCase();
	}
	public String getIP()
	{
		return IpAddress;
	}

}