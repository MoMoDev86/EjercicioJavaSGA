package com.momo.sga.datos;

import com.momo.sga.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class PersonaDaoImpl implements PersonaDao {

    @PersistenceContext(unitName = "PersonaPool")
    EntityManager em;

    @Override
    public List<Persona> findAllPersonas() {
        //Uso la namedQuery disponible en la clase de entidad Persona
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        //A modo de ejemplo, en lugar de una NamedQuery creamos la query acá
        Query query = em.createQuery("from Persona p where p.email = :email");
        query.setParameter("email", persona.getEmail());
        return (Persona) query.getSingleResult();
    }

    @Override
    public void insertPersona(Persona persona) {
        //No hace falta hacer commit, pq usamos EJB
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        //Actualiza el estado en la base de datos
        em.merge(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        //Primero merge (se actualiza el estado del objeto), luego remove (borrado)
        persona = em.merge(persona);
        em.remove(persona);
    }

}
