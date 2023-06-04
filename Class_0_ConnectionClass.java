package Library;
import java.sql.*;


public class Class_0_ConnectionClass {
	Connection con;
	Statement stm;
	
	public Class_0_ConnectionClass() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/tree", "root", "7038");
			stm = con.createStatement();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
		public static void main(String[] args) {
			new Class_0_ConnectionClass();
			System.out.println("Testing...");
			
		}

}
