import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class PathFinding {
		int[][] numberArray = { {11,10,4,3,1},
			{19,12,9,5,2},
			{20,18,13,8,6},
			{24,21,17,14,7},
			{25,23,22,16,15}
	};
		TreeMap<Integer,String> treeMap = new TreeMap();
	public static void main(String[] args) {
		PathFinding pathFinding = new PathFinding();
		pathFinding.printArray();
		
		for (int i=0;i<pathFinding.numberArray.length;i++){
			for (int j=0;j<pathFinding.numberArray.length;j++){
				String position = "["+i+","+j+"]";
				pathFinding.treeMap.put(pathFinding.numberArray[i][j],position);
			}
		}
		
		Iterator iterator = pathFinding.treeMap.entrySet().iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
			
		}
//		System.out.println(pathFinding.treeMap);
	}
	public void printArray(){
		String res="";
		for (int i=0;i< numberArray.length;i++){
			for (int j=0;j< numberArray.length;j++){
				res+=numberArray[i][j]+"\t";
			}
			res+="\n";
		}
		System.out.println(res);
	}
	
}
