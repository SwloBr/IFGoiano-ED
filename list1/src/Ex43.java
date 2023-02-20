import java.util.Scanner;

public class Ex43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float num, logaritmo;
        System.out.print("\nentre com o logaritmando: ");
        num = scanner.nextFloat();
        logaritmo = (float) (Math.log(num) / Math.log(10));
        System.out.print("\n logaritmo: " + logaritmo);
        System.out.print("\n");
    }
}
