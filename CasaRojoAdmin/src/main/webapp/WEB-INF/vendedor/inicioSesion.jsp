<section id="actions" class="container">
    <div class="row">
        <div class="col-7" style="margin-top: 10px;">
            <label style="font-size: 50px; font-weight: bold; margin-bottom: 40px; color: #FF1616; margin-right: 0px;">I</label>
            <label style="font-size: 50px; font-weight: bold; margin-bottom: 40px; margin-right: 12px; margin-left: 0px;">nicio de </label>
            <label style="font-size: 50px; font-weight: bold; margin-bottom: 40px; color: #FF1616; margin-right: 0px;"> S</label>
            <label style="font-size: 50px; font-weight: bold; margin-bottom: 40px; margin-left: 0px;">esión</label>
            <form action="${pageContext.request.contextPath}/ServletControladorInicio"
                  method="POST">
                <div class="mb-3">
                    <label class="form-label" style="font-size: 20px;">Usuario</label>
                    <input type="text" name="usuario" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label" style="font-size: 20px;">Contraseña</label>
                    <input type="password" name="password" class="form-control">
                </div>
                <div class="mb-4 row">
                    <div class="col-7">
                        <button class="btn btn-dark btn-lg btn-block" style="margin-top: 20px; font-size: 25px;" type="submit">Ingresar</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-3">
            <img src="${pageContext.request.contextPath}/CR_Logo1.png">
        </div>
    </div>
    <br>
</section>
