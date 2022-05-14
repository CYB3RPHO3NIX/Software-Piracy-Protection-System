package Server;

import java.util.Scanner;

class LicenseKey
{
	private char[] k;
	private String license="";
	public LicenseKey(String key)
	{
		key = key.toUpperCase();
		k = new char[24];
		for(int i = 0 ; i < key.length() ; i++)
		{
			k[i] = key.charAt(i);
		}
	}
	private boolean isCodeDigit(char c)
	{
		int num = Character.getNumericValue(c);
		if(1 <= num && num <=6)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	private boolean isLetter(char c)
	{
		return Character.isLetter(c);
	}
	private boolean isInteger(char c)
	{
		return Character.isDigit(c);
	}
	public boolean isValid()
	{
		boolean validL = false;
		boolean validP = false;
		boolean validD = false;
		if(isLetter(k[0]) && isLetter(k[1]) && isLetter(k[4]) && isLetter(k[6]) && isLetter(k[9]) && isLetter(k[10]) && isLetter(k[14]) && isLetter(k[17]) && isLetter(k[20]))
		{
			validL = true;
		}
		if(isInteger(k[2]) && isInteger(k[5]) && isInteger(k[8]) && isInteger(k[12]) && isInteger(k[13]) && isInteger(k[16]) && isInteger(k[18]) && isInteger(k[21]) && isInteger(k[22]))
		{
			validP = true;
		}
		if(isCodeDigit(k[3]) && isCodeDigit(k[7]) && isCodeDigit(k[11]) && isCodeDigit(k[15]) && isCodeDigit(k[19]) && isCodeDigit(k[23]))
		{
			int arr[] = new int[6];
			validD = true;
			arr[0] = k[3];
			arr[1] = k[7];
			arr[2] = k[11];
			arr[3] = k[15];
			arr[4] = k[19];
			arr[5] = k[23];
			
			for(int i = 0 ; i < arr.length-1 ; i++)
			{
				for(int j = i+1 ; j < arr.length ; j++)
				{
					if(arr[i] == arr[j])
					{
						validD = false;
					}
				}
			}
		}
		if(validL && validP && validD)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int[] getInsideCode()
	{
		int[] code = new int[6];
		if(isValid())
		{
			code[0] = Character.getNumericValue(k[3]);
			code[1] = Character.getNumericValue(k[7]);
			code[2] = Character.getNumericValue(k[11]);
			code[3] = Character.getNumericValue(k[15]);
			code[4] = Character.getNumericValue(k[19]);
			code[5] = Character.getNumericValue(k[23]);
		}
		return code;
	}
	public String getKey()
	{
		String lkey = "";
		for(int i = 0 ; i < k.length ; i++)
		{
			lkey = lkey + k[i];
			if(i == 3 || i == 7 || i == 11 || i == 15  || i == 19)
			{
				lkey = lkey + "-";
			}
		}
		return lkey;
	}
	public boolean compareKey(LicenseKey k)
	{
		return license.equals(k.license);
	}
}