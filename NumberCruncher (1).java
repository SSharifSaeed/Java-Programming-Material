public class NumberCruncher {
	/**
	*
	* This method returns true if
	*
	*
	*/
	public static boolean isCoprime(int input1, int input2) {
		while (input2 != 0) { //This loops through the function until input 2 = 0
			int i = input2;
			input2 = input1 % input2; 
			input1 = i;
		}
		if (input1 == 1) { //This checks the value of input1 to see whether it is 1 or not. From there it decides if it is prime or not.
			return true;
		} else {
			return false;
		}
	}

	/**
	*
	* This method returns true if
	*
	*
	*/
	public static boolean isFibonacciPrime(long input) {
		int f1 = 1;
		int f2 = 1;
		int f3 = 0;
		int first = 0; // prime checker
		int second = 0; // fib checker
		
		if (input <= 1) { // 0 or 1 are not prime numbers 
			return false;
		}
		for (int i = 2; i <= input / 2; i++){ // starts from 2 cuz 2 is a prime number
			if (input % i == 0){
				return false;
			}
		}
		first = 1; // if code reaches here, ticks prime requirement

		while (f3 < input){
			f3 = f2 + f1;
			f1 = f2;
			f2 = f3;
		}
		if (f3 == input){
			second = 1; // ticks fib requirement
		}
		if (first == second){ // makes sure both requirements are met
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 *
	 * This method returns the number of steps it takes to get to 1
	 * following the collatz game rules starting at the input
	 */
	public static int countCollatzSteps(int input){
		int val;
		int countTime;
		countTime = 0;
		val = input;
		while(val != 1) {  //condition that iterates as long as val is not 1
			if (input % 2 != 0) {  //checks to see if the number is even or odd
				val /= 2; //divides 2 for even numbers 
				countTime += 1; 
			} else {
				val = val * 3 + 1; //multiplies by 3 and adds one for odd numbers
				countTime += 1;
			}
		}
		return countTime;
	}

	/**
	 *
	 * This method marks off all the spots in the input array
	 * corresponding to composite numbers, leaving only the
	 * prime numbers as true.
	 */
	public static void sieveOfEratosthenes(boolean[] array){
		for (int n = 0; n <= array.length; n++){ 
			if (n <= 1){ // 0 and 1 are not prime numbers
				array[n] = false; // set those indexes to false
			}
		}
		for (int i = 2; i <= array.length-1; i++){ 
			
			if (i == 2){ // 2 is a exception prime number
				array[i] = true;
			}
			else if (i % 2 ==0){ // if i % 2 -> not prime number
				array[i] = false; // set index to false
			}
			else{
				array[i] = true; // everything that makes it to this point is a prime number
			}
			}
	}

	/**
	 * Modifies a two-dimensional array in-place. Every occurrence of item
	 * is replaced by replacement.
	 */
	public static void replaceItem(int[][] array, int item, int[] replacement){
		for (i = 0; i < array.length; i++) {
			for (j = 0; j < array.length; j++){
				if (array[i][j] == item) {
					array[i][j] = replacement;
				}
			}
			
		}
	}

	/**
	 *
	 * Main method. Is not tested by the tester, create your own tests here!
	 */
	public static void main(String[] args){
		//pass
	}

}
