package java_project_240321;

import java.text.DecimalFormat;
import java.util.Scanner;

class Circle {
    private int radius;
    
    public Circle(int radius) { 
        this.radius = radius;
    }
    
    public double getArea() { 
        return radius * radius * 3.14; 
    }
}

public class CircleArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] radii = new int[4];
        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + " 반지름 >> ");
            radii[i] = scanner.nextInt();
        }
        
        Circle[] circles = new Circle[4];

        for (int i = 0; i < 4; i++) {
            circles[i] = new Circle(radii[i]);
        }

        double totalArea = 0;
        for (Circle circle : circles) {
            totalArea += circle.getArea();
        }

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("저장하였습니다...");
        System.out.println("원의 면적 전체 합은 " + df.format(totalArea));
    }
}


