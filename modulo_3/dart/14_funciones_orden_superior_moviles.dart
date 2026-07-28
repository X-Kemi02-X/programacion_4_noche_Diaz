void main() {
  final precios = [299.99, 499.50, 150.00, 999.99];

  final preciosConIva = precios.map((p) => (p * 1.19).toStringAsFixed(2));
  print(preciosConIva.toList());

  final modelos = ['/galaxy-s24', '/iphone-15', '/redmi-note-13'];
  final urls = modelos.map((m) => 'https://tienda-moviles.com$m');
  print(urls.toList());

  final preciosStock = [150.0, 899.0, 1299.0, 350.0, 1099.0, 180.0];

  final gamaAlta = preciosStock.where((p) => p > 700);
  print(gamaAlta.toList());

  final gamaMedia = preciosStock.where((p) => p >= 300 && p <= 700);
  print(gamaMedia.toList());

  final ventas = [1500.0, 2300.0, 980.0, 3100.0, 750.0];

  final total = ventas.reduce((acum, venta) => acum + venta);
  print('Total ventas: \$${total.toStringAsFixed(2)}');

  final totalFold = ventas.fold(0.0, (acum, venta) => acum + venta);
  print('Total (fold): \$${totalFold.toStringAsFixed(2)}');

  final maximo = ventas.reduce((a, b) => a > b ? a : b);
  print('Mayor venta: \$$maximo');
}
