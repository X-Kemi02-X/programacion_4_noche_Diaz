void main() {
  print('=== 1. VARIABLES DEL INVENTARIO ===');
  ejemploVariables();

  print('\n=== 2. NULL SAFETY EN CATÁLOGO ===');
  ejemploNullSafety();

  print('\n=== 3. COLECCIONES DE CELULARES ===');
  ejemploColecciones();
}

void ejemploVariables() {
  var marca = 'Samsung';
  var stock = 150;
  var precio = 899.99;
  var disponible = true;

  String modelo = 'Galaxy S24';
  int    unidades = 50;
  double tamanoPantalla = 6.8;
  bool   oferta = false;

  final tienda = 'MiStore Centro';
  final double iva = 0.19;

  const descuentoMaximo = 0.30;
  const mesesSinIntereses = 12;

  final ahora = DateTime.now();

  print('$marca $modelo: \$$precio en $tienda');

  var contadorVentas = 0;
  contadorVentas = 1;

  final listaPrecios = [899.99, 1099.99, 699.99];
  listaPrecios.add(799.99);

  const marcas = ['Samsung', 'Apple', 'Xiaomi'];
  print('Marcas disponibles: $marcas');
}

void ejemploNullSafety() {
  String marca = 'Apple';

  String? modelo = null;
  modelo = 'iPhone 15';

  String? codigoDescuento;

  print('Código length: ${codigoDescuento?.length}');

  String resultado = codigoDescuento ?? 'Sin descuento';
  print('Resultado Elvis: $resultado');

  try {
    String codigoSeguro = codigoDescuento!;
    print(codigoSeguro);
  } catch (e) {
    print('Capturado operador !: Lanzó excepción porque el código era null');
  }

  if (modelo != null) {
    print('Smart cast modelo length: ${modelo.length}');
  }

  late String imei;
  imei = '356938035643809';
  print('IMEI late: $imei');
}

void ejemploColecciones() {
  List<String> modelos = ['Galaxy S24', 'iPhone 15', 'Redmi Note 13'];
  var          precios = [899.99, 1099.99, 299.99];

  print('Primer modelo: ${modelos[0]}');
  print('Total modelos: ${modelos.length}');
  modelos.add('Pixel 8');
  modelos.remove('iPhone 15');

  Map<String, double> catalogo = {
    'Galaxy S24':   899.99,
    'iPhone 15':    1099.99,
    'Redmi Note 13': 299.99,
  };

  print('Precio Galaxy S24: \$${catalogo['Galaxy S24']}');
  print('Precio Pixel 8: ${catalogo['Pixel 8']}');
  catalogo['Moto G84'] = 349.99;

  Set<String> marcas = {'Samsung', 'Apple', 'Xiaomi'};
  marcas.add('Samsung');
  print('Total marcas únicas: ${marcas.length}');

  var carrito1 = [899.99, 299.99];
  var carrito2 = [1099.99, 349.99];
  var total = [...carrito1, ...carrito2];
  print('Carrito combinado: $total');

  bool tieneOferta = true;
  var items = [
    'Samsung Galaxy S24',
    'Redmi Note 13',
    if (tieneOferta) 'iPhone 15 con descuento',
  ];
  print('Items con condicional: $items');

  var preciosConIva = [for (var p in precios) p * 1.19];
  print('Precios + IVA: $preciosConIva');
}
