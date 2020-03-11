package beximtex;
/**
* <p>Title: BeximTex, User Manager</p>
* <p>Description: Support Software System</p>
* <p>Copyright: 2006-2010</p>
* <p>Company: ASKA</p>
* @author Adeel Ashraf Malik
* @version 1.0.0
*/

import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class UserControllerImpl extends UnicastRemoteObject implements UserController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsUser;
	User usr;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public UserControllerImpl() throws RemoteException
	{
		Connect();
	}//End of Constructor


	/**
	*	Gets Data from Resultset Sets Data
	*
	*/

	public void setData()
	{
		if (haveData)
		{

			try
			{
				usr.setEmpCode(rsUser.getString(1));
				usr.setPass(rsUser.getString(2));
				usr.setName(rsUser.getString(3));
				usr.setDesignation(rsUser.getString(4));
				usr.setDepartment(rsUser.getString(5));
				usr.setExt(rsUser.getString(6));
				usr.setDeptHead(rsUser.getString(7));
				usr.setHeadDesg(rsUser.getString(8));
				usr.setDOJ(sdf.format(rsUser.getDate(9)));
				usr.setDOP(sdf.format(rsUser.getDate(10)));
				usr.setBU(rsUser.getString(11));
				usr.setAppMBamt(rsUser.getString(12));
				usr.setUserType(rsUser.getString(13));
				usr.setEmail(rsUser.getString(14));
				usr.setRemarks(rsUser.getString(15));
			}catch(SQLException sqle)
			{
				System.out.println("Server [UserControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [UserControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return User Object
	*/

	public User moveFirst()
	{
		usr = new User();

		try
		{
			rsUser.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [UserControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return usr;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return User Object
	*/

	public User movePrevious()
	{
		usr = new User();

		try
		{
			if (!rsUser.previous()) rsUser.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [UserControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return usr;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return User Object
	*/

	public User moveNext()
	{
		usr = new User();

		try
		{
			if (!rsUser.next()) rsUser.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [UserControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return usr;
	};

	/**
	*	MOVE TO LAST Record
	*  @return User Object
	*/

	public User moveLast()
	{
		usr = new User();

		try
		{
			rsUser.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [UserControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return usr;
	};

	/**
	*	Open Table
	*
	*/

	public void Connect()
	{
		haveData=false;

		try
		{
			rsUser=db.stmt.executeQuery("SELECT * FROM Employees ORDER BY EmpCode;");
			if (rsUser.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [UserControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into Employee Table
	*  @param User Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(User usr)
	{

		try
		{
			String strQuery="INSERT INTO Employees VALUES(" +
							"'" + usr.getEmpCode()   	+ "',"+
							"'" + usr.getPass()      	+ "',"+
							"'" + usr.getName()    		+ "',"+
							"'" + usr.getDesignation()	+ "',"+
							"'" + usr.getDepartment()   + "',"+
							""  + usr.getExt()      	+ ","+
							"'" + usr.getDeptHead()     + "',"+
							"'" + usr.getHeadDesg()     + "',"+
							"'" + usr.getDOJ()      	+ "',"+
							"'" + usr.getDOP()      	+ "',"+
							"'" + usr.getBU()      		+ "',"+
							"'" + usr.getAppMBamt()     + "',"+
							"'" + usr.getUserType()     + "',"+
							"'" + usr.getEmail()   		+ "',"+
							"'" + usr.getRemarks() 		+ "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [UserControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Data Employee Table
	*  @param User Class Object
	*  @return boolean true or false value
	*/

	public boolean updateData(User usr)
	{
		try
		{
			String strQuery="UPDATE Employees SET " +
							"Password = "		+ "'" + usr.getPass()        	+ "',"+
							"Name = "    		+ "'" + usr.getName()      		+ "',"+
							"Designation = "    + "'" + usr.getDesignation()	+ "',"+
							"Department = "   	+ "'" + usr.getDepartment()     + "',"+
							"Ext = "      		+ ""  + usr.getExt()        	+ "," +
							"DeptHead = " 		+ "'" + usr.getDeptHead()   	+ "',"+
							"HeadDesg = " 		+ "'" + usr.getHeadDesg()   	+ "',"+
							"DOJ = " 			+ "'" + usr.getDOJ()   			+ "',"+
							"DOP = " 			+ "'" + usr.getDOP()   			+ "',"+
							"BU = " 			+ "'" + usr.getBU()   			+ "',"+
							"AppMBamt = "		+ ""  + usr.getAppMBamt()		+ "," +
							"UserType = "		+ "'" + usr.getUserType()		+ "',"+
							"Email = " 			+ "'" + usr.getEmail()   		+ "',"+
							"Remarks = " 		+ "'" + usr.getRemarks()   		+ "' "+

							"WHERE EmpCode = " 	+ "'" + usr.getEmpCode() 		+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();

		}catch(SQLException sqle){
			System.out.println("Server [UserControllerImpl]: UPDATE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of updateData Method

	/**
	*	CHECK DATA Exist or Not
	*  @param String Criteria
	*  @return boolean true or false value
	*/

	public boolean isFound(String srchStr)
	{
		System.out.println("\nQuery: "+srchStr);
		try
		{
			rsUser = db.stmt.executeQuery(srchStr);

			if (!rsUser.next())
			{
				Connect();
				return false;
			}
		}catch(SQLException sqle)
		{
			System.out.println("Server [UserControllerImpl]: CHECK DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			JOptionPane.showMessageDialog(null, "Server: RECORD NOT FOUND!");
			return false;
		}

		//Refresh Table...
		Connect();
		return true;
	}//End of isFound Data

	/**
	*	DELETE DATA from Employee Table
	*  @param String Criteria
	*
	*/

	public void DeleteData(String strQuery)
	{
		System.out.println("\nQuery: "+strQuery);
		try
		{
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();
		}catch(SQLException sqle)
		{
			System.out.println("Server [UserControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	SEARCH DATA from Employee Table
	*  @param String Criteria
	*  @return User Class Object
	*/

	public User SearchData(String srchStr)
	{
		usr = new User();

		if (srchStr.equals("")) return usr;
		else
		{
			//System.out.println("\nQuery: "+srchStr);

			try
			{
				rsUser = db.stmt.executeQuery(srchStr);

				if (rsUser.next())
				{
					setData();
				}

			}catch(SQLException sqle)
			{
				System.out.println("Server [UserControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return usr;
	}//End of Search Data

}//End of UserController Class