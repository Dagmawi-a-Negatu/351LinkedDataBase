
public enum Label {
    MOM("Mom"),
    DAD("Dad"),
    BROTHER("Brother"),
    SISTER("Sister"),
    FRIEND("Friend"), 
    HUSBAND("Husband"),
    WIFE("Wife");

    private final String label;

    // Constructor for enum to set the string value
    Label(String label) {
        this.label = label;
    }

    // Getter for the string value
    public String getLabel() {
        return this.label;
    }
    
    
    public static Label fromString(String text) {
        for (Label b : Label.values()) {
            if (b.label.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
    
    public boolean compare(Label status) {
    	return (this.getLabel().equals(status.getLabel()));
    }
    
    
}
