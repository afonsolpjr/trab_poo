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
                input.nextLine();
                if(opcao<0 || opcao>10)
                {
                        throw new InputMismatchException();
                }
        }
        catch(InputMismatchException e)
        {
                System.out.println("\n\t[Insira um valor válido!]");
        }
        
        switch(opcao)
        {

        case 1:
                testpost_texto();
                break;
        case 2:
                testpost_video();
                break;
        case 3:
                testpost_semvideo();
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
                testcoment_foto();
                break;
        case 8:  
                testcoment_video();
                break;
        case 9:
                testinvalid_video();
                break;
        case 10:
                testinvalid_foto();
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
        Postavel post = PostavelFactory.getPostavel("POSTVIDEO");
        try 
        {
                post.posta();
        }
        catch(TooFewException e)
        {
                System.out.println("Erro: "+e);
        }
        catch(TooManyException e)
        {
                System.out.println("Erro: "+e);
        }
        finally
        {
                post.infos();
        }
    }

    private static void testpost_semvideo()
    {
        PostVideo post = new PostVideo();
        try 
        {
                post.posta();
        }
        catch(TooFewException e)
        {
                System.out.println("Erro: "+e);
        }
        finally
        {
                post.infos();
        }
    }

    private static void testpost_semfoto()
    {
	PostFoto post = new PostFoto();
	try
	{
	        post.posta();
	}
	catch (TooFewException e)
	{
	        System.out.println("Erro: "+e);
	}
	catch (TooManyException e)
	{
		System.out.println("Erro:"+e);
	}
        finally
        {
                post.infos();
        }
    }

    private static void testpost_5fotos()
    {
        Postavel post = PostavelFactory.getPostavel("POSTFOTO");
	try
	{
	        post.posta();
	}
	catch (TooFewException e)
	{
	        System.out.println("Erro: "+e);
	}
	catch (TooManyException e)
	{
		System.out.println("Erro:"+e);
	}
        finally
        {
                post.infos();
        }
    }

    private static void testpost_11fotos()
    {
        Postavel post = PostavelFactory.getPostavel("POSTFOTO");
	try
	{
	        post.posta();
	}
	catch (TooFewException e)
	{
	        System.out.println("Erro: "+e);
	}
	catch (TooManyException e)
	{
		System.out.println("Erro:"+e);
	}
        finally
        {
                post.infos();
        }
    }

    private static void testcoment_foto()
    {
        Postavel post = PostavelFactory.getPostavel("POSTFOTO");
        System.out.println("Teste comentário: "+post.comenta());
    }

    private static void testcoment_video()
    {
        Postavel post = PostavelFactory.getPostavel("POSTVIDEO");
        System.out.println("Teste comentário: "+post.comenta());
    }

    private static void testinvalid_video()
    {

    }

    private static void testinvalid_foto()
    {

    }

}
