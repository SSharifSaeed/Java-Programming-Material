public abstract class MovieRobot extends Robot{
        private String catchphrase;

        /**
         * Default constructor
         * @param flies if robot can fly
         * @param autonomous if robot is autonomous
         * @param teleoperated if robot is teleoperated
         * @param serialNumber the robots serial number
         * @param catchphrase catchphrase of robot 
         */
        public MovieRobot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated, String catchphrase){
            super(serialNumber, flies, autonomous, teleoperated);
        
            this.catchphrase = catchphrase;
        }
        /**
         * Overloaded constructor, replaces catchphrase slot with null if empty
         * @param flies if robot can fly
         * @param autonomous if robot is autonomous
         * @param teleoperated if robot is teleoperated
         * @param serialNumber the robots serial number
         */
        public MovieRobot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
            this(serialNumber, flies, autonomous, teleoperated, null);

        }
        /**
         * absract canSpeak method (will be overridden in subclasses)
         */
        public abstract boolean canSpeak();
        
        /**
         * Overriden getCapabilites method
         * @return capabilites + " can also speak." if robot can speak
         * @return capabilities if robot cannot speak
         */
        @Override
        public String getCapabilities(){
            if (canSpeak() == true){
                return super.getCapabilities() + " can also speak.";
            }
            else{
                return super.getCapabilities();
            }
        }
        /**
         * Overriden toString method
         * @return Robot.toString + catchphrase if can speak
         * @return Robot.toString if cannot speak
         */
        @Override
        public String toString(){
            if (canSpeak() == true){
                return super.toString() + " " + "\"" + catchphrase + "\"";
            }
            else{
                return super.toString();
            }
        }
    }