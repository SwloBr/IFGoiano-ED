import java.util.Scanner;

public class Ex463 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double ang, r;
        System.out.println("Digite angulo em graus: ");
        ang = scanner.nextDouble();
        r = radiano(ang);
        System.out.println("graus" + ang + " radianos: " + r);



    }
    private static double radiano(double gang) {

        return (gang * Math.PI)/180;

    }
}
