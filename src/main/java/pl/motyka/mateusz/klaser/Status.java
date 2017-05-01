package pl.motyka.mateusz.klaser;

public enum Status {
    
	NEW("Nowa"),
    TO_SELL("Do sprzedania"),
    DUPLICATE("Duplikat");

    public static final Status[] ALL = { NEW, TO_SELL, DUPLICATE };

    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
