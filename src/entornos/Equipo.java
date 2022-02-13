package entornos;
public class Equipo {

	private String nombreEquipo;
	private int ranking;

	public void setNombreEquipo(String nombreEquipo) {
		//Comprobamos si es null
		if (isValidated(nombreEquipo)){
			//Comprobamos el Rango
			if (isInRange(nombreEquipo)) {
				//Comprobamos que sea del abecedario español
				if (isWord(nombreEquipo)){
					String nombreEquipoMayus = nombreEquipo.toUpperCase();
					this.nombreEquipo = nombreEquipoMayus;
				}
			}
		}
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}


	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		if (isEntire(ranking)){
			if (isRankingInRange(ranking)) {
				this.ranking = ranking;
			}
		}
	}

	// Author: alvaro martin bazan
	public String getCategoriaEquipo() {
		return categoria();
	}

	private String categoria(){
		String tercera = "Tercera";
		String segunda = "Segunda";
		String primera = "Primera";
		String retorno = null;

		//En esta parte definimos la categoria segun su ranking
		int minimoTerceraCategoria = 1;
		int maximoTerceraCategoria= 3;

		int minimoSegundaCategoria = 3;
		int maximoSegundaCategoria= 6;

		int minimoPrimeraCategoria = 7;
		int maximoPrimeraCategoria= 10;


		if (isValidated(nombreEquipo)){

			if(this.ranking>=minimoTerceraCategoria && this.ranking<maximoTerceraCategoria){
				retorno =  tercera;
			}else if(this.ranking>=minimoSegundaCategoria && this.ranking <=maximoSegundaCategoria){
				retorno = segunda;
			}else if(this.ranking>=minimoPrimeraCategoria && this.ranking <=maximoPrimeraCategoria){
				retorno = primera;
			}
		}
		return retorno;
	}

	//Nos devuelve true si no es nulo.
	private boolean isValidated(String nombreEquipo) {
		boolean isValidated = true;
		if(nombreEquipo==null) {
			isValidated= false;
		} else {
			isValidated= true;
		} return isValidated;
	}

	//Nos devuelve true si está en rango la longitud de la palabra
	private boolean isInRange(String nombreEquipo) {
		int nombreMinimo = 4;
		int nombreMaximo = 20;
		boolean isInRage = false;

		if (nombreEquipo.length() >= nombreMinimo && nombreEquipo.length() <= nombreMaximo) {
			isInRage= true;
		} else {
			isInRage = false;
		}

		return isInRage;
	}

	//Nos devuelve true si una letra del abecedario español
	private boolean isWord(String comprobar){
		char a = 65;
		char z = 90;
		char espacio = 32;
		char cero = 48;
		char nueve = 57;
		boolean inWord = true;

		comprobar = comprobar.toUpperCase();

		for (int i = 0; i < comprobar.length(); i++) {
			char c = comprobar.charAt(i);
			if (!(c >= a && c <= z || c==espacio)) {
				inWord =  false;
				i = comprobar.length()+1;
			}
			if (c>= cero && c <= nueve){
				inWord = false;
				i = comprobar.length()+1;
			}
		}

		return inWord;
	}

	//Nos devuelve true si es un numero entero
	private boolean isEntire(int ranking) {
		boolean isEntire = true;

		if(ranking%1 != 0) {
			isEntire= false;

		} else {
			isEntire = true;

		}
		return isEntire;
	}

	//Nos devuelve true si está en el rango de ranking
	private boolean isRankingInRange(int ranking) {
		int rankingMinimo = 1; //ranking minimo para poder esta en el ranking
		int rankingMaximo = 10; //ranking maximo para poder esta en el ranking
		boolean isInRange = true;

		if (ranking >= rankingMinimo && ranking <= rankingMaximo) { //Comprobamos que estan entre el minimo y el maximo
			isInRange = true;
		} else {
			isInRange = false;
		}
		return isInRange;
	}


}
