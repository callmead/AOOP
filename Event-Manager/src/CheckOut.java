import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

/**
 * A checkout user interface that allows users to see the content of their seat selection purchase.
 *
 * @author Alex Balderrama
 * @since 03/08/2017
 * @version 1.0
 */

public class CheckOut extends JFrame {

    // JButtons
    JButton reset = new JButton("Start Over");
    JButton changes = new JButton("Make Changes");
    JButton checkout = new JButton("Checkout");

    JLabel totalLabel = new JLabel();
    JLabel seatsLabel = new JLabel();

    JPanel purchaseInfo = new JPanel();
    JPanel choices = new JPanel();

    ImageIcon checkMark = new ImageIcon("GreenMark.png");

    /**
     * Constructor that on initialization, loads all the content of the GUI so that the User can view their checkout
     * items.
     *
     * @param total the total price that the user will be charged
     * @param userType the user's type
     * @param selectedSeats an ArrayList of the selected seats
     */

    public CheckOut(double total, String userType, Set<String> selectedSeats) {

        /**Frame Initialization**/
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(650, 200);
        this.setLocationRelativeTo(null);
        this.setTitle("Event Checkout");
        this.setResizable(false);
        setVisible(true);

        /**Buttons Initialization**/
        reset.setFocusable(false);
        changes.setFocusable(false);
        checkout.setForeground(Color.RED);
        checkout.setOpaque(true);

        changes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent c) {
                dispose();
            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent c) {
                dispose();
                SeatingSystem s = new SeatingSystem();
                s.setVisible(true);;
            }
        });

        checkout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent c) {
                JOptionPane.showMessageDialog(null, "Your tickets have been purchased! See you soon!", "Payment Complete", JOptionPane.INFORMATION_MESSAGE, checkMark);;
                System.exit(0);
            }
        });

        /**Set JLabel Text**/
        if (userType.equals("Bulk") || userType.equals("VIP")){
            if (userType.equals("Bulk")){
                total = total - (total*0.10);
                totalLabel.setText("Total Amount Due: $" + total + " (Bulk Discount: 10% off!)");
            } else if (userType.equals("VIP")){
                total = total - (total*0.20);
                totalLabel.setText("Total Amount Due: $"+total + " (VIP Discount: 20% off!)");
            }
        } else {
            totalLabel.setText("Total Amount Due: $" + total);
        }

        seatsLabel.setText("Seats Selected: " + Arrays.toString(selectedSeats.toArray()));

        /**JPanel Initialization**/
        purchaseInfo.setLayout(new GridLayout(1, 2));
        purchaseInfo.setSize(600, 100);
        choices.setSize(600, 100);
        purchaseInfo.setBorder(BorderFactory.createLineBorder(Color.black));
        purchaseInfo.add(totalLabel);
        purchaseInfo.add(seatsLabel);
        choices.add(reset);
        choices.add(changes);
        choices.add(checkout);

        this.add(purchaseInfo);
        this.add(choices, BorderLayout.SOUTH);

    }
}