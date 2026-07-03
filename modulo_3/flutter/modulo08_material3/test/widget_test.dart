import 'package:flutter_test/flutter_test.dart';
import 'package:modulo08_material3/main.dart';

void main() {
  testWidgets('App renders without errors', (WidgetTester tester) async {
    await tester.pumpWidget(const AppMonitoreo());
    expect(find.text('Sistema de Monitoreo'), findsOneWidget);
  });
}
