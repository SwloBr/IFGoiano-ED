import java.util.Locale;
import java.util.Scanner;

public class Ex473 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String c;
        System.out.println("Digie letra: ");
        c = scanner.next();
        int x = maiscula(c);
        if(x==1) {
            System.out.println("e uma consoante ");
        } else {
            System.out.println("nao e uma consoantes");
        }
    }
    private static int maiscula(String letra) {
        letra.toLowerCase(Locale.ROOT);

        if (letra == "a" ||letra == "e" ||letra == "i" ||letra == "o" ||letra == "u") {
            return 1;
        } else {
            return 0;
        }

    }
}
