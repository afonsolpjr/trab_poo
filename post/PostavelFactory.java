package trab_poo.post;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

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

        return null;
    }

    private static PostFoto getPostFoto()
    {
        int opcao=-1;
        int opcao2;
        String url;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\t\t[*~*~Postagem com foto*~*~]\n");

        PostFoto post_foto = new PostFoto();

        while(opcao!=3)
        {
            
            post_foto.printaFotos();

            System.out.println("\n[Opções]:\n" + 
                "\t[1] Incluir foto\n" + 
                "\t[2] Deletar foto\n" + 
                "\t[3] Cancelar criação de post\n" +
                "\n\t Selecione : ");

            opcao = input.nextInt();
            
            switch(opcao)
            {
            case 1:
                System.out.print("\n[Insira o URL da foto]\n" +
                    "URL: ");
                url = input.next();
                Foto foto = new Foto();

                if(foto.setURL(url))
                {
                    System.out.println("\n[Foto adicionada com sucesso!] teste url=  "+
                     foto.getUrl() +
                     "\n");

                    post_foto.adicionaFotos(foto);
                }
                else
                {
                    System.out.println("\n[ URL inválida. Tente outra URL.]\n");
                }  
                break;
                
            case 2: //deletar foto
                post_foto.printaFotos();
                System.out.println("\nSelecione o id da foto a ser deletada");
                opcao2 = input.nextInt();
                opcao2--;
                foto = post_foto.getFoto(opcao2);
                post_foto.removeFoto(foto);
                foto = null;
                break;
            
            case 3:
                post_foto = null;
                return null;                    
            }
        }

        return post_foto;
    }

    private static PostVideo getPostVideo()
    {
        return null;
    }
}
