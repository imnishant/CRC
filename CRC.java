import java.util.Scanner;

public class CRC {

	static void checkError(int r[], int len)
	{
		for (int i = 0; i < len; i++) {
			if( r[i] != 0)
			{
				System.out.println("Error");
				System.exit(0);
			}
		}
		System.out.println("No Error");
	}
	
	static int XOR(int a, int b)
	{
		if(a==b)
			return 0;
		else
			return 1;
	}
	
	static void crcCheck(int d[], int r[], int g[], int n, int m)
	{
		int msb, k;
		for (int i = 0; i < n; i++) 
		{
			msb = r[i];
			k = 0;
			
			for (int j = i; j < m+i ; j++) 
			{
				
				if( msb == 0 )
					r[j] = XOR( r[j], 0);
				else
					r[j] = XOR(r[j], g[k]);
				k++;
			}
		}
		
		for (int i = n ; i < m+n-1; i++)
			d[i] = r[i];
		
		System.out.println("Remainder is");
		for (int i = n; i < m+n-1 ; i++) 
			System.out.print(r[i] + " ");
		System.out.println();
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		
		System.out.println("Enter size of dataword");
		n = sc.nextInt();
		System.out.println("Enter size of generator");
		m = sc.nextInt();
		int g[] = new int[m];
		int d[] = new int[m+n];
		int r[] = new int[m+n];
		System.out.println("Enter dataword");
		for (int i = 0; i < n; i++)
			d[i] = sc.nextInt();
		
		System.out.println("Enter generator");
		for (int i = 0; i < m; i++)
			g[i] = sc.nextInt();
		
	
		
		for (int i = n; i < m+n-1; i++)
			d[i] = 0;
		
		for (int i = 0; i < m+n-1; i++) 
			r[i] = d[i];
		
		
		System.out.println("Augmented Codeword");
		for (int i = 0; i < m+n-1; i++)
			System.out.print(d[i] + " ");
		System.out.println();
		
		crcCheck(d, r, g, n, m);
		
		System.out.println("Codeword is");
		for (int i = 0; i < m+n-1 ; i++) 
			System.out.print(d[i] + " ");
		System.out.println();
		/*System.out.println("Enter size of codeword");
		int cn = sc.nextInt();*/
		
		int c[] = new int[n+m];
		
		
		System.out.println("Enter codeword");
		for (int i = 0; i < n+m-1; i++)
			c[i] = sc.nextInt();
		
		for (int i = 0; i < m+n-1; i++) 
			r[i] = c[i];
		
		crcCheck(c, r, g, n, m);
		checkError(r, n+m-1);
	}

}
