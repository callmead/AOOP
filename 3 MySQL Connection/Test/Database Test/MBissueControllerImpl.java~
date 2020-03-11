package beximtex;
/**
* <p>Title: BeximTex, MBissue Manager</p>
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

public class MBissueControllerImpl extends UnicastRemoteObject implements MBissueController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsIssue;
	MBissue mbis;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public MBissueControllerImpl() throws RemoteException
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
				mbis.setTransactionID(rsIssue.getString(1));
				mbis.setDate(sdf.format(rsIssue.getDate(2)));
				mbis.setIssueType(rsIssue.getString(3));
				mbis.setIssueTo(rsIssue.getString(4));
				mbis.setSetOwner(rsIssue.getString(5));
				mbis.setSetID(rsIssue.getString(6));
				mbis.setSetName(rsIssue.getString(7));
				mbis.setPhoneNo(rsIssue.getString(8));
				mbis.setReturnDate(sdf.format(rsIssue.getDate(9)));
				mbis.setCCC(rsIssue.getString(10));
				mbis.setEmpCode(rsIssue.getString(11));
				mbis.setRemarks(rsIssue.getString(12));

			}catch(SQLException sqle)
			{
				System.out.println("Server [MBissueControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [MBissueControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return MBissue Object
	*/

	public MBissue moveFirst()
	{
		mbis = new MBissue();

		try
		{
			rsIssue.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBissueControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbis;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return MBissue Object
	*/

	public MBissue movePrevious()
	{
		mbis = new MBissue();

		try
		{
			if (!rsIssue.previous()) rsIssue.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBissueControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbis;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return MBissue Object
	*/

	public MBissue moveNext()
	{
		mbis = new MBissue();

		try
		{
			if (!rsIssue.next()) rsIssue.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBissueControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbis;
	};

	/**
	*	MOVE TO LAST Record
	*  @return MBissue Object
	*/

	public MBissue moveLast()
	{
		mbis = new MBissue();

		try
		{
			rsIssue.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBissueControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbis;
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
			rsIssue=db.stmt.executeQuery("SELECT * FROM MB_Issue ORDER BY TransactionID;");
			if (rsIssue.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBissueControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into MB_P_Stock Table
	*  @param MBissue Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(MBissue mbis)
	{

		try
		{
			String strQuery="INSERT INTO MB_Issue VALUES(" 	+
							"'" + mbis.getTransactionID()	+ "',"+
							"'" + mbis.getDate()   	 		+ "',"+
							"'" + mbis.getIssueType() 		+ "',"+
							"'" + mbis.getIssueTo()			+ "',"+
							"'" + mbis.getSetOwner() 		+ "',"+
							"'" + mbis.getSetID()    		+ "',"+
							"'" + mbis.getSetName()    		+ "',"+
							"'" + mbis.getPhoneNo()    		+ "',"+
							"'" + mbis.getReturnDate()  	+ "',"+
							"'" + mbis.getCCC() 			+ "',"+
							"'" + mbis.getEmpCode() 		+ "',"+
							"'" + mbis.getRemarks() 		+ "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [MBissueControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Data MB_P_Stock Table
	*  @param MBissue Class Object
	*  @return boolean true or false value
	*/

	public boolean updateData(MBissue mbis)
	{
		try
		{
			String strQuery="UPDATE MB_Issue SET " 	+
							"Date = "				+ "'" + mbis.getDate()     		+ "',"+
							"IssueType = "   	 	+ "'" + mbis.getIssueType()  	+ "',"+
							"IssueTo = "    		+ "'" + mbis.getIssueTo()		+ "',"+
							"SetOwner = "			+ "'" + mbis.getSetOwner()		+ "',"+
							"SetID = "    			+ "'" + mbis.getSetID()	 	  	+ "',"+
							"SetName = " 			+ "'" + mbis.getSetName()		+ "',"+
							"PhoneNo = "		 	+ "'" + mbis.getPhoneNo()   	+ "',"+
							"ReturnDate = "	 		+ "'" + mbis.getReturnDate()	+ "',"+
							"CCC = "	 			+ "'" + mbis.getCCC() 			+ "',"+
							"EmpCode = " 			+ "'" + mbis.getEmpCode()   	+ "',"+
							"Remarks = " 			+ "'" + mbis.getRemarks()   	+ "' "+

							"WHERE TransactionID = "+ "'" + mbis.getTransactionID() +"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();

		}catch(SQLException sqle){
			System.out.println("Server [MBissueControllerImpl]: UPDATE DATA Error !!!");
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
			System.out.println("Server [MBissueControllerImpl]: CHDateK DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			JOptionPane.showMessageDialog(null, "Server: RDateORD NOT FOUND!");
			return false;
		}

		//Refresh Table...
		Connect();
		return true;
	}//End of isFound Data

	/**
	*	DELETE DATA from MB_P_Stock Table
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
			System.out.println("Server [MBissueControllerImpl]: DELETE DATA Error !!!");
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
			System.out.println("Server [MBissueControllerImpl]: RUN UPDATE Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}
	}

	/**
	*	SEARCH DATA from Table
	*  @param String Criteria
	*  @return MBissue Class Object
	*/

	public MBissue SearchData(String srchStr)
	{
		mbis = new MBissue();

		if (srchStr.equals("")) return mbis;
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
				System.out.println("Server [MBissueControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return mbis;
	}//End of Search Data

}//End of MBissueController Class