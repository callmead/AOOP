/**
 * Interface for all types of events.
 */
public interface EventLayout{

    void buildLayout();

    void reserveSeat(String seatLabel);

    void clearSelection();

    void finalizeSelection(String userType);
}