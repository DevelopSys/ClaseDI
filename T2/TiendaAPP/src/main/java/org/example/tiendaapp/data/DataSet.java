package org.example.tiendaapp.data;

import org.example.tiendaapp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataSet {

    private static List<User> listUser = new ArrayList();

    public static void initListUser() {
        // String name, String surname, String mail, String password, int profile
        listUser.add(new User("Administrador", "Administrador", "admin@gmail.com", "admin", 1));
    }

    public static boolean addUser(User user) {
        // en caso de tener un correo ya en la lista -> retorno false
        // en caso de tener un correo ya en la lista -> añado y retorno true
        return false;
    }

    public static List<User> getList() {
        return listUser;
    }

    public static int getLogin(String mail, String pass) {
        // si en la lista hay algun usuario con el mail y el pass -> return true
        // si en la lista no hay algun usuario con el mail y el pass -> return false
        // int -> -1 no login 0 user 1 admin
        // itero lista -> if -> variable -> retorno profile

        for (User item : listUser) {
            if (item.getPassword().equals(pass) && item.getMail().equals(mail)) {
                return item.getProfile();
            }
        }
        return -1;


        /*
        return listUser.stream()
                .filter(item -> item.getPassword().equals(pass)
                && item.getMail().equals(mail))
                .findAny().map(User::getProfile).orElse(-1);

         */


    }

}
