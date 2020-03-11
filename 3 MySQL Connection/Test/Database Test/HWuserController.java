//package beximtex;
/**
 * <p>Title: BeximTex, HWuser Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface HWuserController extends Remote
{

 public HWuser moveFirst()  throws RemoteException;
 public HWuser moveNext()  throws RemoteException;
 public HWuser movePrevious()  throws RemoteException;
 public HWuser moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(HWuser hwusr) throws RemoteException;
 public boolean updateData(HWuser hwusr) throws RemoteException;

 public void DeleteData(String strQuery) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public HWuser SearchData(String srchStr) throws RemoteException;

}//End of HWuserController Class