package trab_poo.recurso;

public abstract class Recurso{
    
    protected int ID;
    protected String url_recurso;
    protected static int prox_ID = 1;

    public abstract boolean validaUrlRecurso(String url);

    public Recurso(String url) throws Exception
    {
        if(!(this.setURL(url)))
        {
            throw new Exception("\n[URL inserida inválida.]");
        }
        this.ID = Recurso.getProxID();
        Recurso.prox_ID++;
    }

    public int getID()
    {
        return this.ID;
    }

    public String getUrl()
    {
        return this.url_recurso;
    }

    public static int getProxID()
    {
        return Recurso.prox_ID;
    }

    public boolean setURL(String url)
    {
        if(this.validaUrlRecurso(url))
        {
            this.url_recurso = url;
            return true;
        }
        else
        {
            return false;
        }
    }
}
