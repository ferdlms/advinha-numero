
public class Jogador {
	String name;
	int score;
	int games;
	
	public Jogador(String name, int score, int games)
	{
		this.name = name;
		this.score = score;
		this.games = games;
	}
	
	public void addScore(int scr) 
	{
		this.score += scr;
	}
	
	public void addGame()
	{
		this.games += 1;
	}
	
	public String ToString() 
	{
		return "Player: " + this.name + "\nScore: " + this.score + "\nGames played: " + this.games;
	}
}
