<section id="actions" class="bg-light">
    <div class="container-fluid">
        <form>
            <div class="container"><br>
                <h1 style="text-align: center">Registro de Venta</h1><br>
                <label style="font-size: 25px">Producto</label><br>
                    <select style="width:1110px; height: 40px;" class="form-select" aria-label="Default select example">
                    <option selected>Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div><br>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <label style="font-size: 25px">Cantidad</label><br>
                        <input type="number" maxlength="7" class="form-control" name="cantidad" required step="any">
                    </div>
                    <div class="col">
                        <label style="font-size: 25px">Precio</label><br>
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