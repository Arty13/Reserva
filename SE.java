
/**
 * 
 */
package cine;

/**
 * @author Lorenzo Gómez y Arturo Martinez
 *
 */
public class Sesion {
	// Atributos
	private String hora;
	private int[][] estadoAsientos;
	private int asientosDisponibles;
	private int sigIdCompra;

	// Metodos
	public Sesion(String hora, int filas, int columnas) {
		this.hora = hora;
		this.estadoAsientos = new int[filas][columnas];
		this.asientosDisponibles = filas * columnas;
		this.sigIdCompra = 1;

	}

	public String getHora() {
		return hora;
	}

	public void comprarEntrada(int fila, int columna) {
		this.estadoAsientos[fila - 1][columna - 1] = sigIdCompra++;
		this.asientosDisponibles--;

	}

	public int getIdEntrada(int fila, int columna) {
		return this.estadoAsientos[fila - 1][columna - 1];
	}

	public char[][] getEstadoSesion() {
		char[][] ocupacion = new char[estadoAsientos.length][estadoAsientos[0].length];
		for (int i = 0; i < estadoAsientos.length; i++) {
			for (int j = 0; j < estadoAsientos[i].length; j++) {
				if (estadoAsientos[i][j] == 0) {
					ocupacion[i][j] = 'O';
				} else {
					ocupacion[i][j] = '#';
				}
			}
		}
		return ocupacion;

	}

	public int getButacasDisponiblesSesion() {
		return this.asientosDisponibles;
	}

	public String recogerEntradas(int id) {
		String hora = this.hora ;
		for (int i = 0; i < estadoAsientos.length; i++) {
			for (int j = 0; j < estadoAsientos[i].length; j++) {
				if (estadoAsientos[i][j] == id) {
					hora += "+" + (i+1) + "," + (j+1);
				}
			}
		}

		return hora;

	}

	public ButacasContiguas recomendarButacasContiguas(int noButacas) {
		ButacasContiguas butacasContiguas=null;
		int butacas=0;
		for (int i= (estadoAsientos.length)/2+1; i<estadoAsientos.length && butacas<noButacas; i++){
			butacas=0;
			for (int j=estadoAsientos[0].length-1; j>=0 && butacas<noButacas; j--){
				if(estadoAsientos[i][j]==0){
					butacas++;
				}
				else butacas=0;
				if (butacas== noButacas){
					butacasContiguas= new ButacasContiguas (i+1, j+1, noButacas);
				}
			}
		}
		if (butacasContiguas == null) {
			for (int i = estadoAsientos.length / 2; i >= 0 && butacas < noButacas; i--) {
				butacas = 0;
				for (int j = estadoAsientos[0].length-1; j>=0 && butacas < noButacas; j--) {
					if (estadoAsientos[i][j] == 0) {
						butacas++;
					} else
						butacas = 0;
					if (butacas == noButacas) {
						butacasContiguas = new ButacasContiguas(i + 1, j + 1 , noButacas);
					}
				}
			}
		}
		return butacasContiguas;

	}

	public void comprarEntradasRecomendadas(ButacasContiguas butacas) {
		for (int i = 0; i<butacas.getNoButacas(); i++){
			   this.estadoAsientos[butacas.getFila()-1][(butacas.getColumna())+i-1]= this.sigIdCompra;
			  this.asientosDisponibles--; 
			  }
     		 this.sigIdCompra++;
     		 
	}

}
