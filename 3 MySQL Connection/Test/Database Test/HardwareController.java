//package beximtex;
/**
 * <p>Title: BeximTex, Hardware Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface HardwareController extends Remote
{

 public Hardware moveFirst()  throws RemoteException;
 public Hardware moveNext()  throws RemoteException;
 public Hardware movePrevious()  throws RemoteException;
 public Hardware moveLast()  throws RemoteException;

    public void Connect(String EmpCode) throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(Hardware usr) throws RemoteException;
 public boolean updateEmpData(Hardware usr) throws RemoteException;
 public boolean updateDeptData(Hardware usr) throws RemoteException;
 public boolean updateISData(Hardware usr) throws RemoteException;
 public boolean updateJobData(Hardware usr) throws RemoteException;

 public void DeleteData(String strQuery) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public Hardware SearchData(String srchStr) throws RemoteException;

}//End of HardwareController Class