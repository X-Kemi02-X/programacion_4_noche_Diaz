import 'package:flutter/material.dart';
import '../models/telefono.dart';

class FilaTelefono extends StatelessWidget {
  final Telefono     telefono;
  final VoidCallback onFavorito;
  final VoidCallback onEliminar;

  const FilaTelefono({
    super.key,
    required this.telefono,
    required this.onFavorito,
    required this.onEliminar,
  });

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return ListTile(
      leading: CircleAvatar(
        backgroundColor: telefono.disponible
            ? cs.primaryContainer
            : cs.surfaceContainerHighest,
        child: Icon(
          Icons.phone_android,
          color: telefono.disponible ? cs.onPrimaryContainer : cs.onSurfaceVariant,
        ),
      ),
      title: Text(
        telefono.modelo,
        style: const TextStyle(fontWeight: FontWeight.w600),
      ),
      subtitle: Text(
        '${telefono.marca} - \$${telefono.precio.toStringAsFixed(2)}',
        style: TextStyle(fontSize: 12, color: cs.onSurfaceVariant),
      ),
      trailing: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          IconButton(
            icon: Icon(
              telefono.favorito ? Icons.star : Icons.star_border,
              color: telefono.favorito ? Colors.amber : cs.outline,
            ),
            onPressed:     onFavorito,
            visualDensity: VisualDensity.compact,
            tooltip:       telefono.favorito ? 'Quitar favorito' : 'Agregar a favoritos',
          ),
          IconButton(
            icon:          Icon(Icons.delete_outline, color: cs.error),
            onPressed:     onEliminar,
            visualDensity: VisualDensity.compact,
            tooltip:       'Eliminar',
          ),
        ],
      ),
      contentPadding: const EdgeInsets.symmetric(horizontal: 16, vertical: 4),
    );
  }
}
