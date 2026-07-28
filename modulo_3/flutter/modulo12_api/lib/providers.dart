import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'api_error.dart';
import 'http_client.dart';
import 'producto.dart';
import 'productos_repository.dart';

// ── 1. Dependencias ───────────────────────────────────────────────────────────
final httpClientProvider =
    Provider<HttpClient>((_) => HttpClient());

final repositoryProvider = Provider<ProductosRepository>(
  (ref) => ProductosRepository(ref.read(httpClientProvider)),
);

// ── 2. Estado ─────────────────────────────────────────────────────────────────
class CatalogoState {
  final List<Producto> productos;
  final bool           cargando;
  final ApiError?      error;

  const CatalogoState({
    this.productos = const [],
    this.cargando  = false,
    this.error,
  });

  CatalogoState copyWith({
    List<Producto>? productos,
    bool?           cargando,
    ApiError?       error,
  }) =>
      CatalogoState(
        productos: productos ?? this.productos,
        cargando:  cargando  ?? this.cargando,
        error:     error,
      );
}

// ── 3. Notifier ───────────────────────────────────────────────────────────────
class CatalogoNotifier extends Notifier<CatalogoState> {
  @override
  CatalogoState build() => const CatalogoState();

  Future<void> cargar() async {
    state = state.copyWith(cargando: true, error: null);
    try {
      final lista = await ref.read(repositoryProvider).listar();
      state = CatalogoState(productos: lista);
    } on ApiError catch (e) {
      state = CatalogoState(error: e);
    }
  }

  Future<void> buscar(String termino) async {
    if (termino.isEmpty) { await cargar(); return; }
    state = state.copyWith(cargando: true, error: null);
    try {
      final lista = await ref.read(repositoryProvider).buscar(termino);
      state = CatalogoState(productos: lista);
    } on ApiError catch (e) {
      state = CatalogoState(error: e);
    }
  }
}

// ── 4. Provider del notifier ──────────────────────────────────────────────────
final catalogoProvider =
    NotifierProvider<CatalogoNotifier, CatalogoState>(CatalogoNotifier.new);