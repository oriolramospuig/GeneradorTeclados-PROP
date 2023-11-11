package main.domain.classes.functions;

import main.domain.classes.types.PairFrequency;

import java.util.*;
import java.util.stream.Collectors;

public class GilmoreLawler {
    int filas;
    int columnas;
    int glBound;
    int [][] matrizFrecuencias;
    int [][] matrizDistancias;
    HashMap<Character, Integer> letraAIndice;

    public GilmoreLawler (int nf, int nc, int bound, int [][] mf, int [][] md, HashMap<Character, Integer> letraAIndice) {
        this.filas = nf;
        this.columnas = nc;
        this.glBound = bound;
        this.matrizDistancias = md;
        this.matrizFrecuencias = mf;
        this.letraAIndice = letraAIndice;
    }

    public int gilmore_lawler(List<PairFrequency> frecuenciasPares, List<Character> teclas, int cotaINI) {
        System.out.println("GILMORE-LAWLER ejecutándose");
        System.out.println();
        // Inicializar la cota con el peor escenario posible
        glBound = cotaINI;

        // Convertir la lista de teclas a una lista de índices basados en el orden dado por 'teclas'
        List<Integer> indicesOrdenados = teclas.stream()
                .map(letraAIndice::get)
                .collect(Collectors.toList());

        // Inicializar la solución parcial como una lista de índices en lugar de caracteres
        List<Integer> solucionParcial = new ArrayList<>(Collections.nCopies(filas * columnas, -1));

        // Llamar a DFS usando el orden de las teclas ordenadas por frecuencia
        dfs(0, indicesOrdenados, solucionParcial, 0); // Empezar DFS con profundidad 0 y cota 0

        System.out.println("GILMORE_LAWLER acabado; Cota final = " + glBound);
        System.out.println();
        return glBound;
    }

    private void dfs(int profundidad, List<Integer> indicesOrdenados, List<Integer> solucionParcial, int cotaActual) {
        if (profundidad == filas * columnas) {
            // Se ha encontrado una solución completa
            int cotaPermutacion = calcularCotaPermutacion(solucionParcial);
            if (cotaPermutacion < glBound) {
                glBound = cotaPermutacion;
                // Aquí podrías guardar la solución parcial actual si es la mejor encontrada hasta ahora
            }
        } else {
            // Probar colocando la siguiente tecla en la posición correspondiente al orden dado
            int indiceTeclaActual = indicesOrdenados.get(profundidad);
            for (int posicion = 0; posicion < filas * columnas; posicion++) {
                if (solucionParcial.get(posicion) == -1) { // Si la posición está libre
                    solucionParcial.set(posicion, indiceTeclaActual); // Coloca la tecla en la posición libre
                    int nuevaCota = cotaActual + calcularContribucionC1C2(solucionParcial, posicion, indiceTeclaActual);
                    if (nuevaCota < glBound) {
                        dfs(profundidad + 1, indicesOrdenados, solucionParcial, nuevaCota);
                        solucionParcial.set(posicion, -1); // Limpia la posición para el próximo intento
                    }

                }
            }
        }
    }


    // Método para calcular la cota de una permutación específica
    // Nota: Este es un pseudocódigo para ilustrar el concepto. La implementación real
    // puede variar dependiendo de la estructura y los datos de tu problema específico.
    private int calcularCotaPermutacion(List<Integer> permutacionActual) {
        // Calcular la cota basada en la permutación actual y las matrices de frecuencia y distancia
        int cota = 0;
        for (int i = 0; i < permutacionActual.size(); i++) {
            for (int j = 0; j < permutacionActual.size(); j++) {
                cota += matrizDistancias[permutacionActual.get(i)][permutacionActual.get(j)]
                        * matrizFrecuencias[i][j];
            }
        }
        return cota;
    }

    private int calcularContribucionC1(int indiceTeclaActual, int posicion, List<Integer> solucionParcial) {
        int contribucionC1 = 0;
        for (int j = 0; j < solucionParcial.size(); j++) {
            if (solucionParcial.get(j) != -1) { // Si la tecla en la solución parcial está emplazada
                // Calcula el costo de tráfico entre la i-ésima tecla y la tecla en la j-ésima posición emplazada
                contribucionC1 += matrizDistancias[posicion][j] * matrizFrecuencias[indiceTeclaActual][solucionParcial.get(j)];
            }
        }
        return contribucionC1;
    }

    private int calcularContribucionC2(int indiceTeclaActual, int posicion, List<Integer> solucionParcial) {
        int contribucionC2 = 0;
        // Crear los vectores T y D basados en tráfico y distancia respectivamente
        List<Integer> traficoNoEmplazado = new ArrayList<>();
        List<Integer> distanciaNoOcupada = new ArrayList<>();

        for (int i = 0; i < matrizFrecuencias.length; i++) {
            if (!solucionParcial.contains(i)) { // Si la tecla 'i' no está emplazada
                traficoNoEmplazado.add(matrizFrecuencias[indiceTeclaActual][i]);
            }
        }

        for (int i = 0; i < matrizDistancias.length; i++) {
            if (!solucionParcial.contains(i)) { // Si la posición 'i' no está ocupada
                distanciaNoOcupada.add(matrizDistancias[posicion][i]);
            }
        }

        // Ordenar T y D para el cálculo del producto escalar
        Collections.sort(traficoNoEmplazado);
        Collections.sort(distanciaNoOcupada, Collections.reverseOrder());

        // Calcular el producto escalar de T ordenado y D ordenado inversamente
        for (int i = 0; i < traficoNoEmplazado.size(); i++) {
            contribucionC2 += traficoNoEmplazado.get(i) * distanciaNoOcupada.get(i);
        }

        return contribucionC2;
    }

    // Función que calcula la contribución de C1 y C2
    private int calcularContribucionC1C2(List<Integer> solucionParcial, int posicion, int indiceTeclaActual) {
        int contribucionC1 = calcularContribucionC1(indiceTeclaActual, posicion, solucionParcial);
        int contribucionC2 = calcularContribucionC2(indiceTeclaActual, posicion, solucionParcial);

        // Sumar las contribuciones de C1 y C2 para obtener la contribución total de la tecla 'i' en la posición 'k'
        return contribucionC1 + contribucionC2;
    }

}


