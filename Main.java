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
                if(opcao<0 || opcao>10)
                {
                        throw new InputMismatchException();
                }
                input.nextLine();
        }
        catch(InputMismatchException e)
        {
                input.nextLine();
                System.out.println("\n\t[Insira um valor válido!]");
        }
        
        switch(opcao)
        {
        case 0:
                return;
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
        Postavel post = PostavelFactory.getPostavel("POSTTEXTO");
        if(post == null)
        {
                System.out.println("Não foi possivel criar posttexto");
        }
    }

    private static Postavel testpost_video()
    {
        Postavel post = PostavelFactory.getPostavel("POSTVIDEO");
        if(post==null)
                return null;
        
        try 
        {
                post.posta();
                post.infos();
                return post;
        }
        catch(TooFewException e)
        {
                System.out.println(e);
        }
        catch(TooManyException e)
        {
                System.out.println(e);
        }
        finally
        {
                post.infos();
        }
        return null;
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
                System.out.println(e);
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
	        System.out.println(e);
	}
	catch (TooManyException e)
	{
		System.out.println(e);
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
                if(opt!= 0 && opt != 1 && opt !=2)
                        throw new InputMismatchException();
                input.nextLine();
                
        }
        catch(InputMismatchException e)
        {
                input.nextLine();
                System.out.println("[Insira um número válido]");
                return null;
        }

        Postavel post1 = null; // Se escolher inserir manualmente, usa-se este objeto.
        PostFoto post2 = null;  // Se escolher os pré-definidos, este é utilizado.
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
	        if(post1==null){
                        post2.posta();
                        post2.infos();
                        return post2;}
                else{
                        post1.posta();
                        post1.infos();
                        return post1;}
	}
	catch (TooFewException e)
	{
	        System.out.println(e);
	}
	catch (TooManyException e)
	{
		System.out.println(e);
	}
        finally
        {
                if(post1==null)
                        post2.infos();
                else
                        post1.infos();
        }
        return null;
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
                if(opt!= 0 && opt != 1 && opt !=2)
                        throw new InputMismatchException();
                input.nextLine();
                
                
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
	        System.out.println(e);
	}
	catch (TooManyException e)
	{
		System.out.println(e);
	}
        finally
        {
                post.infos();
        }
    }

    private static boolean testcoment_foto()
    {
        Scanner sc = new Scanner(System.in);
        boolean fixa,desfixa;
        Postavel post = PostavelFactory.getPostavel("POSTFOTO");
        System.out.printf("Comentario: ");
        String comentario = sc.next();
        int num_anterior = post.getNum_comentarios();

        System.out.println("Teste comentário: "+post.comenta(comentario)); //Comenta
        if(post.getUltimoComent().equals(comentario) && post.getNum_comentarios()-num_anterior==1) 
        {
                post.printaComentario();
                fixa = post.fixaComentario();
                desfixa = post.desfixaComentario();
                if(fixa && desfixa) 
                {
                        System.out.println("Teste concluído com sucesso");
                        return true;
                }
                else return false;
        }
        else return false;
    }

    private static boolean testcoment_video()
    {
        Scanner sc = new Scanner (System.in);
        Postavel post = PostavelFactory.getPostavel("POSTVIDEO");
        boolean fixa,desfixa;

        System.out.printf("Comentario: ");
        String comentario = sc.next();

        int num_anterior = post.getNum_comentarios();
        
        System.out.println("Teste comentário: "+post.comenta(comentario));
        if(post.getUltimoComent().equals(comentario) && post.getNum_comentarios()-num_anterior==1)
        {
                post.printaComentario();
                fixa = post.fixaComentario();
                desfixa = post.desfixaComentario();
                if(fixa && desfixa) 
                {
                        System.out.println("Teste concluído com sucesso");
                        return true;
                }
                else return false;
        }
        else return false;
    }

    private static void testinvalid_video()
    {
        int opt;
        String url = null;
        Video video = null;
        Scanner input = new Scanner(System.in);

        System.out.println(
                "\nDigite [1] para inserir uma URL manualmente, " +
                "ou [2] utilizar um endereço inválido \"Videoinvalido.avi\" .");
        
        try
        {
                opt = input.nextInt();
                if(opt!= 0 && opt != 1 && opt !=2)
                        throw new InputMismatchException();
                input.nextLine();
                
        }
        catch(InputMismatchException e)
        {
                input.nextLine();
                System.out.println("[Insira um número válido]");
                return;
        }        
        
        if(opt==1)
        {
                System.out.print("\n\t[Insira o URL do video]\n" +
                    "\tURL: ");

                try // valida entrada
                {
                    url = input.nextLine();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("\n\t[Insira um valor válido!]");
                }

                try
                {
                    video = new Video(url);
                    System.out.println("\n\t[Video criado com sucesso!]\n");
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }  
        }
        else if(opt==2)
        {
                try
                {
                        video = new Video("Videoinvalido.avi");                
                }
                catch(IllegalArgumentException e)
                {
                        System.out.println(e.getMessage());
                }
        }
        else if(opt==0)
                return;


    }

    private static void testinvalid_foto()
    {
        String url = null;
        Foto foto = null;
        int opt;
        Scanner input = new Scanner(System.in);

        System.out.println(
                "\nDigite [1] para inserir uma URL manualmente, " +
                "ou [2] utilizar um endereço inválido \"FotoInvalida.img\" .");
        
        try
        {
                opt = input.nextInt();
                if(opt!= 0 && opt != 1 && opt !=2)
                        throw new InputMismatchException();
                input.nextLine();
        }
        catch(InputMismatchException e)
        {
                input.nextLine();
                System.out.println("[Insira um número válido]");
                return;
        }        
        
        if(opt==1)
        {
                System.out.print("\n\t[Insira o URL da foto]\n" +
                    "\tURL: ");

                try // valida entrada
                {
                    url = input.nextLine();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("\n\t[Insira um valor válido!]");
                }

                try
                {
                    foto = new Foto(url);
                    System.out.println("\n\t[Foto criada com sucesso!]\n");
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }
        }
        else if(opt==2)
        {
                try
                {
                        foto = new Foto("FotoInvalida.img");                
                }
                catch(IllegalArgumentException e)
                {
                        System.out.println(e.getMessage());
                }
        }
        else if(opt==0)
                return;
    }

    
}
