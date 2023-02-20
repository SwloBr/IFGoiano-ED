import java.util.Scanner;

public class Ex42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float angulo, rang;
        System.out.print("\ndigite um angulo em graus: ");
        angulo = scanner.nextFloat();
        rang = (float)(angulo*Math.PI)/180;
        System.out.print("\nseno: " + Math.sin(rang));
        System.out.print("\nco-seno: " + Math.cos(rang));
        System.out.print("\ntangente: " + Math.tan(rang));
        System.out.print("\nco-secante: " + (1/Math.sin(rang)));
        System.out.print("\nsecante: " + (1/Math.cos(rang)));
        System.out.print("\ncotangente: " + (1/Math.tan(rang)));
        System.out.print("\n");
    }
}
