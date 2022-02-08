import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int city = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int bus = Integer.parseInt(stringTokenizer.nextToken());
        int starting;
        int arrival;
        int cost;
        graph = new int[city + 1][city + 1];

        for (int i = 0; i < city + 1; i++) {
            for (int j = 0; j < city + 1; j++) {
                graph[i][j] =100_000_000;
                if (i == j){
                    graph[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= bus; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            starting = Integer.parseInt(stringTokenizer.nextToken());
            arrival = Integer.parseInt(stringTokenizer.nextToken());
            cost = Integer.parseInt(stringTokenizer.nextToken());
            graph[starting][arrival] = Math.min(graph[starting][arrival],cost);
        }
        for (int i = 1; i < city + 1; i++) {
            for (int j = 1; j < city + 1; j++) {
                for (int k = 1; k < city + 1; k++) {
                    if (graph[j][k] > graph[j][i] + graph[i][k]){
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }
        StringBuilder stringBuilder;
        for (int i = 1; i < city + 1; i++) {
            stringBuilder = new StringBuilder();
            for (int j = 1; j < city + 1; j++) {
                if (graph[i][j] == 100_000_000){
                    graph[i][j] = 0;
                }
                if (j == city) {
                    stringBuilder.append(graph[i][j]);
                } else {
                    stringBuilder.append(graph[i][j] + " ");
                }
            }
            System.out.println(stringBuilder);
        }
    }

}
class Bus{
    private int arrivalCity;
    private int cost;

    Bus(int arrivalCity, int cost){
        this.arrivalCity = arrivalCity;
        this.cost = cost;
    }
}
