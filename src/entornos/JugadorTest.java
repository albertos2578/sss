package entornos;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JugadorTest {

    /*--------NOMBRE------*/

    // Test para comprobar que no venga vacio

    @Test
    void setNombreJugadorVacio() {
        Jugador jugador = new Jugador();
        String nombre = "";
        jugador.setNombreJugador(nombre);
        assertNull(jugador.getNombreJugador());
    }


    // Test para revisar que el nombre del jugador que se guarde sea en mayusculas

    @Test
    void setNombreJugadorEnMayusculas() {
        Jugador jugador = new Jugador();
        String nombre = "CARACTERES";
        jugador.setNombreJugador(nombre);
        assertEquals(nombre,jugador.getNombreJugador());
    }


    // Test para revisar que si el nombre del jugador esta en minusculas SE GUARDA

    @Test
    void setNombreJugadorEnMinusculas() {
        Jugador jugador = new Jugador();
        String nombre = "caracteres";
        jugador.setNombreJugador(nombre);

        nombre = nombre.toUpperCase();
        assertEquals(nombre,jugador.getNombreJugador());
    }

    // Test para revisar el tipo de caracteres, deben ser de tipo texto

    @Test
    void setNombreJugadorValidoCaracteres() {
        Jugador jugador = new Jugador();
        String nombre = "Caracteres";
        jugador.setNombreJugador(nombre);

        nombre = nombre.toUpperCase();
        assertEquals(nombre,jugador.getNombreJugador());
    }

    // Test para revisar el tipo de contenido erroneo, ser revisa que el campo contenga valores no valido

    @Test
    void setNombreJugadorCaracteresNoValidos() {
        Jugador jugador = new Jugador();
        String nombre = "12345";
        jugador.setNombreJugador(nombre);
        assertEquals(null,jugador.getNombreJugador());
    }

    // Test para que tenga menos del mínimo de 4 caracteres

    @Test
    void setTestNombreJugadorCaracterMenorACuatro() {
        Jugador jugador = new Jugador();
        String nombre = "Ana";
        jugador.setNombreJugador(nombre);
        assertEquals(null,jugador.getNombreJugador());
    }

    // Test para que tenga  4 caracteres exactos

    @Test
    void setTestNombreJugadorIgualAlMinimo() {
        Jugador jugador = new Jugador();
        String nombre = "Juan";

        jugador.setNombreJugador(nombre);

        nombre = nombre.toUpperCase();
        assertEquals(nombre,jugador.getNombreJugador());
    }

    // Test para que tenga mas de 4 caracteres

    @Test
    void setTestNombreJugadorMasDelMinimo() {
        Jugador jugador = new Jugador();
        String nombre = "Pedro"; // La prueba
        jugador.setNombreJugador(nombre);

        nombre = nombre.toUpperCase();
        assertEquals(nombre,jugador.getNombreJugador());
    }

    // Test para que tenga igual al maximo (20)

    @Test
    void setTestNombreJugadorMenosDelMaximo() {
        Jugador jugador = new Jugador();
        String nombre = "qwertyuiopasdfghjkln"; // La prueba
        jugador.setNombreJugador(nombre);

        nombre = nombre.toUpperCase();
        assertEquals(nombre,jugador.getNombreJugador());
    }

    // Test para que tenga mas al maximo (20)

    @Test
    void setTestNombreJugadorMasDelMaximo() {
        Jugador jugador = new Jugador();
        String nombre = "qwertyuiopasdfghjklñr"; // La prueba
        jugador.setNombreJugador(nombre);

        assertNull(jugador.getNombreJugador());
    }

    /*--------EDAD-------*/

    // Test para revisar el tipo de caracteres, deben ser de tipo entero

    @Test
    void setEdadJugadorValidoCaracteres() {
        Jugador jugador = new Jugador();
        int edad = 50;
        jugador.setEdad(edad);

        assertEquals(edad,jugador.getEdad());
    }

    // Test para revisar el tipo de contenido erroneo, ser revisa que el campo contenga valores no valido

    @Test
    void setEdadJugadorCaracteresNoValidos() {
        Jugador jugador = new Jugador();

        assertThrows(NumberFormatException.class, () -> {
            int edad = Integer.parseInt("Hola");
            jugador.setEdad(edad);
        },"Solo puedes guardar números");

    }

    // Test para revisar el minimo de edad

    @Test
    void setEdadJugadorEdadMinimo() {
        Jugador jugador = new Jugador();
        int edad = 18;
        jugador.setEdad(edad);
        assertEquals(edad,jugador.getEdad());
    }

    // Test para revisar la edad maxima de un jugador

    @Test
    void setEdadJugadorEdadMaxima() {
        Jugador jugador = new Jugador();
        int edad = 100;
        jugador.setEdad(edad);
        assertEquals(edad,jugador.getEdad());
    }

    // Test para revisar la edad menor a la edad minima de un jugador

    @Test
    void setEdadJugadorEdadMenorEdadMinima() {
        Jugador jugador = new Jugador();
        int edad = 17;
        jugador.setEdad(edad);
        assertEquals(0,jugador.getEdad());
    }

    // Test para revisar la edad mayor que a la edad maxima de un jugador

    @Test
    void setEdadJugadorEdadMayorEdadMaxima() {
        Jugador jugador = new Jugador();
        int edad = 101;
        jugador.setEdad(edad);
        assertEquals(0,jugador.getEdad());
    }

    // Test para revisar la edad negativa de un jugador

    @Test
    void setEdadJugadorEdadNegativa() {
        Jugador jugador = new Jugador();
        int edad = -15;
        jugador.setEdad(edad);
        assertEquals(0,jugador.getEdad());
    }


    /*-------IDIOMA------*/

    // Test para revisar el idioma de un jugador correctamente

    @Test
    void setIdiomaJugadorPositivo() {
        Jugador jugador = new Jugador();
        String idioma = "Aleman";
        jugador.setIdioma(idioma);
        assertEquals(idioma, jugador.getIdioma());
    }

    // Test para revisar que se ha cpgido los 4 idiomas maximos validos

    @Test
    void setIdiomaJugadorTodosLosIdiomas() {
        Jugador jugador = new Jugador();
        String aleman = "Aleman";
        String ingles = "Ingles";
        String espanol = "Espanol";
        String frances = "Frances";

        jugador.setIdioma(aleman);
        jugador.setIdioma(jugador.getIdioma()+ingles);
        jugador.setIdioma(jugador.getIdioma()+espanol);
        jugador.setIdioma(jugador.getIdioma()+frances);
        assertEquals(aleman+ingles+espanol+frances, jugador.getIdioma());
    }

    // Test para revisar que se ha cogido entre 1 y 4 idiomas

    @Test
    void setIdiomaJugadorEntreUnoYCuatroIdiomas() {
        Jugador jugador = new Jugador();
        String ingles = "Ingles";
        String espanol = "Espanol";

        jugador.setIdioma(ingles);
        jugador.setIdioma(jugador.getIdioma()+espanol);

        assertEquals(ingles+espanol, jugador.getIdioma());
    }

    // Test para revisar que de error dejar el campo vacio

    @Test
    void setIdiomaJugadorNegativoVacio() {
        Jugador jugador = new Jugador();
        String vacio = "";
        jugador.setIdioma(vacio);
        assertNull(jugador.getIdioma());
    }


    // Test para revisar que no se pueda coger un idioma erroneo

    @Test
    void setIdiomaJugadorNegativoErroneo() {
        Jugador jugador = new Jugador();
        String idioma = "Chino";
        jugador.setIdioma(idioma);
        assertNull(jugador.getIdioma());
    }

    /*--------TIPO-------*/

    // Test para revisar que si sale del rango de tipo, da null

    @Test
    void testTipoJugadorNull() {
        Jugador jugador = new Jugador();
        String nombreJugador = "Antonio";
        String idioma = "Español";
        int edad = 17;

        jugador.setNombreJugador(nombreJugador);
        jugador.setIdioma(idioma);
        jugador.setEdad(edad);

        assertNull(null,jugador.getTipoJugador());
    }

    // Test para revisar minimo del rango de tipo Junior

    @Test
    void testTipoJugadorMenorRangoJunior() {
        Jugador jugador = new Jugador();
        String nombreJugador = "Antonio";
        String idioma = "Español";
        int edad = 18;

        jugador.setNombreJugador(nombreJugador);
        jugador.setIdioma(idioma);
        jugador.setEdad(edad);

        assertEquals("Junior", jugador.getTipoJugador());
    }

    // Test para revisar maximo del rango de tipo Junior

    @Test
    void testTipoJugadorMaximoRangoJunior() {
        Jugador jugador = new Jugador();
        String nombreJugador = "Antonio";
        int edad = 25;
        String idioma = "Español";


        jugador.setNombreJugador(nombreJugador);
        jugador.setEdad(edad);
        jugador.setIdioma(idioma);


        assertEquals("Junior", jugador.getTipoJugador());
    }

    // Test para revisar minimo del rango de tipo Senior

    @Test
    void testTipoJugadorMenorRangoSenior() {
        Jugador jugador = new Jugador();
        String nombreJugador = "Antonio";
        String idioma = "Español";
        int edad = 26;

        jugador.setNombreJugador(nombreJugador);
        jugador.setIdioma(idioma);
        jugador.setEdad(edad);

        assertEquals("Senior", jugador.getTipoJugador());
    }

    // Test para revisar maximo del rango de tipo Senior

    @Test
    void testTipoJugadorMayorRangoSenior() {
        Jugador jugador = new Jugador();
        String nombreJugador = "Antonio";
        String idioma = "Español";
        int edad = 35;

        jugador.setNombreJugador(nombreJugador);
        jugador.setIdioma(idioma);
        jugador.setEdad(edad);

        assertEquals("Senior", jugador.getTipoJugador());
    }

    // Test para revisar minimo del rango de tipo Master

    @Test
    void testTipoJugadorMenorRangoMaster() {
        Jugador jugador = new Jugador();
        String nombreJugador = "Antonio";
        String idioma = "Español";
        int edad = 36;

        jugador.setNombreJugador(nombreJugador);
        jugador.setIdioma(idioma);
        jugador.setEdad(edad);

        assertEquals("Master", jugador.getTipoJugador());
    }

    // Test para revisar medio del rango de tipo Master

    @Test
    void testTipoJugadorRangoMayoDeMaster() {
        Jugador jugador = new Jugador();
        String nombreJugador = "Antonio";
        String idioma = "Español";
        int edad = 50;

        jugador.setNombreJugador(nombreJugador);
        jugador.setIdioma(idioma);
        jugador.setEdad(edad);

        assertEquals("Master", jugador.getTipoJugador());
    }
}