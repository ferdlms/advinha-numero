
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Matrix {

	public String[][] matriz = {}; 
	public String[][] matrizOculta = {};
	Map<String, Double> sortedNumbers = new HashMap<String, Double>();
	int maxValue = 0;
	
	public Matrix(int dificuldade) 
	{
		Random random = new Random();
		int n = random.nextInt(2, 8);
		this.matrizOculta = matrizNumeros(n*dificuldade);
		this.matriz = matrizNumeros(n*dificuldade);
		escondeElementos();
		sortedNumbers = countNumbersFromMatrix();
	}
	
	void escondeElementos() 
	{
		
		int size = matriz.length;
		int r = 0, c = 0;
		
		while(true) 
		{
			matrizOculta[r][c++] = "*";
			if(c == size) {
				c = 0;
				r += 1;
				if(r == size)
					break;
			}
		}
	}
	
	void revelaElementos(int[] num) {
		int size = matriz.length;
		int r = 0, c = 0;
		
		while(true) 
		{
			for(int n : num) {
				Double selected = Double.valueOf(matriz[r][c]);
				if(selected.intValue() == n) {
					matrizOculta[r][c] = String.valueOf(selected.intValue());
					break;
				}
			}
			c+=1;
			if(c == size) {
				c = 0;
				r += 1;
			}
			if(r == size)
				break;
		}
	}
	

	
	public int somaDiagonalPrincipal() {
		int size = matriz.length;
		int r = 0, c = 0;
		int sum = 0;
		for(int e = 0; e < size; e++)
		{
			sum += Double.valueOf(matriz[r++][c++]).intValue();
		}
		return sum;
	}
	
	public int somaDiagonalSecundaria() 
	{
		int size = matriz.length;
		int r = size - 1, c = 0;
		int sum = 0;
		for(int e = 0; e < size; e++)
		{
			DecimalFormat df = new DecimalFormat("#.##");  
			sum += Double.valueOf(df.format(matriz[r--][c++]));
		}
		
		return sum;
	}
	
	public String printMatrix(int[][] matriz) 
	{
		int row = 0, col = 0;
		String stringrow = "";
		String allRows = "";
		while(true)
		{
			stringrow += matriz[row][col++] + " ";
			
			if(col == matriz.length) 
			{
				allRows += stringrow + '\n';
				System.out.println(stringrow);
				stringrow = "";
				if(row == matriz.length-1) 
				{
					break;
				}
				col = 0;
				row++;
			}
		}
		return allRows;
	}
	
	public void printResult(String[][] matriz) {
		int row = 0, col = 0;
		String stringrow = "";
		String stringrow2 = "";
		
		while(true)
		{
			stringrow += matriz[row][col] + " ";
			stringrow2 += this.matriz[row][col] + " ";
			col+=1;
			if(col == matriz.length) 
			{
				System.out.println(stringrow+ "     " +stringrow2);
				stringrow = "";
				stringrow2 = "";
				if(row == matriz.length-1) 
				{
					break;
				}
				col = 0;
				row++;
			}
		}
		
	}
	
	public String printMatrix(String[][] matriz) 
	{
		
		int row = 0, col = 0;
		String stringrow = "";
		String allRows = "";
		while(true)
		{
			stringrow += matriz[row][col++] + " ";
			
			if(col == matriz.length) 
			{
				allRows += stringrow + '\n';
				System.out.println(stringrow);
				stringrow = "";
				if(row == matriz.length-1) 
				{
					break;
				}
				col = 0;
				row++;
			}
		}
		return allRows;
	}
	
	
	
	public int adquirirPontos(int[] numeros) 
	{		
		int pontos = 0;
		for(int n : numeros) {
			if(sortedNumbers.containsKey(String.valueOf(n))) 
			{
				String s = String.valueOf(n);
				pontos += sortedNumbers.get(s).intValue();
			}
		}
		return pontos;
	}
	
	Map<String, Double> countNumbersFromMatrix() 
	{
		int row = 0, col = 0;
		Map<String, Double> dic = new HashMap<String, Double>();
		
		while(true) 
		{
			int element = Double.valueOf(matriz[row][col++]).intValue();
			dic.put(String.valueOf(element), 0d);
			if(col == matriz.length) 
			{
				if(row == matriz.length-1) 
				{
					break;
				}
				col = 0;
				row++;
			}
		}
		
		row = 0;
		col = 0;
		while(true)
		{
			int element = Double.valueOf(matriz[row][col++]).intValue();
			Double value = dic.get(String.valueOf(element));
			dic.put(String.valueOf(element), value + 1d);
			if(col == matriz.length) 
			{
				if(row == matriz.length-1) 
				{
					break;
				}
				col = 0;
				row++;
			}
		}
		
		return dic;
	}
	
	public String[][] matrizLetras(int size)
	{
		int[] excecao = {66, 70, 71, 72, 74, 75, 76, 81, 86, 87, 88,89, 90}; //letras utf-8
		Charset UTF8_CHARSET = Charset.forName("UTF-8");
		String[][] matriz = new String[size][size];
		int row = 0, col = 0;
		Random rand = new Random();
		Map<String, Double> dic = new HashMap<String, Double>();
		int c = 0;
		while(c != excecao.length) 
		{
			String cs = String.valueOf(excecao[c]);
			dic.put(cs, Double.valueOf(excecao[c])); 
			c+=1;
		}
		while(true)
		{
			int randomLetter = rand.nextInt(65,91);
			while(dic.containsKey(String.valueOf(randomLetter))) 
			{
				randomLetter = rand.nextInt(65,91);
			}
			matriz[row][col++] = new String(new byte[] { (byte) randomLetter }, UTF8_CHARSET);;
			if(col == size) 
			{
				if(row == size-1) 
				{
					break;
				}
				col = 0;
				row++;
			}
		}
		
		return matriz;
	}
	
	public String[][] matrizNumeros(int size)
	{
		String[][] matriz = new String[size][size];
		int row = 0, col = 0;
		Random rand = new Random();
		while(true)
		{
			int randomNumber = rand.nextInt(1,10);
			matriz[row][col++] = String.valueOf(randomNumber);
			if(col == size) 
			{
				if(row == size-1) 
				{
					break;
				}
				col = 0;
				row++;
			}
		}
		
		return matriz;
	}
}
