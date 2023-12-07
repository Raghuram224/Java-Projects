import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Main {
	private String url="jdbc:mysql://localhost:3306/";
	private final String userName="raghu";
	private final String password="@1a2b3c4d@R";
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main= new Main();
		DatabaseConnection databaseConnection = new DatabaseConnection(main.url,main.userName,main.password);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(main.url, main.userName,main.password);

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println("Your DB service name "+databaseMetaData.getDatabaseProductName()+"\nVersion "+databaseMetaData.getDatabaseProductVersion());
			System.out.println("Welcome to Developer Mode in Mysql!!");
			System.out.println();
			System.out.println("Enter 'q' to exit");

			System.out.println("Your databases");
			main.showDatabases(connection);
			connection = DriverManager.getConnection(main.url, main.userName,main.password);
			while (true){
				System.out.println("mysql>");
				String query= bufferedReader.readLine();
				if (!query.equals("q"))databaseConnection.resultGetter(connection,query);
				else  break;
			}
			
			
			
		}catch (Exception e){
			System.out.println(e);
		}
		
	}
	
	public void showDatabases(Connection connection) throws SQLException {
		DatabaseConnection databaseConnection = new DatabaseConnection(url,userName,password);
		databaseConnection.resultGetter(connection,"show databases");
		System.out.println("Enter database name:");
		url+= scanner.nextLine();
		
	}
}