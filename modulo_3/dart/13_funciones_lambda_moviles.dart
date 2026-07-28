void main() {
  final calcularIva = (double precio) => precio * 1.19;
  print('Precio + IVA: \$${calcularIva(899.99)}');

  final calcularDescuento = (double precio, double pct) {
    final descuento = precio * (pct / 100);
    return precio - descuento;
  };
  print(calcularDescuento(1000.0, 15.0));

  final precios = [899.99, 1299.99, 299.99, 499.99, 1099.99];
  precios.sort((a, b) => a.compareTo(b));
  print(precios);
}
