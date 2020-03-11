import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

/**
 * ConcertEvent is a concert event mapping with appropriate pricing and logic for selecting seats. The ConcertEvent GUI allows
 * the user to checkout once the appropriate seats are selected.
 *
 * @author Taylor Dodson
 * @since 03/10/2017
 * @version 1.0
 */

public class ConcertEvent extends JFrame implements EventLayout {

    //Create a frame for the panels.
    JFrame frame = new JFrame();

    //Set global values for tracking reservations and pricing.
    double total = 0.00; //The total price of all seats.
    double seatPrice = 0.00; //Tracks the price of the most recently selected seat.
    Set<String> selectedSeats = new HashSet<>(); //Contains the labels of all seats selected.
    JToggleButton [][] allSeats = new JToggleButton[5][20]; //Stores seats so their states can be modified remotely.

    //Initialize global labels.
    JLabel user = new JLabel();
    JLabel selectedLabel = new JLabel("Selected Seats: NONE");
    JLabel priceLabel = new JLabel("Seat Price: NONE");
    JLabel totalPriceLabel = new JLabel("Total: $0.00");
    JLabel priceListing = new JLabel("Seats 1-40: $100 | Seats 41-80: $75 | Seats 81-100: $50");

    //Initialize "clear selection" and "reserve seats" buttons.
    JButton clearSelection = new JButton("Clear Selection");
    JButton reserveSeats = new JButton("Reserve Selected Seats");

    /**
     * The constructor for the ConcertEvent class. Creates a GUI object that is visible to the user that contains components
     * that allow the user to select seats and view prices.
     *
     * @param userType a String containing the user's type (i.e VIP, regular, bulk)
     */

    public ConcertEvent (String userType){

        clearSelection.addActionListener(new ActionListener(){ //Action Listener
            public void actionPerformed(ActionEvent c) {
                clearSelection();
            }
        });//Action Listener

        reserveSeats.addActionListener(new ActionListener(){ //Action Listener
            public void actionPerformed(ActionEvent c){
                finalizeSelection(userType);
            }
        });//Action Listener

        //Set the parameters/functions of the window.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1300,600);
        setLocationRelativeTo(null);

        /**Builds the corresponding layout.**/
        buildLayout();

        this.user.setText("User Type: " + userType);
        this.totalPriceLabel.setText(String.format("Total Price $%.2f", total));
        setResizable(false);
        setVisible(true);
    }

    /**
     * Builds the concert layout structure so that it resembles a typical concert stage.
     */

    public void buildLayout(){

        this.setTitle("Concert");

        //Concert layout contains 4 panels: 1 for labels, 1 for the stage, 1 for seats, and 1 for clear/reserve options.
        this.setLayout(new GridLayout(4,1));

        //Initialize each panel.
        JPanel labels = new JPanel();
        JPanel options = new JPanel();
        JPanel stage = new JPanel();
        JPanel seats = new JPanel();

        //Format and build labels panel.
        labels.setLayout(new GridLayout(3,1));
        labels.setBorder(BorderFactory.createLineBorder(Color.black));
        labels.add(user);
        labels.add(selectedLabel);
        labels.add(priceLabel);
        labels.add(totalPriceLabel);
        labels.add(priceListing);

        //Format and build options panel.
        options.setLayout(new GridLayout(1,2, 20, 20));
        options.add(clearSelection);
        options.add(reserveSeats);

        //Format and build stage panel.
        stage.setLayout(new BorderLayout());
        JButton stageButton = new JButton("STAGE"); //Creates button representing stage, pressed down to give a unique look
        stageButton.setEnabled(false);
        stage.add(stageButton, BorderLayout.CENTER);

        //Format and build the seat layout.
        int count = 0; //Keeps track of the seat number.
        seats.setLayout(new GridLayout(5,20, 5, 5));
        for (int i =  0; i < allSeats.length; i++){ //This loop creates 100 seats and stores refrences to them in the array.
            for (int j = 0; j < allSeats[i].length; j++){

                count++;
                JToggleButton seat = new JToggleButton(String.valueOf(count));

                //Add a listener to the new seat.
                seat.addActionListener(new java.awt.event.ActionListener(){ //Action Listener
                    public void actionPerformed(ActionEvent c){reserveSeat(seat.getText());}
                });//Action Listener

                allSeats[i][j] = seat; //Store the newly created seat in the array of seats.
                seats.add(seat); //Add the seat to
            }
        }

        //Add all panels to the JFrame, frame.
        this.add(labels);
        this.add(stage);
        this.add(seats);
        this.add(options);
    }

    /**
     * This method is called by pushing seat buttons on the ConcertEvent object's GUI. It contains the logic for adjusting
     * the price and adding/removing from the seat list.
     *
     * @param seatLabel a String that represents a seat numbering
     */

    public void reserveSeat(String seatLabel){

        if(selectedSeats.contains(seatLabel)) {
            selectedSeats.remove(seatLabel);
            int seatNum = Integer.parseInt(seatLabel);

            seatPrice = 0;

            if (seatNum <= 40) {
                total -= 100.00;
            }
            if (seatNum >= 41 && seatNum <= 80) {
                total -= 75.00;
            } else if (seatNum >= 81) {
                total -= 50.00;
            }
        }
        else {
            selectedSeats.add(seatLabel); //Add seat to the list of seats selected.
            int seatNum = Integer.parseInt(seatLabel); //Seat numbers are stored as strings: parsing to int for comparison.

            //The number on the seat indicates its price.
            if (seatNum <= 40) {
                total += 100.00;
                seatPrice = 100.00;
            }
            if (seatNum >= 41 && seatNum <= 80) {
                total += 75.00;
                seatPrice = 75.00;
            } else if (seatNum >= 81) {
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

        for(int i = 0; i < allSeats.length; i++){
            for (int j = 0; j < allSeats[i].length; j++){
                allSeats[i][j].setSelected(false);
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