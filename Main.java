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
    ArrayList<Postavel> posts = new ArrayList<Postavel>();
    Postavel post;
    Scanner input = new Scanner(System.in);

    opcao = -1;
    while(opcao!=0)
    {
        System.out.println(
            "Selecione o teste que deseja realizar:\n" +
            "\n[1] Tentativa de postagem com texto" + 
            "\n[2] Tentativa de postagem com um vídeo atribuído" +
            "\n[3] Tentativa de postagem sem vídeo" +
            "\n[4] Tentativa de postagem sem foto" + 
            "\n[5] Tentativa de postagem com 5 fotos atribuídas" + 
            "\n[6] Tentativa de postagem com 11 fotos atribuídas" +
            "\n[7] Tentativa de criação de comentário em uma postagem com foto" +
            "\n[8] Tentativa de criação de comentário em uma postagem com vídeo" +
            "\n[9] Tentativa de criação de vídeo inválido" +
            "\n[10] Tentativa de criação de foto inválida" +
            "\n[0] para sair." +
            "\n\nInsira o numero da opção: ");
        
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
                input.nextLine();
                System.out.println("\n\t[Insira um valor válido!]");
        }
        
        switch(opcao)
        {

        case 1:
                testpost_texto();
                break;
        case 2:
                post = testpost_video();
                if(post!=null)
                        posts.add(post);
                break;
        case 3:
                testpost_semvideo();
                break;
        case 4:
		testpost_semfoto();
                break;
        case 5:
                post = testpost_5fotos();
                if(post!=null)
                        posts.add(post);
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
    input.close();
}

// A classe de execução do trabalho (Main) deverá ter pelo menos os seguintes testes:
// ● Tentativa de postagem com texto
// ● Tentativa de postagem com um vídeo atribuído       FEITO
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

    private static Postavel testpost_video()
    {
        Postavel post = PostavelFactory.getPostavel("POSTVIDEO");
        if(post==null)
                return null;
        
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
        return post;
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

    private static Postavel testpost_5fotos()
    {
        Scanner input = new Scanner(System.in);
        int opt=-1;
        System.out.println("\nDigite [1] para inserir os URL das 5 fotos manualmente, " +
                "ou [2] utilizar os seguintes endereços:\n \"Foto1.jpg\""+
                "\n\"Foto2.bmp\""+
                "\n\"Foto3.png\"" +
                "\n\"Foto4.jpg\"" +
                "\n\"Foto5.png\"\n");
        try
        {
                opt = input.nextInt();
                input.nextLine();
                if(opt!= 0 && opt != 1 && opt !=2)
                        throw new InputMismatchException();
                
        }
        catch(InputMismatchException e)
        {
                System.out.println("[Insira um número válido]");
        }
        Postavel post1 = null;
        PostFoto post2 = null;
        if(opt==1)
        {
                do
                {
                System.out.println("\t\tFaça uma postagem de 5 fotos!");
                post1 = PostavelFactory.getPostavel("POSTFOTO");
                if(post1==null)
                        return null;
                }
                while(((PostFoto)post1).getQtdFotos() != 5);
        }
        else if(opt==2)
        {
                post2 = new PostFoto();
                ArrayList<Foto> fotos = new ArrayList<Foto>();
                try
                {
                fotos.add(new Foto("Foto1.jpg"));
                fotos.add(new Foto("Foto2.bmp"));
                fotos.add(new Foto("Foto3.png"));
                fotos.add(new Foto("Foto4.jpg"));
                fotos.add(new Foto("Foto5.png"));
                }
                catch(Exception e)
                {
                        System.out.println(e.getMessage());
                }
                int i;
                for(i=0;i<fotos.size();i++)
                {
                        post2.adicionaFotos(fotos.get(i));
                }
        }
	try
	{
	        if(post1==null)
                        post2.posta();
                else
                        post1.posta();
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
                if(post1==null)
                        post2.infos();
                else
                        post1.infos();
        }
        if(post1==null)
                return post2;
        else
                return post1;
    }

    private static void testpost_11fotos()
    {
        Scanner input = new Scanner(System.in);
        int opt=-1;
        System.out.println("\nDigite [1] para inserir os URL das 11 fotos manualmente, " +
                "ou [2] utilizar endereços padrões.");
        try
        {
                opt = input.nextInt();
                input.nextLine();
                if(opt!= 0 && opt != 1 && opt !=2)
                        throw new InputMismatchException();
                
        }
        catch(InputMismatchException e)
        {
                System.out.println("[Insira um número válido]");
        }
        Postavel post = null;
        if(opt==1)
        {
                do
                {
                System.out.println("\t\tFaça uma postagem de 11 fotos!");
                post = PostavelFactory.getPostavel("POSTFOTO");
                if(post==null)
                        return;
                }
                while(((PostFoto)post).getQtdFotos() != 11);
        }
        else if(opt==2)
        {
                post = new PostFoto();
                ArrayList<Foto> fotos = new ArrayList<Foto>();
                try
                {
                        for(int i=0;i<11;i++)
                                fotos.add(new Foto(i+"teste.jpg"));
                }
                catch(IllegalArgumentException e)
                {
                        System.out.println(e.getMessage());
                }
                int i;
                for(i=0;i<fotos.size();i++)
                {
                        ((PostFoto)post).adicionaFotos(fotos.get(i));
                }
        }
	if(post==null)
                return;
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
