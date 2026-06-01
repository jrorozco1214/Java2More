package LeetCodeQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class floodFill{

    record Pair(int x, int y){ //creating a new type like if you wanted to a create 3D vector

    };


    public static void main(String[] args) {

        int [][] ar = new int[][]{
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        System.out.println(Arrays.deepToString(floodFill(ar, 2, 0, 2)));

        /*
        In this problem we utilized BFS and remember BFS uses a queue for the algorithm
        */
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        final int target = image[sr][sc]; //color

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));

        boolean[][] hasBeenVisted = new boolean[image.length][image[0].length]; //will be all false by default
        
        hasBeenVisted[sr][sc] = true;

        while(!queue.isEmpty()){

            Pair current = queue.remove();

            image[current.x][current.y] = color; 

            ArrayList<Pair> neighbors = findNeighbors(current, image[0].length, image.length);

            for(Pair p: neighbors){

                if(!hasBeenVisted[p.x][p.y] && image[p.x][p.y] == target){ //dont forget the ! negation

                    queue.add(p);
                    hasBeenVisted[p.x][p.y] = true;
                }
            }
        }

        //System.out.println(neighbors.toString());



        return image;
    }

    public static ArrayList<Pair> findNeighbors(Pair node, int width, int height){

        ArrayList<Pair> neighborsList = new ArrayList<>();

        if(node.x != 0){

            neighborsList.add(new Pair(node.x-1, node.y));
        }

        if(node.x+1 < width) { //grid[0].length is the rows length and grid.length is the column length

            neighborsList.add(new Pair(node.x+1, node.y));
        }

        if(node.y != 0){
            neighborsList.add(new Pair(node.x, node.y-1));
        }

        if(node.y+1 < height){
            neighborsList.add(new Pair(node.x, node.y+1));
        }

        return neighborsList;
    }
}