import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../models/telefono.dart';

class PantallaDetalle extends StatelessWidget {
  final String    id;
  final Telefono? telefono;

  const PantallaDetalle({super.key, required this.id, this.telefono});

  @override
  Widget build(BuildContext context) {
    final tel = telefono ??
        telefonosSimulados.where((t) => t.id == id).firstOrNull;

    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Detalle: ${tel?.modelo ?? id}'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: tel == null
          ? Center(child: Text('Teléfono $id no encontrado'))
          : Padding(
              padding: const EdgeInsets.all(16),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  _Fila('ID',     tel.id),
                  _Fila('Modelo', tel.modelo),
                  _Fila('Marca',  tel.marca),
                  _Fila('Precio', '\$${tel.precio.toStringAsFixed(2)}'),
                  const SizedBox(height: 24),
                  Row(children: [
                    OutlinedButton.icon(
                      onPressed: () => context.pop(),
                      icon:  const Icon(Icons.arrow_back),
                      label: const Text('Volver'),
                    ),
                  ]),
                ],
              ),
            ),
    );
  }
}

class _Fila extends StatelessWidget {
  final String label;
  final String valor;
  const _Fila(this.label, this.valor);

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 6),
      child: Row(children: [
        SizedBox(
          width: 70,
          child: Text(label,
              style: TextStyle(color: cs.onSurfaceVariant,
                  fontWeight: FontWeight.w600, fontSize: 12)),
        ),
        Text(valor, style: const TextStyle(fontSize: 15)),
      ]),
    );
  }
}