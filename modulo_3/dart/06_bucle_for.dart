void main() {
  print('=== 1. FOR TRADICIONAL CON ÍNDICE ===');
  // for con índice — cuando necesitas el número de iteración
  for (int i = 0; i < 5; i++) {
    print('Iteración $i');
  }

  print('\n=== 2. FOR CON PASO PERSONALIZADO ===');
  // for con paso distinto
  for (int i = 0; i <= 100; i += 25) {
    print('Progreso: $i%');
  }

  print('\n=== 3. FOR DECRECIENTE ===');
  // for decreciente
  for (int i = 5; i >= 1; i--) {
    print('Cuenta regresiva: $i');
  }

  print('\n=== 4. FOR-IN SOBRE UNA LISTA ===');
  final protocolos = ['HTTP', 'HTTPS', 'FTP', 'SSH', 'SMTP'];

  // for-in — la forma idiomática para recorrer listas (como in en Kotlin)
  for (final protocolo in protocolos) {
    print(protocolo);
  }

  print('\n=== 5. FOREACH CON LAMBDA ===');
  // forEach con lambda — alternativa funcional
  protocolos.forEach((p) => print(p.toLowerCase()));

  print('\n=== 6. FOR-IN SOBRE UN MAP ===');
  // for-in sobre las entradas (entries) de un Map
  final puertos = {'HTTP': 80, 'HTTPS': 443, 'SSH': 22, 'FTP': 21};
  for (final entrada in puertos.entries) {
    print('${entrada.key} → puerto ${entrada.value}');
  }

  print('\n=== 7. FOR-IN SOBRE UN STRING ===');
  // SOLUCIONADO: .split('') transforma el String en una List<String> iterable
  for (final caracter in 'Dart'.split('')) {
    print(caracter);
  }
}