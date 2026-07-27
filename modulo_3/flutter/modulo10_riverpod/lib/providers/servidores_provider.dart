import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../models/telefono.dart';

class TelefonosNotifier extends Notifier<List<Telefono>> {
  @override
  List<Telefono> build() => [
    Telefono(id:'1', modelo:'Galaxy S25',    marca:'Samsung',  precio:899.99,  stock:15, color:'Negro',  favorito:true),
    Telefono(id:'2', modelo:'iPhone 16',      marca:'Apple',    precio:999.99,  stock:0,  color:'Blanco', disponible: false),
    Telefono(id:'3', modelo:'Redmi Note 13',  marca:'Xiaomi',   precio:299.99,  stock:8,  color:'Azul'),
  ];

  void toggleFavorito(String id) {
    state = state.map((t) =>
        t.id == id
          ? Telefono(id:t.id, modelo:t.modelo, marca:t.marca,
                     precio:t.precio, stock:t.stock, color:t.color,
                     disponible:t.disponible, favorito:!t.favorito)
          : t
    ).toList();
  }

  void eliminar(String id) {
    state = state.where((t) => t.id != id).toList();
  }

  void agregar(Telefono telefono) {
    state = [...state, telefono];
  }
}

final telefonosProvider =
    NotifierProvider<TelefonosNotifier, List<Telefono>>(
  TelefonosNotifier.new,
);

final busquedaProvider = StateProvider<String>((ref) => '');

final telefonosFiltradosProvider = Provider<List<Telefono>>((ref) {
  final todos    = ref.watch(telefonosProvider);
  final busqueda = ref.watch(busquedaProvider);

  if (busqueda.isEmpty) return todos;

  final q = busqueda.toLowerCase();
  return todos.where((t) =>
      t.modelo.toLowerCase().contains(q) || t.marca.toLowerCase().contains(q)
  ).toList();
});
