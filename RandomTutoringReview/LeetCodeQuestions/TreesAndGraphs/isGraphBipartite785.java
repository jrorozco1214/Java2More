package LeetCodeQuestions.TreesAndGraphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class isGraphBipartite785 {

    public static void main(String[] args) {

        boolean result = isBipartite(new int[][]{
            {1},{0},{3,4},{2,4},{2,3}
        });

        System.out.println(result);
    }


    public static boolean isBipartite(int[][] graph) {

        // boolean[][] adjMatrix = buildAdjMatrix(graph);

        final int RED = 1;
        final int BLUE = 2;

        int[] nodeColors = new int[graph.length];

        Queue<Integer> colorQ = new LinkedList<>();

        for(int root = 0; root < graph.length; root++){

            if(nodeColors[root] != 0) continue;

            nodeColors[root] = RED;
            colorQ.add(root);

            while(!colorQ.isEmpty()){

                int i = colorQ.remove();

                for(Integer j: graph[i]){

                    if(nodeColors[j] == 0){

                        if(nodeColors[i] == RED){

                            nodeColors[j] = BLUE;
                        } else if(nodeColors[i] == BLUE){

                            nodeColors[j] = RED;
                        }

                        colorQ.add(j);
                    } else if(nodeColors[i] == nodeColors[j]){

                        return false;
                    }
                }

            }
        }

        return true;

        // for(int i = 0; i < adjMatrix.length; i++){

        //     for(int j = i + 1; j < adjMatrix[0].length; j++){

        //         if(adjMatrix[i][j] == false) continue;

        //         if(nodeColors[j] == 0){

        //             if(nodeColors[i] == RED){

        //                 nodeColors[j] = BLUE;
        //             } else if(nodeColors[i] == BLUE){

        //                 nodeColors[j] = RED;
        //             }
        //         } else if(nodeColors[i] == nodeColors[j]){

        //             return false;
        //         }
        //     }
        // }

        // return true;
    }

    // public static boolean[][] buildAdjMatrix(int[][]graph){

    //     int numOfNodes = graph.length;

    //     boolean[][] matrix = new boolean[numOfNodes][numOfNodes];

    //     for(int i = 0; i < numOfNodes; i++){

    //         for(Integer j: graph[i]){

    //             matrix[i][j] = true;
                
    //         }
    //     }

    //     return matrix;
    // }
    
}
