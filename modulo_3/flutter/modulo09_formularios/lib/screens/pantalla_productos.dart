import 'package:flutter/material.dart';
import 'package:modulo09_formularios/widgets/tarjetaproductogrid.dart';
import '../models/telefono.dart';
import '../widgets/fila_producto.dart';

class PantallaTelefonos extends StatefulWidget {
  const PantallaTelefonos({super.key});
  @override
  State<PantallaTelefonos> createState() => _PantallaTelefonosState();
}

class _PantallaTelefonosState extends State<PantallaTelefonos> {
  final _telefonos = [
    Telefono(id:'1', modelo:'Galaxy S25',      marca:'Samsung',  precio:899.99,  stock:15, color:'Negro',    sistema:'Android'),
    Telefono(id:'2', modelo:'iPhone 16',        marca:'Apple',    precio:999.99,  stock:0,  color:'Blanco',   sistema:'iOS',     disponible: false),
    Telefono(id:'3', modelo:'Redmi Note 13',    marca:'Xiaomi',   precio:299.99,  stock:8,  color:'Azul',     sistema:'Android', favorito: true),
    Telefono(id:'4', modelo:'Edge 50 Pro',      marca:'Motorola', precio:449.99,  stock:5,  color:'Gris',     sistema:'Android'),
  ];

  bool _modoGrid = false;

  void _toggleFavorito(int i) =>
      setState(() => _telefonos[i].favorito = !_telefonos[i].favorito);

  void _eliminar(int i) => setState(() => _telefonos.removeAt(i));

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Teléfonos (${_telefonos.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
        actions: [
          IconButton(
            icon:    Icon(_modoGrid ? Icons.list : Icons.grid_view),
            onPressed: () => setState(() => _modoGrid = !_modoGrid),
            tooltip: _modoGrid ? 'Vista lista' : 'Vista cuadrícula',
          ),
        ],
      ),
      body: _modoGrid
          ? GridView.builder(
              padding: const EdgeInsets.all(12),
              gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount:   2,
                childAspectRatio: 1.1,
                crossAxisSpacing: 8,
                mainAxisSpacing:  8,
              ),
              itemCount:   _telefonos.length,
              itemBuilder: (ctx, i) => TarjetaTelefonoGrid(
                telefono:   _telefonos[i],
                onFavorito: () => _toggleFavorito(i),
                onEliminar: () => _eliminar(i),
              ),
            )
          : ListView.separated(
              itemCount:        _telefonos.length,
              separatorBuilder: (_, _) =>
                  const Divider(height: 1, indent: 72),
              itemBuilder: (ctx, i) => FilaTelefono(
                telefono:   _telefonos[i],
                onFavorito: () => _toggleFavorito(i),
                onEliminar: () => _eliminar(i),
              ),
            ),
    );
  }
}
