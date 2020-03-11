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

public interface UserController extends Remote
{

 public User moveFirst()  throws RemoteException;
 public User moveNext()  throws RemoteException;
 public User movePrevious()  throws RemoteException;
 public User moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(User usr) throws RemoteException;
 public boolean updateData(User usr) throws RemoteException;

 public void DeleteData(String strQuery) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public User SearchData(String srchStr) throws RemoteException;

}//End of UserController Class