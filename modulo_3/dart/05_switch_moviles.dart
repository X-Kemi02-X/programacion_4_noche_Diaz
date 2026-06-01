void main() {
  String codigoMarca = 'SAM';

  switch (codigoMarca) {
    case 'SAM':
      print('Samsung');
    case 'APP':
      print('Apple');
    case 'XIA':
      print('Xiaomi');
    case 'GOO':
      print('Google');
    case 'MOT':
      print('Motorola');
    case 'HUA':
      print('Huawei');
    default:
      print('Marca desconocida');
  }

  String gama = switch (codigoMarca) {
    'SAM' => 'Samsung - Gama Alta',
    'APP' => 'Apple - Gama Premium',
    'XIA' => 'Xiaomi - Gama Media',
    'GOO' => 'Google - Gama Alta',
    'MOT' => 'Motorola - Gama Media',
    'HUA' => 'Huawei - Gama Alta',
    _     => 'Marca desconocida',
  };

  print(gama);

  double precio = 899.99;

  String categoria = switch (precio) {
    200 || 300 || 400       => 'Gama Baja',
    500 || 600 || 700       => 'Gama Media',
    800 || 900 || 1000      => 'Gama Alta',
    1100 || 1200 || 1300     => 'Premium',
    _                       => 'Desconocido',
  };

  print(categoria);

  double presupuesto = 950;

  String recomendacion = switch (presupuesto) {
    double p when p >= 1200 => 'iPhone 15 Pro o Galaxy S24 Ultra',
    double p when p >= 800  => 'Galaxy S24 o iPhone 15',
    double p when p >= 500  => 'Redmi Note 13 o Moto G84',
    double p when p >= 200  => 'Gama básica',
    _                       => 'Consulte opciones de financiación',
  };

  print(recomendacion);
}
