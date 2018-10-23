
/**
 * Write a description of class Cavalo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cavalo extends Peca
{
    private Tabuleiro tabuleiro;
    
    /**
     * Constructor for objects of class Cavalo
     */
    public Cavalo(Casa casa, int tipo)
    {
      super(casa, tipo);
      tabuleiro = new Tabuleiro();
    }
    
    public void mover(Casa destino) {
        //movimentação dos cavalos brancos e pretos        
        if(podeMover(destino)){
            destino.colocarPeca(this);
            casa.removerPeca();
            casa=destino; 
        }
    }
     
    public Boolean podeMover(Casa destino) {
        
        // dentro do if vai verificar se o destino possui peca e se possuir o movimento so sera valido se o tipo for diferente do tipo da casa
        if (((tipo ==4 || tipo ==5)  && (destino.possuiPeca()==false ||  capturar(destino)==true)) &&
            ((casa.getX()+2 == destino.getX() || casa.getX()-2==destino.getX()) &&
                (casa.getY()+1== destino.getY() || casa.getY()-1== destino.getY()))){
                return true;
                
        } else if (((tipo ==4 || tipo ==5) && (destino.possuiPeca()==false ||  capturar(destino)==true)) &&
           ((casa.getX()+1 == destino.getX() || casa.getX()-1==destino.getX()) && 
                (casa.getY()+2== destino.getY() || casa.getY()-2== destino.getY()))){
                return true;
        }
        
        return false;    
    }
}
