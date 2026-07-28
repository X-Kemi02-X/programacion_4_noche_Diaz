import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../screens/pantalla_inicio.dart';
import '../screens/pantalla_telefonos_filtro.dart';
import '../screens/pantalla_detalle.dart';
import '../models/telefono.dart';

final appRouterPaso3 = GoRouter(
  initialLocation: '/',
  routes: [
    GoRoute(
      path:    '/',
      builder: (context, state) => const PantallaInicio(),
    ),
    GoRoute(
      path:    '/telefonos',
      builder: (context, state) {
        return const PantallaTelefonosFiltro();
      },
    ),
    GoRoute(
      path:    '/telefonos/:id',
      builder: (context, state) {
        final id  = state.pathParameters['id']!;
        final tel = state.extra as Telefono?;
        return PantallaDetalle(id: id, telefono: tel);
      },
    ),
  ],
);
