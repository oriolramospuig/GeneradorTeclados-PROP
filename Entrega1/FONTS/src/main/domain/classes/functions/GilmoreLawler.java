package main.domain.classes.functions;

import main.domain.classes.types.PairFrequency;

import javax.sound.midi.SysexMessage;
import java.util.*;
import java.util.stream.Collectors;

/** Clase que implementa el algoritmo de gilmore-lawler. Recibe las matrices de frecuencias
 * y de distancias y calcula una asignación mediante la cota de gilmore lawler, llamando
 * al algortimo Húngaro
 * @author X (X@estudiantat.upc.edu)
 */
public class GilmoreLawler {
    int filas;
    int columnas;
    int glBound;
    int [][] matrizFrecuencias;
    int [][] matrizDistancias;
    HashMap<Character, Integer> letraAIndice;
    private List<Integer> mejorSolucionParcial;

    ///// CONSTRUCTORA

    public GilmoreLawler() {
        this.filas = 0;
        this.columnas = 0;
        this.glBound = 0;
        this.matrizDistancias = new int[0][0];
        this.matrizFrecuencias = new int[0][0];
        this.letraAIndice = new HashMap<Character, Integer>();
        this.mejorSolucionParcial = new ArrayList<>();
    }
    public GilmoreLawler (int nf, int nc, int bound, int [][] mf, int [][] md, HashMap<Character, Integer> letraAIndice) {
        this.filas = nf;
        this.columnas = nc;
        this.glBound = bound;
        this.matrizDistancias = md;
        this.matrizFrecuencias = mf;
        this.letraAIndice = letraAIndice;
        this.mejorSolucionParcial = new ArrayList<>();
    }

    /// GETTERS

    public int getFilas() {return filas;}

    public int getColumnas() {return columnas;}

    public int getGlBound() {return glBound;}

    public int[][] getMatrizFrecuencias() { return matrizFrecuencias;}

    public int[][] getMatrizDistancias() { return matrizDistancias;}

    public HashMap<Character,Integer> getLetraAIndice() {return letraAIndice;}

    // Método para obtener la mejor solución parcial como lista de índices
    public List<Integer> getMejorSolucionParcial() {
        return new ArrayList<>(mejorSolucionParcial); // Devuelve una copia defensiva
    }
    /// GETTERS

    public void setMejorSolucionParcial(List<Integer> mejorSolucionParcial) {
        this.mejorSolucionParcial = mejorSolucionParcial;
    }

    /// FUNCIONES PRINCIPALES
    public int gilmore_lawler() {
        System.out.println("GILMORE-LAWLER ejecutándose");
        System.out.println();
        // Inicializar la cota con el peor escenario posible
        //glBound = cotaINI;
        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < matrizFrecuencias.length; ++i) {
            ind.add(i);
        }
        // Inicializar la solución parcial como una lista de índices en lugar de caracteres
        List<Integer> solucionParcial = new ArrayList<>(Collections.nCopies(filas * columnas, -1));
        List<Integer> posicionesNoUsadas = new ArrayList<>();
        List<Integer> letrasNO = new ArrayList<>();
        for (int i = 0; i < ind.size(); ++i) {
            posicionesNoUsadas.add(i);
            letrasNO.add(i);
        }
        boolean[] vis = new boolean[ind.size()];
        // Llamar a DFS usando el orden de las teclas ordenadas por frecuencia
        dfs(0, ind, solucionParcial, 0, posicionesNoUsadas, letrasNO, vis); // Empezar DFS con profundidad 0 y cota 0

        System.out.println("GILMORE_LAWLER acabado; Cota final = " + glBound);
        System.out.println();
        imprimirMejorSolucionParcial();
        return glBound;
    }

    private void dfs(int profundidad, List<Integer> ind, List<Integer> solucionParcial, int cotaActual, List<Integer> posNO, List<Integer> letNO, boolean[] vis) {
        if (profundidad == filas * columnas) {
            // Se ha encontrado una solución completa
            int cotaPermutacion = calcularCotaPermutacion(solucionParcial);
            // System.out.println(cotaPermutacion + " = Cota permutacion");
            if (cotaPermutacion < glBound) {
                glBound = cotaPermutacion;
                mejorSolucionParcial = new ArrayList<>(solucionParcial);
            }
        }
        else {
            //System.out.println(profundidad + " posicion actual**********************************************************");
            for (int letra = 0; letra < filas*columnas; ++letra) {
                if (solucionParcial.get(letra) == -1) {
                    solucionParcial.set(letra, profundidad); // Coloca la tecla en la posición libre
                    //System.out.println(letra + " Letra actual************************************");

                    Integer x = letra;
                    letNO.remove(x);
                    Integer y = profundidad;
                    posNO.remove(y);

                    int nuevaCota = cotaActual + calcularContribucionC1C2(solucionParcial, profundidad, letra, posNO, letNO);

                    if (nuevaCota < glBound) {
                        int cotaAnt = cotaActual;
                        cotaActual = calcularCotaPermutacionAct(solucionParcial);
                        dfs(profundidad + 1, ind, solucionParcial, cotaActual, posNO, letNO, vis);
                        cotaActual = cotaAnt;
                    }
                    solucionParcial.set(letra, -1); // Limpia la posición para el próximo intento
                    letNO.add(letra);
                    posNO.add(profundidad);
                }

            }



            // Probar colocando la siguiente tecla en la posición correspondiente al orden dado
            //int indiceTeclaActual = ind.get(profundidad);
            /*for (int posicion = 0; posicion < filas * columnas; posicion++) {
                if (solucionParcial.get(posicion) == -1) { // Si la posición está libre
                    solucionParcial.set(posicion, indiceTeclaActual); // Coloca la tecla en la posición libre
                      System.out.println(indiceTeclaActual + " Indice actual******************************************************");
                      System.out.println(posicion + " posicion actual*************************************************************");
                     Integer x = indiceTeclaActual;
                     letNO.remove(x);
                     Integer y = posicion;
                     posNO.remove(y);
                     /*System.out.println("LETNO");
                     for (int i = 0; i < letNO.size(); ++i) {
                         System.out.print(letNO.get(i) + " ");
                     }
                     System.out.println();
                    System.out.println("POSNO");
                    for (int i = 0; i < posNO.size(); ++i) {
                        System.out.print(posNO.get(i) + " ");
                    }
                    System.out.println();

                    int nuevaCota = cotaActual + calcularContribucionC1C2(solucionParcial, posicion, indiceTeclaActual, posNO, letNO);
                    //System.out.println("Nueva cota = " + nuevaCota);
                    //System.out.println("Contribución C1C2 = " + (nuevaCota-cotaActual));
                    //System.out.println("Solucion parcial = " + solucionParcial);
                    if (nuevaCota < glBound) {
                        int cotaAnt = cotaActual;
                        cotaActual = calcularCotaPermutacionAct(solucionParcial);
                        dfs(profundidad + 1, ind, solucionParcial, cotaActual, posNO, letNO);
                        solucionParcial.set(posicion, -1); // Limpia la posición para el próximo intento
                        cotaActual = cotaAnt;
                    }
                    letNO.add(indiceTeclaActual);
                    posNO.add(posicion);

                }
            }*/
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
            //System.out.println("letra " + letNO.get(i));
            for (int j = 0; j < posNO.size(); ++j) {
                //System.out.println("posicion " + posNO.get(j));
                //calculamos T
                List<Integer> traficoNoEmplazado = new ArrayList<>();
                for (int k = 0; k < letNO.size(); ++k) {
                    if (!letNO.get(k).equals(letNO.get(i))) traficoNoEmplazado.add(matrizFrecuencias[letNO.get(i)][letNO.get(k)]);
                }
                //calculamos d
                List<Integer> distanciaNoOcupada = new ArrayList<>();
                for (int k = 0; k < posNO.size(); ++k) {
                  //  System.out.println("posicion k " + posNO.get(k));
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
                //if (i == 3 && j == 5) {
                /*    System.out.println("T = ");
                    System.out.println();
                    for (int k = 0; k < traficoNoEmplazado.size(); ++k) {
                        System.out.println(traficoNoEmplazado.get(k));
                    }
                    System.out.println();
                    System.out.println("D = ");
                    System.out.println();
                    for (int k = 0; k < distanciaNoOcupada.size(); ++k) {
                        System.out.println(distanciaNoOcupada.get(k));
                    }
                    System.out.println("Contribucion i = "+ i + " j = " + j + " = " + contribucionC2);
                //}*/

            }
        }
        /*System.out.println("Matriz C2 = ");
        System.out.println();
        for (int i = 0; i < c2.length; ++i) {
            for (int j = 0; j < c2.length; ++j) {
                System.out.println(c2[i][j]);
            }
            System.out.println();
        }

         */


        return c2;
    }

    // Función que calcula la contribución de C1 y C2
    private int calcularContribucionC1C2(List<Integer> solucionParcial, int posicion, int indiceTeclaActual, List<Integer> posNO, List<Integer> letNO) {
        int [][] c1 = calcularContribucionC1(indiceTeclaActual, posicion, solucionParcial, posNO, letNO);
        int [][] c2 = calcularContribucionC2(indiceTeclaActual, posicion, solucionParcial, posNO, letNO);
        int [][] c1c2 = Matrices.sumaMatrices(c1,c2);
        //if (c1c2.length != 0) return HungarianAlgorithm.Hungarian(c1c2);
        return minimos(c1c2);
    }

    public void imprimirMejorSolucionParcial() {
        // Suponiendo que 'mejorSolucionParcial' es una lista de índices que representa la mejor solución actual
        System.out.print("La mejor solución parcial es: ");
        for (int tecla = 0; tecla < mejorSolucionParcial.size(); tecla++) {
            int posicion = mejorSolucionParcial.get(tecla);
            System.out.println("Posición " + posicion + ": Elemento " + tecla + " | ");
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


