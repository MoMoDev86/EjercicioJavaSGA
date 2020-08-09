package com.momo.sga.datos;

import com.momo.sga.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext(unitName = "PersonaPool")
    EntityManager em;

    @Override
    public List<Usuario> findAllUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public Usuario findUsuarioByUserName(Usuario usuario) {
        Query query = em.createQuery("from Usuario u where u.username= :username");
        query.setParameter("username", usuario.getUsername());
        return (Usuario) query.getSingleResult();
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        //Primero merge (se actualiza el estado del objeto), luego remove (borrado)
        usuario = em.merge(usuario);
        em.remove(usuario);
    }

}
