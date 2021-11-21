<section id="actions" class="bg-light">
    <div class="container">
        <form>
            <div class="container-fluid"><br>
                <h1 style="text-align: center">Registro de Compra</h1><br>
                <label style="font-size: 25px">Producto</label><br>
                <input type="text" class="form-control" name="producto" required>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <label style="font-size: 25px">Cantidad</label><br>
                        <input type="number" maxlength="7" class="form-control" name="cantidad" required step="any">
                    </div>
                    <div class="col">
                        <label style="font-size: 25px">Costo</label><br>
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