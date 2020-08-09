<div id="eliminarUsuarioModal" class="ui tiny modal"> 
    <div class="ui icon header">
        <i class="trash icon"></i>
        Eliminar Usuario
    </div>
    <div class="content">
        <h4>¿Está seguro de que desea eliminar el registro?</h4>
    </div>
    <div class="actions">
        <form class="formEliminarUsuario" action="${pageContext.request.contextPath}/Usuarios?accion=eliminar&idUsuario=" 
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

            $('#eliminarUsuarioModal')
                    .modal({
                        onApprove: function (e) {

                            var cadenaAction = $(".formEliminarUsuario").attr("action");
                            var aux = cadenaAction.search("idUsuario=");

                            cadenaAction = cadenaAction.slice(0, aux + "idUsuario=".length) + id;

                            $(".formEliminarUsuario").attr("action", cadenaAction)
                            $(".formEliminarUsuario").submit();

                        }, }).modal('show');
        });
    });
</script>