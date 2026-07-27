import 'package:flutter/material.dart';
import 'widgets/tarjeta_log.dart';
import 'widgets/fila_estado.dart';
import 'widgets/avatar_badge.dart';

const int paso = 5;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  home: switch (paso) {
    1 => _paso1(),
    2 => Scaffold(
          body: ListView(
            children: [
              TarjetaLog(nivel: 'VENTA', componente: 'Galaxy S25',
                  mensaje:   'Samsung Galaxy S25 vendido - \$899.99',
                  timestamp: DateTime.now()),
              TarjetaLog(nivel: 'STOCK', componente: 'iPhone 16',
                  mensaje:   'Stock agotado - reabastecer',
                  timestamp: DateTime.now().subtract(const Duration(minutes: 2))),
              TarjetaLog(nivel: 'INFO',  componente: 'Redmi Note 13',
                  mensaje:   'Nuevo lote recibido - 20 unidades',
                  timestamp: DateTime.now().subtract(const Duration(minutes: 5))),
              TarjetaLog(nivel: 'DEBUG', componente: 'Motorola Edge',
                  mensaje:   'Precio actualizado: \$449.99',
                  timestamp: DateTime.now().subtract(const Duration(minutes: 8))),
            ],
          ),
        ),
    3 => const Scaffold(
          body: Column(
            children: [
              FilaEstado(nombre: 'Samsung Galaxy', detalle: 'Stock: 15 · \$899.99',         activo: true),
              Divider(height: 1),
              FilaEstado(nombre: 'iPhone 16',      detalle: 'Stock: 0 · Agotado',           activo: false),
              Divider(height: 1),
              FilaEstado(nombre: 'Redmi Note 13',  detalle: 'Stock: 8 · \$299.99',          activo: true),
              Divider(height: 1),
              FilaEstado(nombre: 'Edge 50 Pro',    detalle: 'Stock: 5 · \$449.99',          activo: true),
            ],
          ),
        ),
    4 => const Scaffold(
          body: Center(
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                AvatarBadge(nombre: 'Samsung', alertas: 2,  activo: true),
                SizedBox(width: 24),
                AvatarBadge(nombre: 'Apple',   alertas: 0,  activo: true),
                SizedBox(width: 24),
                AvatarBadge(nombre: 'Xiaomi',  alertas: 0,  activo: false),
                SizedBox(width: 24),
                AvatarBadge(nombre: 'Motorola', alertas: 1, activo: true),
              ],
            ),
          ),
        ),
    5 => Scaffold(
          body: ListView(
            padding: const EdgeInsets.all(16),
            children: [
              const Text('SizedBox', style: TextStyle(fontWeight: FontWeight.bold)),
              const SizedBox(height: 8),
              const Text('Primer teléfono'),
              const SizedBox(height: 32),
              const Text('Segundo teléfono (después de 32px)'),
              const Divider(height: 32),
              const Text('Padding', style: TextStyle(fontWeight: FontWeight.bold)),
              const SizedBox(height: 8),
              Container(
                color: Colors.indigo.shade50,
                child: const Padding(
                  padding: EdgeInsets.only(left: 24),
                  child:   Text('Texto con Padding izquierdo'),
                ),
              ),
              const Divider(height: 32),
              const Text('Align', style: TextStyle(fontWeight: FontWeight.bold)),
              const SizedBox(height: 8),
              const Align(
                alignment: Alignment.centerRight,
                child: Icon(Icons.settings, color: Colors.indigo),
              ),
              const Divider(height: 32),
              const Text('Wrap', style: TextStyle(fontWeight: FontWeight.bold)),
              const SizedBox(height: 8),
              Wrap(
                spacing: 8, runSpacing: 8,
                children: ['Samsung', 'Apple', 'Xiaomi', '5G', 'OLED', '128GB', 'Dual SIM']
                    .map((t) => Chip(label: Text(t)))
                    .toList(),
              ),
            ],
          ),
        ),
    _ => Scaffold(body: Center(child: Text('Paso $paso no definido'))),
  },
));

Widget _paso1() => Scaffold(
  body: Center(
    child: Container(
      width:   220,
      height:  80,
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
      decoration: BoxDecoration(
        color:        Colors.indigo.shade50,
        borderRadius: BorderRadius.circular(12),
        border:       Border.all(color: Colors.indigo, width: 1.5),
        boxShadow: [
          BoxShadow(
            color:      Colors.black.withValues(alpha: 0.08),
            blurRadius: 8,
            offset:     const Offset(0, 2),
          ),
        ],
      ),
      child: const Text('Galaxy S25',
          style: TextStyle(fontWeight: FontWeight.bold)),
    ),
  ),
);
