package beximtex;
/**
 * <p>Title: BeximTex, Hardware Users Registeration</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.text.*;
import java.util.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java.rmi.*;

public class frmHWUsers extends JInternalFrame
{//Class

	JPanel pnlFields = new JPanel();
	TitledBorder titledBorder1;
	TitledBorder titledBorder2;
	JTextField txtBPW = new JTextField();
	JLabel lblIP = new JLabel();
	JLabel lblGW = new JLabel();
	JTextField txtSubnet = new JTextField();
	JLabel lblBP = new JLabel();
	JTextField txtEmpCode = new JTextField();
	JLabel lblEmpCode = new JLabel();
	JLabel lblBSPW = new JLabel();
	JLabel lblDNS = new JLabel();
	JTextField txtGW = new JTextField();
	JLabel lblIE = new JLabel();
	JTextField txtBSPW = new JTextField();
	JLabel lblMsng = new JLabel();
	JLabel lblSubnet = new JLabel();
	JTextField txtIP = new JTextField();
	JTextField txtDNS = new JTextField();
	JLabel lblRem = new JLabel();
	JScrollPane SPtxtRem = new JScrollPane();
	JLabel lblDate = new JLabel();
	JLabel lblNID = new JLabel();
	JTextField txtNID = new JTextField();
	JLabel lblNTD = new JLabel();
	JTextField txtDate = new JTextField();
	JLabel lblOS = new JLabel();
	JComboBox cboMessenger = new JComboBox();
	JButton btnSelect = new JButton();
	JComboBox cboNTD = new JComboBox();
	JComboBox cboOS = new JComboBox();
	JLabel lblIEmail = new JLabel();
	JTextField txtEmail = new JTextField();
	JLabel lblIFM = new JLabel();
	JLabel lblDT = new JLabel();
	JLabel lblHead = new JLabel();
	JPanel pnlButtons = new JPanel();
	TitledBorder titledBorder3;
	TitledBorder titledBorder4;
	JButton btnClose = new JButton();
	JButton btnNew = new JButton();
	JButton btnSave = new JButton();
	JToggleButton btnLast = new JToggleButton();
	JToggleButton btnPrevious = new JToggleButton();
	JButton btnDelete = new JButton();
	JButton btnEdit = new JButton();
	JButton btnRefresh = new JButton();
	JToggleButton btnNext = new JToggleButton();
	JToggleButton btnFirst = new JToggleButton();
	JLabel lblRec = new JLabel();
	JButton btnCancel = new JButton();

	//**************************************************************
	//RMI Declare Server Object
	HWuserController hwusrcon;
	HWuser hwusr = new HWuser();

	CommonTableController ctccon;
	//**************************************************************

	ImageIcon imgFirst = new ImageIcon("./Images/iconFirst.gif");
	ImageIcon imgFO = new ImageIcon("./Images/iconFirstOver.gif");
	ImageIcon imgLast = new ImageIcon("./Images/iconLast.gif");
	ImageIcon imgLO = new ImageIcon("./Images/iconLastOver.gif");
	ImageIcon imgNext = new ImageIcon("./Images/iconNext.gif");
	ImageIcon imgNO = new ImageIcon("./Images/iconNextOver.gif");
	ImageIcon imgPrev = new ImageIcon("./Images/iconPrevious.gif");
	ImageIcon imgPO = new ImageIcon("./Images/iconPreviousOver.gif");
	ImageIcon imgSearch = new ImageIcon("./Images/powerSearch.gif");
	ImageIcon imgSrc = new ImageIcon("./Images/find.png");
	ImageIcon imgRef = new ImageIcon("./Images/db.gif");
	ImageIcon imgExc = new ImageIcon("./Images/exc.gif");
	ImageIcon imgTab = new ImageIcon("./Images/table.gif");
	ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
	ImageIcon imgHead = new ImageIcon("./Images/touch.gif");
	ImageIcon imgQ = new ImageIcon("./Images/question32.png");

	JTextArea txtRemarks = new JTextArea();
	int yn;
	boolean isAdd = false;

	Vector ColHead = new Vector();
	Vector rows = new Vector();

	int TotalCol = 0;
	int Rows = 0;
	int Columns = 0;
	String SQL=null;
	String EmpCode = null;
	String SelRow[][];

	String CurrentDate = null;
	String TranID = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date d;
	JTabbedPane TP = new JTabbedPane();
	JPanel pnlRegister = new JPanel();
	JPanel pnlSearch = new JPanel();
	JButton btnGo = new JButton();
	JLabel lblPicture = new JLabel();
	JScrollPane sp = new JScrollPane();
	JTable Table = new JTable();
	JComboBox cboSearch = new JComboBox();
	JTextField txtSearch = new JTextField();
	JComboBox cboIE = new JComboBox();
	JComboBox cboDatatex = new JComboBox();
	JComboBox cboIFM = new JComboBox();
	JToggleButton btnDT1 = new JToggleButton();

	public frmHWUsers(String ec)
	{//Cons
		EmpCode = ec;
		try {jbInit();}
		catch(Exception e){System.exit(0);}
	}//Cons

	private void jbInit() throws Exception
	{//jbInit

		//**************************************************************
	    //getConnectedion: getConnecteds with Server
		try
		{
			hwusrcon = (HWuserController)Naming.lookup(new ReadHost().getHost() + "HWuserController");
			ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmHWUsers] \n******************************\n");
		//**************************************************************

		titledBorder3 = new TitledBorder("");
		titledBorder4 = new TitledBorder("");
		lblHead.setBounds(new Rectangle(0, 0, 534, 60));
		lblHead.setIcon(imgHead);
		pnlButtons.setBackground(Color.white);
		pnlButtons.setBorder(titledBorder4);
		pnlButtons.setBounds(new Rectangle(5, 282, 553, 73));
		pnlButtons.setLayout(null);
		btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
		btnClose.setMnemonic('L');
		btnClose.setText("CLOSE");
		btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnClose.setIcon(new ImageIcon("images/close.gif"));
		btnClose.setBounds(new Rectangle(448, 35, 91, 28));
		btnClose.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ dispose(); }
		});
		btnNew.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				isAdd = true;
				setButton(false);
				setFields(true);
				clearFields();
				d = new Date();
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				CurrentDate = sdf.format(d);
				txtDate.setText(CurrentDate);

				txtDNS.setText("203.122.133.108");
				txtGW.setText("190.123.133.60");
				lblRec.setText(" Add New Record... ");
			}
		});
		btnNew.setBorder(BorderFactory.createRaisedBevelBorder());
		btnNew.setBounds(new Rectangle(12, 35, 91, 28));
		btnNew.setText("NEW");
		btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnNew.setIcon(new ImageIcon("images/FileMnu.gif"));
		btnNew.setMnemonic('N');
		btnSave.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(checkFields()==true)
				{
					if (isAdd)
					{
						if (save()==false)
						{
							JOptionPane.showMessageDialog(null,	"UNABLE TO INSERT NEW RECORD !!!\nPlease try with valid Data ...",
																"Error", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							setButton(true);
							setFields(false);
						}
					}
					else
					{
						if (editData()==false)
						{
							JOptionPane.showMessageDialog(null,	"UNABLE TO UPDATE RECORD !!!\nPlease try with valid Data ...",
																"Error", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							setButton(true);
							setFields(false);
						}
					}
					//SET FLAG...
					isAdd=false;
					lblRec.setText("");
				}
			}
		});
		btnSave.setBorder(BorderFactory.createRaisedBevelBorder());
		btnSave.setMnemonic('S');
		btnSave.setText("SAVE");
		btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnSave.setIcon(new ImageIcon("images/Save16.gif"));
		btnSave.setBounds(new Rectangle(12, 35, 91, 28));

		btnFirst.setToolTipText("First");
		btnFirst.setText("");
		btnFirst.setIcon(imgFirst);
		btnFirst.setBounds(new Rectangle(152, 8, 22, 23));
		btnFirst.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					hwusr=hwusrcon.moveFirst();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmHWUsers]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnFirst.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnFirst.setIcon(imgFO); }
			public void mouseExited(MouseEvent f)
			{ btnFirst.setIcon(imgFirst); }
		});

		btnNext.setToolTipText("Next");
		btnNext.setText("");
		btnNext.setIcon(imgNext);
		btnNext.setBounds(new Rectangle(355, 8, 22, 23));
		btnNext.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					hwusr=hwusrcon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmHWUsers]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnNext.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnNext.setIcon(imgNO); }
			public void mouseExited(MouseEvent f)
			{ btnNext.setIcon(imgNext); }
		});

		btnPrevious.setToolTipText("Previous");
		btnPrevious.setText("");
		btnPrevious.setIcon(imgPrev);
		btnPrevious.setBounds(new Rectangle(176, 8, 22, 23));
		btnPrevious.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					hwusr=hwusrcon.movePrevious();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmHWUsers]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnPrevious.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnPrevious.setIcon(imgPO); }
			public void mouseExited(MouseEvent f)
			{ btnPrevious.setIcon(imgPrev); }
		});

		btnLast.setToolTipText("Last");
		btnLast.setIcon(imgLast);
		btnLast.setText("");
		btnLast.setBounds(new Rectangle(378, 8, 22, 23));
		btnLast.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					hwusr=hwusrcon.moveLast();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmHWUsers]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnLast.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnLast.setIcon(imgLO); }
			public void mouseExited(MouseEvent f)
			{ btnLast.setIcon(imgLast); }
		});

		btnDelete.setBorder(BorderFactory.createRaisedBevelBorder());
		btnDelete.setMnemonic('D');
		btnDelete.setText("DELETE");
		btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnDelete.setIcon(new ImageIcon("images/Delete16.gif"));
		btnDelete.setBounds(new Rectangle(354, 35, 91, 28));
		btnDelete.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(txtEmpCode.getText().equals(""))
				{  return;}
				DeleteData();
			}
		});
		btnEdit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setButton(false);
				setFields(true);
				btnDT1.setEnabled(false);
				txtBPW.requestFocus();
				lblRec.setText(" Edit Record... ");
			}
		});
		btnEdit.setBorder(BorderFactory.createRaisedBevelBorder());
		btnEdit.setBounds(new Rectangle(107, 35, 91, 28));
		btnEdit.setText("EDIT");
		btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnEdit.setIcon(new ImageIcon("images/EditMnu.gif"));
		btnEdit.setMnemonic('E');
		btnRefresh.setToolTipText("Refresh Database");
		btnRefresh.setBorder(BorderFactory.createRaisedBevelBorder());
		btnRefresh.setMnemonic('B');
		btnRefresh.setIcon(imgRef);
		btnRefresh.setText("REFRESH DB");
		btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnRefresh.setBounds(new Rectangle(201, 35, 149, 28));
		btnRefresh.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ getConnected();}
		});

		lblRec.setBackground(Color.white);
		lblRec.setBounds(new Rectangle(201, 9, 150, 21));
		lblRec.setOpaque(true);
		lblRec.setText("");
		lblRec.setFont(new Font("Tahoma", 1, 12));
		btnCancel.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setButton(true);
				setFields(false);
				getConnected();
				isAdd = false;
				lblRec.setText("");
			}
		});
		btnCancel.setBorder(BorderFactory.createRaisedBevelBorder());
		btnCancel.setBounds(new Rectangle(107, 35, 91, 28));
		btnCancel.setText("CANCEL");
		btnCancel.setIcon(new ImageIcon("images/Cancel.gif"));
		btnCancel.setMnemonic('C');
		btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
		cboOS.setBackground(Color.white);
		cboMessenger.setBackground(Color.white);
		txtEmpCode.setToolTipText("USER's Employee Code");

		TP.setBackground(Color.black);
		TP.setForeground(Color.white);
		TP.setBounds(new Rectangle(4, 42, 567, 386));
		TP.setFont(new java.awt.Font("Monospaced", 1, 12));
		pnlRegister.setBackground(Color.white);
		pnlRegister.setLayout(null);
		pnlSearch.setLayout(null);
		pnlSearch.setBackground(Color.white);
		btnGo.setBounds(new Rectangle(455, 323, 91, 28));
		btnGo.setText("  FIND     ");
		btnGo.setIcon(imgSrc);
		btnGo.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnGo.setBorder(BorderFactory.createRaisedBevelBorder());
		btnGo.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (txtSearch.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Search What ?", "Information Required...", JOptionPane.INFORMATION_MESSAGE, imgExc);
					txtSearch.requestFocus();
				}
				else
				{
					String SQLString = "SELECT * FROM HW_Users WHERE " + cboSearch.getSelectedItem().toString() + "='" + txtSearch.getText() + "';";

					try
					{
						if (hwusrcon.isFound(SQLString))
						{
							hwusr = hwusrcon.SearchData(SQLString);
							StartWorking("LOADING");
							getTableData(SQLString);
							display();
						}
						else
						{
							System.out.println("Record Not Found!");
							JOptionPane.showMessageDialog(null, "Record Not Found!", "Information", JOptionPane.INFORMATION_MESSAGE, imgExc);
							getConnected();
						}

					}catch(RemoteException re)
					{System.out.println("Client [frmHWUsers]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}
				}
			}
		});
		lblPicture.setText("");
		lblPicture.setIcon(imgSearch);
		lblPicture.setBounds(new Rectangle(13, 278, 273, 42));
		sp.getViewport().setBackground(Color.white);
		sp.setToolTipText("Issued Items");
		sp.setBounds(new Rectangle(6, 6, 549, 267));

		cboSearch.setBounds(new Rectangle(350, 326, 101, 24));
		cboSearch.setMaximumRowCount(4);
		cboSearch.setBackground(Color.white);
		txtSearch.setFont(new Font("Tahoma", 1, 12));
		cboSearch.addItem("Datatex");
		cboSearch.addItem("Email");
		cboSearch.addItem("EmpCode");
		cboSearch.addItem("IE");
		cboSearch.addItem("IFM");
		cboSearch.addItem("IP");
		cboSearch.addItem("Messenger");
		cboSearch.addItem("NetworkID");
		cboSearch.addItem("NTDomain");
		cboSearch.addItem("OS");

		txtSearch.setCaretColor(Color.blue);
		txtSearch.setText("");
		txtSearch.setBounds(new Rectangle(15, 326, 330, 24));
		cboIE.setMaximumRowCount(3);
		cboIE.setBounds(new Rectangle(398, 136, 142, 20));
		cboIE.setBackground(Color.white);
		cboIE.addItem("YES");
		cboIE.addItem("NO");

		cboDatatex.setMaximumRowCount(3);
		cboDatatex.setBounds(new Rectangle(115, 185, 142, 20));
		cboDatatex.setBackground(Color.white);
		cboDatatex.addItem("YES");
		cboDatatex.addItem("NO");

		cboIFM.setBackground(Color.white);
		cboIFM.setBounds(new Rectangle(398, 185, 142, 20));
		cboIFM.setMaximumRowCount(3);
		btnDT1.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnDT1_actionPerformed(e); }
		});
		btnDT1.setBounds(new Rectangle(331, 9, 22, 23));
		btnDT1.setIcon(imgTab);
		btnDT1.setText("");
		btnDT1.setToolTipText("DATE SELECTOR");
		btnDT1.setBounds(new Rectangle(518, 11, 22, 23));
		pnlFields.add(txtEmpCode, null);
		pnlFields.add(lblBP, null);
		pnlFields.add(txtBPW, null);
		pnlFields.add(lblIP, null);
		pnlFields.add(txtIP, null);
		pnlFields.add(lblNID, null);
		pnlFields.add(txtNID, null);
		pnlFields.add(lblDNS, null);
		pnlFields.add(txtDNS, null);
		pnlFields.add(lblOS, null);
		pnlFields.add(lblMsng, null);
		pnlFields.add(cboMessenger, null);
		pnlFields.add(lblEmpCode, null);
		pnlFields.add(txtBSPW, null);
		pnlFields.add(txtSubnet, null);
		pnlFields.add(txtGW, null);
		pnlFields.add(txtDate, null);
		pnlFields.add(cboNTD, null);
		pnlFields.add(cboOS, null);
		pnlFields.add(txtEmail, null);
		pnlFields.add(lblDT, null);
		pnlFields.add(lblRem, null);
		pnlFields.add(SPtxtRem, null);
		pnlFields.add(btnSelect, null);
		pnlFields.add(lblIFM, null);
		pnlFields.add(lblDate, null);
		pnlFields.add(lblBSPW, null);
		pnlFields.add(lblSubnet, null);
		pnlFields.add(lblNTD, null);
		pnlFields.add(lblGW, null);
		pnlFields.add(lblIEmail, null);
		pnlFields.add(lblIE, null);
		pnlFields.add(cboIE, null);
		pnlFields.add(cboDatatex, null);
		pnlFields.add(cboIFM, null);
		pnlFields.add(btnDT1, null);
		TP.add(pnlSearch, "DATA VIEW");
		SPtxtRem.getViewport().add(txtRemarks, null);
		TP.add(pnlRegister, "REGISTER");
		pnlSearch.add(sp, null);
		pnlSearch.add(txtSearch, null);
		pnlSearch.add(btnGo, null);
		pnlSearch.add(cboSearch, null);
		pnlSearch.add(lblPicture, null);
		sp.add(Table, null);
		this.getContentPane().add(lblHead, null);
		this.getContentPane().add(TP, null);
		pnlButtons.add(btnNew, null);
		pnlButtons.add(btnEdit, null);
		pnlButtons.add(btnFirst, null);
		pnlButtons.add(btnSave, null);
		pnlButtons.add(btnCancel, null);
		pnlButtons.add(btnRefresh, null);
		pnlButtons.add(btnDelete, null);
		pnlButtons.add(btnClose, null);
		pnlButtons.add(btnLast, null);
		pnlButtons.add(btnNext, null);
		pnlButtons.add(lblRec, null);
		pnlButtons.add(btnPrevious, null);
		pnlRegister.add(pnlFields, null);
		pnlRegister.add(pnlButtons, null);
		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");
		pnlFields.setBackground(Color.white);
		pnlFields.setBorder(titledBorder2);
		pnlFields.setDebugGraphicsOptions(0);
		pnlFields.setBounds(new Rectangle(5, 5, 553, 273));
		pnlFields.setLayout(null);
		txtBPW.setFont(new Font("Tahoma", 1, 12));
		txtBPW.setToolTipText("Bios Password");
		txtBPW.setCaretColor(Color.blue);
		txtBPW.setText("");
		txtBPW.setBounds(new Rectangle(115, 38, 142, 20));
		txtBPW.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtBPW.getText().length()>=8){ke1.consume();}
			}
		});

		lblIP.setBounds(new Rectangle(10, 64, 105, 16));
		lblIP.setText("IP ADDRESS");
		lblIP.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblGW.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblGW.setHorizontalAlignment(SwingConstants.LEFT);
		lblGW.setText("GATEWAY");
		lblGW.setBounds(new Rectangle(271, 113, 105, 16));
		txtSubnet.setFont(new Font("Tahoma", 1, 12));
		txtSubnet.setCaretColor(Color.blue);
		txtSubnet.setBounds(new Rectangle(398, 62, 142, 20));
		txtSubnet.setText("");
		txtSubnet.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtSubnet.getText().length()>=15){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46) || (ke1.getKeyChar()==32)) {}
				else ke1.consume();
			}
		});

		lblBP.setBounds(new Rectangle(10, 40, 105, 16));
		lblBP.setText("BIOS PWD");
		lblBP.setFont(new java.awt.Font("Tahoma", 1, 12));
		txtEmpCode.setText("");
		txtEmpCode.setBounds(new Rectangle(115, 13, 118, 20));
		txtEmpCode.setCaretColor(Color.blue);
		txtEmpCode.setEnabled(false);
		txtEmpCode.setFont(new Font("Tahoma", 1, 12));
		lblEmpCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpCode.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblEmpCode.setText("EMP. CODE");
		lblEmpCode.setBounds(new Rectangle(10, 15, 105, 16));
		lblBSPW.setHorizontalAlignment(SwingConstants.LEFT);
		lblBSPW.setBounds(new Rectangle(271, 39, 105, 16));
		lblBSPW.setText("BIOS SPWD");
		lblBSPW.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblDNS.setBounds(new Rectangle(10, 113, 105, 16));
		lblDNS.setText("DNS");
		lblDNS.setFont(new java.awt.Font("Tahoma", 1, 12));
		txtGW.setText("");
		txtGW.setBounds(new Rectangle(398, 111, 142, 20));
		txtGW.setCaretColor(Color.blue);
		txtGW.setFont(new Font("Tahoma", 1, 12));
		txtGW.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtGW.getText().length()>=15){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46) || (ke1.getKeyChar()==32)) {}
				else ke1.consume();
			}
		});

		lblIE.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblIE.setHorizontalAlignment(SwingConstants.LEFT);
		lblIE.setText("INTERNET EXPLORER");
		lblIE.setBounds(new Rectangle(271, 137, 127, 16));
		txtBSPW.setBounds(new Rectangle(398, 38, 142, 20));
		txtBSPW.setText("");
		txtBSPW.setCaretColor(Color.blue);
		txtBSPW.setFont(new Font("Tahoma", 1, 12));
		txtBSPW.setToolTipText("Bios Supervisor Password");
		txtBSPW.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtBSPW.getText().length()>=8){ke1.consume();}
			}
		});

		lblMsng.setBounds(new Rectangle(10, 162, 105, 16));
		lblMsng.setText("MESSENGER");
		lblMsng.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblSubnet.setBounds(new Rectangle(271, 64, 105, 16));
		lblSubnet.setText("SUBNET");
		lblSubnet.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblSubnet.setHorizontalAlignment(SwingConstants.LEFT);
		txtIP.setFont(new Font("Tahoma", 1, 12));
		txtIP.setCaretColor(Color.blue);
		txtIP.setBounds(new Rectangle(115, 62, 142, 20));
		txtIP.setText("");
		txtIP.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtIP.getText().length()>=15){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46) || (ke1.getKeyChar()==32)) {}
				else ke1.consume();
			}
		});

		txtDNS.setFont(new Font("Tahoma", 1, 12));
		txtDNS.setCaretColor(Color.blue);
		txtDNS.setBounds(new Rectangle(115, 112, 142, 20));
		txtDNS.setText("");
		txtDNS.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtDNS.getText().length()>=15){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46) || (ke1.getKeyChar()==32)) {}
				else ke1.consume();
			}
		});

		lblRem.setBounds(new Rectangle(11, 211, 105, 16));
		lblRem.setText("REMARKS");
		lblRem.setFont(new java.awt.Font("Tahoma", 1, 12));
		SPtxtRem.getViewport().setBackground(Color.white);
		SPtxtRem.setBounds(new Rectangle(115, 210, 425, 51));
		lblDate.setBounds(new Rectangle(271, 15, 105, 16));
		lblDate.setText("DATE");
		lblDate.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblNID.setBounds(new Rectangle(10, 89, 105, 16));
		lblNID.setText("NETWORD ID");
		lblNID.setFont(new java.awt.Font("Tahoma", 1, 12));
		txtNID.setFont(new Font("Tahoma", 1, 12));
		txtNID.setCaretColor(Color.blue);
		txtNID.setBounds(new Rectangle(115, 87, 142, 20));
		txtNID.setText("");
		txtNID.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtNID.getText().length()>=15){ke1.consume();}
			}
		});
		txtNID.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtNID.selectAll(); }
			public void focusLost(FocusEvent f)
			{
				String a = txtNID.getText();
				txtNID.setText(a.toUpperCase());
			}
		});

		lblNTD.setBounds(new Rectangle(271, 88, 105, 16));
		lblNTD.setText("NT DOMAIN");
		lblNTD.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblNTD.setHorizontalAlignment(SwingConstants.LEFT);
		txtDate.setEnabled(false);
		txtDate.setFont(new Font("Tahoma", 1, 12));
		txtDate.setCaretColor(Color.blue);
		txtDate.setBounds(new Rectangle(398, 13, 118, 20));
		txtDate.setText("");
		lblOS.setBounds(new Rectangle(10, 138, 105, 16));
		lblOS.setText("OS");
		lblOS.setFont(new java.awt.Font("Tahoma", 1, 12));

		txtRemarks.setFont(new Font("Tahoma", 1, 12));
		txtRemarks.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1)
			{
				if (ke1.getKeyCode() == KeyEvent.VK_TAB)
				{ btnSave.requestFocus(); }
			}
			public void KeyReleased(KeyEvent ke2) {}
			public void KeyTyped(KeyEvent ke3) {}
		});

		cboMessenger.setMaximumRowCount(3);
		cboMessenger.setBounds(new Rectangle(115, 161, 142, 20));
		btnSelect.setToolTipText("Select a Particular User Record");
		btnSelect.setBorder(BorderFactory.createRaisedBevelBorder());
		btnSelect.setIcon(imgTab);
		btnSelect.setBounds(new Rectangle(235, 11, 22, 23));
		btnSelect.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnSelect_actionPerformed(e); }
		});
		cboNTD.setBounds(new Rectangle(398, 87, 142, 20));
		cboNTD.setMaximumRowCount(3);
		cboNTD.setBackground(Color.white);
		cboOS.setBounds(new Rectangle(115, 136, 142, 20));
		cboOS.setMaximumRowCount(3);
		lblIEmail.setBounds(new Rectangle(271, 162, 105, 16));
		lblIEmail.setText("EMAIL");
		lblIEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblIEmail.setFont(new java.awt.Font("Tahoma", 1, 12));
		txtEmail.setFont(new Font("Tahoma", 1, 12));
		txtEmail.setCaretColor(Color.blue);
		txtEmail.setBounds(new Rectangle(398, 160, 142, 20));
		txtEmail.setText("");
		txtEmail.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtEmail.getText().length()>=25){ke1.consume();}
				if((ke1.getKeyChar()>=65 && ke1.getKeyChar()<=90 ) || (ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()>=97 && ke1.getKeyChar()<=122 ) || (ke1.getKeyChar()=='@') || (ke1.getKeyChar()==46) || (ke1.getKeyChar()==45) || (ke1.getKeyChar()==109) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==95)) {}
				else ke1.consume();
			}
		});
		txtEmail.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtEmail.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		lblIFM.setBounds(new Rectangle(271, 186, 105, 16));
		lblIFM.setText("IFM");
		lblIFM.setHorizontalAlignment(SwingConstants.LEFT);
		lblIFM.setFont(new java.awt.Font("Tahoma", 1, 12));

		lblDT.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblDT.setText("DATATEX");
		lblDT.setBounds(new Rectangle(11, 187, 105, 16));

		cboMessenger.addItem("MSN");
		cboMessenger.addItem("Yahoo");
		cboMessenger.addItem("Both");
		cboMessenger.addItem("None");

		cboNTD.addItem("BTLSITE");
		cboNTD.addItem("PDCA");
		cboNTD.addItem("OTHER");

		cboOS.addItem("Windows 95");
		cboOS.addItem("Windows 98");
		cboOS.addItem("Windows NT");
		cboOS.addItem("Windows 2000");
		cboOS.addItem("Windows XP");
		cboOS.addItem("Linux");
		cboOS.addItem("Unix");

		cboIFM.addItem("YES");
		cboIFM.addItem("NO");

		this.setTitle("HARDWARE USER REGISTRATION");
		this.getContentPane().setBackground(Color.white);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(false);
		this.setSize(new Dimension(588, 468));
		this.setFrameIcon(imgIco);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(TP, null);
		this.getContentPane().add(lblHead, null);

		setButton(true);
		setFields(false);
		getConnected();

	}//jbInit

	/**
	*	getConnecteds Table
	*
	*/

	public void getConnected()
	{
		//CONNECT TABLE
		try
		{
			hwusrcon.Connect();
		}catch(RemoteException re){ System.out.println("Client [frmHWUsers]: Open Error");System.out.println("Error: "+re.getMessage());}

		//DISPLAY DATA RMI
		try
		{
			hwusr = hwusrcon.moveNext();
			display();
		}catch(RemoteException re){ System.out.println("Client [frmHWUsers]: Show Error");System.out.println("Error: "+re.getMessage());}

		SQL="SELECT * FROM HW_Users ORDER BY EmpCode;";
		getTableData(SQL);
	}

	/**
	*	Sets Button States
	*	@param boolean true or false
	*
	*/

	public void setButton(boolean btnValue)
	{
		btnNew.setVisible(btnValue);
		btnEdit.setVisible(btnValue);
		btnSave.setVisible(!btnValue);
		btnCancel.setVisible(!btnValue);
		btnDelete.setEnabled(btnValue);
		btnClose.setEnabled(btnValue);
		btnFirst.setEnabled(btnValue);
		btnPrevious.setEnabled(btnValue);
		btnNext.setEnabled(btnValue);
		btnLast.setEnabled(btnValue);
		btnSelect.setEnabled(!btnValue);
		btnRefresh.setEnabled(btnValue);

		btnDT1.setEnabled(!btnValue);
	}

	/**
	*	Sets Fields States
	*	@param boolean true or false
	*
	*/

	public void setFields(boolean txtValue)
	{
		txtBPW.setEnabled(txtValue);
		txtBSPW.setEnabled(txtValue);
		txtIP.setEnabled(txtValue);
		txtSubnet.setEnabled(txtValue);
		txtNID.setEnabled(txtValue);
		cboNTD.setEnabled(txtValue);
		txtDNS.setEnabled(txtValue);
		txtGW.setEnabled(txtValue);
		cboOS.setEnabled(txtValue);
		cboIE.setEnabled(txtValue);
		cboMessenger.setEnabled(txtValue);
		txtEmail.setEnabled(txtValue);
		cboDatatex.setEnabled(txtValue);
		cboIFM.setEnabled(txtValue);
		txtRemarks.setEnabled(txtValue);
	}

	/**
	*	Clear Text From Fields
	*
	*/

	public void clearFields()
	{
		txtEmpCode.setText("");
		txtDate.setText("");
		txtBPW.setText("");
		txtBSPW.setText("");
		txtIP.setText("");
		txtGW.setText("");
		txtSubnet.setText("");
		txtNID.setText("");
		txtDNS.setText("");
		txtEmail.setText("");
		txtRemarks.setText("");
	}

	/**
	*	Display Data
	*
	*/

	public void display()
	{
		txtEmpCode.setText(hwusr.getEmpCode());
		txtDate.setText(hwusr.getDate());
		txtBPW.setText(hwusr.getBIOS_PW());
		txtBSPW.setText(hwusr.getBIOS_SPW());
		txtIP.setText(hwusr.getIP());
		txtSubnet.setText(hwusr.getSubnet());
		txtNID.setText(hwusr.getNetworkID());
		cboNTD.setSelectedItem(hwusr.getNTDomain());
		txtDNS.setText(hwusr.getDNS());
		txtGW.setText(hwusr.getGW());
		cboOS.setSelectedItem(hwusr.getOS());
		cboIE.setSelectedItem(hwusr.getIE());
		cboMessenger.setSelectedItem(hwusr.getMessenger());
		txtEmail.setText(hwusr.getEmail());
		cboDatatex.setSelectedItem(hwusr.getDatatex());
		cboIFM.setSelectedItem(hwusr.getIFM());
		txtRemarks.setText(hwusr.getRemarks());
	}

	/**
	*	Checks the Fields
	*
	*	@return boolean true or false value
	*/

	public boolean checkFields()
	{
		if (txtEmpCode.getText().equals("")) {JOptionPane.showMessageDialog(null, "Please Provide Employee Code !!!","Missing Information",JOptionPane.ERROR_MESSAGE);return false;}
		if (txtBPW.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide BIOS Password!","Missing Information",JOptionPane.ERROR_MESSAGE);txtBPW.requestFocus();return false;}
		if (txtBSPW.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide BIOS Supervisor Password!","Missing Information",JOptionPane.ERROR_MESSAGE);txtBSPW.requestFocus();return false;}
		if (txtIP.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide IP Address!","Missing Information",JOptionPane.ERROR_MESSAGE);txtIP.requestFocus();return false;}
		if (txtSubnet.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Subnet!","Missing Information",JOptionPane.ERROR_MESSAGE);txtSubnet.requestFocus();return false;}
		if (txtNID.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Network ID!","Missing Information",JOptionPane.ERROR_MESSAGE);txtNID.requestFocus();return false;}
		if (txtDNS.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide DNS!","Missing Information",JOptionPane.ERROR_MESSAGE);txtDNS.requestFocus();return false;}
		if (txtGW.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Gateway!","Missing Information",JOptionPane.ERROR_MESSAGE);txtGW.requestFocus();return false;}
		if (txtEmail.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Email!","Missing Information",JOptionPane.ERROR_MESSAGE);txtEmail.requestFocus();return false;}
		if (txtRemarks.getText().equals("")){txtRemarks.setText("-");}
		return true;
	}

	/**
	*	Requests Server to Add New Record
	*
	*	@return boolean true or false value
	*/

	public boolean save()
	{//Save
		boolean savesucc=false;

		//INITIALISE USER OBJECT...
		hwusr.setEmpCode(txtEmpCode.getText());
		hwusr.setDate(txtDate.getText());
		hwusr.setBIOS_PW(txtBPW.getText());
		hwusr.setBIOS_SPW(txtBSPW.getText());
		hwusr.setIP(txtIP.getText());
		hwusr.setSubnet(txtSubnet.getText());
		hwusr.setNetworkID(txtNID.getText());
		hwusr.setNTDomain(cboNTD.getSelectedItem()+"");
		hwusr.setDNS(txtDNS.getText());
		hwusr.setGW(txtGW.getText());
		hwusr.setOS(cboOS.getSelectedItem()+"");
		hwusr.setIE(cboIE.getSelectedItem()+"");
		hwusr.setMessenger(cboMessenger.getSelectedItem()+"");
		hwusr.setEmail(txtEmail.getText());
		hwusr.setDatatex(cboDatatex.getSelectedItem()+"");
		hwusr.setIFM(cboIFM.getSelectedItem()+"");
		hwusr.setRemarks(txtRemarks.getText());

		try
		{
			savesucc = hwusrcon.insertData(hwusr);
			StartWorking("ADDING NEW RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmHWUsers]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmHWUsers]: "+re.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			return savesucc;
		}

		return savesucc;
	}//Save

	/**
	*	Requests Server to Update a Specific Record
	*
	*	@return boolean true or false value
	*/

	public boolean editData()
	{//Edit Data
		boolean updatesucc=false;

		//INITIALISE USER OBJECT...
		hwusr.setEmpCode(txtEmpCode.getText());
		hwusr.setDate(txtDate.getText());
		hwusr.setBIOS_PW(txtBPW.getText());
		hwusr.setBIOS_SPW(txtBSPW.getText());
		hwusr.setIP(txtIP.getText());
		hwusr.setSubnet(txtSubnet.getText());
		hwusr.setNetworkID(txtNID.getText());
		hwusr.setNTDomain(cboNTD.getSelectedItem()+"");
		hwusr.setDNS(txtDNS.getText());
		hwusr.setGW(txtGW.getText());
		hwusr.setOS(cboOS.getSelectedItem()+"");
		hwusr.setIE(cboIE.getSelectedItem()+"");
		hwusr.setMessenger(cboMessenger.getSelectedItem()+"");
		hwusr.setEmail(txtEmail.getText());
		hwusr.setDatatex(cboDatatex.getSelectedItem()+"");
		hwusr.setIFM(cboIFM.getSelectedItem()+"");
		hwusr.setRemarks(txtRemarks.getText());

		try
		{
			updatesucc = hwusrcon.updateData(hwusr);
			StartWorking("UPDATING RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmHWUsers]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmHWUsers]: "+re.getMessage(),
												"Error", JOptionPane.ERROR_MESSAGE);
			return updatesucc;
		}

		return updatesucc;
	}//Edit Data

	/**
	*	Requests Server to Delete a Specific Record
	*
	*/

	public void DeleteData()
	{//Delete Data
		String strQuery = "DELETE FROM HW_Users WHERE EmpCode='" + txtEmpCode.getText() + "';";

		int yn;
		yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
		JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
			try
			{
				hwusrcon.DeleteData(strQuery);
				StartWorking("DELETING RECORD");
				JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
				clearFields();
				getConnected();

			}catch(RemoteException re)
			{
				System.out.println("Client [frmHWUsers]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
				JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmHWUsers]: "+re.getMessage(),
													"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {}
	}//Delete Data

	/**
	*	Gets Table Data
	*	@param String SQL
	*
	*/

	void getTableData(String SQLString)
	{
		try
		{
			rows = ctccon.getRowData(SQLString);
			ColHead = ctccon.getColumnData(SQLString);
			TotalCol = ctccon.getColNo(SQLString);

		}catch(RemoteException re)
		{
			System.out.println("Client [frmHWUsers]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmHWUsers]: "+re.getMessage(),
												"Error", JOptionPane.ERROR_MESSAGE);
		}

		Table = new JTable(rows, ColHead);
		setColWidth(SQL, Table);
		sp.getViewport().add(Table);
		Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Table.setFont(new java.awt.Font("Tahoma", 0, 11));

		Table.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				int x[] = Table.getSelectedRows();

				if (x.length >= 1)
				{
					SelRow = new String[x.length][TotalCol];
					System.out.println("\nSELECTED ROW: ");
					for (int i = 0; i < x.length; i++)
					{
						for (int j = 0; j < TotalCol; j++)
						{
							SelRow[i][j] = Table.getValueAt(x[i], j).toString();
							System.out.print(SelRow[i][j]+" * ");
						}
					}
					txtEmpCode.setText(SelRow[0][0]);txtDate.setText(SelRow[0][1]);txtBPW.setText(SelRow[0][2]);txtBSPW.setText(SelRow[0][3]);txtIP.setText(SelRow[0][4]);txtSubnet.setText(SelRow[0][5]);txtNID.setText(SelRow[0][6]);cboNTD.setSelectedItem(SelRow[0][7]);txtDNS.setText(SelRow[0][8]);txtGW.setText(SelRow[0][9]);cboOS.setSelectedItem(SelRow[0][10]);cboIE.setSelectedItem(SelRow[0][11]);cboMessenger.setSelectedItem(SelRow[0][12]);txtEmail.setText(SelRow[0][13]);cboDatatex.setSelectedItem(SelRow[0][14]);cboIFM.setSelectedItem(SelRow[0][15]);txtRemarks.setText(SelRow[0][16]);
				}
				else if (x.length < 1)
				{
					JOptionPane.showMessageDialog(null, "Please Select One Item!",
					"Information Required...",
					JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	*	Sets Column Widths of Table
	*	@param String SQL, @param JTable Table
	*
	*/

	void setColWidth(String SQLString, JTable Table)
	{
		TableColumn column = null;
		int[] sz = new int[17];
		sz[0]=50;sz[1]=60;sz[2]=70;sz[3]=70;sz[4]=100;sz[5]=100;sz[6]=100;sz[7]=100;
		sz[8]=100;sz[9]=100;sz[10]=100;sz[11]=50;sz[12]=70;sz[13]=200;sz[14]=50;
		sz[15]=50;sz[16]=200;
		for (int j = 0; j < TotalCol; ++j)
		{
			column = Table.getColumnModel().getColumn(j);
			column.setPreferredWidth(sz[j]);
		}
	}

	void btnSelect_actionPerformed(ActionEvent e)
	{
		frmList lst = new frmList("EMPLOYEE INFORMATION", "SELECT EmpCode, Name, Designation, Department, Ext FROM Employees ORDER BY EmpCode;");
		lst.setVisible(true);

		String t[][] = lst.getType();
		if(t!=null)
		{
			txtEmpCode.setText(t[0][0]);
			txtBPW.requestFocus();
		}
	}

	void btnDT1_actionPerformed(ActionEvent e)
	{
		frmDate fd = new frmDate("Select Date");
		fd.setSize(new Dimension(212, 163));
		fd.setVisible(true);
		String SDate = fd.createDate();
		txtDate.setText(SDate);
	}

	/**
	*	Progress Bar
	*
	*/

	private void StartWorking(String t)
	{
		frmWork w = new frmWork(t);
		w.setSize(368, 140);
		w.setVisible(true);
	}

}//Class