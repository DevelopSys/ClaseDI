package org.example.tiendaapp.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.tiendaapp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataSet {

    private static ObservableList<User> listUser = FXCollections.observableArrayList();

    public static void initListUser() {
        // String name, String surname, String mail, String password, int profile
        listUser.add(new User("Administrador", "Administrador", "admin@gmail.com", "admin", 0));
        listUser.add(new User("Borja", "Martin", "borja@gmail.com", "borja", 1));
    }

    public static boolean removeUser(User user){
        return listUser.remove(user);
    }
    public static boolean addUser(User user) {

        // listUser.stream().filter(item -> item.getMail().equalsIgnoreCase(user.getMail())).findAny().orElseThrow();
        Optional<User> userOptional =
                listUser.stream().filter(item -> item.getMail().equalsIgnoreCase(user.getMail())).findAny();
        if (!userOptional.isPresent()) {
            listUser.add(user);
            return true;
        }
        // en caso de tener un correo ya en la lista -> retorno false
        // en caso de tener un correo ya en la lista -> añado y retorno true
        return false;
    }

    public static ObservableList<User> getList() {
        return listUser;
    }

    public static Object[] getLogin(String mail, String pass) {
        // si en la lista hay algun usuario con el mail y el pass -> return true
        // si en la lista no hay algun usuario con el mail y el pass -> return false
        // int -> -1 no login 0 user 1 admin
        // itero lista -> if -> variable -> retorno profile

        for (User item : listUser) {
            if (item.getPassword().equals(pass) && item.getMail().equals(mail)) {
                return new Object[]{item.getMail(), item.getProfile()};
            }
        }
        return new Object[]{null, -1};


        /*
        return listUser.stream()
                .filter(item -> item.getPassword().equals(pass)
                && item.getMail().equals(mail))
                .findAny().map(User::getProfile).orElse(-1);

         */


    }

    public static User getUser(String mail) {
        User user = listUser.stream().filter(item -> item.getMail().equalsIgnoreCase(mail)).findAny().get();
        return user;
    }

    public static Long getAdmins() {
        return listUser.stream().filter(item -> item.getProfile() == 0).count();
    }

}
