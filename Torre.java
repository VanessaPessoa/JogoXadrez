
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
    
    public void mover(Casa destino){      
        if(podeMover(destino)){
            destino.colocarPeca(this);
            casa.removerPeca();
            casa=destino; 
        }
    }
    
    public Boolean podeMover(Casa destino) {
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
        
        if ((xDestino == yOrigem && yDestino != yOrigem) || (xDestino != xOrigem && yDestino == yOrigem)) {
            return true;
        }
        return false;
    }
}
