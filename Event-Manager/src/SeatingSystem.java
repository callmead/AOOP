import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * SeatingSystem contains the initial GUI for the Event Manager that allows users to select their user type and the
 * event that they wish to view.
 *
 * @author Taylor Dodson
 * @since 03/06/2017
 * @version 1.0
 */

public class SeatingSystem extends JFrame{

    JPanel p1 = new JPanel();
    TitledBorder titledBorder1;
    JLabel lblSelectEventType = new JLabel("Select Event Type");

    JRadioButton rdbtnConcert = new JRadioButton("Concert");
    JRadioButton rdbtnGame = new JRadioButton("Game");
    JRadioButton rdbtnIceShow = new JRadioButton("Race");
    ButtonGroup EventGroup = new ButtonGroup();

    JLabel lblUserType = new JLabel("User Type");

    JRadioButton rdbtnRegular = new JRadioButton("Regular");
    JRadioButton rdbtnVip = new JRadioButton("VIP");
    JRadioButton rdbtnBulkPurchase = new JRadioButton("Bulk Purchase");
    ButtonGroup UserGroup = new ButtonGroup();

    JButton btnShowSeatingMap = new JButton("Show Seating Map");

    String EventType;
    String UserType;

    /**
     * Basic constructor for the SeatingSystem. Responsible for initialization of all the containers and components
     * that allow the user to view and interact with the GUI.
     */

    public SeatingSystem()
    {
        this.setTitle("Seating System");
        this.setBounds(100, 100, 330, 220);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.getContentPane().add(p1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.white);
        titledBorder1 = new TitledBorder("");

        p1.setLayout(null);
        p1.setBounds(2, 2, 322, 212);
        p1.setBorder(titledBorder1);

        p1.add(lblSelectEventType);

        EventGroup.add(rdbtnConcert);
        EventGroup.add(rdbtnGame);
        EventGroup.add(rdbtnIceShow);
        p1.add(rdbtnConcert);
        p1.add(rdbtnGame);
        p1.add(rdbtnIceShow);

        p1.add(lblUserType);

        UserGroup.add(rdbtnRegular);
        UserGroup.add(rdbtnVip);
        UserGroup.add(rdbtnBulkPurchase);
        p1.add(rdbtnRegular);
        p1.add(rdbtnVip);
        p1.add(rdbtnBulkPurchase);
        p1.add(btnShowSeatingMap);

        lblSelectEventType.setBounds(28, 10, 120, 20);
        rdbtnConcert.setBounds(28, 40, 120, 20);
        rdbtnGame.setBounds(28, 60, 120, 20);
        rdbtnIceShow.setBounds(28, 80, 120, 20);

        lblUserType.setBounds(170, 10, 120, 20);
        rdbtnRegular.setBounds(170, 40, 120, 20);
        rdbtnVip.setBounds(170, 60, 120, 20);
        rdbtnBulkPurchase.setBounds(170, 80, 120, 20);

        btnShowSeatingMap.setBounds(80, 130, 150, 20);
        btnShowSeatingMap.addActionListener(new java.awt.event.ActionListener()
        { //Action Listener
            public void actionPerformed(ActionEvent x1)
            {
                checkSelection();
            }
        });//Action Listener
    }

    /**
     * The main method for the application. Instantiates a SeatingSystem object and sets its visibility so that the
     * user can view the application.
     *
     * @param args no params
     */
    public static void main (String args[])
    {
        SeatingSystem s = new SeatingSystem();
        s.setVisible(true);
    }

    /**
     * Checks the users selection of the radio buttons and creates the appropriate event JPanel or informs the user
     * of the error within their selection.
     */

    public void checkSelection()
    {
        if (rdbtnConcert.isSelected()){EventType = "Concert";}
        if (rdbtnGame.isSelected()){EventType = "Game";}
        if (rdbtnIceShow.isSelected()){EventType = "Race";}
        else if (EventType == null){JOptionPane.showMessageDialog(null, "Please select Event Type", "Error", JOptionPane.ERROR_MESSAGE);}

        if (rdbtnRegular.isSelected()){UserType = "Regular";}
        if (rdbtnVip.isSelected()){UserType = "VIP";}
        if (rdbtnBulkPurchase.isSelected()){UserType = "Bulk";}
        else if (UserType == null){JOptionPane.showMessageDialog(null, "Please select User Type", "Error", JOptionPane.ERROR_MESSAGE);}

        //Once user and event type is selected, an event of the chosen type will be created.
        if (UserType != null && EventType != null){
            System.out.println("Event: "+EventType+". User: "+UserType);

            //Creates a seat layout based on the user's choice.
            if(EventType.equals("Concert")){
                ConcertEvent myLayout = new ConcertEvent(UserType);
            } else if (EventType.equals("Game")){
                GameEvent myLayout = new GameEvent(UserType);
            } else {
                RaceEvent myLayout = new RaceEvent(UserType);
            }
        }

    }

}