void main() {
  print('=== 1. FOR TRADICIONAL CON ÍNDICE ===');
  for (int i = 0; i < 5; i++) {
    print('Teléfono #${i + 1} en catálogo');
  }

  print('\n=== 2. FOR CON PASO PERSONALIZADO ===');
  for (int i = 0; i <= 100; i += 25) {
    print('Descuento: $i%');
  }

  print('\n=== 3. FOR DECRECIENTE ===');
  for (int i = 5; i >= 1; i--) {
    print('Stock decreciente: $i unidades');
  }

  print('\n=== 4. FOR-IN SOBRE UNA LISTA ===');
  final marcas = ['Samsung', 'Apple', 'Xiaomi', 'Google', 'Motorola'];

  for (final marca in marcas) {
    print(marca);
  }

  print('\n=== 5. FOREACH CON LAMBDA ===');
  marcas.forEach((m) => print(m.toLowerCase()));

  print('\n=== 6. FOR-IN SOBRE UN MAP ===');
  final precios = {'Samsung': 899.99, 'Apple': 1099.99, 'Xiaomi': 299.99};
  for (final entrada in precios.entries) {
    print('${entrada.key} → \$${entrada.value}');
  }

  print('\n=== 7. FOR-IN SOBRE UN STRING ===');
  for (final caracter in 'iPhone'.split('')) {
    print(caracter);
  }
}
