package beximtex;
/**
* <p>Title: BeximTex, HWissue Manager</p>
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

public class HWissueControllerImpl extends UnicastRemoteObject implements HWissueController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsIssue;
	HWissue hwis;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public HWissueControllerImpl() throws RemoteException
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
				hwis.setTransactionID(rsIssue.getString(1));
				hwis.setDate(sdf.format(rsIssue.getDate(2)));
				hwis.setItemCode(rsIssue.getString(3));
				hwis.setItem(rsIssue.getString(4));
				hwis.setIssuedTo(rsIssue.getString(5));
				hwis.setEmpCode(rsIssue.getString(6));
				hwis.setRemarks(rsIssue.getString(7));

			}catch(SQLException sqle)
			{
				System.out.println("Server [HWissueControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [HWissueControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return HWissue Object
	*/

	public HWissue moveFirst()
	{
		hwis = new HWissue();

		try
		{
			rsIssue.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWissueControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwis;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return HWissue Object
	*/

	public HWissue movePrevious()
	{
		hwis = new HWissue();

		try
		{
			if (!rsIssue.previous()) rsIssue.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWissueControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwis;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return HWissue Object
	*/

	public HWissue moveNext()
	{
		hwis = new HWissue();

		try
		{
			if (!rsIssue.next()) rsIssue.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWissueControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwis;
	};

	/**
	*	MOVE TO LAST Record
	*  @return HWissue Object
	*/

	public HWissue moveLast()
	{
		hwis = new HWissue();

		try
		{
			rsIssue.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWissueControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwis;
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
			rsIssue=db.stmt.executeQuery("SELECT * FROM HW_Issue ORDER BY Date;");
			if (rsIssue.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWissueControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into MB_P_Stock Table
	*  @param HWissue Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(HWissue hwis)
	{

		try
		{
			String strQuery="INSERT INTO HW_Issue VALUES(" 	+
							"'" + hwis.getTransactionID()	+ "',"+
							"'" + hwis.getDate()   	 		+ "',"+
							"'" + hwis.getItemCode() 		+ "',"+
							"'" + hwis.getItem()			+ "',"+
							"'" + hwis.getIssuedTo() 		+ "',"+
							"'" + hwis.getEmpCode() 		+ "',"+
							"'" + hwis.getRemarks() 		+ "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [HWissueControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Data MB_P_Stock Table
	*  @param HWissue Class Object
	*  @return boolean true or false value
	*/

	public boolean updateData(HWissue hwis)
	{
		try
		{
			String strQuery="UPDATE HW_Issue SET " 	+
							"ItemCode = "   	 	+ "'" + hwis.getItemCode()  	+ "',"+
							"Item = "    			+ "'" + hwis.getItem()			+ "',"+
							"IssuedTo = "			+ "'" + hwis.getIssuedTo()		+ "',"+
							"Remarks = " 			+ "'" + hwis.getRemarks()   	+ "' "+

							"WHERE TransactionID = "+ "'" + hwis.getTransactionID() +"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();

		}catch(SQLException sqle){
			System.out.println("Server [HWissueControllerImpl]: UPDATE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of updateData Method

	/**
	*	CHECKS DATA Exist or Not
	*  @param String Criteria
	*  @return boolean true or false value
	*/

	public boolean isFound(String srchStr)
	{
		System.out.println("\nQuery: "+srchStr);
		try
		{
			rsIssue = db.stmt.executeQuery(srchStr);

			if (!rsIssue.next())
			{
				Connect();
				return false;
			}
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWissueControllerImpl]: CHDateK DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			JOptionPane.showMessageDialog(null, "Server: RDateORD NOT FOUND!");
			return false;
		}

		//Refresh Table...
		Connect();
		return true;
	}//End of isFound Data

	/**
	*	DELETE DATA from Table
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
			System.out.println("Server [HWissueControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	Updates DATA in Different Tables
	*  @param String Criteria
	*  @return boolean true or false value
	*/

	public void RunUpdate(String strQuery)
	{
		System.out.println("\nQuery: "+strQuery);
		try
		{
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle)
		{
			System.out.println("Server [HWissueControllerImpl]: RUN UPDATE Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}
	}

	/**
	*	SEARCH DATA from Table
	*  @param String Criteria
	*  @return HWissue Class Object
	*/

	public HWissue SearchData(String srchStr)
	{
		hwis = new HWissue();

		if (srchStr.equals("")) return hwis;
		else
		{
			//System.out.println("\nQuery: "+srchStr);

			try
			{
				rsIssue = db.stmt.executeQuery(srchStr);

				if (rsIssue.next())
				{
					setData();
				}

			}catch(SQLException sqle)
			{
				System.out.println("Server [HWissueControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return hwis;
	}//End of Search Data

}//End of HWissueController Class