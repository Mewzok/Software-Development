public class Exercise13_7 {
    public static void main(String[] args) {
        // create and initialize 5 triangles
        GeometricObject[] triangles = new Triangle[5];

        triangles[0] = new Triangle(1.1, 1.2, 1.3, "white", true);
        triangles[1] = new Triangle(2.9, 2.8, 2.7, "green", false);
        triangles[2] = new Triangle(3.4, 3.5, 3.6, "red", false);
        triangles[3] = new Triangle(4.1, 4.2, 4.3, "blue", false);
        triangles[4] = new Triangle(5.9, 5.8, 5.7, "black", true);


        // display area and howToColor
        for(int i = 0; i < triangles.length; i++) {
            System.out.println("Area: " + triangles[i].getArea());
            if(triangles[i] instanceof Colorable) {
                System.out.println("How to color triangle " + (i + 1) + ": ");
                triangles[i].howToColor();
            }
            System.out.println();
        }
    }
}
