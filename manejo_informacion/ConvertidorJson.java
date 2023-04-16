package manejo_informacion;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import modelos.Proveedor;
import modelos.Producto;

public class ConvertidorJson {
    private LectorJson lector=new LectorJson();
    

    /**
     * @return ArrayList de proveedores del archivo proveedores.json
     */
    public ArrayList<Proveedor> conseguirProveedores() throws Exception {
        ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
        JSONArray jsonArray = lector.leerProveedores();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            String nombre = (String) jsonObject.get("nombre");
            double precioEnvio = (double) jsonObject.get("precioEnvio");
            Proveedor p = new Proveedor(nombre, precioEnvio);
            proveedores.add(p);
        }
            return proveedores;
        }

    /**
     * @param nombre nombre del proveedor a buscar en el archivo productos.json
     * @return ArrayList de productos del proveedor
     */
    public ArrayList<Producto> conseguirProductos(String nombre) throws Exception {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        JSONArray jsonArray = lector.leerProductos(nombre);
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            String nombreProveedor = (String) jsonObject.get("proveedor");
            String nombreProducto = (String) jsonObject.get("nombre");
            double precio = (double) jsonObject.get("precio");
            int edad = (int)(long) jsonObject.get("edad");
            if (nombre.equals(nombreProveedor)) {
                Producto p = new Producto(nombreProducto, precio, edad);
                productos.add(p);
            }
        }
        return productos;
    }

}

