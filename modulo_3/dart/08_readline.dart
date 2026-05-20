import 'dart:io';

void main() {
  print('Ingrese su nombre: ');
  String? nombre = stdin.readLineSync();
  print('Hola $nombre');

  print('Ingrese un número entero: ');
  int numero = int.parse(stdin.readLineSync()!);
  print('Número: $numero');

  print('Ingrese un decimal: ');
  double valor = double.parse(stdin.readLineSync()!);
  print('Valor: $valor');


  print('Ingrese un numero: ');
  int numero1 = int.parse(stdin.readLineSync()!);
  print('Ingrese el segundo numero: ');
  int numero2 = int.parse(stdin.readLineSync()!);
  int resultado = numero1 * numero2;
  print('La multiplacion de los valores ingresados es: $resultado');


  print('Ingrese un numero: ');
  int numero3 = int.parse(stdin.readLineSync()!);
  print('Ingrese el segundo numero: ');
  int numero4 = int.parse(stdin.readLineSync()!);
  int resultado = 0;
  for (int i = 0; i < numero4; i++) {
    resultado += numero3;
  }
  print('El resultado de la multiplicacion es: $resultado');
}