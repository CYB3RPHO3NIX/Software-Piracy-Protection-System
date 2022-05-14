package Server;

class MacEncrypt
{
	private LicenseKey lk;
	private Encryption e;

	public String getEncrypted(String license, String mac)
	{
		lk = new LicenseKey(license);
		e = new Encryption();
		int code[] = lk.getInsideCode();
		String moded[] = new String[6];
		String normal[] = new String[6];
		
		normal[0] = ""+mac.charAt(0)+mac.charAt(1);
		normal[1] = ""+mac.charAt(3)+mac.charAt(4);
		normal[2] = ""+mac.charAt(6)+mac.charAt(7);
		normal[3] = ""+mac.charAt(9)+mac.charAt(10);
		normal[4] = ""+mac.charAt(12)+mac.charAt(13);
		normal[5] = ""+mac.charAt(15)+mac.charAt(16);
		for(int i = 0 ; i < code.length ; i++)
		{
			moded[code[i]-1] = normal[i]; 
		}
		
		String temp = moded[0]+moded[1]+moded[2]+moded[3]+moded[4]+moded[5];
		temp = e.encrypt(temp);
		return temp;
	}
	public static void main(String args[])
	{
		MacEncrypt me = new MacEncrypt();
		String key = "yh62e1f40ck565c19b36l103".toUpperCase();
		System.out.println("The Key "+key+" Hash : "+me.getEncrypted(key, "EC:55:F9:7D:60:81"));
	}
}