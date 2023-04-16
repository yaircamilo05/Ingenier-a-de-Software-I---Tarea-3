package modelos;

import java.util.ArrayList;


public class Proveedor {

    String nombre;
    double precioEnvio;
    ArrayList<Producto> Productos;

    public Proveedor(String nombre, double precioEnvio) {
        this.nombre = nombre;
        this.precioEnvio = precioEnvio;
        this.Productos = new ArrayList<Producto>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public void setProductos(ArrayList<Producto> Productos) {
        this.Productos = Productos;
    }

    public ArrayList<Producto> buscarProductos(int edad, double precio) {
        ArrayList<Producto> ProductosEncontrados = new ArrayList<Producto>();
        for (Producto Producto : Productos) {
            if (Producto.getEdad() == edad && Producto.getPrecio() < precio) {
                ProductosEncontrados.add(Producto);
            }
        }
        return ProductosEncontrados;
    }

    }

    

