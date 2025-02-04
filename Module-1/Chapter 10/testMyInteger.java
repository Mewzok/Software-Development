public class testMyInteger {
    public static void main(String[] args) {
        MyInteger myInt1 = new MyInteger(7);
        MyInteger myInt2 = new MyInteger(151);
        char[] numberChars = {'1', '6', '0'};

        // check for is myInt1 is even, odd and prime
        System.out.println("myInt1 is even: " + myInt1.isEven());
        System.out.println("myInt1 is odd: " + myInt1.isOdd());
        System.out.println("myInt1 is prime: " + myInt1.isPrime());

        // check static methods for if 7 is even, odd and prime
        System.out.println("7 is even: " + MyInteger.isEven(7));
        System.out.println("7 is odd: " + MyInteger.isOdd(7));
        System.out.println("7 is prime: " + MyInteger.isPrime(7));

        // check static methods for if object is even, odd and prime
        System.out.println("myInt2 is even: " + MyInteger.isEven(myInt2));
        System.out.println("myInt2 is odd: " + MyInteger.isOdd(myInt2));
        System.out.println("myInt2 is prime: " + MyInteger.isPrime(myInt2));

        // check for equality
        System.out.println("myInt1 equals 7: " + myInt1.equals(7));
        System.out.println("myInt1 equals myInt2: " + myInt1.equals(myInt2));

        // parse character array and String
        System.out.println("Characters parsed to int: " + MyInteger.parseInt(numberChars) + 1);
        System.out.println("String parsed to int: " + MyInteger.parseInt("009"));
    }
}
