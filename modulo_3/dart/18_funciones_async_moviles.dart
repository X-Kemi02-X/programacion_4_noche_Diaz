import 'dart:io';

Future<int> consultarStockOnline() async {
  await Future.delayed(Duration(milliseconds: 200));
  return 42;
}

void main() async {
  print('Consultando stock...');
  final stock = await consultarStockOnline();
  print('Stock disponible: $stock unidades');
  print('Consulta completada');
}
