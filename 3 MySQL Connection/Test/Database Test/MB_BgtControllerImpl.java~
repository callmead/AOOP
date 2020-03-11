package beximtex;
/**
* <p>Title: BeximTex, MB_Bgt Manager</p>
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

public class MB_BgtControllerImpl extends UnicastRemoteObject implements MB_BgtController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsBgt;
	MB_Bgt mbbgt;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public MB_BgtControllerImpl() throws RemoteException
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
				mbbgt.setTransactionID(rsBgt.getString(1));
				mbbgt.setBU(rsBgt.getString(2));
				mbbgt.setYear(rsBgt.getString(3));
				mbbgt.setCCC(rsBgt.getString(4));
				mbbgt.setPhoneNo(rsBgt.getString(5));
				mbbgt.setMonthlyExp(rsBgt.getString(6));
				mbbgt.setExpCeiling(rsBgt.getString(7));
				mbbgt.setMonthlyBgt(rsBgt.getString(8));
				mbbgt.setAnnualBgt(rsBgt.getString(9));
				mbbgt.setEmpCode(rsBgt.getString(10));
				mbbgt.setRemarks(rsBgt.getString(11));
			}catch(SQLException sqle)
			{
				System.out.println("Server [MB_BgtControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [MB_BgtControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return MB_Bgt Object
	*/

	public MB_Bgt moveFirst()
	{
		mbbgt = new MB_Bgt();

		try
		{
			rsBgt.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MB_BgtControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbbgt;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return MB_Bgt Object
	*/

	public MB_Bgt movePrevious()
	{
		mbbgt = new MB_Bgt();

		try
		{
			if (!rsBgt.previous()) rsBgt.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MB_BgtControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbbgt;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return MB_Bgt Object
	*/

	public MB_Bgt moveNext()
	{
		mbbgt = new MB_Bgt();

		try
		{
			if (!rsBgt.next()) rsBgt.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MB_BgtControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbbgt;
	};

	/**
	*	MOVE TO LAST Record
	*  @return MB_Bgt Object
	*/

	public MB_Bgt moveLast()
	{
		mbbgt = new MB_Bgt();

		try
		{
			rsBgt.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MB_BgtControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbbgt;
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
			rsBgt=db.stmt.executeQuery("SELECT * FROM MB_Budget ORDER BY Year,PhoneNo;");
			if (rsBgt.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [MB_BgtControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into MB_Budget Table
	*  @param MB_Bgt Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(MB_Bgt mbbgt)
	{

		try
		{
			String strQuery="INSERT INTO MB_Budget VALUES(" +
							"'" + mbbgt.getTransactionID() 	+ "',"+
							"'" + mbbgt.getBU()      		+ "',"+
							"'" + mbbgt.getYear()    		+ "',"+
							"'" + mbbgt.getCCC()			+ "',"+
							"'" + mbbgt.getPhoneNo() 		+ "',"+
							""  + mbbgt.getMonthlyExp()    	+ "," +
							""  + mbbgt.getExpCeiling()     + " ,"+
							""  + mbbgt.getMonthlyBgt()     + ", "+
							""  + mbbgt.getAnnualBgt()      + ", "+
							"'" + mbbgt.getEmpCode()      	+ "',"+
							"'" + mbbgt.getRemarks() 		+ "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [MB_BgtControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Data MB_Budget Table
	*  @param MB_Bgt Class Object
	*  @return boolean true or false value
	*/

	public boolean updateData(MB_Bgt mbbgt)
	{
		try
		{
			String strQuery="UPDATE MB_Budget SET " 	+
							"BU = "						+ "'" + mbbgt.getBU()        		+ "',"+
							"Year = "   	 			+ "'" + mbbgt.getYear()      		+ "',"+
							"CCC = "    				+ "'" + mbbgt.getCCC()				+ "',"+
							"PhoneNo = "		   		+ "'" + mbbgt.getPhoneNo()			+ "',"+
							"MonthlyExp = "    			+ ""  + mbbgt.getMonthlyExp()	   	+ "," +
							"ExpCeiling = " 			+ ""  + mbbgt.getExpCeiling()   	+ "," +
							"MonthlyBudget = " 			+ ""  + mbbgt.getMonthlyBgt()   	+ "," +
							"AnnualBudget = " 				+ ""  + mbbgt.getAnnualBgt() 		+ "," +
							"EmpCode = " 				+ "'" + mbbgt.getEmpCode()   		+ "',"+
							"Remarks = " 				+ "'" + mbbgt.getRemarks()   		+ "' "+

							"WHERE TransactionID = " 	+ "'" + mbbgt.getTransactionID() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();

		}catch(SQLException sqle){
			System.out.println("Server [MB_BgtControllerImpl]: UPDATE DATA Error !!!");
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
			rsBgt = db.stmt.executeQuery(srchStr);

			if (!rsBgt.next())
			{
				Connect();
				return false;
			}
		}catch(SQLException sqle)
		{
			System.out.println("Server [MB_BgtControllerImpl]: CHECK DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			JOptionPane.showMessageDialog(null, "Server: RECORD NOT FOUND!");
			return false;
		}

		//Refresh Table...
		Connect();
		return true;
	}//End of isFound Data

	/**
	*	DELETE DATA from MB_Budget Table
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
			System.out.println("Server [MB_BgtControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	SEARCH DATA from MB_Budget Table
	*  @param String Criteria
	*  @return MB_Bgt Class Object
	*/

	public MB_Bgt SearchData(String srchStr)
	{
		mbbgt = new MB_Bgt();

		if (srchStr.equals("")) return mbbgt;
		else
		{
			//System.out.println("\nQuery: "+srchStr);

			try
			{
				rsBgt = db.stmt.executeQuery(srchStr);

				if (rsBgt.next())
				{
					setData();
				}

			}catch(SQLException sqle)
			{
				System.out.println("Server [MB_BgtControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return mbbgt;
	}//End of Search Data

}//End of MB_BgtController Class