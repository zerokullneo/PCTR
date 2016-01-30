public class ADN
{
	private enum basesadn{A,C,G,T};
	private enum basesarn{A,C,G,U};
	private char adn[2][];
	private char arn[];
	
	public ADN(char [2][]acido)
	{
		adn = new char(acido);
		int i, j, m, n;
		for(i=0, m=0; i < 1; i++)
			for(j=0, n=0; j < adn.length(); j++)
			switch(acido[i][j])
			{
				case 'A':
					if(acido[i+1][j] == 'T')
					{
						adn[m][n] = 'A';
						adn[m+1][n] = 'T';
						n++;
						break;
					}
					else
						break;
				case 'C':
					if(acido[i+1][j] == 'G')
					{
						adn[m][n] = 'C';
						adn[m+1][n] = 'G';
						n++;
						break;
					}
					else
						break;
				case 'G':
					if(acido[i+1][j] == 'C')
					{
						adn[m][n] = 'G';
						adn[m+1][n] = 'C';
						n++;
						break;
					}
					else
						break;
				case 'T':
					if(acido[i+1][j] == 'A')
					{
						adn[m][n] = 'T';
						adn[m+1][n] = 'A';
						n++;
						break;
					}
					else
					break;
				default:
					n++;
					break;
					
			}
	}
	
	public Ligasa(char [2][]adnA, char [2][]adnB)
	{
		
	}
	
	public Polimerasa(char []adn_simple)
	{
	
	}
	
	public Transcriptasa(String cad, int ini, int fin)
	{
	
	}
}
