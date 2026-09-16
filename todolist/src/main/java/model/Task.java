package model;


public abstract class Task {

    // una tarea tiene siempre una persona asociada (que tiene nombre, apellido, correo, dni)

    private long id;
    private String title;
    private int level;
    private boolean complete;
    private Person person;
    // constructor vacio
    public Task(){}
    public Task( String title, int level, Person person){
        this.title = title;
        this.level = level;
        this.person = person;
        // complete = false
    }

    public Task(String title, int level, String name, String surname, String email, String dni){
        this.id = id;
        this.title = title;
        this.level = level;
        this.person =new Person(name, surname, email, dni);
    }

    public void showData(){
        System.out.println("title = " + title);
        System.out.println("level = " + level);
        System.out.println("complete = " + complete);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public abstract void completeTask();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
