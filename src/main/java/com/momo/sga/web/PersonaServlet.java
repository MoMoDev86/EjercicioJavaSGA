package com.momo.sga.web;

import com.momo.sga.domain.Persona;
import com.momo.sga.servicio.PersonaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Personas")
public class PersonaServlet extends HttpServlet {

    @Inject
    PersonaService personaService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarPersona(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Persona> personas = personaService.listarPersonas();
        System.out.println("personas: " + personas);
        
        // Cuando uso sendRedirect pierdo el request, entonces debo usar un session
        HttpSession session = request.getSession();
        
        session.setAttribute("personas", personas);        
        response.sendRedirect("listadoPersonas.jsp"); 
    }

    private void editarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idPersona = Integer.parseInt(request.getParameter("idPersona"));

        Persona persona = personaService.encontrarPersonaPorId(new Persona(idPersona));
        request.setAttribute("persona", persona);

        String jspEdit = "/WEB-INF/paginas/persona/editarPersona.jsp";

        request.getRequestDispatcher(jspEdit).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarPersona(request, response);
                    break;
                case "modificar":
                    this.modificarPersona(request, response);
                    break;
                case "eliminar":
                    this.eliminarPersona(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recuperar los valores del formulario agregarPersona
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        //Creamos el objeto de Persona (modelo)
        Persona persona = new Persona(nombre, apellido, email, telefono);
        
        //Registramos en la base
        personaService.registrarPersona(persona);

        //Redirigimos a la acción por defecto
        this.accionDefault(request, response);
    }

    private void modificarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        //Recuperar los valores del formulario editarPersona
        int idPersona = Integer.parseInt(request.getParameter("idPersona"));
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        
        Persona persona = new Persona(nombre, apellido, email, telefono);
        persona.setIdPersona(idPersona);
        
        personaService.modificarPersona(persona);
        
        //Redirigimos a la acción por defecto
        this.accionDefault(request, response);
    }

    private void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recuperar los valores del formulario editarPersona
        int idPersona = Integer.parseInt(request.getParameter("idPersona"));

        //Creamos el objeto de la clase Persona
        Persona persona = new Persona(idPersona);

        //Eliminamos el objeto en la base de datos
        personaService.eliminarPersona(persona);
        
        //Redirigimos a la acción por defecto
        this.accionDefault(request, response);
    }
}
