package dp;

public class unique_path_62 {
	public static void main(String[] args){
		System.out.println(new unique_path_62().uniquePaths(7,3));
	}

	public int uniquePaths(int m, int n) {
		int[] dp = new int[m];
		for(int i = 0 ; i < m ; i++){
			dp[i] = 0;
		}
		dp[0] = 1;

		for(int j = 0 ; j < n ; j++) {
			for (int i = 1; i < m; i++) {
				dp[i] = dp[i] + dp[i-1];
			}
		}
		return dp[m-1];
	}
}
