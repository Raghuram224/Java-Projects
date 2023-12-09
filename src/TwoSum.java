import java.util.ArrayList;

public class TwoSum {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(9);
		
		int target = 9;
		
		findTwoSum(arrayList, target);
	}
	
	public static void findTwoSum(ArrayList<Integer> nums, int target) {
		for (int i = 0; i < nums.size() - 1; i++) {
			for (int j = i + 1; j < nums.size(); j++) {
				if (nums.get(i) + nums.get(j) == target) {
					System.out.println("Two elements found: " + nums.get(i) + " and " + nums.get(j));
					return; // If you want to find only one pair, you can remove this line to find all pairs
				}
			}
		}
		
		System.out.println("No two elements found that sum up to the target.");
	}
}
