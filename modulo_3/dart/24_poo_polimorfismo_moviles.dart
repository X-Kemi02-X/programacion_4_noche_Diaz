abstract class Phone {
  String get nombre;
  double calcularPrecioFinal();
}

class Estandar extends Phone {
  final double precioBase;
  Estandar(this.precioBase);
  @override String get nombre => 'Estándar';
  @override double calcularPrecioFinal() => precioBase;
}

class ConDescuento extends Phone {
  final double precioBase;
  final double descuento;
  ConDescuento(this.precioBase, this.descuento);
  @override String get nombre => 'Con Descuento';
  @override double calcularPrecioFinal() => precioBase * (1 - descuento / 100);
}

class ConCargos extends Phone {
  final double precioBase;
  ConCargos(this.precioBase);
  @override String get nombre => 'Con Cargos';
  @override double calcularPrecioFinal() => precioBase * 1.19;
}

void imprimirPrecio(Phone phone) {
  print('${phone.nombre}: \$${phone.calcularPrecioFinal().toStringAsFixed(2)}');
}

void main() {
  final phones = <Phone>[
    Estandar(899.99),
    ConDescuento(1099.99, 15),
    ConCargos(699.99),
  ];

  for (final p in phones) {
    imprimirPrecio(p);
  }

  final mayor = phones.reduce((a, b) => a.calcularPrecioFinal() > b.calcularPrecioFinal() ? a : b);
  print('\nTeléfono más caro: ${mayor.nombre}');
}
