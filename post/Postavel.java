package trab_poo.post;

public abstract class Postavel
{
	public abstract boolean posta() throws TooFewException,TooManyException;;
	public abstract boolean comenta(String texto);
	public abstract void infos();
	public abstract int getNum_comentarios();
	public abstract String getUltimoComent();
	public abstract void printaComentario();
	public abstract boolean fixaComentario();
	public abstract boolean desfixaComentario();
}
