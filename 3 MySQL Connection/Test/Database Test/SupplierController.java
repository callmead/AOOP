//package beximtex;
/**
 * <p>Title: BeximTex, Supplier Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface SupplierController extends Remote
{

 public Supplier moveFirst()  throws RemoteException;
 public Supplier moveNext()  throws RemoteException;
 public Supplier movePrevious()  throws RemoteException;
 public Supplier moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
 public boolean insertData(Supplier supp) throws RemoteException;
 public boolean updateData(Supplier supp) throws RemoteException;

 public void DeleteData(String strQuery) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public Supplier SearchData(String srchStr) throws RemoteException;

}//End of SupplierController Class