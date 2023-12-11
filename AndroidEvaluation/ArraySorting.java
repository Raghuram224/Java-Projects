
import java.util.*;


public class ArraySorting {
	
	HashMap hashMap = new HashMap<>();
	public static void main(String[] args) {
		int[] array = new int[]{5,9,13,16,20,20,34};
		ArraySorting arraySorting = new ArraySorting();

		for (int i=0;i< array.length;i++){
			arraySorting.primeDifferenceFinder(array[i]);
		}
		System.out.println(arraySorting.hashMap);
		Integer[] keys = (Integer[]) arraySorting.hashMap.keySet().toArray(new Integer[1]);
		
		Integer[] values = (Integer[]) arraySorting.hashMap.values().toArray(new Integer[0]);
		
		ArrayList<Integer> sortedArray= new ArrayList();
		int index=0;
		for (int i=0;i< keys.length;i++){
			for (int j=0;j<keys.length;j++){
				if (values[j]==index){
					sortedArray.add(keys[j]);
				}
			}
			index++;
		}
		System.out.println(sortedArray);

		

		
	
	}
	
	public void primeDifferenceFinder(int n){
		int[]primeNumbers= new int[]{1,2,3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73};
		
		int num1 = 0;
		int num2=0;
		for (int i=0;i<primeNumbers.length;i++){
			if (primeNumbers[i]<n){
				num1=n-primeNumbers[i];
			}
			else if (primeNumbers[i]>n){
				num2=primeNumbers[i]-n;
				break;
			}
		}
		hashMap.put(n,Math.min(num1,num2));
		
		
	}
	
	
	

	
	
}
