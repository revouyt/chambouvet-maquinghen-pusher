
/**
 * @author chamboug
 * Classe application du projet
 */
public class LanceurDePartiedePusher {

	public static void main(String[] args) {

		Map map = new Map();
		new PartieDePusher(map).jouer();
	}

}