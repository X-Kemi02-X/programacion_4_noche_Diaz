double Function(double) crearDescuentoTienda(double porcentaje) {
  return (double precio) => precio * (1 - porcentaje / 100);
}

void main() {
  final descuento10 = crearDescuentoTienda(10);
  final descuento20 = crearDescuentoTienda(20);
  final descuento50 = crearDescuentoTienda(50);

  print(descuento10(900.0));
  print(descuento20(900.0));
  print(descuento50(900.0));

  bool Function(double) crearValidadorPresupuesto(double min, double max) {
    return (precio) => precio >= min && precio <= max;
  }

  final esEconomico  = crearValidadorPresupuesto(0, 400);
  final esPremium   = crearValidadorPresupuesto(800, double.infinity);

  print(esEconomico(350.0));
  print(esPremium(1099.99));
  print(esPremium(450.0));
}
