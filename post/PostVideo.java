package trab_poo.post;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import trab_poo.post.PostFoto;
import trab_poo.recurso.Video;

public class PostVideo extends Postavel
{
	private Video video;
	private LocalDateTime data_postagem = LocalDateTime.now();
	private ArrayList<Comentario> lista_comentarios = new ArrayList<Comentario>();

	public PostVideo()
	{
	}
	
	public boolean adicionaVideo(Video video)
	{
		this.video=video;
		return true;
	}

	public void removeVideo()
	{
		this.video = null;
	}
	
	@Override
	public boolean posta() throws TooFewException
	{
		if (video==null)
		{
			throw new TooFewException();
		}
		else
		{
			this.data_postagem = LocalDateTime.now();
			System.out.println("Video postado com sucesso");
			return true;
		}
	}
	
	@Override
	public boolean comenta() //Não sei se a prof vai querer que o comentario seja feito totalmente na função, ou se eu recebo ele como argumento
	{
		Scanner sc = new Scanner(System.in);
		Comentario comentario = new Comentario(sc.next());
		this.lista_comentarios.add(comentario);
		return true;
	}

	public void printaVideo()
	{
		if(this.video == null)
		{
			System.out.println("\n\t[Não há vídeo atribuido a esta postagem.]");
		}
		else
		{
			System.out.println("\n\t[ID:" + this.video.getID() + "] " +
			"URL: " + this.video.getUrl());
		}
	}

	public Video getVideo()
	{
		return this.video;
	}
}
