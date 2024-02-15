
public enum Status {
	
		MARRIED("Married"),
        SINGLE("Single"),
        DIVORCED("Divorced"),
        WIDOWED("Widowed");

        private final String status;

        // Constructor for enum to set the string value
        Status(String status) {
            this.status = status;
        }

        // Getter for the string value
        public String getStatus() {
            return this.status;
        }
        
        
        public static Status fromString(String text) {
            for (Status b : Status.values()) {
                if (b.status.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("No constant with text " + text + " found");
        }
        
        @Override
        public String toString() {
        	return ("("+ status+"): ");
        }
        
        
        public boolean compare(Status status) {
        	return (this.getStatus().equals(status.getStatus()));
        }
    }


