// lib/main.dart
import 'package:flutter/material.dart';
import 'widgets/formulario_producto.dart';
import 'models/telefono.dart';
import 'widgets/fila_producto.dart';
import 'screens/pantalla_productos.dart';
import 'screens/pantalla_busqueda.dart';

const int paso = 4;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  theme: ThemeData(
    colorScheme: ColorScheme.fromSeed(
      seedColor: const Color(0xFF1565C0),
    ),
    useMaterial3: true,
  ),
  home: switch (paso) {
    1 => const _Paso1(),
    2 => const _Paso2(),
    3 => const _Paso3(),
    4 => const PantallaTelefonos(),
    5 => const PantallaBusqueda(),
    _ => Scaffold(body: Center(child: Text('Paso $paso no definido'))),
  },
));

class _Paso1 extends StatefulWidget {
  const _Paso1();
  @override
  State<_Paso1> createState() => _Paso1State();
}

class _Paso1State extends State<_Paso1> {
  final _ctrlModelo = TextEditingController();
  final _ctrlMarca  = TextEditingController();
  final _ctrlPrecio = TextEditingController();
  final _ctrlStock  = TextEditingController(text: '10');
  final _focusMarca = FocusNode();
  final _focusPrecio = FocusNode();

  @override
  void dispose() {
    _ctrlModelo.dispose();
    _ctrlMarca.dispose();
    _ctrlPrecio.dispose();
    _ctrlStock.dispose();
    _focusMarca.dispose();
    _focusPrecio.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Registrar Teléfono'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              controller:      _ctrlModelo,
              decoration:      const InputDecoration(
                labelText:  'Modelo',
                hintText:   'Galaxy S25',
                prefixIcon: Icon(Icons.phone_android),
                border:     OutlineInputBorder(),
              ),
              textInputAction: TextInputAction.next,
              onSubmitted:     (_) => _focusMarca.requestFocus(),
            ),
            const SizedBox(height: 12),
            TextField(
              controller:      _ctrlMarca,
              focusNode:       _focusMarca,
              decoration:      const InputDecoration(
                labelText:  'Marca',
                hintText:   'Samsung',
                prefixIcon: Icon(Icons.badge),
                border:     OutlineInputBorder(),
              ),
              textInputAction: TextInputAction.next,
              onSubmitted:     (_) => _focusPrecio.requestFocus(),
            ),
            const SizedBox(height: 12),
            TextField(
              controller:      _ctrlPrecio,
              focusNode:       _focusPrecio,
              decoration:      const InputDecoration(
                labelText:  'Precio',
                prefixIcon: Icon(Icons.attach_money),
                border:     OutlineInputBorder(),
              ),
              keyboardType:    TextInputType.number,
              textInputAction: TextInputAction.next,
              onSubmitted:     (_) => FocusScope.of(context).unfocus(),
            ),
            const SizedBox(height: 12),
            TextField(
              controller:      _ctrlStock,
              decoration:      const InputDecoration(
                labelText:  'Stock',
                prefixIcon: Icon(Icons.inventory),
                border:     OutlineInputBorder(),
              ),
              keyboardType:    TextInputType.number,
              textInputAction: TextInputAction.done,
            ),
            const SizedBox(height: 20),
            FilledButton.icon(
              onPressed: () {
                FocusScope.of(context).unfocus();
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                    content: Text('${_ctrlModelo.text} (${_ctrlMarca.text}) registrado'),
                    behavior: SnackBarBehavior.floating,
                  ),
                );
              },
              icon:  const Icon(Icons.save),
              label: const Text('Guardar'),
            ),
          ],
        ),
      ),
    );
  }
}

class _Paso2 extends StatelessWidget {
  const _Paso2();

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Nuevo teléfono'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: FormularioTelefono(
          onGuardar: (datos) {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(
                content: Text(
                    'Guardado: ${datos['modelo']} — ${datos['marca']} \$${datos['precio']}'),
                behavior: SnackBarBehavior.floating,
              ),
            );
          },
        ),
      ),
    );
  }
}

class _Paso3 extends StatefulWidget {
  const _Paso3();
  @override
  State<_Paso3> createState() => _Paso3State();
}

class _Paso3State extends State<_Paso3> {
  final _telefonos = [
    Telefono(id:'1', modelo:'Galaxy S25',    marca:'Samsung',  precio:899.99,  stock:15, color:'Negro',  sistema:'Android', favorito:true),
    Telefono(id:'2', modelo:'iPhone 16',      marca:'Apple',    precio:999.99,  stock:0,  color:'Blanco', sistema:'iOS',     disponible: false),
    Telefono(id:'3', modelo:'Redmi Note 13',  marca:'Xiaomi',   precio:299.99,  stock:8,  color:'Azul',   sistema:'Android'),
    Telefono(id:'4', modelo:'Edge 50 Pro',    marca:'Motorola', precio:449.99,  stock:5,  color:'Gris',   sistema:'Android'),
  ];

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Teléfonos (${_telefonos.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: _telefonos.isEmpty
          ? Center(
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Icon(Icons.phone_android, size: 56, color: cs.onSurfaceVariant),
                  const SizedBox(height: 12),
                  Text('Sin teléfonos', style: TextStyle(color: cs.onSurfaceVariant)),
                ],
              ),
            )
          : ListView.separated(
              itemCount:        _telefonos.length,
              separatorBuilder: (_, _) => const Divider(height: 1, indent: 72),
              itemBuilder: (ctx, i) => FilaTelefono(
                telefono:   _telefonos[i],
                onFavorito: () => setState(() =>
                    _telefonos[i].favorito = !_telefonos[i].favorito),
                onEliminar: () => setState(() => _telefonos.removeAt(i)),
              ),
            ),
    );
  }
}