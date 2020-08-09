<div id="eliminarPersonaModal" class="ui tiny modal"> 
    <div class="ui icon header">
        <i class="trash icon"></i>
        Eliminar Persona
    </div>
    <div class="content">
        <h4>¿Está seguro de que desea eliminar el registro?</h4>
    </div>
    <div class="actions">
        <form class="formEliminarPersona" action="${pageContext.request.contextPath}/Personas?accion=eliminar&idPersona=" 
              method="post">
            <div class="ui red cancel button">
                <i class="remove icon"></i>
                No
            </div>
            <div class="ui green ok button">
                <i class="checkmark icon"></i>
                Si
            </div>
        </form>
    </div>   
</div>
<script>
    $(document).ready(function () {
        $('.botonEliminar').click(function () {

            var id = $(this).data('id');

            $('#eliminarPersonaModal')
                    .modal({
                        onApprove: function (e) {

                            var cadenaAction = $(".formEliminarPersona").attr("action");
                            var aux = cadenaAction.search("idPersona=");

                            cadenaAction = cadenaAction.slice(0, aux + "idPersona=".length) + id;

                            $(".formEliminarPersona").attr("action", cadenaAction)
                            $(".formEliminarPersona").submit();

                        }, }).modal('show');
        });
    });
</script>