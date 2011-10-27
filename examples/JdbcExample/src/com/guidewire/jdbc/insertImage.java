import java.sql.*;
import java.io.*;

public class insertImage{
	public static void main(String[] args) {
		System.out.println("Insert Image Example!");
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "hibernatetutorial";
		String userName = "root";
		String password = "root";
		Connection con = null;
		try{
			Class.forName(driverName);
			con = DriverManager.getConnection(url+dbName,userName,password);
			Statement st = con.createStatement();
			File imgfile = new File("images.jpg");
			FileInputStream fin = new FileInputStream(imgfile);
			PreparedStatement pre = con.prepareStatement("insert into Image values(?,?,?)");
			pre.setInt(1,5);
			pre.setString(2,"Durga");
			pre.setBinaryStream(3,fin,(int)imgfile.length());
			pre.executeUpdate();
			System.out.println("Inserting Successfully!");
			pre.close();
			con.close();	
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}