<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/glyphicon.css" type="text/css"/>
	<link rel="stylesheet" href="./css/table.css" type="text/css"/>
	
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript" src="./js/Alertas.js"></script>
    
    <script type="text/javascript" src="./js/jquery.configTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready( function () {
		$("#TablaCuentas").DataTable();
		} );
	</script>
<title>UTN Banking 2021</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    
    <c:choose>
	     <c:when test="${not empty msgAlta}">
	         <script type="text/javascript">
	        	AltaCuentaExitosa("${msgAlta}")
	         </script>
	     </c:when>
	 </c:choose>	
    
    <div style="background-color: #e9ecef; min-height:94vh!important" class="container-fluid py-3" >
        <div class="container">
        	<div>
        		<h2>Administrar Cuentas</h2>
        	</div>
		    <div class="row">
		        <div class="col-md-12">                                
		            <br/>
		            <p><a href="${pageContext.servletContext.contextPath}/crearCuenta.html" style="color: #337ab7"><i class="glyphicon glyphicon-list-alt" style="color: #337ab7"></i>Crear Cuenta</a></p>
		        </div>
		    </div>
			<br>
            <div>
            	<table id="TablaCuentas" class="blueTable">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Tipo</th>
							<th>Fecha de creacion</th>
							<th>Saldo</th>
							<th>#</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="6">
							</td>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach items="${ListaCuentas}" var="objCuenta">
							<tr>
								<form action="${pageContext.servletContext.contextPath}/accionCliente.html" method="get">
									<td>${objCuenta.nroCuenta}<input type="hidden" name="nroCliente" value="${objCuenta.nroCliente}"></td>
									<td>${objCuenta.nombre}</td>
									<td>${objCuenta.tipoCuenta.nombre}</td>
									<td>${objCuenta.fechaCreacion}</td>
									<td>${objCuenta.saldo}</td>
									<td><button type="submit" name="btnModificarCli" class="btn btn-secondary btn-sm">Modificar</button><button type="submit" name="btnEliminarCli" class="btn btn-danger btn-sm">Eliminar</button></td>
								</form>
							</tr>
						</c:forEach>
					</tbody>
				</table>
            </div>	 	
        </div>
    </div>
</body>
</html>
