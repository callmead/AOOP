package beximtex;
/**
* <p>Title: BeximTex, Indent Manager</p>
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

public class IndentControllerImpl extends UnicastRemoteObject implements IndentController
{

	//Global Objects...
	DBU db = new DBU();
	ResultSet rsInd;
	Indent ind;
	boolean haveData=false;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	*	Default Constructor With no parameter
	*
	*/

	public IndentControllerImpl() throws RemoteException
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
				ind.setIndentNo(rsInd.getString(1));
				ind.setBU(rsInd.getString(2));
				ind.setDate(sdf.format(rsInd.getDate(3)));
				ind.setAmount(rsInd.getString(4));
				ind.setRecFrom(rsInd.getString(5));
				ind.setRecDate(rsInd.getString(6));
				ind.setRecBy(rsInd.getString(7));
				ind.setBalance(rsInd.getString(8));
				ind.setSubmtDate(rsInd.getString(9));
				ind.setSubmtTo(rsInd.getString(10));
				ind.setRemarks(rsInd.getString(11));
			}catch(SQLException sqle)
			{
				System.out.println("Server [IndentControllerImpl] : SET DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}
		else{System.out.println("Server [IndentControllerImpl] : NO RECORDS FOUND!");}
	}

	/**
	*	MOVE TO FIRST Record
	*  @return Indent Object
	*/

	public Indent moveFirst()
	{
		ind = new Indent();

		try
		{
			rsInd.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [IndentControllerImpl] : MOVE FIRST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return ind;
	};

	/**
	*	MOVE TO PREVIOUS Record
	*  @return Indent Object
	*/

	public Indent movePrevious()
	{
		ind = new Indent();

		try
		{
			if (!rsInd.previous()) rsInd.first();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [IndentControllerImpl] : MOVE PREVIOUS Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return ind;
	};

	/**
	*	MOVE TO NEXT Record
	*  @return Indent Object
	*/

	public Indent moveNext()
	{
		ind = new Indent();

		try
		{
			if (!rsInd.next()) rsInd.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [IndentControllerImpl] : MOVE NEXT Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return ind;
	};

	/**
	*	MOVE TO LAST Record
	*  @return Indent Object
	*/

	public Indent moveLast()
	{
		ind = new Indent();

		try
		{
			rsInd.last();
			setData();
		}catch(SQLException sqle)
		{
			System.out.println("Server [IndentControllerImpl] : MOVE LAST Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

		return ind;
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
			rsInd=db.stmt.executeQuery("SELECT * FROM Indents ORDER BY IndentNo;");
			if (rsInd.next()) haveData=true;
		}catch(SQLException sqle)
		{
			System.out.println("Server [IndentControllerImpl]: Connect Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			haveData=false;
		}
	}

	/**
	*	Insert Data into Indents Table
	*  @param Indent Class Object
	*  @return boolean true or false value
	*/

	public boolean insertData(Indent ind)
	{

		try
		{
			String strQuery="INSERT INTO Indents VALUES(" +
							"'" + ind.getIndentNo() 	+ "',"+
							"'" + ind.getBU()      		+ "',"+
							"'" + ind.getDate()    		+ "',"+
							""  + ind.getAmount()		+ "," +
							"'" + ind.getRecFrom() 		+ "',"+
							"'" + ind.getRecDate()    	+ "',"+
							"'" + ind.getRecBy()     	+ "',"+
							""  + ind.getBalance()      + "," +
							"'" + ind.getSubmtDate()    + "',"+
							"'" + ind.getSubmtTo()      + "',"+
							"'" + ind.getRemarks() 		+ "');";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table
			Connect();

		}catch(SQLException sqle)
		{
			System.out.println("Server [IndentControllerImpl]: INSERT DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of insertData Method

	/**
	*	Update Indent Data Indents Table
	*  @param Indent Class Object
	*  @return boolean true or false value
	*/

	public boolean updateIndData(Indent ind)
	{
		try
		{
			String strQuery="UPDATE Indents SET " 	+
							"BU = "					+ "'" + ind.getBU()        	+ "',"+
							"Amount = "    			+ ""  + ind.getAmount()		+ ", "+
							"Remarks = " 			+ "'" + ind.getRemarks()   	+ "' "+

							"WHERE IndentNo = " 	+ "'" + ind.getIndentNo() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();

		}catch(SQLException sqle){
			System.out.println("Server [IndentControllerImpl]: UPDATE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			return false;
		}

		return true;

	}//End of updateData Method

	/**
	*	Update Data Indents Table
	*  @param Indent Class Object
	*  @return boolean true or false value
	*/

	public boolean updateData(Indent ind)
	{
		try
		{
			String strQuery="UPDATE Indents SET " 	+
							"BU = "					+ "'" + ind.getBU()        	+ "',"+
							"Date = "   	 		+ "'" + ind.getDate()      	+ "',"+
							"Amount = "    			+ ""  + ind.getAmount()		+ ", "+
							"RecFrom = "			+ "'" + ind.getRecFrom()	+ "',"+
							"RecDate = "    		+ "'" + ind.getRecDate()	+ "',"+
							"RecBy = " 				+ "'" + ind.getRecBy()   	+ "',"+
							"Balance = " 			+ ""  + ind.getBalance()   	+ "," +
							"SubmtDate = " 			+ "'" + ind.getSubmtDate() 	+ "',"+
							"SubmtTo = " 			+ "'" + ind.getSubmtTo()   	+ "',"+
							"Remarks = " 			+ "'" + ind.getRemarks()   	+ "' "+

							"WHERE IndentNo = " 	+ "'" + ind.getIndentNo() 	+"';";

			System.out.println("\nQuery: "+strQuery);
			//Executing SQL
			db.stmt.executeUpdate(strQuery);

			//Refresh Table...
			Connect();

		}catch(SQLException sqle){
			System.out.println("Server [IndentControllerImpl]: UPDATE DATA Error !!!");
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
			rsInd = db.stmt.executeQuery(srchStr);

			if (!rsInd.next())
			{
				Connect();
				return false;
			}
		}catch(SQLException sqle)
		{
			System.out.println("Server [IndentControllerImpl]: CHECK DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
			JOptionPane.showMessageDialog(null, "Server: RECORD NOT FOUND!");
			return false;
		}

		//Refresh Table...
		Connect();
		return true;
	}//End of isFound Data

	/**
	*	DELETE DATA from Indents Table
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
			System.out.println("Server [IndentControllerImpl]: DELETE DATA Error !!!");
			System.out.println("Error: "+sqle.getMessage());
		}

	}//End of Delete Data

	/**
	*	SEARCH DATA from Indents Table
	*  @param String Criteria
	*  @return Indent Class Object
	*/

	public Indent SearchData(String srchStr)
	{
		ind = new Indent();

		if (srchStr.equals("")) return ind;
		else
		{
			//System.out.println("\nQuery: "+srchStr);

			try
			{
				rsInd = db.stmt.executeQuery(srchStr);

				if (rsInd.next())
				{
					setData();
				}

			}catch(SQLException sqle)
			{
				System.out.println("Server [IndentControllerImpl]: SEARCH DATA Error !!!");
				System.out.println("Error: "+sqle.getMessage());
			}
		}

		return ind;
	}//End of Search Data

}//End of IndentController Class