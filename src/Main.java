import javax.swing.JOptionPane;

public class Main {

    public static final float salarioMin = 1423500;
    public static int IdEmpleados = 1;

    public static void main(String[] args) {

        try {
            // ListaDoble
            ListaDoble lista = new ListaDoble();

            byte opcion;

            do {
                opcion = AbrirMenu(lista);

                switch (opcion) {
                    case 1:
                        // Insertar
                        JOptionPane.showMessageDialog(null, lista.InsertarEmpleado(new Empleado(
                                JOptionPane.showInputDialog(null, "Ingresa el nombre"),
                                Float.parseFloat(JOptionPane.showInputDialog(null, "Ingresa el salario")))));
                        break;
                    case 2:
                        // Imprimir
                        JOptionPane.showMessageDialog(null, lista.Imprimir());
                        break;
                    case 3:
                        // Buscar
                        JOptionPane.showMessageDialog(null,
                                lista.BuscarEmpleado(
                                        Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "¿Cuál es el ID del empleado a buscar?"))));
                        break;
                    case 4:
                        // Eliminar
                        JOptionPane.showMessageDialog(null,
                                lista.EliminarEmpleado(
                                        Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "¿Cuál es el ID del empleado a eliminar?\n")))
                                        + lista.Imprimir());
                        break;
                    case 5:
                        // Ordenar por Nombre
                        JOptionPane.showMessageDialog(null,
                                lista.OrdenarPorNombre(
                                        Boolean.parseBoolean(JOptionPane.showInputDialog(null,
                                                "Ordenamiento por Nombre: " + "\ntrue - Ordenamiento Ascendente"
                                                        + "\nfalse - Ordenamiento Descendente\n")
                                                .toLowerCase()))
                                        + lista.Imprimir());
                        break;
                    case 6:
                        // Ordenar por Salario
                        JOptionPane.showMessageDialog(null,
                        lista.OrdenarPorSalario(
                                Boolean.parseBoolean(JOptionPane.showInputDialog(null,
                                        "Ordenamiento por Salario: " + "\ntrue - Ordenamiento Ascendente"
                                                + "\nfalse - Ordenamiento Descendente\n")
                                        .toLowerCase()))
                                + "\n"+lista.Imprimir());
                        break;
                        case 7:
                        // Calcular promedio salario
                        JOptionPane.showMessageDialog(null, "El promedio de los empleados es de: " + 
                        lista.calcular_promedio_salario());
                        break;
                    case 8:
                        // Encontrar maximo
                        JOptionPane.showMessageDialog(null, "El empleado con el salario más alto es " +
                        lista.encontrar_salario_maximo());
                        break;
                    case 9:
                        // Encontrar minimo
                        JOptionPane.showMessageDialog(null, "El empleado con el salario más bajo es " + 
                        lista.encontrar_salario_minimo());
                        break;
                    case 10:
                        // Obtener mediana de Salario
                        JOptionPane.showMessageDialog(null, "La mediana de los salarios es " 
                        + lista.obtener_mediana_salario());
                        break;
                    case 11:
                        // Cargar datos
                        JOptionPane.showMessageDialog(null, lista.CargarDatos());
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "\tSaliendo del programa...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "\tOpción inválida.");
                }
            } while (opcion != 0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:\n" + e);
        }
    }

    // --------------------- METODOS ----------------------//

    public static byte AbrirMenu(ListaDoble listaDoble) throws Exception{
        try {

            String sOpcion = JOptionPane.showInputDialog(
                    """
                        Menú:
                            --- Operaciones ---
                            
                            1. Añadir empleado a la lista
                            2. Imprimir lista
                            3. Buscar dato
                            4. Eliminar dato

                            --- Consultas ---

                            5. Ordenar por nombre
                            6. Ordenar por salario
                            7. Calcular el salario promedio
                            8. Encuentra el empleado con el salario máximo
                            9. Encuentra el empleado con el salario mínimo
                            10. Calcula la mediana de los salarios

                            11. Cargar datos
                            0. Salir
                            """ + listaDoble.MostrarCaracteristicas());

            if (sOpcion == null) {
                return 0;
            } else if (sOpcion.isBlank() || sOpcion.isEmpty()) {
                return -1;
            } else {
                return Byte.parseByte(sOpcion);
            }

        } catch (Exception e) {
            throw new Exception("Error al AbrirMenu:\n" + e);
        }
    }

}