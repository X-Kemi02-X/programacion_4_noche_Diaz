import 'package:flutter/material.dart';

class CatalogoBotones extends StatelessWidget {
  const CatalogoBotones({super.key});

  @override
  Widget build(BuildContext context) {
    final cs   = Theme.of(context).colorScheme;
    final text = Theme.of(context).textTheme;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Botones Material 3'),
        backgroundColor: cs.surfaceContainerHighest,
      ),
      body: ListView(
        padding: const EdgeInsets.all(16),
        children: [

          Text('Variantes — de mayor a menor énfasis',
              style: text.labelLarge?.copyWith(color: cs.primary)),
          const SizedBox(height: 12),
          FilledButton(
            onPressed: () {},
            child: const Text('FilledButton — acción principal'),
          ),
          const SizedBox(height: 8),
          FilledButton.tonal(
            onPressed: () {},
            child: const Text('FilledButton.tonal — acción secundaria'),
          ),
          const SizedBox(height: 8),
          ElevatedButton(
            onPressed: () {},
            child: const Text('ElevatedButton — acción con sombra'),
          ),
          const SizedBox(height: 8),
          OutlinedButton(
            onPressed: () {},
            child: const Text('OutlinedButton — acción con borde'),
          ),
          const SizedBox(height: 8),
          TextButton(
            onPressed: () {},
            child: const Text('TextButton — acción mínima'),
          ),

          const Divider(height: 32),

          Text('Con ícono',
              style: text.labelLarge?.copyWith(color: cs.primary)),
          const SizedBox(height: 12),
          FilledButton.icon(
            onPressed: () {},
            icon:  const Icon(Icons.send),
            label: const Text('Enviar reporte'),
          ),
          const SizedBox(height: 8),
          OutlinedButton.icon(
            onPressed: () {},
            icon:  const Icon(Icons.download),
            label: const Text('Exportar logs'),
          ),
          const SizedBox(height: 8),
          TextButton.icon(
            onPressed: () {},
            icon:  const Icon(Icons.open_in_new),
            label: const Text('Ver documentación'),
          ),

          const Divider(height: 32),

          Text('Estados y personalización',
              style: text.labelLarge?.copyWith(color: cs.primary)),
          const SizedBox(height: 12),
          FilledButton(
            onPressed: null,
            child: const Text('No disponible — onPressed: null'),
          ),
          const SizedBox(height: 8),
          FilledButton(
            style: FilledButton.styleFrom(
              backgroundColor: cs.error,
              foregroundColor: cs.onError,
              minimumSize:     const Size(double.infinity, 48),
            ),
            onPressed: () {},
            child: const Text('Eliminar servidor — con cs.error'),
          ),
          const SizedBox(height: 8),
          FilledButton(
            style: FilledButton.styleFrom(
              backgroundColor: cs.errorContainer,
              foregroundColor: cs.onErrorContainer,
              minimumSize:     const Size(double.infinity, 48),
            ),
            onPressed: () {},
            child: const Text('Eliminar servidor — con cs.errorContainer'),
          ),
          const SizedBox(height: 16),
          Row(children: [
            Expanded(
              child: OutlinedButton(onPressed: () {}, child: const Text('Reiniciar')),
            ),
            const SizedBox(width: 8),
            Expanded(
              child: FilledButton(onPressed: () {}, child: const Text('Apagar')),
            ),
          ]),

          const Divider(height: 32),

          Text('Íconos solos',
              style: text.labelLarge?.copyWith(color: cs.primary)),
          const SizedBox(height: 12),
          Row(children: [
            IconButton(
              icon: const Icon(Icons.delete),
              onPressed: () {},
              tooltip: 'Eliminar',
            ),
            IconButton(
              icon: const Icon(Icons.edit),
              onPressed: () {},
              tooltip: 'Editar',
            ),
            IconButton(
              icon: const Icon(Icons.share),
              onPressed: () {},
              tooltip: 'Compartir',
            ),
            IconButton(
              icon: const Icon(Icons.more_vert),
              onPressed: () {},
              tooltip: 'Más opciones',
            ),
          ]),

          const Divider(height: 32),

          Text('OutlinedButton → FilledButton.tonal (comparación)',
              style: text.labelLarge?.copyWith(color: cs.primary)),
          const SizedBox(height: 12),
          OutlinedButton(onPressed: () {}, child: const Text('OutlinedButton')),
          const SizedBox(height: 8),
          FilledButton.tonal(onPressed: () {}, child: const Text('FilledButton.tonal')),
        ],
      ),
    );
  }
}
