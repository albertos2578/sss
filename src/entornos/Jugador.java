package entornos;


public class Jugador {
	private String nombre;
	private int edad;
	private String idioma;

	/*NOMBRE*/
	public void setNombreJugador(String nombre) {
		if (isValidated(nombre)){

			//Pasamos a mayusculas para facilitar el trabajo
			String nombreMayus = nombre.toUpperCase();

			//Comprobamos el Rango
			if (isInRange(nombreMayus)) {

				//Comprobamos que sea del abecedario español
				if (isWord(nombreMayus)){
					this.nombre = nombreMayus;
				}
			}
		}
	}

	public String getNombreJugador() {
		return nombre;
	}

	/*EDAD*/
	public void setEdad(int edad) {

		//Comprobamos el Rango de edad
		if (isInYear(edad)){
			this.edad = edad;
		}

	}

	public int getEdad() {
		return edad;
	}

	/*IDIOMA*/
	public void setIdioma(String idioma) {
		// A IDIOMA NO PUEDE LLEGAR MAS DE 1 IDIOMA

		//Pasamos el idioma a minusculas
		String idiomaMin = idioma.toLowerCase();

		//Revisamos que no sea nulo y no este vacio
		if (isValidated(idiomaMin)) {
			if (isInLanguage(idiomaMin)) {
				this.idioma = idioma;
			}

		}
	}

	public String getIdioma() {
		return idioma;
	}


	//Story 5
	/*TIPO*/
	public String getTipoJugador() {
		//String para los rangos de clases
		String junior = "Junior";
		String senior = "Senior";
		String master = "Master";

		//Int para rangos de edades
		int edadMinJunior = 18;
		int edadMaxJunior = 25;
		int edadMinSenior = 26;
		int edadMaxSenior = 35;
		int edadMinMaster = 36;
		int edadCero = 0;

			if (this.edad >= edadMinJunior
					&& this.edad <= edadMaxJunior) {

				return junior;

			} else if (this.edad >= edadMinSenior
					&& this.edad <= edadMaxSenior) {

				return senior;

			} else if (this.edad >= edadMinMaster) {

				return master;

			} else {
				return null;
			}

	}

	//Nos devuelve un true si es distinto a nulo.
	private Boolean isValidated(String comprobar) {

		if (comprobar != null) {

			return true;
		}
		return false;
	}

	//Nos devuelve un true si está en rango la longitud de la palabra
	private boolean isInRange(String comprobar){
		int largoMin = 4;
		int largoMax = 20;

		if (comprobar.length() >= largoMin
				&& comprobar.length() <= largoMax ){
			return true;
		}
		return false;
	}

	//Nos devuelve un true si una letra del abecedario español
	private boolean isWord(String comprobar){
		char a = 65;
		char z = 90;
		char espacio = 32;

		for (int i = 0; i < comprobar.length(); i++) {
			char c = comprobar.charAt(i);
			if (!(c >= a && c <= z || c==espacio)) {
				return false;
			}
		}
		return true;
	}

	//Nos devuelve true si está en el rango de edad
	private boolean isInYear(int comprobarEdad){
		int edadCero = 0;
		int edadMinima = 18;
		int edadMaxima = 100;

		if (comprobarEdad != edadCero){

			if (comprobarEdad >= edadMinima && comprobarEdad <= edadMaxima){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	//Nos devuelve true si el idioma es válido
	private boolean isInLanguage(String idioma){
		String[] listaDeIdiomas =  {"aleman", "ingles", "espanol", "frances"};
		String vacio = " ";

		if (!idioma.equals(vacio)){
			for (int i = 0; i < listaDeIdiomas.length; i++) {
				if (idioma.contains(listaDeIdiomas[i])){
					return true;
				}
			}

		}
		return false;
	}

}