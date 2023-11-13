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
    private List<Integer> mejorSolucionParcial;


    public GilmoreLawler (int nf, int nc, int bound, int [][] mf, int [][] md, HashMap<Character, Integer> letraAIndice) {
        this.filas = nf;
        this.columnas = nc;
        this.glBound = bound;
        this.matrizDistancias = md;
        this.matrizFrecuencias = mf;
        this.letraAIndice = letraAIndice;
        this.mejorSolucionParcial = new ArrayList<>();
    }

    // Método para obtener la mejor solución parcial como lista de índices
    public List<Integer> getMejorSolucionParcial() {
        return new ArrayList<>(mejorSolucionParcial); // Devuelve una copia defensiva
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
        List<Integer> posicionesNoUsadas = new ArrayList<>();
        List<Integer> letrasNO = new ArrayList<>();
        for (int i = 0; i < teclas.size(); ++i) {
            posicionesNoUsadas.add(i);
            letrasNO.add(i);
        }

        // Llamar a DFS usando el orden de las teclas ordenadas por frecuencia
        dfs(0, indicesOrdenados, solucionParcial, 0, posicionesNoUsadas, letrasNO); // Empezar DFS con profundidad 0 y cota 0


        System.out.println("GILMORE_LAWLER acabado; Cota final = " + glBound);
        System.out.println();
        imprimirMejorSolucionParcial();
        return glBound;
    }

    private void dfs(int profundidad, List<Integer> indicesOrdenados, List<Integer> solucionParcial, int cotaActual, List<Integer> posNO, List<Integer> letNO) {
        if (profundidad == filas * columnas) {
            // Se ha encontrado una solución completa
            int cotaPermutacion = calcularCotaPermutacion(solucionParcial);
            if (cotaPermutacion < glBound) {
                glBound = cotaPermutacion;
                mejorSolucionParcial = new ArrayList<>(solucionParcial);
            }
        } else {
            // Probar colocando la siguiente tecla en la posición correspondiente al orden dado
            int indiceTeclaActual = indicesOrdenados.get(profundidad);
            for (int posicion = 0; posicion < filas * columnas; posicion++) {
                if (solucionParcial.get(posicion) == -1) { // Si la posición está libre
                    solucionParcial.set(posicion, indiceTeclaActual); // Coloca la tecla en la posición libre
                     // System.out.println(indiceTeclaActual + " Indice actual");
                     // System.out.println(posicion + " posicion actual");
                     Integer x = indiceTeclaActual;
                     letNO.remove(x);
                     Integer y = posicion;
                     posNO.remove(y);
                    int nuevaCota = cotaActual + calcularContribucionC1C2(solucionParcial, posicion, indiceTeclaActual, posNO, letNO);
                    if (nuevaCota < glBound) {
                        int cotaAnt = cotaActual;
                        cotaActual = calcularCotaPermutacionAct(solucionParcial);
                        dfs(profundidad + 1, indicesOrdenados, solucionParcial, cotaActual, posNO, letNO);
                        solucionParcial.set(posicion, -1); // Limpia la posición para el próximo intento
                        cotaActual = cotaAnt;
                    }
                    letNO.add(indiceTeclaActual);
                    posNO.add(posicion);

                }
            }
        }
    }


    // Método para calcular la cota de una permutación específica
    private int calcularCotaPermutacion(List<Integer> permutacionActual) {
        int cota = 0;
        // Suponiendo que permutacionActual.size() == filas * columnas
        for (int i = 0; i < permutacionActual.size(); i++) {
            for (int j = i + 1; j < permutacionActual.size(); j++) { // Comenzar con j = i + 1 para evitar duplicados
                // Aquí se considera cada par de índices solo una vez, i con j, donde i < j
                int distanciaIJ = matrizDistancias[permutacionActual.get(i)][permutacionActual.get(j)];
                int frecuenciaIJ = matrizFrecuencias[i][j]; // La frecuencia de i a j es la misma que de j a i

                // Sumar el costo de la distancia multiplicado por la frecuencia de i a j
                cota += (distanciaIJ * frecuenciaIJ);
            }
        }
        return cota;
    }


    private int calcularCotaPermutacionAct(List<Integer> permutacionActual) {
        int cota = 0;
        for (int i = 0; i < permutacionActual.size(); i++) {
            for (int j = i + 1; j < permutacionActual.size(); j++) { // Comenzar con j = i + 1 para evitar duplicados
                if (permutacionActual.get(i) >= 0 && permutacionActual.get(j) >= 0) {// Aquí se considera cada par de índices solo una vez, i con j, donde i < j
                    int distanciaIJ = matrizDistancias[permutacionActual.get(i)][permutacionActual.get(j)];
                    int frecuenciaIJ = matrizFrecuencias[i][j]; // La frecuencia de i a j es la misma que de j a i

                    // Sumar el costo de la distancia multiplicado por la frecuencia de i a j
                    cota += (distanciaIJ * frecuenciaIJ);
                }
            }
        }
        return cota;
    }


    private int [][] calcularContribucionC1(int indiceTeclaActual, int posicion, List<Integer> solucionParcial, List<Integer> posNO, List<Integer> letNO) {
        int [][] c1 = new int[posNO.size()][posNO.size()];
        for (int i = 0; i < letNO.size(); ++i) {
            for (int j = 0; j < posNO.size(); ++j) {
                for (int k = 0; k < solucionParcial.size(); ++k) {
                    if (solucionParcial.get(k) != -1) {
                        c1[i][j] += matrizDistancias[posNO.get(j)][k]*matrizFrecuencias[letNO.get(i)][solucionParcial.get(k)];
                    }
                }
            }
        }
        return c1;

    }

    private int[][] calcularContribucionC2(int indiceTeclaActual, int posicion, List<Integer> solucionParcial, List<Integer> posNO, List<Integer> letNO) {

        int [][] c2 = new int[posNO.size()][posNO.size()];

        for (int i = 0; i < letNO.size(); ++i) {
            for (int j = 0; j < posNO.size(); ++j) {
                //calculamos T
                List<Integer> traficoNoEmplazado = new ArrayList<>();
                for (int k = 0; k < letNO.size(); ++k) {
                    if (!letNO.get(k).equals(letNO.get(i))) traficoNoEmplazado.add(matrizFrecuencias[letNO.get(i)][letNO.get(k)]);
                }
                //calculamos d
                List<Integer> distanciaNoOcupada = new ArrayList<>();
                for (int k = 0; k < posNO.size(); ++k) {
                    if (!posNO.get(k).equals(posNO.get(j))) distanciaNoOcupada.add(matrizDistancias[posNO.get(j)][posNO.get(k)]);
                }

                // Ordenar T y D para el cálculo del producto escalar
                Collections.sort(traficoNoEmplazado);
                Collections.sort(distanciaNoOcupada, Collections.reverseOrder());
                int contribucionC2 = 0;
                // Calcular el producto escalar de T ordenado y D ordenado inversamente
                for (int k = 0; k < traficoNoEmplazado.size(); k++) {
                    contribucionC2 += traficoNoEmplazado.get(k) * distanciaNoOcupada.get(k);
                }
                c2[i][j] = contribucionC2;
            }
        }



        return c2;
    }

    // Función que calcula la contribución de C1 y C2
    private int calcularContribucionC1C2(List<Integer> solucionParcial, int posicion, int indiceTeclaActual, List<Integer> posNO, List<Integer> letNO) {
        int [][] c1 = calcularContribucionC1(indiceTeclaActual, posicion, solucionParcial, posNO, letNO);
        int [][] c2 = calcularContribucionC2(indiceTeclaActual, posicion, solucionParcial, posNO, letNO);
        int [][] c1c2 = Matrices.sumaMatrices(c1,c2);
        return minimos(c1c2);
        // Sumar las contribuciones de C1 y C2 para obtener la contribución total de la tecla 'i' en la posición 'k'
    }

    public void imprimirMejorSolucionParcial() {
        // Suponiendo que 'mejorSolucionParcial' es una lista de índices que representa la mejor solución actual
        System.out.print("La mejor solución parcial es: ");
        for (int posicion = 0; posicion < mejorSolucionParcial.size(); posicion++) {
            char tecla = getTeclaPorIndice(mejorSolucionParcial.get(posicion));
            System.out.print("Posición " + posicion + ": Tecla " + tecla + " | ");
        }
        System.out.println(); // Finalizar con una nueva línea
    }

    private char getTeclaPorIndice(int indiceTecla) {
        for (Map.Entry<Character, Integer> entry : letraAIndice.entrySet()) {
            if (entry.getValue().equals(indiceTecla)) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("Índice de tecla no encontrado: " + indiceTecla);
    }

    public int minimos(int [][] c1c2) {
        int suma = 0;
        for (int i = 0; i < c1c2.length; ++i) {
            int min = c1c2[i][0];
            for (int j = 1; j < c1c2.length; ++j) {
                if (min > c1c2[i][j]) min = c1c2[i][j];
            }
            suma += min;
        }
        return suma;
    }



}


