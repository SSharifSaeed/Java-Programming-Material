public class Replicant extends MovieRobot{
    /**
     * Replicant subclass of MovieRobot
     * Replicant object creation with serial number, flies, autonomous, and teleoperated
     * Calls super constructor with parameters and catchphrase
     * @param serialNumber serial number of robot
     * @param flies if robot can fly
     * @param autonomous if robot is autonomous
     * @param teleoperated if robot is teleoperated
     */
    public Replicant(int serialNumber,boolean flies, boolean autonomous, boolean teleoperated){
        
        super(serialNumber, flies, autonomous, teleoperated, "like tears in rain...");
    }
    /**
     * canFight capability
     * @return true
     */
    public boolean canFight(){
        return true;
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