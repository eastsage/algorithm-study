package algorithm.sortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ComparableAndComparator {
    public static List<Point> solution(List<Point> list) {
        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getX() == o2.getX()) {
                    return o1.getY() - o2.getY();
                } else {
                    return o1.getX() - o2.getX();
                }
            }
        };
        Collections.sort(list, comparator);

        return list;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        for (Point point : solution(list)) {
            System.out.println(point.toString());
        }
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
