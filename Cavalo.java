import java.util.ArrayList;
/**
 * Write a description of class Cavalo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cavalo extends Peca
{
    
    /**
     * Constructor for objects of class Cavalo
     */
    public Cavalo(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
      super(casa, tipo, tabuleiro);
    }
    
    public void movimentos(int x, int y) {
        if (tabuleiro.getCasa(x+2, y+1) != null && (tabuleiro.getCasa(x+2, y+1).possuiPeca() == false ||
                capturar(tabuleiro.getCasa(x+2, y+1)))) {
            casas.add(tabuleiro.getCasa(x+2, y+1));
        }
        if (tabuleiro.getCasa(x+2, y-1) != null && (tabuleiro.getCasa(x+2, y-1).possuiPeca() == false || 
                capturar(tabuleiro.getCasa(x+2, y-1)))) {
            casas.add(tabuleiro.getCasa(x+2, y-1));
        }
        if (tabuleiro.getCasa(x-2, y+1) != null && (tabuleiro.getCasa(x-2, y+1).possuiPeca() == false || 
                capturar(tabuleiro.getCasa(x-2, y+1)))) {
            casas.add(tabuleiro.getCasa(x-2, y+1));
        }
        if (tabuleiro.getCasa(x-2, y-1) != null && (tabuleiro.getCasa(x-2, y-1).possuiPeca() == false || 
                capturar(tabuleiro.getCasa(x-2, y-1)))) {
            casas.add(tabuleiro.getCasa(x-2, y-1));
        }
        if (tabuleiro.getCasa(x+1, y+2) != null && (tabuleiro.getCasa(x+1, y+2).possuiPeca() == false ||
                capturar(tabuleiro.getCasa(x+1, y+2)))) {
            casas.add(tabuleiro.getCasa(x+1, y+2));
        }
        if (tabuleiro.getCasa(x-1, y+2) != null && (tabuleiro.getCasa(x-1, y+2).possuiPeca() == false ||
                capturar(tabuleiro.getCasa(x-1, y+2)))) {
            casas.add(tabuleiro.getCasa(x-1, y+2));
        }
        if (tabuleiro.getCasa(x+1, y-2) != null && (tabuleiro.getCasa(x+1, y-2).possuiPeca() == false ||
                capturar(tabuleiro.getCasa(x+1, y-2)))) {
            casas.add(tabuleiro.getCasa(x+1, y-2));
        }
        if (tabuleiro.getCasa(x-1, y-2) != null && (tabuleiro.getCasa(x-1, y-2).possuiPeca() == false ||
                capturar(tabuleiro.getCasa(x-1, y-2)))) {
            casas.add(tabuleiro.getCasa(x-1, y-2));
        }
    }
    
    public void mover(Casa destino) {
        super.mover(destino);
    }
    
}
