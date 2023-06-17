package trab_poo.post;

public abstract class Postavel
{
	public abstract boolean posta() throws TooFewException,TooManyException;;
	public abstract boolean comenta();
	public abstract void infos();
}
