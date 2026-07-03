import 'package:flutter/material.dart';
import 'screens/pantalla_tema.dart';
import 'screens/pantalla_appbar.dart';
import 'widgets/catalogo_botones.dart';
import 'screens/pantalla_navegacion.dart';
import 'screens/pantalla_dialogs.dart';

const int paso = 6;

void main() => runApp(const AppMonitoreo());

class AppMonitoreo extends StatefulWidget {
  const AppMonitoreo({super.key});
  @override
  State<AppMonitoreo> createState() => _AppMonitoreoState();
}

class _AppMonitoreoState extends State<AppMonitoreo> {
  ThemeMode _themeMode = ThemeMode.system;

  @override
  Widget build(BuildContext context) {
    const seedColor = Color(0xFF1565C0);

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      themeMode: _themeMode,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
            seedColor: seedColor, brightness: Brightness.light),
        useMaterial3: true,
      ),
      darkTheme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
            seedColor: seedColor, brightness: Brightness.dark),
        useMaterial3: true,
      ),
      home: switch (paso) {
        1 => const _Paso1(),
        2 => PantallaTema(
               themeMode: _themeMode,
               onToggle:  (mode) => setState(() => _themeMode = mode),
             ),
        3 => const PantallaAppBar(),
        4 => const CatalogoBotones(),
        5 => const PantallaNavegacion(),
        6 => const PantallaDialogs(),
        _ => Scaffold(body: Center(child: Text('Paso $paso no definido'))),
      },
    );
  }
}

class _Paso1 extends StatefulWidget {
  const _Paso1();

  @override
  State<_Paso1> createState() => _Paso1State();
}

class _Paso1State extends State<_Paso1> {
  bool _useTertiary = false;
  bool _centerTitle = false;
  bool _useCloud = false;
  double _iconSize = 64;
  Color _seedColor = const Color(0xFF1565C0);

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;
    final text = Theme.of(context).textTheme;

    return Scaffold(
      appBar: AppBar(
        title: const Text('Sistema de Monitoreo'),
        backgroundColor: _useTertiary ? cs.tertiaryContainer : cs.primaryContainer,
        foregroundColor: _useTertiary ? cs.onTertiaryContainer : cs.onPrimaryContainer,
        centerTitle: _centerTitle,
        actions: [
          IconButton(icon: const Icon(Icons.refresh), onPressed: () {}),
        ],
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Icon(
              _useCloud ? Icons.cloud : Icons.dns,
              size: _iconSize,
              color: cs.primary,
            ),
            const SizedBox(height: 16),
            Text(
              'Servidor web-01',
              style: text.headlineMedium?.copyWith(fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 8),
            Text(
              '10.0.2.10 · Ubuntu 24.04',
              style: text.bodyMedium?.copyWith(color: cs.onSurfaceVariant),
            ),
            const SizedBox(height: 24),
            FilledButton.icon(
              onPressed: () {},
              icon: const Icon(Icons.terminal),
              label: const Text('Conectar SSH'),
            ),
            const SizedBox(height: 32),
            Card(
              margin: const EdgeInsets.symmetric(horizontal: 24),
              child: Padding(
                padding: const EdgeInsets.all(12),
                child: Column(
                  children: [
                    Text('Prueba esto', style: text.labelLarge?.copyWith(color: cs.primary)),
                    const SizedBox(height: 8),
                    Wrap(
                      spacing: 8,
                      runSpacing: 4,
                      children: [
                        ActionChip(
                          label: const Text('seedColor'),
                          onPressed: () => setState(() {
                            _seedColor = _seedColor == const Color(0xFF1565C0)
                                ? Colors.green
                                : const Color(0xFF1565C0);
                          }),
                          avatar: Icon(Icons.colorize, size: 16),
                        ),
                        ActionChip(
                          label: const Text('AppBar: tertiaryContainer'),
                          onPressed: () => setState(() => _useTertiary = !_useTertiary),
                          avatar: Icon(Icons.palette, size: 16),
                        ),
                        ActionChip(
                          label: Text(_centerTitle ? 'centerTitle: ON' : 'centerTitle: OFF'),
                          onPressed: () => setState(() => _centerTitle = !_centerTitle),
                          avatar: Icon(Icons.format_align_center, size: 16),
                        ),
                        ActionChip(
                          label: Text(_useCloud ? 'Icons.cloud' : 'Icons.dns'),
                          onPressed: () => setState(() => _useCloud = !_useCloud),
                          avatar: Icon(Icons.cloud, size: 16),
                        ),
                        ActionChip(
                          label: Text('size: ${_iconSize.round()}'),
                          onPressed: () => setState(() {
                            _iconSize = _iconSize == 64 ? 96 : 64;
                          }),
                          avatar: Icon(Icons.photo_size_select_large, size: 16),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        tooltip: 'Agregar servidor',
        child: const Icon(Icons.add),
      ),
    );
  }
}
