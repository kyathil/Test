public class Main {

    public void printNumbers(int start, int end) {
        for(int i = start; i <= end; i++) {
            System.out.print(i);
        }
    }

    public double calcTriangleArea(int[] a, int[] b, int[] c) {

        if (a.length < 1 || b.length < 1 || c.length < 1) {
            throw new IllegalArgumentException("Input must be valid vertices!");
        }
        double area = (a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])) / 2.0;
        return Math.abs(area);
    }
}
