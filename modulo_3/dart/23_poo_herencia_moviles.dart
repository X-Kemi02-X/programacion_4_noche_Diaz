class TelefonoBase {
  final String modelo;
  final double precioBase;

  TelefonoBase(this.modelo, this.precioBase);

  String obtenerTipo() => 'Genérico';

  void presentarse() {
    print('$modelo - \$${precioBase} - Tipo: ${obtenerTipo()}');
  }
}

class GamingPhone extends TelefonoBase {
  GamingPhone(super.modelo, super.precioBase);

  @override
  String obtenerTipo() => 'Gaming';

  void modoTurbo() => print('$modelo activa modo turbo');
}

class CameraPhone extends TelefonoBase {
  CameraPhone(super.modelo, super.precioBase);

  @override
  String obtenerTipo() => 'Cámara';

  void modoNoche() => print('$modelo activa modo nocturno');
}

void main() {
  final gaming = GamingPhone('ROG Phone 8', 1199.99);
  final camera = CameraPhone('Pixel 8 Pro', 999.99);

  gaming.presentarse();
  camera.presentarse();

  gaming.modoTurbo();
  camera.modoNoche();
}
