package trab_poo.post;

import java.util.InputMismatchException;
import java.util.Scanner;

//import javax.lang.model.util.ElementScanner14;

import trab_poo.recurso.Video;
import trab_poo.recurso.Foto;



public class PostavelFactory {
    
    private PostavelFactory()
    {
        // Construtor privado vazio, pra evitar instanciação.
    }
    
    public static Postavel getPostavel(String tipo)
    {
        if(tipo.equals("POSTFOTO")) //retorna postfoto
        {
            return getPostFoto();
        }
        else if(tipo.equals("POSTVIDEO"))
        {
            //instanciacao de postvideo
            return getPostVideo();
        }
        else if(tipo.equals("POSTTEXTO"))
        {
            System.out.println("\n\t[*~*~Não existe posttexto*~*~]\n");
            return null;
        }

        return null;
    }

    private static PostFoto getPostFoto()
    {
        int opcao=0;
        int opcao2=0;
        String url = null;
        Scanner input = new Scanner(System.in);

        PostFoto post_foto = new PostFoto();

        while(true)
        {
            System.out.println("\n\t[*~*~Postagem com foto*~*~]\n");
            post_foto.printaFotos();
            System.out.print("\n\t[Opções]:\n" + 
                "\t[1] Incluir foto\n" + 
                "\t[2] Deletar foto\n" + 
                "\t[3] Cancelar criação de post\n" +
                "\t[4] Concluir criação de post\n" +
                "\n\tSelecione : ");
            opcao =0;
            try /* Valida entrada do usuário */
            {
                opcao = input.nextInt();
                input.nextLine();
                if(opcao<1 || opcao>4) //Adicionei o 4 à validação
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
            case 1: //inclusao de foto
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
                    Foto foto = new Foto(url);
                    System.out.println("\n\t[Foto adicionada com sucesso!]\n");
                    post_foto.adicionaFotos(foto);
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }  
                break;
                
            case 2: //deletar foto
                if(post_foto.getQtdFotos()==0)
                {
                    post_foto.printaFotos();
                    break;
                }

                post_foto.printaFotos();
                System.out.println("\nSelecione o id da foto a ser deletada");
                try
                {
                    opcao2 = input.nextInt();
                }
                catch(InputMismatchException e)
                {
                    input.next();
                    System.out.println("\n\t[Insira um valor válido!]");
                }
                Foto foto = post_foto.getFoto(opcao2);
                if(post_foto.removeFoto(foto))
                {
                    System.out.println("\n\t[Foto deletada com sucesso.]");
                }
                else 
                {
                    System.out.println("\n\t[ID inválido.]");
                }
                foto = null;
                break;
            
            case 3:
                post_foto = null;
                return null;                   
            
            case 4: // Adicionei case 4
                return post_foto;
            }
        }
    }

    private static PostVideo getPostVideo()
    {
        int opcao=0;
        String url;
        Scanner input = new Scanner(System.in);


        PostVideo post_video = new PostVideo();

        while(true)
        {
            System.out.println("\n\t[*~*~Postagem com video*~*~]\n");   
            post_video.printaVideo();

            System.out.print("\n\t[Opções]:\n" + 
                "\t[1] Incluir video\n" + 
                "\t[2] Deletar video\n" + 
                "\t[3] Cancelar criação de post\n" +
                "\t[4] Concluir criação de post\n" +
                "\n\t Selecione : ");
            opcao = 0;
            try //valida entrada
            {
                opcao = input.nextInt();
                input.nextLine();
                if(opcao < 0 || opcao >4 )
                    throw new InputMismatchException();
            }       
            catch(InputMismatchException e)
            {
                input.nextLine();
                System.out.println("\n\t[Insira um valor válido!]");
            } 
            
            switch(opcao)
            {
            case 1: //anexar video
                if(post_video.getVideo()!=null)
                {
                    System.out.println("\n\t[Já existe um vídeo incluido.]");
                    break;
                }
                System.out.print("\n\t[Insira o URL do video]\n" + "\tURL: ");

                url = input.nextLine();

                try
                {
                    Video video = new Video(url);
                    post_video.adicionaVideo(video);
                    System.out.println("\n\t[Vídeo adicionado com sucesso.]");
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }
                  
                break;
                
            case 2: //deletar video
                post_video.removeVideo();                
                break;
            
            case 3:
                post_video = null;
                return null;

            case 4:
                return post_video;
            }

        }

    }
}
