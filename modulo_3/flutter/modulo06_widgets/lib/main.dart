import 'package:flutter/material.dart';
import 'widgets/catalogo_basicos.dart';
import 'widgets/etiqueta.dart';
import 'widgets/servicio_estado.dart';
import 'widgets/contador_limitado.dart';
import 'widgets/reloj.dart';
import 'widgets/pantalla_contexto.dart';
import 'widgets/indicador.dart';

const int paso = 8;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  theme: ThemeData(
    colorScheme:  ColorScheme.fromSeed(
      seedColor:  const Color.fromARGB(255, 21, 101, 192),
      brightness: Brightness.dark,
    ),
    useMaterial3: true,
  ),
  home: switch (paso) {
    1 => const Scaffold(body: Center(child: Saludo())),
    2 => const CatalogoBasicos(),
    3 => const Scaffold(
      body: Center(
        child: Wrap(
          spacing:    12,
          runSpacing: 8,
          children: [
            Etiqueta(texto: 'Disponible', color: Colors.green),
            Etiqueta(texto: 'Agotado',    color: Colors.red,    relleno: true),
            Etiqueta(texto: 'Oferta',     color: Colors.orange),
            Etiqueta(texto: 'Nuevo',      color: Colors.blue,   fontSize: 16, relleno: true),
          ],
        ),
      ),
    ),
    4 => const Scaffold(
      body: Center(
        child: ServicioEstado(nombre: 'Galaxy S25'),
      ),
    ),
    5 => Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ContadorLimitado(
              etiqueta: 'Stock mínimo',
              limite:   3,
              color:    const Color.fromARGB(255, 54, 216, 244),
              onLimite: () => debugPrint('¡Stock agotado!'),
            ),
            const SizedBox(height: 40),
            ContadorLimitado(
              etiqueta: 'En carrito',
              limite:   10,
              color:    const Color.fromARGB(255, 187, 255, 0),
            ),
          ],
        ),
      ),
    ),
    6 => Scaffold(
      appBar: AppBar(title: const Text('Tiempo en tienda')),
      body: const Center(child: Reloj()),
    ),
    7 => const PantallaContexto(),
    8 => Scaffold(
      body: Center(
        child: Wrap(
          spacing:    32,
          runSpacing: 24,
          alignment:  WrapAlignment.center,
          children: const [
            Indicador(label: 'Teléfonos activos', valor: '12',
                      color: Colors.green, icono: Icons.phone_android),
            Indicador(label: 'Ofertas',           valor: '3',
                      color: Colors.red,   icono: Icons.discount,
                      subtitulo: 'Requieren atención'),
            Indicador(label: 'Stock total',       valor: '42',
                      color: Colors.indigo),
            Indicador(label: 'Valor inventario',  valor: '\$8,500',
                      color: Colors.teal, subtitulo: 'Precio total'),
          ],
        ),
      ),
    ),
    _ => Scaffold(body: Center(child: Text('Paso $paso: crea el widget primero'))),
  },
));

class Saludo extends StatelessWidget {
  const Saludo({super.key});
  @override
  Widget build(BuildContext context) {
    return const SelectableText (
      'Bienvenido a Tienda Móvil - Venta de Celulares',
      textAlign: TextAlign.left,
      style: TextStyle(
        fontSize: 32,
        fontWeight: FontWeight.bold,
        letterSpacing: 4,
        color: Colors.blue,
        shadows: [Shadow(color: Colors.black26, blurRadius: 4, offset: Offset(2,2))]
      ),
      maxLines: 5,
    );
  }
}
