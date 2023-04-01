import java.util.Scanner;

public class Ex465 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int num1, num2;
        System.out.println("Digite numero 1");
        num1 = scanner.nextInt();
        System.out.println("Digite numero 1");
        num2 = scanner.nextInt();
        verifica(num1, num2);

        
    }

    private static void verifica(int n1, int n2) {
        if(n1 < n2) {
            System.out.println(n2);
        } else {
            System.out.println(n1);
        }
    }
}
