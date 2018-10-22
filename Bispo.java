
/**
 * Write a description of class Bispo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bispo extends Peca
{
    private Tabuleiro tabuleiro;
    /**
     * Constructor for objects of class Bispo
     */
    public Bispo(Casa casa, int tipo)
    {
        super(casa, tipo);
         tabuleiro = new Tabuleiro();
    }
    
    
}
