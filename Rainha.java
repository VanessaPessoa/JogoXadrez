
/**
 * Write a description of class Rainha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rainha extends Peca

{
    private Tabuleiro tabuleiro;
    
        /**
     * Constructor for objects of class Rainha
     */
    public Rainha(Casa casa, int tipo)
    {
        super(casa, tipo);
         tabuleiro = new Tabuleiro();
    }
    
    
}
