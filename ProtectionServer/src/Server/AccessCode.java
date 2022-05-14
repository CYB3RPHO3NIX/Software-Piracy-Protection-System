package Server;

class AccessCode
{
	private String ACode = "";
	private MacEncrypt me;
	public String getAccessCode(String license, String mac)
	{
		me = new MacEncrypt();
		String code = me.getEncrypted(license, mac);
		return code;
	}
}