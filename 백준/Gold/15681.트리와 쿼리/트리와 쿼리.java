

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static LinkedList<Integer>[] list;
    private static LinkedList<Integer>[] nodeList;
    private static int[] nodeParent;
    private static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int q = Integer.parseInt(stringTokenizer.nextToken());
        list = new LinkedList[n + 1];
        nodeList = new LinkedList[n + 1];
        nodeParent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new LinkedList<Integer>();
            nodeList[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parent = Integer.parseInt(stringTokenizer.nextToken());
            int children = Integer.parseInt(stringTokenizer.nextToken());
            list[parent].add(children);
            list[children].add(parent);
        }
        makeTree(r,-1);
        countSubTree(r);
        for (int i = 0; i < q; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int idx= Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(size[idx]);
        }

    }
    private static void makeTree(int currentNode, int parent){
        for (int node : list[currentNode]){
            if (node != parent){
                nodeList[currentNode].add(node);
                nodeParent[node] = currentNode;
                makeTree(node, currentNode);
            }
        }
    }
    private static void countSubTree(int currentNode){
        size[currentNode] = 1;
        for (int node : nodeList[currentNode]){
            countSubTree(node);
            size[currentNode] += size[node];
        }
    }

}
