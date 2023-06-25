package trab_poo.post;

public class TooFewException extends Throwable
{
	@Override
    public String toString()
	{
		return "\n\t[Erro:Não há mídia na postagem. Postagem não efetuada.]";
	}
}
