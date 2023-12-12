package main.domain.classes.functions;

import java.util.Arrays;

public class HungarianAlgorithm {

    private static final double INF = 1e8; // Un valor muy grande para representar 'infinito'

    private int N; // El número de elementos (teclas o posiciones)
    private int maxcoincidencia; // El máximo número de coincidencias encontradas
    private int[] prioridadteclas; // Prioridades asignadas a las teclas
    private int[] prioridadPos; // Prioridades asignadas a las posiciones
    private int[] teclastoPos; // Asignaciones de teclas a posiciones
    private int[] Postoteclas; // Asignaciones de posiciones a teclas
    private boolean[] S; // Conjunto de teclas seleccionadas
    private boolean[] T; // Conjunto de posiciones seleccionadas
    private int[] minimCostassignar; // Costo mínimo para asignar una tecla a una posición
    private int[] TeclacostMin; // Tecla que causa el costo mínimo
    private int[] teclaprevia; // Tecla previa en el árbol de asignación

    /**
     * Constructor que inicializa el algoritmo con un tamaño específico.
     *
     * @param n El tamaño de la matriz, que es el número de teclas o posiciones.
     */
    public HungarianAlgorithm(int n) {
        N = n;
        maxcoincidencia = 0;
        prioridadteclas = new int[N];
        prioridadPos = new int[N];
        teclastoPos = new int[N];
        Postoteclas = new int[N];
        S = new boolean[N];
        T = new boolean[N];
        minimCostassignar = new int[N];
        TeclacostMin = new int[N];
        teclaprevia = new int[N];
    }

    /**
     * Añade una tecla al árbol de expansión del algoritmo húngaro y actualiza la información de 'slack'.
     *
     * @param act La tecla actual que se está considerando para la asignación.
     * @param prev La tecla previa conectada a la actual en el árbol de expansión.
     * @param cost La matriz de costos que representa las incompatibilidades entre teclas y posiciones.
     */
    private void addToTree(int act, int prev, int[][] cost) {
        int slackForNewNode;

        S[act] = true;
        teclaprevia[act] = prev;

        for (int i = 0; i < N; ++i) {
            if (!T[i]) {
                slackForNewNode = prioridadteclas[act] + prioridadPos[i] - cost[act][i];
                if (slackForNewNode < minimCostassignar[i]) {
                    minimCostassignar[i] = slackForNewNode;
                    TeclacostMin[i] = act;
                }
            }
        }
    }

    /**
     * Inicializa las etiquetas (prioridades) de las teclas y las posiciones.
     *
     * @param cost La matriz de costos que representa las incompatibilidades entre teclas y posiciones.
     */
    private void initetiq(int[][] cost) {
        Arrays.fill(prioridadPos, 0);
        Arrays.fill(prioridadteclas, Integer.MIN_VALUE);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                prioridadteclas[i] = Math.max(prioridadteclas[i], cost[i][j]);
            }
        }

        Arrays.fill(teclastoPos, -1);
        Arrays.fill(Postoteclas, -1);
    }

    /**
     * Actualiza las etiquetas (prioridades) de las teclas y las posiciones para el método de etiquetado.
     */
    private void actualizaretiquetas() {
        int delta = Integer.MAX_VALUE;

        for (int i = 0; i < N; ++i) {
            if (!T[i]) {
                delta = Math.min(delta, minimCostassignar[i]);
            }
        }

        for (int i = 0; i < N; ++i) {
            if (S[i]) {
                prioridadteclas[i] -= delta;
            }
            if (T[i]) {
                prioridadPos[i] += delta;
            }
        }

        for (int i = 0; i < N; ++i) {
            if (!T[i]) {
                minimCostassignar[i] -= delta;
            }
        }
    }

    /**
     * Intenta aumentar el número máximo de asignaciones posibles.
     *
     * @param cost La matriz de costos que representa las incompatibilidades entre teclas y posiciones.
     */
    private void augment(int[][] cost) {
        if (maxcoincidencia == N) {
            return;
        }

        Arrays.fill(S, false);
        Arrays.fill(T, false);
        Arrays.fill(teclaprevia, -1);

        int[] queue = new int[N];
        int qHead = 0;
        int qTail = 0;

        int root = -1;
        for (int i = 0; i < N; ++i) {
            if (teclastoPos[i] == -1) {
                queue[qTail++] = i;
                root = i;
                teclaprevia[i] = -2;
                S[i] = true;
                break;
            }
        }

        for (int j = 0; j < N; ++j) {
            minimCostassignar[j] = prioridadteclas[root] + prioridadPos[j] - cost[root][j];
            TeclacostMin[j] = root;
        }

        int x = -1;
        int y = -1;
        while (true) {
            while (qHead < qTail) {
                x = queue[qHead++];
                for (y = 0; y < N; y++) {
                    if (cost[x][y] == prioridadteclas[x] + prioridadPos[y] && !T[y]) {
                        if (Postoteclas[y] == -1) {
                            break;
                        }
                        T[y] = true;
                        queue[qTail++] = Postoteclas[y];
                        addToTree(Postoteclas[y], x, cost);
                    }
                }
                if (y < N) {
                    break;
                }
            }
            if (y < N) {
                break;
            }

            actualizaretiquetas();

            qHead = 0;
            qTail = 0;

            for (y = 0; y < N; y++) {
                if (!T[y] && minimCostassignar[y] == 0) {
                    if (Postoteclas[y] == -1) {
                        x = TeclacostMin[y];
                        break;
                    } else {
                        T[y] = true;
                        if (!S[Postoteclas[y]]) {
                            queue[qTail++] = Postoteclas[y];
                            addToTree(Postoteclas[y], TeclacostMin[y], cost);
                        }
                    }
                }
            }
            if (y < N) {
                break;

            }
        }

        if (y < N) {
            maxcoincidencia++;
            for (int cx = x, cy = y, ty; cx != -2; cx = teclaprevia[cx], cy = ty) {
                ty = teclastoPos[cx];
                Postoteclas[cy] = cx;
                teclastoPos[cx] = cy;
            }
            augment(cost);
        }
    }

    /**
     * Calcula la asignación con el menor costo total utilizando el algoritmo húngaro.
     *
     * @param cost La matriz de costos que representa las incompatibilidades entre teclas y posiciones.
     * @return El costo total de la asignación óptima.
     */
    public int hungarianLeastCost(int[][] cost) {
        int maxCost = Arrays.stream(cost).flatMapToInt(Arrays::stream).max().orElse(Integer.MIN_VALUE);
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                cost[i][j] = maxCost - cost[i][j];
            }
        }

        initetiq(cost);
        augment(cost);

        int totalCost = 0;
        for (int i = 0; i < N; ++i) {
            totalCost += cost[i][teclastoPos[i]];
        }
        totalCost = maxCost * N - totalCost; // Adjust cost back to the original
        return totalCost;
    }
}
