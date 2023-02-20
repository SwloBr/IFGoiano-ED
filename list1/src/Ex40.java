import java.util.Scanner;

public class Ex40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quoc, rest, val1, val2;
        System.out.print("\nentre com o dividendo: ");
        val1 = scanner.nextInt();
        System.out.print("\nentre com divisor: ");
        val2 = scanner.nextInt();
        quoc = val1/val2;
        rest = val1 % val2;
        System.out.print("\n\n\n");
        System.out.print("\ndividendo  : " + val1);
        System.out.print("\ndivisor    : " + val2);
        System.out.print("\nquociente  : " + quoc);
        System.out.print("\nresto      : " + rest);
        System.out.print("\n");
    }
}
