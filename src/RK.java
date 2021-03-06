import java.util.ArrayList;

public class RK {
	public static ArrayList<Integer> run(String S, String T) {		
		ArrayList<Integer> res = new ArrayList<>();		
		int len = T.length();		
		String text = "";
		int textHash = 0; 
		int subHash = getHash(S, T);			
		for (int i = -1; i < S.length() - len; i++) {			
			text = S.substring(i + 1, i + len + 1);		
			textHash = getHash(S, text);			
			if (subHash == textHash) {				
				boolean equal = true;
				if (!T.equals(text)) {
					equal = false;
					break;
				}
				if (equal) res.add(i + 1);				
			}
		}		
		if (res.isEmpty()) res.add(-1);	
		System.gc();
		return res;		
	}	
	private static int getHash(String S, String sub) {		
		int q = 65713; 
		int hash = 0;			
		for (int i = 0; i < sub.length(); i++) {			
			hash += (((int) sub.charAt(i)) * Math.pow(2, sub.length() - i - 1)) % q;			
		}	
		System.gc();
		return hash;		
	}	
}
