package project1CS351;

public enum Status {
	
		MARRIED("married"),
        SINGLE("single"),
        DIVORCED("divorced"),
        WIDOWED("widowed");

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
}


