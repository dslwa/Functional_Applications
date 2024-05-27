package Spiral;
import java.util.ArrayList;
import java.util.List;
import Exceptions.EmptyArray;
public class Spiral {
    private List<Integer> res = new ArrayList<>();
    private int n;
    private int m;

    private int[][] matrix;

    public void spiral(){
        try{
            if(matrix.length == 0){
                throw new EmptyArray("Matrix is empty");
            }
        }
        catch(EmptyArray a){
            System.out.printf(a.getMessage());
        }
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while(top < bottom + 1 && left < right + 1) {
            for (int i = top; i < bottom + 1; i++) {
                this.res.add(matrix[i][left]);
            }
            left++;

            for (int i = left; i < right + 1; i++) {
                this.res.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i > top - 1; i--) {
                this.res.add(matrix[i][right]);
            }
            right--;

            for (int i = right; i > left - 1; i--) {
                this.res.add(matrix[top][i]);
            }
            top++;
        }
    }
    public void print(){
        System.out.println("Matrix:" +
                "");
        for(int i =0 ;i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] +  "    ");
            }
            System.out.println();
        }
        System.out.printf("Spiral: ");
        System.out.println(res);
    }
    public Spiral(int n, int m, int[][] matrix) {
        this.n = n;
        this.m = m;
        this.matrix = matrix;
    }


}
