package died.guia06;

public class NoHayCuposDisponibles extends Exception {
	// Constructor
    public NoHayCuposDisponibles() {}

    // Constructor that accepts a message
    public NoHayCuposDisponibles(String message) {
       super (message);
    }
    
}
