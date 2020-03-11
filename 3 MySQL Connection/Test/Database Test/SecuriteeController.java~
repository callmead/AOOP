package beximtex;
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

public interface SecuriteeController extends Remote
{
	public Securitee moveFirst()  throws RemoteException;
	public Securitee moveNext()  throws RemoteException;
	public Securitee movePrevious()  throws RemoteException;
	public Securitee moveLast()  throws RemoteException;

    public void Connect() throws RemoteException;
    public void setData() throws RemoteException;
	public boolean insertData(Securitee sec) throws RemoteException;
	public void UpdateData(String strQuery) throws RemoteException;

	public boolean isFound(String srchStr) throws RemoteException;
	public Securitee SearchData(String srchStr) throws RemoteException;

}//End of SecuriteeController Class