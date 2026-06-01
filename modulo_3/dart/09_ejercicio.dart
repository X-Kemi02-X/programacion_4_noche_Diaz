import 'dart:io';
void main() {
  /*print('Ingrese un numero entero: ');
  int numero = int.parse(stdin.readLineSync()!);

  if (numero > 0) {
    print('El numero es positivo');
  } else if (numero < 0) {
    print('El numero es negativo');
  } else {
    print('El numero es cero');
  }*/


  /*int suma = 0;
  int numero = -1;
  while (numero != 0) {
    print('Ingrese un numero (0 para finalizar): ');
    numero = int.parse(stdin.readLineSync()!);
    suma += numero;
  }

  print('La suma total es: $suma'); */

  double suma = 0;
  double precio = -1.0;
  while (precio != 0.0) {
    print('Ingrese el precio del plato (0 para finalizar): ');
    precio = double.parse(stdin.readLineSync()!);
    suma += precio;
  }
  print('La suma total de los platos es: $suma');
}