String consultarCelular(String marca, String modelo, [int? almacen]) {
  if (almacen != null) {
    return 'Buscando $marca $modelo en almacén #$almacen';
  }
  return 'Buscando $marca $modelo en todos los almacenes';
}

String consultarCelularV2(String marca, String modelo, [int almacen = 1]) {
  return 'Buscando $marca $modelo en almacén #$almacen';
}

void main() {
  print(consultarCelular('Samsung', 'Galaxy S24'));
  print(consultarCelular('Samsung', 'Galaxy S24', 3));
  print(consultarCelularV2('Apple', 'iPhone 15'));

    configurarBusqueda(
    marca:       'Samsung',
    presupuesto:     900,
    soloOferta:        false,
    tiempoLimiteSeg: 60,
  );

  configurarBusqueda(
    marca:   'Apple',
    presupuesto: 1200,
  );
}

void configurarBusqueda({
  required String marca,
  required double presupuesto,
  bool   soloOferta        = true,
  int    tiempoLimiteSeg = 30,
}) {
  final tipo = soloOferta ? 'en oferta' : 'disponibles';
  print('Buscando $marca $tipo hasta \$$presupuesto (timeout: ${tiempoLimiteSeg}s)');
}
