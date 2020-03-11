//package beximtex;
/**
 * <p>Title: BeximTex, Jobs Manager</p>
 * <p>Description: Support Jobs System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface JobsController extends Remote
{

 public Jobs moveFirst()  throws RemoteException;
 public Jobs moveNext()  throws RemoteException;
 public Jobs movePrevious()  throws RemoteException;
 public Jobs moveLast()  throws RemoteException;

    public void Connect(String EmpCode) throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(Jobs usr) throws RemoteException;
 public boolean updateData(Jobs usr) throws RemoteException;

 public void UpdateReqTable(String strQuery) throws RemoteException;
 public void DeleteData(String strQuery) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public Jobs SearchData(String srchStr) throws RemoteException;

}//End of JobsController Class