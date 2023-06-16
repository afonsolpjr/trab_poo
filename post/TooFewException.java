package trab_poo.post;

public class TooFewException extends Throwable
{
	@Override
    public String toString()
	{
		return "Não há mídia na postagem";
	}
}
