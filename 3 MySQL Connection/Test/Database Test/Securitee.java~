package beximtex;
/**
 * <p>Title: BeximTex, Securitee Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.io.Serializable;

public class Securitee implements Serializable
{//Class

	private String f_SNo;
	private String f_EmpCode;
	private String f_LogInTime;
	private String f_LogOutTime;
	private String f_Remarks;

	/**
	 *	Default Constructor With no parameter
	 *
	 */

	public Securitee()
	{//Default Constructor...

		f_SNo			="";
		f_EmpCode		="";
		f_LogInTime		="";
		f_LogOutTime	="";
		f_Remarks		="";

	}//END Default Constructor...


	/**
	 *	Constructor with parameter
	 *
	 */

	public Securitee(Securitee usr)
	{//Constructor...

		f_SNo			=usr.f_SNo;
		f_EmpCode		=usr.f_EmpCode;
		f_LogInTime		=usr.f_LogInTime;
		f_LogOutTime	=usr.f_LogOutTime;
		f_Remarks		=usr.f_Remarks;

	}//END Constructor...


    //Setting Values...
	public void setSNo(String SNo)
	{ f_SNo=SNo; }

	public void setEmpCode(String EmpCode)
	{ f_EmpCode=EmpCode; }

	public void setLogInTime(String LogInTime)
	{ f_LogInTime=LogInTime; }

	public void setLogOutTime(String LogOutTime)
	{ f_LogOutTime=LogOutTime; }

	public void setRemarks(String Remarks)
	{ f_Remarks=Remarks; }


    //Get Methods...
	public String getSNo() 			{ return f_SNo; }
	public String getEmpCode() 		{ return f_EmpCode; }
	public String getLogInTime()	{ return f_LogInTime; }
	public String getLogOutTime() 	{ return f_LogOutTime; }
	public String getRemarks() 		{ return f_Remarks; }

}//Class