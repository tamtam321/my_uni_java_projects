public interface SellableCurrency {
    /**
     * Ezzel tudjuk az adott pénznemet HUF-ba váltani.
     *
     * @param _currency     Pénznem értéke, amit átváltunk HUF-ba.
     * */
    double sellCurrency(double _currency);
}