import java.util.InputMismatchException;

import javax.swing.JOptionPane;
//https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-user-input-with-a-Swing-JOptionPane-example

public class Main {
    /*
     * public static final String
     * RESET = "\u001B[0m",
     * WHITE = "\u001B[37m",
     * BLACK = "\u001B[30m",
     * RED = "\u001B[31m",
     * GREEN = "\u001B[32m",
     * YELLOW = "\u001B[33m",
     * BLUE = "\u001B[34m",
     * PURPLE = "\u001B[35m",
     * CYAN = "\u001B[36m";
     */

    public static final float salarioMin = 1423500;
    public static int IdEmpleados = 0;

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
                                                "¿Cuál es el ID del empleado a eliminar?"))));
                        lista.Imprimir();
                        break;
                    case 5:
                        // ordenar por Nombre

                        break;
                    case 6:
                        // Ordenar por Salario

                        break;
                    case 7:
                        // Calcular promedio salario

                        break;
                    case 8:
                        // Encontrar maximo

                        break;
                    case 9:
                        // Encontrar minimo

                        break;
                    case 10:
                        // Obtener mediana de Salario

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

    public static byte AbrirMenu(ListaDoble listaDoble) {
        try {

            String sOpcion = JOptionPane.showInputDialog(
                """
                Menú:
                1. Añadir empleado a la lista
                2. Imprimir lista
                3. Buscar dato
                4. Eliminar dato
                5. Mostrar características
                6. Ordenar lista ascendente
                7. Ordenar lista descendente
                8. Calcular la suma de los datos
                9. Calcular el producto de los datos
                10. Calcular el Rango de los Datos
                0. Salir
                """ + listaDoble.MostrarCaracteristicas()
            );

            if (sOpcion == null) {
                return 0;
            } else if (sOpcion.isBlank() || sOpcion.isEmpty()) {
                return -1;
            } else {
                return Byte.parseByte(sOpcion);
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error al AbrirMenu:\n" + e);
        }
    }

}