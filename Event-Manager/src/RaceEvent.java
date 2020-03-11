import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

/**
 * RaceEvent is a race event mapping with appropriate pricing and logic for selecting seats. The RaceEvent GUI allows
 * the user to checkout once the appropriate seats are selected.
 *
 * @author Taylor Dodson
 * @since 03/10/2017
 * @version 1.0
 */

public class RaceEvent extends JFrame  implements EventLayout  {

    //Create a frame for the panels.
    JFrame frame = new JFrame();

    //Set global values for tracking reservations and pricing.
    double total = 0.00; //The total price of all seats.
    double seatPrice = 0.00; //Tracks the price of the most recently selected seat.
    Set<String> selectedSeats = new HashSet<>(); //Contains the labels of all seats selected.

    //Stores seats so their states can be modified remotely.
    JToggleButton [][] allSeats = new JToggleButton[2][50];


    //Initialize global labels and buttons.
    JLabel user = new JLabel();
    JLabel selectedLabel = new JLabel("Selected Seats: NONE");
    JLabel priceLabel = new JLabel("Seat Price: NONE");
    JLabel totalPriceLabel = new JLabel("Total: $0.00");
    JLabel priceListing = new JLabel("North/South Front: $100 | North/South Middle: $75 | North/South Back: $50");

    //Initialize "clear selection" and "reserve seats" buttons.
    JButton clearSelection = new JButton("Clear Selection");
    JButton reserveSeats = new JButton("Reserve Selected Seats");


    /**
     * The constructor for the RaceEvent class. Creates a GUI object that is visible to the user that contains components
     * that allow the user to select seats and view prices.
     *
     * @param userType a String containing the user's type (i.e VIP, regular, bulk)
     */

    public RaceEvent (String userType){

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
        setResizable(false);
        setVisible(true);
    }

    /**
     * Builds the race layout structure so that it resembles a typical race track.
     */

    public void buildLayout(){

        this.setTitle("Race");


        //Concert layout contains 5 panels: 1 for labels, 3 for seats and stage, and 1 for clear/reserve options.
        this.setLayout(new GridLayout(5,1));

        //Initialize each panel.
        JPanel labels = new JPanel();
        JPanel northSeats = new JPanel();
        JPanel stage = new JPanel();
        JPanel southSeats = new JPanel();
        JPanel options = new JPanel();


        //Format and build labels panel.
        labels.setLayout(new GridLayout(3,2));
        labels.setBorder(BorderFactory.createLineBorder(Color.black));
        labels.add(user);
        labels.add(selectedLabel);
        labels.add(priceLabel);
        labels.add(totalPriceLabel);
        labels.add(priceListing);

        //Format the seating areas.
        northSeats.setLayout(new GridLayout(5,10, 3, 3));
        southSeats.setLayout(new GridLayout(5,10, 3, 3));
        stage.setLayout(new GridLayout(1,3));


        //This loop creates 50 seats, places them on the north section, and stores refrences to them in an array.
        int count = 51; //Keeps track of the seat number.
        for (int i = 0; i < 50; i++){

            count--;
            JToggleButton seat = new JToggleButton(String.valueOf(count));

            //Add a listener to the new seat.
            seat.addActionListener(new java.awt.event.ActionListener(){ //Action Listener
                public void actionPerformed(ActionEvent c){reserveSeat(seat.getText());}
            });//Action Listener

            allSeats[0][i] = seat; //Store the newly created seat in the array of seats.
            northSeats.add(seat); //Add the seat to the section.
        }

        //This loop creates 50 seats, places them on the south section, and stores refrences to them in an array.
        count = 50; //Keeps track of the seat number.
        for (int i = 0; i < 50; i++){
            count++;
            JToggleButton seat = new JToggleButton(String.valueOf(count));

            //Add a listener to the new seat.
            seat.addActionListener(new java.awt.event.ActionListener(){ //Action Listener
                public void actionPerformed(ActionEvent c){reserveSeat(seat.getText());}
            });//Action Listener

            allSeats[1][i] = seat; //Store the newly created seat in the array of seats.
            southSeats.add(seat); //Add the seat to the section.
        }

        //Formats and builds the "stage" area.
        JButton stageButton = new JButton("TRACK");
        stageButton.setEnabled(false);
        stage.add(stageButton);

        //Format and build options panel.
        options.setLayout(new GridLayout(1,2, 5, 5));
        options.add(clearSelection);
        options.add(reserveSeats);

        //Add all panels to the JFrame, frame.
        this.add(labels);
        this.add(northSeats);
        this.add(stage);
        this.add(southSeats);
        this.add(options);
    }

    /**
     * This method is called by pushing seat buttons on the RaceEvent object's GUI. It contains the logic for adjusting
     * the price and adding/removing from the seat list.
     *
     * @param seatLabel a String that represents a seat numbering
     */

    public void reserveSeat(String seatLabel){

        int seatNum = Integer.parseInt(seatLabel); //Seat numbers are stored as strings: parsing to int for comparison.

        if(selectedSeats.contains(seatLabel)) {
            selectedSeats.remove(seatLabel);

            seatPrice = 0;

            if (seatNum <= 50){
                if(seatNum < 21){
                    total -= 100.00;
                } else if (seatNum < 41){
                    total -= 75.00;
                } else {
                    total -= 50.00;
                }
            } else {
                if(seatNum < 71){
                    total -= 100.00;
                } else if (seatNum < 91){
                    total -= 75.00;
                } else {
                    total -= 50.00;
                }
            }
        }

        else {
            selectedSeats.add(seatLabel); //Add seat to the list of seats selected.

            //The number on the seat indicates its price.
            if (seatNum <= 50) {
                if (seatNum < 21) {
                    total += 100.00;
                    seatPrice = 100.00;
                } else if (seatNum < 41) {
                    total += 75.00;
                    seatPrice = 75.00;
                } else {
                    total += 50.00;
                    seatPrice = 50.00;
                }
            } else {
                if (seatNum < 71) {
                    total += 100.00;
                    seatPrice = 100.00;
                } else if (seatNum < 91) {
                    total += 75.00;
                    seatPrice = 75.00;
                } else {
                    total += 50.00;
                    seatPrice = 50.00;
                }
            }
        }

        //Update the labels to reflect the new selections.
        this.totalPriceLabel.setText(String.format("Total Price $%.2f", total));
        this.priceLabel.setText(String.format("Seat Price: $%.2f", seatPrice));
        this.selectedLabel.setText("Seats Selected: " + Arrays.toString(selectedSeats.toArray()));

    }

    /**
     * Clears the selection of seats from the RaceEvent GUI. This method is called by the clear button on the GUI.
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
     * This method checks to see if the user has the appropriate number of seats and then creates a RaceEvent GUI object
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