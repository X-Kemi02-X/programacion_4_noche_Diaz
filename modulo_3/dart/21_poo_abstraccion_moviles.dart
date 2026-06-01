abstract class Telefono {
  String get nombre;
  double calcularPrecio();
  String obtenerEspecificaciones();

  void mostrarFicha() {
    print('$nombre — Precio: \$${calcularPrecio().toStringAsFixed(2)}, '
          'Especificaciones: ${obtenerEspecificaciones()}');
  }
}

class AndroidPhone extends Telefono {
  final String modelo;
  final int ramGb;
  AndroidPhone(this.modelo, this.ramGb);

  @override String get nombre => 'Android $modelo';
  @override double calcularPrecio() => ramGb <= 8 ? 499.99 : 899.99;
  @override String obtenerEspecificaciones() => 'Android, $ramGb GB RAM';
}

class iPhone extends Telefono {
  final String modelo;
  final int almacenamientoGb;
  iPhone(this.modelo, this.almacenamientoGb);

  @override String get nombre => 'iPhone $modelo';
  @override double calcularPrecio() => 799.99 + (almacenamientoGb > 128 ? 200 : 0);
  @override String obtenerEspecificaciones() => 'iOS, $almacenamientoGb GB';
}

void main() {
  final telefonos = <Telefono>[AndroidPhone('Pixel 8', 8), iPhone('15', 256)];
  for (final t in telefonos) {
    t.mostrarFicha();
  }
}
