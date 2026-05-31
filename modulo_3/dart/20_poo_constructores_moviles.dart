class Telefono {
  final String marca;
  final String modelo;
  final int    almacenamientoGb;
  final bool   es5g;

  Telefono({
    required this.marca,
    required this.modelo,
    required this.almacenamientoGb,
    this.es5g = false,
  });

  Telefono.basico()
      : marca = 'Generico',
        modelo = 'Basic 100',
        almacenamientoGb = 64,
        es5g = false;

  Telefono.gamaAlta({required this.marca, required this.modelo})
      : almacenamientoGb = 512,
        es5g = true;

  factory Telefono.desdeCodigo(String codigo) {
    final partes = codigo.split('-');
    return Telefono(
      marca: partes[0],
      modelo: partes[1],
      almacenamientoGb: int.parse(partes[2]),
      es5g: codigo.contains('5G'),
    );
  }

  @override
  String toString() =>
      '$marca $modelo (${almacenamientoGb}GB${es5g ? ", 5G" : ""})';
}

void main() {
  final t1 = Telefono(marca: 'Samsung', modelo: 'Galaxy S24', almacenamientoGb: 256);
  final t2 = Telefono.basico();
  final t3 = Telefono.gamaAlta(marca: 'Apple', modelo: 'iPhone 15 Pro');
  final t4 = Telefono.desdeCodigo('Xiaomi-RedmiNote13-256-5G');

  print(t1);
  print(t2);
  print(t3);
  print(t4);
}
