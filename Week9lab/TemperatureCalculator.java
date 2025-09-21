public class TemperatureCalculator {
    public int [] temperatures = {
        15, 22, 18, 25, 30, 
        19, 24, 20, 27, 21, 
        16, 29, 23, 17, 20, 
        28, 31, 26, 24, 19, 
        22, 27, 18, 16, 21, 
        29, 23, 20, 25, 28
    };
    public TemperatureCalculator()
    {}
    /**
     * 
     * @param day the day that we are checking
     * @return
     * getTempByDay checks the temperature of the day using the integer value of day provided. 
     * we used a try catch to make sure that the day entered is not outside of the index.
     */
    public int getTempByDay(int day){
        int currTemp = 0;
        
        try{
            currTemp = temperatures[day -1];
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid day");
            return -1;
        }
        

        return currTemp;
    }
    /**
     * 
     * @param firstDay is the first day the user chooses
     * @param lastDay is the last day the user chooses
     * @return returns the value of the average temperature 
     * @throws AverageException throws an exception if the first day or day has a invalid range
     * @throws IllegalRangeException throws an exception if the first day is larger than the last day.
     */
    public int tempAvg(int firstDay, int lastDay) throws AverageException, IllegalRangeException {

        // throw AverageException for invalid range of firstDay and lastDay
        if(firstDay < 1 || lastDay > 30) throw new AverageException("First day and last day must be in the range 1-30");
        // throw IllegalRangeException if firstDay is greater than lastDay
        if( firstDay >= lastDay) throw new IllegalRangeException("Last day must be greater than First day");
        

        int tempSum = 0;
        int total = 0;
        int average = 0;

        // calculate average temperature between firstDay and lastDay
        for (int i = firstDay - 1; i <=lastDay-1; i++){
            tempSum += temperatures[i];
            total++;
        }
        average = tempSum/total;
        return average;
    }
}