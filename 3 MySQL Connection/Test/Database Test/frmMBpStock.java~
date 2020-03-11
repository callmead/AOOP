package beximtex;
/**
 * <p>Title: BeximTex, Mobile Phone Stock</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import java.rmi.*;

public class frmMBpStock extends JInternalFrame
{//Class

	JTabbedPane TP = new JTabbedPane();
	JPanel pnlReg = new JPanel();
	JPanel pnlDV = new JPanel();
	TitledBorder titledBorder1;
	TitledBorder titledBorder2;
	TitledBorder titledBorder3;
	JPanel pnlFields = new JPanel();
	TitledBorder titledBorder4;
	TitledBorder titledBorder5;
	JTextField txtSID = new JTextField();
	JTextField txtDate = new JTextField();
	JLabel lblSID = new JLabel();
	JLabel lblBrand = new JLabel();
	JTextField txtEmpCode = new JTextField();
	JLabel lblDate = new JLabel();
	JTextField txtName = new JTextField();
	JLabel lblName = new JLabel();
	JTextField txtSNo = new JTextField();
	JLabel lblSNo = new JLabel();
	JTextField txtRemarks = new JTextField();
	JLabel lblRem = new JLabel();
	JPanel pnlButtons = new JPanel();
	TitledBorder titledBorder6;
	TitledBorder titledBorder7;
	JButton btnDelete = new JButton();
	JButton btnClose = new JButton();
	JLabel lblRec = new JLabel();
	JButton btnSave = new JButton();
	JButton btnCancel = new JButton();
	JButton btnEdit = new JButton();
	JButton btnNew = new JButton();
	JToggleButton btnLast = new JToggleButton();
	JButton btnRefresh = new JButton();
	JToggleButton btnPrevious = new JToggleButton();
	JToggleButton btnNext = new JToggleButton();
	JToggleButton btnFirst = new JToggleButton();
	TitledBorder titledBorder8;
	JPanel pnlTab = new JPanel();
	TitledBorder titledBorder9;
	TitledBorder titledBorder10;
	JScrollPane sp = new JScrollPane();
	JTable Table = new JTable();
	JPanel pnlFieldsRE = new JPanel();
	TitledBorder titledBorder11;
	TitledBorder titledBorder12;
	JPanel pnlSearch = new JPanel();
	TitledBorder titledBorder13;
	TitledBorder titledBorder14;
	JButton btnGo = new JButton();
	JLabel lblPicture = new JLabel();
	JComboBox cboSearch = new JComboBox();
	JTextField txtSearch = new JTextField();

	//**************************************************************
	//RMI Declare Server Object
	MBpStockController mbpscon;
	MBpStock mbps = new MBpStock();

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
	ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
	ImageIcon imgTab = new ImageIcon("./Images/table.gif");
	ImageIcon imgSrc = new ImageIcon("./Images/find.png");
	ImageIcon imgRef = new ImageIcon("./Images/db.gif");
	ImageIcon imgHead = new ImageIcon("./Images/touch.gif");
	ImageIcon imgSearch = new ImageIcon("./Images/powerSearch.gif");
	ImageIcon imgExc = new ImageIcon("./Images/exc.gif");
	ImageIcon imgQ = new ImageIcon("./Images/question32.png");

	int yn;
	boolean isAdd = false;

	String Type[][];
	String SelRow[][];

	String EmpCode = null;
	String TableName = null;

	String CurrentDate = null;
	String TranID = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date d;

	String SQL = null;
	String SQL1 = null;

	Vector ColHead = new Vector();
	Vector rows = new Vector();

	int TotalCol = 0;
	int Rows = 0;
	int Columns = 0;

	JTextField txtModel = new JTextField();
	JLabel lblModel = new JLabel();
	JTextField txtBrand = new JTextField();
	JTextField txtWar = new JTextField();
	JComboBox cboQuality = new JComboBox();
	JComboBox cboIS = new JComboBox();
	JLabel lblWar = new JLabel();
	JLabel lblQuality = new JLabel();
	JLabel lblIS = new JLabel();
	JToggleButton btnDT1 = new JToggleButton();
	JLabel lblHead = new JLabel();

	public frmMBpStock(String ec)
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
			mbpscon = (MBpStockController)Naming.lookup(new ReadHost().getHost() + "MBpStockController");
			ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmMBpStock] \n******************************\n");
		//**************************************************************

		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");
		titledBorder3 = new TitledBorder("");
		titledBorder4 = new TitledBorder("");
		titledBorder5 = new TitledBorder("");
		titledBorder6 = new TitledBorder("");
		titledBorder7 = new TitledBorder("");
		titledBorder8 = new TitledBorder("");
		titledBorder9 = new TitledBorder("");
		titledBorder10 = new TitledBorder("");
		titledBorder11 = new TitledBorder("");
		titledBorder12 = new TitledBorder("");
		titledBorder13 = new TitledBorder("");
		titledBorder14 = new TitledBorder("");

		this.setTitle("MOBILE PHONE STOCK");
		this.getContentPane().setLayout(null);
		this.setForeground(Color.white);
		this.setFrameIcon(imgIco);
		this.getContentPane().setBackground(Color.white);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(false);
		this.setSize(new Dimension(596, 471));

		TP.setBackground(Color.lightGray);
		TP.setFont(new java.awt.Font("Monospaced", 1, 12));
		TP.setForeground(Color.white);
		TP.setBounds(new Rectangle(7, 42, 572, 285));

		pnlReg.setBackground(Color.white);
		pnlReg.setForeground(Color.white);
		pnlReg.setBorder(titledBorder2);
		pnlReg.setLayout(null);
		pnlDV.setBackground(Color.white);
		pnlDV.setBorder(titledBorder3);
		pnlDV.setLayout(null);
		pnlFields.setBackground(Color.white);
		pnlFields.setBorder(titledBorder5);
		pnlFields.setBounds(new Rectangle(8, 9, 550, 160));
		pnlFields.setLayout(null);

		lblSID.setText("SET ID");
		lblSID.setBounds(new Rectangle(10, 8, 102, 24));
		lblSID.setFont(new java.awt.Font("Tahoma", 1, 11));

		txtSID.setText("");
		txtSID.setBounds(new Rectangle(121, 9, 140, 23));
		txtSID.setEnabled(false);
		txtSID.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtSID.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtSID.selectAll();}
			public void focusLost(FocusEvent f){}
		});


		txtDate.setBounds(new Rectangle(399, 9, 114, 23));
		txtDate.setEnabled(false);
		txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtDate.setText("");

		lblBrand.setBounds(new Rectangle(278, 37, 106, 24));
		lblBrand.setText("BRAND");
		lblBrand.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblBrand.setHorizontalAlignment(SwingConstants.RIGHT);

		lblDate.setBounds(new Rectangle(343, 8, 41, 24));
		lblDate.setText("DATE");
		lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);

		txtName.setText("");
		txtName.setBounds(new Rectangle(121, 38, 140, 23));
		txtName.setEnabled(true);
		txtName.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtName.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtName.selectAll();}
			public void focusLost(FocusEvent f)	{}
		});

		lblName.setText("SET NAME");
		lblName.setBounds(new Rectangle(10, 37, 106, 24));
		lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblName.setToolTipText("");

		txtSNo.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtSNo.setBounds(new Rectangle(399, 67, 140, 23));
		txtSNo.setText("");
		txtSNo.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtSNo.selectAll();}
			public void focusLost(FocusEvent f)	{}
		});

		txtSNo.setEnabled(true);
		lblSNo.setToolTipText("");
		lblSNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSNo.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblSNo.setBounds(new Rectangle(278, 66, 106, 24));
		lblSNo.setText("SERIAL");
		txtRemarks.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtRemarks.setBounds(new Rectangle(399, 124, 140, 23));
		txtRemarks.setText("");
		txtRemarks.setEnabled(true);
		txtRemarks.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtRemarks.selectAll();}
			public void focusLost(FocusEvent f)	{}
		});

		lblRem.setToolTipText("");
		lblRem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRem.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblRem.setBounds(new Rectangle(278, 123, 106, 24));
		lblRem.setText("REMARKS");
		pnlButtons.setBackground(Color.white);
		pnlButtons.setBorder(titledBorder7);
		pnlButtons.setMaximumSize(new Dimension(32767, 32767));
		pnlButtons.setBounds(new Rectangle(8, 175, 550, 74));
		pnlButtons.setLayout(null);
		btnDelete.setBorder(BorderFactory.createRaisedBevelBorder());
		btnDelete.setMnemonic('D');
		btnDelete.setText("DELETE");
		btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnDelete.setIcon(new ImageIcon("images/Delete16.gif"));
		btnDelete.setBounds(new Rectangle(352, 36, 91, 28));
		btnDelete.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(txtSID.getText().equals(""))
				{ return; }
				DeleteData();
			}
		});
		btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
		btnClose.setMnemonic('L');
		btnClose.setText("CLOSE");
		btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnClose.setIcon(new ImageIcon("./Images/close.gif"));
		btnClose.setBounds(new Rectangle(446, 36, 91, 28));
		btnClose.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ dispose(); }
		});
		lblRec.setBackground(Color.white);
		lblRec.setBounds(new Rectangle(199, 10, 150, 21));
		lblRec.setOpaque(true);
		lblRec.setText("");
		lblRec.setFont(new Font("Tahoma", 1, 12));

		btnSave.setBorder(BorderFactory.createRaisedBevelBorder());
		btnSave.setMnemonic('S');
		btnSave.setText("SAVE");
		btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnSave.setIcon(new ImageIcon("images/Save16.gif"));
		btnSave.setBounds(new Rectangle(10, 36, 91, 28));
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

		btnCancel.setBorder(BorderFactory.createRaisedBevelBorder());
		btnCancel.setBounds(new Rectangle(104, 36, 91, 28));
		btnCancel.setText("CANCEL");
		btnCancel.setMnemonic('C');
		btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
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

		btnEdit.setBorder(BorderFactory.createRaisedBevelBorder());
		btnEdit.setBounds(new Rectangle(104, 36, 91, 28));
		btnEdit.setText("EDIT");
		btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnEdit.setMnemonic('E');
		btnEdit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setButton(false);
				setFields(true);
				btnDT1.setEnabled(false);
				txtName.requestFocus();
				lblRec.setText(" Edit Record... ");
			}
		});

		btnNew.setBorder(BorderFactory.createRaisedBevelBorder());
		btnNew.setBounds(new Rectangle(10, 36, 91, 28));
		btnNew.setText("NEW");
		btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnNew.setMnemonic('N');
		btnNew.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				isAdd = true;
				setButton(false);
				setFields(true);
				clearFields();
				txtEmpCode.setText(EmpCode);
				d = new Date();
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				CurrentDate = sdf.format(d);
				txtDate.setText(CurrentDate);
				d = new Date();
				CurrentDate = null;
				sdf = new SimpleDateFormat("y");
				TranID = sdf.format(d);
				sdf = new SimpleDateFormat("M");
				TranID = TranID + sdf.format(d);
				sdf = new SimpleDateFormat("d");
				TranID = TranID + sdf.format(d);
				sdf = new SimpleDateFormat("Hms");
				TranID = TranID + sdf.format(d);
				txtSID.setText("MB"+TranID);
				System.out.println("Transaction ID: " + txtSID.getText());

				txtName.requestFocus();
				cboIS.setSelectedItem("No");
				cboIS.setEnabled(false);
				cboQuality.setSelectedItem("New");
				lblRec.setText(" Add New Record... ");
			}
		});

		btnLast.setToolTipText("Last");
		btnLast.setText("");
		btnLast.setIcon(imgLast);
		btnLast.setBounds(new Rectangle(376, 9, 22, 23));
		btnLast.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					mbps=mbpscon.moveLast();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBpStock]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnLast.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnLast.setIcon(imgLO);}

			public void mouseExited(MouseEvent f)
			{ btnLast.setIcon(imgLast);}
		});
		btnRefresh.setToolTipText("Refresh Database");
		btnRefresh.setBorder(BorderFactory.createRaisedBevelBorder());
		btnRefresh.setMnemonic('B');
		btnRefresh.setIcon(imgRef);
		btnRefresh.setText("REFRESH DB");
		btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnRefresh.setBounds(new Rectangle(199, 36, 149, 28));
		btnRefresh.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ getConnected();}
		});
		btnPrevious.setToolTipText("Previous");
		btnPrevious.setText("");
		btnPrevious.setIcon(imgPrev);
		btnPrevious.setBounds(new Rectangle(174, 9, 22, 23));
		btnPrevious.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					mbps=mbpscon.movePrevious();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBpStock]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnPrevious.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnPrevious.setIcon(imgPO); }
			public void mouseExited(MouseEvent f)
			{ btnPrevious.setIcon(imgPrev); }
		});
		btnNext.setToolTipText("Next");
		btnNext.setText("");
		btnNext.setIcon(imgNext);
		btnNext.setBounds(new Rectangle(353, 9, 22, 23));
		btnNext.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					mbps=mbpscon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBpStock]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnNext.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnNext.setIcon(imgNO); }

			public void mouseExited(MouseEvent f)
			{ btnNext.setIcon(imgNext); }
		});
		btnFirst.setToolTipText("First");
		btnFirst.setText("");
		btnFirst.setIcon(imgFirst);
		btnFirst.setBounds(new Rectangle(150, 9, 22, 23));
		btnFirst.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					mbps=mbpscon.moveFirst();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBpStock]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnFirst.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnFirst.setIcon(imgFO); }
			public void mouseExited(MouseEvent f)
			{ btnFirst.setIcon(imgFirst); }
		});
		pnlTab.setBounds(new Rectangle(6, 8, 554, 243));
		pnlTab.setLayout(null);
		pnlTab.setBackground(Color.white);
		pnlTab.setBorder(titledBorder9);
		sp.getViewport().setBackground(Color.white);
		sp.setToolTipText("MOBILE PHONE STOCK");
		sp.setBounds(new Rectangle(6, 6, 540, 229));
		pnlFieldsRE.setBackground(Color.white);
		pnlFieldsRE.setBorder(titledBorder12);
		pnlFieldsRE.setBounds(new Rectangle(6, 158, 554, 60));
		pnlFieldsRE.setLayout(null);
		pnlSearch.setBackground(Color.white);
		pnlSearch.setBorder(titledBorder14);
		pnlSearch.setBounds(new Rectangle(7, 333, 572, 98));
		pnlSearch.setLayout(null);

		btnGo.setBounds(new Rectangle(459, 60, 91, 28));
		btnGo.setText("  FIND     ");
		btnGo.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnGo_actionPerformed(e);	}
		});
		btnGo.setIcon(imgSrc);
		btnGo.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnGo.setBorder(BorderFactory.createRaisedBevelBorder());
		lblPicture.setText("");
		lblPicture.setIcon(imgSearch);
		lblPicture.setBounds(new Rectangle(17, 15, 273, 42));
		cboSearch.setBounds(new Rectangle(354, 63, 101, 24));
		cboSearch.setMaximumRowCount(4);
		cboSearch.setBackground(Color.white);
		txtSearch.setFont(new Font("Tahoma", 1, 12));
		txtSearch.setCaretColor(Color.blue);
		txtSearch.setText("");
		txtSearch.setBounds(new Rectangle(19, 63, 330, 24));
		txtSearch.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtSearch.selectAll();}
			public void focusLost(FocusEvent f) {}
		});

		txtModel.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtModel.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtModel.selectAll();}
			public void focusLost(FocusEvent f) {}
		});
		lblModel.setToolTipText("");
		lblModel.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblModel.setBounds(new Rectangle(10, 66, 106, 24));
		lblModel.setText("MODEL");
		txtModel.setBounds(new Rectangle(121, 67, 140, 23));

		txtBrand.setBounds(new Rectangle(399, 38, 140, 23));
		txtBrand.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtBrand.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtBrand.selectAll();	}
			public void focusLost(FocusEvent f) {}
		});

		txtWar.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtWar.setText("");
		txtWar.setBounds(new Rectangle(121, 124, 140, 23));
		txtWar.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtWar.selectAll();}
			public void focusLost(FocusEvent f) {}
		});
		cboQuality.setBounds(new Rectangle(121, 95, 140, 23));
		cboQuality.setToolTipText("");
		cboQuality.setMaximumRowCount(4);
		cboQuality.setBackground(Color.white);
		cboIS.setBackground(Color.white);
		cboIS.setMaximumRowCount(3);
		cboIS.setToolTipText("");
		cboIS.setBounds(new Rectangle(399, 95, 140, 23));
		lblWar.setHorizontalAlignment(SwingConstants.LEFT);
		lblWar.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblWar.setText("WARRANTY");
		lblWar.setBounds(new Rectangle(10, 124, 75, 24));
		lblQuality.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQuality.setBounds(new Rectangle(10, 94, 75, 24));
		lblQuality.setText("QUALITY");
		lblIS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIS.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblIS.setText("ISSUED");
		lblIS.setBounds(new Rectangle(319, 94, 65, 24));
		btnDT1.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnDT1_actionPerformed(e);}
		});
		btnDT1.setBounds(new Rectangle(517, 9, 22, 23));
		btnDT1.setIcon(imgTab);
		btnDT1.setText("");
		btnDT1.setToolTipText("DATE SELECTOR");
		lblHead.setBounds(new Rectangle(0, 0, 534, 60));
		lblHead.setIcon(imgHead);
		pnlFields.add(txtEmpCode, null);
		pnlFields.add(lblSID, null);
		pnlFields.add(lblName, null);
		pnlFields.add(txtSNo, null);
		pnlFields.add(txtRemarks, null);
		pnlFields.add(lblModel, null);
		pnlFields.add(txtBrand, null);
		pnlFields.add(txtDate, null);
		pnlFields.add(lblQuality, null);
		pnlFields.add(lblWar, null);
		pnlFields.add(cboIS, null);
		pnlFields.add(cboQuality, null);
		pnlFields.add(txtWar, null);
		pnlFields.add(txtSID, null);
		pnlFields.add(txtName, null);
		pnlFields.add(txtModel, null);
		pnlFields.add(lblIS, null);
		pnlFields.add(lblRem, null);
		pnlFields.add(lblDate, null);
		pnlFields.add(lblBrand, null);
		pnlFields.add(lblSNo, null);
		pnlFields.add(btnDT1, null);


		pnlButtons.add(btnEdit, null);
		pnlButtons.add(btnNew, null);
		pnlButtons.add(btnRefresh, null);
		pnlButtons.add(btnSave, null);
		pnlButtons.add(btnDelete, null);
		pnlButtons.add(lblRec, null);
		pnlButtons.add(btnClose, null);
		pnlButtons.add(btnCancel, null);
		pnlButtons.add(btnPrevious, null);
		pnlButtons.add(btnLast, null);
		pnlButtons.add(btnNext, null);
		pnlButtons.add(btnFirst, null);
		pnlReg.add(pnlFields, null);
		pnlReg.add(pnlButtons, null);

		pnlDV.add(pnlTab, null);
		pnlTab.add(sp, null);
		pnlDV.add(pnlFieldsRE, null);
		TP.add(pnlReg, "REGISTER");
		sp.add(Table, null);
		TP.add(pnlDV, "VIEW DATA");
		this.getContentPane().add(TP, null);
		this.getContentPane().add(pnlSearch, null);
		pnlSearch.add(btnGo, null);
		pnlSearch.add(lblPicture, null);
		pnlSearch.add(txtSearch, null);
		pnlSearch.add(cboSearch, null);

		getComboItems();

		this.getContentPane().add(pnlSearch, null);
		this.getContentPane().add(TP, null);
		this.getContentPane().add(pnlSearch, null);
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
			mbpscon.Connect();
		}catch(RemoteException re){ System.out.println("Client [frmMBpStock]: Open Error");System.out.println("Error: "+re.getMessage());}

		//DISPLAY DATA RMI
		try
		{
			mbps = mbpscon.moveNext();
			display();
		}catch(RemoteException re){ System.out.println("Client [frmMBpStock]: Show Error");System.out.println("Error: "+re.getMessage());}

		SQL="SELECT * FROM MB_P_Stock ORDER BY SetID;";
		getTableData(SQL);
	}

	/**
	*	Sets Button States
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
		btnRefresh.setEnabled(btnValue);
		btnGo.setEnabled(btnValue);
		btnDT1.setEnabled(!btnValue);
	}

	/**
	*	Sets Fields States
	*
	*/

	public void setFields(boolean txtValue)
	{
		txtName.setEnabled(txtValue);
		txtBrand.setEnabled(txtValue);
		txtModel.setEnabled(txtValue);
		txtSNo.setEnabled(txtValue);
		cboQuality.setEnabled(txtValue);
		cboIS.setEnabled(txtValue);
		txtWar.setEnabled(txtValue);
		txtRemarks.setEnabled(txtValue);

		cboSearch.setEnabled(!txtValue);
		txtSearch.setEnabled(!txtValue);
	}

	/**
	*	Clear Text From Fields
	*
	*/

	public void clearFields()
	{
		txtSID.setText("");
		txtDate.setText("");
		txtName.setText("");
		txtBrand.setText("");
		txtModel.setText("");
		txtSNo.setText("");
		txtWar.setText("");
		txtRemarks.setText("");
	}

	/**
	*	Display Data
	*
	*/

	public void display()
	{
		//clearFields();
		txtSID.setText(mbps.getSetID());
		txtDate.setText(mbps.getDate());
		txtName.setText(mbps.getSetName());
		txtBrand.setText(mbps.getBrand());
		txtModel.setText(mbps.getModel());
		txtSNo.setText(mbps.getSNo());
		cboQuality.setSelectedItem(mbps.getQuality());
		cboIS.setSelectedItem(mbps.getIssued());
		txtWar.setText(mbps.getWarranty());
		//EmpCode(10)
		txtRemarks.setText(mbps.getRemarks());

	}

	/**
	*	Checks the Fields
	*
	*	@return boolean true or false value
	*/

	public boolean checkFields()
	{
		if (txtName.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide a Set Name!","Missing Information",JOptionPane.ERROR_MESSAGE);txtName.requestFocus();return false;}
		if (txtBrand.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Set Brand!","Missing Information",JOptionPane.ERROR_MESSAGE);txtBrand.requestFocus();return false;}
		if (txtModel.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Set Model!","Missing Information",JOptionPane.ERROR_MESSAGE);txtModel.requestFocus();return false;}
		if (txtSNo.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Set Serial No.!","Missing Information",JOptionPane.ERROR_MESSAGE);txtSNo.requestFocus();return false;}
		if (txtWar.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Set Warranty!","Missing Information",JOptionPane.ERROR_MESSAGE);txtWar.requestFocus();return false;}
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
		mbps.setSetID(txtSID.getText());
		mbps.setDate(txtDate.getText());
		mbps.setSetName(txtName.getText());
		mbps.setBrand(txtBrand.getText());
		mbps.setModel(txtModel.getText());
		mbps.setSNo(txtSNo.getText());
		mbps.setQuality(cboQuality.getSelectedItem()+"");
		mbps.setIssued(cboIS.getSelectedItem()+"");
		mbps.setEmpCode(EmpCode);
		mbps.setRemarks(txtRemarks.getText());

		try
		{
			savesucc = mbpscon.insertData(mbps);
			StartWorking("ADDING NEW RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMBpStock]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBpStock]: "+re.getMessage(),
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
		mbps.setSetID(txtSID.getText());
		mbps.setDate(txtDate.getText());
		mbps.setSetName(txtName.getText());
		mbps.setBrand(txtBrand.getText());
		mbps.setModel(txtModel.getText());
		mbps.setSNo(txtSNo.getText());
		mbps.setQuality(cboQuality.getSelectedItem()+"");
		mbps.setIssued(cboIS.getSelectedItem()+"");
		mbps.setEmpCode(EmpCode);
		mbps.setRemarks(txtRemarks.getText());

		try
		{
			updatesucc = mbpscon.updateData(mbps);
			StartWorking("UPDATING RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMBpStock]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmMBpStock]: "+re.getMessage(),
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
		String strQuery = "DELETE FROM MB_P_Stock WHERE SetID='" + txtSID.getText() + "';";

		int yn;
		yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
		JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
			try
			{
				mbpscon.DeleteData(strQuery);
				StartWorking("DELETING RECORD");
				JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
				clearFields();
				getConnected();

			}catch(RemoteException re)
			{
				System.out.println("Client [frmMBpStock]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
				JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBpStock]: "+re.getMessage(),
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
			System.out.println("Client [frmMBpStock]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmMBpStock]: "+re.getMessage(),
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
					txtSID.setText(SelRow[0][0]);txtDate.setText(SelRow[0][1]);txtName.setText(SelRow[0][2]);txtBrand.setText(SelRow[0][3]);txtModel.setText(SelRow[0][4]);txtSNo.setText(SelRow[0][5]);cboQuality.setSelectedItem(SelRow[0][6]);cboIS.setSelectedItem(SelRow[0][7]);txtWar.setText(SelRow[0][8]);txtRemarks.setText(SelRow[0][10]);
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
		int[] sz = new int[11];
		sz[0]=100;sz[1]=60;sz[2]=120;sz[3]=120;sz[4]=100;sz[5]=100;sz[6]=70;
		sz[7]=50;sz[8]=70;sz[9]=50;sz[10]=250;
		for (int j = 0; j < TotalCol; ++j)
		{
			column = Table.getColumnModel().getColumn(j);
			column.setPreferredWidth(sz[j]);
		}
	}

	/**
	*	Searching
	*
	*/

	void btnGo_actionPerformed(ActionEvent e)
	{
		String SQLString=null;
		if (txtSearch.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Search What ?",
			"Information Required...",
			JOptionPane.INFORMATION_MESSAGE, imgExc);
			txtSearch.requestFocus();
		}
		else
		{
			SQLString = "SELECT * FROM MB_P_Stock WHERE " + cboSearch.getSelectedItem().toString() + "='" + txtSearch.getText() + "';";

			try
			{
				if (mbpscon.isFound(SQLString))
				{
					mbps = mbpscon.SearchData(SQLString);
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
			{System.out.println("Client [frmMBpStock]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}
		}
	}

	void btnDT1_actionPerformed(ActionEvent e) {
	frmDate fd = new frmDate("Select Date");
	fd.setSize(new Dimension(212, 163));
	fd.setVisible(true);
	String SDate = fd.createDate();
	txtDate.setText(SDate);
	}

	/**
	*	Adding Combo Items
	*
	*/

	void getComboItems()
	{
		cboSearch.addItem("SetName");
		cboSearch.addItem("Brand");
		cboSearch.addItem("Model");
		cboSearch.addItem("Quality");
		cboSearch.addItem("Warranty");

		cboQuality.addItem("New");
		cboQuality.addItem("Repaired");
		cboQuality.addItem("Bad");

		cboIS.addItem("No");
		cboIS.addItem("Yes");
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