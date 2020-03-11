package beximtex;
/**
 * <p>Title: BeximTex, HWissue Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface HWissueController extends Remote
{

	public HWissue moveFirst()  throws RemoteException;
	public HWissue moveNext()  throws RemoteException;
	public HWissue movePrevious()  throws RemoteException;
	public HWissue moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
	public boolean insertData(HWissue hwis) throws RemoteException;
	public boolean updateData(HWissue hwis) throws RemoteException;

	public void DeleteData(String strQuery) throws RemoteException;
	public void RunUpdate(String strQuery) throws RemoteException;
	public boolean isFound(String srchStr) throws RemoteException;
	public HWissue SearchData(String srchStr) throws RemoteException;

}//End of HWissueController Class