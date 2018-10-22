
/**
 * Write a description of class Torre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Torre extends Peca
{
    private Tabuleiro tabuleiro;

    /**
     * Constructor for objects of class Torre
     */
    public Torre(Casa casa, int tipo)
    {
       super(casa, tipo); 
       tabuleiro = new Tabuleiro();
    }
    
    
}
