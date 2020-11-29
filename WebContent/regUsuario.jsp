<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<sb:head />
<sj:head/>

</head>
<body>
	<div id="contenedor" style="margin-left: 30%; width: 40%">
		<h1></h1>
		<s:form action="crudUsuario" theme="bootstrap" method="post" cssClass="well form-search"
			label="Registro de Usuario">
			<s:textfield label="Nombre de Usuario" placeholder="Ingrese Nombre" 
				name="u.nombre"/>
			<s:textfield label="Apellido de Usuario" placeholder="Ingrese Apellido"  
				name="u.apellido" />
				
			<div class="row">
				 <div class="col-md-6">
				 	<s:textfield label="Correo" placeholder="Ingrese Correo"  
					name="u.correo" />
				 </div>
				 <div class="col-md-6">
					<s:textfield label="Contraseña" placeholder="Ingrese Contraseña" name="u.contraseña" />
				 </div>
			</div>
			
			<s:textfield label="Localización" placeholder="Ingrese su Localización" 
				name="u.localizacion"/>
					
			<s:submit value="Registrar" cssClass="btn btn-warning"  name="btn" />

		</s:form>
		<br>
		<s:actionmessage theme="bootstrap"/>
		<s:actionerror theme="bootstrap"/>
	</div>
</body>
</html>