<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%-- Importar las librerias de etiquetas --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%-- Importamos las librerias de etiquetas bootstrap --%>
<%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<%-- Importamos las librerias de struts jquery --%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busqueda</title>

<sb:head />
<sj:head />

</head>

<body>
	<div id="contenedor"
		style="display: flex; justify-content: space-around; margin-top: 2rem">
		<div id="busqueda" style="width: 50%">
			<s:form action="" theme="bootstrap" method="post"
				label="Busqueda Productos">

				<s:url id="idFil" action="" />

				<sj:autocompleter label="Nombre Producto" name="id" href="%{idFil}"
					list="listaUsuario" listKey="codigo" listValue="nombre"
					cssClass="form-control" />

				<s:submit value="Buscar" cssClass="btn btn-warning" />

			</s:form>
			<br>
			<br>
			<!-- Generar lista dinamica de datos de productos -->
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

		<div id="mapa" style="width: 30%">
			<iframe width="100%" height="600" frameborder="0" scrolling="no"
				marginheight="0" marginwidth="0"
				src="https://maps.google.com/maps?width=100%25&amp;height=600&amp;output=embed"></iframe>
			<!-- Falta agregar parametros dinamicos -->

		</div>
	</div>
</body>
</html>