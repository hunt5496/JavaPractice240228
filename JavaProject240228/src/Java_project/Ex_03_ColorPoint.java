package Java_project;

public class Ex_03_ColorPoint extends Ex_03_Point {
    private String color;

    public Ex_03_ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public void setPoint(int x, int y) {
        move(x, y);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void show() {
        System.out.println(color + "색으로 " + super.toString());
    }

    public static void main(String[] args) {
        Ex_03_ColorPoint cp = new Ex_03_ColorPoint(5, 5, "YELLOW");
        cp.setPoint(10, 20);
        cp.setColor("GREEN");
        cp.show();
    }
}