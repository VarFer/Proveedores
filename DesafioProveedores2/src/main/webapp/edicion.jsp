<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Proveedor - Sistema de Proveedores</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Estilos CSS personalizados -->
    <link href="css/styles.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="color-box">
            <h1 class="mt-5">Editar Proveedor</h1>
        </div>

        <!-- Mensajes de éxito o error -->
        <c:if test="${not empty msgSuccess}">
            <div class="alert alert-success">${msgSuccess}</div>
        </c:if>
        <c:if test="${not empty msgError}">
            <div class="alert alert-danger">${msgError}</div>
        </c:if>

        <!-- Formulario para editar proveedor -->
        <div class="color-box">
            <h2>Modificar Proveedor</h2>
            <form action="ActualizarProveedorServlet" method="post">
                <input type="hidden" name="id" value="${proveedor.id}">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nombre">Nombre:</label>
                        <input type="text" id="nombre" name="nombre" class="form-control" value="${proveedor.nombre}" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="rut">RUT:</label>
                        <input type="text" id="rut" name="rut" class="form-control" value="${proveedor.rut}" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="direccion">Dirección:</label>
                        <input type="text" id="direccion" name="direccion" class="form-control" value="${proveedor.direccion}" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="correo">Correo:</label>
                        <input type="email" id="correo" name="correo" class="form-control" value="${proveedor.correo}" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="telefono">Teléfono:</label>
                        <input type="text" id="telefono" name="telefono" class="form-control" value="${proveedor.telefono}" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="contacto">Contacto:</label>
                        <input type="text" id="contacto" name="contacto" class="form-control" value="${proveedor.contacto}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="telefono_contacto">Teléfono de Contacto:</label>
                    <input type="text" id="telefono_contacto" name="telefono_contacto" class="form-control" value="${proveedor.telefonoContacto}" required>
                </div>
                <button type="submit" class="btn btn-primary">Actualizar</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS y dependencias opcionales -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
