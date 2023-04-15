import java.util.ArrayList;
import java.util.Scanner;

public class Control {

    ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();

    public static void main(String[] args) {
        Control c = new Control();
        c.buscarRegalo();
    }

    /**
     * Carga la informacion de los proveedores y sus productos
     */
    public void cargarInfo() {
        ConvertidorJson convertidor = new ConvertidorJson();
        this.proveedores = convertidor.leerProveedores();
        for (Proveedor proveedor : proveedores) {
            proveedor.setProductos(convertidor.leerProductos(proveedor.getNombre()));
        }
    }

    /**
     * Busca los productos que cumplan con la edad y el precio maximo ingresado por
     * el usuario
     */
    public void buscarRegalo() {
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

    /**
     * @param producto producto a regalar
     * @param proveedor proveedor del producto
     * @return String con el mensaje de regalo
     */
    public String MensajeRegalo(Producto producto, Proveedor proveedor) {
        return "el regalo es: " + producto.toString() + " precio de envio $" + proveedor.getPrecioEnvio()
                + " precio total $" + (producto.getPrecio() + proveedor.getPrecioEnvio());
    }

}
