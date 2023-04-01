import java.util.Scanner;

public class Ex471 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int num, num1, n;
        System.out.println("Digite dividendo: ");
        num = scanner.nextInt();
        System.out.println("digite divisor: ");
        num1 = scanner.nextInt();
        while (num1 > num) {
            System.out.println("INVALIDO. digite numero menor do o dividendo: ");
            num1 = scanner.nextInt();
        }
        n = divisor(num, num1);
        if(n==0) {
            System.out.println("Nenhuma vez");
        } else {
            System.out.println("Numero de vezes: " + n);

        }
    }

    private static int divisor(int x,int y) {
        int r, n1;
        n1 = 0;
        r = x%y;
        while(r==0) {
            n1++;
            x = x/y;
            r = x%y;
        }
        return n1;
    }
}
