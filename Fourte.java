import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Fourte {
	Random random = new Random();
	private String operator;
	public int getNumberForGuess(){
		int data = random.nextInt(1,50);
		return  data;
	}

	public ArrayList<Integer> answers(){
		ArrayList <Integer> options= new ArrayList<>();
		Main main = new Main();
		operator =getOperator();
		int num1 =getNumberForGuess();
		int num2 = getNumberForGuess();
		
		switch (operator){
			
			case "+":
				System.out.println("add");
				main.setRandomNumber(num1+num2);
					
				break;
			case "-":
				System.out.println("min");
				main.setRandomNumber(num1-num2);
				
				break;
			case "*":

				System.out.println("mul");
				
				main.setRandomNumber((num1*num2));
				break;
			case "/":
				System.out.println("div");
				
				double temp = (double) num1/num2;
//				while (temp%1!=0){
//					num1 =getNumberForGuess();
//				}
				main.setRandomNumber((num1/num2));
				break;
			default:
				break;
		}
		options.add(num1);
		options.add(num2);
		options.add(getNumberForGuess());
		options.add(getNumberForGuess());
		Collections.shuffle(options);
		return options;
		
	}

	public String getOperator(){
		String [] operators =new String[]{"+","-","/","*"};
		return operators[random.nextInt(0,4)];

	}
	public int getDivisionReminder(){
		return random.nextInt(0,10);
	}


}


