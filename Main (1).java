class Main {
    
    public static long fibonacci(int num) {
        if (num < 0){
            throw new IllegalArgumentException();
        }

        if num == 0 || num == 1{
            return num;
        } else {
            return fibonacci((num-1)+fibonacci(num-2))
        }

    }
    
    public static long factorial(int num) {
        if (num < 0){
            throw new IllegalArgumentException();
        }

        if (num == 0 || num == 1){
            return 1;
        }else {
            return num * factorial(num-1)
        }
    }

    public static void main(String[] args) {
        // Part 1:
        System.out.println("Part 1:");
        System.out.println("The first number in fibonacci sequence is: " + fibonacci(0));
        System.out.println("The 8th number in fibonacci sequence is: " + fibonacci(7));
        System.out.println("The 13th number in fibonacci sequence is: "+ fibonacci(12));
        System.out.println("The 21st number in fibonacci sequence is: "+ fibonacci(20));

        // Part 2:
        System.out.println("Part 2:");
        System.out.println("numbers in factorial sequence is: " + factorial(0));
        System.out.println("numbers in factorial sequence is: " + factorial(5));
        System.out.println("numbers in factorial sequence is: "+ factorial(15));
        System.out.println("numbers in factorial sequence is: "+ factorial(20));
    }

}