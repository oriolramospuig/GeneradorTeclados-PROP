package main.domain.classes.functions;

import main.domain.classes.types.PairFrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GilmoreLawler {
    int filas;
    int columnas;
    int glBound;
    int [][] matrizFrecuencias;
    int [][] matrizDistancias;

    public GilmoreLawler (int nf, int nc, int bound, int [][] mf, int [][] md) {
        this.filas = nf;
        this.columnas = nc;
        this.glBound = bound;
        this.matrizDistancias = md;
        this.matrizFrecuencias = mf;
    }

    public int getFilas() {
        return this.filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return this.columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getGlBound() {
        return this.glBound;
    }

    public void setGlBound(int glBound) {
        this.glBound = glBound;
    }

    public int[][] getMatrizFrecuencias() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.matrizFrecuencias)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    public void setMatrizFrecuencias(int[][] matrizFrecuencias) {
        this.matrizFrecuencias = matrizFrecuencias;
    }

    public int[][] getMatrizDistancias() {
        // Devuelve una copia para evitar la modificación directa de la matriz
        return Arrays.stream(this.matrizDistancias)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    public void setMatrizDistancias(int[][] matrizDistancias) {
        this.matrizDistancias = matrizDistancias;
    }

    public int gilmore_lawler(List<PairFrequency> frecuenciasPares, List<Character> teclas, int cotaINI) {
        System.out.println("GILMORE-LAWLER ejecutándose");
        System.out.println();
        // Inicializar la cota con el peor escenario posible
        glBound = cotaINI;
        /**Matriz de frecuencias bien matriz de distancias hay que comprobar*/
        // generarMatrizDeFrecuencias(frecuenciasPares, teclas);
        // generarMatrizDistancias();

        // Preparar una lista para mantener un registro de la permutación actual y la visitada
        List<Integer> permutacionActual = new ArrayList<>();
        boolean[] visitado = new boolean[filas * columnas];

        // Llamar a DFS para todas las posiciones
        for (int i = 0; i < filas * columnas; i++) {
            dfs(i, visitado, permutacionActual);
            // Restablecer para la siguiente iteración de DFS
            permutacionActual.clear();
            Arrays.fill(visitado, false);
        }

        // Aquí tendrías que comparar el resultado de cada DFS con la cota actual y actualizar la cota
        // con el menor valor encontrado. Este es un lugar donde se aplicaría la lógica de Gilmore-Lawler.
        // Por simplicidad, este código no muestra esa comparación directamente.
        System.out.println("GILMORE_LAWLER acabado; Cota final = " + glBound);
        System.out.println();
        return glBound;
    }

    private void dfs(int indice, boolean[] visitado, List<Integer> permutacionActual) {
        // Marcar la posición actual como visitada
        visitado[indice] = true;
        permutacionActual.add(indice);

        // Verificar si hemos llegado al final de la permutación
        if (permutacionActual.size() == filas * columnas) {
            // Calcular la cota para esta permutación
            int cotaPermutacion = calcularCotaPermutacion(permutacionActual);
            if (cotaPermutacion < glBound) glBound = cotaPermutacion;
        } else {
            // Continuar la búsqueda en profundidad para la siguiente posición no visitada
            for (int i = 0; i < filas * columnas; i++) {
                if (!visitado[i]) {
                    dfs(i, visitado, permutacionActual);
                }
            }
        }

        // Backtrack: deshacer la última acción antes de la próxima iteración
        visitado[indice] = false;
        permutacionActual.remove(permutacionActual.size() - 1);
    }

    // Método para calcular la cota de una permutación específica
    // Nota: Este es un pseudocódigo para ilustrar el concepto. La implementación real
    // puede variar dependiendo de la estructura y los datos de tu problema específico.
    private int calcularCotaPermutacion(List<Integer> permutacionActual) {
        // Calcular la cota basada en la permutación actual y las matrices de frecuencia y distancia
        int cota = 0;
        for (int i = 0; i < permutacionActual.size(); i++) {
            for (int j = 0; j < permutacionActual.size(); j++) {
                // Asumiendo que matrizDistancias y matrizFrecuencias están correctamente pobladas
                cota += matrizDistancias[permutacionActual.get(i)][permutacionActual.get(j)]
                        * matrizFrecuencias[i][j];
            }
        }
        return cota;
    }

}
