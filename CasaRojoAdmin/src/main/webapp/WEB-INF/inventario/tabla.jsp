<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<section>
    <div class="container-fluid"  style="padding:50px;">
 <table class="table table-dark table-striped">
       <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Producto</th>
      <th scope="col">Cantidad</th>
      <th scope="col">Precio</th>
    </tr>
  </thead>
   <tbody>
       <c:forEach var="producto" items="${productos}" varStatus="status">
          <tr>
            <th scope="row">${status.count}</th>
            <td>${producto.getNombreProducto()}</td>
            <td>${producto.getCantidadProducto()}</td>
            <td>${producto.getPrecioCompra()}</td>
          </tr> 
       </c:forEach>
  </tbody>
 </table>
        </div>
</section>
