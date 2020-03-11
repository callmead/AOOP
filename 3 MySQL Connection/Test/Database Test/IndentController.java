//package beximtex;
/**
 * <p>Title: BeximTex, Indent Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface IndentController extends Remote
{

 public Indent moveFirst()  throws RemoteException;
 public Indent moveNext()  throws RemoteException;
 public Indent movePrevious()  throws RemoteException;
 public Indent moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(Indent ind) throws RemoteException;
 public boolean updateIndData(Indent ind) throws RemoteException;
 public boolean updateData(Indent ind) throws RemoteException;

 public void DeleteData(String strQuery) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public Indent SearchData(String srchStr) throws RemoteException;

}//End of IndentController Class