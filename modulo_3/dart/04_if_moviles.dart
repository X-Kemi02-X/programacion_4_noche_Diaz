void main() {
  String? modelo;

  if (modelo != null) {
    print(modelo.length);
  }

  print(modelo?.length);

  int longitud = modelo?.length ?? 0;
  print(longitud);

  double precio = 1299.99;

  if (precio > 1000) {
    print('Gama alta');
  } else if (precio > 500) {
    print('Gama media');
  } else {
    print('Gama baja');
  }

  String categoria = precio > 1000 ? 'Premium' : 'Económico';
  print(categoria);

  String? marca;
  String display = marca != null ? marca.toUpperCase() : 'Sin marca';
  print(display);

  String display2 = marca?.toUpperCase() ?? 'Sin marca';
  print(display2);
}
