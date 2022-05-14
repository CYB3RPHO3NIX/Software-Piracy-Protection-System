package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

class Database
{
	private Statement statement;
	private ResultSet result;

	public Database()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/LicenseDatabase?serverTimezone=UTC", "root", "root");
			statement = conn.createStatement();
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Unable to connect to database", "Connection Failed",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public Object[][] search(String skey)
	{
		Object[][] res = null;
		int i = 0, count = 0;
		try
		{
			result = statement
					.executeQuery("select ID, LICENSE, FNAME, LNAME, REGDATE from LicenseTable where ID LIKE '%" + skey
							+ "%' OR LICENSE LIKE '%" + skey + "%' OR FNAME LIKE '%" + skey + "%' OR LNAME LIKE '%"
							+ skey + "%' OR REGDATE LIKE '%" + skey + "%';");
			do
			{
				count = count + 1;
			} while (result.next());
			res = new Object[count][5];
			result.first();
			if (count != 0)
			{
				do
				{
					res[i][0] = result.getInt(1);
					res[i][1] = result.getString(2);
					res[i][2] = result.getString(3);
					res[i][3] = result.getString(4);
					res[i][4] = result.getString(5);
					i = i + 1;
				} while (result.next());
			}
		} catch (SQLException e)
		{
			res[0][0] = "No results";
			res[0][1] = "No results";
			res[0][2] = "No results";
			res[0][3] = "No results";
			res[0][4] = "No results";
		}
		return res;
	}

	// this function is for ShowDatabase only.
	public Object[][] fetchAll()
	{
		int max = getNumberOfRows();
		int i = 0;
		Object[][] data = new Object[max][5];
		try
		{
			result = statement.executeQuery("SELECT ID, LICENSE, FNAME, LNAME, REGDATE  FROM LicenseTable;");
			result.first();
			String temp="";
			do
			{
				data[i][0] = result.getInt(1);//id
				data[i][1] = result.getString(2);//license
				
				temp = result.getString(3);
				if(!temp.equals("empty"))
				{
					data[i][2] = temp;
				}
				else
				{
					data[i][2] = "";
				}
				temp = result.getString(4);
				if(!temp.equals("empty"))
				{
					data[i][3] = temp;
				}
				else
				{
					data[i][3] = "";
				}
				temp = result.getString(5);
				if(!temp.equals("empty"))
				{
					data[i][4] = temp;
				}
				else
				{
					data[i][4] = "";
				}
				i = i + 1;
			} while (result.next());
		} catch (SQLException e)
		{
			System.out.println("Error in Query");
			e.printStackTrace();
		}
		return data;
	}

	public boolean insertKey(String key, String md5)
	{
		try
		{
			statement.execute("INSERT INTO LicenseTable(LICENSE,MD5) VALUES('" + key + "','" + md5 + "');");
		} catch (SQLException e)
		{
			JOptionPane.showConfirmDialog(null, "License Key is Already Present", "Duplicate Entry Error", JOptionPane.CLOSED_OPTION);
			return false;
		}
		return true;
	}

	public int getNumberOfRows()
	{
		int num = -1;
		try
		{
			result = statement.executeQuery("select Count(*) from LicenseTable;");
			result.first();
			num = result.getInt(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return num;
	}

	public String getKeyOfIndex(String index)
	{
		String key = null;
		try
		{
			result = statement.executeQuery("select LICENSE FROM LicenseTable WHERE ID = '" + index + "';");
			result.first();
			key = result.getString(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return key;
	}

	public boolean removeRow(String key)
	{
		try
		{
			statement.execute("delete from LicenseTable where ID= '" + key + "';");
		} catch (SQLException e)
		{
			return false;
		}
		return true;
	}

	public int[] getAllIndex()
	{
		int[] index = null;
		int count = 0;
		try
		{
			result = statement.executeQuery("SELECT ID from LicenseTable;");
			for (count = 0; result.next(); count++)
				;
			index = new int[count];
			result.first();
			int i = 0;
			do
			{
				index[i] = result.getInt(1);
				i = i + 1;
			} while (result.next());
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return index;
	}

	public boolean isKeyPresent(String md5)
	{
		boolean isTrue = false;
		try
		{
			result = statement.executeQuery("SELECT * FROM LicenseTable WHERE MD5 = '" + md5 + "';");
			result.first();
			if (result.isFirst() && result.isLast())
			{
				isTrue = true;
			} else
			{
				isTrue = false;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return isTrue;
	}

	public String getKey(String md5)
	{
		String key = "";
		if (isKeyPresent(md5))
		{
			try
			{
				result = statement.executeQuery("SELECT LICENSE FROM LicenseTable WHERE MD5 = '" + md5 + "';");
				result.first();
				key = result.getString(1);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
		{
			key = "Empty";
		}
		return key;
	}

	public boolean isMacAssociated(String md5)
	{
		String mac = "";
		try
		{
			result = statement.executeQuery("SELECT MAC FROM LicenseTable WHERE MD5 = '" + md5 + "';");
			result.first();
			mac = result.getString(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		if (mac.equals("empty"))
		{
			return false;
		} else
		{
			return true;
		}
	}
	public boolean isSameMac(String mac, String md5)
	{
		String m="";
		try
		{
			result = statement.executeQuery("SELECT MAC FROM LicenseTable WHERE MD5 = '" + md5 + "';");
			result.first();
			m = result.getString(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		if (m.equals(mac))
		{
			return true;
		} else
		{
			return false;
		}
	}
	public boolean updateCredentials(String license, String mac, String fname, String lname, String regdate)
	{
		boolean isTrue = false;

		try
		{
			isTrue = statement.execute("UPDATE LicenseTable SET MAC = '" + mac + "', FNAME = '" + fname
					+ "', LNAME = '" + lname + "', REGDATE = '" + regdate + "' WHERE LICENSE = '" + license + "';");
			isTrue = true;
		} catch (SQLException e)
		{
			e.printStackTrace();
			isTrue = false;
		}
		return isTrue;
	}
	public boolean updateCred(String license,String fname, String lname)
	{
		boolean isTrue = false;

		try
		{
			isTrue = statement.execute("UPDATE LicenseTable SET FNAME = '" + fname + "', LNAME = '" + lname + "' WHERE LICENSE = '" + license + "';");
			isTrue = true;
		} catch (SQLException e)
		{
			e.printStackTrace();
			isTrue = false;
		}
		return isTrue;
	}
}