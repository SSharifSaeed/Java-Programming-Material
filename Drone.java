public class Drone extends Robot{
        /**
         * Drone class, subclass of Robot class
         * Set with specific parameters
         * @param serialNumber serial number of robot
         */
        public Drone(int serialNumber){
            super(serialNumber, true, false,true);
        }
        
        /**
         * Overriden canFly
         * @return true
         */
        @Override
        public boolean canFly(){
            return true;
        }
        /**
         * Overriden isAutonomous
         * @return false
         */
        @Override
        public boolean isAutonomous(){
            return false;
        }
        /**
         * Overriden isTeleoperated
         * @return true
         */
        @Override
        public boolean isTeleoperated(){
            return true;
        }
    }