package beximtex;
/**
* <p>Title: BeximTex, Department Manager</p>
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

public class DepartmentControllerImpl extends UnicastRemoteObject implements DepartmentController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsDepartment;
	Department dep;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public DepartmentControllerImpl() throws RemoteException
	{
		Connect();
	}//End of Constructor

	/**
	*	Gets Data from Resultset Sets Data
	*
	*/

	public void setData()
	{
		try
		{
			dep.setDepartment(rsDepartment.getString(1));
		}catch(SQLException sqle)
		{
			System.out.println("Server [DepartmentControllerImpl] : SET DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return Department Object
	*/

	public Department moveFirst()
	{
		dep = new Department();

		try
		{
			rsDepartment.first();

		}catch(SQLException sqle)
		{
			System.out.println("Server [DepartmentControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return dep;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return Department Object
	*/

	public Department movePrevious()
	{
		dep = new Department();

		try
		{
			if (!rsDepartment.previous()) rsDepartment.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [DepartmentControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return dep;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return Department Object
	*/

	public Department moveNext()
	{
		dep = new Department();

		try
		{
			if (!rsDepartment.next()) rsDepartment.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [DepartmentControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return dep;
	};

	/**
	*	MOVE TO LAST Record
	*  @return Department Object
	*/

	public Department moveLast()
	{
		dep = new Department();

		try
		{
			rsDepartment.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [DepartmentControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return dep;
	};

	/**
	*	Open Table
	*
	*/

	public void Connect()
	{
		try
		{
			rsDepartment=db.stmt.executeQuery("SELECT * FROM Dept ORDER BY Department;");

		}catch(SQLException sqle)
		{
			System.out.println("Server [DepartmentControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}
	}

	/**
	*	Insert Data into Department Table
	*  @param Department Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(Department dep)
	{

		try
		{
			String strQuery="INSERT INTO Dept VALUES ('" + dep.getDepartment() + "')";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [DepartmentControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method


	/**
	*	UPDATE DATA from Department Table
	*  @param String Criteria
	*
	*/

	public void UpdateData(String strQuery)
	{//Update Data
		System.out.println("\nQuery: "+strQuery);
		try
		{
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();
		}catch(SQLException sqle)
		{
			System.out.println("Server [DepartmentControllerImpl]: UPDATE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Update Data

	/**
	*	DELETE DATA from Department Table
	*  @param String Criteria
	*
	*/

	public void DeleteData(String strQuery)
	{//Delete Data

		System.out.println("\nQuery: "+strQuery);
		try
		{
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();
		}catch(SQLException sqle)
		{
			System.out.println("Server [DepartmentControllerImpl]: UPDATE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	CHECK DATA Exist or Not
	*  @param String Criteria
	*  @return boolean true or false value
	*/

	public boolean isFound(String srchStr)
	{//isFound
		System.out.println("\nQuery: "+srchStr);
		try
		{
			rsDepartment = db.stmt.executeQuery(srchStr);

			if (!rsDepartment.next())
			{
				Connect();
				return false;
			}
		}catch(SQLException sqle)
		{
			System.out.println("Server [DepartmentControllerImpl]: CHECK DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			JOptionPane.showMessageDialog(null, "Server [DepartmentControllerImpl]: RECORD NOT FOUND!");
			return false;
		}

		//Refresh Table...
		Connect();
		return true;

	}//End of isFound Data

	/**
	*	SEARCH DATA from Security Table
	*  @param String Criteria
	*  @return User Class Object
	*/

	public Department SearchData(String srchStr)
	{//SearchData

		dep = new Department();

		if (srchStr.equals("")) return dep;
		else
		{
			//System.out.println("\nQuery: "+srchStr);

			try
			{
				rsDepartment = db.stmt.executeQuery(srchStr);

				if (rsDepartment.next())
				{
					setData();
				}

			}catch(SQLException sqle)
			{
				System.out.println("Server [DepartmentControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return dep;
	}//End of Search Data

}//End of DepartmentController Class