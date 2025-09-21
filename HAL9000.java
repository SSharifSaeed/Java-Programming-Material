public class HAL9000 extends MovieRobot{
    /**
     * HAL9000 subclass of MovieRobot
     * HAL9000 Object creation with serialNumber, autonomous, and teleoperated
     * Calls super constructor with those parameters and catchphrase
     * @param serialNumber serial number of robot
     * @param autonomous if robot is autonomous
     * @param teleoperated if robot is teleoperated
     */
    public HAL9000(int serialNumber, boolean autonomous, boolean teleoperated){
        super(serialNumber, true, autonomous, teleoperated, "I can't let you do that Dave.");
    }
    /**
         * Overriden canSpeak
         * @return true
         */
    @Override
    public boolean canSpeak(){
        return true;
    }
}