package trab_poo.recurso;


public class Video extends Recurso{
    
    private int frame_rate;
    private int duracao;



    public int getFrameRate()
    {
        return this.frame_rate;
    }

    public int getDuracao()
    {
        return this.duracao;
    }

    public boolean validaUrlRecurso(String url) // a fazer
    {
        return true;
    }
}
