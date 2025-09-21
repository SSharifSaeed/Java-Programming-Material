public class ShapeAnalyzer {
    private static final Object EMPTY_PROPERTY = new Object();

    public static Machine analyze(String json) {
        // try this as you start exploring the project: use null for refrence types, and data for primitives.
       return null;
    }

    public static String[][] parseEntries(String flatJson) {
        String repJson = flatJson.replaceAll("[{}]","");
        String[] array = repJson.split(",");
        String[][] results = new String [array.length][2];
        int i;
        
        
        for (i=0; i<array.length; i++){
            String[] keyval = array[i].split(":");
            results[i][0] = keyval[0];
            results[i][1] = keyval[1];    
        }
        return results;
    }

    public static String reifyKind(String[][] entries) {
        String temp = "";
        for (int i = 0; i < entries.length; i++){
            for (int j = 0; j < entries[i].length; j++){
                if (entries[i][j].equals("kind") == true){
                    temp = entries[i][j+1];
                }
            }
        }
        return temp;
    }

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
    }

    public static boolean isDigit(char c) {
        if (Character.isDigit(c)){
            return true;
        }
        else{
            return false;
        }
    }
        

    public static boolean hasNonNumbers(String value) { 
        boolean finalresult;
        int i;
        int periodcounter = 0;
        finalresult = false;

        for (i = 0; i<value.length; i++){
            if (Character.isDigit(value.charAt(i)) == true || value.charAt(i) == '_'){
                finalresult = true; 
            }
        }
        for (i = 0; i<value.length(); i++){
            if (value.charAt(i) == '.'){
                periodcounter++;
            }
        }
        if (periodcounter > 1){
            finalresult = true;
        } 

        return finalresult;
    }   

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
    public void main(String [] args){
        //System.out.println(hasNonNumbers("1232345436546476"));
    }
}
