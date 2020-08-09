<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Usuarios</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">       
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>        
        <div class="ui container">
            <h1>Listado de Usuarios</h1>
            <table class="ui celled table selectable ">
                <thead>               
                    <tr>
                        <th>#</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Persona</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <c:forEach items="${usuarios}" var="usuario">
                    <tr>
                        <td>${usuario.idUsuario}</td>
                        <td>${usuario.username}</td>
                        <td style="-webkit-text-security: disc;">${usuario.password}</td>
                        <td>${usuario.persona.idPersona} - ${usuario.persona.nombre} ${usuario.persona.apellido}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Usuarios?accion=editar&idUsuario=${usuario.idUsuario}"
                               class="ui labeled icon basic button">
                                <i class="edit icon"></i>Editar
                            </a>
                        </td>
                        <td>
                            <a href="#" data-target="#eliminarUsuarioModal" class="ui labeled icon basic button botonEliminar" data-id="${usuario.idUsuario}">
                                <i class="trash icon"></i>Eliminar
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <hr>
            <jsp:include page="/WEB-INF/paginas/usuario/agregarUsuario.jsp" />
            <jsp:include page="/WEB-INF/paginas/usuario/eliminarUsuario.jsp" />
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp" />
        </div>
        <script>
            $(document).ready(function () {
                $('#abrir_modal').click(function () {
                    $('#modal_agregar_usuario').modal('show');
                });
            });
        </script>
    </body>
</html>