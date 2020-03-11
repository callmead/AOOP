package beximtex;
/**
 * <p>Title: BeximTex, HWStock Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface HWStockController extends Remote
{

	public HWStock moveFirst()  throws RemoteException;
	public HWStock moveNext()  throws RemoteException;
	public HWStock movePrevious()  throws RemoteException;
	public HWStock moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
	public boolean insertData(HWStock hws) throws RemoteException;
	public boolean updateData(HWStock hws) throws RemoteException;

	public void DeleteData(String strQuery) throws RemoteException;
	public boolean isFound(String srchStr) throws RemoteException;
	public HWStock SearchData(String srchStr) throws RemoteException;

}//End of HWStockController Class