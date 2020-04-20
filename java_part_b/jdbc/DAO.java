package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO 
{
	
	public int insertemp(Employee e)
	{
		int r=0;
		Connection conn=new DBConnection().getDBconnection();
		try 
		{
			PreparedStatement pst=conn.prepareStatement("insert into emp values(?,?,?,?)");
			pst.setString(1, e.getName());
			pst.setInt(2, e.getAge());
			pst.setString(3, e.getDept());
			pst.setDouble(4, e.getSal());
			r=pst.executeUpdate();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return r;
	}
	
	public int deleteemp(String emp)
	{
		int s=0;
		Connection conn=new DBConnection().getDBconnection();
		try 
		{
			PreparedStatement pst=conn.prepareStatement("delete from emp where name=?");
			pst.setString(1, emp);
			s=pst.executeUpdate();
		} 
		catch (SQLException e1)
		{	
			e1.printStackTrace();
		}
		return s;
	}
	
	public void displayname(String empname)
	{
		Connection conn=new DBConnection().getDBconnection();
		try 
		{
				PreparedStatement pst = conn.prepareStatement("select * from emp where empname=?");
				pst.setString(1, empname);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					System.out.println("Name : " +rs.getString(1)+ "\t"+  "Age : " +rs.getInt(2)+ "\t"+ "Dept :" +rs.getString(3)+ "\t"+ "Salary :" +rs.getDouble(4));;
				}
		}
		catch (SQLException e) 
		{
				e.printStackTrace();
		}
	
	}
	
	public void displayall()
	{
		Connection conn=new DBConnection().getDBconnection();
		try 
		{	
			PreparedStatement pst=conn.prepareStatement("select * from emp");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println("Name : " +rs.getString(1)+ "\t"+  "Age : " +rs.getInt(2)+"\t"+ "Dept :" +rs.getString(3)+"\t" + "Salary :" +rs.getDouble(4));;
			}
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	}
}

