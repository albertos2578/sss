package entornos;

public class AsignarEquipo {
    private Equipo equipo;
    private Jugador jugador;

    public void setEquipo(Equipo equipo) {
          if (isEquipoValidated(equipo)){
                if (hasString(equipo.getNombreEquipo())){
                      if (hasInt(equipo.getRanking())){
                            this.equipo = equipo;
                      }
                }
          }
    }

    public Equipo getEquipo(){
          return this.equipo;
    }

    public void setJugador(Jugador jugador) {
          //Comprobamos si viene null
          if (isJugadorValidated(jugador)){
                if (hasString(jugador.getNombreJugador())){
                      if (hasInt(jugador.getEdad())){
                            if (hasString(jugador.getIdioma())) {
                                  this.jugador = jugador;
                            }
                      }
                }
          }
    }



    public Jugador getJugador() {
          return this.jugador;
    }

    //Nos devuelve un true si es distinto a nulo.
    private Boolean isJugadorValidated(Jugador comprobar) {
          boolean validated = true;

          if (comprobar == null) {
                validated = false;
          } else {
                validated = true;
          }

          return validated;
    }

    private Boolean isEquipoValidated(Equipo comprobar) {
          boolean validated = true;

          if (comprobar == null) {
                validated = false;
          } else {
                validated = true;
          }

          return validated;
    }

    private boolean hasInt(int rank){
          boolean hasRanking = true;

          if (rank != 0){
                hasRanking = true;
          } else {
                hasRanking = false;
          }

          return hasRanking;
    }

    private boolean hasString(String name){
          boolean hasName = true;

          if (name != null){
                if (name.length()>0){
                      hasName = true;
                } else {
                      hasName = false;
                }
          } else {
                hasName = false;
          }
          return hasName;
    }

}
