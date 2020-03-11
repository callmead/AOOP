//package beximtex;
/**
 * <p>Title: BeximTex, Mobile Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface MobileController extends Remote
{

 public Mobile moveFirst()  throws RemoteException;
 public Mobile moveNext()  throws RemoteException;
 public Mobile movePrevious()  throws RemoteException;
 public Mobile moveLast()  throws RemoteException;

    public void Connect(String EmpCode) throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(Mobile usr) throws RemoteException;
 public boolean updateEmpData(Mobile usr) throws RemoteException;
 public boolean updateDeptData(Mobile usr) throws RemoteException;
 public boolean updateISData(Mobile usr) throws RemoteException;
 public boolean updateJobData(Mobile usr) throws RemoteException;

 public void DeleteData(String strQuery) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public Mobile SearchData(String srchStr) throws RemoteException;

}//End of MobileController Class