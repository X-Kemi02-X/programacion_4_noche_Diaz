// lib/main.dart
import 'package:flutter/material.dart';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1   StatelessWidget mínimo                             │
// │  2  Paso 1b  Widgets básicos — catálogo                        │
// │  3  Paso 2   StatelessWidget con parámetros                     │
// │  4  Paso 3   StatefulWidget / setState / cambio de estatus      │
// │  5  Paso 3b  Parámetros en StatefulWidget                       │
// │  6  Paso 4   Ciclo de vida con Timer                            │
// │  7  Paso 5   BuildContext                                        │
// │  8  Paso 6   Composición de widgets                             │
// └──────────────────────────────────────────────────────────────────┘
const int paso = 1;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  home: switch (paso) {
    1 => const Scaffold(body: Center(child: Saludo())),
    _ => Scaffold(body: Center(child: Text('Paso $paso: crea el widget primero'))),
  },
));

class Saludo extends StatelessWidget {
  const Saludo({super.key});
  Widget build(BuildContext context) {
    // describe cómo se ve
    return const SelectableText (
      'Empresa periodística con diarios regionales, de carácter local. Nuestras 8 ediciones se enfocan en cubrir las necesidades de los lectores en cada comunidad.',
      textAlign: TextAlign.left,
      style: TextStyle(
        fontSize: 32,
        fontWeight: FontWeight.bold,
        letterSpacing: 4,
        color: Colors.deepOrange,
        shadows: [Shadow(color: Colors.black26, blurRadius: 4, offset: Offset(2,2))]
      ),
      // overflow: TextOverflow.ellipsis,
      maxLines: 5,
    );
  }
}
