package trab_poo.recurso;

import java.util.ArrayList;


public class Foto extends Recurso{
    
    private String resolucao;

    public Foto(String url) throws Exception
    {
        super(url);
    }
    public String getResolucao()
    {
        return this.resolucao;
    }

    public boolean validaUrlRecurso(String url) // a fazer
    {
        /*método validaUrlRecurso comparando se a extensão da
        URL termina em '.jpg', ‘.png' e ‘.bmp’. 
        Caso seja uma dessas extensões, a URL é válida.
        Caso contrário, não é válida. */
        int tam_url = url.length();

        if(url.length() < 4)
        {
            return false;
        }

        String url_ext;
        url_ext = url.substring(tam_url-4);

        ArrayList<String> extensoes = new ArrayList<String>();

        extensoes.add(".jpg");
        extensoes.add(".png");
        extensoes.add(".bmp");

        return (extensoes.contains(url_ext));

    }
}
