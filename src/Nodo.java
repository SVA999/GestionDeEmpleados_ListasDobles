public class Nodo {
    Empleado empleado;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(Empleado empleado){
        this.empleado=empleado;
        siguiente=null;
        anterior=null;
    }
}