package Server;

import java.util.Random;

class KeyGenerator
{
	public String getKey()
	{
		Random r = new Random();
		char l[] =
		{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' };
		char p[] =
		{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		int d[] = new int[6];
		int lnum = 26;
		int pnum = 10;
		String key;
		d = getCode();
		key = "" + l[r.nextInt(lnum)] + l[r.nextInt(lnum)] + p[r.nextInt(pnum)] + d[0];
		key = key + l[r.nextInt(lnum)] + p[r.nextInt(pnum)] + l[r.nextInt(lnum)] + d[1];
		key = key + p[r.nextInt(pnum)] + l[r.nextInt(lnum)] + l[r.nextInt(lnum)] + d[2];
		key = key + p[r.nextInt(pnum)] + p[r.nextInt(pnum)] + l[r.nextInt(lnum)] + d[3];
		key = key + p[r.nextInt(pnum)] + l[r.nextInt(lnum)] + p[r.nextInt(pnum)] + d[4];
		key = key + l[r.nextInt(lnum)] + p[r.nextInt(pnum)] + p[r.nextInt(pnum)] + d[5];
		return key;
	}
	public String getFormattedKey(String key)
	{
		String lkey = "";
		for(int i = 0; i < key.length() ; i++)
		{
			lkey = lkey + key.charAt(i);
			if(i == 3 || i == 7 || i == 11 || i == 15  || i == 19)
			{
				lkey = lkey + "-";
			}
		}
		return lkey;
	}
	private static int[] getCode()
	{
		Random r = new Random();
		int d[] = new int[6];
		int temp;
		boolean isfine;
		for (int i = 0; i < d.length;)
		{
			isfine = true;
			temp = (r.nextInt(6) + 1);
			for (int j = 0; j <= i; j++)
			{
				if (d[j] == temp)
				{
					isfine = false;
					break;
				}
			}
			if (isfine)
			{
				d[i] = temp;
				i++;
			}
		}
		return d;
	}
}