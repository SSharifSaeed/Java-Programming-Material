import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
public class TemperatureCalculatorTest {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("TemperatureCalculatorTest");
  
  /**
   * 
   * Tester for getTemp by Day
   */
  @Test
  public void getTempByDayTest() {
    TemperatureCalculator temperatureCalculator = new TemperatureCalculator();
    int inputValue = 2;
    int expectedValue = 22;
    String errorMessageString = String.format("Temperature(%d) incorrect",expectedValue);
    assertEquals(errorMessageString, expectedValue, temperatureCalculator.getTempByDay(inputValue));
}
  /**
   * this is a test for the gettemperature average exceptions
   * @param firstDay first day to take average
   * @param lastDay last day to take average
   */
  public void getTemperatureAverageExceptionTest(int firstDay, int lastDay) {
    try{
      TemperatureCalculator tempCalc = new TemperatureCalculator();
      int output = tempCalc.tempAvg(firstDay, lastDay);
    }
    catch(AverageException ex) {
		assertEquals("First day and last day must be in the range 1-30");
    System.out.println(-1);
    } catch (IllegalRangeException e) {
		assertEquals("Last day must be greater than First day");
    System.out.println(-2);
    }
  }
}

