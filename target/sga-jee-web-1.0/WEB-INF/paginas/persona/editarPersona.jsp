<!DOCTYPE html>
<html>
    <head>
        <title>Editar Persona</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

        <div class="ui container" style="width: 50%">
            <form action="${pageContext.request.contextPath}/Personas?accion=modificar&idPersona=${persona.idPersona}"
                  method="POST" class="ui form"
                  >

                <h2 class="ui horizontal divider header blue" style="padding-top: 20px">Datos de la persona</h4>
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

                    <jsp:include page="/WEB-INF/paginas/persona/navEditarPersona.jsp" />
            </form>
        </div>
    </body>
</html>
