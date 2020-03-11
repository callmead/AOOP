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

public interface CommonTableController extends Remote
{
 public Vector getColumnData(String strQuery) throws RemoteException;
 public Vector getRowData(String strQuery) throws RemoteException;
 public void ExecuteQuery(String strQuery) throws RemoteException;
 public int getColNo(String strQuery) throws RemoteException;
 public Vector getComboData(String strQuery, int colNo) throws RemoteException;
 public boolean isFound(String srchStr) throws RemoteException;
 public String getDataItem(String strQuery) throws RemoteException;

}//End Class