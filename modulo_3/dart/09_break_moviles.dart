void main() {
  final almacenes = ['NORTE', 'SUR', 'CENTRO'];
  final estantes  = ['ESTANTE-A', 'ESTANTE-B', 'ESTANTE-C'];

  String? celularEncontrado;

  busqueda:
  for (final almacen in almacenes) {
    for (final estante in estantes) {
      final ubicacion = '$almacen/$estante';
      print('Buscando en $ubicacion...');

      if (almacen == 'SUR' && estante == 'ESTANTE-B') {
        celularEncontrado = ubicacion;
        break busqueda;
      }
    }
  }

  print('Celular encontrado en: $celularEncontrado');
}
