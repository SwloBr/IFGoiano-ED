import java.util.Scanner;

public class Ex480 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int n, x;
        System.out.println("digite numero: ");
        n = scanner.nextInt();
        x = reverso(n);
        System.out.println(n + " - " + x);
        if(x==n) {
            System.out.println("e um numero capicua");
        } else {
            System.out.println("Nao e um numero capocua");
        }

    }
    private static int reverso(int num) {
        int soma, r;
        soma = 0;
        while (num < 0) {
            r = num%10;
            soma = soma *10 +r;
            num = num/10;
        }
        return soma;
    }
}
