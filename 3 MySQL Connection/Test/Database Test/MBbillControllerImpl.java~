package beximtex;
/**
* <p>Title: BeximTex, MBbill Manager</p>
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

public class MBbillControllerImpl extends UnicastRemoteObject implements MBbillController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsBill;
	MBbill mbb;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public MBbillControllerImpl() throws RemoteException
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
				mbb.setTransactionID(rsBill.getString(1));
				mbb.setEC(rsBill.getString(2));
				mbb.setDate(sdf.format(rsBill.getDate(3)));
				mbb.setCP(rsBill.getString(4));
				mbb.setName(rsBill.getString(5));
				mbb.setMobileNo(rsBill.getString(6));
				mbb.setYear(rsBill.getString(7));
				mbb.setMonth(rsBill.getString(8));
				mbb.setAmount(rsBill.getString(9));
				mbb.setApproved(rsBill.getString(10));
				mbb.setBalance(rsBill.getString(11));
				mbb.setEmpCode(rsBill.getString(12));
				mbb.setRemarks(rsBill.getString(13));

			}catch(SQLException sqle)
			{
				System.out.println("Server [MBbillControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [MBbillControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return MBbill Object
	*/

	public MBbill moveFirst()
	{
		mbb = new MBbill();

		try
		{
			rsBill.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBbillControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbb;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return MBbill Object
	*/

	public MBbill movePrevious()
	{
		mbb = new MBbill();

		try
		{
			if (!rsBill.previous()) rsBill.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBbillControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbb;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return MBbill Object
	*/

	public MBbill moveNext()
	{
		mbb = new MBbill();

		try
		{
			if (!rsBill.next()) rsBill.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBbillControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbb;
	};

	/**
	*	MOVE TO LAST Record
	*  @return MBbill Object
	*/

	public MBbill moveLast()
	{
		mbb = new MBbill();

		try
		{
			rsBill.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBbillControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbb;
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
			rsBill=db.stmt.executeQuery("SELECT * FROM MB_Bill ORDER BY Name,Year,Month;");
			if (rsBill.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBbillControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into MB_P_Stock Table
	*  @param MBbill Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(MBbill mbb)
	{

		try
		{
			String strQuery="INSERT INTO MB_Bill VALUES(" +
							"'" + mbb.getTransactionID()+ "',"+
							"'" + mbb.getEC()   	 	+ "',"+
							"'" + mbb.getDate() 		+ "',"+
							"'" + mbb.getCP()			+ "',"+
							"'" + mbb.getName() 		+ "',"+
							"'" + mbb.getMobileNo()    	+ "',"+
							"'" + mbb.getYear()    		+ "',"+
							"'" + mbb.getMonth()    	+ "',"+
							""  + mbb.getAmount()    	+ "," +
							""  + mbb.getApproved() 	+ "," +
							""  + mbb.getBalance()  	+ "," +
							"'" + mbb.getEmpCode() 		+ "',"+
							"'" + mbb.getRemarks() 		+ "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [MBbillControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Data MB_P_Stock Table
	*  @param MBbill Class Object
	*  @return boolean true or false value
	*/

	public boolean updateData(MBbill mbb)
	{
		try
		{
			String strQuery="UPDATE MB_Bill SET " 	+
							"EC = "					+ "'" + mbb.getEC()     		+ "',"+
							"Date = "   	 		+ "'" + mbb.getDate()   		+ "',"+
							"CP = "    				+ "'" + mbb.getCP()				+ "',"+
							"Name = "		   		+ "'" + mbb.getName()			+ "',"+
							"MobileNo = "    		+ "'" + mbb.getMobileNo()	   	+ "',"+
							"Year = " 				+ "'" + mbb.getYear()  			+ "',"+
							"Month = "		 		+ "'" + mbb.getMonth()   		+ "',"+
							"Amount = "	 			+ ""  + mbb.getAmount() 		+ "," +
							"Approved = "	 		+ ""  + mbb.getApproved() 		+ "," +
							"Balance = "	 		+ ""  + mbb.getBalance() 		+ "," +
							"EmpCode = " 			+ "'" + mbb.getEmpCode()   		+ "',"+
							"Remarks = " 			+ "'" + mbb.getRemarks()   		+ "' "+

							"WHERE TransactionID = "+ "'" + mbb.getTransactionID() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();

		}catch(SQLException sqle){
			System.out.println("Server [MBbillControllerImpl]: UPDATE DATA Error !!!");
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
			rsBill = db.stmt.executeQuery(srchStr);

			if (!rsBill.next())
			{
				Connect();
				return false;
			}
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBbillControllerImpl]: CHECK DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			JOptionPane.showMessageDialog(null, "Server: RECORD NOT FOUND!");
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
			System.out.println("Server [MBbillControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	SEARCH DATA from MB_P_Stock Table
	*  @param String Criteria
	*  @return MBbill Class Object
	*/

	public MBbill SearchData(String srchStr)
	{
		mbb = new MBbill();

		if (srchStr.equals("")) return mbb;
		else
		{
			//System.out.println("\nQuery: "+srchStr);

			try
			{
				rsBill = db.stmt.executeQuery(srchStr);

				if (rsBill.next())
				{
					setData();
				}

			}catch(SQLException sqle)
			{
				System.out.println("Server [MBbillControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return mbb;
	}//End of Search Data

}//End of MBbillController Class