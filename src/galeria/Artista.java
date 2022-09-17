package galeria;

import java.util.ArrayList;

public class Artista {

    String nombre, fecha, nacionalidad;
    
    ArrayList obras = new ArrayList();

    public Artista(String nom, String fec, String nac) {
        nombre = nom;
        fecha = fec;
        nacionalidad = nac;
        ArrayList obras = new ArrayList();
        
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    

}
