<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<section>
    <form action="${pageContext.request.contextPath}/ServletControladorGanancia?accionListar=listarCompra"
          method="POST">
    <div class="container-fluid"  style="padding:50px;">
  <table>
            <tr>
                <td style="width:350px">
                    <table>
                        <tr>
                            <td>
                                <br>
                                <br>
                                <div>
                                    <select name="year" style="width:170px; height: 50px; font-size: 20px; text-align: center" class="form-select" aria-label="Default select example">
                                        <option selected value="2021">2021</option>
                                        <option value="2020">2020</option>
                                        <option value="2019">2019</option>
                                        <option value="2018">2018</option>
                                        <option value="2017">2017</option>
                                    </select>
                                </div>
                                <br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div>
                                    <select name="mes" style="width:170px; height: 50px; font-size: 20px; text-align: center" class="form-select" aria-label="Default select example">
                                        <option value="1">Enero</option>
                                        <option value="2">Febrero</option>
                                        <option value="3">Marzo</option>
                                        <option value="4">Abril</option>
                                        <option value="5">Mayo</option>
                                        <option value="6">Junio</option>
                                        <option value="7">Julio</option>
                                        <option value="8">Agosto</option>
                                        <option value="9">Septiembre</option>
                                        <option value="10">Octubre</option>
                                        <option selected value="11">Noviembre</option>
                                        <option value="12">Diciembre</option>
                                    </select>
                                </div>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    
                                <br>
                                <br>
                   <table class="table table-dark table-striped">
                    <thead>
                        <tr>
                            <th scope="col" style="width: 600px">INVERTIDO</th>
                          <th scope="col" style="width: 600px">GANADO</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ganancia" items="${ganancias}" varStatus="status">
                         <tr>
                            <th>${ganancia.getInvertido()}</th>
                            <td>${ganancia.getGanado()}</td>
                        </tr>
                     </c:forEach>
                   </tbody>
                  </table>
                </td>
            </tr>
        </table>
        </div>
        <button class="btn btn-dark btn-lg btn-block" style="margin-top: 20px; font-size: 25px;" type="submit">Buscar</button>
    </form>
</section>
