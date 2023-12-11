package FourteReverse;

import java.util.Scanner;

public class MainReverse{
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        FourteReverse fourteReverse ;
        while (true){
            System.out.println("Enter your target:");
            int target = scanner.nextInt();
            fourteReverse = new FourteReverse(target);
            fourteReverse.matchFinder();
        }
        
    }
   
}