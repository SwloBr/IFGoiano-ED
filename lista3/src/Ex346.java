import java.util.Scanner;

public class Ex346 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String frase;
        int op, x, tam;

        do {
            System.out.println("MENU");
            System.out.println("1 - Imprime o comprimento da frase ");
            System.out.println("2 - Imprime os dois primeiros e os dois ultimos caracteres da frase ");
            System.out.println("3 - Imprime a frase espelhada ");
            System.out.println("4 - Termina o algoritmo ");
            System.out.println("OPCAO");
            op = scanner.nextInt();
            if (op == 1) {
                System.out.println("Digite uma frase: ");
                frase = scanner.nextLine();
                System.out.println("numero de caracteres da frase: " + frase.length());
            } else {
                if (op == 2) {
                    System.out.println("Digite uma frase: ");
                    frase = scanner.nextLine();
                    System.out.println("os dois primeiros caracteres: " + frase.charAt(0) + frase.charAt(1) );
                    tam = (frase.length() - 2);
                    System.out.print("\nos dois ultimos caracteres: ");
                    for (int i = 2; i < frase.length() ; i++) {
                        System.out.print(frase.charAt(i));
                    }
                } else {
                    if (op == 3) {
                        System.out.println("Digite uma frase: ");
                        frase = scanner.nextLine();
                        for (x = frase.length() -1; x >= 0 ; x--) {
                            System.out.println(frase.charAt(x));
                        }
                    } else {
                        if (op == 4) {
                            System.out.println("Fim do algoritmo");
                        } else { System.out.println("opção não disponível");}
                    }
                }
            }
            System.out.println("\n");
        } while (op <= 4);
        System.out.println("\n");
    }
}

