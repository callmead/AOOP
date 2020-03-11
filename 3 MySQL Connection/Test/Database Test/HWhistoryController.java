//package beximtex;
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

public interface HWhistoryController extends Remote
{
 public HWhistory moveFirst()  throws RemoteException;
 public HWhistory moveNext()  throws RemoteException;
 public HWhistory movePrevious()  throws RemoteException;
 public HWhistory moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(HWhistory hwh) throws RemoteException;

}//End of HWhistoryController Class