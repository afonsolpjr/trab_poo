import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import trab_poo.recurso;
import trab_poo.recurso.Foto;
package trab_poo.post;


public class PostavelFactory {
    
    private PostavelFactory()
    {
        // Construtor privado vazio, pra evitar instanciação.
    }
    
    public static Postavel getPostavel(String tipo)
    {
        if(tipo.equals("POSTFOTO")) //retorna postfoto
        {
            int opcao=-1;
            Scanner input = new Scanner(System.in);

            System.out.println("\n\t\t[*~*~Postagem com foto*~*~]\n");

            PostFoto post_foto = new PostFoto();

            while(opcao!=3)
            {
                //printa lista de fotos
                int i;
                char item_foto;
                System.out.println("\n[Lista de fotos da postagem]\n");
                for(i=0;i<post_foto.getQtde_fotos();i++)
                {
                    item_foto  += i;
                    System.out.println("[" + item_foto + "] Foto " + (i+1) +"\n" );
                }


                System.out.println("\n[Opções]:\n" + 
                    "\t[1] Incluir foto\n" + 
                    "\t[2] Deletar foto\n" + 
                    "\t[3] Cancelar criação de post\n" +
                    "\n\t Selecione : ");

                opcao = input.nextInt();
                
                switch(opcao)
                {
                case 1:
                    System.out.println("\n[Insira o URL da foto]\n" +
                        "URL: ");

                    String url = input.nextLine();
                    Foto foto = new Foto();

                    if(foto.setURL(url))
                    {
                        System.out.println("\n[Foto adicionada com sucesso!]\n");
                        post_foto.adicionaFotos(foto);
                    }
                    else
                    {
                        System.out.println("\n[ URL inválida. Tente outra URL.]\n");
                    }  
                    break;
                    
                case 2:
                    
                    
                }
            }


            return post_foto;
        }
        else if(tipo.equals("POSTVIDEO"))
        {
            //instanciacao de postvideo
        }
    }
}
