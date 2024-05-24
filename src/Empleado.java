import java.util.ArrayList;

public class Empleado implements IFileLectura {
    private String nombre;
    private int edad;
    private String email;

    private ArrayList<Empleado> empleadoEmigrados = new ArrayList<Empleado>();

    private int indexNombre = -1;
    private int indexEdad = -1;
    private int indexEmail = -1;

    public Empleado() {
    }

    public Empleado(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Empleado> getEmpleadoEmigrados() {
        return empleadoEmigrados;
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
                case "Email":
                    indexEmail = i;
                    break;
            }
        }
    }

    // Proceso de empleados
    @Override
    public void leerLinea(String linea, int numLinea) {
        if (numLinea == 1) {
            asignarIndices(linea);
        } else {
            Empleado empleado = new Empleado();
            empleadoEmigrados.add(empleado);
            String[] splitValueCampo = linea.split(",");
            for (int i = 0; i < splitValueCampo.length; i++) {
                String valor = splitValueCampo[i].trim();
                if (i == indexNombre) {
                    empleado.setNombre(valor);
                }
                else if (i == indexEdad) {
                    empleado.setEdad(Integer.parseInt(valor));
                }
                else if (i == indexEmail) {
                    empleado.setEmail(valor);
                }
            }
        }
    }

}
