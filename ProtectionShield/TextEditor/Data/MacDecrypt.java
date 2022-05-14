package TextEditor.Data;

class MacDecrypt
{
	private LicenseKey lk;
	private Decryption d;
	public String decrypt(String enc, String license)
	{
		d = new Decryption();
		lk = new LicenseKey(license);
		int code[] = lk.getInsideCode();
		String decrypt[] = new String[6];
		String normal[] = new String[6];
		String mac = d.decrypt(enc);
		normal[0] = ""+mac.charAt(0)+mac.charAt(1);
		normal[1] = ""+mac.charAt(2)+mac.charAt(3);
		normal[2] = ""+mac.charAt(4)+mac.charAt(5);
		normal[3] = ""+mac.charAt(6)+mac.charAt(7);
		normal[4] = ""+mac.charAt(8)+mac.charAt(9);
		normal[5] = ""+mac.charAt(10)+mac.charAt(11);
		for(int i = 0 ; i < code.length ; i++)
		{
			decrypt[i] = normal[code[i]-1]; 
		}
		String temp = decrypt[0]+":"+decrypt[1]+":"+decrypt[2]+":"+decrypt[3]+":"+decrypt[4]+":"+decrypt[5];
		return temp;
	}
}