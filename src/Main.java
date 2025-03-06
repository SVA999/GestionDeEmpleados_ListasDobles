import javax.swing.JOptionPane;
//https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-user-input-with-a-Swing-JOptionPane-example

public class Main {
/*
    public static final String RESET = "\u001B[0m",
            WHITE = "\u001B[37m",
            BLACK = "\u001B[30m",
            RED = "\u001B[31m",
            GREEN = "\u001B[32m",
            YELLOW = "\u001B[33m",
            BLUE = "\u001B[34m",
            PURPLE = "\u001B[35m",
            CYAN = "\u001B[36m";
*/
    public static void main(String[] args) {

        try {

            System.out.println("\nMenú:");
            System.out.println("1. Ingresar datos a la lista");
            System.out.println("2. Imprimir lista");
            System.out.println("3. Ordenar lista ascendente");
            System.out.println("4. Ordenar lista descendente");
            System.out.println("5. Mostrar características");
            System.out.println("6. Buscar dato");
            System.out.println("7. Eliminar dato");
            System.out.println("8. Calcular la suma de los datos");
            System.out.println("9. Calcular el producto de los datos");
            System.out.println("10. Calcular el Rango de los Datos");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción: ");

            switch (opcion) {
                case 1:
                    System.out.print(PURPLE + "\tIngrese el dato: ");
                    int dato = scanner.nextInt();
                    lista.insertar(dato);
                    break;
                case 2:
                    lista.imprimir();
                    break;
                case 3:
                    lista.ordenarAscendente();
                    lista.imprimir();
                    break;
                case 4:
                    lista.ordenarDescendente();
                    lista.imprimir();
                    break;
                case 5:
                    lista.mostrarCaracteristicas();
                    break;
                case 6:
                    System.out.print(PURPLE + "\t¿Cuál es el dato a buscar? ");
                    int datoBuscar = scanner.nextInt();
                    lista.buscarDato(datoBuscar);
                    break;
                case 7:
                    System.out.print(PURPLE + "\t¿Cuál es el dato a eliminar? ");
                    int datoEliminar = scanner.nextInt();
                    lista.eliminarDato(datoEliminar);
                    lista.imprimir();
                    break;
                case 8:
                    System.out.println(PURPLE + "\t"+lista.calcularSuma());
                    break;
                case 9:
                    System.out.println(PURPLE + "\t"+lista.calcularProducto());
                    break;
                case 10:
                System.out.println(PURPLE + "\t"+lista.calcularRango());
                    break;
                case 0:
                    System.out.println(YELLOW + "\tSaliendo del programa..." + RESET);
                    break;
                default:
                    System.out.println(RED + "\tOpción inválida." + RESET);
            }



            String name = JOptionPane.showInputDialog("What is your name?");

            JOptionPane.showMessageDialog(null, name);

            var yesOrNo = JOptionPane.showConfirmDialog(null, "What will it be?");
            if (yesOrNo == 0) {
                JOptionPane.showMessageDialog(null, "You chose yes!");
            }
            if (yesOrNo == 1) {
                JOptionPane.showMessageDialog(null, "You chose no.");
            }
            if (yesOrNo == 2) {
                JOptionPane.showMessageDialog(null, "You chose to cancel!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR:\n"+e);
        }
    }
}
