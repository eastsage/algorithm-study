import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] nums;
	static int[][] countOfPrimes;
	static final int MAX_NUM = 1_000;
	static List<Integer> primes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		sieveOfEratosthenes();

		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			if (isPrime(nums[i]) && !primes.contains(nums[i])) {
				primes.add(nums[i]);
			}
		}
		countOfPrimes = new int[primes.size()][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < primes.size(); j++) {
				if (nums[i] == 1)
					break;
				nums[i] = divideWithPrime(i, j);
			}
		}

		int ans = 1;
		int moveCount = 0;
		for (int i = 0; i < primes.size(); i++) {
			int countOfPrime = getCountOfPrime(i);

			if (countOfPrime / N == 0)
				continue;
			moveCount += getMovementCount(i, countOfPrime / N);
			ans *= Math.pow(primes.get(i), countOfPrime / N);
		}

		System.out.println(ans + " " + moveCount);
	}

	private static int getMovementCount(int primeIdx, int sameCount) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (countOfPrimes[primeIdx][i] < sameCount) {
				count += sameCount - countOfPrimes[primeIdx][i];
			}
		}
		return count;
	}

	private static int getCountOfPrime(int primeIdx) {
		int count = 0;

		for (int i = 0; i < N; i++) {
			count += countOfPrimes[primeIdx][i];
		}
		return count;
	}

	private static int divideWithPrime(int numIdx, int primeIdx) {
		int num = nums[numIdx];
		int prime = primes.get(primeIdx);
		while (num % prime == 0) {
			num /= prime;
			countOfPrimes[primeIdx][numIdx]++;
		}
		return num;
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private static void sieveOfEratosthenes() {
		boolean[] check = new boolean[MAX_NUM];
		for (int i = 2; i < MAX_NUM; i++) {
			if (check[i])
				continue;
			primes.add(i);
			for (int j = i * i; j < MAX_NUM; j += i) {
				check[j] = true;
			}
		}
	}
}