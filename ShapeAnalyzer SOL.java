public class ShapeAnalyzer {
    private static final Object EMPTY_PROPERTY = new Object();

    public static void main(String[] args) {
        
    }

//-----------------------------------------------------------------------

    public static Machine analyze(String json) {
        String[][] entries = parseEntries(json);
        Object[] properties = reifyProperties(entries);
        String kindProperty = reifyKind(entries);
        boolean isHumanoid = SystemWhole.isHumanoid(properties);
        Machine machine = new Machine(kindProperty, properties, isHumanoid);
        return machine;
    }

//-----------------------------------------------------------------------

    public static String[][] parseEntries(String flatJson) {
        String fixedJson = flatJson.replaceAll("[{}]", ""); // gets rid of curly brackets
        String[] splitJson = fixedJson.split(","); // splits string by commas
        String [][] results = new String[splitJson.length][2]; // initializes results with a 2d array with length of splitJson rows, and 2 colums  
        int i; // initializes i
        int n; // initialzes n 
        
        for (i = 0; i < splitJson.length; i++){ 
            String[] pair = splitJson[i].split(":"); // initializes 1d array with key-value pairs
            results[i][0] = pair[0]; // adds 0th index to results[0]
            results[i][1] = pair[1]; // add 1st index to results[1]
            
        }
        return results; // returns 2d results array
    }
    
//-----------------------------------------------------------------------

    public static String reifyKind(String[][] entries) {
        String reifyString = ""; // initiallizes reifyString
        for (int i = 0; i < entries.length; i++){ // double for loop to iterate thru 2D array
            for (int k = 0; k < entries[i].length; k++){
                if (entries[i][k].contains("kind")){ // if entries(at index) contain "kind" keyword
                    reifyString = entries[i][k + 1]; // sets reifyString with the property of kind
                }
            }
        }
        return reifyString; 
    }

//-----------------------------------------------------------------------

    public static Object[] reifyProperties(String[][] entries) {
        String[][] temp = new String[entries.length][2];
        Object[] finalOb;
        for (int i = 0; i < entries.length; i++) {
            if (entries[i][0].equals("kind") == false){
                temp[i][0] = entries[i][0];
                temp[i][1] = entries[i][1];
            }
        }
        finalOb = new Object[temp.length];
        for (int j = 0; j < temp.length; j++){
            Object [] partsarray = PartState(temp[j][0],temp[j][1]);
            finalOb[j] = partsarray;
        }
        return finalOb;
        

        String[][] entriesCopy = new String[entries.length][2]; // makes copy of entries 
        Object[] properties; // initializes new object array
        int i; // initializes i 
        int propertiesLenCounter = 0; // initializes counter for copy array size, to exclude "kind"
    

        for (i = 0; i < entries.length; i++){
            String key = entries[i][0]; // initializes key data
            String value = entries[i][1]; // initializes value data
            
            if ((key.equals("kind")) == false){ // if key isnt "kind" 
            // updates array copy with all the key-value pairs that dont include "kind"
                entriesCopy[propertiesLenCounter][0] = key;  
                entriesCopy[propertiesLenCounter][1] = value;
                propertiesLenCounter = propertiesLenCounter + 1; // increments counter for properties length
            }
            }
        properties = new Object[propertiesLenCounter]; // creates new object array with the size of new data minus the "kind" attribute
        
        for (i = 0; i < properties.length;i++){ // iterates through properties
        // sets final key-value data from entriesCopy and calls puts them in partStateInit object while calling PartState
            String key = entriesCopy[i][0]; 
            String value = entriesCopy[i][1];
            Object partStateInit = new PartState(key, value);
            properties[i] = partStateInit; // assigns PartState data into properties array object 
        }
        return properties; 
    }

//-----------------------------------------------------------------------

    public static boolean isDigit(char c) {
        if (Character.isDigit(c)){
            return true;
        }
        else{
            return false;
        }
    }

//-----------------------------------------------------------------------

    public static boolean hasNonNumbers(String value) {
      
        boolean hasNonNumbersBool = false;
        int periodCounter = 0;
        for (int i=0;i<value.length();i++){ 

            if (Character.isDigit(value.charAt(i)) == false && value.charAt(i) != '_' && value.charAt(i) != '.'){
                hasNonNumbersBool = true; // marks anything that isnt a digit, underscore, or period
            }
        }
        for (int i=0;i<value.length();i++){ // counts periods in string
            if (value.charAt(i) == '.'){
                periodCounter = periodCounter + 1;
            }
        }
        if (periodCounter > 1){ // if more than 1 period occur in string
          hasNonNumbersBool = true;
        }

        return hasNonNumbersBool;
    }



//-----------------------------------------------------------------------

    public static Object inferObject(String value) {
        if (value.isEmpty()){ // if value is nothing
            return EMPTY_PROPERTY;
        }
        else if (value.contains(".")){ // if has non numbers == true
            return EMPTY_PROPERTY;
        }
        if (hasNonNumbers(value)){ // if contains period
            return Double.parseDouble(value); // parses value to double
        }
        else{
            return Integer.parseInt(value); // parses value to integer
        }
    }
}


