public interface BuyableCurrency {
    /**
     * HUF-ból egy külföldi pénznembe váltó metódus.
     *
     * @param _currency   HUF értéke, amit váltani szeretnénk
     * */
    double buyCurrency(double _currency);
}