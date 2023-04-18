package manejo_informacion;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class LectorJson{
    private final String UBICACIONPROVEEDORES="./data/proveedores.json";
    private final String UBIACACIONPRODUCTOS="./data/productos.json";

    /**
     * Lee el archivo proveedores.json y lo convierte en un JSONArray
     * @return JSONArray con los proveedores
     */
    public JSONArray leerProveedores()throws Exception {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(this.UBICACIONPROVEEDORES);
        Object obj = parser.parse(reader);
        JSONArray jsonArray = (JSONArray) obj;
        return jsonArray;
    }

   
    /**
     * Lee el archivo productos.json y lo convierte en un JSONArray
     * @return JSONArray con los productos
     */
    public JSONArray leerProductos(String nombre) throws Exception {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(this.UBIACACIONPRODUCTOS);
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;
            return jsonArray;
    }
}


