
import java.sql.*;

public class DatabaseConnection {
	String url;
	String userName;
	String password;
	final  String GREEN="\u001B[32m";
	final String WHITE="\u001B[0m";
	Statement statement=null;
	public DatabaseConnection(String url,String userName,String password) {
		this.url=url;
		this.userName = userName;
		this.password=password;
	}
	
	public ResultSet queryeExecutor(Connection connection,String query){
		ResultSet resultSet=null;
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
		}catch (SQLException  e){
			System.out.println(e.getMessage());
//			System.out.println(e.getErrorCode());
//			System.out.println(e.getSQLState());
		}
		return  resultSet;
	}
	public void  resultGetter(Connection connection,String query) throws SQLException {
		
		ResultSet resultSet;

		try{


			resultSet = queryeExecutor(connection,query);
			connection.setAutoCommit(false);
			if (resultSet!=null){
				int columnCount=resultSet.getMetaData().getColumnCount();
					printColumnName(resultSet, columnCount);
					printTableValue(resultSet, columnCount);
					System.out.println();
					connection.commit();
				
				
			}
			
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
			connection.rollback();
		}
		
	}
	
	public void printColumnName(ResultSet resultSet,int columnCount) {
		String columnString="|";
		try {
			
			int precision;
			String column;
			int maxLength;
			for (int i = 1; i <= columnCount; i++) {
				precision = resultSet.getMetaData().getPrecision(i);
				column = resultSet.getMetaData().getColumnName(i);
				maxLength = Math.max(precision,column.length());
				columnString+=String.format(" %-"+maxLength+"s |",column);
			}
			columnString+="\n";
		
			
		}catch (Exception e){
			System.out.println(e+"first");
		}
		System.out.print("+");
		for (int i=0;i<columnString.length()-3;i++){
			System.out.print("-");
		}
		System.out.println("+");
		System.out.print(GREEN+columnString+WHITE);
		System.out.print("+");
		for (int i=0;i<columnString.length()-3;i++){
			System.out.print("-");
		}
		System.out.print("+");
		System.out.println();
	}
	
	public  void  printTableValue(ResultSet resultSet,int columnCount) {
		try{
			String tableString="";
			while (resultSet.next()){
				tableString="|";
				for (int i=1;i<= columnCount ;i++){
					int precise = resultSet.getMetaData().getPrecision(i);
					int columnNameLength= resultSet.getMetaData().getColumnName(i).length();
					tableString+=String.format(" %-"+Math.max(precise,columnNameLength)+"s |",resultSet.getString(i));
					
					
				}
				System.out.print(tableString);
				System.out.println();
			}
			System.out.print("+");
			for (int i=0;i<tableString.length()-2;i++){
				System.out.print("-");
			}
			System.out.print("+");
		}catch (Exception e){
			System.out.println( e+"Second");
		}
		
	}
	
	
}



