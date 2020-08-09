<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ui tiny modal" id="modal_agregar_usuario">
    <div class="ui icon header">
        <i class="user icon"></i>
        Alta de usuario
    </div>
    <div class="content">
        <form action="${pageContext.request.contextPath}/Usuarios?accion=insertar"
              method="POST" class="ui form" id="formUsuario"
              >            
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
                <!--<select name="idPersona" class="ui search dropdown">
                    -->
                <select name="idPersona">    
                    <c:forEach items="${personas}" var="persona">
                        <option value="${persona.idPersona}">${persona.idPersona} - ${persona.nombre} ${persona.apellido}</option>    
                    </c:forEach>
                </select>
            </div>
            <div class="ui container" style="padding-bottom: 10px">
                <jsp:include page="/WEB-INF/paginas/usuario/navEditarUsuario.jsp" />
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    $('.ui.dropdown').dropdown();
</script>