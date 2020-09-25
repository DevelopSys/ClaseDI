package sistema;

import java.util.Enumeration;
import java.util.Hashtable;

public class Sistema {

    private Hashtable<String, Persona> listaSistema;
    private String personaActual;

    public Sistema(){
        listaSistema = new Hashtable();
    }

    public void registrarUsuario(Persona persona){
        if(listaSistema.containsKey(persona.getNombre())){
            System.out.println("No puedo añadirlo");
        } else {
            listaSistema.put(persona.getNombre(), persona);
            System.out.println("Añadido correctamente");
        }
    }
    public void listarUsuarios(){
        // keys() --> todas las clases y con ellas accedo a los valores
        /*Enumeration<String> claves = listaSistema.keys();
        while(claves.hasMoreElements()){
            String key = claves.nextElement();
            Persona item = listaSistema.get(key);
            System.out.println(item);
        }*/

        for (Persona persona:listaSistema.values()) {
            System.out.println(persona);
        }
    }
    public boolean buscarUsuario(String nombre){
        if (listaSistema.containsKey(nombre)){
            Persona persona = listaSistema.get(nombre);
            System.out.println(persona);
            return true;
        }else {
            System.out.println("no lo encuentro");
            return false;
        }
    }
    public void logear(Persona persona){
        if (personaActual.equals(persona.getNombre())){

        } else {
            personaActual = persona.getNombre();
            // reseteo
        }


        if (listaSistema.containsKey(persona.getNombre())){
            Persona personaLogin = listaSistema.get(persona.getNombre());
            if (personaLogin.getPass().equals(persona.getPass())){
                System.out.println("Acceso OK");
            }else {
                System.out.println("Acceso incorrecto");
            }
        }else {
            System.out.println("No está en el sistema");
        }
    }

    public Hashtable<String, Persona> getListaSistema() {
        return listaSistema;
    }
}
