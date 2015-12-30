package PrimeNumbers;

/**
 * Created by Anuradha Sanjeewa on 30/12/2015.
 */
public class PrimeSimple {
    public static void main(String[] args) {
        System.out.println(isPrime(587));
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        else if (n == 2) return true;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
