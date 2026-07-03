import 'package:flutter/material.dart';

class PantallaAppBar extends StatefulWidget {
  const PantallaAppBar({super.key});

  @override
  State<PantallaAppBar> createState() => _PantallaAppBarState();
}

class _PantallaAppBarState extends State<PantallaAppBar> {
  bool _useMedium = false;
  bool _pinned = true;
  bool _useTertiary = false;

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      body: CustomScrollView(
        slivers: [
          (_useMedium ? SliverAppBar.medium : SliverAppBar.large)(
            title:           const Text('Servidores'),
            pinned:          _pinned,
            backgroundColor: _useTertiary ? cs.tertiaryContainer : cs.primaryContainer,
            foregroundColor: _useTertiary ? cs.onTertiaryContainer : cs.onPrimaryContainer,
            actions: [
              IconButton(
                icon:      const Icon(Icons.filter_list),
                onPressed: () {},
                tooltip:   'Filtrar',
              ),
              IconButton(
                icon:      const Icon(Icons.search),
                onPressed: () {},
                tooltip:   'Buscar',
              ),
            ],
            flexibleSpace: FlexibleSpaceBar(
              background: Container(
                color: _useTertiary ? cs.tertiaryContainer : cs.primaryContainer,
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    const SizedBox(height: 56),
                    Icon(Icons.dns, size: 48, color: _useTertiary ? cs.onTertiaryContainer : cs.onPrimaryContainer),
                    const SizedBox(height: 8),
                    Text(
                      '8 servidores activos',
                      style: TextStyle(color: _useTertiary ? cs.onTertiaryContainer : cs.onPrimaryContainer),
                    ),
                  ],
                ),
              ),
            ),
          ),

          SliverToBoxAdapter(
            child: Padding(
              padding: const EdgeInsets.fromLTRB(16, 8, 16, 4),
              child: Card(
                child: Padding(
                  padding: const EdgeInsets.all(8),
                  child: Row(
                    children: [
                      Expanded(
                        child: ActionChip(
                          label: Text(_useMedium ? 'Medium' : 'Large'),
                          onPressed: () => setState(() => _useMedium = !_useMedium),
                          avatar: Icon(Icons.view_headline, size: 16),
                        ),
                      ),
                      const SizedBox(width: 8),
                      Expanded(
                        child: ActionChip(
                          label: Text(_pinned ? 'pinned: ON' : 'pinned: OFF'),
                          onPressed: () => setState(() => _pinned = !_pinned),
                          avatar: Icon(Icons.push_pin, size: 16),
                        ),
                      ),
                      const SizedBox(width: 8),
                      Expanded(
                        child: ActionChip(
                          label: Text(_useTertiary ? 'tertiary' : 'primary'),
                          onPressed: () => setState(() => _useTertiary = !_useTertiary),
                          avatar: Icon(Icons.palette, size: 16),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ),
          ),

          SliverPadding(
            padding: const EdgeInsets.all(8),
            sliver: SliverList(
              delegate: SliverChildBuilderDelegate(
                (context, i) => Card(
                  child: ListTile(
                    leading:  Icon(Icons.dns, color: cs.primary),
                    title:    Text('prod-web-0${i + 1}'),
                    subtitle: Text('10.0.2.${i + 10} · Activo'),
                    trailing: Chip(
                      label:           const Text('OK'),
                      backgroundColor: cs.primaryContainer,
                      labelStyle:      TextStyle(color: cs.onPrimaryContainer),
                    ),
                    onTap: () {},
                  ),
                ),
                childCount: 10,
              ),
            ),
          ),
        ],
      ),
    );
  }
}
