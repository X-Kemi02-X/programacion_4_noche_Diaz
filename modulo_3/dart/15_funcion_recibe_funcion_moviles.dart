List<double> filtrarPrecios(List<double> lista, bool Function(double) criterio) {
  return lista.where(criterio).toList();
}

bool esGamaAlta(double p) => p > 700;
bool esEconomico(double p) => p < 400;

void main() {
  final precios = [150.0, 899.0, 1299.0, 350.0, 1099.0, 180.0];

  print(filtrarPrecios(precios, esGamaAlta));
  print(filtrarPrecios(precios, esEconomico));

  print(filtrarPrecios(precios, (p) => p >= 500 && p <= 1000));
}
