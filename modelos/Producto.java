package modelos;

public class Producto {

    private String nombre;
    private double precio;
    private int edad;

    public Producto(String nombre, double precio, int edad) {
        this.nombre = nombre;
        this.precio = precio;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - precio Base $"+ precio;
    }


    
}
