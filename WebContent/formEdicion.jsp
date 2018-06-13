<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="navBar.html"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<form action="CambiarProducto" method="post">
				<input type="hidden" name="id" value="${producto.id}"/>
				Nombre: <input type="text" name="nombre" value="${producto.nombre}"/><br><br>
				Fecha de compra: <input type="text" paceholder="yyyy-MM-dd" name="fechaCompra" value="${producto.fechaCompra}"/><br><br>
				Precio: <input type="text" name="nombre" value="${producto.precio}"/><br><br>
				<input class="btn btn-primary" type="submit" value="Guardar"/>
				</form>
			</div>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>