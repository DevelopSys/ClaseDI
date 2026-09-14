package model;

public class WorkTask extends Task{

    private String expirationDate;

    public WorkTask(String title, int level, Person person, String expirationDate) {
        super(title, level, person);
        this.expirationDate = expirationDate;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("expirationDate = " + expirationDate);
    }

    @Override
    public void completeTask() {
        System.out.println("Correo enviado a "+this.getPerson().getEmail());
        setComplete(true);
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
