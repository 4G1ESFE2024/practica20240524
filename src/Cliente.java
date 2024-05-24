import java.util.ArrayList;

public class Cliente implements IFileLectura {
    private String nombre;
    private int edad;

    private ArrayList<Cliente> clienteEmigrados = new ArrayList<Cliente>();

    private int indexNombre = -1;
    private int indexEdad = -1;
    public Cliente() {
    }
    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public ArrayList<Cliente> getClienteEmigrados() {
        return clienteEmigrados;
    }
    private void asignarIndices(String linea) {
        String[] splitNameCampo = linea.split(",");
        for (int i = 0; i < splitNameCampo.length; i++) {
            String campo = splitNameCampo[i];
            switch (campo) {
                case "Nombre":
                    indexNombre = i;
                    break;
                case "Edad":
                    indexEdad = i;
                    break;               
            }
        }
    }
    @Override
    public void leerLinea(String linea, int numLinea) {       
        if (numLinea == 1) {
            asignarIndices(linea);
        } else {
            Cliente cliente = new Cliente();
            clienteEmigrados.add(cliente);
            String[] splitValueCampo = linea.split(",");
            for (int i = 0; i < splitValueCampo.length; i++) {
                String valor = splitValueCampo[i].trim();
                if (i == indexNombre) {
                    cliente.setNombre(valor);
                }
                else if (i == indexEdad) {
                    cliente.setEdad(Integer.parseInt(valor));
                }                
            }
        }
    }

}
