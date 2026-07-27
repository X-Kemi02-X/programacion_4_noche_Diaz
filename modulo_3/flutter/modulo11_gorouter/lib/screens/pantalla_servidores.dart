import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:modulo11_gorouter/models/servidor_ssh.dart';

class PantallaTelefonos extends StatelessWidget {
  const PantallaTelefonos({super.key});

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;
    final telefonos = telefonosSimulados;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Teléfonos'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: ListView.builder(
        itemCount:   telefonos.length,
        itemBuilder: (context, i) => ListTile(
          leading: const Icon(Icons.phone_android),
          title:   Text(telefonos[i].modelo),
          subtitle: Text('${telefonos[i].marca} - \$${telefonos[i].precio.toStringAsFixed(2)}'),
          onTap: () {
            context.push('/servidores/${telefonos[i].id}',
              extra: telefonos[i],
            );
          },
        ),
      ),
    );
  }
}   
