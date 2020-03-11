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

public interface BUController extends Remote
{
	public BU moveFirst()  throws RemoteException;
	public BU moveNext()  throws RemoteException;
	public BU movePrevious()  throws RemoteException;
	public BU moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
	public boolean insertData(BU sec) throws RemoteException;
	public void UpdateData(String strQuery) throws RemoteException;
	public void DeleteData(String strQuery) throws RemoteException;

	public boolean isFound(String srchStr) throws RemoteException;
	public BU SearchData(String srchStr) throws RemoteException;

}//End of BUController Class