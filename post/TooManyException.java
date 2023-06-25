package trab_poo.post;

public class TooManyException extends Throwable
{
	@Override
    public String toString()
	{
		return "\n\t[Erro:Muitas mídia na postagem (max = 10). Postagem não efetuada.]";	
	}
}
