import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../screens/pantalla_inicio.dart';
import '../screens/pantallaservidoresfiltro.dart';
import '../screens/pantalla_detalle.dart';
import '../models/servidor_ssh.dart';

final appRouterPaso3 = GoRouter(
  initialLocation: '/',
  routes: [
    GoRoute(
      path:    '/',
      builder: (context, state) => const PantallaInicio(),
    ),
    GoRoute(
      path:    '/servidores',
      builder: (context, state) {
        return const PantallaTelefonosFiltro();
      },
    ),
    GoRoute(
      path:    '/servidores/:id',
      builder: (context, state) {
        final id  = state.pathParameters['id']!;
        final tel = state.extra as Telefono?;
        return PantallaDetalle(id: id, telefono: tel);
      },
    ),
  ],
);