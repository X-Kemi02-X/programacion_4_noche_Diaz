double descuento10(double p) => p * 0.90;
double descuento20(double p) => p * 0.80;
double descuento30(double p) => p * 0.70;

void main() {
  double Function(double) calculador;

  calculador = descuento10;
  print(calculador(899.99));

  calculador = descuento20;
  print(calculador(899.99));

  final descuentos = <double Function(double)>[descuento10, descuento20, descuento30];
  for (final fn in descuentos) {
    print(fn(1000.00));
  }
}
