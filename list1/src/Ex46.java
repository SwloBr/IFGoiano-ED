import java.util.Scanner;

public class Ex46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float saldo, nsaldo;
        System.out.print("\ndigite saldo: ");
        saldo = scanner.nextFloat();
        nsaldo = (float)(saldo * 1.01);
        System.out.print("\nnovo saldo: " + nsaldo);
        System.out.print("\n");
    }
}
