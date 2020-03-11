//package beximtex;
/**
 * <p>Title: BeximTex, MBbill Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface MBbillController extends Remote
{

 public MBbill moveFirst()  throws RemoteException;
 public MBbill moveNext()  throws RemoteException;
 public MBbill movePrevious()  throws RemoteException;
 public MBbill moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(MBbill mbb) throws RemoteException;
 public boolean updateData(MBbill mbb) throws RemoteException;

 public void DeleteData(String strQuery) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public MBbill SearchData(String srchStr) throws RemoteException;

}//End of MBbillController Class