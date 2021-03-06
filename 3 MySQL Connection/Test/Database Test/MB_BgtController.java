//package beximtex;
/**
 * <p>Title: BeximTex, MB_Bgt Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface MB_BgtController extends Remote
{

 public MB_Bgt moveFirst()  throws RemoteException;
 public MB_Bgt moveNext()  throws RemoteException;
 public MB_Bgt movePrevious()  throws RemoteException;
 public MB_Bgt moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(MB_Bgt mbbgt) throws RemoteException;
 public boolean updateData(MB_Bgt mbbgt) throws RemoteException;

 public void DeleteData(String strQuery) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public MB_Bgt SearchData(String srchStr) throws RemoteException;

}//End of MB_BgtController Class