package beximtex;
/**
 * <p>Title: BeximTex, MBsStock Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface MBsStockController extends Remote
{

	public MBsStock moveFirst()  throws RemoteException;
	public MBsStock moveNext()  throws RemoteException;
	public MBsStock movePrevious()  throws RemoteException;
	public MBsStock moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
	public boolean insertData(MBsStock mbss) throws RemoteException;
	public boolean updateData(MBsStock mbss) throws RemoteException;

	public void DeleteData(String strQuery) throws RemoteException;
	public boolean isFound(String srchStr) throws RemoteException;
	public MBsStock SearchData(String srchStr) throws RemoteException;

}//End of MBsStockController Class