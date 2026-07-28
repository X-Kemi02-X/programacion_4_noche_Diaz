import 'package:flutter/material.dart';

class FormularioTelefono extends StatefulWidget {
  final void Function(Map<String, String> datos) onGuardar;
  const FormularioTelefono({super.key, required this.onGuardar});

  @override
  State<FormularioTelefono> createState() => _FormularioTelefonoState();
}

class _FormularioTelefonoState extends State<FormularioTelefono> {
  final _formKey = GlobalKey<FormState>();

  final _ctrlModelo = TextEditingController();
  final _ctrlMarca  = TextEditingController();
  final _ctrlPrecio = TextEditingController();
  final _ctrlStock  = TextEditingController(text: '10');
  final _ctrlColor  = TextEditingController();

  final _focusMarca  = FocusNode();
  final _focusPrecio = FocusNode();
  final _focusStock  = FocusNode();
  final _focusColor  = FocusNode();

  String _sistema = 'Android';
  bool   _disponible = true;

  @override
  void dispose() {
    _ctrlModelo.dispose();
    _ctrlMarca.dispose();
    _ctrlPrecio.dispose();
    _ctrlStock.dispose();
    _ctrlColor.dispose();
    _focusMarca.dispose();
    _focusPrecio.dispose();
    _focusStock.dispose();
    _focusColor.dispose();
    super.dispose();
  }

  void _guardar() {
    if (!_formKey.currentState!.validate()) return;

    widget.onGuardar({
      'modelo':     _ctrlModelo.text,
      'marca':      _ctrlMarca.text,
      'precio':     _ctrlPrecio.text,
      'stock':      _ctrlStock.text,
      'color':      _ctrlColor.text,
      'sistema':    _sistema,
      'disponible': _disponible.toString(),
    });
  }

  @override
  Widget build(BuildContext context) {
    return Form(
      key: _formKey,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          TextFormField(
            controller:      _ctrlModelo,
            decoration:      const InputDecoration(
              labelText:  'Modelo',
              hintText:   'Galaxy S25',
              prefixIcon: Icon(Icons.phone_android),
              border:     OutlineInputBorder(),
            ),
            textInputAction: TextInputAction.next,
            onFieldSubmitted: (_) => _focusMarca.requestFocus(),
            validator: (v) {
              if (v == null || v.trim().isEmpty) return 'El modelo es obligatorio';
              if (v.length < 3)                  return 'Mínimo 3 caracteres';
              return null;
            },
          ),
          const SizedBox(height: 12),
          TextFormField(
            controller:      _ctrlMarca,
            focusNode:       _focusMarca,
            decoration:      const InputDecoration(
              labelText:  'Marca',
              hintText:   'Samsung',
              prefixIcon: Icon(Icons.badge),
              border:     OutlineInputBorder(),
            ),
            textInputAction: TextInputAction.next,
            onFieldSubmitted: (_) => _focusPrecio.requestFocus(),
            validator: (v) =>
                v == null || v.trim().isEmpty ? 'La marca es obligatoria' : null,
          ),
          const SizedBox(height: 12),
          TextFormField(
            controller:      _ctrlPrecio,
            focusNode:       _focusPrecio,
            decoration:      const InputDecoration(
              labelText:  'Precio',
              prefixIcon: Icon(Icons.attach_money),
              border:     OutlineInputBorder(),
            ),
            keyboardType:    TextInputType.number,
            textInputAction: TextInputAction.next,
            onFieldSubmitted: (_) => _focusStock.requestFocus(),
            validator: (v) {
              final precio = double.tryParse(v ?? '');
              if (precio == null)       return 'Precio debe ser un número';
              if (precio <= 0)          return 'Precio debe ser mayor a 0';
              return null;
            },
          ),
          const SizedBox(height: 12),
          TextFormField(
            controller:      _ctrlStock,
            focusNode:       _focusStock,
            decoration:      const InputDecoration(
              labelText:  'Stock',
              prefixIcon: Icon(Icons.inventory),
              border:     OutlineInputBorder(),
            ),
            keyboardType:    TextInputType.number,
            textInputAction: TextInputAction.next,
            onFieldSubmitted: (_) => _focusColor.requestFocus(),
            validator: (v) {
              final stock = int.tryParse(v ?? '');
              if (stock == null)       return 'Stock debe ser un número entero';
              if (stock < 0)           return 'Stock no puede ser negativo';
              return null;
            },
          ),
          const SizedBox(height: 12),
          TextFormField(
            controller:      _ctrlColor,
            focusNode:       _focusColor,
            decoration:      const InputDecoration(
              labelText:  'Color',
              hintText:   'Negro',
              prefixIcon: Icon(Icons.palette),
              border:     OutlineInputBorder(),
            ),
            textInputAction: TextInputAction.next,
          ),
          const SizedBox(height: 12),
          DropdownButtonFormField<String>(
            initialValue: _sistema,
            decoration: const InputDecoration(
              labelText:  'Sistema Operativo',
              prefixIcon: Icon(Icons.settings),
              border:     OutlineInputBorder(),
            ),
            items: ['Android', 'iOS', 'HarmonyOS', 'Sin sistema']
                .map((s) => DropdownMenuItem(value: s, child: Text(s))).toList(),
            onChanged: (v) => setState(() => _sistema = v!),
          ),
          const SizedBox(height: 8),
          SwitchListTile(
            title:     const Text('Disponible'),
            subtitle:  const Text('Mostrar en catálogo'),
            value:     _disponible,
            onChanged: (v) => setState(() => _disponible = v),
            secondary: const Icon(Icons.visibility),
          ),
          const SizedBox(height: 16),
          Row(children: [
            Expanded(
              child: OutlinedButton(
                onPressed: () => _formKey.currentState?.reset(),
                child: const Text('Limpiar'),
              ),
            ),
            const SizedBox(width: 12),
            Expanded(
              flex: 2,
              child: FilledButton.icon(
                onPressed: _guardar,
                icon:  const Icon(Icons.save),
                label: const Text('Guardar teléfono'),
              ),
            ),
          ]),
        ],
      ),
    );
  }
}
