package model;

public class PersonalTask extends Task {

    private String location;

    public PersonalTask() {
    }

    public PersonalTask(String title, int level, Person person, String location) {
        super(title, level, person);
        this.location = location;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("location = " + location);
    }

    @Override
    public void completeTask() {
        if (isComplete()) {
            System.out.println("la tarea ya esta completada");
        } else {
            System.out.println("Esta tarea es personal, por lo tanto esta completada por defecto");
            setComplete(true);
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
