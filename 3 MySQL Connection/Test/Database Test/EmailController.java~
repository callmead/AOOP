package beximtex;
/**
 * <p>Title: BeximTex, Email Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface EmailController extends Remote
{

	public Email moveFirst()  throws RemoteException;
	public Email moveNext()  throws RemoteException;
	public Email movePrevious()  throws RemoteException;
	public Email moveLast()  throws RemoteException;

    public void Connect(String EmpCode) throws RemoteException;
    public void setData() throws RemoteException;
	public boolean insertData(Email usr) throws RemoteException;
	public boolean updateEmpData(Email usr) throws RemoteException;
	public boolean updateDeptData(Email usr) throws RemoteException;
	public boolean updateISData(Email usr) throws RemoteException;
	public boolean updateJobData(Email usr) throws RemoteException;

	public void DeleteData(String strQuery) throws RemoteException;
	public boolean isFound(String srchStr) throws RemoteException;
	public Email SearchData(String srchStr) throws RemoteException;

}//End of EmailController Class