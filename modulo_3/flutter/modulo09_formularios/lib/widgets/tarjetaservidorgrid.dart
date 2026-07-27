import 'package:flutter/material.dart';
import '../models/telefono.dart';

class TarjetaTelefonoGrid extends StatelessWidget {
  final Telefono    telefono;
  final VoidCallback onFavorito;
  final VoidCallback onEliminar;

  const TarjetaTelefonoGrid({
    super.key,
    required this.telefono,
    required this.onFavorito,
    required this.onEliminar,
  });

  @override
  Widget build(BuildContext context) {
    final cs   = Theme.of(context).colorScheme;
    final text = Theme.of(context).textTheme;

    return Card(
      child: Padding(
        padding: const EdgeInsets.all(10),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(children: [
              Icon(
                Icons.phone_android,
                color: telefono.disponible ? cs.primary : cs.outline,
                size: 18,
              ),
              const Spacer(),
              GestureDetector(
                onTap: onFavorito,
                child: Icon(
                  telefono.favorito ? Icons.star : Icons.star_border,
                  color: telefono.favorito ? Colors.amber : cs.outline,
                  size: 18,
                ),
              ),
            ]),
            const SizedBox(height: 6),
            Text(
              telefono.modelo,
              style: text.titleSmall?.copyWith(fontWeight: FontWeight.bold),
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
            ),
            Text(
              '${telefono.marca} - \$${telefono.precio.toStringAsFixed(2)}',
              style: text.bodySmall?.copyWith(color: cs.onSurfaceVariant),
            ),
            const Spacer(),
            Row(children: [
              if (telefono.disponible)
                Padding(
                  padding: const EdgeInsets.only(right: 4),
                  child: Icon(Icons.check_circle, size: 12, color: Colors.green),
                ),
              Expanded(
                child: Text(
                  'Stock: ${telefono.stock}',
                  style: text.labelSmall?.copyWith(color: cs.onSurfaceVariant),
                  overflow: TextOverflow.ellipsis,
                ),
              ),
              GestureDetector(
                onTap: onEliminar,
                child: Icon(Icons.delete_outline, size: 16, color: cs.error),
              ),
            ]),
          ],
        ),
      ),
    );
  }
}
