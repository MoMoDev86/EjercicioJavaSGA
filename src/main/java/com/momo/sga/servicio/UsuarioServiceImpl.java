package com.momo.sga.servicio;

import com.momo.sga.datos.UsuarioDao;
import com.momo.sga.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return usuarioDao.findUsuarioById(usuario);
    }

    @Override
    public Usuario encontrarUsuarioPorUsername(Usuario usuario) {
        return usuarioDao.findUsuarioByUserName(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDao.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }
    
}
