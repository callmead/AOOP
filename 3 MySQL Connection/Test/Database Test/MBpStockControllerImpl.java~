package beximtex;
/**
* <p>Title: BeximTex, MBpStock Manager</p>
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

public class MBpStockControllerImpl extends UnicastRemoteObject implements MBpStockController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsStock;
	MBpStock mbps;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public MBpStockControllerImpl() throws RemoteException
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
				mbps.setSetID(rsStock.getString(1));
				mbps.setDate(sdf.format(rsStock.getDate(2)));
				mbps.setSetName(rsStock.getString(3));
				mbps.setBrand(rsStock.getString(4));
				mbps.setModel(rsStock.getString(5));
				mbps.setSNo(rsStock.getString(6));
				mbps.setQuality(rsStock.getString(7));
				mbps.setIssued(rsStock.getString(8));
				mbps.setWarranty(rsStock.getString(9));
				mbps.setEmpCode(rsStock.getString(10));
				mbps.setRemarks(rsStock.getString(11));
			}catch(SQLException sqle)
			{
				System.out.println("Server [MBpStockControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [MBpStockControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return MBpStock Object
	*/

	public MBpStock moveFirst()
	{
		mbps = new MBpStock();

		try
		{
			rsStock.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBpStockControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbps;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return MBpStock Object
	*/

	public MBpStock movePrevious()
	{
		mbps = new MBpStock();

		try
		{
			if (!rsStock.previous()) rsStock.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBpStockControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbps;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return MBpStock Object
	*/

	public MBpStock moveNext()
	{
		mbps = new MBpStock();

		try
		{
			if (!rsStock.next()) rsStock.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBpStockControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbps;
	};

	/**
	*	MOVE TO LAST Record
	*  @return MBpStock Object
	*/

	public MBpStock moveLast()
	{
		mbps = new MBpStock();

		try
		{
			rsStock.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBpStockControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return mbps;
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
			rsStock=db.stmt.executeQuery("SELECT * FROM MB_P_Stock ORDER BY SetID;");
			if (rsStock.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBpStockControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into MB_P_Stock Table
	*  @param MBpStock Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(MBpStock mbps)
	{

		try
		{
			String strQuery="INSERT INTO MB_P_Stock VALUES(" +
							"'" + mbps.getSetID() 	+ "',"+
							"'" + mbps.getDate()    + "',"+
							"'" + mbps.getSetName() + "',"+
							"'" + mbps.getBrand()	+ "',"+
							"'" + mbps.getModel() 	+ "',"+
							"'" + mbps.getSNo()    	+ "',"+
							"'" + mbps.getQuality() + "',"+
							"'" + mbps.getIssued()  + "',"+
							"'" + mbps.getWarranty()+ "',"+
							"'" + mbps.getEmpCode() + "',"+
							"'" + mbps.getRemarks() + "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [MBpStockControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Data MB_P_Stock Table
	*  @param MBpStock Class Object
	*  @return boolean true or false value
	*/

	public boolean updateData(MBpStock mbps)
	{
		try
		{
			String strQuery="UPDATE MB_P_Stock SET " 	+
							"Date = "					+ "'" + mbps.getDate()      + "',"+
							"SetName = "   	 			+ "'" + mbps.getSetName()   + "',"+
							"Brand = "    				+ "'" + mbps.getBrand()		+ "',"+
							"Model = "		   			+ "'" + mbps.getModel()		+ "',"+
							"SNo = "    				+ "'" + mbps.getSNo()	   	+ "',"+
							"Quality = " 				+ "'" + mbps.getQuality()  	+ "',"+
							"Issued = "		 			+ "'" + mbps.getIssued()   	+ "',"+
							"Warranty = "	 			+ "'" + mbps.getWarranty() 	+ "',"+
							"EmpCode = " 				+ "'" + mbps.getEmpCode()   + "',"+
							"Remarks = " 				+ "'" + mbps.getRemarks()   + "' "+

							"WHERE SetID = " 	+ "'" + mbps.getSetID() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();

		}catch(SQLException sqle){
			System.out.println("Server [MBpStockControllerImpl]: UPDATE DATA Error !!!");
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
			rsStock = db.stmt.executeQuery(srchStr);

			if (!rsStock.next())
			{
				Connect();
				return false;
			}
		}catch(SQLException sqle)
		{
			System.out.println("Server [MBpStockControllerImpl]: CHECK DATA Error !!!");
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
			System.out.println("Server [MBpStockControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	SEARCH DATA from MB_P_Stock Table
	*  @param String Criteria
	*  @return MBpStock Class Object
	*/

	public MBpStock SearchData(String srchStr)
	{
		mbps = new MBpStock();

		if (srchStr.equals("")) return mbps;
		else
		{
			//System.out.println("\nQuery: "+srchStr);

			try
			{
				rsStock = db.stmt.executeQuery(srchStr);

				if (rsStock.next())
				{
					setData();
				}

			}catch(SQLException sqle)
			{
				System.out.println("Server [MBpStockControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return mbps;
	}//End of Search Data

}//End of MBpStockController Class