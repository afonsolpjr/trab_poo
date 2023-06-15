package trab_poo.post;
import java.util.Scanner;
import java.util.ArrayList;
import trab_poo.recurso.Foto;
import java.time.LocalDateTime;
import java.time.LocalDate;

class Comentario
	{
		private LocalDate data = LocalDate.now();
		private boolean fixado;
		private int tamanho;
		private String texto;

		protected Comentario(String texto)
		{
			this.texto = texto;
			this.tamanho = texto.length();
		}
		protected int gettamanho()
		{
			return this.tamanho;
		}
	}

public class PostFoto
{
	private int qtde_fotos;
	private ArrayList<Foto> fotos = new ArrayList<Foto>();
	private String localizacao;
	private LocalDateTime data_postagem = LocalDateTime.now();
	private ArrayList<Comentario> listaComentarios = new ArrayList<Comentario>();
	
	public PostFoto()
	{
		this.qtde_fotos=0;
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

	public boolean posta() throws ToofewException,ToomanyException
	{
		if(this.fotos.size()==0)
		{
			throw new ToofewException();
		}
		else if(this.fotos.size() >10)
		{
			throw new ToomanyException();
		}
		else 
		{
			this.data_postagem = LocalDateTime.now();
			System.out.println("Foto Postada com sucesso");
			return true;
		}
	}
	
	public boolean comenta()
	{
		Scanner sc = new Scanner(System.in);
		Comentario comentario = new Comentario(sc.next());
		this.listaComentarios.add(comentario);
		return true;
	}
	public int getQtde_fotos()
	{
		return this.qtde_fotos;
	}
}

