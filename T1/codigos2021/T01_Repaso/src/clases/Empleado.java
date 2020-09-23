package clases;

public interface Empleado {

    // variables --> const (MAY)
    // metodos --> son abstract
    // metodo --> default
    String NOMBRE_EMPRESA = "RETAMAR";

    default String porDefecto(){
        return  "Soy un trabajador "+NOMBRE_EMPRESA;
    }
    void fichar();
    int cobrar();

}
