<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<sb:head />
</head>
<body>
	<div id="contenedor" style="margin-left: 30%; width: 40%">
		<h1>
			<s:property value="getText('login.title')" />
		</h1>

		<!-- IDIOMAS -->
		<s:url id="langEN" namespace="/" action="lang">
			<s:param name="request_locale">en</s:param>
		</s:url>
		<s:url id="langZH" namespace="/" action="lang">
			<s:param name="request_locale">zh</s:param>
		</s:url>
		<s:url id="langES" namespace="/" action="lang">
			<s:param name="request_locale">es</s:param>
		</s:url>
		<s:a href="%{langEN}">English</s:a>
		<s:a href="%{langZH}">Chinese</s:a>
		<s:a href="%{langES}">Español</s:a>

		<!-- CONTENIDO -->
		<s:form action="crudUsuario" theme="bootstrap">
			<s:textfield type="email" placeholder="Ingrese su correo"
				label="%{getText('login.email')}" name="u.correo" />

			<s:textfield type="password" placeholder="Ingrese clave"
				label="%{getText('login.password')}" name="u.contraseña" />

			<s:submit key="login.submit" cssClass="btn btn-warning"
				value="Validar" />
		</s:form>
		<br>
		<s:property value="login.validausuario" />
		<s:actionmessage theme="bootstrap" />
		<s:actionerror theme="bootstrap" />
	</div>
</body>
</html>