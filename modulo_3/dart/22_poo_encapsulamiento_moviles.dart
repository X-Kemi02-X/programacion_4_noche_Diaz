class InventarioCelular {
  final String modelo;
  int _stock;

  InventarioCelular(this.modelo, int stockInicial)
      : _stock = stockInicial;

  int get stock => _stock;

  void vender(int cantidad) {
    if (cantidad <= 0) throw ArgumentError('La cantidad debe ser positiva');
    if (cantidad > _stock) throw StateError('Stock insuficiente');
    _stock -= cantidad;
    print('Venta de $cantidad $modelo(s). Nuevo stock: $_stock');
  }

  void reabastecer(int cantidad) {
    if (cantidad <= 0) throw ArgumentError('La cantidad debe ser positiva');
    _stock += cantidad;
    print('Reabastecimiento de $cantidad $modelo(s). Nuevo stock: $_stock');
  }
}

void main() {
  final inventario = InventarioCelular('Galaxy S24', 50);

  inventario.vender(3);
  inventario.reabastecer(10);
  print(inventario.stock);
}
