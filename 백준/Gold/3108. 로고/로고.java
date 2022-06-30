import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main{
	static class TestRectangulars{
		private Point x1;
		private Point x2;
		public TestRectangulars(Point x1, Point x2) {
			this.x1 = x1;
			this.x2 = x2;
		}
		public Point getPoint1() {
			return x1;
		}
		public Point getPoint2() {
			return x2;
		}
	}
	static TestRectangulars[] tests;
    static int N;
    static int curX = 0, curY = 0, PU_CNT = 0;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		tests = new TestRectangulars[N];
		parent = new int[N];
		Arrays.fill(parent, -1);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			tests[i] = new TestRectangulars(new Point(x1,x2), new Point(x3,x4));
		}
		solution();
		System.out.println(PU_CNT);
    }
    static void solution() {
    	for (int i = 0; i < N - 1; i++) {
    		for (int j = i + 1; j < N; j++) {
    			if (isRectangularAboveRectangular(tests[i].getPoint1(), tests[i].getPoint2()
    					, tests[j].getPoint1(), tests[j].getPoint2())) {
    				int a = findParent(i);
    				int b = findParent(j);
    				if (a > b) {
    					parent[b] = a;
    				}else if (a < b) {
    					parent[a] = b;
    				}
    			}
    		}
    	}
    	boolean flag = false;
    	for (int i = 0; i < N; i++) {
    		if (parent[i] < 0) {
    			PU_CNT++;
    		}
    		if (isPointAboveRectangular(0,0,tests[i].getPoint1(), tests[i].getPoint2())) {
    			flag = true;
    		}
    	}
    	if (flag)
    		PU_CNT--;
    }
    
    static boolean isPointAboveRectangular(int x, int y, Point x1, Point x2) {
    	if ((y == x1.y || y == x2.y) && (x >= x1.x && x <= x2.x)) {
    		return true;
    	}else if ((x == x1.x || x == x2.x) && (y >= x1.y && y <=x2.y)) {
    		return true;
    	}
    	return false;
    }
    
    static int findParent(int x) {
    	if (parent[x] < 0) {
    		return x;
    	}
    	return parent[x] = findParent(parent[x]);
    }
    
    static boolean isRectangularAboveRectangular(Point x1, Point x2, Point x3, Point x4) {
    	if ((x2.x < x3.x) || (x4.x < x1.x)) {
    		return false;
    	}
    	if ((x2.y < x3.y) || (x1.y > x4.y)) {
    		return false;
    	}
    	if ((x1.x > x3.x) && (x2.x < x4.x) && (x1.y > x3.y) && (x4.y > x2.y)) return false;
    	if ((x3.x > x1.x) && (x4.x < x2.x) && (x3.y > x1.y) && (x2.y > x4.y)) return false;
    	return true;
    }
}