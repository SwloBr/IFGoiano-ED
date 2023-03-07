import java.util.Scanner;

public class Ex161 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c;
        double num;
        for (c = 1; c <= 5 ; c++) {

            System.out.print("\nnumero: ");
            num = scanner.nextDouble();
            System.out.print("quadrado: " + Math.pow(num, 2));
        }
        System.out.print("\n");

    }
}
