package beximtex;
/**
* <p>Title: BeximTex, Email Manager</p>
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

public class EmailControllerImpl extends UnicastRemoteObject implements EmailController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsEmail;
	Email eml;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public EmailControllerImpl() throws RemoteException
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
				eml.setTransactionID(rsEmail.getString(1));
				eml.setEmpCode(rsEmail.getString(2));
				eml.setDate(sdf.format(rsEmail.getDate(3)));
				eml.setRemarks(rsEmail.getString(4));
				eml.setEmail1(rsEmail.getString(5));
				eml.setEmail2(rsEmail.getString(6));
				eml.setPass(rsEmail.getString(7));
				eml.setDeptApp(rsEmail.getString(8));
				eml.setDeptComm(rsEmail.getString(9));
				eml.setDeptAppBy(rsEmail.getString(10));
				eml.setISApp(rsEmail.getString(11));
				eml.setISComm(rsEmail.getString(12));
				eml.setISAppBy(rsEmail.getString(13));
				eml.setJobStatus(rsEmail.getString(14));

			}catch(SQLException sqle)
			{
				System.out.println("Server [EmailControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [EmailControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return Email Object
	*/

	public Email moveFirst()
	{
		eml = new Email();

		try
		{
			rsEmail.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [EmailControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return eml;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return Email Object
	*/

	public Email movePrevious()
	{
		eml = new Email();

		try
		{
			if (!rsEmail.previous()) rsEmail.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [EmailControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return eml;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return Email Object
	*/

	public Email moveNext()
	{
		eml = new Email();

		try
		{
			if (!rsEmail.next()) rsEmail.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [EmailControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return eml;
	};

	/**
	*	MOVE TO LAST Record
	*  @return Email Object
	*/

	public Email moveLast()
	{
		eml = new Email();

		try
		{
			rsEmail.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [EmailControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return eml;
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
			rsEmail = db.stmt.executeQuery("SELECT * FROM Email WHERE EmpCode='" + EmpCode + "' AND DeptApp='-' ORDER BY Date;");
			if (rsEmail.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [EmailControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into Email Table
	*  @param Email Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(Email eml)
	{
		try
		{
			String strQuery="INSERT INTO Email VALUES(" +
							"'" + eml.getTransactionID()   	+ "',"+
							"'" + eml.getEmpCode()      	+ "',"+
							"'" + eml.getDate()    			+ "',"+
							"'" + eml.getRemarks()			+ "',"+
							"'" + eml.getEmail1()   		+ "',"+
							"'" + eml.getEmail2()   		+ "',"+
							"'" + eml.getPass()   			+ "',"+
							"'" + eml.getDeptApp()      	+ "',"+
							"'" + eml.getDeptComm()		    + "',"+
							"'" + eml.getDeptAppBy()	    + "',"+
							"'" + eml.getISApp()    	  	+ "',"+
							"'" + eml.getISComm()   	   	+ "',"+
							"'" + eml.getISAppBy()     		+ "',"+
							"'" + eml.getJobStatus() 		+ "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle)
		{
			System.out.println("Server [EmailControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Emp Data Email Table
	*  @param Email Class Object
	*  @return boolean true or false value
	*/

	public boolean updateEmpData(Email eml)
	{
		try
		{
			String strQuery="UPDATE Email SET "		+
							"Remarks = "    		+ "'" + eml.getRemarks()		+ "',"+
							"Email1 = "   			+ "'" + eml.getEmail1()    		+ "',"+
							"Email2 = "   			+ "'" + eml.getEmail2()    		+ "',"+
							"Password = "			+ "'" + eml.getPass()			+ "' "+

							"WHERE TransactionID = "+ "'" + eml.getTransactionID()	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle){
			System.out.println("Server [EmailControllerImpl]: UPDATE EMP DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of updateEmpData Method

	/**
	*	Update Dept Data Email Table
	*  @param Email Class Object
	*  @return boolean true or false value
	*/

	public boolean updateDeptData(Email eml)
	{
		try
		{
			String strQuery="UPDATE Email SET " 	+
							"DeptApp = "      		+ "'" + eml.getDeptApp()    	+ "'," +
							"DeptComm = " 			+ "'" + eml.getDeptComm()  		+ "'," +
							"DeptAppBy = " 			+ "'" + eml.getDeptAppBy() 		+ "'," +

							"WHERE TransactionID = "+ "'" + eml.getTransactionID() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle){
			System.out.println("Server [EmailControllerImpl]: UPDATE DEPT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of updateDeptData Method

	/**
	*	Update IS Data Email Table
	*  @param Email Class Object
	*  @return boolean true or false value
	*/

	public boolean updateISData(Email eml)
	{
		try
		{
			String strQuery="UPDATE Email SET " 	+
							"ISApp = " 				+ "'" + eml.getISApp()   		+ "',"+
							"ISComm = " 			+ "'" + eml.getISComm()   		+ "',"+
							"ISAppBy = " 			+ "'" + eml.getISAppBy()  	 	+ "',"+

							"WHERE TransactionID = "+ "'" + eml.getTransactionID() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle){
			System.out.println("Server [EmailControllerImpl]: UPDATE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of updateISData Method

	/**
	*	Update Job Data Email Table
	*  @param Email Class Object
	*  @return boolean true or false value
	*/

	public boolean updateJobData(Email eml)
	{
		try
		{
			String strQuery="UPDATE Email SET " 	+
							"JobStatus = "			+ "'" + eml.getJobStatus() 		+ "' "+

							"WHERE TransactionID = "+ "'" + eml.getTransactionID() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

		}catch(SQLException sqle){
			System.out.println("Server [EmailControllerImpl]: UPDATE JOB DATA Error !!!");
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
			rsEmail = db.stmt.executeQuery(srchStr);

			if (!rsEmail.next())
			{ return false; }
		}catch(SQLException sqle)
		{
			System.out.println("Server [EmailControllerImpl]: CHECK DATA Error !!!");
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
			System.out.println("Server [EmailControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	SEARCH DATA from Employee Table
	*  @param String Criteria
	*  @return Email Class Object
	*/

	public Email SearchData(String srchStr)
	{
		eml = new Email();

		if (srchStr.equals("")) return eml;
		else
		{
			//System.out.println("\nQuery: "+srchStr);

			try
			{
				rsEmail = db.stmt.executeQuery(srchStr);

				if (rsEmail.next())
				{
					setData();
				}

			}catch(SQLException sqle)
			{
				System.out.println("Server [EmailControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return eml;
	}//End of Search Data

}//End of EmailController Class