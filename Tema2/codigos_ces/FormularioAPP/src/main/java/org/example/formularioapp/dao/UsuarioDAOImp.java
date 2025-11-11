package org.example.formularioapp.dao;

import org.example.formularioapp.model.Usuario;

import java.util.List;

public class UsuarioDAOImp implements UsuarioDAO{
    @Override
    public void insertarUsuario(Usuario usuario) {

    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return List.of();
    }

    @Override
    public List<Usuario> obtenerUsuarios(String correo) {
        return List.of();
    }

    @Override
    public int borrarUsuarios(String nombre) {
        return 0;
    }
}
