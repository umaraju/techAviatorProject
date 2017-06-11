package Day6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB {
	
	public static void main(String[] args) throws Exception {
		
//		connection string
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;servername=DELL-PC\\SQLEXPRESS;databaseName=Selenium;IntegratedSecurity=true");
//		check whether connection established
		if(con!=null){
			System.out.println("connection established");
		}else{
			System.out.println("connection not established");
		}
	
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter the name");
		String name = sc.next();
		System.out.println("please enter the name");
		String id = sc.next();
		
//		Execute statement
		Statement st = con.createStatement();
//		customised sql query where search happens with 2 attributes(select * from employee where name = 'Ram' and ID='3')
		ResultSet rs = st.executeQuery("select * from employee where name = '" + name + "' and ID='" + id + "'");	
		
//		read the result
		while(rs.next()){
			
			System.out.println(rs.getString("ID"));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			
		}
		
		
		
//		close the connection
		con.close();
		
		
		
	}	

}
