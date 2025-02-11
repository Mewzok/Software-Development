GeometricObject
-color: String
-filled: boolean
----------------
#GeometricObject()
#GeometricObject(color: String, filled: boolean)
+getColor(): String
+setColor(color: String): void
+isFilled(): boolean
+setFilled(filled: boolean): void
+toString(): String
+getArea(): double <<abstract>>
+getPerimeter(): double <<abstract>>

<<interface>>
Comparable<Octagon>
-------------------
+compareTo(o: Octagon): int

<<interface>>
Cloneable
---------
+clone(): Object

^Octagon
-sideLength: double
-------------------
+Octagon()
+Octagon(sideLength: double)
+getSideLength(): double
+setSideLength(sideLength: double): void
+compareTo(o: Octagon): int
+clone(): Object