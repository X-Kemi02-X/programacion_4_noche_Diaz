import 'dart:io';
void main() {
  double suma = 0;
  double precio = -1.0;
  while (precio != 0.0) {
    print('Ingrese el precio del celular (0 para finalizar): ');
    precio = double.parse(stdin.readLineSync()!);
    suma += precio;
  }
  print('El total del carrito de celulares es: \$$suma');
}
