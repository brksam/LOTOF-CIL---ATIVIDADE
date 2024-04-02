import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        System.out.println("exemplo do while");
        int opcao;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("******** Sistema de cadastro **********");
            System.out.println("1 - Apostar de 0 a 100");
            System.out.println("2 - Apostar de A à Z");
            System.out.println("3 - Apostar em par ou ímpar");
            System.out.println("0 - Sair");
            System.out.println("***************************************");
            opcao = in.nextInt();
            System.out.println("***************************************");
            switch (opcao){
                case 1:
                    aposta0100();
                    break;
                case 2:
                    apostaAZ();
                    break;
                case 3:
                    parimpar();
                    break;
                case 0:
                    System.out.println("Opção 0 escolhida!");
                    break;
                default:
                    System.out.println("o número escolhido é invalido!");
            }
        }while(opcao != 0);
    }
    public static void aposta0100(){
        Scanner s = new Scanner(System.in);
        System.out.println("DIGITE O VALOR A SER APOSTADO (ENTRE 0 E 100) SE VOCÊ ACERTAR VOCÊ GANHAR 1000 R$");
        int aposta = s.nextInt();
        if (aposta > 100  || aposta < 0){
            System.out.println("Aposta inválida!");
        }else{
            double numerorandom = Math.random() * 101;
            int numeroInteiro = (int)numerorandom;
            if (numeroInteiro == aposta){
                System.out.println("VOCÊ ACERTOU O NÚMERO, ACABOU DE GANHAR 100R$");
            }else{
                System.out.println("VOCÊ ERROU O NÚMERO, MEU NÚMERO ESCOLHIDO FOI: " + numeroInteiro);
            }
        }
    }

    public static void apostaAZ(){
        Random random = new Random();
        System.out.println("DIGITE UMA LETRA");
        try {
            char l = (char) System.in.read();
            if (Character.isLetter(l)){
                l = (Character.toLowerCase(l));
                if (l >= 'a' && l <= 'z'){
                    System.out.println("------------------------");
                    System.out.println("Você digitou a letra: " + l);
                    System.out.println("------------------------");
                    int numeroQtransformLetra = random.nextInt(26) + 65;
                    char lrandon = (char)numeroQtransformLetra;
                    if (l != lrandon){
                        System.out.println("Que pena! A letra sorteada foi: " + lrandon);
                    }else if (l == lrandon){
                        System.out.println("Você ganhou R$ 500,00 reais.");
                    }
                }
                else {
                    System.out.println("Aposta inválida!");
                }
            }else{
                System.out.println("Aposta inválida!");
            }
        }catch(IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
    public static void parimpar(){
        Scanner s = new Scanner(System.in);
        System.out.println("DIGITE UM NÚMERO: ");
        int numDigitado = s.nextInt();
        if (numDigitado % 2 == 0){
            System.out.println("Você ganhou R$ 100,00 reais");
        }else {
            System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
        }
    }
}