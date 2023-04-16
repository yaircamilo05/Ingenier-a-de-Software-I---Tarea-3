package manejo_informacion;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class LectorJson{

    /**
     * Lee el archivo proveedores.json y lo convierte en un JSONArray
     * @return JSONArray con los proveedores
     */
    public JSONArray leerProveedores() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("./data/proveedores.json")) {
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;
            return jsonArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

   
    /**
     * Lee el archivo productos.json y lo convierte en un JSONArray
     * @return JSONArray con los productos
     */
    public JSONArray leerProductos(String nombre) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("./data/productos.json")) {
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;
            return jsonArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


