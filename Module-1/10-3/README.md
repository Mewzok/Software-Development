UML
MyInteger
-value: int
-----------
+MyInteger(value: int)
+getValue(): int
+isEven(): Boolean
+isOdd(): Boolean
+isPrime(): Boolean
+isEven(value: int): Boolean <<static>>
+isOdd(value: int): Boolean <<static>>
+isPrime(value: int): Boolean <<static>>
+isEven(myInt: MyInteger): Boolean <<static>>
+isOdd(myInt: MyInteger): Boolean <<static>>
+isPrime(myInt: MyInteger): Boolean <<static>>
+equals(value: int): Boolean
+equals(myInt: MyInteger): Boolean
+parseInt(chars: char[]): int <<static>>
+parseInt(string: String): int <<static>>