<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--Importacion de la libreria etiqueta struts-tag  --%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%--Importacion de la libreria etiqueta bootstrap  --%>
<%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>

<%--Importacion de la libreria struts jquery --%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Principal Cliente</title>
<sb:head />
<sj:head />

</head>
<body>
	<h1>Bienvenido:XXX</h1>
	<br>
	<br>

	<div class="col-md-9">
		<div class="container"></div>

		<!-- Ingresar automcpletar caja y boton para buscar  -->
		<s:form action="" theme="bootstrap" method="post">

			<div class="row">
				<div class="col-md-4">
					<s:url id="  " action="" />
					<sj:autocompleter label="Ingrese su producto deseado"
						name="p.id_prod " href="%{}" listValue="nom_prod"
						listKey="id_prod" cssClass="form-control" />
				</div>
				<div class="col-md-6">
					<a class="btn btn-primary" href="">Buscar</a>
				</div>
			</div>
		</s:form>

		<div id="lista">

			<ul style="list-style: none; display: flex; flex-wrap: wrap;">
				<s:iterator value="">
					<li class="grilla_campo"><img alt="" src="bd/asdf.png"
						width="100px" />
						<p>
							<s:property value="nom_prod" />
						</p>
						<p>
							<s:property value="marc_prod" />
						</p>
						<p>
							<s:property value="con_net_prod" />
						</p>
						<p>
							<s:property value="pre_prod" />
						</p></li>
				</s:iterator>
				<li class="grilla_campo"
					style="margin: .5em; background-color: rgba(200, 200, 200, .2); display: block; width: 25%; padding: .5em">
					<img alt="" src="bd/asdf.png" width="150px"
					style="display: block; margin: auto; padding: .2em" />
					<p>Nombre prueba</p>
					<p>Marca prueba</p>
					<p>Contenido prueba</p>
					<p>
						<em>Precio prueba</em>
					</p>
				</li>
			</ul>


		</div>
	</div>


</body>
</html>