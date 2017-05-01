package pl.motyka.mateusz.klaser;

public class PokemonAlreadyExistsException extends Exception {
	private static final long serialVersionUID = -4576295597218170159L;

	public PokemonAlreadyExistsException() {
	}

	public PokemonAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PokemonAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public PokemonAlreadyExistsException(String message) {
		super(message);
	}

	public PokemonAlreadyExistsException(Throwable cause) {
		super(cause);

	}

}
