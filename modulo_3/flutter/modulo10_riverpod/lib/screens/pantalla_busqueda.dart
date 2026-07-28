import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../providers/telefonos_provider.dart';

class PantallaBusqueda extends ConsumerWidget {
  const PantallaBusqueda({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final telefonos = ref.watch(telefonosFiltradosProvider);
    final busqueda  = ref.watch(busquedaProvider);

    return Scaffold(
      appBar: AppBar(title: const Text('Buscar teléfonos')),
      body: Column(children: [
        Padding(
          padding: const EdgeInsets.all(12),
          child: SearchBar(
            hintText: 'Buscar por modelo o marca...',
            leading:  const Icon(Icons.search),
            trailing: busqueda.isNotEmpty
                ? [IconButton(
                    icon: const Icon(Icons.clear),
                    onPressed: () =>
                        ref.read(busquedaProvider.notifier).limpiar(),
                  )]
                : null,
            onChanged: (v) =>
                ref.read(busquedaProvider.notifier).setValor(v),
            padding: const WidgetStatePropertyAll(
              EdgeInsets.symmetric(horizontal: 16),
            ),
          ),
        ),
        Expanded(
          child: telefonos.isEmpty
              ? const Center(child: Text('Sin resultados'))
              : ListView.builder(
                  itemCount:   telefonos.length,
                  itemBuilder: (_, i) => ListTile(
                    leading: const Icon(Icons.phone_android),
                    title:    Text(telefonos[i].modelo),
                    subtitle: Text('${telefonos[i].marca} - \$${telefonos[i].precio.toStringAsFixed(2)}'),
                  ),
                ),
        ),
      ]),
    );
  }
}
