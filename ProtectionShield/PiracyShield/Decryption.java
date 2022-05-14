package PiracyShield;

class Decryption
{
	private Constants c;
	public Decryption()
	{
		c = new Constants();
	}
	public String decrypt(String text)
	{
		String dec = "";
		int cnum; 
		for(int i = 0; i < text.length() ; i++)
		{
			cnum = (int)text.charAt(i);
			if(cnum == c.A[0] || cnum == c.A[1] || cnum == c.A[2] || cnum == c.A[3] || cnum == c.A[4] || cnum == c.A[5] || cnum == c.A[6] || cnum == c.A[7])      
			{
				dec = dec + 'A';
			}
			if(cnum == c.B[0] || cnum == c.B[1] || cnum == c.B[2] || cnum == c.B[3] || cnum == c.B[4] || cnum == c.B[5] || cnum == c.B[6] || cnum == c.B[7])      
			{
				dec = dec + 'B';
			}
			if(cnum == c.C[0] || cnum == c.C[1] || cnum == c.C[2] || cnum == c.C[3] || cnum == c.C[4] || cnum == c.C[5] || cnum == c.C[6] || cnum == c.C[7])      
			{
				dec = dec + 'C';
			}
			if(cnum == c.D[0] || cnum == c.D[1] || cnum == c.D[2] || cnum == c.D[3] || cnum == c.D[4] || cnum == c.D[5] || cnum == c.D[6] || cnum == c.D[7])      
			{
				dec = dec + 'D';
			}
			if(cnum == c.E[0] || cnum == c.E[1] || cnum == c.E[2] || cnum == c.E[3] || cnum == c.E[4] || cnum == c.E[5] || cnum == c.E[6] || cnum == c.E[7])      
			{
				dec = dec + 'E';
			}
			if(cnum == c.F[0] || cnum == c.F[1] || cnum == c.F[2] || cnum == c.F[3] || cnum == c.F[4] || cnum == c.F[5] || cnum == c.F[6] || cnum == c.F[7])      
			{
				dec = dec + 'F';
			}
			if(cnum == c.G[0] || cnum == c.G[1] || cnum == c.G[2] || cnum == c.G[3] || cnum == c.G[4] || cnum == c.G[5] || cnum == c.G[6] || cnum == c.G[7])      
			{
				dec = dec + 'G';
			}
			if(cnum == c.H[0] || cnum == c.H[1] || cnum == c.H[2] || cnum == c.H[3] || cnum == c.H[4] || cnum == c.H[5] || cnum == c.H[6] || cnum == c.H[7])      
			{
				dec = dec + 'H';
			}
			if(cnum == c.I[0] || cnum == c.I[1] || cnum == c.I[2] || cnum == c.I[3] || cnum == c.I[4] || cnum == c.I[5] || cnum == c.I[6] || cnum == c.I[7])      
			{
				dec = dec + 'I';
			}
			if(cnum == c.J[0] || cnum == c.J[1] || cnum == c.J[2] || cnum == c.J[3] || cnum == c.J[4] || cnum == c.J[5] || cnum == c.J[6] || cnum == c.J[7])      
			{
				dec = dec + 'J';
			}
			if(cnum == c.K[0] || cnum == c.K[1] || cnum == c.K[2] || cnum == c.K[3] || cnum == c.K[4] || cnum == c.K[5] || cnum == c.K[6] || cnum == c.K[7])      
			{
				dec = dec + 'K';
			}
			if(cnum == c.L[0] || cnum == c.L[1] || cnum == c.L[2] || cnum == c.L[3] || cnum == c.L[4] || cnum == c.L[5] || cnum == c.L[6] || cnum == c.L[7])      
			{
				dec = dec + 'L';
			}
			if(cnum == c.M[0] || cnum == c.M[1] || cnum == c.M[2] || cnum == c.M[3] || cnum == c.M[4] || cnum == c.M[5] || cnum == c.M[6] || cnum == c.M[7])      
			{
				dec = dec + 'M';
			}
			if(cnum == c.N[0] || cnum == c.N[1] || cnum == c.N[2] || cnum == c.N[3] || cnum == c.N[4] || cnum == c.N[5] || cnum == c.N[6] || cnum == c.N[7])      
			{
				dec = dec + 'N';
			}
			if(cnum == c.O[0] || cnum == c.O[1] || cnum == c.O[2] || cnum == c.O[3] || cnum == c.O[4] || cnum == c.O[5] || cnum == c.O[6] || cnum == c.O[7])      
			{
				dec = dec + 'O';
			}
			if(cnum == c.P[0] || cnum == c.P[1] || cnum == c.P[2] || cnum == c.P[3] || cnum == c.P[4] || cnum == c.P[5] || cnum == c.P[6] || cnum == c.P[7])      
			{
				dec = dec + 'P';
			}
			if(cnum == c.Q[0] || cnum == c.Q[1] || cnum == c.Q[2] || cnum == c.Q[3] || cnum == c.Q[4] || cnum == c.Q[5] || cnum == c.Q[6] || cnum == c.Q[7])      
			{
				dec = dec + 'Q';
			}
			if(cnum == c.R[0] || cnum == c.R[1] || cnum == c.R[2] || cnum == c.R[3] || cnum == c.R[4] || cnum == c.R[5] || cnum == c.R[6] || cnum == c.R[7])      
			{
				dec = dec + 'R';
			}
			if(cnum == c.S[0] || cnum == c.S[1] || cnum == c.S[2] || cnum == c.S[3] || cnum == c.S[4] || cnum == c.S[5] || cnum == c.S[6] || cnum == c.S[7])      
			{
				dec = dec + 'S';
			}
			if(cnum == c.T[0] || cnum == c.T[1] || cnum == c.T[2] || cnum == c.T[3] || cnum == c.T[4] || cnum == c.T[5] || cnum == c.T[6] || cnum == c.T[7])      
			{
				dec = dec + 'T';
			}
			if(cnum == c.U[0] || cnum == c.U[1] || cnum == c.U[2] || cnum == c.U[3] || cnum == c.U[4] || cnum == c.U[5] || cnum == c.U[6] || cnum == c.U[7])      
			{
				dec = dec + 'U';
			}
			if(cnum == c.V[0] || cnum == c.V[1] || cnum == c.V[2] || cnum == c.V[3] || cnum == c.V[4] || cnum == c.V[5] || cnum == c.V[6] || cnum == c.V[7])      
			{
				dec = dec + 'V';
			}
			if(cnum == c.W[0] || cnum == c.W[1] || cnum == c.W[2] || cnum == c.W[3] || cnum == c.W[4] || cnum == c.W[5] || cnum == c.W[6] || cnum == c.W[7])      
			{
				dec = dec + 'W';
			}
			if(cnum == c.X[0] || cnum == c.X[1] || cnum == c.X[2] || cnum == c.X[3] || cnum == c.X[4] || cnum == c.X[5] || cnum == c.X[6] || cnum == c.X[7])      
			{
				dec = dec + 'X';
			}
			if(cnum == c.Y[0] || cnum == c.Y[1] || cnum == c.Y[2] || cnum == c.Y[3] || cnum == c.Y[4] || cnum == c.Y[5] || cnum == c.Y[6] || cnum == c.Y[7])      
			{
				dec = dec + 'Y';
			}
			if(cnum == c.Z[0] || cnum == c.Z[1] || cnum == c.Z[2] || cnum == c.Z[3] || cnum == c.Z[4] || cnum == c.Z[5] || cnum == c.Z[6] || cnum == c.Z[7])      
			{
				dec = dec + 'Z';
			}
			if(cnum == c.n0[0] || cnum == c.n0[1] || cnum == c.n0[2] || cnum == c.n0[3] || cnum == c.n0[4] || cnum == c.n0[5] || cnum == c.n0[6] || cnum == c.n0[7])      
			{
				dec = dec + '0';
			}
			if(cnum == c.n1[0] || cnum == c.n1[1] || cnum == c.n1[2] || cnum == c.n1[3] || cnum == c.n1[4] || cnum == c.n1[5] || cnum == c.n1[6] || cnum == c.n1[7])      
			{
				dec = dec + '1';
			}
			if(cnum == c.n2[0] || cnum == c.n2[1] || cnum == c.n2[2] || cnum == c.n2[3] || cnum == c.n2[4] || cnum == c.n2[5] || cnum == c.n2[6] || cnum == c.n2[7])      
			{
				dec = dec + '2';
			}
			if(cnum == c.n3[0] || cnum == c.n3[1] || cnum == c.n3[2] || cnum == c.n3[3] || cnum == c.n3[4] || cnum == c.n3[5] || cnum == c.n3[6] || cnum == c.n3[7])      
			{
				dec = dec + '3';
			}
			if(cnum == c.n4[0] || cnum == c.n4[1] || cnum == c.n4[2] || cnum == c.n4[3] || cnum == c.n4[4] || cnum == c.n4[5] || cnum == c.n4[6] || cnum == c.n4[7])      
			{
				dec = dec + '4';
			}
			if(cnum == c.n5[0] || cnum == c.n5[1] || cnum == c.n5[2] || cnum == c.n5[3] || cnum == c.n5[4] || cnum == c.n5[5] || cnum == c.n5[6] || cnum == c.n5[7])      
			{
				dec = dec + '5';
			}
			if(cnum == c.n6[0] || cnum == c.n6[1] || cnum == c.n6[2] || cnum == c.n6[3] || cnum == c.n6[4] || cnum == c.n6[5] || cnum == c.n6[6] || cnum == c.n6[7])      
			{
				dec = dec + '6';
			}
			if(cnum == c.n7[0] || cnum == c.n7[1] || cnum == c.n7[2] || cnum == c.n7[3] || cnum == c.n7[4] || cnum == c.n7[5] || cnum == c.n7[6] || cnum == c.n7[7])      
			{
				dec = dec + '7';
			}
			if(cnum == c.n8[0] || cnum == c.n8[1] || cnum == c.n8[2] || cnum == c.n8[3] || cnum == c.n8[4] || cnum == c.n8[5] || cnum == c.n8[6] || cnum == c.n8[7])      
			{
				dec = dec + '8';
			}
			if(cnum == c.n9[0] || cnum == c.n9[1] || cnum == c.n9[2] || cnum == c.n9[3] || cnum == c.n9[4] || cnum == c.n9[5] || cnum == c.n9[6] || cnum == c.n9[7])      
			{
				dec = dec + '9';
			}
		}
		return dec;
	}
}