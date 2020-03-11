//package beximtex;
/**
 * <p>Title: BeximTex, MBTbill Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface MBTbillController extends Remote
{

 public MBTbill moveFirst()  throws RemoteException;
 public MBTbill moveNext()  throws RemoteException;
 public MBTbill movePrevious()  throws RemoteException;
 public MBTbill moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(MBTbill mbtb) throws RemoteException;
 public boolean updateData(MBTbill mbtb) throws RemoteException;

 public void DeleteData(String strQuery) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public MBTbill SearchData(String srchStr) throws RemoteException;

}//End of MBTbillController Class