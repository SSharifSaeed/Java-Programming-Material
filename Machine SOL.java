public class Machine {
    private final Object kind; // Type of shape as Object
    private final Object[] properties; // Properties of the shape as an array of Object
    private final boolean humanConstrained; // Stores the result of the humanoid check
    private boolean humanEmergence; // Stores the result of the humanoid check

    public static void main(String[] args){
        
    }
    
    public Machine(Object kind, Object[] partStates, boolean humanConstrained) {
        this.kind = kind;
        this.properties = partStates;
        this.humanConstrained = humanConstrained;
        this.humanEmergence = false;
    }

    public Object[] getProperties() {
        return properties; // returns properties
    }

    public void emergeFromLimitations() {
        humanEmergence = true; // changes from false to true
    }

    public static boolean isHumanoid() {
        return SystemWhole.isHumanoid(properties);
    }

    @Override
    public String toString() { // DO NOT EDIT (FULLY IMPLEMENTED ALREADY)
        return String.format("Machine{kind=%s, humanoid=%s, properties=%s}", kind, humanConstrained,
                propertiesToString(properties));
    }

    public static String propertiesToString(Object[] machineProperties) {
        String processedString = ""; // empty string
        for (int i = 0; i < machineProperties.length; i++){
            processedString = processedString + machineProperties[i].toString(); // creates each property to string and appends it to propertiesStrig
            processedString = processedString.replaceAll("PartState", "").replaceAll("[{}]", "");
            if (i < machineProperties.length - 1){
                processedString = processedString + ", "; // adds comma between each dataset skipping last one
            }
        }
        return processedString;
    }

}
