import database.GestionDB;
import model.Prioridad;
import model.Tarea;
import model.TareaOcio;
import model.TareaTrabajo;

import java.sql.*;
import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
        //TareaOcio tareaOcio1 = new TareaOcio();
        TareaOcio tareaOcio2 = new TareaOcio(1,"Tarea Ocio", "Descripcion","Enero2024",
                Prioridad.alta, "Pozuelo", 1000);
        TareaOcio tareaOcio1 = new TareaOcio(2,"Tarea Ocio", "Descripcion","Enero2024",
                Prioridad.alta, "Pozuelo", 40);
        TareaTrabajo tareaTrabajo1 = new TareaTrabajo(3, "Tarea Trabajo","Ejemplo de tarea trabajo",
                "Febrero 2024",Prioridad.alta,"Desarrollo Web");
        TareaTrabajo tareaTrabajo2 = new TareaTrabajo(3, "Tarea Trabajo","Ejemplo de tarea trabajo",
                "Febrero 2024",Prioridad.alta,"Movil");

        // acceso a la base de datos
        Connection connection = new GestionDB().getConnection();

        // insertar datos en la bd
        try {
            Statement statement = connection.createStatement();
            // execute - bool
            // executeUpdate - int
            // INSERT INTO tareas (titulo, descripcion, completada)
            //  VALUES ('Titulo1','Descripcion1',false)
            //String queryFormat = "INSERT INTO tareas (titulo, descripcion, completa) VALUES ('%s','%s',%b)";
            //statement.execute(String.format(queryFormat,"TituloFormat","DescripFormat",false));
            /*PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tareas (titulo, descripcion," +
                    " completa) VALUES (?,?,?)");
            preparedStatement.setString(1,"TituloPS");
            preparedStatement.setString(2,"DescriptionPS");
            preparedStatement.setBoolean(3,false);
            preparedStatement.execute();*/
            Statement statement1 = connection.createStatement();
            // SELECT * FROM tareas WHERE FECHA > 123123 AND COMPLETADA = 1
            ResultSet resultado = statement1.executeQuery("SELECT * FROM tareas");
            while (resultado.next()){
                String titulo = resultado.getString("titulo");
                String descripcion = resultado.getString("descripcion");
                System.out.println(titulo+" "+descripcion);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //tareaOcio1.agregarSubtarea(tareaOcio2);
        //tareaOcio1.agregarSubtarea(tareaTrabajo1);
        //tareaOcio1.agregarSubtarea(tareaTrabajo2);

        /*ArrayList<Tarea> tareasGenerales = new ArrayList<>();
        tareasGenerales.add(tareaOcio2);
        tareasGenerales.add(tareaOcio1);
        tareasGenerales.add(tareaTrabajo1);
        tareasGenerales.add(tareaTrabajo2);

        for ( Tarea item : tareasGenerales ) {
            item.completar();
        }*/

    }
}
