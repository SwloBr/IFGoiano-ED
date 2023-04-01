import java.util.Scanner;

public class Ex462 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        double n1, n2, n3, m;

        System.out.print("\nDigite a nota 1: ");
        n1 = scanner.nextInt();
        System.out.print("\nDigite a nota 2: ");
        n2 = scanner.nextInt();
        System.out.print("\nDigite a nota 3: ");
        n3 = scanner.nextInt();
        System.out.print("\nmedia aritmetica é: " + media(n1,n2,n3));
        m = media(n1,n2,n3);
        System.out.println("media armazenada em cariavel = " + m);


    }

    private static double media(double x,double y,double z) {

        return (x+y+z)/3;
    }
}
