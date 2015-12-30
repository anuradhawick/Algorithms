package PrimeNumbers;

/**
 * Created by Anuradha Sanjeewa on 30/12/2015.
 */
public class PrimeAdvanced {
    public static void main(String[] args) {
        System.out.println(isPrime(587));
    }

    public static boolean isPrime(int n) {
        if (n < 2 || n > 2 && n % 2 == 0) return false;
        if (n == 2 || n == 3) return true;
        for (int i = 3; i < (int) Math.sqrt(n) + 1; i = i + 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
