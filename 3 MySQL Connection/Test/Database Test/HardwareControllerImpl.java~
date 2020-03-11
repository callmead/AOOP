package beximtex;
/**
* <p>Title: BeximTex, Hardware Manager</p>
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

public class HardwareControllerImpl extends UnicastRemoteObject implements HardwareController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsHardware;
	Hardware hdw;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public HardwareControllerImpl() throws RemoteException
	{}//Constructor

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
				hdw.setTransactionID(rsHardware.getString(1));
				hdw.setEmpCode(rsHardware.getString(2));
				hdw.setDate(sdf.format(rsHardware.getDate(3)));
				hdw.setDescription(rsHardware.getString(4));
				hdw.setNeed(rsHardware.getString(5));
				hdw.setSpec(rsHardware.getString(6));
				hdw.setDeptApp(rsHardware.getString(7));
				hdw.setDeptComm(rsHardware.getString(8));
				hdw.setDeptAppBy(rsHardware.getString(9));
				hdw.setISApp(rsHardware.getString(10));
				hdw.setISComm(rsHardware.getString(11));
				hdw.setISAppBy(rsHardware.getString(12));
				hdw.setJobStatus(rsHardware.getString(13));

			}catch(SQLException sqle)
			{
				System.out.println("Server [HardwareControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [HardwareControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return Hardware Object
	*/

	public Hardware moveFirst()
	{
		hdw = new Hardware();

		try
		{
			rsHardware.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HardwareControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hdw;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return Hardware Object
	*/

	public Hardware movePrevious()
	{
		hdw = new Hardware();

		try
		{
			if (!rsHardware.previous()) rsHardware.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HardwareControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hdw;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return Hardware Object
	*/

	public Hardware moveNext()
	{
		hdw = new Hardware();

		try
		{
			if (!rsHardware.next()) rsHardware.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HardwareControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hdw;
	};

	/**
	*	MOVE TO LAST Record
	*  @return Hardware Object
	*/

	public Hardware moveLast()
	{
		hdw = new Hardware();

		try
		{
			rsHardware.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [HardwareControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return hdw;
	};

	/**
	*	Open Table
	*
	*/

	public void Connect(String EmpCode)
	{
		haveData=false;

		try
		{
			rsHardware=db.stmt.executeQuery("SELECT * FROM Hardware WHERE EmpCode='" + EmpCode + "' AND DeptApp='-' ORDER BY Date;");
			if (rsHardware.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [HardwareControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into Hardware Table
	*  @param Hardware Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(Hardware hdw)
	{
		try
		{
			String strQuery="INSERT INTO Hardware VALUES(" +
							"'" + hdw.getTransactionID()   	+ "',"+
							"'" + hdw.getEmpCode()      	+ "',"+
							"'" + hdw.getDate()    			+ "',"+
							"'" + hdw.getDescription()		+ "',"+
							"'" + hdw.getNeed()   			+ "',"+
							"'" + hdw.getSpec()   			+ "',"+
							"'" + hdw.getDeptApp()      	+ "',"+
							"'" + hdw.getDeptComm()		    + "',"+
							"'" + hdw.getDeptAppBy()	    + "',"+
							"'" + hdw.getISApp()    	  	+ "',"+
							"'" + hdw.getISComm()   	   	+ "',"+
							"'" + hdw.getISAppBy()     		+ "',"+
							"'" + hdw.getJobStatus() 		+ "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle)
		{
			System.out.println("Server [HardwareControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Emp Data Hardware Table
	*  @param Hardware Class Object
	*  @return boolean true or false value
	*/

	public boolean updateEmpData(Hardware hdw)
	{
		try
		{
			String strQuery="UPDATE Hardware SET "		+
							"Description = "    		+ "'" + hdw.getDescription()	+ "',"+
							"Need = "   				+ "'" + hdw.getNeed()    		+ "',"+
							"Spec = "   				+ "'" + hdw.getSpec()    		+ "' "+

							"WHERE TransactionID = "	+ "'" + hdw.getTransactionID()	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle){
			System.out.println("Server [HardwareControllerImpl]: UPDATE EMP DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of updateEmpData Method

	/**
	*	Update Dept Data Hardware Table
	*  @param Hardware Class Object
	*  @return boolean true or false value
	*/

	public boolean updateDeptData(Hardware hdw)
	{
		try
		{
			String strQuery="UPDATE Hardware SET " 	+
							"DeptApp = "      		+ "'" + hdw.getDeptApp()    	+ "'," +
							"DeptComm = " 			+ "'" + hdw.getDeptComm()  		+ "'," +
							"DeptAppBy = " 			+ "'" + hdw.getDeptAppBy() 		+ "'," +

							"WHERE TransactionID = "+ "'" + hdw.getTransactionID() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle){
			System.out.println("Server [HardwareControllerImpl]: UPDATE DEPT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of updateDeptData Method

	/**
	*	Update IS Data Hardware Table
	*  @param Hardware Class Object
	*  @return boolean true or false value
	*/

	public boolean updateISData(Hardware hdw)
	{
		try
		{
			String strQuery="UPDATE Hardware SET " 	+
							"ISApp = " 				+ "'" + hdw.getISApp()   		+ "',"+
							"ISComm = " 			+ "'" + hdw.getISComm()   		+ "',"+
							"ISAppBy = " 			+ "'" + hdw.getISAppBy()  	 	+ "',"+

							"WHERE TransactionID = "+ "'" + hdw.getTransactionID() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle){
			System.out.println("Server [HardwareControllerImpl]: UPDATE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of updateISData Method

	/**
	*	Update Job Data Hardware Table
	*  @param Hardware Class Object
	*  @return boolean true or false value
	*/

	public boolean updateJobData(Hardware hdw)
	{
		try
		{
			String strQuery="UPDATE Hardware SET " 	+
							"JobStatus = "			+ "'" + hdw.getJobStatus() 		+ "' "+

							"WHERE TransactionID = "+ "'" + hdw.getTransactionID() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle){
			System.out.println("Server [HardwareControllerImpl]: UPDATE JOB DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of updateJobData Method

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
			rsHardware = db.stmt.executeQuery(srchStr);

			if (!rsHardware.next())
			{ return false; }
		}catch(SQLException sqle)
		{
			System.out.println("Server [HardwareControllerImpl]: CHECK DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			JOptionPane.showMessageDialog(null, "Server: RECORD NOT FOUND!");
			return false;
		}

		return true;
	}//End of isFound Data

	/**
	*	DELETE DATA from Employee Table
	*  @param String Criteria
	*
	*/

	public void DeleteData(String strQuery)
	{
		System.out.println("\nQuery: "+strQuery);
		try
		{
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle)
		{
			System.out.println("Server [HardwareControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	SEARCH DATA from Employee Table
	*  @param String Criteria
	*  @return Hardware Class Object
	*/

	public Hardware SearchData(String srchStr)
	{
		hdw = new Hardware();

		if (srchStr.equals("")) return hdw;
		else
		{
			//System.out.println("\nQuery: "+srchStr);

			try
			{
				rsHardware = db.stmt.executeQuery(srchStr);

				if (rsHardware.next())
				{
					setData();
				}

			}catch(SQLException sqle)
			{
				System.out.println("Server [HardwareControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return hdw;
	}//End of Search Data

}//End of HardwareController Class