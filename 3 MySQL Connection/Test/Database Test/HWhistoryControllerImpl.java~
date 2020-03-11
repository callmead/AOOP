package beximtex;
/**
* <p>Title: BeximTex, HWhistory Manager</p>
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

public class HWhistoryControllerImpl extends UnicastRemoteObject implements HWhistoryController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsHist;
	HWhistory hwh;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public HWhistoryControllerImpl() throws RemoteException
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
				hwh.setSNo(rsHist.getString(1));
				hwh.setItemCode(rsHist.getString(2));
				hwh.setDate(rsHist.getString(3));
				hwh.setEmpCode(rsHist.getString(4));

			}catch(SQLException sqle)
			{
				System.out.println("Server [HWhistoryControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [HWhistoryControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return HWhistory Object
	*/

	public HWhistory moveFirst()
	{
		hwh = new HWhistory();

		try
		{
			rsHist.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWhistoryControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwh;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return HWhistory Object
	*/

	public HWhistory movePrevious()
	{
		hwh = new HWhistory();

		try
		{
			if (!rsHist.previous()) rsHist.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWhistoryControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwh;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return HWhistory Object
	*/

	public HWhistory moveNext()
	{
		hwh = new HWhistory();

		try
		{
			if (!rsHist.next()) rsHist.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWhistoryControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwh;
	};

	/**
	*	MOVE TO LAST Record
	*  @return HWhistory Object
	*/

	public HWhistory moveLast()
	{
		hwh = new HWhistory();

		try
		{
			rsHist.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWhistoryControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwh;
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
			rsHist=db.stmt.executeQuery("SELECT * FROM HW_History ORDER BY SNo;");
			if (rsHist.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWhistoryControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into HW_History Table
	*  @param HWhistory Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(HWhistory hwh)
	{

		try
		{
			String strQuery="INSERT INTO HW_History (ItemCode,Date,EmpCode) VALUES (" +
							"'" + hwh.getItemCode() + "',"+
							"'" + hwh.getDate()   	+ "',"+
							"'" + hwh.getEmpCode() 	+ "')";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [HWhistoryControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

}//End of HWhistoryController Class