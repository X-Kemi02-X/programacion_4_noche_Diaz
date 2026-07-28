import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:modulo11_gorouter/screens/scaffoldconnav.dart';
import '../screens/pantalla_telefonos.dart';
import '../screens/pantalla_detalle.dart';
import '../screens/pantallametricas.dart';
import '../screens/pantalla_ajustes.dart';
import '../models/telefono.dart';

final appRouterPaso4 = GoRouter(
  initialLocation: '/telefonos',
  debugLogDiagnostics: true,
  routes: [
    ShellRoute(
      builder: (context, state, child) => ScaffoldConNav(child: child),
      routes: [
        GoRoute(
          path:    '/telefonos',
          builder: (_, __) => const PantallaTelefonos(),
          routes: [
            GoRoute(
              path:    ':id',
              builder: (context, state) {
                final id  = state.pathParameters['id']!;
                final tel = state.extra as Telefono?;
                return PantallaDetalle(id: id, telefono: tel);
              },
            ),
          ],
        ),
        GoRoute(
          path:    '/metricas',
          builder: (_, __) => const PantallaMetricas(),
        ),
        GoRoute(
          path:    '/ajustes',
          builder: (_, __) => const PantallaAjustes(),
        ),
      ],
    ),
  ],
);
