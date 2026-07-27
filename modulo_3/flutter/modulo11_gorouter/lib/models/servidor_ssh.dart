class Telefono {
  final String id;
  final String modelo;
  final String marca;
  final double precio;
  final String imagenUrl;

  const Telefono({
    required this.id,
    required this.modelo,
    required this.marca,
    required this.precio,
    this.imagenUrl = '',
  });
}

const telefonosSimulados = [
  Telefono(id: '1', modelo: 'Galaxy S25',      marca: 'Samsung',  precio: 899.99),
  Telefono(id: '2', modelo: 'iPhone 16',        marca: 'Apple',    precio: 999.99),
  Telefono(id: '3', modelo: 'Redmi Note 13',    marca: 'Xiaomi',   precio: 299.99),
];
