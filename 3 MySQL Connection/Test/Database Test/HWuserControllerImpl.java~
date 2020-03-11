package beximtex;
/**
* <p>Title: BeximTex, HWuser Manager</p>
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

public class HWuserControllerImpl extends UnicastRemoteObject implements HWuserController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsStock;
	HWuser hwusr;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public HWuserControllerImpl() throws RemoteException
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
				hwusr.setEmpCode(rsStock.getString(1));
				hwusr.setDate(sdf.format(rsStock.getDate(2)));
				hwusr.setBIOS_PW(rsStock.getString(3));
				hwusr.setBIOS_SPW(rsStock.getString(4));
				hwusr.setIP(rsStock.getString(5));
				hwusr.setSubnet(rsStock.getString(6));
				hwusr.setNetworkID(rsStock.getString(7));
				hwusr.setNTDomain(rsStock.getString(8));
				hwusr.setDNS(rsStock.getString(9));
				hwusr.setGW(rsStock.getString(10));
				hwusr.setOS(rsStock.getString(11));
				hwusr.setIE(rsStock.getString(12));
				hwusr.setMessenger(rsStock.getString(13));
				hwusr.setEmail(rsStock.getString(14));
				hwusr.setDatatex(rsStock.getString(15));
				hwusr.setIFM(rsStock.getString(16));
				hwusr.setRemarks(rsStock.getString(17));

			}catch(SQLException sqle)
			{
				System.out.println("Server [HWuserControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [HWuserControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return HWuser Object
	*/

	public HWuser moveFirst()
	{
		hwusr = new HWuser();

		try
		{
			rsStock.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWuserControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwusr;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return HWuser Object
	*/

	public HWuser movePrevious()
	{
		hwusr = new HWuser();

		try
		{
			if (!rsStock.previous()) rsStock.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWuserControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwusr;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return HWuser Object
	*/

	public HWuser moveNext()
	{
		hwusr = new HWuser();

		try
		{
			if (!rsStock.next()) rsStock.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWuserControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwusr;
	};

	/**
	*	MOVE TO LAST Record
	*  @return HWuser Object
	*/

	public HWuser moveLast()
	{
		hwusr = new HWuser();

		try
		{
			rsStock.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWuserControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hwusr;
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
			rsStock=db.stmt.executeQuery("SELECT * FROM HW_Users ORDER BY EmpCode;");
			if (rsStock.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [HWuserControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into  Table
	*  @param HWuser Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(HWuser hwusr)
	{

		try
		{
			String strQuery="INSERT INTO HW_Users VALUES("+
							"'" + hwusr.getEmpCode()		+ "',"+
							"'" + hwusr.getDate()    		+ "',"+
							"'" + hwusr.getBIOS_PW() 		+ "',"+
							"'" + hwusr.getBIOS_SPW()		+ "',"+
							"'" + hwusr.getIP() 			+ "',"+
							"'" + hwusr.getSubnet()    		+ "',"+
							"'" + hwusr.getNetworkID()    	+ "',"+
							"'" + hwusr.getNTDomain()    	+ "',"+
							"'" + hwusr.getDNS()    		+ "',"+
							"'" + hwusr.getGW() 			+ "',"+
							"'" + hwusr.getOS()  			+ "',"+
							"'" + hwusr.getIE() 			+ "',"+
							"'" + hwusr.getMessenger()		+ "',"+
							"'" + hwusr.getEmail() 			+ "',"+
							"'" + hwusr.getDatatex() 		+ "',"+
							"'" + hwusr.getIFM() 			+ "',"+
							"'" + hwusr.getRemarks() 		+ "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [HWuserControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Data  Table
	*  @param HWuser Class Object
	*  @return boolean true or false value
	*/

	public boolean updateData(HWuser hwusr)
	{
		try
		{
			String strQuery="UPDATE HW_Users SET " 	+
							"BIOS_PW = "   	 		+ "'" + hwusr.getBIOS_PW()   	+ "',"+
							"BIOS_SPW = "    		+ "'" + hwusr.getBIOS_SPW()		+ "',"+
							"IP = "		   			+ "'" + hwusr.getIP()			+ "',"+
							"Subnet = "    			+ "'" + hwusr.getSubnet()	   	+ "',"+
							"NetworkID = " 			+ "'" + hwusr.getNetworkID()  	+ "',"+
							"NTDomain = "			+ "'" + hwusr.getNTDomain()   	+ "',"+
							"DNS = "	 			+ "'" + hwusr.getDNS() 			+ "',"+
							"GW = "	 				+ "'" + hwusr.getGW() 			+ "',"+
							"OS = "	 				+ "'" + hwusr.getOS() 			+ "',"+
							"IE = " 				+ "'" + hwusr.getIE()   		+ "',"+
							"Messenger = " 			+ "'" + hwusr.getMessenger()	+ "',"+
							"Email = " 				+ "'" + hwusr.getEmail()   		+ "',"+
							"Datatex="       		+ "'" + hwusr.getDatatex() 		+ "',"+
							"IFM="           		+ "'" + hwusr.getIFM()   		+ "',"+
							"Remarks="       		+ "'" + hwusr.getRemarks() 		+ "' "+

							"WHERE EmpCode = " 		+ "'" + hwusr.getEmpCode() 		+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();

		}catch(SQLException sqle){
			System.out.println("Server [HWuserControllerImpl]: UPDATE DATA Error !!!");
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
			System.out.println("Server [HWuserControllerImpl]: CHECK DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			JOptionPane.showMessageDialog(null, "Server: RECORD NOT FOUND!");
			return false;
		}

		//Refresh Table...
		Connect();
		return true;
	}//End of isFound Data

	/**
	*	DELETE DATA from  Table
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
			System.out.println("Server [HWuserControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	SEARCH DATA from  Table
	*  @param String Criteria
	*  @return HWuser Class Object
	*/

	public HWuser SearchData(String srchStr)
	{
		hwusr = new HWuser();

		if (srchStr.equals("")) return hwusr;
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
				System.out.println("Server [HWuserControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return hwusr;
	}//End of Search Data

}//End of HWuserController Class