//package beximtex;
/**
 * <p>Title: BeximTex, Phone Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface PhoneController extends Remote
{

 public Phone moveFirst()  throws RemoteException;
 public Phone moveNext()  throws RemoteException;
 public Phone movePrevious()  throws RemoteException;
 public Phone moveLast()  throws RemoteException;

    public void Connect(String EmpCode) throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(Phone usr) throws RemoteException;
 public boolean updateEmpData(Phone usr) throws RemoteException;
 public boolean updateDeptData(Phone usr) throws RemoteException;
 public boolean updateISData(Phone usr) throws RemoteException;
 public boolean updateJobData(Phone usr) throws RemoteException;

 public void DeleteData(String strQuery) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public Phone SearchData(String srchStr) throws RemoteException;

}//End of PhoneController Class