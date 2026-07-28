import 'package:flutter/material.dart';

class ServicioEstado extends StatefulWidget {
  final String nombre;
  const ServicioEstado({super.key, required this.nombre});

  @override
  State<ServicioEstado> createState() => _ServicioEstadoState();
}

class _ServicioEstadoState extends State<ServicioEstado> {
  bool _disponible = true;
  int  _ventas     = 0;

  void _toggle() {
    setState(() {
      _disponible = !_disponible;
      if (_disponible) _ventas++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(24),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(
            _disponible ? Icons.check_circle : Icons.cancel,
            size:  72,
            color: _disponible ? Colors.green : Colors.red,
          ),
          const SizedBox(height: 8),
          Text(widget.nombre,
              style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 20)),
          Text(
            _disponible ? 'En stock' : 'Agotado',
            style: TextStyle(
              fontSize:   15,
              fontWeight: FontWeight.w600,
              color:      _disponible ? Colors.green.shade700 : Colors.red.shade700,
            ),
          ),
          const SizedBox(height: 16),
          if (!_disponible)
            Container(
              margin:     const EdgeInsets.only(bottom: 16),
              padding:    const EdgeInsets.symmetric(horizontal: 14, vertical: 8),
              decoration: BoxDecoration(
                color:        Colors.red.shade50,
                borderRadius: BorderRadius.circular(8),
                border:       Border.all(color: Colors.red.shade300),
              ),
              child: const Row(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Icon(Icons.warning_amber, color: Colors.red, size: 16),
                  SizedBox(width: 6),
                  Text('Sin stock',
                      style: TextStyle(color: Colors.red, fontSize: 13)),
                ],
              ),
            ),
          FilledButton.icon(
            onPressed: _toggle,
            icon: Icon(_disponible ? Icons.remove_shopping_cart : Icons.add_shopping_cart),
            label: Text(_disponible ? 'Marcar agotado' : 'Reponer stock'),
            style: FilledButton.styleFrom(
              backgroundColor: _disponible ? Colors.red.shade600 : Colors.green.shade600,
            ),
          ),
          const SizedBox(height: 12),
          Text(
            'Ventas: $_ventas',
            style: TextStyle(fontSize: 13, color: Colors.grey.shade600),
          ),
        ],
      ),
    );
  }
}
