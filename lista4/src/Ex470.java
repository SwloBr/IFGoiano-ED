import java.util.Scanner;

public class Ex470 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int num, pri;
        num = scanner.nextInt();
        pri = primo(num);
        if (pri == 0) {
            System.out.println(" e primo" + num);
        } else {
            System.out.println("nao e primo" + num);
        }
    }

    private static int primo(int n) {
        int c, p;
        c = 0;
        p = 2;
        while (c== 0 && p <= n/2) {
            if (n %p == 0) {
                c = 1;
            }
            p++;
        }
        return c;

    }

}
