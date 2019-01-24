## JavaFX
### Tareas inciales -- 

1. Crear una clase que extienda de Application y sobreescribir el método start
````
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}
````
2. Crear un objeto de tipo Parent que infle la vista creada con el formato fxml. Asignarla a una scene y esta asignarla al primaryStage

````
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("vista/welcome.fxml"));
        primaryStage.setTitle("Welcome to School Managment");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
````
3. En el método main llamar a la clase mediante el método launch()

````
public class Main extends Application {

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("vista/welcome.fxml"));
        primaryStage.setTitle("Welcome to School Managment");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

````