package com.momo.sga.datos;

import java.util.List;
import com.momo.sga.domain.Usuario;

public interface UsuarioDao {
    
    public List<Usuario> findAllUsuarios();
    
    public Usuario findUsuarioById(Usuario usuario);
    
    public Usuario findUsuarioByUserName(Usuario usuario);
    
    public void insertUsuario(Usuario usuario);
    
    public void updateUsuario(Usuario usuario);
    
    public void deleteUsuario(Usuario usuario);
    
}
