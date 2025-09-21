public class TeeOneThousand extends MovieRobot{
    /**
     * TeeOneThousand subclass of MovieRobot
     * TeeOneThousand object creation with serial number as parameter
     * Calls overloaded constructor from movierobot with arguments
     * @param serialNumber serial number of robot
     */
    public TeeOneThousand(int serialNumber){
        super(serialNumber, false,false,false );
    }
    /**
     * canClean method
     * @return true
     */
    public boolean canClean(){
        return true;
    }
    /**
     * Overriden canSpeak
     * @return false
     */
    @Override
    public boolean canSpeak(){
        return false;
    }
}