import 'dart:io';

void main() {
  print('Ingrese el modelo del teléfono: ');
  String? modelo = stdin.readLineSync();
  print('Modelo registrado: $modelo');

  print('Ingrese el precio del teléfono: ');
  double precio = double.parse(stdin.readLineSync()!);
  print('Precio: \$$precio');

  print('Ingrese el porcentaje de descuento: ');
  double descuento = double.parse(stdin.readLineSync()!);
  print('Descuento: $descuento%');

  print('Ingrese la cantidad de unidades: ');
  int cantidad = int.parse(stdin.readLineSync()!);
  print('Ingrese el precio por unidad: ');
  int precioUnitario = int.parse(stdin.readLineSync()!);
  int total = cantidad * precioUnitario;
  print('El total de la venta es: \$$total');

  print('Ingrese el número de celulares: ');
  int numCelulares = int.parse(stdin.readLineSync()!);
  print('Ingrese el precio de cada uno: ');
  int precioCadaUno = int.parse(stdin.readLineSync()!);
  int resultado = 0;
  for (int i = 0; i < precioCadaUno; i++) {
    resultado += numCelulares;
  }
  print('El resultado de la multiplicación es: $resultado');
}
