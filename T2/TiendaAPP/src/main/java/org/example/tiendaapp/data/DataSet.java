package org.example.tiendaapp.data;

import org.example.tiendaapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataSet {

    private static List<User> listUser = new ArrayList();

    public static boolean addUser(User user){
        // en caso de tener un correo ya en la lista -> retorno false
        // en caso de tener un correo ya en la lista -> añado y retorno true
        return false;
    }

    public static List<User> getList(){
        return listUser;
    }

    public static boolean getLogin(String mail, String pass){
        // si en la lista hay algun usuario con el mail y el pass -> return true
        // si en la lista no hay algun usuario con el mail y el pass -> return false
        // int -> -1 no login 0 user 1 admin
        return false;
    }

}
