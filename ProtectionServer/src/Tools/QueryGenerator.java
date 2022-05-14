package Tools;

class QueryGenerator
{
	public static void main(String args[])
	{
		KeyGenerator keygen = new KeyGenerator();
		HashFunction hash = new HashFunction();
		String k = "";
		String h = "";
		for(int i = 0 ; i < 100 ; i++)
		{
			k = keygen.getKey().toUpperCase();
			h = hash.getMd5(k);
			System.out.println("INSERT INTO LicenseTable(LICENSE,MD5) VALUES('"+k+"','"+h+"');");
		}
	}
}