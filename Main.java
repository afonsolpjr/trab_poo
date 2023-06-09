package trab_poo;
import java.util.Scanner;

public class Main {
    

public static void Main(String[] args)
{
    int opcao;
    Scanner input = new Scanner(System.in);

    opcao = -1;
    while(opcao!=0)
    {
        System.out.println(
            "Selecione o teste que deseja realizar:\n" +
            "\n\t[1] Tentativa de postagem com texto" + 
            "\n\t[2] Tentativa de postagem com um vídeo atribuído" +
            "\n\t[3] Tentativa de postagem sem vídeo" +
            "\n\t[4] Tentativa de postagem sem foto" + 
            "\n\t[5] Tentativa de postagem com 5 fotos atribuídas" + 
            "\n\t[6] Tentativa de postagem com 11 fotos atribuídas" +
            "\n\t[7] Tentativa de criação de comentário em uma postagem com foto" +
            "\n\t[8] Tentativa de criação de comentário em uma postagem com vídeo" +
            "\n\t[9] Tentativa de criação de vídeo inválido" +
            "\n\t[10] Tentativa de criação de foto inválida\n" +
            "Insira o numero da opção: ");

        opcao = input.nextInt();

        System.out.println("Numero digitado:" + opcao);

    }

}
}
