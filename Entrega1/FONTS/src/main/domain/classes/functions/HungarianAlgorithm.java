package main.domain.classes.functions;

import java.util.Arrays;

public class HungarianAlgorithm {

    private static final double INF = 1e8;

    private int N;
    private int maxMatch;
    private int[] labelX;
    private int[] labelY;
    private int[] matchXY;
    private int[] matchYX;
    private boolean[] S;
    private boolean[] T;
    private int[] slack;
    private int[] slackCauser;
    private int[] prevOnTree;

    public HungarianAlgorithm(int n) {
        initGlobalVariables(n);
    }

    private void addToTree(int current, int prev, int[][] cost) {
        int slackForNewNode;

        S[current] = true;
        prevOnTree[current] = prev;

        for (int i = 0; i < N; ++i) {
            if (!T[i]) {
                slackForNewNode = labelX[current] + labelY[i] - cost[current][i];
                if (slackForNewNode < slack[i]) {
                    slack[i] = slackForNewNode;
                    slackCauser[i] = current;
                }
            }
        }
    }

    private void initLabels(int[][] cost) {
        Arrays.fill(labelY, 0);
        Arrays.fill(labelX, Integer.MIN_VALUE);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                labelX[i] = Math.max(labelX[i], cost[i][j]);
            }
        }

        Arrays.fill(matchXY, -1);
        Arrays.fill(matchYX, -1);
    }

    private void updateLabels() {
        int delta = Integer.MAX_VALUE;

        for (int i = 0; i < N; ++i) {
            if (!T[i]) {
                delta = Math.min(delta, slack[i]);
            }
        }

        for (int i = 0; i < N; ++i) {
            if (S[i]) {
                labelX[i] -= delta;
            }
            if (T[i]) {
                labelY[i] += delta;
            }
        }

        for (int i = 0; i < N; ++i) {
            if (!T[i]) {
                slack[i] -= delta;
            }
        }
    }

    private void augment(int[][] cost) {
        if (maxMatch == N) {
            return;
        }

        Arrays.fill(S, false);
        Arrays.fill(T, false);
        Arrays.fill(prevOnTree, -1);

        int[] queue = new int[N];
        int qHead = 0;
        int qTail = 0;

        int root = -1;
        for (int i = 0; i < N; ++i) {
            if (matchXY[i] == -1) {
                queue[qTail++] = i;
                root = i;
                prevOnTree[i] = -2;
                S[i] = true;
                break;
            }
        }

        for (int j = 0; j < N; ++j) {
            slack[j] = labelX[root] + labelY[j] - cost[root][j];
            slackCauser[j] = root;
        }

        int x = -1;
        int y = -1;
        while (true) {
            while (qHead < qTail) {
                x = queue[qHead++];
                for (y = 0; y < N; y++) {
                    if (cost[x][y] == labelX[x] + labelY[y] && !T[y]) {
                        if (matchYX[y] == -1) {
                            break;
                        }
                        T[y] = true;
                        queue[qTail++] = matchYX[y];
                        addToTree(matchYX[y], x, cost);
                    }
                }
                if (y < N) {
                    break;
                }
            }
            if (y < N) {
                break;
            }

            updateLabels();

            qHead = 0;
            qTail = 0;

            for (y = 0; y < N; y++) {
                if (!T[y] && slack[y] == 0) {
                    if (matchYX[y] == -1) {
                        x = slackCauser[y];
                        break;
                    } else {
                        T[y] = true;
                        if (!S[matchYX[y]]) {
                            queue[qTail++] = matchYX[y];
                            addToTree(matchYX[y], slackCauser[y], cost);
                        }
                    }
                }
            }
            if (y < N) {
                break;

            }
        }

        if (y < N) {
            maxMatch++;
            for (int cx = x, cy = y, ty; cx != -2; cx = prevOnTree[cx], cy = ty) {
                ty = matchXY[cx];
                matchYX[cy] = cx;
                matchXY[cx] = cy;
            }
            augment(cost);
        }
    }

    public int hungarianLeastCost(int[][] cost) {
        int maxCost = Arrays.stream(cost).flatMapToInt(Arrays::stream).max().orElse(Integer.MIN_VALUE);
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                cost[i][j] = maxCost - cost[i][j];
            }
        }

        initLabels(cost);
        augment(cost);

        int totalCost = 0;
        for (int i = 0; i < N; ++i) {
            totalCost += cost[i][matchXY[i]];
        }
        totalCost = maxCost * N - totalCost; // Adjust cost back to the original
        return totalCost;
    }

    private void initGlobalVariables(int n) {
        N = n;
        maxMatch = 0;
        labelX = new int[N];
        labelY = new int[N];
        matchXY = new int[N];
        matchYX = new int[N];
        S = new boolean[N];
        T = new boolean[N];
        slack = new int[N];
        slackCauser = new int[N];
        prevOnTree = new int[N];
    }

    public static void main(String[] args) {
        int[][] costMatrix = {
                {4, 1, 3},
                {2, 0, 5},
                {3, 2, 2}
        };

        HungarianAlgorithm ha = new HungarianAlgorithm(costMatrix.length);
        int result = ha.hungarianLeastCost(costMatrix);
        System.out.println("The result is: " + result);
    }
}
