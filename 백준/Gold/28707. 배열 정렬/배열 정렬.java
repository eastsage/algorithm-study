import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[][] operations;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        operations = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            operations[i][0] = Integer.parseInt(st.nextToken()) - 1;
            operations[i][1] = Integer.parseInt(st.nextToken()) - 1;
            operations[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = dijkstra();
        System.out.println(result);
    }

    public static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        Map<String, Integer> minCost = new HashMap<>();

        String start = Arrays.toString(arr);
        pq.add(new Node(arr, 0));
        minCost.put(start, 0);

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int[] currentArray = current.array;
            int currentCost = current.cost;

            // Check if the current array is sorted
            if (isSorted(currentArray)) {
                return currentCost;
            }

            // Explore all operations
            for (int[] op : operations) {
                int l = op[0];
                int r = op[1];
                int cost = op[2];

                int[] newArray = currentArray.clone();
                swap(newArray, l, r);

                String newArrayStr = Arrays.toString(newArray);
                int newCost = currentCost + cost;

                if (!minCost.containsKey(newArrayStr) || newCost < minCost.get(newArrayStr)) {
                    minCost.put(newArrayStr, newCost);
                    pq.add(new Node(newArray, newCost));
                }
            }
        }

        return -1; // If we exhaust the queue without finding a sorted array
    }

    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static class Node {
        int[] array;
        int cost;

        Node(int[] array, int cost) {
            this.array = array;
            this.cost = cost;
        }
    }
}