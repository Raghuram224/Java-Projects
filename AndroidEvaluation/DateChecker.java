import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DateChecker {
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		DateChecker dateChecker = new DateChecker();
		int peopleLivedYear=2090;
		int peopleCount=0;
		List datas = dateChecker.addData();
		for (int i =0;i<datas.size();i++){
			People person = (People) datas.get(i);

			if (peopleLivedYear>=person.bDate && peopleLivedYear<person.dDate){
				peopleCount++;
			}
	
		}
		System.out.println("people lived :"+peopleCount);
		
	}
	public List addData(){
		List<Object> peopleList = new ArrayList<>();
		peopleList.add(new People("Ram",2003,2023));
		peopleList.add(new People("raghu",2000,2050));
		peopleList.add(new People("Rahul",2001,2090));
		peopleList.add(new People("ganapathi",2011,2015));
		peopleList.add(new People("nick",2002,2050));
		peopleList.add(new People("fuery",2003,2023));
		peopleList.add(new People("helios",2013,2043));
		peopleList.add(new People("kumar",2006,2027));
		peopleList.add(new People("vel",2013,2033));
		peopleList.add(new People("rick",2004,20025));
		
		return  peopleList;
		
	}
	
}

class People{
	String name;
	int bDate;
	int dDate;
	public  People(String name,int bDate,int dDate){
		this.name=name;
		this.bDate=bDate;
		this.dDate=dDate;
	}
}
