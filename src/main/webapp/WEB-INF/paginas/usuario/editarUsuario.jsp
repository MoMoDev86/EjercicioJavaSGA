<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Editar Usuario</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

        <div class="ui container" style="width: 50%">
            <form action="${pageContext.request.contextPath}/Usuarios?accion=modificar&idUsuario=${usuario.idUsuario}"
                  method="POST" class="ui form"
                  >

                <h2 class="ui horizontal divider header blue" style="padding-top: 20px">Datos del usuario</h4>
                    <div class="field">
                        <label for="username">Usuario</label>
                        <input type="text" name="username" placeholder="nombre de usuario" required autofocus value="${usuario.username}">
                    </div>
                    <div class="field">
                        <label for="password">Contraseña</label>
                        <input type="password" name="password" placeholder="contraseña" required autofocus value="${usuario.password}">
                    </div>  
                    <div class="field">
                        <label for="idPersona">Persona</label>
                        <select name="idPersona" class="ui search dropdown">                            
                            <option value="0">(Ninguno)</option>                            
                            <c:forEach items="${personas}" var="persona">
                                <option value="${persona.idPersona}" accesskey=""  
                                        <c:if test="${persona.idPersona != usuario.persona.idPersona}">selected</c:if>
                                        >${persona.nombre} ${persona.apellido} (${persona.idPersona})</option>    
                            </c:forEach>
                        </select>
                    </div>
                    <div class="ui container">
                        <jsp:include page="/WEB-INF/paginas/usuario/navEditarUsuario.jsp" />
                    </div>
            </form>
        </div>
    </body>
</html>
<script type="text/javascript">
    $('.ui.dropdown').dropdown();
</script>
