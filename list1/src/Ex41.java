import java.util.Scanner;

public class Ex41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float a, b, c, d, mp;
        System.out.print("\nentre com 1 numero: ");
        a = scanner.nextFloat();
        System.out.print("\nentre com 2 numero: ");
        b = scanner.nextFloat();
        System.out.print("\nentre com 3 numero: ");
        c = scanner.nextFloat();
        System.out.print("\nentre com 4 numero: ");
        d = scanner.nextFloat();
        mp =  (a*1 + b*2 + c*3 + d*4)/10;
        System.out.print("\nmedia ponderada: " + mp);
        System.out.print("\n");

    }
}
