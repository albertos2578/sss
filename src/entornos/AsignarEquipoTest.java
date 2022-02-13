package entornos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AsignarEquipoTest {


	/**
	 * Quiero comprobar la asignación de un equipo, con todos los campos de jugador, son correctos y se guarden.
 	 */
	@Test
	void testSetJugadorTodoCorrecto() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		/*Creamos un jugador con todos los campos válidos*/
		Jugador jugador = new Jugador();
		String nombrevalido = "Maria";
		int edadValida = 32;
		String idiomaValido = "Espanol";

		jugador.setNombreJugador(nombrevalido);
		jugador.setEdad(edadValida);
		jugador.setIdioma(idiomaValido);

		/*Asignar el jugador creado en asignar equipo*/
		asignarEquipo.setJugador(jugador);

		Jugador jugadorGuardado = asignarEquipo.getJugador();

		nombrevalido = nombrevalido.toUpperCase();

		assertNotNull(asignarEquipo.getJugador());
		assertEquals(nombrevalido, jugadorGuardado.getNombreJugador());
		assertEquals(edadValida, jugadorGuardado.getEdad());
		assertEquals(idiomaValido, jugadorGuardado.getIdioma());
	}

	/**
	 * Se prueba Set nombre, para ver que el nombre esta mal puesto
	 */
	@Test
	void testSetNombreJugadorNombreIncorrecto() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Jugador jugador = new Jugador();
		String nombreInvalido = "1234";
		int edadValida = 18;
		String idiomaValido = "Aleman";

		jugador.setNombreJugador(nombreInvalido);
		jugador.setEdad(edadValida);
		jugador.setIdioma(idiomaValido);

		asignarEquipo.setJugador(jugador);

		Jugador jugadorGuardado = asignarEquipo.getJugador();

		assertNull(jugadorGuardado);
	}

	/**
	 * Se prueba Set nombre, para ver si el nombre esta vacio
	 */
	@Test
	void testSetNombreJugadorNombreVacio() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Jugador jugador = new Jugador();
		String nombrevalido = "";
		int edadValida = 80;
		String idiomaValido = "Ingles";

		jugador.setNombreJugador(nombrevalido);
		jugador.setEdad(edadValida);
		jugador.setIdioma(idiomaValido);

		asignarEquipo.setJugador(jugador);

		Jugador jugadorGuardado = asignarEquipo.getJugador();

		assertNull(jugadorGuardado);
	}

	/**
	 * Se prueba Set edad para ver que la edad no es valida
	 */
	@Test
	void testSetNombreJugadorPruebaEdadNoValida() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Jugador jugador = new Jugador();
		String nombrevalido = "Maria";
		int edadValida = 15;
		String idiomaValido = "Espanol";

		jugador.setNombreJugador(nombrevalido);
		jugador.setEdad(edadValida);
		jugador.setIdioma(idiomaValido);

		Jugador jugadorGuardado = asignarEquipo.getJugador();

		assertNull(jugadorGuardado);
	}

	/**
	 * Se prueba Set nombre, para ver que no tenga edad
	 */
	@Test
	void testSetNombreJugadorPruebaNoHayEdad() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Jugador jugador = new Jugador();
		String nombrevalido = "Artsiom";
		int edadValida = 0;
		String idiomaValido = "Aleman";

		jugador.setNombreJugador(nombrevalido);
		jugador.setEdad(edadValida);
		jugador.setIdioma(idiomaValido);
		nombrevalido = nombrevalido.toUpperCase();

		asignarEquipo.setJugador(jugador);

		Jugador jugadorGuardado = asignarEquipo.getJugador();

		assertNull(jugadorGuardado);
	}

	/**
	 * Se prueba Set nombre, para ver que idioma no es valido
	 */
	@Test
	void testSetNombreJugadorPruebaIdiomaNoValido() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		/*Creamos un jugador con todos los campos válidos*/
		Jugador jugador = new Jugador();
		String nombrevalido = "Artsiom";
		int edadValida = 50;
		String idiomaValido = "Japones";

		jugador.setNombreJugador(nombrevalido);
		jugador.setEdad(edadValida);
		jugador.setIdioma(idiomaValido);

		/*Asignar el jugador creado en asignar equipo*/
		asignarEquipo.setJugador(jugador);

		Jugador jugadorGuardado = asignarEquipo.getJugador();

		assertNull(jugadorGuardado);
	}

	/**
	 * Se prueba que jugador no se guarda cuanto no tine idioma
	 */
	@Test
	void testSetJugadorPruebaNoHayIdioma() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Jugador jugador = new Jugador();
		String nombrevalido = "Antonio";
		int edadValida = 19;
		String idiomaValido = "";

		jugador.setNombreJugador(nombrevalido);
		jugador.setEdad(edadValida);
		jugador.setIdioma(idiomaValido);

		asignarEquipo.setJugador(jugador);

		Jugador jugadorGuardado = asignarEquipo.getJugador();

		assertNull(jugadorGuardado);
	}


	/**
	 * En este caso voy a probar que no exista.
	 */
	@Test
	void testSetEquipoNoExista() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();
		Equipo equipo = null;

		asignarEquipo.setEquipo(equipo);

		Equipo equipoGuardado = asignarEquipo.getEquipo();

		assertNull(equipoGuardado);
	}

	/**
	 * Voy a comprobar que el equipo exista.
	 */
	@Test
	void testAsignarEquipoExista() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();
		Equipo equipo = new Equipo();
		String nombreEquipo= "Los chancletas";
		int ranking = 3;

		equipo.setNombreEquipo(nombreEquipo);
		equipo.setRanking(ranking);

		asignarEquipo.setEquipo(equipo);
		assertEquals(asignarEquipo.getEquipo(),equipo);
	}

	/**
	 * Si existe, pero menos de 4 caracteres
	 */
	@Test
	void testSetEquipoExistaNoValidoMenos() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Equipo equipo = new Equipo();
		String nombreEquipo="Pac";
		int ranking = 3;
		equipo.setNombreEquipo(nombreEquipo);
		equipo.setRanking(ranking);

		asignarEquipo.setEquipo(equipo);

		assertNull(asignarEquipo.getEquipo());
	}

	/**
	 * Si existe, y tiene 4 caracteres exactos.
	 */
	@Test
	void testSetEquipoExistaValido() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Equipo equipo = new Equipo();
		String nombreEquipo="Juan";
		int ranking = 3;
		equipo.setNombreEquipo(nombreEquipo);
		equipo.setRanking(ranking);

		asignarEquipo.setEquipo(equipo);

		assertEquals(asignarEquipo.getEquipo(),equipo);
	}

	/**
	 * Si existe, y tiene mas de 4 caracteres .
	 */
	@Test
	void testSetEquipoExistaValidoMasDeCuatro() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Equipo equipo = new Equipo();
		String nombreEquipo="Antonio";
		int ranking = 3;

		equipo.setNombreEquipo(nombreEquipo);
		equipo.setRanking(ranking);

		asignarEquipo.setEquipo(equipo);

		assertEquals(asignarEquipo.getEquipo(),equipo);
	}


	/**
	 * Si existe, pero tiene mas de 20 caracteres .
	 */
	@Test
	void testSetEquipoExistaNoValidoMasDeVeinte() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();
		Equipo equipo = new Equipo();
		String nombreEquipo="Pacolpacolpacolpacolpoloco";
		int ranking = 3;
		equipo.setNombreEquipo(nombreEquipo);
		equipo.setRanking(ranking);

		asignarEquipo.setEquipo(equipo);


		Equipo equipoGuardado = asignarEquipo.getEquipo();

		assertNull(equipoGuardado);
	}

	/**
	 * Si existe equipo pero no tiene ranking
	 */
	@Test
	void testSetEquipoExistaSinRanking() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Equipo equipo = new Equipo();
		String nombreEquipo="Los Pacos";

		equipo.setNombreEquipo(nombreEquipo);

		asignarEquipo.setEquipo(equipo);

		Equipo equipoTemporal = asignarEquipo.getEquipo();

		assertNull(equipoTemporal);
	}

	/**
	 * Si existe, pero nombre está vacio
	 */
	@Test
	void testSetEquipoNombreVacio() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();
		Equipo equipo = new Equipo();
		String nombreEquipo="";
		int ranking = 4;

		equipo.setNombreEquipo(nombreEquipo);
		equipo.setRanking(ranking);

		asignarEquipo.setEquipo(equipo);

		Equipo equipoTemporal = asignarEquipo.getEquipo();

		assertNull(equipoTemporal);
	}

	/**
	 * Si existe, pero nombre es alfanumerico y por tanto invalido
	 */
	@Test
	void testSetEquipoExistaNombreInvalido() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Equipo equipoTemporal = new Equipo();
		String nombreEquipo = "Los Pirañas69";
		int ranking = 4;

		equipoTemporal.setNombreEquipo(nombreEquipo);
		equipoTemporal.setRanking(ranking);

		asignarEquipo.setEquipo(equipoTemporal);

		Equipo equipoGuardado = asignarEquipo.getEquipo();

		assertNull(equipoGuardado);

	}

	/**
	 * Si existe, pero ranking vacio
	 */
	@Test
	void testSetEquipoExistaRankingVacio() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Equipo equipo = new Equipo();
		String nombreEquipo="Los chancletas";

		equipo.setNombreEquipo(nombreEquipo);

		asignarEquipo.setEquipo(equipo);

		Equipo equipoGuardado = asignarEquipo.getEquipo();

		assertNull(equipoGuardado);

	}

	/**
	 * Si existe, pero ranking invalido
	 */
	@Test
	void testSetEquipoExistaRankingInvalido() {
		AsignarEquipo asignarEquipo = new AsignarEquipo();

		Equipo equipo = new Equipo();
		String nombreEquipo="Los Madriles";
		int ranking = 15;

		equipo.setNombreEquipo(nombreEquipo);
		equipo.setRanking(ranking);

		asignarEquipo.setEquipo(equipo);

		Equipo equipoGuardado = asignarEquipo.getEquipo();

		assertNull(equipoGuardado);
	}
}