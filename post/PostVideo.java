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
	public boolean comenta(String texto) //Não sei se a prof vai querer que o comentario seja feito totalmente na função, ou se eu recebo ele como argumento
	{
		Comentario comentario = new Comentario(texto);
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
	
	public LocalDateTime getdata_postagem()
	{
		return this.data_postagem;
	}
	
	public void printaComentario()
	{
		if(this.lista_comentarios.size()==0)
		{
			System.out.println("\n\t [*~*~ Não há comentários nesta postagem. *~*~]\n");
		}
		else
		{
			int i;
			System.out.println("[*~*~*Lista de comentários*~*~*~]");
			for (i=0;i<this.lista_comentarios.size();i++)
			{
				System.out.println("\n\t Comentário:\n" + lista_comentarios.get(i).gettexto());
			}
		}
	}
	@Override
	public int getNum_comentarios()
	{
		return this.lista_comentarios.size();
	}
	@Override
	public String getUltimoComent()
	{
		return this.lista_comentarios.get(this.lista_comentarios.size()-1).gettexto();
	}
	@Override
	public void infos()
	{
		System.out.println("\n\t[*~*~Informações do objeto da classe PostVideo *~*~]\n");
		this.printaVideo();
		System.out.printf("\tdata_postagem :");
		System.out.println(this.getdata_postagem());
		this.printaComentario();
		System.out.println("\n\t [*~*~Fim das informações*~*~]\n");
	}
}
