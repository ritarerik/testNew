public class ZFunction {

	public static int[] run(String S) {
		
		int n = S.length();
		int Z[] = new int[n];
		
		for (int i = 1, l = 0, r = 0; i < n; ++i) {
			
			if (i <= r)	Z[i] = Math.min(r - i + 1, Z[i - l]);			
			
			while (i + Z[i] < n && S.charAt(Z[i]) == S.charAt(i+Z[i])) ++Z[i];
			
			if (i + Z[i] - 1 > r) {
				l = i;  
				r = i + Z[i] - 1;
			}

		}
		
		return Z;
		
	}
	
}
