<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GANANCIAS</title>
    </head>
    <body>
        
        <!--Cabecero-->
        <jsp:include page="/WEB-INF/generales/botonRegresarInicio.jsp"/>
        <jsp:include page="/WEB-INF/ganancia/encabezado.jsp"/>
        
        <jsp:include page="/WEB-INF/ganancia/listado.jsp"/>
        
        <!--pie de página-->
        <jsp:include page="/WEB-INF/generales/piePagina.jsp"/>
        
    </body>
</html>
