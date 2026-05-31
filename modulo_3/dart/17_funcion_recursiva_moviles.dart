int combinacionesAccesorios(int n) {
  if (n <= 1) return 1;
  return n * combinacionesAccesorios(n - 1);
}

int formasDePago(int n) {
  if (n <= 1) return n;
  return formasDePago(n - 1) + formasDePago(n - 2);
}

int contarCategorias(Map<String, dynamic> categoria) {
  int total = 0;
  for (final entrada in categoria.entries) {
    if (entrada.value is Map) {
      total += contarCategorias(entrada.value as Map<String, dynamic>);
    } else {
      total++;
    }
  }
  return total;
}

void main() {
  print(combinacionesAccesorios(6));
  print(formasDePago(10));

  final arbolCelulares = {
    'Smartphones': {
      'Samsung': {'Galaxy S24': true, 'Galaxy A54': true, 'Galaxy Z Fold': true},
      'Apple': {'iPhone 15': true, 'iPhone 14': true},
      'Xiaomi': {'Redmi Note 13': true, 'Poco X6': true},
    },
    'Accesorios': {'Funda': true, 'Cargador': true},
    'inventario.json': true,
  };

  print('Total de modelos: ${contarCategorias(arbolCelulares)}');
}
