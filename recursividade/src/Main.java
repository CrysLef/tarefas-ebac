public class Main {

    // 1 * 2 * 3 = 3!
    private final static long[] array_fatorial = new long[150];
    
    public static long calculaFatorial(int n) {
        if (n <= 1) return 1;
        return n * calculaFatorial(n - 1);
    }
    
    public static long calculaFatorialPD(int n) {
        if (array_fatorial[n] == 0) {
            if (n <= 1) return 1;
            array_fatorial[n] = calculaFatorialPD(n - 1) * n;
        }

        return array_fatorial[n];
    }
    

    public static void main(String[] args) {
        System.out.println(calculaFatorialPD(20));
    }
}