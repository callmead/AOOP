import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

/**
 * GameEvent is a game event mapping with appropriate pricing and logic for selecting seats. The GameEvent GUI allows
 * the user to checkout once the appropriate seats are selected.
 *
 * @author Taylor Dodson
 * @since 03/10/2017
 * @version 1.0
 */

public class GameEvent extends JFrame  implements EventLayout  {

    //Create a frame for the panels.
    JFrame frame = new JFrame();

    //Set global values for tracking reservations and pricing.
    double total = 0.00; //The total price of all seats.
    double seatPrice = 0.00; //Tracks the price of the most recently selected seat.
    Set<String> selectedSeats = new HashSet<>(); //Contains the labels of all seats selected.

    //Stores seats so their states can be modified remotely.
    JToggleButton [][] northSouthSeats = new JToggleButton[2][20];
    JToggleButton [][] eastWestSeats = new JToggleButton[2][30];

    //Initialize global labels and buttons.
    JLabel user = new JLabel();
    JLabel selectedLabel = new JLabel("Selected Seats: NONE");
    JLabel priceLabel = new JLabel("Seat Price: NONE");
    JLabel totalPriceLabel = new JLabel("Total: $0.00");
    JLabel priceListing = new JLabel("North/South: $100 | East/West Front: $75 | East/West Back: $50");

    //Initialize "clear selection" and "reserve seats" buttons.
    JButton clearSelection = new JButton("Clear Selection");
    JButton reserveSeats = new JButton("Reserve Selected Seats");

    /**
     * The constructor for the GameEvent class. Creates a GUI object that is visible to the user that contains components
     * that allow the user to select seats and view prices.
     *
     * @param userType a String containing the user's type (i.e VIP, regular, bulk)
     */

    public GameEvent (String userType){

        clearSelection.addActionListener(new ActionListener(){ //Action Listener
            public void actionPerformed(ActionEvent c){clearSelection();}
        });//Action Listener


        reserveSeats.addActionListener(new ActionListener(){ //Action Listener
            public void actionPerformed(ActionEvent c){finalizeSelection(userType);}
        });//Action Listener


        //Set the parameters/functions of the window.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1400,600);
        setLocationRelativeTo(null);


        buildLayout(); //Build the layout.

        this.user.setText("User Type: " + userType); //Set the label for the usertype.
        this.totalPriceLabel.setText("Total: $" + total); //Set the initial label for the total.
        //setResizable(false);
        setVisible(true);
    }

    /**
     * Builds the game layout structure so that it resembles a typical game arena.
     */

    public void buildLayout(){

        this.setTitle("Game");

        //Concert layout contains 5 panels: 1 for labels, 3 for seats and stage, and 1 for clear/reserve options.
        this.setLayout(new GridLayout(5,1));

        //Initialize each panel.
        JPanel labels = new JPanel();
        JPanel northSection = new JPanel();
        JPanel midSection = new JPanel();
        JPanel southSection = new JPanel();
        JPanel options = new JPanel();
        JPanel northSeats = new JPanel();
        JPanel southSeats = new JPanel();
        JPanel westSeats = new JPanel();
        JPanel eastSeats = new JPanel();



        //Format and build labels panel.
        labels.setLayout(new GridLayout(3,2));
        labels.setBorder(BorderFactory.createLineBorder(Color.black));
        labels.add(user);
        labels.add(selectedLabel);
        labels.add(priceLabel);
        labels.add(totalPriceLabel);
        labels.add(priceListing);

        //Format the seating areas.
        northSection.setLayout(new GridLayout(1,3));
        southSection.setLayout(new GridLayout(1,3));
        northSeats.setLayout(new GridLayout(2,10, 3, 3));
        southSeats.setLayout(new GridLayout(2,10, 3, 3));

        midSection.setLayout(new GridLayout(1,3));
        westSeats.setLayout(new GridLayout(3,10, 3, 3));
        eastSeats.setLayout(new GridLayout(3,10, 3, 3));


        //This loop creates 20 seats, places them on the north section, and stores refrences to them in an array.

        int count = 21; //Keeps track of the seat number.
        for (int i = 0; i < 20; i++){

            count--;
            JToggleButton seat = new JToggleButton(String.valueOf(count));
            seat.setFont(new Font("Arial", Font.BOLD, 8));

            //Add a listener to the new seat.
            seat.addActionListener(new ActionListener(){ //Action Listener
                public void actionPerformed(ActionEvent c){reserveSeat(seat.getText());}
            });//Action Listener

            northSouthSeats[0][i] = seat; //Store the newly created seat in the array of seats.
            northSeats.add(seat); //Add the seat to the section.
        }

        //This loop creates 20 seats, places them on the south section, and stores refrences to them in an array.
        count = 20; //Keeps track of the seat number.
        for (int i = 0; i < 20; i++){

            count++;
            JToggleButton seat = new JToggleButton(String.valueOf(count));
            seat.setFont(new Font("Arial", Font.BOLD, 8));

            //Add a listener to the new seat.
            seat.addActionListener(new ActionListener(){ //Action Listener
                public void actionPerformed(ActionEvent c){reserveSeat(seat.getText());}
            });//Action Listener

            northSouthSeats[1][i] = seat; //Store the newly created seat in the array of seats.
            southSeats.add(seat); //Add the seat to the section.
        }

        //Build the north and south sections by adding empty panels for spacing and the JPanels containing the seats.
        northSection.add(new JPanel());
        northSection.add(northSeats);
        northSection.add(new JPanel());

        southSection.add(new JPanel());
        southSection.add(southSeats);
        southSection.add(new JPanel());


        //This loop creates 30 seats, places them on the east section, and stores refrences to them in an array.
        count = 40; //Keeps track of the seat number.
        for (int i = 0; i < 30; i++){

            count++;
            JToggleButton seat = new JToggleButton(String.valueOf(count));
            seat.setFont(new Font("Arial", Font.BOLD, 8));

            //Add a listener to the new seat.
            seat.addActionListener(new ActionListener(){ //Action Listener
                public void actionPerformed(ActionEvent c){reserveSeat(seat.getText());}
            });//Action Listener

            eastWestSeats[0][i] = seat; //Store the newly created seat in the array of seats.
            eastSeats.add(seat); //Add the seat to the section.
        }


        //This loop creates 30 seats, places them on the west section, and stores refrences to them in an array.
        count = 70; //Keeps track of the seat number.
        for (int i = 0; i < 30; i++){

            count++;
            JToggleButton seat = new JToggleButton(String.valueOf(count));
            seat.setFont(new Font("Arial", Font.BOLD, 8));

            //Add a listener to the new seat.
            seat.addActionListener(new ActionListener(){ //Action Listener
                public void actionPerformed(ActionEvent c){reserveSeat(seat.getText());}
            });//Action Listener

            eastWestSeats[1][i] = seat; //Store the newly created seat in the array of seats.
            westSeats.add(seat); //Add the seat to the section.
        }

        //Creates button representing stage, pressed down to give a unique look
        JButton stageButton = new JButton("FIELD");
        stageButton.setEnabled(false);

        midSection.add(eastSeats);
        midSection.add(stageButton);
        midSection.add(westSeats);

        //Format and build options panel.
        options.setLayout(new GridLayout(1,2, 5, 5));
        options.add(clearSelection);
        options.add(reserveSeats);

        //Add all panels to the JFrame, frame.
        this.add(labels);
        this.add(northSection);
        this.add(midSection);
        this.add(southSection);
        this.add(options);
    }

    /**
     * This method is called by pushing seat buttons on the GameEvent object's GUI. It contains the logic for adjusting
     * the price and adding/removing from the seat list.
     *
     * @param seatLabel a String that represents a seat numbering
     */

    public void reserveSeat(String seatLabel){

        int seatNum = Integer.parseInt(seatLabel); //Seat numbers are stored as strings: parsing to int for comparison.

        if(selectedSeats.contains(seatLabel)) {

            selectedSeats.remove(seatLabel);
            seatPrice = 0;

            if (seatNum <= 40){
                total -= 100.00;
            } else if (seatNum == 50 || seatNum == 60||seatNum == 70||
                    seatNum == 49 || seatNum == 59||seatNum == 69||
                    seatNum == 48 || seatNum == 58||seatNum == 68||
                    seatNum == 71 || seatNum == 81||seatNum == 91||
                    seatNum == 72 || seatNum == 82||seatNum == 92||
                    seatNum == 73 || seatNum == 83||seatNum == 93){
                total -= 75.00;
            } else {
                total -= 50.00;
            }
        }

        else {
            selectedSeats.add(seatLabel); //Add seat to the list of seats selected.

            //The number on the seat indicates its price.
            if (seatNum <= 40) {
                total += 100.00;
                seatPrice = 100.00;
            } else if (seatNum == 50 || seatNum == 60 || seatNum == 70 ||
                    seatNum == 49 || seatNum == 59 || seatNum == 69 ||
                    seatNum == 48 || seatNum == 58 || seatNum == 68 ||
                    seatNum == 71 || seatNum == 81 || seatNum == 91 ||
                    seatNum == 72 || seatNum == 82 || seatNum == 92 ||
                    seatNum == 73 || seatNum == 83 || seatNum == 93) {
                total += 75.00;
                seatPrice = 75.00;
            } else {
                total += 50.00;
                seatPrice = 50.00;
            }
        }

        //Update the labels to reflect the new selections.
        this.totalPriceLabel.setText(String.format("Total Price $%.2f", total));
        this.priceLabel.setText(String.format("Seat Price: $%.2f", seatPrice));
        this.selectedLabel.setText("Seats Selected: " + Arrays.toString(selectedSeats.toArray()));

    }

    /**
     * Clears the selection of seats from the GameEvent GUI. This method is called by the clear button on the GUI.
     */

    public void clearSelection(){
        total = 0.00;
        seatPrice = 0.00;
        selectedSeats = new HashSet<>();

        for(int i = 0; i < northSouthSeats.length; i++){
            for (int j = 0; j < northSouthSeats[i].length; j++){
                northSouthSeats[i][j].setSelected(false);
            }

        }

        for(int i = 0; i < eastWestSeats.length; i++){
            for (int j = 0; j < eastWestSeats[i].length; j++){
                eastWestSeats[i][j].setSelected(false);
            }

        }

        this.totalPriceLabel.setText("Total Price $0.00");
        this.priceLabel.setText("Seat Price: None Selected");
        this.selectedLabel.setText("Seats Selected: None Selected");

    }

    /**
     * This method checks to see if the user has the appropriate number of seats and then creates a CheckOut GUI object
     * that contains the total and a summary of discounted pricing.
     *
     * @param user a String of the user type
     */

    public void finalizeSelection(String user){

        if (selectedSeats.size() >= 5 && !user.equals("Bulk")) {
            JOptionPane.showMessageDialog(null, "Error: " + user + " users cannot buy more than 4 seats. Please clear your selection and try again.");
        } else if (selectedSeats.size() < 5 && user.equals("Bulk")){
            JOptionPane.showMessageDialog(null, "Error: Bulk users cannot buy less than 5 seats. Please clear your selection and try again.");
        } else {
            CheckOut checkout = new CheckOut(total, user, selectedSeats);
        }

    }

}
