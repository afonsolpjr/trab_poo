package trab_poo.post;
import java.util.Scanner;
import java.util.ArrayList;
import trab_poo.recurso.Foto;
import java.time.LocalDateTime;
public class PostFoto
{
	private int qtde_fotos;
	private ArrayList<Foto> fotos = new ArrayList<Foto>();
	private String localizacao;
	private LocalDateTime data_postagem = LocalDateTime.now();
	private ArrayList<Comentario> listaComentarios = new ArrayList<Comentario>();
	public PostFoto()
	{
	}

	public boolean adicionaFotos(Foto foto)
	{
		this.fotos.add(foto);
		this.qtde_fotos+=1;
		return true;
	}

	public boolean removeFoto(Foto foto)
	{
		if(this.fotos.contains(foto))
		{
			if(this.fotos.remove(foto))
			{
				this.qtde_fotos-=1;
				return true;
			}
		}
		return false;
	}

	public boolean posta() //Quando aprendermos estado de erro vou implementar esse método
	{
		return true;
	}
	
	public boolean comenta()
	{
		Scanner sc = new Scanner(System.in);
		Comentario comentario = new Comentario(sc.next());
		this.listaComentarios.add(comentario);
		return true;
	}
}
