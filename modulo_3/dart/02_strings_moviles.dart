void main() {
  final modelo = 'Galaxy S24';
  final precio = 899.99;

  print('Modelo: $modelo');
  print('${modelo.toUpperCase()} cuesta \$${precio + 100} con impuestos');

  final ficha = '''
Modelo: $modelo
Precio: \$$precio
Gama:   ${precio > 700 ? 'Alta' : 'Media'}
  ''';
  print(ficha);

  final codigoProducto = r'SKU\SAMSUNG\S24';
  print(codigoProducto);

  final saludo = 'Bienvenido, ' + modelo + '!';

  print('xiaomi'.toUpperCase());
  print('  iPhone 15  '.trim());
  print('Smartphone'.contains('phone'));
  print('Samsung'.replaceAll('S', 's'));
  print('apple,google,xiaomi'.split(','));
  print('iPhone 15 Pro Max'.substring(0, 6));
  print('Galaxy'.startsWith('Gal'));
  print('99'.padLeft(5, '0'));
}
