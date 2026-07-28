import 'package:flutter/material.dart';

class PantallaDialogs extends StatelessWidget {
  const PantallaDialogs({super.key});

  void _mostrarSnackBar(BuildContext context, {bool esError = false}) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(esError
            ? 'Error: no se pudo agregar al carrito'
            : 'Producto agregado al carrito correctamente'),
        backgroundColor: esError
            ? Theme.of(context).colorScheme.error
            : null,
        action: SnackBarAction(
          label:    'Deshacer',
          onPressed: () {},
        ),
        behavior:  SnackBarBehavior.floating,
        shape:     RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
        duration:  const Duration(seconds: 3),
      ),
    );
  }

  Future<void> _mostrarConfirmacion(BuildContext context) async {
    final confirmar = await showDialog<bool>(
      context: context,
      builder: (ctx) => AlertDialog(
        icon:    const Icon(Icons.warning_amber, color: Colors.orange),
        title:   const Text('Eliminar producto'),
        content: const Text(
          '¿Estás seguro de que deseas eliminar Samsung Galaxy S25?\n'
          'Esta acción no se puede deshacer.',
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx, false),
            child:     const Text('Cancelar'),
          ),
          FilledButton(
            style: FilledButton.styleFrom(
              backgroundColor: Theme.of(ctx).colorScheme.error,
            ),
            onPressed: () => Navigator.pop(ctx, true),
            child: const Text('Eliminar'),
          ),
        ],
      ),
    );

    if (!context.mounted) return;

    if (confirmar == true) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Producto eliminado correctamente')),
      );
    }
  }

  Future<void> _mostrarFormulario(BuildContext context) async {
    final formKey = GlobalKey<FormState>();
    final ctrlModelo = TextEditingController();
    final ctrlPrecio     = TextEditingController();

    await showDialog<void>(
      context: context,
      builder: (ctx) => AlertDialog(
        title: const Text('Agregar producto'),
        content: Form(
          key: formKey,
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              TextFormField(
                controller:  ctrlModelo,
                decoration:  const InputDecoration(labelText: 'Modelo'),
                validator:   (v) => v == null || v.isEmpty ? 'Campo requerido' : null,
              ),
              const SizedBox(height: 8),
              TextFormField(
                controller: ctrlPrecio,
                decoration: const InputDecoration(labelText: 'Precio'),
                validator:  (v) {
                  if (v == null || v.isEmpty) return 'Campo requerido';
                  if (double.tryParse(v) == null) return 'Ingrese un número válido';
                  return null;
                },
              ),
            ],
          ),
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx),
            child:     const Text('Cancelar'),
          ),
          FilledButton(
            onPressed: () {
              if (formKey.currentState!.validate()) {
                Navigator.pop(ctx);
              }
            },
            child: const Text('Agregar'),
          ),
        ],
      ),
    );

    if (!context.mounted) return;
    if (ctrlModelo.text.isNotEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Producto "${ctrlModelo.text}" agregado')),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    final cs   = Theme.of(context).colorScheme;
    final text = Theme.of(context).textTheme;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('SnackBar y Dialog'),
        backgroundColor: cs.surfaceContainerHighest,
      ),
      body: ListView(
        padding: const EdgeInsets.all(16),
        children: [

          Text('SnackBar', style: text.labelLarge?.copyWith(color: cs.primary)),
          const SizedBox(height: 12),
          FilledButton.icon(
            onPressed: () => _mostrarSnackBar(context),
            icon:  const Icon(Icons.check_circle_outline),
            label: const Text('SnackBar de éxito'),
          ),
          const SizedBox(height: 8),
          FilledButton.icon(
            style: FilledButton.styleFrom(
              backgroundColor: cs.error,
              foregroundColor: cs.onError,
            ),
            onPressed: () => _mostrarSnackBar(context, esError: true),
            icon:  const Icon(Icons.error_outline),
            label: const Text('SnackBar de error'),
          ),

          const Divider(height: 32),

          Text('AlertDialog', style: text.labelLarge?.copyWith(color: cs.primary)),
          const SizedBox(height: 12),
          OutlinedButton.icon(
            style: OutlinedButton.styleFrom(
              foregroundColor: cs.error,
              side: BorderSide(color: cs.error),
            ),
            onPressed: () => _mostrarConfirmacion(context),
            icon:  const Icon(Icons.delete_outline),
            label: const Text('Eliminar producto (confirmación)'),
          ),
          const SizedBox(height: 8),
          FilledButton.tonal(
            onPressed: () => _mostrarFormulario(context),
            child: const Text('Agregar producto (formulario)'),
          ),
        ],
      ),
    );
  }
}
