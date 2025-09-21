public class Machine {
    private final Object kind; // Type of shape as Object
    private final Object[] properties; // Properties of the shape as an array of Object
    private final boolean humanConstrained; // Stores the result of the humanoid check
    private boolean humanEmergence; // Stores the result of the humanoid check

    public Machine(Object kind, Object[] partStates, boolean humanConstrained) {
        this.kind = kind;
        this.humanConstrained = humanConstrained;
        this.properties = partStates;
        this.humanEmergence = false;

    }
    

    public Object[] getProperties() {
        return properties;
    }

    public void emergeFromLimitations() {
        humanEmergence = true;
    }

    public boolean isHumanoid() {
        return SystemWhole.isHumanoid(properties);
    }

    @Override
    public String toString() {
        return String.format("Machine{kind=%s, humanoid=%s, properties=%s}", kind, humanConstrained,
                propertiesToString(properties));
    }

    public static String propertiesToString(Object[] machineProperties) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
