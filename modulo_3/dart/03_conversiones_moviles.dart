void main() {
  int    stock  = 42;
  double precio = stock.toDouble();
  String texto  = stock.toString();

  int    num1 = int.parse('899');
  double num2 = double.parse('1099.99');

  int?    num3 = int.tryParse('abc');
  double? num4 = double.tryParse('699');

  Object valor = 'iPhone 15';
  if (valor is String) {
    print(valor.length);
  }

  Object obj = 'Galaxy S24';
  String str = obj as String;

  String? modeloNulo = null;
  int longitud = modeloNulo?.length ?? 0;
  print(longitud);

  print(double.infinity);
  print(double.nan);
  print(double.maxFinite);
}
