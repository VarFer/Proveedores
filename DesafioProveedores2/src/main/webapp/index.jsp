<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Inicio - Sistema de Proveedores</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #000;
	color: #ffc107; /* Texto amarillo */
	font-family: 'Arial', sans-serif;
}

.color-box {
	background-color: #343a40; /* Gris oscuro para los cuadros */
	padding: 20px;
	margin-bottom: 20px;
	border-radius: 10px;
}

.color-box h2 {
	color: #ffc107; /* Texto amarillo dentro de los cuadros */
}

.table-striped tbody tr:nth-of-type(odd) {
	background-color: rgba(255, 255, 255, 0.05);
	/* Fondo blanco semi-transparente para filas impares */
}

.table-striped tbody tr:nth-of-type(even) {
	background-color: rgba(255, 255, 255, 0.1);
	/* Fondo blanco semi-transparente para filas pares */
}

.table-striped tbody tr td {
	color: #fff; /* Texto blanco en las celdas de la tabla */
}

.main-title {
	text-align: center; /* Centra el texto */
}

.alert {
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<!-- Mensajes de éxito o error -->
		<c:if test="${not empty msgSuccess}">
			<div class="alert alert-success">${msgSuccess}</div>
		</c:if>
		<c:if test="${not empty msgError}">
			<div class="alert alert-danger">${msgError}</div>
		</c:if>

		<!-- Título y enlace para listar proveedores -->
		<div class="color-box">
			<h1 class="mt-5 main-title">Sistema de Proveedores</h1>
			<a href="ListarProveedoresServlet" class="btn btn-primary mt-3">Listar
				Proveedores</a>
		</div>

		<!-- Formulario para ingresar nuevo proveedor -->
		<div class="color-box">
			<h2>Ingresar Nuevo Proveedor</h2>
			<form action="InsertarProveedorServlet" method="post">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="nombre">Nombre:</label> <input type="text" id="nombre"
							name="nombre" class="form-control" required>
					</div>
					<div class="form-group col-md-6">
						<label for="rut">RUT:</label> <input type="text" id="rut"
							name="rut" class="form-control" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="direccion">Dirección:</label> <input type="text"
							id="direccion" name="direccion" class="form-control" required>
					</div>
					<div class="form-group col-md-6">
						<label for="correo">Correo:</label> <input type="email"
							id="correo" name="correo" class="form-control" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="telefono">Teléfono:</label> <input type="text"
							id="telefono" name="telefono" class="form-control" required>
					</div>
					<div class="form-group col-md-6">
						<label for="contacto">Contacto:</label> <input type="text"
							id="contacto" name="contacto" class="form-control" required>
					</div>
				</div>
				<div class="form-group">
					<label for="telefono_contacto">Teléfono de Contacto:</label> <input
						type="text" id="telefono_contacto" name="telefono_contacto"
						class="form-control" required>
				</div>
				<button type="submit" class="btn btn-primary">Guardar</button>
			</form>
		</div>

		<!-- Tabla de Proveedores -->
		<div class="color-box">
			<h2>Listado de Proveedores</h2>
			<table class="table table-striped">
				<thead class="thead-light">
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>RUT</th>
						<th>Dirección</th>
						<th>Correo</th>
						<th>Teléfono</th>
						<th>Contacto</th>
						<th>Teléfono de Contacto</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<!-- Iteración sobre la lista de proveedores utilizando JSTL -->
					<c:forEach items="${proveedores}" var="proveedor">
						<tr>
							<td>${proveedor.id}</td>
							<td>${proveedor.nombre}</td>
							<td>${proveedor.rut}</td>
							<td>${proveedor.direccion}</td>
							<td>${proveedor.correo}</td>
							<td>${proveedor.telefono}</td>
							<td>${proveedor.contacto}</td>
							<td>${proveedor.telefonoContacto}</td>
							<td><a href="EditarProveedorServlet?id=${proveedor.id}"
								class="btn btn-warning btn-sm">Editar</a>
								<form action="EliminarProveedorServlet" method="post"
									style="display: inline;">
									<input type="hidden" name="id" value="${proveedor.id}">
									<button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
								</form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- Bootstrap JS y dependencias opcionales -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>