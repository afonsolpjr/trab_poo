package trab_poo;
import java.util.Scanner;
import trab_poo.post.*;
import trab_poo.recurso.*;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class Main {
    
public static void main(String[] args)
{
    int opcao;
    Postavel post;
    ArrayList<PostFoto> post_fotos = new ArrayList<PostFoto>();
    ArrayList<PostVideo> post_videos = new ArrayList<PostVideo>();
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
            "\n\t[10] Tentativa de criação de foto inválida" +
            "\n\tou [0] para sair." +
            "\nInsira o numero da opção: ");
        
        try //validando entrada do usuario
        {
                opcao = input.nextInt();
                if(opcao<0 || opcao>10)
                {
                        throw new InputMismatchException();
                }
        }
        catch(InputMismatchException e)
        {
                input.next();
                System.out.println("\n\t[Insira um valor válido!]");
        }
        
        switch(opcao)
        {

        case 1:
                break;
        case 2:
                testpost_video();
                break;
        case 3:
                break;
        case 4:
		testpost_semfoto();
                break;
        case 5:
                testpost_5fotos();
                break;
        case 6:
                testpost_11fotos();
                break;
        case 7:
                break;
        case 8:  
                break;
        case 9:
                break;
        case 10:
                break;
        }
    }

}

// A classe de execução do trabalho (Main) deverá ter pelo menos os seguintes testes:
// ● Tentativa de postagem com texto
// ● Tentativa de postagem com um vídeo atribuído
// ● Tentativa de postagem sem vídeo
// ● Tentativa de postagem sem foto
// ● Tentativa de postagem com 5 fotos atribuídas
// ● Tentativa de postagem com 11 fotos atribuídas
// ● Tentativa de criação de comentário em uma postagem com foto
// ● Tentativa de criação de comentário em uma postagem com vídeo
// ● Tentativa de criação de vídeo inválido
// ● Tentativa de criação de foto inválida

    private static void testpost_texto()
    {

    }

    private static void testpost_video()
    {
        PostavelFactory.getPostavel("POSTVIDEO");
    }

    private static void testpost_semvideo()
    {

    }

    private static void testpost_semfoto()
    {
	// PostFoto post = new PostFoto();
	// try
	// {
	// 	post.posta();
	// }
	// catch (ToofewException e)
	// {
	// 	System.out.println("Erro: "+e);
	// }
	// catch (ToomanyException e)
	// {
	// 	System.out.println("Erro:"+e);
	// }
    }

    private static void testpost_5fotos()
    {
        Postavel post = PostavelFactory.getPostavel("POSTFOTO");
    }

    private static void testpost_11fotos()
    {

    }

    private static void testcoment_foto()
    {

    }

    private static void testcoment_video()
    {

    }

    private static void testinvalid_video()
    {

    }

    private static void testinvalid_foto()
    {

    }

}
