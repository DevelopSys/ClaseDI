package model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Agenda {

    private ArrayList<Usuario> listaUsuarios;

    public Agenda(){
        listaUsuarios = new ArrayList<>();
    }

    // addUser
    public boolean agregarUsuario(Usuario usuario){
        //listaUsuarios.add(usuario);
        // solo puedo agregar usuarios que no esten ya en la lista
        // no pueden existir usuarios con el mismo id -> en un método
        if (existeUsuario(usuario.getId())==null){
            // el usuario no existe, por lo tanto agrego
            return listaUsuarios.add(usuario);

        }else {
            return false;
        }
        // en el caso de tener un usuario con el mismo id -> mensaje desde el main
        // en el caso de agregar al usuario -> mensaje desde el main
    }
    private Usuario existeUsuario(int id){
        for (Usuario item:listaUsuarios) {
            if (item.getId() == id){
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


