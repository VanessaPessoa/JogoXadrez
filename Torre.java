import java.util.ArrayList;
/**
 * Write a description of class Torre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Torre extends Peca{
    
    private boolean primeiraJogada;
    /**
     * Constructor for objects of class Torre
     */
    public Torre(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
       super(casa, tipo, tabuleiro);
       primeiraJogada = true;
    }
    
    
    public void movimentos(int x, int y) {
        // vasculhar as casas a esquerda
        for (int i = x-1; i >= 0; i--) {
            if (tabuleiro.getCasa(i, y) != null) {
                if (tabuleiro.getCasa(i, y).possuiPeca() && capturar(tabuleiro.getCasa(i, y))) {
                    casas.add(tabuleiro.getCasa(i, y));  
                    break;
                }
                else if (tabuleiro.getCasa(i, y).possuiPeca() && capturar(tabuleiro.getCasa(i, y)) == false){
                    break;
                }
                casas.add(tabuleiro.getCasa(i, y));
            }
        }
        // vasculhar as casas a direita
        for (int i = x+1; i < 8; i++) {
            if(tabuleiro.getCasa(i, y) != null) {
                if (tabuleiro.getCasa(i, y).possuiPeca() && capturar(tabuleiro.getCasa(i, y))) {
                    casas.add(tabuleiro.getCasa(i, y));  
                    break;
                }
                else if (tabuleiro.getCasa(i, y).possuiPeca() && capturar(tabuleiro.getCasa(i, y)) == false){
                    break;
                }
                casas.add(tabuleiro.getCasa(i, y));
            }
        }
        // vasculhar as casas acima 
        for (int i = y-1; i >= 0; i--) {
            if (tabuleiro.getCasa(x, i) != null) {
                if  (tabuleiro.getCasa(x, i).possuiPeca() && capturar(tabuleiro.getCasa(x, i))) {
                    casas.add(tabuleiro.getCasa(x, i));  
                    break;
                }
                else if (tabuleiro.getCasa(x, i).possuiPeca() && capturar(tabuleiro.getCasa(x, i)) == false){
                    break;
                }
                casas.add(tabuleiro.getCasa(x, i));  
            }
        }
        // vasculhar as casas abaixo
        for (int i = y+1; i < 8; i++) {
            if (tabuleiro.getCasa(x, i) != null) {
                if (tabuleiro.getCasa(x, i).possuiPeca() && capturar(tabuleiro.getCasa(x, i))) {
                    casas.add(tabuleiro.getCasa(x, i));  
                    break;
                }
                else if (tabuleiro.getCasa(x, i).possuiPeca() && capturar(tabuleiro.getCasa(x, i)) == false){
                    break;
                }
                casas.add(tabuleiro.getCasa(x, i));
            }
        }
    }
        
    public void mover(Casa destino){      
        if (podeMover(destino)) {
            setPrimeiraJogadaTorre(false);
        }
        super.mover(destino);
    }    
}
