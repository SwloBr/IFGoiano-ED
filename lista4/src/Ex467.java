import java.util.Scanner;

public class Ex467 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double z, l, b;
        int c;
        for (c = 1; c <=3 ; c++) {
            System.out.println("digite logaritmando maior do que 0: ");
            l = scanner.nextDouble();
            while(l <= 0) {
                System.out.println("inválido.Digite logaritmando maior do que 0: ");
                l = scanner.nextDouble();
            }
            System.out.println("digite base maior que 0 e diferente de 1: ");
            b = scanner.nextDouble();
            while (b<0 || b==1) {
                System.out.println("ivalido. digite base maior que 0 e diferente de 1: ");
                b = scanner.nextDouble();
            }
            System.out.println("logaritmo e " + loga(l, b));
            z = loga(l, b);
            System.out.println("z = " + z);

        }

    }
    private static double loga(double base, double expo) {
        return Math.log(base)/Math.log(expo);
    }
}
