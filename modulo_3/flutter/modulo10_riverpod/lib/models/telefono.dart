class Telefono {
  final String id;
  final String modelo;
  final String marca;
  final double precio;
  final int    stock;
  final String color;
  final bool   disponible;
  bool         favorito;

  Telefono({
    required this.id,
    required this.modelo,
    required this.marca,
    required this.precio,
    required this.stock,
    required this.color,
    this.disponible = true,
    this.favorito = false,
  });
}
