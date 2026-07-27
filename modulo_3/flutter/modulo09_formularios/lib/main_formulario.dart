import 'package:flutter/material.dart';

void main() => runApp(const AppTiendaMovil());

class AppTiendaMovil extends StatelessWidget {
  const AppTiendaMovil({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: const Color(0xFF1565C0),
        ),
        useMaterial3: true,
      ),
      home: const _PantallaTelefono(),
    );
  }
}

class _PantallaTelefono extends StatefulWidget {
  const _PantallaTelefono();
  @override
  State<_PantallaTelefono> createState() => _PantallaTelefonoState();
}

class _PantallaTelefonoState extends State<_PantallaTelefono> {
  final _ctrlModelo = TextEditingController();
  final _ctrlMarca  = TextEditingController();
  final _ctrlPrecio = TextEditingController();
  final _ctrlStock  = TextEditingController(text: '10');

  final _focusMarca  = FocusNode();
  final _focusPrecio = FocusNode();
  final _focusStock  = FocusNode();

  @override
  void dispose() {
    _ctrlModelo.dispose();
    _ctrlMarca.dispose();
    _ctrlPrecio.dispose();
    _ctrlStock.dispose();
    _focusMarca.dispose();
    _focusPrecio.dispose();
    _focusStock.dispose();
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
              onSubmitted:     (_) => _focusStock.requestFocus(),
            ),
            const SizedBox(height: 12),
            TextField(
              controller:      _ctrlStock,
              focusNode:       _focusStock,
              decoration:      const InputDecoration(
                labelText:  'Stock inicial',
                prefixIcon: Icon(Icons.inventory),
                border:     OutlineInputBorder(),
              ),
              keyboardType:    TextInputType.number,
              textInputAction: TextInputAction.done,
              onSubmitted:     (_) => FocusScope.of(context).unfocus(),
            ),
            const SizedBox(height: 20),
            FilledButton.icon(
              onPressed: () {
                FocusScope.of(context).unfocus();
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                    content: Text(
                      '${_ctrlModelo.text} (${_ctrlMarca.text}) registrado',
                    ),
                    behavior: SnackBarBehavior.floating,
                  ),
                );
              },
              icon:  const Icon(Icons.save),
              label: const Text('Guardar teléfono'),
            ),
            const SizedBox(height: 8),
            OutlinedButton(
              onPressed: () {
                _ctrlModelo.clear();
                _ctrlMarca.clear();
                _ctrlPrecio.clear();
                _ctrlStock.text = '10';
              },
              child: const Text('Limpiar campos'),
            ),
          ],
        ),
      ),
    );
  }
}
