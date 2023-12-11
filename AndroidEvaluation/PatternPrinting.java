public class PatternPrinting {
	public static void main(String[] args) {
		
		int n = 5;
		int i,j,k;
		for(i=1;i<=n;i++)
		{
			for(k=1;k<=n-i;k++)
				System.out.print(" ");
			for(j=1;j<=i;j++)
				System.out.print(j);
			for(k=j-2;k>=1; k--)
				System.out.print(k);
			System.out.println();
		}
	}
}
