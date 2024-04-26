package jdbc_learn;

import java.sql.*;
import java.io.*;

public class Fun1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//load the driver:
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creating connection
			String url="jdbc:mysql://localhost:3306/youtube";
			String username="root";
			String pass="Nitinsingh@1234";
			Connection con=DriverManager.getConnection(url,username,pass);
			
			// Create Query
			String q="insert into table1(tName,tCity) values (?,?)";
			
			//get the PreparedStatement  object
			PreparedStatement pstmt=con.prepareStatement(q);
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name :");
			String name=br.readLine();
			
			System.out.println("Enter City :");
			String city=br.readLine();
			
			
			pstmt.setString(1,name);
			pstmt.setString(2, city);
			
			pstmt.executeUpdate();
			System.out.println("Inserted..");
			con.close();
			

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
