package pl.motyka.mateusz.klaser;

public class NoSuchPokemonException extends Exception {
	private static final long serialVersionUID = -8555511053844242536L;

	public NoSuchPokemonException(String string) {
		super(string);
	}

	public NoSuchPokemonException() {
	}

}
