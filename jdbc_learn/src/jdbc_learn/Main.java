package jdbc_learn;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection c=ConnectionProvider.getConnection();
			String q="insert into images(pic) value(?)";
			
			PreparedStatement pstmt=c.prepareStatement(q);
			
			JFileChooser jfc=new JFileChooser();
			
			jfc.showOpenDialog(null);
			File file=jfc.getSelectedFile();
			FileInputStream fis=new FileInputStream(file);
			
			pstmt.setBinaryStream(1, fis, fis.available());
			pstmt.executeUpdate();
			
			System.out.println("Done....");
			
			JOptionPane.showMessageDialog(null,"Success");
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		
	}

}
