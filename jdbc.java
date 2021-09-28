package zoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ato_while {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL","c##keerthi","oracle");
		Scanner s1=new Scanner(System.in);
        System.out.println("Enter 1->insert 2->update 3->delete 4->select exit->0");
        int x=1;
        while(x!=0) {
        	if(x==1) {
        		System.out.println("Enter to insert Atomic weight:: ");
        		int a=s1.nextInt();
        		s1.nextLine();
        		System.out.println("Name:: ");
        		String b=s1.nextLine();
        		
        		System.out.println("Symbol:: ");
        		String c=s1.nextLine();
        		
        		String query1="insert into chem values(?,?,?)";
        		PreparedStatement ps1=con.prepareStatement(query1);
        		ps1.setInt(1, a); 
        		ps1.setString(2, b);
        		ps1.setString(3, c);
        		int row=ps1.executeUpdate();
        		System.out.println(row+ " Record inserted!");
        		
        	}
        	else if(x==2) {
        		System.out.println("Enter atomic no to update:: ");
        		int a1=s1.nextInt();
        		s1.nextLine();
        		System.out.println("Symbol to update:: ");
        		String c1=s1.next();
        		
        		String query="update chem set Symbol=? where weight=?";
        		PreparedStatement ps=con.prepareStatement(query);

        		ps.setString(1, c1);
        		ps.setInt(2, a1); 
        		
        		int rows=ps.executeUpdate();
        		if(rows>=1)
        		{
        			System.out.println("Record Exist!");
        			System.out.println(rows+ " Record Updated!");
        		}
        		else
        		{
        			System.out.println("Record Not Exist!");
        		System.out.println(rows+ " Record Updated!");			
        		}	
        	}
        	else if(x==3) {
        		System.out.println("Enter delete weight:: ");
        		int d=s1.nextInt();
        		
        		String query2="delete from chem where weight=?";
        		PreparedStatement ps2=con.prepareStatement(query2);
        		ps2.setInt(1, d); 
        		int rows1=ps2.executeUpdate();
        		System.out.println(rows1+ " Record deleted!");
        	}
        	else if(x==4) {
        		PreparedStatement ps11=con.prepareStatement("select * from chem");
        		ResultSet rs=ps11.executeQuery();
        		while(rs.next())
        		{
        			int e=rs.getInt(1);
        			String f=rs.getString(2);
        			String g=rs.getString(3);
        			System.out.println(e+ " "+f+" "+g);
        		}
        	}
        	System.out.println("Enter 1->insert 2->update 3->delete 4->select exit->0");
        	x=s1.nextInt();
        }
     s1.close();   
	}

}
