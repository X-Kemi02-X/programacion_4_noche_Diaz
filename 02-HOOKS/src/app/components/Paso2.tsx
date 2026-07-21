// app/index.tsx — agrega la función Paso2
import { useState, useEffect } from 'react'
import { StyleSheet, Text, View, Pressable } from 'react-native'

type EstadoPing = 'pinging' | 'ok' | 'timeout' | 'inactivo'

export function Paso2() {
  const [latencia, setLatencia] = useState<number | null>(null)
  const [estado, setEstado] = useState<EstadoPing>('inactivo')
  const [activo, setActivo] = useState<boolean>(false)
  const [ciclos, setCiclos] = useState<number>(0)

  useEffect(() => {
    if (!activo) return   // no arrancar el intervalo si el ping está detenido

    const intervalo = setInterval(() => {
      setEstado('pinging')

      // Simula latencia de red: número aleatorio entre 10 ms y 200 ms
      // con un 15 % de probabilidad de timeout
      setTimeout(() => {
        const falla = Math.random() < 0.15
        if (falla) {
          setLatencia(null)
          setEstado('timeout')
        } else {
          const ms = Math.floor(Math.random() * 190) + 10
          setLatencia(ms)
          setEstado('ok')
        }
        setCiclos(c => c + 1)
      }, 400)
    }, 2000)

    // ← función de limpieza: cancela el intervalo
    return () => clearInterval(intervalo)
  }, [activo])   // se re-ejecuta cuando 'activo' cambia

  const colorEstado: Record<EstadoPing, string> = {
    pinging:  '#1565c0',
    ok:       '#2e7d32',
    timeout:  '#c62828',
    inactivo: '#757575',
  }

  return (
    <View style={styles.contenedor}>
      <Text style={styles.titulo}>Monitor de Ping — nginx-01</Text>

      <View style={styles.tarjeta}>
        <Text style={[styles.etiqueta, { color: colorEstado[estado] }]}>
          {estado.toUpperCase()}
        </Text>
        <Text style={styles.latencia}>
          {latencia !== null ? `${latencia} ms` : '— ms'}
        </Text>
        <Text style={styles.ciclos}>Ciclos completados: {ciclos}</Text>
        <Text style={styles.detalle}>nginx-01 · 10.0.2.30 · Puerto 80</Text>
      </View>

      <Pressable
        style={({ pressed }) => [
          styles.boton,
          activo ? styles.botonDetener : styles.botonIniciar,
          pressed && { opacity: 0.75 },
        ]}
        onPress={() => setActivo(a => !a)}
      >
        <Text style={styles.textoBoton}>
          {activo ? 'Detener ping' : 'Iniciar ping'}
        </Text>
      </Pressable>
    </View>
  )
}

const styles = StyleSheet.create({
  contenedor: {
    flex: 1,
    padding: 24,
    gap: 16,
    justifyContent: 'center',
  },
  titulo: {
    fontSize: 20,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  tarjeta: {
    backgroundColor: '#f5f5f5',
    borderRadius: 12,
    padding: 20,
    gap: 8,
    alignItems: 'center',
  },
  etiqueta: {
    fontSize: 18,
    fontWeight: 'bold',
  },
  latencia: {
    fontSize: 40,
    fontWeight: 'bold',
  },
  ciclos: {
    fontSize: 14,
    color: '#555',
  },
  detalle: {
    fontSize: 12,
    color: '#999',
  },
  boton: {
    borderRadius: 10,
    paddingVertical: 14,
    alignItems: 'center',
  },
  botonIniciar: {
    backgroundColor: '#1565c0',
  },
  botonDetener: {
    backgroundColor: '#c62828',
  },
  textoBoton: {
    color: '#fff',
    fontSize: 16,
    fontWeight: 'bold',
  },
})