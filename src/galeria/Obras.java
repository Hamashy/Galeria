package galeria;

public class Obras {

    String nombre, descripcion;
    int precio;
    
    

    public Obras(String nom, String des, int prec) {
        nombre = nom;
        descripcion = des;
        precio = prec;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
