<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Personas</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">       
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>        
        <div class="ui container">
            <h1 class="ui horizontal divider header blue" style="text-align: center; padding-top: 20px">Listado de personas</h1>
            <table class="ui celled table selectable">
                <thead>               
                    <tr>
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Email</th>
                        <th>Teléfono</th>     
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <c:forEach items="${personas}" var="persona">
                    <tr>
                        <td>${persona.idPersona}</td>
                        <td>${persona.nombre}</td>
                        <td>${persona.apellido}</td>
                        <td>${persona.email}</td>
                        <td>${persona.telefono}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Personas?accion=editar&idPersona=${persona.idPersona}"
                               class="ui labeled icon basic button">
                                <i class="edit icon"></i>Editar
                            </a>
                        </td>
                        <td>
                            <a href="#" data-target="#eliminarPersonaModal" class="ui labeled icon basic button botonEliminar" data-id="${persona.idPersona}">
                                <i class="trash icon"></i>Eliminar
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <hr>
            <jsp:include page="/WEB-INF/paginas/persona/agregarPersona.jsp" />
            <jsp:include page="/WEB-INF/paginas/persona/eliminarPersona.jsp" />
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp" />
        </div>
        <script>
            $(document).ready(function () {
                $('#abrir_modal').click(function () {
                    $('#modal_agregar_persona').modal('show');
                });
            });
        </script>
    </body>
</html>
