import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../models/telefono.dart';
import '../providers/servidores_provider.dart';

class PantallaTelefonos extends ConsumerWidget {
  const PantallaTelefonos({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final telefonos = ref.watch(telefonosProvider);
    final cs        = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Teléfonos (${telefonos.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: telefonos.isEmpty
          ? const Center(child: Text('Sin teléfonos'))
          : ListView.separated(
              itemCount:        telefonos.length,
              separatorBuilder: (_, _) =>
                  const Divider(height: 1, indent: 72),
              itemBuilder: (context, i) {
                final t = telefonos[i];
                return ListTile(
                  leading: CircleAvatar(
                    backgroundColor: t.disponible
                        ? Colors.green.shade50
                        : Colors.grey.shade100,
                    child: Icon(Icons.phone_android,
                        color: t.disponible ? Colors.green : Colors.grey),
                  ),
                  title:    Text(t.modelo,
                      style: const TextStyle(fontWeight: FontWeight.w600)),
                  subtitle: Text('${t.marca} - \$${t.precio.toStringAsFixed(2)}'),
                  trailing: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      IconButton(
                        icon: Icon(
                          t.favorito ? Icons.star : Icons.star_border,
                          color: t.favorito ? Colors.amber : null,
                        ),
                        onPressed: () => ref
                            .read(telefonosProvider.notifier)
                            .toggleFavorito(t.id),
                      ),
                      IconButton(
                        icon: const Icon(Icons.delete_outline,
                            color: Colors.red),
                        onPressed: () => ref
                            .read(telefonosProvider.notifier)
                            .eliminar(t.id),
                      ),
                    ],
                  ),
                );
              },
            ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          final id = DateTime.now().millisecondsSinceEpoch.toString();
          ref.read(telefonosProvider.notifier).agregar(
            Telefono(
              id:     id,
              modelo: 'Modelo-$id',
              marca:  'Nueva',
              precio: 499.99,
              stock:  5,
              color:  'Negro',
            ),
          );
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}
