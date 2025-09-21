public class Vacuum extends Robot{
        
        /**
         * Vacuum subclass of Robot
         * @param serialNumber serial number of robot
         */
        public Vacuum(int serialNumber){
            super(serialNumber, false,true,false);
        }
        /**
         * canClean method
         * @return true
         */
        public boolean canClean(){
            return true;
        }
        /**
         * Overridden getCapabilites
         * @return capabilites with addition canClean capability
         */
        @Override
        public String getCapabilities(){
            return super.getCapabilities() + " " + canClean();
        }
        /**
         * Overridden canFly method
         * @return true
         */
        @Override
        public boolean canFly(){
            return true;
        }
        /**
         * Overridden isAutonomous method
         * @return false
         */
        @Override
        public boolean isAutonomous(){
            return false;
        }
        /**
         * Overridden isTeleoperated method
         * @return true
         */
        @Override
        public boolean isTeleoperated(){
            return true;
        }
    }