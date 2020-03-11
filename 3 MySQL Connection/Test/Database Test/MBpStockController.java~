package beximtex;
/**
 * <p>Title: BeximTex, MBpStock Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface MBpStockController extends Remote
{

	public MBpStock moveFirst()  throws RemoteException;
	public MBpStock moveNext()  throws RemoteException;
	public MBpStock movePrevious()  throws RemoteException;
	public MBpStock moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
	public boolean insertData(MBpStock mbps) throws RemoteException;
	public boolean updateData(MBpStock mbps) throws RemoteException;

	public void DeleteData(String strQuery) throws RemoteException;
	public boolean isFound(String srchStr) throws RemoteException;
	public MBpStock SearchData(String srchStr) throws RemoteException;

}//End of MBpStockController Class