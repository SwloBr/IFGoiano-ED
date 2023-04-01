import java.util.Scanner;

public class Ex460 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.print("\n\nDigite numero: ");
            int x = scanner.nextInt();
            System.out.printf("dobro: %d", dob(x));

        }

    }

    private static int dob(int x) {
        return x*2;
    }
}
