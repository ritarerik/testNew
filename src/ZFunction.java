public class ZFunction {

	public static int[] run(String S) {
		
		int n = S.length();
		int Z[] = new int[n];
		
		for (int i = 1, l = 0, r = 0; i < n; ++i) {
			
			// если позиция внутри отрезка совпадения, то можно использовать предыдущее значение Z[i]
			// чтобы не выходить за пределы строки: Math.min(r - i + 1, Z[i - l]) 
			if (i <= r)	Z[i] = Math.min(r - i + 1, Z[i - l]);			
			
			// Z[i] по возможности максимально увеличивается пока не достигнут 
			// конец строки, либо пока есть совпадения 
			while (i + Z[i] < n && S.charAt(Z[i]) == S.charAt(i+Z[i])) ++Z[i];
			
			// установка границ отрезка совпадения  
			if (i + Z[i] - 1 > r) {
				l = i;  
				r = i + Z[i] - 1;
			}

		}
		
		return Z;
		
	}
	
}
