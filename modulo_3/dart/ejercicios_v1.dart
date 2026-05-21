import 'dart:io';
/*
void main() {
  int totalMinutos = 0;
  int clientesRegistrados = 0;
  int minutos = -1;

  while (minutos != 0) {
    print('Ingrese los minutos de entrenamiento del cliente (0 para finalizar): ');
    minutos = int.parse(stdin.readLineSync()!);

    if (minutos > 0) {
      if (minutos < 30) {
        print('Entrenamiento insuficiente');
      } else if (minutos >= 30 && minutos <= 90) {
        print('Entrenamiento adecuado');
      } else {
        print('Entrenamiento intenso');
      }

      totalMinutos += minutos;
      clientesRegistrados++;
    }
  }
  print('Total de minutos entrenados: $totalMinutos');
  print('Total de clientes registrados: $clientesRegistrados');

  if (clientesRegistrados > 0) {
    double promedio = totalMinutos / clientesRegistrados;
    print('Promedio de minutos por cliente: $promedio');
  } else {
    print('Promedio de minutos por cliente: 0.0');
  }
}
*/

/*
void main() {
  int totalMuebles = 0;
  int trabajadoresRegistrados = 0;
  int muebles = -1;

  while (muebles != 0) {
    print('Ingrese la cantidad de muebles fabricados (0 para finalizar): ');
    muebles = int.parse(stdin.readLineSync()!);

    if (muebles > 0) {
      if (muebles < 3) {
        print('Producción baja');
      } else if (muebles >= 3 && muebles <= 7) {
        print('Producción normal');
      } else {
        print('Producción alta');
      }

      totalMuebles += muebles;
      trabajadoresRegistrados++;
    }
  }

  print('Total de muebles fabricados: $totalMuebles');
  print('Cantidad de trabajadores registrados: $trabajadoresRegistrados');
  if (trabajadoresRegistrados > 0) {
    double promedio = totalMuebles / trabajadoresRegistrados;
    print('Promedio de muebles por trabajador: $promedio');
  } else {
    print('Promedio de muebles por trabajador: 0.0');
  }
}

 */

/*
void main() {
  int totalTablas = 0;
  int operariosRegistrados = 0;
  int tablas = -1;

  while (tablas != 0) {
    print('Ingrese la cantidad de tablas cortadas (0 para finalizar): ');
    tablas = int.parse(stdin.readLineSync()!);

    if (tablas > 0) {
      if (tablas < 15) {
        print('Trabajo lento');
      } else if (tablas >= 15 && tablas <= 40) {
        print('Trabajo eficiente');
      } else {
        print('Trabajo sobresaliente');
      }

      totalTablas += tablas;
      operariosRegistrados++;
    }
  }

  print('Total de tablas cortadas: $totalTablas');
  print('Cantidad de operarios registrados: $operariosRegistrados');

  if (operariosRegistrados > 0) {
    double promedio = totalTablas / operariosRegistrados;
    print('Promedio de tablas por operario: $promedio');
  } else {
    print('Promedio de tablas por operario: 0.0');
  }
}

 */

/*
void main() {
  int totalPacientes = 0;
  int doctoresRegistrados = 0;
  double horas = -1.0;

  while (horas != 0) {
    print('Ingrese las horas trabajadas por el doctor (0 para finalizar): ');
    horas = double.parse(stdin.readLineSync()!);

    if (horas > 0) {
      print('Ingrese la cantidad de pacientes atendidos: ');
      int pacientes = int.parse(stdin.readLineSync()!);

      double pacientesPorHora = pacientes / horas;
      print('Pacientes por hora: ${pacientesPorHora.toStringAsFixed(2)}');

      if (pacientesPorHora < 3) {
        print('Atención lenta');
      } else if (pacientesPorHora >= 3 && pacientesPorHora <= 6) {
        print('Atención normal');
      } else {
        print('Atención rápida');
      }

      totalPacientes += pacientes;
      doctoresRegistrados++;
    }
  }


  print('Total de pacientes atendidos: $totalPacientes');
  print('Cantidad de doctores registrados: $doctoresRegistrados');
  if (doctoresRegistrados > 0) {
    double promedio = totalPacientes / doctoresRegistrados;
    print('Promedio de pacientes por doctor: $promedio');
  } else {
    print('Promedio de pacientes por doctor: 0.0');
  }
}
*/

/*
void main() {
  int totalPasajeros = 0;
  int totalMinutosRetraso = 0;
  int totalVuelos = 0;
  int agentesRegistrados = 0;
  int vuelos = -1;

  while (vuelos != 0) {
    print('Ingrese la cantidad de vuelos atendidos por el agente (0 para finalizar): ');
    vuelos = int.parse(stdin.readLineSync()!);

    if (vuelos > 0) {
      print('Ingrese la cantidad de pasajeros procesados: ');
      int pasajeros = int.parse(stdin.readLineSync()!);

      print('Ingrese los minutos totales de retraso: ');
      int minutosRetraso = int.parse(stdin.readLineSync()!);

      double pasajerosPorVuelo = pasajeros / vuelos;
      double retrasoPorVuelo = minutosRetraso / vuelos;

      print('Pasajeros por vuelo: ${pasajerosPorVuelo.toStringAsFixed(2)}');
      print('Índice de retraso por vuelo: ${retrasoPorVuelo.toStringAsFixed(2)}');

      if (pasajerosPorVuelo < 50) {
        print('Baja eficiencia');
      } else if (pasajerosPorVuelo >= 50 && pasajerosPorVuelo <= 120) {
        print('Eficiencia normal');
      } else {
        print('Alta eficiencia');
      }

      totalPasajeros += pasajeros;
      totalMinutosRetraso += minutosRetraso;
      totalVuelos += vuelos;
      agentesRegistrados++;
    }
  }

  print('Total de pasajeros procesados: $totalPasajeros');
  print('Total de minutos de retraso acumulados: $totalMinutosRetraso');
  print('Cantidad de agentes registrados: $agentesRegistrados');

  if (agentesRegistrados > 0) {
    double promedioPasajerosAgente = totalPasajeros / agentesRegistrados;
    print('Promedio de pasajeros por agente: ${promedioPasajerosAgente.toStringAsFixed(2)}');
  } else {
    print('Promedio de pasajeros por agente: 0.0');
  }

  if (totalVuelos > 0) {
    double promedioGeneralRetraso = totalMinutosRetraso / totalVuelos;
    print('Promedio general de retraso por vuelo: ${promedioGeneralRetraso.toStringAsFixed(2)}');
  } else {
    print('Promedio general de retraso por vuelo: 0.0');
  }
}
*/


/*
void main() {
  int totalVentas = 0;

  print('Registro de ventas semanales');
  for (int dia = 1; dia <= 7; dia++) {
    print('Ingrese las ventas del día $dia: ');
    int ventasDiarias = int.parse(stdin.readLineSync()!);
    totalVentas += ventasDiarias;
  }

  double promedioVentas = totalVentas / 7;
  String rendimiento = '';

  if (promedioVentas < 10) {
    rendimiento = 'Bajo rendimiento';
  } else if (promedioVentas >= 10 && promedioVentas <= 25) {
    rendimiento = 'Rendimiento normal';
  } else {
    rendimiento = 'Alto rendimiento';
  }

  print('Total de ventas: $totalVentas');
  print('Promedio de ventas diario: ${promedioVentas.toStringAsFixed(2)}');
  print('Clasificación de rendimiento: $rendimiento');
}
m,
 */




void main() {
  double totalKilometros = 0;
  double totalCombustible = 0;

  print('Registro de turno(5 viajes)');
  for (int viaje = 1; viaje <= 5; viaje++) {
    print('Ingrese los kilómetros recorridos en el viaje $viaje: ');
    double kilometrosViaje = double.parse(stdin.readLineSync()!);

    double combustibleViaje = kilometrosViaje / 12;
    totalKilometros += kilometrosViaje;
    totalCombustible += combustibleViaje;
  }

  double promedioKilometros = totalKilometros / 5;
  String tipoRuta = '';

  if (promedioKilometros < 50) {
    tipoRuta = 'Ruta corta';
  } else if (promedioKilometros >= 50 && promedioKilometros <= 150) {
    tipoRuta = 'Ruta media';
  } else {
    tipoRuta = 'Ruta larga';
  }

  print('Total de kilómetros recorridos: ${totalKilometros.toStringAsFixed(2)} km');
  print('Total de combustible estimado: ${totalCombustible.toStringAsFixed(2)} litros');
  print('Promedio de kilómetros por viaje: ${promedioKilometros.toStringAsFixed(2)} km/viaje');
  print('Clasificación del turno: $tipoRuta');
}