$(document).ready(function () {
    $('.abrir-modal').click(function () {
        // Obtener los atributos personalizados de los elementos HTML usando data-*
        var id = $(this).data('id');
        var titulo = $(this).data('titulo');
        var descripcion = $(this).data('descripcion');
        var estado = $(this).data('estado');

        // Llenar los campos de la ventana modal con los valores obtenidos
        $('#cod_tarea').val(id);
        $('#Titulo').val(titulo);
        $('#Descripcion').val(descripcion);
        $('#Estado').val(estado);

        // Mostrar la ventana modal
        $('#editModal #cod_tarea').val(id);
        
        $('#editModal').modal();

        // Manejar el envío del formulario
        $('#editModal form').submit(function (event) {
            event.preventDefault();

            // Realizar la lógica de actualización aquí
  // Obtener el id_tarea
        var id_tarea = id;
           var tarea = {
            cod_tareas: id_tarea,
            Titulo: $('#Titulo').val(),
            Descripcion: $('#Descripcion').val(),
            Estado: $('#Estado').val()
        };
            // Realizar la solicitud AJAX para modificar la tarea
            $.ajax({
                type: 'POST',
                url: '/modificarTarea',
                contentType: 'application/json',
                data: JSON.stringify(tarea),
                success: function (response) {
                    console.log('Éxito:', response);
                          window.location.href ="http://localhost:8080";
                          // Puedes realizar acciones adicionales si es necesario
                },
                error: function (error) {
                    console.error('Error:', error);
                    // Manejar el error si es necesario
                }
            });
         console.log('ID:', id);
console.log('Titulo:', $('#Titulo').val());
console.log('Descripcion:', $('#Descripcion').val());
console.log('Estado:', $('#Estado').val());
         
            // Puedes utilizar AJAX para enviar los datos al servidor

            // Cerrar la ventana modal después de la actualización
            $('#editModal').modal('hide');
      
        });
    });
});