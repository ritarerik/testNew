import java.util.Vector;

// Rabin–Karp algorithm

public class RK {

	public static Vector<Integer> run(String S, String T) {
		
		Vector<Integer> res = new Vector<>();
		
		int len = T.length(); 							// длина искомой подстроки 
		
		String text = "";
		int textHash = 0; 								// хэш подстроки исходной строки
		int subHash = getHash(S, T);					// хэш искомой строки	
		
		for (int i = -1; i < S.length() - len; i++) {
			
			text = S.substring(i + 1, i + len + 1);		
			textHash = getHash(S, text);
			
			// если хеши совпали, то посимвольное сравнение строк
			if (subHash == textHash) {				
				boolean equal = true;
				if (!T.equals(text)) {
					equal = false;
					break;
				}
				// если посимвольно подстроки совпали, то добавляем позицию в массив
				if (equal) res.add(i + 1);				
			}

		}
		
		// если совпадений не найдено, то возращение позиции -1
		if (res.isEmpty()) res.add(-1);
		
		return res;
		
	}
	
	private static int getHash(String S, String sub) {
		
		int q = 65713; // простое число
		int hash = 0;		
		
		// вычисление полиномиального хеша
		for (int i = 0; i < sub.length(); i++) {			
			hash += (((int) sub.charAt(i)) * Math.pow(2, sub.length() - i - 1)) % q;			
		}
		
		return hash;
		
	}
	
}
