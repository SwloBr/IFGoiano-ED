import java.util.Scanner;

public class Ex464 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double ang, g;
        System.out.println("Digite angulo em radianos: ");
        ang = scanner.nextDouble();
        g = graus(ang);
        System.out.println("radianos" + ang + " graus: " + g);



    }
    private static double graus(double gang) {

        return (gang * 180)/Math.PI;

    }
}
