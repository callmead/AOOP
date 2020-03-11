package beximtex;
/**
 * <p>Title: BeximTex, Jobs Manager</p>
 * <p>RequestID: Support Jobs System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class Jobs implements Serializable
{//Class

	private String f_TransactionID;
	private String f_Date;
	private String f_RequestID;
	private String f_ReqFrom;
	private String f_EmpCode;
	private String f_Status;
	private String f_SID;
	private String f_Remarks;

	/**
	 *	Default Constructor With no parameter
	 *
	 */

	public Jobs()
	{//Default Constructor...

		f_TransactionID	="";
		f_Date			="";
		f_RequestID		="";
		f_ReqFrom		="";
		f_EmpCode		="";
		f_Status		="";
		f_SID			="";
		f_Remarks		="";

	}//END Default Constructor...


	/**
	 *	Constructor with parameter
	 *
	 */

	public Jobs(Jobs jobb)
	{//Constructor...

		f_TransactionID	= jobb.f_TransactionID;
		f_Date			= jobb.f_Date;
		f_RequestID		= jobb.f_RequestID;
		f_ReqFrom		= jobb.f_ReqFrom;
		f_EmpCode		= jobb.f_EmpCode;
		f_Status		= jobb.f_Status;
		f_SID			= jobb.f_SID;
		f_Remarks		= jobb.f_Remarks;

	}//END Constructor...


    //Setting Values...
	public void setTransactionID(String TransactionID)
	{ f_TransactionID=TransactionID; }

	public void setDate(String Date)
	{ f_Date=Date; }

	public void setRequestID(String RequestID)
	{ f_RequestID=RequestID; }

	public void setReqFrom(String ReqFrom)
	{ f_ReqFrom=ReqFrom; }

	public void setEmpCode(String EmpCode)
	{ f_EmpCode=EmpCode; }

	public void setStatus(String Status)
	{ f_Status=Status; }

	public void setSID(String SID)
	{ f_SID=SID; }

	public void setRemarks(String Remarks)
	{ f_Remarks=Remarks; }

    //Get Methods...
	public String getTransactionID()	{ return f_TransactionID; }
	public String getDate() 			{ return f_Date; }
	public String getRequestID() 		{ return f_RequestID; }
	public String getReqFrom() 			{ return f_ReqFrom; }
	public String getEmpCode() 			{ return f_EmpCode; }
	public String getStatus() 			{ return f_Status; }
	public String getSID()	 			{ return f_SID; }
	public String getRemarks() 			{ return f_Remarks; }

}//Class