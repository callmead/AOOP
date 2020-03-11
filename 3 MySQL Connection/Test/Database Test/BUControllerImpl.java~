package beximtex;
/**
* <p>Title: BeximTex, BU Manager</p>
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

public class BUControllerImpl extends UnicastRemoteObject implements BUController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsBU;
	BU buu;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public BUControllerImpl() throws RemoteException
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
			buu.setBU(rsBU.getString(1));
		}catch(SQLException sqle)
		{
			System.out.println("Server [BUControllerImpl] : SET DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return BU Object
	*/

	public BU moveFirst()
	{
		buu = new BU();

		try
		{
			rsBU.first();
			setData();

		}catch(SQLException sqle)
		{
			System.out.println("Server [BUControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return buu;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return BU Object
	*/

	public BU movePrevious()
	{
		buu = new BU();

		try
		{
			if (!rsBU.previous()) rsBU.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [BUControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return buu;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return BU Object
	*/

	public BU moveNext()
	{
		buu = new BU();

		try
		{
			if (!rsBU.next()) rsBU.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [BUControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return buu;
	};

	/**
	*	MOVE TO LAST Record
	*  @return BU Object
	*/

	public BU moveLast()
	{
		buu = new BU();

		try
		{
			rsBU.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [BUControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return buu;
	};

	/**
	*	Open Table
	*
	*/

	public void Connect()
	{
		try
		{
			rsBU=db.stmt.executeQuery("SELECT * FROM BU ORDER BY BU;");

		}catch(SQLException sqle)
		{
			System.out.println("Server [BUControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}
	}

	/**
	*	Insert Data into BU Table
	*  @param BU Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(BU buu)
	{

		try
		{
			String strQuery="INSERT INTO BU VALUES ('" + buu.getBU() + "')";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [BUControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method


	/**
	*	UPDATE DATA from BU Table
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
			System.out.println("Server [BUControllerImpl]: UPDATE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Update Data

	/**
	*	DELETE DATA from BU Table
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
			System.out.println("Server [BUControllerImpl]: UPDATE DATA Error !!!");
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
			rsBU = db.stmt.executeQuery(srchStr);

			if (!rsBU.next())
			{
				Connect();
				return false;
			}
		}catch(SQLException sqle)
		{
			System.out.println("Server [BUControllerImpl]: CHECK DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			JOptionPane.showMessageDialog(null, "Server [BUControllerImpl]: RECORD NOT FOUND!");
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

	public BU SearchData(String srchStr)
	{//SearchData

		buu = new BU();

		if (srchStr.equals("")) return buu;
		else
		{
			//System.out.println("\nQuery: "+srchStr);

			try
			{
				rsBU = db.stmt.executeQuery(srchStr);

				if (rsBU.next())
				{
					setData();
				}

			}catch(SQLException sqle)
			{
				System.out.println("Server [BUControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return buu;
	}//End of Search Data

}//End of BUController Class