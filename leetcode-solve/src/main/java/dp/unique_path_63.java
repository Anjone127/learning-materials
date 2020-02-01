package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class unique_path_63 {
	public static void main(String[] args){
		int[][] a = {{0,1,0,0},{0,0,0,0},{0,0,0,0}};
		System.out.println(
				new unique_path_63().uniquePathsWithObstacles(a));
	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length;
		if(n==0){return 0;}
		int m = obstacleGrid[0].length;
		if(m==0){return 0;}

		if(n > m) {
			//init
			int[] dp = new int[m];
			for (int j = 0; j < m; j++) {
				dp[j] = 0;
			}
			dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

			for (int i = 0; i < n; i++) {
				dp[0] = obstacleGrid[i][0] == 1 ? 0 : dp[0];
				for (int j = 1; j < m; j++) {
					dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j] + dp[j - 1];
				}
			}
			return dp[m - 1];
		}

		//init
		int[] dp = new int[n];
		for (int j = 0; j < n; j++) {
			dp[j] = 0;
		}
		dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

		for (int i = 0; i < m; i++) {
			dp[0] = obstacleGrid[0][i] == 1 ? 0 : dp[0];
			for (int j = 1; j < n; j++) {
				dp[j] = obstacleGrid[j][i] == 1 ? 0 : dp[j] + dp[j - 1];
			}
		}
		return dp[n - 1];
	}
}
