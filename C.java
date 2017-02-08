/**
 * 
 */
package cine;

/**
 * @author Lorenzo Gómez y Arturo Martinez
 *
 */
public class Cine {
	//Atributos de la clase cine
	private String nombre;
	private Sala [] salas;
	
	//Métodos de la clase cine
	/**
	 * Constructor de la clase Cine que recibe como argumento el nombre
	 * del cina y un vector de salas y se encarga de inicializar los atributos.
	 * @param nombre
	 * @param salas
	 */
	public Cine (String nombre, Sala [] salas){
		this.nombre= nombre;
		this.salas=salas;
		
		
	}
	public void comprarEntrada (int sala, int sesion, int fila, int columna){
		this.salas[sala-1].comprarEntrada(sesion, fila, columna);
		
	}
	public int getIdEntrada(int sala , int sesion, int fila, int columna){
		return this.salas[sala-1].getIdEntrada(sesion, fila, columna);
		
	}
	public String [] getPeliculas(){
		String [] peliculas= new String [this.salas.length];
		for (int i=0; i<this.salas.length; i++){
			peliculas [i]= salas[i].getPelicula();
		}
		return peliculas;
	}
	public String [] getHorasDeSesionesDeSala(int sala){
		return this.salas[sala-1].getHorasDeSesionesDeSala();
	}
	public char [][]  getEstadoSesion(int sala, int sesion){
		return this.salas[sala-1].getEstadoSesion(sesion); 
	}
	public int  getButacasDisponiblesSesion(int sala, int sesion){
		return this.salas[sala-1].getButacasDisponiblesSesion(sesion);
		
	}
	public String recogerEntradas (int id, int sala, int sesion){
		return this.nombre+"@"+this.salas[sala-1].recogerEntradas(id, sesion);
	}
	public ButacasContiguas recomendarButacasContiguas (int noButacas, int sala, int sesion){
		return this.salas[sala-1].recomendarButacasContiguas(noButacas, sesion);
		
	}
	public void comprarEntradasRecomendadas (int sala, int sesion , ButacasContiguas butacas){
		this.salas[sala-1].comprarEntradasRecomendadas(sesion, butacas);
		
	}

}
