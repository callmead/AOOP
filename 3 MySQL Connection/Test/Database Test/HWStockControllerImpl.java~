package beximtex;
/**
* <p>Title: BeximTex, HWStock Manager</p>
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

public class HWStockControllerImpl extends UnicastRemoteObject implements HWStockController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsStock;
	HWStock hws;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public HWStockControllerImpl() throws RemoteException
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
				hws.setItemCode(rsStock.getString(1));
				hws.setDate(sdf.format(rsStock.getDate(2)));
				hws.setItem(rsStock.getString(3));
				hws.setBrand(rsStock.getString(4));
				hws.setSerial(rsStock.getString(5));
				hws.setCapacity(rsStock.getString(6));
				hws.setMB(rsStock.getString(7));
				hws.setSpeed(rsStock.getString(8));
				hws.setCPUType(rsStock.getString(9));
				hws.setQuality(rsStock.getString(10));
				hws.setIssued(rsStock.getString(11));
				hws.setEmpCode(rsStock.getString(12));
				hws.setWarranty(rsStock.getString(13));
				hws.setRemarks(rsStock.getString(14));

			}catch(SQLException sqle)
			{
				System.out.println("Server [HWStockControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [HWStockControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return HWStock Object
	*/

	public HWStock moveFirst()
	{
		hws = new HWStock();

		try
		{
			rsStock.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWStockControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hws;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return HWStock Object
	*/

	public HWStock movePrevious()
	{
		hws = new HWStock();

		try
		{
			if (!rsStock.previous()) rsStock.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWStockControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hws;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return HWStock Object
	*/

	public HWStock moveNext()
	{
		hws = new HWStock();

		try
		{
			if (!rsStock.next()) rsStock.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWStockControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hws;
	};

	/**
	*	MOVE TO LAST Record
	*  @return HWStock Object
	*/

	public HWStock moveLast()
	{
		hws = new HWStock();

		try
		{
			rsStock.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWStockControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hws;
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
			rsStock=db.stmt.executeQuery("SELECT * FROM HW_Stock ORDER BY ItemCode;");
			if (rsStock.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWStockControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into MB_P_Stock Table
	*  @param HWStock Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(HWStock hws)
	{

		try
		{
			String strQuery="INSERT INTO HW_Stock VALUES(" +
							"'" + hws.getItemCode()		+ "',"+
							"'" + hws.getDate()    		+ "',"+
							"'" + hws.getItem() 		+ "',"+
							"'" + hws.getBrand()		+ "',"+
							"'" + hws.getSerial() 		+ "',"+
							"'" + hws.getCapacity()    	+ "',"+
							"'" + hws.getMB()    		+ "',"+
							"'" + hws.getSpeed()    	+ "',"+
							"'" + hws.getCPUType()    	+ "',"+
							"'" + hws.getQuality() 		+ "',"+
							"'" + hws.getIssued()  		+ "',"+
							"'" + hws.getEmpCode() 		+ "',"+
							"'" + hws.getWarranty()		+ "',"+
							"'" + hws.getRemarks() 		+ "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [HWStockControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Data MB_P_Stock Table
	*  @param HWStock Class Object
	*  @return boolean true or false value
	*/

	public boolean updateData(HWStock hws)
	{
		try
		{
			String strQuery="UPDATE HW_Stock SET " 	+
							"Item = "   	 		+ "'" + hws.getItem()   	+ "',"+
							"Brand = "    			+ "'" + hws.getBrand()		+ "',"+
							"Serial = "		   		+ "'" + hws.getSerial()		+ "',"+
							"Capacity = "    		+ "'" + hws.getCapacity()  	+ "',"+
							"MB = " 				+ "'" + hws.getMB()  		+ "',"+
							"Speed = "		 		+ "'" + hws.getSpeed()   	+ "',"+
							"CPUType = "	 		+ "'" + hws.getCPUType() 	+ "',"+
							"Quality = "	 		+ "'" + hws.getQuality() 	+ "',"+
							"Issued = "	 			+ "'" + hws.getIssued()		+ "',"+
							"EmpCode = " 			+ "'" + hws.getEmpCode()   	+ "',"+
							"Warranty = " 			+ "'" + hws.getWarranty()  	+ "',"+
							"Remarks = " 			+ "'" + hws.getRemarks()   	+ "' "+

							"WHERE ItemCode = " 	+ "'" + hws.getItemCode() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();

		}catch(SQLException sqle){
			System.out.println("Server [HWStockControllerImpl]: UPDATE DATA Error !!!");
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
			System.out.println("Server [HWStockControllerImpl]: CHECK DATA Error !!!");
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
			System.out.println("Server [HWStockControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	SEARCH DATA from MB_P_Stock Table
	*  @param String Criteria
	*  @return HWStock Class Object
	*/

	public HWStock SearchData(String srchStr)
	{
		hws = new HWStock();

		if (srchStr.equals("")) return hws;
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
				System.out.println("Server [HWStockControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return hws;
	}//End of Search Data

}//End of HWStockController Class