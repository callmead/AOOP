package beximtex;
/**
 * <p>Title: BeximTex, Hardware Stock</p>
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

public class frmStock extends JInternalFrame
{//Class

	JPanel pnlFields = new JPanel();
	TitledBorder titledBorder1;
	TitledBorder titledBorder2;
	JTextField txtDate = new JTextField();
	JLabel lblDate = new JLabel();
	JLabel lblHW = new JLabel();
	JComboBox cboHW = new JComboBox();
	JTextField txtIC = new JTextField();
	JLabel lblIC = new JLabel();
	JTextField txtBrand = new JTextField();
	JLabel lblBrand = new JLabel();
	JLabel lblSN = new JLabel();
	JTextField txtSerial = new JTextField();
	JTextField txtCPT = new JTextField();
	JLabel lblCPT = new JLabel();

	JTextField txtRMB = new JTextField();
	JTextField txtRTYP = new JTextField();
	JLabel lblRTYP = new JLabel();
	JTextField txtCap = new JTextField();
	JLabel lblCap = new JLabel();
	JLabel lblSpeed = new JLabel();
	JTextField txtSpeed = new JTextField();
	JLabel lblQuality = new JLabel();
	JComboBox cboQuality = new JComboBox();
	JTextField txtRemarks = new JTextField();
	JLabel lblRem = new JLabel();
	JPanel pnlButtons = new JPanel();
	TitledBorder titledBorder3;
	TitledBorder titledBorder4;
	JButton btnDelete = new JButton();
	JButton btnClose = new JButton();
	JLabel lblRec = new JLabel();
	JButton btnSave = new JButton();
	JButton btnCancel = new JButton();
	JButton btnEdit = new JButton();
	JButton btnNew = new JButton();
	JToggleButton btnLast = new JToggleButton();
	JToggleButton btnPrevious = new JToggleButton();
	JButton btnRefresh = new JButton();
	JToggleButton btnNext = new JToggleButton();
	JToggleButton btnFirst = new JToggleButton();
	JPanel pnlSearch = new JPanel();
	TitledBorder titledBorder5;
	TitledBorder titledBorder6;
	JButton btnGo = new JButton();
	JLabel lblPicture = new JLabel();
	JComboBox cboSearch = new JComboBox();
	JTextField txtSearch = new JTextField();

	int yn;
	boolean isAdd = false;

	String EmpCode = null;
	String TableName = null;

	String CurrentDate = null;
	String ItemCode = null;
	String temp = null;
	char c;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date d;

	String SQL = null;

	Vector ColHead = new Vector();
	Vector rows = new Vector();

	String SelRow[][];

	int TotalCol = 0;
	int Rows = 0;
	int Columns = 0;

	//**************************************************************
	//RMI Declare Server Object
	HWStockController hwscon;
	HWStock hws = new HWStock();

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
	ImageIcon imgTab = new ImageIcon("./Images/table.gif");
	ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
	ImageIcon imgExc = new ImageIcon("./Images/exc.gif");
	ImageIcon imgQ = new ImageIcon("./Images/question32.png");

	JLabel lblMB = new JLabel();
	JScrollPane sp = new JScrollPane();
	JTable Table = new JTable();
	JLabel lblIS = new JLabel();
	JComboBox cboIS = new JComboBox();
	JTextField txtWar = new JTextField();
	JLabel lblWar = new JLabel();
	JToggleButton btnDT1 = new JToggleButton();

	public frmStock(String ec)
	{//Cons
		EmpCode = ec;
		try{jbInit();}
		catch(Exception e){System.exit(0);}
	}//Cons

	private void jbInit() throws Exception
	{//jbInit

		//**************************************************************
	    //getConnectedion: getConnecteds with Server
		try
		{
			hwscon = (HWStockController)Naming.lookup(new ReadHost().getHost() + "HWStockController");
			ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmHWStock] \n******************************\n");
		//**************************************************************

		titledBorder3 = new TitledBorder("");
		titledBorder4 = new TitledBorder("");
		titledBorder5 = new TitledBorder("");
		titledBorder6 = new TitledBorder("");
		pnlButtons.setBackground(Color.white);
		pnlButtons.setBorder(titledBorder4);
		pnlButtons.setBounds(new Rectangle(7, 138, 648, 69));
		pnlButtons.setLayout(null);
		btnDelete.setBorder(BorderFactory.createRaisedBevelBorder());
		btnDelete.setMnemonic('D');
		btnDelete.setText("DELETE");
		btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnDelete.setIcon(new ImageIcon("images/Delete16.gif"));
		btnDelete.setBounds(new Rectangle(391, 34, 91, 28));
		btnDelete.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(txtIC.getText().equals(""))
				{ return; }
				DeleteData();
			}
		});
		btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
		btnClose.setMnemonic('L');
		btnClose.setText("CLOSE");
		btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnClose.setIcon(new ImageIcon("images/close.gif"));
		btnClose.setBounds(new Rectangle(485, 34, 91, 28));
		btnClose.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ dispose(); }
		});
		lblRec.setBackground(Color.white);
		lblRec.setBounds(new Rectangle(238, 8, 150, 21));
		lblRec.setOpaque(true);
		lblRec.setText("");
		lblRec.setFont(new Font("Tahoma", 1, 12));

		btnSave.setBorder(BorderFactory.createRaisedBevelBorder());
		btnSave.setMnemonic('S');
		btnSave.setText("SAVE");
		btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnSave.setIcon(new ImageIcon("images/Save16.gif"));
		btnSave.setBounds(new Rectangle(48, 34, 91, 28));
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
		btnCancel.setBounds(new Rectangle(143, 34, 91, 28));
		btnCancel.setText("CANCEL");
		btnCancel.setIcon(new ImageIcon("images/Cancel.gif"));
		btnCancel.setMnemonic('C');
		btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnEdit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setButton(false);
				setFields(true);
				btnDT1.setEnabled(false);
				cboHW.requestFocus();
				lblRec.setText(" Edit Record... ");
			}
		});
		btnEdit.setBorder(BorderFactory.createRaisedBevelBorder());
		btnEdit.setBounds(new Rectangle(143, 34, 91, 28));
		btnEdit.setText("EDIT");
		btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnEdit.setIcon(new ImageIcon("images/EditMnu.gif"));
		btnEdit.setMnemonic('E');
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
				showFields();
				cboIS.setSelectedItem("No");
				cboHW.requestFocus();
				cboIS.setEnabled(false);
				txtIC.setText(ItemCode);
				lblRec.setText(" Add New Record... ");
			}
		});
		btnNew.setBorder(BorderFactory.createRaisedBevelBorder());
		btnNew.setBounds(new Rectangle(48, 34, 91, 28));
		btnNew.setText("NEW");
		btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnNew.setIcon(new ImageIcon("images/FileMnu.gif"));
		btnNew.setMnemonic('A');
		btnLast.setToolTipText("Last");
		btnLast.setText("");
		btnLast.setIcon(imgLast);
		btnLast.setBounds(new Rectangle(415, 7, 22, 23));
		btnLast.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					hws=hwscon.moveLast();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmHWStock]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnLast.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnLast.setIcon(imgLO); }
			public void mouseExited(MouseEvent f)
			{ btnLast.setIcon(imgLast); }
		});

		btnPrevious.setToolTipText("Previous");
		btnPrevious.setText("");
		btnPrevious.setIcon(imgPrev);
		btnPrevious.setBounds(new Rectangle(213, 7, 22, 23));
		btnPrevious.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					hws=hwscon.movePrevious();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmHWStock]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnPrevious.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnPrevious.setIcon(imgPO); }
			public void mouseExited(MouseEvent f)
			{ btnPrevious.setIcon(imgPrev); }
		});

		btnRefresh.setToolTipText("Refresh Database");
		btnRefresh.setBorder(BorderFactory.createRaisedBevelBorder());
		btnRefresh.setMnemonic('B');
		btnRefresh.setText("REFRESH DB");
		btnRefresh.setIcon(imgRef);
		btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnRefresh.setBounds(new Rectangle(238, 34, 149, 28));
		btnRefresh.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ getConnected();}
		});
		btnNext.setToolTipText("Next");
		btnNext.setText("");
		btnNext.setIcon(imgNext);
		btnNext.setBounds(new Rectangle(392, 7, 22, 23));
		btnNext.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					hws=hwscon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmHWStock]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
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
		btnFirst.setBounds(new Rectangle(189, 7, 22, 23));
		btnFirst.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					hws=hwscon.moveFirst();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmHWStock]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnFirst.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnFirst.setIcon(imgFO); }
			public void mouseExited(MouseEvent f)
			{ btnFirst.setIcon(imgFirst); }
		});

		pnlSearch.setBackground(Color.white);
		pnlSearch.setBorder(titledBorder6);
		pnlSearch.setBounds(new Rectangle(7, 212, 648, 229));
		pnlSearch.setLayout(null);
		btnGo.setBounds(new Rectangle(494, 193, 91, 28));
		btnGo.setText("  FIND     ");
		btnGo.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnGo_actionPerformed(e); }
		});
		btnGo.setIcon(imgSrc);
		btnGo.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnGo.setBorder(BorderFactory.createRaisedBevelBorder());
		lblPicture.setText("");
		lblPicture.setIcon(imgSearch);
		lblPicture.setBounds(new Rectangle(52, 151, 273, 42));

		txtSearch.setFont(new Font("Tahoma", 1, 12));
		txtSearch.setCaretColor(Color.blue);
		txtSearch.setText("");
		txtSearch.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtSearch.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});
		txtSearch.setBounds(new Rectangle(54, 196, 330, 24));

		lblMB.setText("MB");
		lblMB.setBounds(new Rectangle(239, 36, 54, 24));
		lblMB.setFont(new java.awt.Font("Tahoma", 1, 11));

		sp.getViewport().setBackground(Color.white);
		sp.setToolTipText("Current Stock");
		sp.setBounds(new Rectangle(5, 5, 637, 140));

		lblIS.setHorizontalAlignment(SwingConstants.LEFT);
		lblIS.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblIS.setText("ISSUED");
		lblIS.setBounds(new Rectangle(239, 65, 65, 24));

		cboIS.setBackground(Color.white);
		cboIS.setMaximumRowCount(3);
		cboIS.setToolTipText("Hardware Issue Status");
		cboIS.setBounds(new Rectangle(298, 65, 101, 23));
		cboIS.addItem("No");
		cboIS.addItem("Yes");

		txtWar.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtWar.setText("");
		txtWar.setBounds(new Rectangle(497, 66, 140, 23));
		txtWar.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtWar.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		lblWar.setHorizontalAlignment(SwingConstants.LEFT);
		lblWar.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblWar.setText("WARRANTY");
		lblWar.setBounds(new Rectangle(413, 65, 75, 24));

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
		btnDT1.setBounds(new Rectangle(517, 38, 22, 23));
		btnDT1.setBounds(new Rectangle(378, 8, 22, 23));
		pnlFields.add(lblHW, null);
		pnlFields.add(cboHW, null);
		pnlFields.add(txtIC, null);
		pnlFields.add(lblBrand, null);
		pnlFields.add(txtBrand, null);
		pnlFields.add(lblSN, null);
		pnlFields.add(txtSerial, null);
		pnlFields.add(lblCPT, null);
		pnlFields.add(txtCPT, null);
		pnlFields.add(txtRMB, null);
		pnlFields.add(lblRTYP, null);
		pnlFields.add(txtRTYP, null);
		pnlFields.add(txtCap, null);
		pnlFields.add(lblCap, null);
		pnlFields.add(lblSpeed, null);
		pnlFields.add(txtSpeed, null);
		pnlFields.add(lblMB, null);
		pnlFields.add(lblQuality, null);
		pnlFields.add(cboQuality, null);
		pnlFields.add(txtRemarks, null);
		pnlFields.add(lblRem, null);
		this.getContentPane().add(pnlSearch, null);

		cboHW.setMaximumRowCount(5);
		cboHW.setBounds(new Rectangle(90, 9, 133, 23));
		cboHW.setBackground(Color.white);

		cboHW.addItem("AGP");
		cboHW.addItem("CD ROM");
		cboHW.addItem("CDRW");
		cboHW.addItem("CPU");
		cboHW.addItem("DVD ROM");
		cboHW.addItem("FDD");
		cboHW.addItem("HDD");
		cboHW.addItem("KEYBOARD");
		cboHW.addItem("MONITOR");
		cboHW.addItem("MOTHERBOARD");
		cboHW.addItem("MOUSE");
		cboHW.addItem("NIC CARD");
		cboHW.addItem("PRINTER");
		cboHW.addItem("PROCESSOR");
		cboHW.addItem("RAM");
		cboHW.addItem("SCANNER");
		cboHW.addItem("SPECIAL CARD");
		cboHW.addItem("SOUND CARD");
		cboHW.addItem("UPS");
		cboHW.addItem("OTHER");

		cboHW.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1)
			{
				if (ke1.getKeyCode() == KeyEvent.VK_ENTER)
				{
					ke1.setKeyCode(KeyEvent.VK_TAB);
					showFields();
					txtIC.setText(ItemCode);
				}
			}
			public void KeyReleased(KeyEvent ke1) {}

			public void KeyTyped(KeyEvent ke1) {}
		});
		cboHW.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{showFields();}
		});

		cboSearch.setBounds(new Rectangle(389, 196, 101, 24));
		cboSearch.setMaximumRowCount(4);
		cboSearch.setBackground(Color.white);
		cboSearch.addItem("Date");
		cboSearch.addItem("Item");
		cboSearch.addItem("ItemCode");
		cboSearch.addItem("IssuedTo");
		cboSearch.addItem("Brand");
		cboSearch.addItem("Serial");
		cboSearch.addItem("Capacity");
		cboSearch.addItem("MB");
		cboSearch.addItem("Speed");
		cboSearch.addItem("CPUType");
		cboSearch.addItem("Quality");
		cboSearch.addItem("Warranty");

		cboQuality.setBounds(new Rectangle(90, 65, 133, 23));
		cboQuality.setToolTipText("Quality of the Hardware");
		cboQuality.setMaximumRowCount(4);
		cboQuality.setBackground(Color.white);

		cboQuality.addItem("New");
		cboQuality.addItem("Repaired");
		cboQuality.addItem("Bad");

		txtIC.setText("");
		txtIC.setBounds(new Rectangle(497, 8, 140, 23));
		txtIC.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtIC.setEnabled(false);

		lblIC.setText("ITEM CODE");
		lblIC.setBounds(new Rectangle(413, 7, 75, 24));
		lblIC.setFont(new java.awt.Font("Tahoma", 1, 11));

		txtDate.setEnabled(false);

		txtBrand.setText("");
		txtBrand.setBounds(new Rectangle(90, 37, 132, 23));
		txtBrand.setEnabled(true);
		txtBrand.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtBrand.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtBrand.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		lblBrand.setText("BRAND");
		lblBrand.setBounds(new Rectangle(13, 36, 67, 24));
		lblBrand.setFont(new java.awt.Font("Tahoma", 1, 11));

		lblSN.setText("SERIAL #");
		lblSN.setBounds(new Rectangle(239, 36, 54, 24));
		lblSN.setFont(new java.awt.Font("Tahoma", 1, 11));

		txtSerial.setText("");
		txtSerial.setEnabled(true);
		txtSerial.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtSerial.setBounds(new Rectangle(298, 37, 101, 23));
		txtSerial.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtSerial.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		txtCPT.setEnabled(true);
		txtCPT.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtCPT.setBounds(new Rectangle(90, 37, 132, 23));
		txtCPT.setText("");
		txtCPT.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtCPT.selectAll(); }
		public void focusLost(FocusEvent f) {}
		});

		lblCPT.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblCPT.setBounds(new Rectangle(13, 36, 67, 24));
		lblCPT.setText("CPU TYPE");
		lblCap.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblCap.setToolTipText("");
		lblCap.setBounds(new Rectangle(231, 92, 54, 24));
		lblCap.setText("MB");
		txtRMB.setBounds(new Rectangle(298, 37, 101, 23));
		txtRMB.setEnabled(true);
		txtRMB.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtRMB.setToolTipText("RAM MB");
		txtRMB.setText("");
		txtRMB.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtRMB.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		txtRTYP.setText("");
		txtRTYP.setBounds(new Rectangle(90, 37, 132, 23));
		txtRTYP.setEnabled(true);
		txtRTYP.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtRTYP.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtRTYP.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		lblRTYP.setText("RAM TYPE");
		lblRTYP.setBounds(new Rectangle(13, 36, 67, 24));
		lblRTYP.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtCap.setEnabled(true);
		txtCap.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtCap.setToolTipText("HARDDISK CAPACITY");
		txtCap.setBounds(new Rectangle(497, 37, 140, 23));
		txtCap.setText("");
		txtCap.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtCap.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		lblCap.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblCap.setBounds(new Rectangle(413, 36, 75, 24));
		lblCap.setText("CAPACITY");
		lblSpeed.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblSpeed.setBounds(new Rectangle(239, 36, 54, 24));
		lblSpeed.setText("SPEED");
		txtSpeed.setBounds(new Rectangle(298, 37, 101, 23));
		txtSpeed.setEnabled(true);
		txtSpeed.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtSpeed.setToolTipText("Processor Speed");
		txtSpeed.setText("");
		txtSpeed.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtSpeed.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		lblQuality.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQuality.setBounds(new Rectangle(13, 65, 75, 24));
		lblQuality.setText("QUALITY");

		txtRemarks.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtRemarks.setEnabled(true);
		txtRemarks.setBounds(new Rectangle(90, 93, 547, 23));
		txtRemarks.setText("");
		txtRemarks.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtRemarks.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		lblRem.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblRem.setBounds(new Rectangle(13, 92, 67, 24));
		lblRem.setText("REMARKS");
		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");

		pnlFields.setBackground(Color.white);
		pnlFields.setBorder(titledBorder2);
		pnlFields.setBounds(new Rectangle(7, 8, 648, 125));
		pnlFields.setLayout(null);

		txtDate.setBounds(new Rectangle(298, 8, 79, 23));
		txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));

		lblDate.setBounds(new Rectangle(239, 7, 42, 24));
		lblDate.setText("DATE");
		lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);

		lblHW.setText("ITEM");
		lblHW.setBounds(new Rectangle(13, 7, 75, 24));
		lblHW.setFont(new java.awt.Font("Tahoma", 1, 11));

		pnlButtons.add(btnCancel, null);
		pnlButtons.add(btnSave, null);
		pnlButtons.add(btnNext, null);
		pnlButtons.add(btnLast, null);
		pnlButtons.add(btnClose, null);
		pnlButtons.add(btnDelete, null);
		pnlButtons.add(btnRefresh, null);
		pnlButtons.add(btnEdit, null);
		pnlButtons.add(btnNew, null);
		pnlButtons.add(btnFirst, null);
		pnlButtons.add(btnPrevious, null);
		pnlButtons.add(lblRec, null);
		pnlSearch.add(sp, null);
		pnlSearch.add(txtSearch, null);
		pnlSearch.add(cboSearch, null);
		pnlSearch.add(btnGo, null);
		pnlSearch.add(lblPicture, null);
		sp.add(Table, null);
		this.getContentPane().add(pnlButtons, null);
		this.getContentPane().add(pnlFields, null);
		pnlFields.add(cboIS, null);
		pnlFields.add(txtDate, null);
		pnlFields.add(lblDate, null);
		pnlFields.add(lblIS, null);
		pnlFields.add(lblIC, null);
		pnlFields.add(lblWar, null);
		pnlFields.add(txtWar, null);
		pnlFields.add(btnDT1, null);

		this.setClosable(true);
		this.setIconifiable(true);
		this.setTitle("STOCK MANAGEMENT");
		this.setFrameIcon(imgIco);
		this.getContentPane().setBackground(Color.white);
		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(675, 480));
		this.getContentPane().add(pnlSearch, null);

		hideFields();
		showFields();
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
			hwscon.Connect();
		}catch(RemoteException re){ System.out.println("Client [frmHWStock]: Open Error");System.out.println("Error: "+re.getMessage());}

		//DISPLAY DATA RMI
		try
		{
			hws = hwscon.moveNext();
			display();
		}catch(RemoteException re){ System.out.println("Client [frmHWStock]: Show Error");System.out.println("Error: "+re.getMessage());}

		SQL="SELECT * FROM HW_Stock ORDER BY ItemCode;";
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
		btnRefresh.setEnabled(btnValue);
		btnGo.setEnabled(btnValue);
		btnDT1.setEnabled(!btnValue);
	}

	/**
	*	Sets Fields States
	*	@param boolean true or false
	*
	*/

	public void setFields(boolean txtValue)
	{
		cboHW.setEnabled(txtValue);
		txtBrand.setEnabled(txtValue);
		txtSerial.setEnabled(txtValue);
		txtCPT.setEnabled(txtValue);
		txtRMB.setEnabled(txtValue);
		txtRTYP.setEnabled(txtValue);
		txtCap.setEnabled(txtValue);
		txtSpeed.setEnabled(txtValue);
		cboQuality.setEnabled(txtValue);
		cboIS.setEnabled(txtValue);
		txtWar.setEnabled(txtValue);
		txtRemarks.setEnabled(txtValue);
	}

	/**
	*	Clear Text From Fields
	*
	*/

	public void clearFields()
	{
		txtDate.setText("");
		txtIC.setText("");
		txtBrand.setText("");
		txtSerial.setText("");
		txtCPT.setText("");
		txtRMB.setText("");
		txtRTYP.setText("");
		txtCap.setText("");
		txtSpeed.setText("");
		txtWar.setText("");
		txtRemarks.setText("");
	}

	/**
	*	Display Data
	*
	*/

	public void display()
	{
		txtIC.setText(hws.getItemCode());
		txtDate.setText(hws.getDate());
		cboHW.setSelectedItem(hws.getItem());
		txtBrand.setText(hws.getBrand());
		txtSerial.setText(hws.getSerial());
		txtCap.setText(hws.getCapacity());
		txtRMB.setText(hws.getMB());
		txtSpeed.setText(hws.getSpeed());
		txtCPT.setText(hws.getCPUType());
		cboQuality.setSelectedItem(hws.getQuality());
		cboIS.setSelectedItem(hws.getIssued());
		//txtEmpCode.setText(hws.getEmpCode());
		txtWar.setText(hws.getWarranty());
		txtRemarks.setText(hws.getRemarks());
	}

	/**
	*	Checks the Fields
	*
	*	@return boolean true or false value
	*/

	public boolean checkFields()
	{
		if(txtIC.getText().equals("")){txtIC.setText(ItemCode);}
		if(txtWar.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide warranty period!","Missing Information",JOptionPane.ERROR_MESSAGE);txtWar.requestFocus();return false;}
		if (txtBrand.getText().equals("")){txtBrand.setText("-");}
		if (txtSerial.getText().equals("")){txtSerial.setText("-");}
		if (txtCPT.getText().equals("")){txtCPT.setText("-");}
		if (txtRMB.getText().equals("")){txtRMB.setText("-");}
		if (txtRTYP.getText().equals("")){txtRTYP.setText("-");}
		if (txtCap.getText().equals("")){txtCap.setText("-");}
		if (txtSpeed.getText().equals("")){txtSpeed.setText("-");}
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
		hws.setItemCode(txtIC.getText());
		hws.setDate(txtDate.getText());
		hws.setItem(cboHW.getSelectedItem()+"");
		hws.setBrand(txtBrand.getText());
		hws.setSerial(txtSerial.getText());
		hws.setCapacity(txtCap.getText());
		hws.setMB(txtRMB.getText());
		hws.setSpeed(txtSpeed.getText());
		hws.setCPUType(txtCPT.getText());
		hws.setQuality(cboQuality.getSelectedItem()+"");
		hws.setIssued(cboIS.getSelectedItem()+"");
		hws.setEmpCode(EmpCode);
		hws.setWarranty(txtWar.getText());
		hws.setRemarks(txtRemarks.getText());

		try
		{
			savesucc = hwscon.insertData(hws);
			StartWorking("ADDING NEW RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmHWStock]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmHWStock]: "+re.getMessage(),
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
		hws.setItemCode(txtIC.getText());
		hws.setDate(txtDate.getText());
		hws.setItem(cboHW.getSelectedItem()+"");
		hws.setBrand(txtBrand.getText());
		hws.setSerial(txtSerial.getText());
		hws.setCapacity(txtCap.getText());
		hws.setMB(txtRMB.getText());
		hws.setSpeed(txtSpeed.getText());
		hws.setCPUType(txtCPT.getText());
		hws.setQuality(cboQuality.getSelectedItem()+"");
		hws.setIssued(cboIS.getSelectedItem()+"");
		hws.setEmpCode(EmpCode);
		hws.setWarranty(txtWar.getText());
		hws.setRemarks(txtRemarks.getText());

		try
		{
			updatesucc = hwscon.updateData(hws);
			StartWorking("UPDATING RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmHWStock]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmHWStock]: "+re.getMessage(),
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
		String strQuery = "DELETE FROM HW_Stock WHERE ItemCode='" + txtIC.getText() +"';";

		int yn;
		yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
		JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
			try
			{
				hwscon.DeleteData(strQuery);
				StartWorking("DELETING RECORD");
				JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
				clearFields();
				getConnected();

			}catch(RemoteException re)
			{
				System.out.println("Client [frmHWStock]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
				JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmHWStock]: "+re.getMessage(),
													"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {}
	}//Delete Data

	/**
	*	Enables The Fields according to the Hardware selected AND Generates Item Code
	*
	*/

	public void showFields()
	{
		if(cboHW.getSelectedItem().equals("CPU")){hideFields();lblCPT.setVisible(true);txtCPT.setVisible(true);}
		if(cboHW.getSelectedItem().equals("PROCESSOR")){hideFields();lblSpeed.setVisible(true);txtSpeed.setVisible(true);lblBrand.setVisible(true);txtBrand.setVisible(true);}
		if(cboHW.getSelectedItem().equals("HDD")){hideFields();lblCap.setVisible(true);txtCap.setVisible(true);lblBrand.setVisible(true);txtBrand.setVisible(true);lblSN.setVisible(true);txtSerial.setVisible(true);}
		if(cboHW.getSelectedItem().equals("RAM")){hideFields();lblRTYP.setVisible(true);txtRTYP.setVisible(true);lblMB.setVisible(true);txtRMB.setVisible(true);}

		if(cboHW.getSelectedItem().equals("AGP") || cboHW.getSelectedItem().equals("MOTHERBOARD") || cboHW.getSelectedItem().equals("SOUND CARD") || cboHW.getSelectedItem().equals("FDD") || cboHW.getSelectedItem().equals("CD ROM") || cboHW.getSelectedItem().equals("DVD ROM") || cboHW.getSelectedItem().equals("CDRW") || cboHW.getSelectedItem().equals("MONITOR") || cboHW.getSelectedItem().equals("KEYBOARD") || cboHW.getSelectedItem().equals("MOUSE") || cboHW.getSelectedItem().equals("NIC CARD") || cboHW.getSelectedItem().equals("SPECIAL CARD") || cboHW.getSelectedItem().equals("RINTER") || cboHW.getSelectedItem().equals("SCANNER") || cboHW.getSelectedItem().equals("UPS") || cboHW.getSelectedItem().equals("OTHER")){hideFields();lblBrand.setVisible(true);txtBrand.setVisible(true);lblSN.setVisible(true);txtSerial.setVisible(true);}
		d = new Date();
		CurrentDate = null;
		ItemCode = new String("I");
		temp=cboHW.getSelectedItem().toString();
		c = temp.charAt(0);
		ItemCode = ItemCode+c;
		c = temp.charAt(1);
		ItemCode = ItemCode+c;
		c = temp.charAt(2);
		ItemCode = ItemCode+c;
		sdf = new SimpleDateFormat("y");
		ItemCode = ItemCode + sdf.format(d);
		sdf = new SimpleDateFormat("M");
		ItemCode = ItemCode + sdf.format(d);
		sdf = new SimpleDateFormat("d");
		ItemCode = ItemCode + sdf.format(d);
		sdf = new SimpleDateFormat("Hms");
		ItemCode = ItemCode + sdf.format(d);
		System.out.println("Item Code: " + ItemCode);
	}

	/**
	*	Hides Fields
	*
	*/

	public void hideFields()
	{
		lblBrand.setVisible(false);
		txtBrand.setVisible(false);
		lblSN.setVisible(false);
		txtSerial.setVisible(false);
		lblCap.setVisible(false);
		txtCap.setVisible(false);
		lblCPT.setVisible(false);
		txtCPT.setVisible(false);
		lblSpeed.setVisible(false);
		txtSpeed.setVisible(false);
		lblRTYP.setVisible(false);
		txtRTYP.setVisible(false);
		lblMB.setVisible(false);
		txtRMB.setVisible(false);
	}

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
			System.out.println("Client [frmHWStock]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmHWStock]: "+re.getMessage(),
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
					txtIC.setText(SelRow[0][0]);txtDate.setText(SelRow[0][1]);cboHW.setSelectedItem(SelRow[0][2]);txtBrand.setText(SelRow[0][3]);txtSerial.setText(SelRow[0][4]);txtCap.setText(SelRow[0][5]);txtRMB.setText(SelRow[0][6]);txtSpeed.setText(SelRow[0][7]);txtCPT.setText(SelRow[0][8]);cboQuality.setSelectedItem(SelRow[0][9]);cboIS.setSelectedItem(SelRow[0][10]);txtWar.setText(SelRow[0][12]);txtRemarks.setText(SelRow[0][13]);
				}
				else if (x.length < 1)
				{
					JOptionPane.showMessageDialog(null, "Please Select One Item!", "Information Required...", JOptionPane.ERROR_MESSAGE);
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
		int[] sz = new int[14];
		sz[0]=100;sz[1]=60;sz[2]=120;sz[3]=100;sz[4]=100;sz[5]=70;sz[6]=70;sz[7]=70;
		sz[8]=120;sz[9]=70;sz[10]=50;sz[11]=50;sz[12]=70;sz[13]=200;
		for (int j = 0; j < TotalCol; ++j)
		{
			column = Table.getColumnModel().getColumn(j);
			column.setPreferredWidth(sz[j]);
		}
	}

	void btnGo_actionPerformed(ActionEvent e)
	{
		String SQLString=null;
		if (txtSearch.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Search What ?", "Information Required...", JOptionPane.INFORMATION_MESSAGE, imgExc);
			txtSearch.requestFocus();
		}
		else
		{
			if(cboSearch.getSelectedItem().equals("IssuedTo")){SQLString="SELECT HW_Stock.*, HW_Issue.IssuedTo FROM HW_Stock, HW_Issue WHERE HW_Issue.ItemCode=HW_Stock.ItemCode AND HW_Issue.IssuedTo='"+txtSearch.getText()+"';";}
			else{SQLString = "SELECT * FROM HW_Stock WHERE " + cboSearch.getSelectedItem().toString() +             "='" + txtSearch.getText() + "';";}

			try
			{
				if (hwscon.isFound(SQLString))
				{
					hws = hwscon.SearchData(SQLString);
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
			{System.out.println("Client [frmHWStock]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}

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