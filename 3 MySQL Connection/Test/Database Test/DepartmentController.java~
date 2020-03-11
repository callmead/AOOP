package beximtex;
/**
 * <p>Title: BeximTex, User Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface DepartmentController extends Remote
{
	public Department moveFirst()  throws RemoteException;
	public Department moveNext()  throws RemoteException;
	public Department movePrevious()  throws RemoteException;
	public Department moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
	public boolean insertData(Department sec) throws RemoteException;
	public void UpdateData(String strQuery) throws RemoteException;
	public void DeleteData(String strQuery) throws RemoteException;

	public boolean isFound(String srchStr) throws RemoteException;
	public Department SearchData(String srchStr) throws RemoteException;

}//End of DepartmentController Class