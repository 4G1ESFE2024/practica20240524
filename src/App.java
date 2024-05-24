import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Empleado empleado = new Empleado();
        leerArchivo("datos.csv", empleado);
        System.out.println("********* EMPLEADOS *********");
        for (Empleado item : empleado.getEmpleadoEmigrados()) {
            String msg = "Nombre: " + item.getNombre();
            msg += " Edad: " + item.getEdad();
            msg += " Email: " + item.getEmail();
            System.out.println(msg);
        }

        Cliente cliente=new Cliente();
        leerArchivo("clientes.csv", cliente);
        System.out.println("********* CLIENTES *********");
        for (Cliente item : cliente.getClienteEmigrados()) {
            String msg = "Nombre: " + item.getNombre();
            msg += " Edad: " + item.getEdad();         
            System.out.println(msg);
        }
    }

    static void leerArchivo(String ruta, IFileLectura iFileLectura) {
        try {
            File myObj = new File(ruta);
            Scanner myReader = new Scanner(myObj);
            int numLinea = 1;
            while (myReader.hasNextLine()) {
                String linea = myReader.nextLine();
                iFileLectura.leerLinea(linea, numLinea);
                numLinea++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
