<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="navBar.html"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
			<a class="btn btn-primary" href="CrearProducto">Crear producto</a>
			<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Nombre</th>
      <th scope="col">Fecha compra</th>
      <th scope="col">Precio</th>
      <th scope="col">Marca</th>
      <th scope="col">Acciones</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${productos}" var="producto">
  	<tr>
      <td>${producto.nombre}</td>
      <td>${producto.fechaCompra}</td>
      <td>${producto.precio}</td>
      <td>${producto.marca.nombre}</td>
      <td>
      	<a href="VerProducto?id=${producto.id}">Ver</a>
      	<a href="EditarProducto?id=${producto.id}">Editar</a>
      	<a href="EliminarProducto?id=${producto.id}">Eliminar</a>
      </td>
    </tr></c:forEach>
    
  </tbody>
</table>
			</div>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>