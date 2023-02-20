import java.util.Scanner;

public class Ex44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float num, base, logaritmo;
        System.out.print("\nentre com o logaritmando: ");
        num = scanner.nextFloat();
        System.out.print("\nentre com a base: ");
        base = scanner.nextFloat();
        logaritmo = (float) (Math.log(num)/ Math.log(base));
        System.out.print("\no logaritmo de " + num + " na base " + base + " e: " + logaritmo);
        System.out.print("\n");



    }
}
