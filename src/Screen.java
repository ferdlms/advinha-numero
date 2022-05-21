import java.io.IOException;
import java.util.Scanner;

public class Screen {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void StaticText(Jogador jogador) {
		System.out.println("******************************************************************************************************************************************");
		System.out.println("******************************************************************************************************************************************");
		System.out.println("******************************************************************************************************************************************");
		System.out.println("******************************************************************************************************************************************");
		System.out.println("******************************************************************************************************************************************");
		System.out.println("********************  *********  ****         *****  ***********        ****           ****     *****    ****         ********************");
		System.out.println("********************  ***   ***  ****  ************  ***********  **********  *******  ****   *  ***  *  ****  ***************************");
		System.out.println("********************  **  *  **  ****       *******  ***********  **********  *******  ****   **  *  **  ****       **********************");
		System.out.println("********************  *  ***  *  ****  ************  ***********  **********  *******  ****   ***   ***  ****  ***************************");
		System.out.println("********************    *****    ****         *****         ****        ****           ****   *********  ****         ********************");
		System.out.println("******************************************************************************************************************************************");
		System.out.println("******************************************************************************************************************************************");
		System.out.println("******************************************************************************************************************************************");
		System.out.println("******************************************************************************************************************************************");
		System.out.println("******************************************************************************************************************************************");
		System.out.println(jogador.ToString());
	}
	
	static void Clear() {
		try {
			if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
		} catch (Exception e) {
			
		}
	}
	
	public static void EndGame(int score, int total) {
		System.out.println("You make " + score + " points! Total score: "+ total + "\n       Press enter to restart..");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int ChooseNumber() {
		System.out.println("Choose a number (1 to 9: ");
		String text = sc.next();
		if(numberIsValid(text)) {
			int result = Double.valueOf(text).intValue();
			if(result >= 1 && result <= 9) {
				return Double.valueOf(text).intValue();
			}
		}
		return 0;
	}
	
	public static int[] ChooseNumbers(int qtd) 
	{		
		int[] numerosChutados = {0, 0, 0};
		int number = 0;
		while(qtd>=0) {
			number = ChooseNumber();
			if(number != 0)
				numerosChutados[qtd--] = number;   
		}
		return numerosChutados;
	}
	
	static boolean numberIsValid(String number) 
	{
		try {
			Double n = Double.valueOf(number);
			Integer i = Integer.valueOf(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String ReadPlayerName() {
		System.out.println("Player name: ");
		String res = sc.next();
		while(res.trim() == "") {
			Clear();
			System.out.println("Player name: ");
			res = sc.next();
		}
		return res;
	}

	public static Double ReadDifficulty() {
		System.out.println("\n3 - Easy\n2 - Medium\n1 - Hard");
		String text = sc.next();	
		try {
			Double diff = Double.valueOf(text);			
			if(diff.intValue() > 3 || diff.intValue() < 1) {
				Clear();
				return ReadDifficulty();
			}
		} catch (Exception e) {
			Clear();
			return ReadDifficulty();
		}
			
		return Double.valueOf(text);
	}
	
	public static int ReadANumber() {
		System.out.println("Choose a number: ");
		Double res = sc.nextDouble();
		return res.intValue();
	}
}
