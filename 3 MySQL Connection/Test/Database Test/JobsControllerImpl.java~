package beximtex;
/**
* <p>Title: BeximTex, Jobs Manager</p>
* <p>RequestID: Support Jobs System</p>
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

public class JobsControllerImpl extends UnicastRemoteObject implements JobsController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsJobs;
	Jobs jobb;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public JobsControllerImpl() throws RemoteException
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
				jobb.setTransactionID(rsJobs.getString(1));
				jobb.setDate(sdf.format(rsJobs.getDate(2)));
				jobb.setRequestID(rsJobs.getString(3));
				jobb.setReqFrom(rsJobs.getString(4));
				jobb.setEmpCode(rsJobs.getString(5));
				jobb.setStatus(rsJobs.getString(6));
				jobb.setSID(rsJobs.getString(7));
				jobb.setRemarks(rsJobs.getString(8));

			}catch(SQLException sqle)
			{
				System.out.println("Server [JobsControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [JobsControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return Jobs Object
	*/

	public Jobs moveFirst()
	{
		jobb = new Jobs();

		try
		{
			rsJobs.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [JobsControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return jobb;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return Jobs Object
	*/

	public Jobs movePrevious()
	{
		jobb = new Jobs();

		try
		{
			if (!rsJobs.previous()) rsJobs.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [JobsControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return jobb;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return Jobs Object
	*/

	public Jobs moveNext()
	{
		jobb = new Jobs();

		try
		{
			if (!rsJobs.next()) rsJobs.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [JobsControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return jobb;
	};

	/**
	*	MOVE TO LAST Record
	*  @return Jobs Object
	*/

	public Jobs moveLast()
	{
		jobb = new Jobs();

		try
		{
			rsJobs.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [JobsControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return jobb;
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
			rsJobs=db.stmt.executeQuery("SELECT * FROM Jobs WHERE EmpCode='" + EmpCode + "' AND Status<>'Cleared';");
			if (rsJobs.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [JobsControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into Jobs Table
	*  @param Jobs Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(Jobs jobb)
	{
		try
		{
			String strQuery="INSERT INTO Jobs VALUES(" 		+
							"'" + jobb.getTransactionID()  	+ "',"+
							"'" + jobb.getDate()    		+ "',"+
							"'" + jobb.getRequestID()		+ "',"+
							"'" + jobb.getReqFrom()   		+ "',"+
							"'" + jobb.getEmpCode()      	+ "',"+
							"'" + jobb.getStatus()		    + "',"+
							"'" + jobb.getSID()	    		+ "',"+
							"'" + jobb.getRemarks() 	   	+ "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle)
		{
			System.out.println("Server [JobsControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Emp Data Jobs Table
	*  @param Jobs Class Object
	*  @return boolean true or false value
	*/

	public boolean updateData(Jobs jobb)
	{
		try
		{
			String strQuery="UPDATE Jobs SET "			+
							"Status = " 	   			+ "'" + jobb.getStatus()		+ "',"+
							"SID = "    				+ "'" + jobb.getSID()			+ "',"+
							"Remarks = "   				+ "'" + jobb.getRemarks()		+ "' "+

							"WHERE TransactionID = "	+ "'" + jobb.getTransactionID()	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle){
			System.out.println("Server [JobsControllerImpl]: UPDATE EMP DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of updateEmpData Method

	/**
	*	UPDATES Request's Master Table
	*  @param String Criteria
	*
	*/

	public void UpdateReqTable(String strQuery)
	{
		System.out.println("\nQuery: "+strQuery);
		try
		{
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle)
		{
			System.out.println("Server [JobsControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of UpdateReqTable Data


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
			rsJobs = db.stmt.executeQuery(srchStr);

			if (!rsJobs.next())
			{ return false; }
		}catch(SQLException sqle)
		{
			System.out.println("Server [JobsControllerImpl]: CHECK DATA Error !!!");
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
			System.out.println("Server [JobsControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	SEARCH DATA from Employee Table
	*  @param String Criteria
	*  @return Jobs Class Object
	*/

	public Jobs SearchData(String srchStr)
	{
		jobb = new Jobs();

		if (srchStr.equals("")) return jobb;
		else
		{
			//System.out.println("\nQuery: "+srchStr);

			try
			{
				rsJobs = db.stmt.executeQuery(srchStr);

				if (rsJobs.next())
				{
					setData();
				}

			}catch(SQLException sqle)
			{
				System.out.println("Server [JobsControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return jobb;
	}//End of Search Data

}//End of JobsController Class