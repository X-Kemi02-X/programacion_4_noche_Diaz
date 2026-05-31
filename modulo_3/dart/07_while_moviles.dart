void main() {
  int cajas = 0;
  int stockTotal = 500;

  while (stockTotal > 0) {
    final lote = stockTotal > 50 ? 50 : stockTotal;
    cajas++;
    stockTotal -= lote;
    print('Caja $cajas: $lote teléfonos (restante: $stockTotal)');
  }

  int reintentos = 0;
  bool conexionServidor = false;

  do {
    reintentos++;
    print('Consultando stock al servidor #$reintentos...');
    if (reintentos == 3) conexionServidor = true;
  } while (!conexionServidor && reintentos < 5);

  print(conexionServidor
      ? 'Stock consultado tras $reintentos intentos'
      : 'No se pudo consultar el stock');
}
