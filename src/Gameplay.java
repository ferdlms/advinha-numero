import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Gameplay {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		while(true) 
		{
			Screen.Clear();
			String name = Screen.ReadPlayerName();
			Jogador player = new Jogador(name, 0, 0);
			while(true) {
				Double dificuldade = Screen.ReadDifficulty();
				Screen.Clear();
				Screen.StaticText(player);
				Matrix matrix = new Matrix(dificuldade.intValue());
				matrix.escondeElementos();
				matrix.printMatrix(matrix.matrizOculta);
				int[] numerosChutados = Screen.ChooseNumbers(dificuldade.intValue()-1);
				while (numerosChutados == null) {
					numerosChutados = Screen.ChooseNumbers(dificuldade.intValue()-1);
				}
				int pontos = matrix.adquirirPontos(numerosChutados);
				player.addGame();
				player.addScore(pontos);
				matrix.revelaElementos(numerosChutados);
				matrix.printResult(matrix.matrizOculta);
				Screen.EndGame(pontos, player.score);
				Screen.Clear();
			}
		}
	}
}
