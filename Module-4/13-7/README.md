<<Interface>>
Colorable
-------------------
+howToColor(): void

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

^Triangle
-side1: double
-side2: double
-side3: double
--------------
+Triangle()
+Triangle(side1: double, side2: double, side3: double)
+Triangle(side1: double, side2: double, side3: double, color: String, filled: boolean)
+getSide1(): double
+setSide1(side1: double): void
+getSide2(): double
+setSide2(side2: double): void
+getSide3(): double
+setSide3(side3: double): void
+toString(): String