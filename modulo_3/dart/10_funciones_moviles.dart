void mostrarBienvenida() {
  print('Bienvenido a la tienda de celulares');
}

void saludarCliente(String nombre) {
  print('Hola $nombre, bienvenido a nuestra tienda');
}

int obtenerStock() {
  return 50;
}

double calcularTotal(double precio, int cantidad) {
  return precio * cantidad;
}

double aplicarDescuento(double precio, double porcentaje) => precio * (1 - porcentaje / 100);

void registrarVenta(String modelo, [String accesorio = 'Sin accesorio']) {
  print('Venta: $modelo + $accesorio');
}

void crearPedido({
  required String modelo,
  required int cantidad,
}) {
  print("Pedido: $modelo cantidad: $cantidad");
}

String formatearPrecio(double precio) => '\$${precio.toStringAsFixed(2)}';

formatearPrecioSinTipo(double precio) => '\$${precio.toStringAsFixed(2)}';

void main() {
  mostrarBienvenida();
  saludarCliente('Carlos López');
  int stock = obtenerStock();
  print(stock);
  print('el stock es : ${obtenerStock()}');
  print('el total : \$${calcularTotal(899.99, 2)}');
  print('precio con descuento : \$${aplicarDescuento(899.99, 15)}');
  registrarVenta('Galaxy S24', 'Funda');
  registrarVenta('Redmi Note 13');
  crearPedido(
    modelo: 'iPhone 15',
    cantidad: 3,
  );
  print(formatearPrecio(1299.99));
  print(formatearPrecioSinTipo(1299.99));
}
