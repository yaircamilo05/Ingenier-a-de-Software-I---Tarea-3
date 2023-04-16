package control;
import java.util.ArrayList;
import java.util.Scanner;

import manejo_informacion.ConvertidorJson;
import modelos.*;

public class Control {

    private ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
    private ConvertidorJson convertidor = new ConvertidorJson();


    public static void main(String[] args) {
        Control c = new Control();
        c.buscarRegalo();
    }

    /**
     * Carga la informacion de los proveedores y los productos de cada proveedor
     * en sus respectivas listas
     */
    private void cargarInfo() throws Exception{
        this.proveedores = convertidor.conseguirProveedores();
        this.llenarProductos();
    }

    /**
     * Busca los productos que cumplan con la edad y el precio maximo ingresado por
     * el usuario
     */
    public void buscarRegalo() {
        try{
        this.cargarInfo();
        boolean encontrado = false;
        System.out.println("ingrese la edad de la persona");
        Scanner escaner = new Scanner(System.in);
        int edad = escaner.nextInt();
        System.out.println("ingrese el precio maximo del regalo");
        double precio = escaner.nextDouble();
        for (Proveedor proveedor : proveedores) {
            for (Producto producto : proveedor.buscarProductos(edad, precio)) {
                System.out.println(MensajeRegalo(producto, proveedor));
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se tiene productos para esa edad o precio");
        }
        escaner.close();
    }
    catch(Exception e){
        System.out.println("error al cargar la informacion");
    }
}

    /**
     * @param producto producto a regalar
     * @param proveedor proveedor del producto
     * @return String con el mensaje de regalo
     */
    public String MensajeRegalo(Producto producto, Proveedor proveedor) {
        return "el regalo es: " + producto.toString() + " precio de envio $" + proveedor.getPrecioEnvio()
                + " precio total $" + (producto.getPrecio() + proveedor.getPrecioEnvio());
    }

    /**
     * llena los productos de cada proveedor
     */
    private void llenarProductos() throws Exception{
        for (Proveedor proveedor : proveedores) {
            proveedor.setProductos(convertidor.conseguirProductos(proveedor.getNombre()));
        }
    }

}
