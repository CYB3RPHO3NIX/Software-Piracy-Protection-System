package Server;

import java.util.Random;
import java.util.Scanner;
class Encryption
{
	private Constants c;
	private static Random r;
	public Encryption()
	{
		r = new Random();
		c = new Constants();
	}
	public String encrypt(String text)
	{
		String enc="";
		char x;
		if(isValid(text))
		{
			for(int i = 0 ; i < text.length() ; i++)
			{
				x = text.charAt(i);
				if(x == 'A')
				{
					enc = enc + (char)c.A[r.nextInt(8)];
				}
				if(x == 'B')
				{
					enc = enc + (char)c.B[r.nextInt(8)];
				}
				if(x == 'C')
				{
					enc = enc + (char)c.C[r.nextInt(8)];
				}
				if(x == 'D')
				{
					enc = enc + (char)c.D[r.nextInt(8)];
				}
				if(x == 'E')
				{
					enc = enc + (char)c.E[r.nextInt(8)];
				}
				if(x == 'F')
				{
					enc = enc + (char)c.F[r.nextInt(8)];
				}
				if(x == 'G')
				{
					enc = enc + (char)c.G[r.nextInt(8)];
				}
				if(x == 'H')
				{
					enc = enc + (char)c.H[r.nextInt(8)];
				}
				if(x == 'I')
				{
					enc = enc + (char)c.I[r.nextInt(8)];
				}
				if(x == 'J')
				{
					enc = enc + (char)c.J[r.nextInt(8)];
				}
				if(x == 'K')
				{
					enc = enc + (char)c.K[r.nextInt(8)];
				}
				if(x == 'L')
				{
					enc = enc + (char)c.L[r.nextInt(8)];
				}
				if(x == 'M')
				{
					enc = enc + (char)c.M[r.nextInt(8)];
				}
				if(x == 'N')
				{
					enc = enc + (char)c.N[r.nextInt(8)];
				}
				if(x == 'O')
				{
					enc = enc + (char)c.O[r.nextInt(8)];
				}
				if(x == 'P')
				{
					enc = enc + (char)c.P[r.nextInt(8)];
				}
				if(x == 'Q')
				{
					enc = enc + (char)c.Q[r.nextInt(8)];
				}
				if(x == 'R')
				{
					enc = enc + (char)c.R[r.nextInt(8)];
				}
				if(x == 'S')
				{
					enc = enc + (char)c.S[r.nextInt(8)];
				}
				if(x == 'T')
				{
					enc = enc + (char)c.T[r.nextInt(8)];
				}
				if(x == 'U')
				{
					enc = enc + (char)c.U[r.nextInt(8)];
				}
				if(x == 'V')
				{
					enc = enc + (char)c.V[r.nextInt(8)];
				}
				if(x == 'W')
				{
					enc = enc + (char)c.W[r.nextInt(8)];
				}
				if(x == 'X')
				{
					enc = enc + (char)c.X[r.nextInt(8)];
				}
				if(x == 'Y')
				{
					enc = enc + (char)c.Y[r.nextInt(8)];
				}
				if(x == 'Z')
				{
					enc = enc + (char)c.Z[r.nextInt(8)];
				}
				if(x == '0')
				{
					enc = enc + (char)c.n0[r.nextInt(8)];
				}
				if(x == '1')
				{
					enc = enc + (char)c.n1[r.nextInt(8)];
				}
				if(x == '2')
				{
					enc = enc + (char)c.n2[r.nextInt(8)];
				}
				if(x == '3')
				{
					enc = enc + (char)c.n3[r.nextInt(8)];
				}
				if(x == '4')
				{
					enc = enc + (char)c.n4[r.nextInt(8)];
				}
				if(x == '5')
				{
					enc = enc + (char)c.n5[r.nextInt(8)];
				}
				if(x == '6')
				{
					enc = enc + (char)c.n6[r.nextInt(8)];
				}
				if(x == '7')
				{
					enc = enc + (char)c.n7[r.nextInt(8)];
				}
				if(x == '8')
				{
					enc = enc + (char)c.n8[r.nextInt(8)];
				}
				if(x == '9')
				{
					enc = enc + (char)c.n9[r.nextInt(8)];
				}
			}
		}
		else
		{
			enc="NULL";
		}
		return enc;
	}
	private boolean isValid(String text)
	{
		int count=0;
		int charNum;
		for(int i = 0 ; i < text.length() ; i++)
		{
			charNum = (int)text.charAt(i);
			if(48 <= charNum && charNum <= 57 || 65 <= charNum && charNum <= 90)
			{
				count=count+1;
			}
		}
		if(count == text.length())
		{
			return true;
		}
		else
		{
			return false;
		}
	}	
}