package beximtex;
/**
 * <p>Title: BeximTex, Payment Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface PaymentController extends Remote
{

	public Payment moveFirst()  throws RemoteException;
	public Payment moveNext()  throws RemoteException;
	public Payment movePrevious()  throws RemoteException;
	public Payment moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
	public boolean insertData(Payment pay) throws RemoteException;
	public boolean updateData(Payment pay) throws RemoteException;

	public void DeleteData(String strQuery) throws RemoteException;
	public boolean isFound(String srchStr) throws RemoteException;
	public Payment SearchData(String srchStr) throws RemoteException;

}//End of PaymentController Class