import java.util.Scanner;
import java.util.ArrayList;

public class MainClass {
	
	
	public static void main(String args[])
	{
		
		boolean exit = false;		
		while (!exit) {
			
			System.out.println("> Z-функция > 1");
			System.out.println("> Алгоритм Кнута — Морриса — Пратта > 2");
			System.out.println("> Алгоритм Рабина — Карпа > 3");
			System.out.println("> ______________________________________");
			System.out.println("> Выход > 4");
			
			//-----------------------------------------------------------//
			Scanner in = new Scanner(System.in);			
			System.out.print("\n>> ");
			
			//-----------------------------------------------------------//
	        
			int num = 0;
			String res = "";
			try {
				num = in.nextInt();		        
	        } catch (Exception e) {
	        	continue;
	        }
			
	        //-----------------------------------------------------------//
			System.out.print("\n>> Строка > ");
			in = new Scanner(System.in);
	        String S = in.nextLine().toLowerCase();
	        String T = "";
	        ArrayList<Integer> V = new ArrayList<>();
	        
	        //-----------------------------------------------------------//
	        switch(num) {     
	        	case 1:
		        	
		        	int[] Z =  ZFunction.run(S);
		        				        
		        	res += "[";
			        for (int i = 0; i < Z.length; i++) {			        	
			        	res += Z[i];			        			
			        	if (i < Z.length - 1) res += ", "; 
			        }
			        res += "]\n\n";
		        	
		        	break;
		        	
		        //-----------------------------------------------------------//	
		        case 2:
		        	
		        	in = new Scanner(System.in);				
					System.out.print("\n>> Подстрока > ");				
			        T = in.nextLine().toLowerCase();
			        
			        if (S.contains("¶")) {
			        	System.out.println(">> Строка содержит запрещённый символ ¶");
			        } else if (T.contains("¶")) {
			        	System.out.println(">> Подстрока содержит запрещённый символ ¶");
			        } else {
				        V = new ArrayList<>();
				        V = KMP.run(S, T);
				        res += "[";
				        for (int i = 0; i < V.size(); i++) {
				        	if (V.get(i) != -1) {			        	
					        	res += V.get(i);			        			
					        	if (i < V.size() - 1) res += ", "; 
				        	} else res += " совпадений не найдено ";
				        }				        
				        res += "]\n\n";				        
			        }
			        System.gc();
		        	break;
		        	
		       	//-----------------------------------------------------------//	
		        case 3:
		        	
		        	in = new Scanner(System.in);				
					System.out.print("\n>> Подстрока > ");				
			        T = in.nextLine().toLowerCase();
		        	
		        	V = new ArrayList<>();
			        V = RK.run(S, T);
			        res += "[";
			        for (int i = 0; i < V.size(); i++) {
			        	if (V.get(i) != -1) {			        	
				        	res += V.get(i);			        			
				        	if (i < V.size() - 1) res += ", "; 
			        	} else res += " совпадений не найдено ";
			        }
			        
			        res += "]\n\n";
			        System.gc();
		        	break;
		        	
		        default:
		        	exit = true;
		        	break;
	        	
	        }
	        
	        //-----------------------------------------------------------//
        	System.out.print("\n> Результат > ");
	        System.out.println(res);
	        System.gc();
		}
		
		
		
	}
	
}
