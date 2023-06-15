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

public class PostFoto extends Postavel
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

	public Foto getFoto(int id) //retorna foto pelo id informado dela. Será que isso nao deveria estar em recurso?
	{
		int i;
		for(i=0;i<fotos.size();i++)
		{
			if(fotos.get(i).getID() == id)
			{
				return fotos.get(i);
			}
		}
		return null;
	}

	// public boolean posta() throws ToofewException,ToomanyException
	// {
	// 	if(this.fotos.size()==0)
	// 	{
	// 		throw new TooFewException();
	// 	}
	// 	else if(this.fotos.size() >10)
	// 	{
	// 		throw new TooManyException();
	// 	}
	// 	else 
	// 	{
	// 		this.data_postagem = LocalDateTime.now();
	// 		System.out.println("Foto Postada com sucesso");
	// 		return true;
	// 	}
	// }
	
	public boolean posta()
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
	

	public void printaFotos()
	{
		if(this.qtde_fotos==0)
		{
			System.out.println("\n\t[*~*~ Não há fotos nesta postagem. *~*~]\n");
		}
		else
		{
			int i;
			System.out.println("[*~*~*~Lista de fotos*~*~*~]");
			for(i=0;i<this.qtde_fotos;i++)
			{
				System.out.println("\n\t[Id:" + fotos.get(i).getID() +
					"] URL: " +
					fotos.get(i).getUrl());
			}
		}
	}
	
	public int getQtdFotos()
	{
		return this.qtde_fotos;
	}

}

