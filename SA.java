/**
 * 
 */
package cine;

/**
 * @author Lorenzo Gómez y Arturo Martinez
 *
 */
public class Sala {
	// Atributos
	private String pelicula;
	private Sesion[] sesiones;

	// Metodos de la clase Sala
	public Sala(String pelicula, String[] horasSesiones, int filas, int columnas) {
		this.pelicula = pelicula;
		this.sesiones = new Sesion[horasSesiones.length];
		for (int i=0; i<horasSesiones.length; i++){
			sesiones[i] = new Sesion(horasSesiones[i], filas, columnas); 
			}

	}

	public String getPelicula() {
		return pelicula;
	}

	public void comprarEntrada(int sesion, int fila, int columna) {
		this.sesiones[sesion - 1].comprarEntrada(fila, columna);
	}

	public int getIdEntrada(int sesion, int fila, int columna) {
		return this.sesiones[sesion - 1].getIdEntrada(fila, columna);
	}

	public String [] getHorasDeSesionesDeSala(){
		String[] horaSesion = new String[this.sesiones.length];
		for (int i=0; i<this.sesiones.length; i++){
			horaSesion[i] = this.sesiones[i].getHora();
			}
	return horaSesion;
	}

	public char[][] getEstadoSesion(int sesion) {
		return this.sesiones[sesion - 1].getEstadoSesion();
	}

	public int getButacasDisponiblesSesion(int sesion) {
		return this.sesiones[sesion - 1].getButacasDisponiblesSesion();
	}

	public String recogerEntradas(int id, int sesion) {
		return this.pelicula+"@"+this.sesiones[sesion-1].recogerEntradas(id);

	}

	public ButacasContiguas recomendarButacasContiguas(int noButacas, int sesion) {
		return this.sesiones[sesion-1].recomendarButacasContiguas(noButacas);
		
	}

	public void comprarEntradasRecomendadas(int sesion, ButacasContiguas butacas) {
		this.sesiones[sesion-1].comprarEntradasRecomendadas(butacas);
		
	}

}
