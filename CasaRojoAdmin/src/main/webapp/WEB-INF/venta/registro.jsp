<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="actions">
    <div class="container">
        <form method="POST" action="${pageContext.request.contextPath}/ServletControladorVenta?accion=insertar">
            <div class="container"><br>
                <label style="font-size: 25px" for="producto">Producto</label><br>
                    <select style="width:1110px; height: 40px;" class="form-select" name="producto" aria-label="Default select example">
                        <c:forEach var="producto" items="${productos}">
                            <c:choose>
                                <c:when test="${producto.cantidadProducto > 0}">
                                    <option value="${producto.nombreProducto}">${producto.nombreProducto}</option>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                </select>
            </div><br>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <label style="font-size: 25px" for="cantidad">Cantidad</label><br>
                        <input type="number" maxlength="7" class="form-control" name="cantidad" required step="any">
                    </div>
                    <div class="col">
                        <label style="font-size: 25px" for="costo">Precio</label><br>
                        <input type="number" maxlength="7" class="form-control" name="costo" required step="any">
                    </div>
                </div>
            </div>
            <div class="container">
                <br>
                <div class="col-6 mx-auto">
                    <button class="btn btn-outline-danger btn-block" type="submit">Registrar</button>
                </div>
            </div>
        </form>
    </div>
    <br>
</section>