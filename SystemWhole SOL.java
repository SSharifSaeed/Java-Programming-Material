
public class SystemWhole_SOL {
    public static String[] emergences; // To store JSON strings representing emergences
    public static Machine[] parts; // To store Machine objects directly as an array

    public static void main(String[] args) {
        // Sample JSON strings representing different "emergences"
        String[] emergences = {
                "{\"kind\": \"Humanoid\", \"bodyType\": \"physical\", \"faceType\": \"anthropomorphic\", \"reverie\": \"mechatypical\"}",
                "{\"kind\": \"Humanoid\", \"bodyType\": \"physical\", \"faceType\": \"anthropomorphic\", \"reverie\": \"biotypical\"}",
                "{\"kind\": \"Robot\", \"material\": \"metal\", \"function\": \"industrial\"}",
                "{\"kind\": \"Humanoid\", \"bodyType\": \"physical\", \"faceType\": \"anthropomorphic\"}"
        };
    }

//-----------------------------------------------------------------------

    public static void emergencesFromPhenomena(String[] emergences) {
        SystemWhole.emergences = emergences;
        
    }
    
//-----------------------------------------------------------------------

    public static void reifyFrameOfReference() {
        SystemWhole.parts = new Machine[emergences.length];
        int i = 0;
        for (String emergence:emergences){
            SystemWhole.parts[i++] = ShapeAnalyzer.analyze(emergence);
        }
    }

//-----------------------------------------------------------------------

    public static boolean isHumanoid(Object[] machineProperties) {
        boolean physical = false;
        boolean anthropomorphic = false; // sets all initial values to false 
        boolean biotypical = false;
        int i;
        String property; 
        
        for (i=0; i < machineProperties.length; i++){ 
            property = machineProperties[i].toString(); // since toString cant convert the entire object array to string, 
                                                    // we set each key-value dataset to strings individually
            if (property.contains("physical")){ // if string "physical" is in property
                physical = true;
            }
            if (property.contains("anthropomorphic")){ // if string "antrhopomorphic " is in property
                anthropomorphic = true;
            }
            if (property.contains("biotypical")){ // if string "biotypical" is in property
                biotypical = true; 
            }
        }
        if (physical == true && anthropomorphic == true && biotypical == true){ // if meets all requirements for humanoid
            
            return true;

        }
        
        return false; // if not all requirements are met
    }

//-----------------------------------------------------------------------

    // SystemWhole's logic to determine if a Machine is humanoid and count them
    public static int identitySingularityMachines() {
        int totalcount = 0; 

        for (int i=0; i < parts.length; i++){
            Machine machine = parts[i]; // 
            if (machine.isHumanoid() == true){
                totalcount++;
            }
            else {
                totalcount++;
            }
        }
        return totalcount; // adds counters together
    }

//-----------------------------------------------------------------------

    public static Machine[] trackSingularityMachines() {
        int singularity = 0;
        for (int i = 0; i < parts.length; i++){
            Machine machine = parts[i]; // initialize new machine object
            if (machine.isHumanoid() == false){ // if is humanoid
                singularity++; // ipdate counter
            }
        }
        Machine[] singularities = new Machine[singularity]; // initialize singularities object array with size singularity (counter)
        for (int j = 0; j < parts.length; j++){
            Machine machine = parts[j];
            if (machine.isHumanoid() == false){
                singularities[j] = machine; // adds singularity to machine object array
            }
        }
        return singularities; 
    }

    

}