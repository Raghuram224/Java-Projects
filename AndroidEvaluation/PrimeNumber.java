public class PrimeNumber {
	public static void main(String[] args) {
		int n=11;
		for (int i=1;i<n;i++){
			if (n==1 || n==2){
				System.out.println("prime number");
				break;
			}
			else if (n%i==0 ){
				System.out.println("Not a prime number");
				break;
			} else if (i==n-1 ) {
				System.out.println("Prime number");
				
			}
		}
	}
}
