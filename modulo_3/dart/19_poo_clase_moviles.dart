class Smartphone {
  final String id;
  final String modelo;
  String       precio;
  bool         _vendido = false;

  Smartphone({
    required this.id,
    required this.modelo,
    required this.precio,
  });

  bool   get vendido => _vendido;
  String get estado  => _vendido ? 'vendido' : 'disponible';

  set estadoVendido(bool valor) {
    _vendido = valor;
    print('$modelo: ${valor ? "vendido" : "devuelto al stock"}');
  }

  void vender() {
    _vendido = true;
    print('$modelo vendido en $precio');
  }

  void devolver() {
    _vendido = false;
    print('$modelo devuelto');
  }

  String resumen() => 'ID: $id | Modelo: $modelo | Precio: $precio | Estado: $estado';

  @override
  String toString() => 'Smartphone($modelo, $precio, $estado)';
}

void main() {
  final s24 = Smartphone(
    id:     'CEL-001',
    modelo: 'Galaxy S24',
    precio: '\$899.99',
  );

  s24.vender();
  print(s24.estado);
  print(s24.resumen());
  print(s24);

  s24.estadoVendido = false;
  print(s24.vendido);
}
