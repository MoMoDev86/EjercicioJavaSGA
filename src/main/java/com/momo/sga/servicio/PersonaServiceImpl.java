package com.momo.sga.servicio;

import com.momo.sga.datos.PersonaDao;
import com.momo.sga.domain.Persona;
import java.util.List;
import javax.ejb.*;
import javax.inject.Inject;

@Stateless
public class PersonaServiceImpl implements  PersonaService, PersonaServiceRemote{

    @Inject
    private PersonaDao personaDao;

    @Override
    public List<Persona> listarPersonas() {
        return personaDao.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return personaDao.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDao.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        personaDao.updatePersona(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }

}
