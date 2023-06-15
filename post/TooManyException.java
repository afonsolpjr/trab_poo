package trab_poo.post;

public class TooManyException extends Throwable
{
	@Override
    public String toString()
	{
		return "Há muitas fotos na postagem";	
	}
}
