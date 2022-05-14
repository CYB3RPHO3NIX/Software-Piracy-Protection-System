package PiracyShield;
import java.io.*;

public class CopyFile
{
	public void copyFile(File from, File to) throws Exception
	{
		FileInputStream in = null;
		FileOutputStream out = null;

		try
		{
			in = new FileInputStream(from);
			out = new FileOutputStream(to);

			int c;
			while ((c = in.read()) != -1)
			{
				out.write(c);
			}
		} finally
		{
			if (in != null)
			{
				in.close();
			}
			if (out != null)
			{
				out.close();
			}
		}
	}
}