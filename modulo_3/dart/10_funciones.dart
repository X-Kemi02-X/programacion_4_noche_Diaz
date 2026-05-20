// Funcion sin parametros y sin retorno
void saludar() {
  print('Hola mundo');
}

// Funcion con parametros y sin retorno
void saludoConParametro(String nombre) {
  print('Hola $nombre');
}
//Funcion sin parametros y con retorno
int obtenerNumero() {
  return 20;
}
//Funcion con parametros y con retorno
int sumar(int a, int b) {
  return a+b;
}
//Funcion flecha (arrow function)
int multiplicar(int a, int b)=>a*b;
//Funcion con parametros opcionales
void saludarOpcional(String nombre, [String apellido='Sin apellido']){
  print('Hola $nombre $apellido');
}
//Funcion con parámetros nombrados
void registroUsuario({
  required String nombre,
  required int edad,
}){
  print("Hola $nombre edad: $edad");
}

void  main(){
  saludar();
  saludoConParametro('Kevin Diaz');
  int numero = obtenerNumero();
  print(numero);
  print('el numero es : ${obtenerNumero()}');
  print('la suma : ${sumar(5,5)}');
  print('la multiplicacion : ${multiplicar(5,5)}');
  saludarOpcional('Kevin', 'Diaz');
  saludarOpcional('Elizabeth');
  registroUsuario(
    nombre: 'Kev',
    edad: 22,
  );
}



