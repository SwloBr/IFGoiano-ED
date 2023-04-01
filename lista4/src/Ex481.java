import java.util.Scanner;

public class Ex481 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int num, base, c;
        System.out.println("digite numero maior ou igual a 0");
        num = scanner.nextInt();
        while (num < 0) {
            System.out.println(" numero negatio. digite numero maior ou igual a 0");
            num = scanner.nextInt();
        }
        System.out.println("digite a base em deseja representa-lo(2-10): ");
        base = scanner.nextInt();
        while (base <2 || base >10) {
            System.out.println("nao sei converter. digite a base em deseja representa-lo(2-10): ");
            base = scanner.nextInt();

        }
        c = converte(num, base);
        System.out.println("numero em decimal: " + num);
        System.out.println("numero na base " +base + " : " + c);
    }
    private static int converte(int nnum, int nbase) {
        int nb, r,b;
        b = 0;
        nb = 0;
        while (nnum > nbase) {
            r = nnum%nbase;
            nb = (int)(nb + Math.pow(10,b) * r);
            nnum = nnum/nbase;
            b++;
        }
        nb = (int)(nb + Math.pow(10,b) * nnum);

    return nb;
    }
}
