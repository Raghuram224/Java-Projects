
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.util.ArrayList;

 public class Main {


 	static int randomNumber;
 	public static void main(String[] args) {
 		Main main = new Main();
 		Fourte fourte = new Fourte();
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		System.out.println("Welcome to Fourte!!");
 		System.out.println("You can use + - / * this 4 operators to solve this qn!");
		
 		try {
 			while (true) {

 				ArrayList options = fourte.answers();
 				System.out.println("Qn: "+randomNumber);
 				System.out.println("Your options "+options);
 				System.out.println("Enter your operator:");
 				String op= br.readLine();
 				System.out.println("Enter number 1");
 				int num1 = Integer.parseInt(br.readLine());
 				System.out.println();

 				System.out.println("Enter number 2");
 				int num2 = Integer.parseInt(br.readLine());
				
 				boolean result=false;
 				switch (op){
 					case "+":
 						 result = num1 + num2 == randomNumber;
 						break;
 					case "-":
 						result= num1-num2==randomNumber;
 						break;
 					case "*":
 						result = num1*num2== randomNumber ;
 						break;
 					case "/":
 						result =num1/num2==randomNumber;
 						 break;
 				}
				
 				if (result){
 					System.out.println("You Guessed!!");
 					System.out.println("**************");
 				}else {
 					System.out.println("Wrong Guess!!");
 					System.out.println("**************");
 				}
				
 			}
		
 		}catch (Exception e){
 			System.out.println( e);
 		}
		
		

 	}
	
	
 	public void setRandomNumber(int number){
 		if (number<1){
 			number=(number*-1);
 		}
 		randomNumber=number;
 	}


 }