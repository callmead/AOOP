package beximtex;
/**
* <p>Title: BeximTex, Server</p>
* <p>Description: Support Software System</p>
* <p>Copyright: 2006-2010</p>
* <p>Company: ASKA</p>
* @author Adeel Ashraf Malik
* @version 1.0.0
*/

import java.rmi.*;
import java.awt.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;

public class Server extends JFrame
{//Class
	JLabel lblDisplay = new JLabel();

	JPanel pnl = new JPanel();
	JLabel lblPicture = new JLabel();
	JLabel lblLoad = new JLabel();
	JLabel lblLine = new JLabel();
	JLabel lblCopyright = new JLabel();
	ImageIcon imgSplash = new ImageIcon("./Images/sps.jpg");
	ImageIcon imgLine = new ImageIcon("./Images/sp3.gif");
	ImageIcon imgQ = new ImageIcon("./Images/question32.png");

	public Server()
	{

		//LABEL PROPERTIES...
		lblPicture.setIcon(imgSplash);
		lblLine.setIcon(imgLine);
		lblLoad.setText("   ** SERVER READY **                                                     Software ver 5.2.02");
		lblLoad.setForeground(Color.white);
		lblLoad.setFont(new java.awt.Font("Tahoma", 1, 11));

		lblPicture.setBounds(0, 10, 400, 366);
		lblLoad.setBounds(1, 370, 400, 15);
		lblLine.setBounds( -5, 382, 400, 18);

		pnl.setLayout(null);
		pnl.setBounds(0, 0, 400, 400);
		pnl.setBackground(Color.black);
		pnl.add(lblPicture);
		pnl.add(lblLine);
		pnl.add(lblLoad);

		this.setSize(400, 410);
		this.getContentPane().add(pnl);
		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		this.getContentPane().setBackground(Color.black);

		this.getContentPane().setLayout(null);
		this.setTitle("BeximTex Server");

		centerForm(this);

		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setState(1); //0 = Normal //1 = Minimized

		this.addWindowListener(new WindowAdapter()
		{
			public void windowActivated(WindowEvent e){}
			public void windowDeativated(WindowEvent e){}
			public void windowOpened(WindowEvent e){}
			public void windowDeiconified(WindowEvent e){}
			public void windowIconified(WindowEvent e){}
			public void windowClosed(WindowEvent e){}
			public void windowClosing(WindowEvent e){exitMsg();}
		});

		try
		{
			//IMPLEMENTATION OBJECT...
			UserControllerImpl userImpl = new UserControllerImpl();
			SecuriteeControllerImpl secImpl = new SecuriteeControllerImpl();
			DepartmentControllerImpl depImpl = new DepartmentControllerImpl();
			BUControllerImpl buImpl = new BUControllerImpl();
			DesignationControllerImpl desImpl = new DesignationControllerImpl();
			PhoneControllerImpl phImpl = new PhoneControllerImpl();
			MobileControllerImpl mbImpl = new MobileControllerImpl();
			EmailControllerImpl emlImpl = new EmailControllerImpl();
			HardwareControllerImpl hdwImpl = new HardwareControllerImpl();
			SoftwareControllerImpl sftImpl = new SoftwareControllerImpl();
			JobsControllerImpl jobbImpl = new JobsControllerImpl();
			CommonTableControllerImpl ctcImpl = new CommonTableControllerImpl();
			MB_BgtControllerImpl mbbgtcImpl = new MB_BgtControllerImpl();
			MBpStockControllerImpl mbpscImpl = new MBpStockControllerImpl();
			MBsStockControllerImpl mbsscImpl = new MBsStockControllerImpl();
			MBbillControllerImpl mbbcImpl = new MBbillControllerImpl();
			MBTbillControllerImpl mbtbcImpl = new MBTbillControllerImpl();
			MBissueControllerImpl mbiscImpl = new MBissueControllerImpl();
			IndentControllerImpl indcImpl = new IndentControllerImpl();
			HWpogrControllerImpl hwpocImpl = new HWpogrControllerImpl();
			SupplierControllerImpl suppcImpl = new SupplierControllerImpl();
			PaymentControllerImpl pymtcImpl = new PaymentControllerImpl();
			HWhistoryControllerImpl hwhcImpl = new HWhistoryControllerImpl();
			HWStockControllerImpl hwscImpl = new HWStockControllerImpl();
			HWissueControllerImpl hwicImpl = new HWissueControllerImpl();
			HWuserControllerImpl hwusrcImpl = new HWuserControllerImpl();


			//REBIND
			//Naming.rebind("rmi://localhost:1099/SupplierController",suppImpl);
			Naming.rebind("rmi://localhost/UserController",userImpl);
			Naming.rebind("rmi://localhost/SecuriteeController",secImpl);
			Naming.rebind("rmi://localhost/DepartmentController",depImpl);
			Naming.rebind("rmi://localhost/BUController",buImpl);
			Naming.rebind("rmi://localhost/DesignationController",desImpl);
			Naming.rebind("rmi://localhost/PhoneController",phImpl);
			Naming.rebind("rmi://localhost/MobileController",mbImpl);
			Naming.rebind("rmi://localhost/EmailController",emlImpl);
			Naming.rebind("rmi://localhost/HardwareController",hdwImpl);
			Naming.rebind("rmi://localhost/SoftwareController",sftImpl);
			Naming.rebind("rmi://localhost/JobsController",jobbImpl);
			Naming.rebind("rmi://localhost/CommonTableController",ctcImpl);
			Naming.rebind("rmi://localhost/MB_BgtController",mbbgtcImpl);
			Naming.rebind("rmi://localhost/MBpStockController",mbpscImpl);
			Naming.rebind("rmi://localhost/MBsStockController",mbsscImpl);
			Naming.rebind("rmi://localhost/MBbillController",mbbcImpl);
			Naming.rebind("rmi://localhost/MBTbillController",mbtbcImpl);
			Naming.rebind("rmi://localhost/MBissueController",mbiscImpl);
			Naming.rebind("rmi://localhost/IndentController",indcImpl);
			Naming.rebind("rmi://localhost/HWpogrController",hwpocImpl);
			Naming.rebind("rmi://localhost/SupplierController",suppcImpl);
			Naming.rebind("rmi://localhost/PaymentController",pymtcImpl);
			Naming.rebind("rmi://localhost/HWhistoryController",hwhcImpl);
			Naming.rebind("rmi://localhost/HWStockController",hwscImpl);
			Naming.rebind("rmi://localhost/HWissueController",hwicImpl);
			Naming.rebind("rmi://localhost/HWuserController",hwusrcImpl);


			System.out.println("\n******************************\n******** SERVER READY ********\n******************************\n");
			Date d = new Date();
			System.out.println("Session Started: "+d.toString());
		}catch(Exception re)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n"+re);
			lblLoad.setText("   ** SERVER NOT READY **");
			lblLoad.setForeground(Color.red);
			this.setState(0);
		}
	}

	public static void main(String[] args)
	{//Main
		Server srv = new Server();
		srv.setVisible(true);
	}//Main

	public void centerForm(JFrame f)
	{
		int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int cx = (x - f.getWidth()) / 2;
		int cy = (y - f.getHeight()) / 2;
		f.setLocation(cx, cy);
	}

	private void exitMsg()
	{
		int yn = JOptionPane.showConfirmDialog(null,
			"THIS WILL SHUTDOWN SERVER,\nCLIENTS WILL NOT BE ABLE TO MAKE TRANSACTIONS!!!"+
			"\nAre you sure you want to do this",
			"Exit Confirmation", JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
		  System.out.println("\n*** Database Closed ***");
   		  Date d = new Date();
		  System.out.println("\nSession Ended: "+d.toString());
		  System.out.println("\n*** THANK YOU FOR USING SUPPORT SOFTWARE SYSTEM ***\n*** Good Bye ***");
		  System.exit(0);
		}
	}

}//Class