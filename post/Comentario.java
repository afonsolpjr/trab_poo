package Trab_final;
import java.time.LocalDate;
public class Comentario
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
