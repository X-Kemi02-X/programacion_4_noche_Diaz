import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../models/servidor_ssh.dart';

class PantallaTelefonosFiltro extends StatelessWidget {
  final bool soloDisponibles;
  const PantallaTelefonosFiltro({super.key, this.soloDisponibles = false});

  @override
  Widget build(BuildContext context) {
    final filtrados = telefonosSimulados;

    return Scaffold(
      appBar: AppBar(
        title:   const Text('Teléfonos'),
      ),
      body: ListView.builder(
        itemCount:   filtrados.length,
        itemBuilder: (context, i) {
          final t = filtrados[i];
          return ListTile(
            leading: const Icon(Icons.phone_android, color: Colors.blue),
            title:   Text(t.modelo),
            subtitle: Text('${t.marca} - \$${t.precio.toStringAsFixed(2)}'),
            onTap: () => context.push(
              '/servidores/${t.id}',
              extra: t,
            ),
          );
        },
      ),
    );
  }
}