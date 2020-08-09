<div class="ui tiny modal" id="modal_agregar_persona">
    <div class="ui icon header">
        <i class="user icon"></i>
        Alta de persona
    </div>
    <div class="content">
        <form action="${pageContext.request.contextPath}/Personas?accion=insertar"
              method="POST" class="ui form"
              >            
            <div class="field">
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" placeholder="nombre" required autofocus value="${persona.nombre}">
            </div>
            <div class="field">
                <label for="apellido">Apellido</label>
                <input type="text" name="apellido" placeholder="apellido" required autofocus value="${persona.apellido}">
            </div>            
            <div class="field">
                <label for="email">E-mail</label>
                <input type="text" name="email" placeholder="e-mail" required autofocus value="${persona.email}">
            </div>            
            <div class="field">
                <label for="telefono">Teléfono</label>
                <input type="text" name="telefono" placeholder="teléfono" required autofocus value="${persona.telefono}">
            </div>
            <div class="ui container" style="padding-bottom: 10px">
                <jsp:include page="/WEB-INF/paginas/persona/navEditarPersona.jsp" />
            </div>
        </form>
    </div>
</div>