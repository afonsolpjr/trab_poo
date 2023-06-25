package trab_poo.post;
import java.util.Scanner;
import java.util.ArrayList;
import trab_poo.recurso.Foto;
import java.time.LocalDateTime;
import java.time.LocalDate;

class Comentario // Precisa ser default para evitar problemas de compilação (Herança)
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
		protected String gettexto()
		{
			return this.texto;
		}
		protected LocalDate getdata()
		{
			return this.data;
		}
		protected boolean fixaComentario()
		{
			if(!this.fixado) 
			{
				this.fixado = true;
				return true;
			}
			else
			{
				System.out.println("O comentário já está fixado");
				return false;
			}
		}
		protected boolean retiraFixado()
		{
			if(this.fixado)
			{
				this.fixado=false;
				return true;
			}
			else 
			{
				System.out.println("O comentário não está fixado");
				return false;
			}
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
		System.out.println("A foto cuja qual exclusão é desejada não está no Post");
		return false;
	}

	public Foto getFoto(int id) //retorna foto pelo id informado dela. Será que isso nao deveria estar em recurso? Acho que aqui mesmo por se tratar de querer uma foto especifica do post
	{
		int i;
		for(i=0;i<fotos.size();i++)
		{
			if(fotos.get(i).getID() == id)
			{
				return fotos.get(i);
			}
		}
		System.out.println("\n\t[Foto não está contida no Post]");
		return null;
	}

	public boolean posta() throws TooFewException,TooManyException
	{
		if(this.fotos.size()==0)
		{
			throw new TooFewException();
		}
		else if(this.fotos.size() >10)
		{
			throw new TooManyException();
		}
	 	else 
	 	{
			this.data_postagem = LocalDateTime.now();
	 		System.out.println("\n[Foto Postada com sucesso]");
	 		return true;
		}
	}
	
	@Override
	public boolean comenta(String texto)
	{
		Comentario comentario = new Comentario(texto);
		this.listaComentarios.add(comentario);
		return true;
	}
	
	public String getUltimoComent()
	{
		return this.listaComentarios.get(this.listaComentarios.size()-1).gettexto();
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
			System.out.println("\t\t[*~*~*~Lista de fotos*~*~*~]\n");
			for(i=0;i<this.qtde_fotos;i++)
			{
				System.out.print("\t\t\t[Id:" + fotos.get(i).getID() +
					"] URL: " +
					fotos.get(i).getUrl() + '\n');
			}
		}
	}
	
	public int getQtdFotos()
	{
		return this.qtde_fotos;
	}

	public void printaComentario()
	{
		if(this.listaComentarios.size()==0)
		{
			System.out.println("\n\t [*~*~ Não há comentários nesta postagem. *~*~]\n");
		}
		else
		{
			int i;
			System.out.println("[*~*~*Lista de comentários*~*~*~]");
			for (i=0;i<this.listaComentarios.size();i++)
			{
				System.out.println("\n\t Comentário:\n" + listaComentarios.get(i).gettexto());
			}
		}
	}
	public boolean setlocalizacao()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual local gostaria de adicionar à postagem?");
		String local = sc.nextLine();
		this.localizacao = local;
		return true;
	}
	public String getlocalizacao()
	{
		if(localizacao==null)
		{
			System.out.println("Localização não espeficicada");
			return null;
		}
		else
		{
			return this.localizacao;
		}
	}
	public LocalDateTime getdata_postagem()
	{
		return this.data_postagem;
	}

	public int getNum_comentarios()
	{
		return this.listaComentarios.size();
	}
	
	public void infos() //Método pra printar todas as informações do objeto criado como pedido na especificação do trabalho \\ sera que o nome é toString?
	{
		System.out.println("\n\t[*~*~Informações do objeto da classe PostFoto *~*~]\n");
		System.out.println("\tQuantidade de fotos: "+this.getQtdFotos());
		this.printaFotos();
		System.out.println("\tLocalizacao: "+this.getlocalizacao());
		System.out.printf("\tdata_postagem :");
		System.out.println(this.getdata_postagem());
		this.printaComentario();
		System.out.println("\n\t [*~*~Fim das informações*~*~]\n");
	}
}
