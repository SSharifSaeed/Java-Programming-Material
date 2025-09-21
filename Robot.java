/*
* Names: Stephen Doudaklian, Sharif Saeed
* netID: sdoudakl , ssaeed24
* G#: 01422164 , 01314603
* Lecture section: 004
* Lab section: 209
*/

public class Robot{
    private int serialNumber;
    private boolean flies;
    private boolean autonomous; 
    private boolean teleoperated;
    public static void main(String[] args){
        
    }
    /**
     * @param flies if robot can fly
     * @param autonomous if robot is autonomous
     * @param teleoperated if robot is teleoperated
     * @param serialNumber the robots serial number
     */
    public Robot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
        this.flies = flies;
        this.autonomous = autonomous;
        this.teleoperated = teleoperated;
        this.serialNumber = serialNumber;
    }
    /**
     * SETS CAPABILITIES OF ROBOT
     * @param flies if robot can fly
     * @param autonomous if robot is autonomous
     * @param teleoperated if robot is teleoperated
     */
    public void setCapabilities(boolean flies, boolean autonomous, boolean teleoperated){
        this.flies = flies;
        this.autonomous = autonomous;
        this.teleoperated = teleoperated;
        
    }
    
    /**
     * @return boolean flies
     */
    public boolean canFly(){
        return flies;
    }
    /**
     * @return boolean autonomous
     */
    public boolean isAutonomous(){
        return autonomous;
    }
    /**
     * @return boolean teleoperated
     */
    public boolean isTeleoperated(){
        return teleoperated;
    }
    /**
     * @return creates a string based on the capabilities of the robot
     */
    public String getCapabilities(){
        String capabilities = "";
        if (canFly() == true){
            capabilities = capabilities + "canFly ";
        }
        if (isAutonomous() == true){
            capabilities = capabilities + "isAutonomous ";
        }
        if (isTeleoperated() == true){
            capabilities = capabilities + "isTeleoperated";
        }
        if (capabilities == ""){
            return "";
        }
        else{
            return capabilities;
        }
    }
    /**
     * @return serial number
     */
    public int getSerialNumber(){
        return serialNumber;
    }
    /**
     * @return ID: serialNumber, Capabilites: capabilites
     */
    @Override
    public String toString(){
        return "ID: " + serialNumber + ", Capabilities: " + getCapabilities();
    }

}





