package model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Agenda {

    private ArrayList<Usuario> listaUsuarios;

    public Agenda() {
        listaUsuarios = new ArrayList<>();
    }

    // addUser
    public boolean agregarUsuario(Usuario usuario) {
        //listaUsuarios.add(usuario);
        // solo puedo agregar usuarios que no esten ya en la lista
        // no pueden existir usuarios con el mismo id -> en un método
        if (listaUsuarios.size()==0){
            return listaUsuarios.add(usuario);
        } else {
            if (existeUsuario(usuario.getId()) == null) {
                // el usuario no existe, por lo tanto agrego
                return listaUsuarios.add(usuario);

            } else {
                return false;
            }
        }

        // en el caso de tener un usuario con el mismo id -> mensaje desde el main
        // en el caso de agregar al usuario -> mensaje desde el main
    }

    public boolean verDetalleUsuario(int id) {
        if (existeUsuario(id) != null) {
            existeUsuario(id).mostrarDatos();
            return true;
        }

        return false;
    }

    public boolean listarUsuarios(){
        if (listaUsuarios.size()==0){
            return  false;
        } else {
            for ( Usuario item : listaUsuarios ) {
                item.mostrarDatos();
            }
            return true;
        }

    }

    public boolean borrarUsuario(int id){
        if (existeUsuario(id)!=null){
            listaUsuarios.remove(existeUsuario(id));
            return true;
        } else {
            return false;
        }
    }

    public void modificarUsuario(int id, String modificar, Object dato){
        if (existeUsuario(id)!=null){
            switch (modificar){
                case "nombre":
                    existeUsuario(id).setNombre(dato.toString());
                    break;
                case "apellido":
                    existeUsuario(id).setApellido(dato.toString());
                    break;
                case "telefono":
                    existeUsuario(id).setTelefono(Integer.valueOf(dato.toString()));
                    break;
                case "dni":
                    existeUsuario(id).setDni(dato.toString());
                    break;
            }
        }

    }

    private Usuario existeUsuario(int id) {
        for (Usuario item : listaUsuarios) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    // removeUser

    // modifyUser

    // listUser

    // exist

}


