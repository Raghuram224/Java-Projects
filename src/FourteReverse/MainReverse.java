package FourteReverse;

import java.util.Scanner;

public class MainReverse{
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your target:");
        int target = scanner.nextInt();
        FourteReverse fourteReverse = new FourteReverse(target);
        fourteReverse.matchFinder();
    }
   
}