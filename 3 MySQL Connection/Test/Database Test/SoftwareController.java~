package beximtex;
/**
 * <p>Title: BeximTex, Software Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface SoftwareController extends Remote
{

	public Software moveFirst()  throws RemoteException;
	public Software moveNext()  throws RemoteException;
	public Software movePrevious()  throws RemoteException;
	public Software moveLast()  throws RemoteException;

    public void Connect(String EmpCode) throws RemoteException;
    public void setData() throws RemoteException;
	public boolean insertData(Software usr) throws RemoteException;
	public boolean updateEmpData(Software usr) throws RemoteException;
	public boolean updateDeptData(Software usr) throws RemoteException;
	public boolean updateISData(Software usr) throws RemoteException;
	public boolean updateJobData(Software usr) throws RemoteException;

	public void DeleteData(String strQuery) throws RemoteException;
	public boolean isFound(String srchStr) throws RemoteException;
	public Software SearchData(String srchStr) throws RemoteException;

}//End of SoftwareController Class