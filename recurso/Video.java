package trab_poo.recurso;

import java.util.ArrayList;


public class Video extends Recurso{
    
    private int frame_rate;
    private int duracao;

    public Video(String url) throws IllegalArgumentException
    {
        super(url);
    }

    public int getFrameRate()
    {
        return this.frame_rate;
    }

    public int getDuracao()
    {
        return this.duracao;
    }

    public boolean validaUrlRecurso(String url) 
    {
        // URL termina em ‘.mp4’, ‘.mov’ ou ‘.wmv’.
        int tam_url = url.length();

        if(url.length() < 4)
            return false;
        

        String url_ext;
        url_ext = url.substring(tam_url-4);

        ArrayList<String> extensoes = new ArrayList<String>();

        extensoes.add(".mp4");
        extensoes.add(".mov");
        extensoes.add(".wmv");

        return (extensoes.contains(url_ext));

    }
}
