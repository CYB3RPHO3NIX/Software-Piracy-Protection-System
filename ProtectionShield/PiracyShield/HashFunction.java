package PiracyShield;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

class HashFunction
{
//	public static void main(String args[])
//	{
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter your String : ");
//		String text = input.nextLine();
//		System.out.println("HASH : "+getMd5(text)+" and its length : "+getMd5(text).length());
//		input.close();
//	}

	public String getMd5(String input)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32)
			{
				hashtext = "0" + hashtext;
			}
			return hashtext.toUpperCase();
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e);
		}
	}
}