public class BinaryConverter {
	public static void main(String[] args) {
		int bin=5;
		int count =0;
		String result ="";
		
		while (bin!=0){
			int reminder =bin%2;
			result=reminder+result;
			bin=bin/2;
			
			
			
		}
//		if (result.length() < 4) {
//			result="0"+result;
//		}
//
//		System.out.println(result);
		for (int i=0;i<result.length();i++){
			if (result.charAt(i)=='1'){
				count++;
				
			}
		}
		System.out.println(count);
	}
}
