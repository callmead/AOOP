package beximtex;
/**
 * <p>Title: BeximTex, Mobile Request</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.text.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.rmi.*;

public class frmMobile extends JInternalFrame
{
	JPanel pnlTop = new JPanel();
	JPanel pnlMid = new JPanel();
	JPanel pnlButtons = new JPanel();

	TitledBorder titledBorder1;
	TitledBorder titledBorder2;
	TitledBorder titledBorder3;

	JLabel lblEmpCode = new JLabel();
	JLabel lblEID = new JLabel();
	JLabel lblName = new JLabel();
	JLabel lblDate = new JLabel();
	JLabel lblQ1 = new JLabel();
	JLabel lblQ2 = new JLabel();
	JLabel lblQ2a = new JLabel();
	JLabel lblQ3 = new JLabel();
	JLabel lblQ4 = new JLabel();
	JLabel lblQ5 = new JLabel();
	JLabel lblQ6 = new JLabel();
	JLabel lblQ7 = new JLabel();
	JLabel lblQ8 = new JLabel();
	JLabel lblQ9 = new JLabel();
	JLabel lblQ10 = new JLabel();
	JLabel lblQ11 = new JLabel();
	JLabel lblQ12 = new JLabel();
	JLabel lblQ13 = new JLabel();
	JLabel lblQ13a = new JLabel();
	JLabel lblQ14 = new JLabel();

	JLabel lblRec = new JLabel();

	JTextField txtEmpCode = new JTextField();
	JTextField txtMID = new JTextField();
	JTextField txtName = new JTextField();
	JTextField txtDate = new JTextField();

	JToggleButton btnDelete = new JToggleButton();
	JToggleButton btnClose = new JToggleButton();
	JToggleButton btnSave = new JToggleButton();
	JToggleButton btnCancel = new JToggleButton();
	JToggleButton btnEdit = new JToggleButton();
	JToggleButton btnPrev = new JToggleButton();
	JToggleButton btnNext = new JToggleButton();
	JToggleButton btnNew = new JToggleButton();

	JRadioButton rdoQ1Yes = new JRadioButton();
	JRadioButton rdoQ1NO = new JRadioButton();
	ButtonGroup bgQ1 = new ButtonGroup();

	JRadioButton rdoQ2Yes = new JRadioButton();
	JRadioButton rdoQ2NO = new JRadioButton();
	ButtonGroup bgQ2 = new ButtonGroup();

	JRadioButton rdoQ2CC = new JRadioButton();
	JRadioButton rdoQ2GP = new JRadioButton();
	JRadioButton rdoQ2Ak = new JRadioButton();
	JRadioButton rdoQ2Other = new JRadioButton();
	ButtonGroup bgQ2a = new ButtonGroup();

	JRadioButton rdoQ4Yes = new JRadioButton();
	JRadioButton rdoQ4NO = new JRadioButton();
	ButtonGroup bgQ4 = new ButtonGroup();

	JRadioButton rdoQ5VO = new JRadioButton();
	JRadioButton rdoQ5O = new JRadioButton();
	JRadioButton rdoQ5H = new JRadioButton();
	ButtonGroup bgQ5 = new ButtonGroup();

	JRadioButton rdoQ7Yes = new JRadioButton();
	JRadioButton rdoQ7NO = new JRadioButton();
	ButtonGroup bgQ7 = new ButtonGroup();

	JRadioButton rdoQ8VO = new JRadioButton();
	JRadioButton rdoQ8O = new JRadioButton();
	JRadioButton rdoQ8H = new JRadioButton();
	ButtonGroup bgQ8 = new ButtonGroup();

	JRadioButton rdoQ9Yes = new JRadioButton();
	JRadioButton rdoQ9NO = new JRadioButton();
	ButtonGroup bgQ9 = new ButtonGroup();

	JRadioButton rdoQ10Yes = new JRadioButton();
	JRadioButton rdoQ10NO = new JRadioButton();
	ButtonGroup bgQ10 = new ButtonGroup();

	JRadioButton rdoQ11Yes = new JRadioButton();
	JRadioButton rdoQ11NO = new JRadioButton();
	ButtonGroup bgQ11 = new ButtonGroup();

	JRadioButton rdoQ13Yes = new JRadioButton();
	JRadioButton rdoQ13NO = new JRadioButton();
	ButtonGroup bgQ13 = new ButtonGroup();

	JRadioButton rdoQ14VO = new JRadioButton();
	JRadioButton rdoQ14O = new JRadioButton();
	JRadioButton rdoQ14H = new JRadioButton();
	ButtonGroup bgQ14 = new ButtonGroup();

	JTextField txtQ3 = new JTextField();
	JTextField txtQ6 = new JTextField();
	JTextField txtQ12 = new JTextField();

	//**************************************************************
	//RMI Declare Server Object
	MobileController mobcon;
	Mobile mob = new Mobile();
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
	ImageIcon imgQ = new ImageIcon("./Images/question32.png");

	String stQ1 = new String("1. At the time of appointment was there any commitment / condition for providing Mobile Telephone? ");
	String stQ2 = new String("2. Is the employee currently using a mobile phone? ");
	String stQ2a = new String("If YES, then which one is being used? ");
	String stQ4 = new String("4. Need for after office-hour communication ");
	String stQ5 = new String("5. Frequency of after office-hour communication ");
	String stQ7 = new String("7. Need for staying longer in the office ");
	String stQ8 = new String("8. Frequency of staying longer in the office ");
	String stQ9 = new String("9. Does the employee has residence telephone? ");
	String stQ10 = new String("10. Does the employee interact with suppliers/customers? ");
	String stQ11 = new String("11. Does the employee's duties keep him out of office? ");
	String stQ13 = new String("13. Does the employee require ISD facilities? ");
	String stQ14 = new String("14. How Frequently will the ISD facilities be used by the employee? ");

	String rdoQ1Val = null;
	String rdoQ2Val = null;
	String rdoQ2aVal = null;
	String rdoQ4Val = null;
	String rdoQ5Val = null;
	String rdoQ7Val = null;
	String rdoQ8Val = null;
	String rdoQ9Val = null;
	String rdoQ10Val = null;
	String rdoQ11Val = null;
	String rdoQ13Val = null;
	String rdoQ14Val = null;

	String EmpCode = null;
	String userName = null;
	int yn;

	String CurrentDate = null;
	String TranID = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date d;

	boolean isAdd = false;
	boolean fieldsOK = false;
	JTextField txtQ13a = new JTextField();

	public frmMobile(String ec, String un)
	{
		EmpCode = ec;
		userName = un;

		try {jbInit();}
		catch (Exception e) {System.exit(0);}
	}

	private void jbInit() throws Exception
	{//Cons

		//**************************************************************
		//Connection: Connects with Server
		try
		{
			mobcon = (MobileController)Naming.lookup(new ReadHost().getHost() + "MobileController");
		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmMobile] \n******************************\n");
		//**************************************************************

		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");
		titledBorder3 = new TitledBorder("");

		pnlTop.setBackground(Color.white);
		pnlTop.setForeground(Color.white);
		pnlTop.setBorder(titledBorder1);
		pnlTop.setBounds(new Rectangle(3, 433, 759, 37));
		pnlTop.setLayout(null);

		pnlMid.setBackground(Color.white);
		pnlMid.setForeground(Color.white);
		pnlMid.setBorder(titledBorder2);
		pnlMid.setBounds(new Rectangle(3, 4, 759, 385));
		pnlMid.setLayout(null);

		pnlButtons.setBackground(Color.white);
		pnlButtons.setForeground(Color.white);
		pnlButtons.setBorder(titledBorder3);
		pnlButtons.setBounds(new Rectangle(3, 392, 759, 38));
		pnlButtons.setLayout(null);

		lblQ1.setBounds(new Rectangle(9, 4, 635, 24));
		lblQ1.setText("1. At the time of appointment was there any commitment / condition for providing Mobile Telephone?");
		lblQ1.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ2a.setBounds(new Rectangle(87, 51, 324, 24));
		lblQ2a.setText("If YES, then which one is being used?");
		lblQ2a.setFont(new java.awt.Font("Tahoma", 1, 11));

		lblQ2.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ2.setText("2. Is the employee currently using a mobile phone?");
		lblQ2.setBounds(new Rectangle(9, 27, 579, 24));

		lblQ3.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ3.setText("3. What is the purpose of using mobile at present");
		lblQ3.setBounds(new Rectangle(9, 74, 388, 24));
		lblQ4.setBounds(new Rectangle(9, 98, 378, 24));
		lblQ4.setText("4. Need for after office-hour communication");
		lblQ4.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ5.setBounds(new Rectangle(9, 121, 372, 24));
		lblQ5.setText("5. Frequency of after office-hour communication");
		lblQ5.setBackground(Color.white);
		lblQ5.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ6.setBounds(new Rectangle(9, 145, 380, 24));
		lblQ6.setText("6. Purpose of after office-hour communication ");
		lblQ6.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ7.setBounds(new Rectangle(9, 168, 365, 24));
		lblQ7.setText("7. Need for staying longer in the office");
		lblQ7.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ8.setBounds(new Rectangle(9, 192, 349, 24));
		lblQ8.setText("8. Frequency of staying longer in the office");
		lblQ8.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ9.setBounds(new Rectangle(9, 215, 364, 24));
		lblQ9.setText("9. Does the employee has residence telephone?");
		lblQ9.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ10.setBounds(new Rectangle(9, 239, 420, 24));
		lblQ10.setText("10. Does the employee interact with suppliers/customers?");
		lblQ10.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ11.setBounds(new Rectangle(9, 262, 403, 24));
		lblQ11.setText("11. Does the employee\'s duties keep him out of office?");
		lblQ11.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ12.setBounds(new Rectangle(9, 286, 289, 24));
		lblQ12.setText("12. Additional Remarks");
		lblQ12.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ13.setBounds(new Rectangle(9, 309, 325, 24));
		lblQ13.setText("13. Does the employee require ISD facilities?");
		lblQ13.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ13a.setBounds(new Rectangle(121, 333, 229, 24));
		lblQ13a.setText("If YES, for what purpose?");
		lblQ13a.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblQ14.setBounds(new Rectangle(9, 356, 491, 24));
		lblQ14.setText("14. How Frequently will the ISD facilities be used by the employee?");
		lblQ14.setFont(new java.awt.Font("Tahoma", 1, 11));

		lblEmpCode.setBounds(new Rectangle(384, 7, 98, 24));
		lblEmpCode.setText("EMPLOYEE CODE");
		lblEmpCode.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblEmpCode.setHorizontalAlignment(SwingConstants.RIGHT);

		lblEID.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblEID.setBounds(new Rectangle(11, 7, 100, 24));
		lblEID.setText("TRANSACTION #");

		lblName.setText("NAME");
		lblName.setBounds(new Rectangle(567, 7, 39, 24));
		lblName.setFont(new java.awt.Font("Tahoma", 1, 11));

		lblDate.setBounds(new Rectangle(236, 7, 42, 24));
		lblDate.setText("DATE");
		lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);

		lblRec.setBounds(new Rectangle(329, 8, 89, 24));
		lblRec.setText("");
		lblRec.setHorizontalAlignment(SwingConstants.LEFT);
		lblRec.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblRec.setBorder(null);

		txtEmpCode.setBounds(new Rectangle(488, 7, 75, 23));
		txtEmpCode.setText("");
		txtEmpCode.setEnabled(false);
		txtEmpCode.setFont(new java.awt.Font("Tahoma", 1, 11));

		txtMID.setEnabled(false);
		txtMID.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtMID.setBounds(new Rectangle(104, 7, 141, 23));
		txtMID.setText("");

		txtName.setText("");
		txtName.setBounds(new Rectangle(603, 7, 148, 23));
		txtName.setEnabled(false);
		txtName.setFont(new java.awt.Font("Tahoma", 1, 11));

		txtDate.setBounds(new Rectangle(282, 7, 108, 23));
		txtDate.setEnabled(false);
		txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtDate.setText("");

		txtQ3.setText("");
		txtQ3.setBounds(new Rectangle(313, 75, 439, 23));
		txtQ3.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtQ6.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtQ6.setBounds(new Rectangle(313, 146, 439, 23));
		txtQ6.setText("");
		txtQ12.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtQ12.setBounds(new Rectangle(313, 287, 439, 23));
		txtQ12.setText("");

		rdoQ1Yes.setText("YES");
		rdoQ1Yes.setBounds(new Rectangle(622, 7, 60, 19));
		rdoQ1Yes.setBackground(Color.white);
		rdoQ1Yes.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ1NO.setBounds(new Rectangle(692, 7, 60, 19));
		rdoQ1NO.setText("NO");
		rdoQ1NO.setBackground(Color.white);
		rdoQ1NO.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtQ13a.setText("");
		txtQ13a.setBounds(new Rectangle(313, 334, 439, 23));
		txtQ13a.setFont(new java.awt.Font("Tahoma", 1, 11));

		rdoQ14H.setBackground(Color.white);
		rdoQ14O.setBackground(Color.white);
		rdoQ14VO.setBackground(Color.white);
		rdoQ13Yes.setBackground(Color.white);
		rdoQ13NO.setBackground(Color.white);
		rdoQ11NO.setBackground(Color.white);
		rdoQ11Yes.setBackground(Color.white);
		rdoQ10Yes.setBackground(Color.white);
		rdoQ10NO.setBackground(Color.white);
		rdoQ9NO.setBackground(Color.white);
		rdoQ9Yes.setBackground(Color.white);
		rdoQ8H.setBackground(Color.white);
		rdoQ8O.setBackground(Color.white);
		rdoQ8VO.setBackground(Color.white);
		rdoQ7Yes.setBackground(Color.white);
		rdoQ7NO.setBackground(Color.white);
		rdoQ5H.setBackground(Color.white);
		rdoQ5O.setBackground(Color.white);
		rdoQ4Yes.setBackground(Color.white);
		rdoQ4NO.setBackground(Color.white);
		rdoQ2Other.setBackground(Color.white);
		rdoQ2Ak.setBackground(Color.white);
		rdoQ2CC.setBackground(Color.white);
		rdoQ2GP.setBackground(Color.white);
		rdoQ2Yes.setBackground(Color.white);
		rdoQ2NO.setBackground(Color.white);
		rdoQ5VO.setBackground(Color.white);
		bgQ1.add(rdoQ1Yes);
		bgQ1.add(rdoQ1NO);

		rdoQ2Yes.setBounds(new Rectangle(622, 30, 60, 19));
		rdoQ2Yes.setText("YES");
		rdoQ2Yes.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ2Yes.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rdoQ2CC.setVisible(true);
				rdoQ2Ak.setVisible(true);
				rdoQ2GP.setVisible(true);
				rdoQ2Other.setVisible(true);
				lblQ2a.setVisible(true);
			}
		});
		rdoQ2NO.setText("NO");
		rdoQ2NO.setBounds(new Rectangle(692, 30, 60, 19));
		rdoQ2NO.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ2NO.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rdoQ2CC.setVisible(false);
				rdoQ2Ak.setVisible(false);
				rdoQ2GP.setVisible(false);
				rdoQ2Other.setVisible(false);
				lblQ2a.setVisible(false);
			}
		});

		bgQ2.add(rdoQ2Yes);
		bgQ2.add(rdoQ2NO);

		rdoQ2CC.setBounds(new Rectangle(387, 51, 78, 19));
		rdoQ2CC.setText("City Cell");
		rdoQ2CC.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ2Ak.setBounds(new Rectangle(465, 51, 78, 19));
		rdoQ2Ak.setText("Aktel");
		rdoQ2Ak.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ2Other.setBounds(new Rectangle(546, 51, 78, 19));
		rdoQ2Other.setText("Other");
		rdoQ2Other.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ2GP.setText("Grameen");
		rdoQ2GP.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ2GP.setBounds(new Rectangle(308, 51, 78, 19));
		bgQ2a.add(rdoQ2CC);
		bgQ2a.add(rdoQ2Ak);
		bgQ2a.add(rdoQ2GP);
		bgQ2a.add(rdoQ2Other);

		rdoQ4Yes.setText("YES");
		rdoQ4Yes.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ4Yes.setBounds(new Rectangle(622, 101, 60, 19));
		rdoQ4NO.setBounds(new Rectangle(692, 101, 60, 19));
		rdoQ4NO.setText("NO");
		rdoQ4NO.setFont(new java.awt.Font("Tahoma", 1, 11));
		bgQ4.add(rdoQ4Yes);
		bgQ4.add(rdoQ4NO);

		rdoQ5O.setBounds(new Rectangle(461, 124, 67, 19));
		rdoQ5O.setText("OFTEN");
		rdoQ5O.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ5VO.setText("VERY OFTEN");
		rdoQ5VO.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ5VO.setBounds(new Rectangle(308, 124, 98, 19));
		rdoQ5H.setText("HARDLY");
		rdoQ5H.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ5H.setBounds(new Rectangle(542, 124, 86, 19));
		bgQ5.add(rdoQ5O);
		bgQ5.add(rdoQ5VO);
		bgQ5.add(rdoQ5H);

		rdoQ7Yes.setText("YES");
		rdoQ7Yes.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ7Yes.setBounds(new Rectangle(622, 171, 60, 19));
		rdoQ7NO.setBounds(new Rectangle(692, 171, 60, 19));
		rdoQ7NO.setText("NO");
		rdoQ7NO.setFont(new java.awt.Font("Tahoma", 1, 11));
		bgQ7.add(rdoQ7Yes);
		bgQ7.add(rdoQ7NO);

		rdoQ8O.setText("OFTEN");
		rdoQ8O.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ8O.setBounds(new Rectangle(461, 195, 67, 19));
		rdoQ8H.setBounds(new Rectangle(542, 195, 86, 19));
		rdoQ8H.setText("HARDLY");
		rdoQ8H.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ8VO.setBounds(new Rectangle(308, 195, 98, 19));
		rdoQ8VO.setText("VERY OFTEN");
		rdoQ8VO.setFont(new java.awt.Font("Tahoma", 1, 11));
		bgQ8.add(rdoQ8O);
		bgQ8.add(rdoQ8VO);
		bgQ8.add(rdoQ8H);

		rdoQ9Yes.setText("YES");
		rdoQ9Yes.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ9Yes.setBounds(new Rectangle(622, 218, 60, 19));
		rdoQ9NO.setBounds(new Rectangle(692, 218, 60, 19));
		rdoQ9NO.setText("NO");
		rdoQ9NO.setFont(new java.awt.Font("Tahoma", 1, 11));
		bgQ9.add(rdoQ9Yes);
		bgQ9.add(rdoQ9NO);

		rdoQ10Yes.setText("YES");
		rdoQ10Yes.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ10Yes.setBounds(new Rectangle(622, 242, 60, 19));
		rdoQ10NO.setBounds(new Rectangle(692, 242, 60, 19));
		rdoQ10NO.setText("NO");
		rdoQ10NO.setFont(new java.awt.Font("Tahoma", 1, 11));
		bgQ10.add(rdoQ10Yes);
		bgQ10.add(rdoQ10NO);

		rdoQ11Yes.setText("YES");
		rdoQ11Yes.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ11Yes.setBounds(new Rectangle(622, 262, 60, 19));
		rdoQ11NO.setBounds(new Rectangle(692, 262, 60, 19));
		rdoQ11NO.setText("NO");
		rdoQ11NO.setFont(new java.awt.Font("Tahoma", 1, 11));
		bgQ11.add(rdoQ11Yes);
		bgQ11.add(rdoQ11NO);

		rdoQ13Yes.setText("YES");
		rdoQ13Yes.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ13Yes.setBounds(new Rectangle(622, 312, 60, 18));
		rdoQ13Yes.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				txtQ13a.setVisible(true);
				lblQ13a.setVisible(true);
			}
		});
		rdoQ13NO.setBounds(new Rectangle(692, 312, 60, 18));
		rdoQ13NO.setText("NO");
		rdoQ13NO.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ13NO.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				txtQ13a.setVisible(false);
				lblQ13a.setVisible(false);
			}
		});
		bgQ13.add(rdoQ13Yes);
		bgQ13.add(rdoQ13NO);

		rdoQ14O.setText("OFTEN");
		rdoQ14O.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ14O.setBounds(new Rectangle(580, 359, 67, 19));
		rdoQ14H.setBounds(new Rectangle(661, 359, 86, 19));
		rdoQ14H.setText("HARDLY");
		rdoQ14H.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoQ14VO.setBounds(new Rectangle(425, 359, 98, 19));
		rdoQ14VO.setText("VERY OFTEN");
		rdoQ14VO.setFont(new java.awt.Font("Tahoma", 1, 11));
		bgQ14.add(rdoQ14O);
		bgQ14.add(rdoQ14VO);
		bgQ14.add(rdoQ14H);

		btnNew.setBounds(new Rectangle(107, 6, 91, 28));
		btnNew.setText("NEW");
		btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnNew.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d = new Date();
				CurrentDate = null;
				TranID = new String("M");
				sdf = new SimpleDateFormat("y");
				TranID = TranID + sdf.format(d);
				sdf = new SimpleDateFormat("M");
				TranID = TranID + sdf.format(d);
				sdf = new SimpleDateFormat("d");
				TranID = TranID + sdf.format(d);
				TranID = TranID + EmpCode;
				sdf = new SimpleDateFormat("Hms");
				TranID = TranID + sdf.format(d);
				System.out.println("Transaction ID: " + TranID);
				clearFields();
				txtMID.setText(TranID);
				txtEmpCode.setText(EmpCode);
				txtName.setText(userName);
				d = new Date();
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				CurrentDate = sdf.format(d);
				txtDate.setText(CurrentDate);
				isAdd = true;
				SetInitialButtons(false);
				SetTextFields(true);
				SetLabelsRDOs();
				lblRec.setText(" Add New Rec. ");
			}
		});

		btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnSave.setText("SAVE");
		btnSave.setBounds(new Rectangle(107, 6, 91, 28));
		btnSave.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CheckRDOs();
				CheckFields();
				if (fieldsOK)
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
							//BUTTON STATE...
							SetInitialButtons(true);
							//FIELD STATE...
							SetTextFields(false);
							fieldsOK = false;
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
							//BUTTON STATE...
							SetInitialButtons(true);
							//FIELD STATE...
							SetTextFields(false);
							fieldsOK = false;
						}
					}

					//SET FLAG...
					isAdd=false;
					lblRec.setText("");
				}
				else
				{ return; }
			}
		});

		btnEdit.setText("EDIT");
		btnEdit.setBounds(new Rectangle(203, 6, 91, 28));
		btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnEdit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SetInitialButtons(false);
				SetTextFields(true);
				SetLabelsRDOs();
				lblRec.setText(" Edit Record. ");
			}
		});

		btnDelete.setBounds(new Rectangle(456, 5, 91, 28));
		btnDelete.setText("Delete");
		btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnDelete.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (txtMID.getText().equals(""))
				{ return; }
				DeleteData();
			}
		});

		btnClose.setText("CLOSE");
		btnClose.setBounds(new Rectangle(553, 5, 91, 28));
		btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnClose.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent x2)
			{ dispose(); }
		});

		btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnCancel.setText("CANCEL");
		btnCancel.setBounds(new Rectangle(203, 6, 91, 28));
		btnCancel.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SetInitialButtons(true);
				SetTextFields(false);
				//REFRESH...
				getConnected();
				isAdd = false;
				lblRec.setText("");
			}
		});

		btnPrev.setBounds(new Rectangle(306, 8, 22, 23));
		btnPrev.setText("");
		btnPrev.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnPrev.setIcon(imgPrev);
		btnPrev.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnPrev.setIcon(imgPO); }
			public void mouseExited(MouseEvent f)
			{ btnPrev.setIcon(imgPrev);	}
		});
		btnPrev.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					mob=mobcon.movePrevious();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMobile]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
			}
		});

		btnNext.setText("");
		btnNext.setBounds(new Rectangle(421, 8, 22, 23));
		btnNext.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnNext.setIcon(imgNext);
		btnNext.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnNext.setIcon(imgNO); }
			public void mouseExited(MouseEvent f)
			{ btnNext.setIcon(imgNext);	}
		});
		btnNext.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					mob=mobcon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMobile]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
			}
		});

		pnlMid.add(lblQ1, null);
		pnlMid.add(rdoQ1NO, null);
		pnlMid.add(rdoQ1Yes, null);
		pnlMid.add(rdoQ2GP, null);
		pnlMid.add(lblQ4, null);
		pnlMid.add(rdoQ7Yes, null);
		pnlMid.add(rdoQ7NO, null);
		pnlMid.add(lblQ2, null);
		pnlMid.add(lblQ10, null);
		pnlMid.add(lblQ9, null);
		pnlMid.add(rdoQ9Yes, null);
		pnlMid.add(rdoQ10Yes, null);
		pnlMid.add(rdoQ9NO, null);
		pnlMid.add(rdoQ10NO, null);
		pnlMid.add(rdoQ8H, null);
		pnlMid.add(rdoQ8O, null);
		pnlMid.add(rdoQ8VO, null);
		pnlMid.add(lblQ8, null);
		pnlMid.add(lblQ7, null);
		pnlMid.add(lblQ6, null);
		pnlMid.add(txtQ6, null);
		pnlMid.add(rdoQ5H, null);
		pnlMid.add(rdoQ5O, null);
		pnlMid.add(lblQ5, null);
		pnlMid.add(rdoQ5VO, null);
		pnlMid.add(rdoQ4Yes, null);
		pnlMid.add(rdoQ4NO, null);
		pnlMid.add(txtQ3, null);
		pnlMid.add(lblQ3, null);
		pnlMid.add(lblQ2a, null);
		pnlMid.add(rdoQ2NO, null);
		pnlMid.add(rdoQ2Yes, null);
		pnlMid.add(lblQ11, null);
		pnlMid.add(rdoQ11Yes, null);
		pnlMid.add(rdoQ11NO, null);
		pnlMid.add(txtQ12, null);
		pnlMid.add(lblQ12, null);
		pnlMid.add(lblQ13, null);
		pnlMid.add(rdoQ13Yes, null);
		pnlMid.add(rdoQ13NO, null);
		pnlMid.add(txtQ13a, null);
		pnlMid.add(lblQ13a, null);
		pnlMid.add(lblQ14, null);
		pnlMid.add(rdoQ14VO, null);
		pnlMid.add(rdoQ14O, null);
		pnlMid.add(rdoQ14H, null);
		pnlMid.add(rdoQ2CC, null);
		pnlMid.add(rdoQ2Ak, null);
		pnlMid.add(rdoQ2Other, null);
		this.getContentPane().add(pnlButtons, null);
		pnlTop.add(txtName, null);
		pnlTop.add(lblEID, null);
		pnlTop.add(txtMID, null);
		pnlTop.add(lblDate, null);
		pnlTop.add(txtDate, null);
		pnlTop.add(lblEmpCode, null);
		pnlTop.add(txtEmpCode, null);
		pnlTop.add(lblName, null);
		this.getContentPane().add(pnlMid, null);

		pnlButtons.add(btnClose, null);
		pnlButtons.add(btnDelete, null);
		pnlButtons.add(btnNext, null);
		pnlButtons.add(lblRec, null);
		pnlButtons.add(btnPrev, null);
		pnlButtons.add(btnEdit, null);
		pnlButtons.add(btnNew, null);
		pnlButtons.add(btnCancel, null);
		pnlButtons.add(btnSave, null);
		this.getContentPane().add(pnlTop, null);

		this.setClosable(true);
		this.setIconifiable(true);
		this.setTitle("MOBILE REQUEST FORM");
		this.getContentPane().setLayout(null);
		this.setFrameIcon(imgIco);
		this.getContentPane().setBackground(Color.white);
		this.setSize(new Dimension(777, 507));

		SetTextFields(false);
		SetInitialButtons(true);
		getConnected();
	}//Cons

	/**
	*	Connects Table
	*
	*/

	public void getConnected()
	{
		//CONNECT TABLE
		try
		{
			mobcon.Connect(EmpCode);
		}catch(RemoteException re){ System.out.println("Client [frmMobile]: Open Error");System.out.println("Error: "+re.getMessage());}

		//DISPLAY DATA RMI
		try
		{
			mob=mobcon.moveNext();
			display();
		}catch(RemoteException re){ System.out.println("Client [frmMobile]: Show Error");System.out.println("Error: "+re.getMessage());}
	}

	/**
	*	Display Data
	*
	*/

	public void display()
	{
		clearFields();
		String rdoQ1Val = new String("");
		String rdoQ2Val = new String("");
		String rdoQ2aVal = new String("");
		String rdoQ4Val = new String("");
		String rdoQ5Val = new String("");
		String rdoQ7Val = new String("");
		String rdoQ8Val = new String("");
		String rdoQ9Val = new String("");
		String rdoQ10Val = new String("");
		String rdoQ11Val = new String("");
		String rdoQ13Val = new String("");
		String rdoQ14Val = new String("");

		txtMID.setText(mob.getTransactionID());
		if(!txtMID.getText().equals("")) txtName.setText(userName);
		txtEmpCode.setText(mob.getEmpCode());
		txtDate.setText(mob.getDate());

		lblQ1.setText(stQ1 + mob.getQ1());
		lblQ2.setText(stQ2 + mob.getQ2());
		lblQ2a.setText(stQ2a + mob.getQ2a());

		txtQ3.setText(mob.getQ3());

		lblQ4.setText(stQ4 + mob.getQ4());
		lblQ5.setText(stQ5 + mob.getQ5());

		txtQ6.setText(mob.getQ6());

		lblQ7.setText(stQ7 + mob.getQ7());
		lblQ8.setText(stQ8 + mob.getQ8());
		lblQ9.setText(stQ9 + mob.getQ9());
		lblQ10.setText(stQ10 + mob.getQ10());
		lblQ11.setText(stQ11 + mob.getQ11());

		txtQ12.setText(mob.getQ12());

		lblQ13.setText(stQ13 + mob.getQ13());

		txtQ13a.setText(mob.getQ13a());

		lblQ14.setText(stQ14 + mob.getQ14());
	}

	/**
	*	Clear Text Fields
	*
	*/

	public void clearFields()
	{
		txtMID.setText("");
		txtDate.setText("");
		txtName.setText("");
		txtEmpCode.setText("");
		lblRec.setText("");
		txtQ3.setText("");
		txtQ6.setText("");
		txtQ12.setText("");
		txtQ13a.setText("");
	}

	/**
	*	Setting Text Fields
	*	@param boolean true or false value
	*
	*/

	void SetTextFields(boolean txtValue)
	{
		txtQ3.setEnabled(txtValue);
		txtQ6.setEnabled(txtValue);
		txtQ12.setEnabled(txtValue);
		txtQ13a.setEnabled(txtValue);

		rdoQ1Yes.setVisible(txtValue);
		rdoQ1NO.setVisible(txtValue);
		rdoQ2Yes.setVisible(txtValue);
		rdoQ2NO.setVisible(txtValue);
		rdoQ2CC.setVisible(txtValue);
		rdoQ2GP.setVisible(txtValue);
		rdoQ2Ak.setVisible(txtValue);
		rdoQ2Other.setVisible(txtValue);
		rdoQ4Yes.setVisible(txtValue);
		rdoQ4NO.setVisible(txtValue);
		rdoQ5VO.setVisible(txtValue);
		rdoQ5O.setVisible(txtValue);
		rdoQ5H.setVisible(txtValue);
		rdoQ7Yes.setVisible(txtValue);
		rdoQ7NO.setVisible(txtValue);
		rdoQ8VO.setVisible(txtValue);
		rdoQ8O.setVisible(txtValue);
		rdoQ8H.setVisible(txtValue);
		rdoQ9Yes.setVisible(txtValue);
		rdoQ9NO.setVisible(txtValue);
		rdoQ10Yes.setVisible(txtValue);
		rdoQ10NO.setVisible(txtValue);
		rdoQ11Yes.setVisible(txtValue);
		rdoQ11NO.setVisible(txtValue);
		rdoQ13Yes.setVisible(txtValue);
		rdoQ13NO.setVisible(txtValue);
		rdoQ14VO.setVisible(txtValue);
		rdoQ14O.setVisible(txtValue);
		rdoQ14H.setVisible(txtValue);
	}

	/**
	*	Setting Button States
	*	@param boolean true or false value
	*
	*/

	void SetInitialButtons(boolean bVal)
	{
		btnNew.setVisible(bVal);
		btnEdit.setVisible(bVal);
		btnSave.setVisible(!bVal);
		btnCancel.setVisible(!bVal);
		btnDelete.setEnabled(bVal);
		btnClose.setEnabled(bVal);
		btnPrev.setEnabled(bVal);
		btnNext.setEnabled(bVal);
	}

	/**
	*	Checking RDO's States
	*
	*/

	public void CheckRDOs()
	{
		if (rdoQ1Yes.isSelected()) {rdoQ1Val = "Yes";}
		if (rdoQ1NO.isSelected()) {rdoQ1Val = "No";}
		if (rdoQ2Yes.isSelected())
		{
			rdoQ2Val = "Yes";
			if (rdoQ2CC.isSelected()) {rdoQ2aVal = "City Cell";}
			if (rdoQ2GP.isSelected()) {rdoQ2aVal = "Grameen Phone";}
			if (rdoQ2Ak.isSelected()) {rdoQ2aVal = "Aktel";}
			if (rdoQ2Other.isSelected()) {rdoQ2aVal = "Other";}
		}
		if (rdoQ2NO.isSelected())
		{
			rdoQ2Val = "No";
			rdoQ2aVal = "-";
		}
		if (rdoQ4Yes.isSelected()) {rdoQ4Val = "Yes";}
		if (rdoQ4NO.isSelected()) {rdoQ4Val = "No";}
		if (rdoQ5VO.isSelected()) {rdoQ5Val = "Very Often";}
		if (rdoQ5O.isSelected()) {rdoQ5Val = "Often";}
		if (rdoQ5H.isSelected()) {rdoQ5Val = "Hardly";}
		if (rdoQ7Yes.isSelected()) {rdoQ7Val = "Yes";}
		if (rdoQ7NO.isSelected()) {rdoQ7Val = "No";}
		if (rdoQ8VO.isSelected()) {rdoQ8Val = "Very Often";}
		if (rdoQ8O.isSelected()) {rdoQ8Val = "Often";}
		if (rdoQ8H.isSelected()) {rdoQ8Val = "Hardly";}
		if (rdoQ9Yes.isSelected()) {rdoQ9Val = "Yes";}
		if (rdoQ9NO.isSelected()) {rdoQ9Val = "No";}
		if (rdoQ10Yes.isSelected()) {rdoQ10Val = "Yes";}
		if (rdoQ10NO.isSelected()) {rdoQ10Val = "No";}
		if (rdoQ11Yes.isSelected()) {rdoQ11Val = "Yes";}
		if (rdoQ11NO.isSelected()) {rdoQ11Val = "No";}
		if (rdoQ13Yes.isSelected()) {rdoQ13Val = "Yes";}
		if (rdoQ13NO.isSelected())
		{
			rdoQ13Val = "No";
			txtQ13a.setText("-");
		}
		if (rdoQ14VO.isSelected()) {rdoQ14Val = "Very Often";}
		if (rdoQ14O.isSelected()) {rdoQ14Val = "Often";}
		if (rdoQ14H.isSelected()) {rdoQ14Val = "Hardly";}
	}

	/**
	*	Field Checking
	*
	*	@return boolean true or false value
	*/

	public void CheckFields()
	{
		if (txtQ3.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,
			"Please provide required information!!!",
			"Missing Information",
			JOptionPane.ERROR_MESSAGE);
			txtQ3.requestFocus();
			fieldsOK = false; ;
		}
		else if (txtQ6.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,
			"Please provide required information!!!",
			"Missing Information",
			JOptionPane.ERROR_MESSAGE);
			txtQ6.requestFocus();
			fieldsOK = false; ;
		}
		else if (txtQ12.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,
			"Please provide required information!!!",
			"Missing Information",
			JOptionPane.ERROR_MESSAGE);
			txtQ12.requestFocus();
			fieldsOK = false; ;
		}
		else if (txtQ13a.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,
			"Please provide required information!!!",
			"Missing Information",
			JOptionPane.ERROR_MESSAGE);
			txtQ13a.requestFocus();
			fieldsOK = false; ;
		}

		else
		{ fieldsOK = true; }
	}

	public boolean save()
	{//Save
		boolean savesucc=false;

		//INITIALISE USER OBJECT...
		mob.setTransactionID(txtMID.getText());
		mob.setEmpCode(EmpCode);
		mob.setDate(txtDate.getText());
		mob.setQ1(rdoQ1Val);
		mob.setQ2(rdoQ2Val);
		mob.setQ2a(rdoQ2aVal);
		mob.setQ3(txtQ3.getText());
		mob.setQ4(rdoQ4Val);
		mob.setQ5(rdoQ5Val);
		mob.setQ6(txtQ6.getText());
		mob.setQ7(rdoQ7Val);
		mob.setQ8(rdoQ8Val);
		mob.setQ9(rdoQ9Val);
		mob.setQ10(rdoQ10Val);
		mob.setQ11(rdoQ11Val);
		mob.setQ12(txtQ12.getText());
		mob.setQ13(rdoQ13Val);
		mob.setQ13a(txtQ13a.getText());
		mob.setQ14(rdoQ14Val);
		mob.setDeptApp("-");
		mob.setDeptComm("-");
		mob.setDeptAppBy("-");
		mob.setISApp("-");
		mob.setISComm("-");
		mob.setISAppBy("-");
		mob.setJobStatus("-");

		try
		{
			savesucc = mobcon.insertData(mob);
			StartWorking("ADDING NEW RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
			lblRec.setText("");
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMobile]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMobile]: "+re.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			return savesucc;
		}

		return savesucc;
	}//Save

	/**
	*	Requests Server to Update a Specific Record
	*
	*/

	public boolean editData()
	{//Edit Data
		boolean updatesucc=false;

		//INITIALISE USER OBJECT...
		mob.setQ1(rdoQ1Val);
		mob.setQ2(rdoQ2Val);
		mob.setQ2a(rdoQ2aVal);
		mob.setQ3(txtQ3.getText());
		mob.setQ4(rdoQ4Val);
		mob.setQ5(rdoQ5Val);
		mob.setQ6(txtQ6.getText());
		mob.setQ7(rdoQ7Val);
		mob.setQ8(rdoQ8Val);
		mob.setQ9(rdoQ9Val);
		mob.setQ10(rdoQ10Val);
		mob.setQ11(rdoQ11Val);
		mob.setQ12(txtQ12.getText());
		mob.setQ13(rdoQ13Val);
		mob.setQ13a(txtQ13a.getText());
		mob.setQ14(rdoQ14Val);

		try
		{
			updatesucc = mobcon.updateEmpData(mob);
			StartWorking("UPDATING RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
			lblRec.setText("");
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMobile]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmMobile]: "+re.getMessage(),
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
		String strQuery = "DELETE FROM Mobile WHERE TransactionID='" + txtMID.getText() +"';";

		yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
		JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
			try
			{
				mobcon.DeleteData(strQuery);
				StartWorking("DELETING RECORD");
				JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
				clearFields();
				getConnected();

			}catch(RemoteException re)
			{
				System.out.println("Client [frmMobile]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
				JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMobile]: "+re.getMessage(),
													"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {}
	}//Delete Data

	/**
	*	Set RDO Labels
	*
	*/

	public void SetLabelsRDOs()
	{
		lblQ1.setText(stQ1);
		lblQ2.setText(stQ2);
		lblQ2a.setText(stQ2a);
		lblQ4.setText(stQ4);
		lblQ5.setText(stQ5);
		lblQ7.setText(stQ7);
		lblQ8.setText(stQ8);
		lblQ9.setText(stQ9);
		lblQ10.setText(stQ10);
		lblQ11.setText(stQ11);
		lblQ13.setText(stQ13);
		lblQ14.setText(stQ14);

		rdoQ1Yes.setSelected(true);
		rdoQ2Yes.setSelected(true);
		rdoQ2GP.setSelected(true);
		rdoQ4Yes.setSelected(true);
		rdoQ5VO.setSelected(true);
		rdoQ7Yes.setSelected(true);
		rdoQ8VO.setSelected(true);
		rdoQ9Yes.setSelected(true);
		rdoQ10Yes.setSelected(true);
		rdoQ11Yes.setSelected(true);
		rdoQ13Yes.setSelected(true);
		rdoQ14VO.setSelected(true);
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

	//void btnPrint_actionPerformed(ActionEvent e) {}

}//Class