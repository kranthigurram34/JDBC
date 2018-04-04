package Insertion;
     import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.PreparedStatement;

	public class Insertion {
		public static void main(String[] args) throws  SQLException, ClassNotFoundException {

				Class.forName("org.postgresql.Driver"); //registering Driver class
				System.out.println("Connection Established");
				
				
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/kranthi","postgres","root");
	          System.out.println("Connected"); //Creating connection
	          
	          
				 Statement stm=con.createStatement(); //Creating statement
	        /*  
	          String sql="insert into emp values(590,'das','male')"; //inserting values into table dynamically 
	           stm.executeUpdate(sql);*/
	           
	           
	          PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");// it compile only once
	          ps.setInt(1,567);
	          ps.setString(2,"kranthi");
	          ps.setString(3,"male");
	         
	      
	           int i=ps.executeUpdate();
	           int result=stm.executeUpdate("update emp set name='kranthi' where id=590 "); // manipulating data
	           
	           
	           int result1=stm.executeUpdate("delete from emp where id=512"); //deleting data
	           
	           
	           ResultSet rs=stm.executeQuery("select * from emp"); // selecting entire table to view
	           while(rs.next()){
	        	   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
	           }
	     
	        con.close();//closing connection
			
		}
	}


