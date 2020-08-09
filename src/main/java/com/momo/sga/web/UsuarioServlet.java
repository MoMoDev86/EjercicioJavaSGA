package com.momo.sga.web;

import com.momo.sga.domain.Persona;
import com.momo.sga.domain.*;
import com.momo.sga.servicio.*;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Usuarios")
public class UsuarioServlet extends HttpServlet {

    @Inject
    UsuarioService usuarioService;

    @Inject
    PersonaService personaService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarUsuario(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Usuario> usuarios = usuarioService.listarUsuarios();
        List<Persona> personas = personaService.listarPersonas();

        System.out.println("usuarios: " + usuarios);
        System.out.println("personas: " + personas);

        HttpSession session = request.getSession();

        session.setAttribute("usuarios", usuarios);
        session.setAttribute("personas", personas);
        response.sendRedirect("listadoUsuarios.jsp");
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        Usuario usuario = usuarioService.encontrarUsuarioPorId(new Usuario(idUsuario));
        request.setAttribute("usuario", usuario);

        String jspEdit = "/WEB-INF/paginas/usuario/editarUsuario.jsp";

        request.getRequestDispatcher(jspEdit).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarUsuario(request, response);
                    break;
                case "modificar":
                    this.modificarUsuario(request, response);
                    break;
                case "eliminar":
                    this.eliminarUsuario(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recuperar los valores del formulario agregarUsuario
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String id = request.getParameter("idPersona");

        int idPersona;

        try {
            idPersona = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            idPersona = 0;
        }

        Usuario usuario = null;

        if (idPersona > 0) {
            usuario = new Usuario(username, password, personaService.encontrarPersonaPorId(new Persona(idPersona)));
        } else {
            usuario = new Usuario(username, password);
        }

        //Registramos en la base
        usuarioService.registrarUsuario(usuario);

        //Redirigimos a la acción por defecto
        this.accionDefault(request, response);
    }

    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recuperar los valores del formulario editarUsuario
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String id = request.getParameter("idPersona");

        int idPersona;

        try {
            idPersona = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            idPersona = 0;
        }

        Usuario usuario = new Usuario(username, password);

        usuario.setIdUsuario(idUsuario);

        if (idPersona > 0) {
            Persona persona = new Persona(idPersona);
            persona = personaService.encontrarPersonaPorId(persona);
            usuario.setPersona(persona);
        }

        usuarioService.modificarUsuario(usuario);

        //Redirigimos a la acción por defecto
        this.accionDefault(request, response);
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recuperar los valores del formulario editarPersona
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        //Creamos el objeto de la clase Usuario
        Usuario usuario = new Usuario(idUsuario);

        usuario = usuarioService.encontrarUsuarioPorId(usuario);

        //Eliminamos el objeto en la base de datos
        usuarioService.eliminarUsuario(usuario);

        //Redirigimos a la acción por defecto
        this.accionDefault(request, response);
    }
}
