public class MyInteger {
    private int value;

    MyInteger(int value) {
        this.value = value;
    }

    // get value
    public int getValue() {
        return value;
    }

    // even, odd, prime methods
    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    public boolean isPrime() {
        for(int i = 2; i <= value / i; i++){
            if(value % i == 0) {
                return false;
            }
        }
        return value > 1;
    }

    // static even, odd, prime methods
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }

    public static boolean isPrime(int value) {
        for(int i = 2; i <= value / i; i++){
            if(value % i == 0) {
                return false;
            }
        }
        return value > 1;
    }

    // static methods object is even, odd, prime
    public static boolean isEven(MyInteger myInt) {
        return myInt.getValue() % 2 == 0;
    }

    public static boolean isOdd(MyInteger myInt) {
        return myInt.getValue() % 2 != 0;
    }

    public static boolean isPrime(MyInteger myInt) {
        for(int i = 2; i <= myInt.getValue() / i; i++){
            if(myInt.getValue() % i == 0) {
                return false;
            }
        }
        return myInt.getValue() > 1;
    }

    // methods to check for equality
    public boolean equals(int value) {
        return this.value == value;
    }

    public boolean equals(MyInteger myInt) {
        return value == myInt.getValue();
    }

    // parse methods
    public static int parseInt(char[] chars) {
        int number = Integer.parseInt(new String(chars));

        return number;
    }

    public static int parseInt(String string) {
        int number = Integer.parseInt(string);

        return number;
    }
}
