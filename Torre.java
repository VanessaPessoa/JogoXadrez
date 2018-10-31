import java.util.ArrayList;
/**
 * Write a description of class Torre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Torre extends Peca{
    private boolean primeiraJogadaTorre;
    
    /**
     * Constructor for objects of class Torre
     */
    public Torre(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
       super(casa, tipo, tabuleiro);
       primeiraJogadaTorre = true;
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
    
    /*
    public boolean roque(Casa destino){
        if(tipoRoque == 1){
            destino = tabuleiro.getCasa(5,0);
            return true;
        }
        else if(tipoRoque == 2){
            destino = tabuleiro.getCasa(5,7);
            return true;
        }
        else if(tipoRoque == 3){
            destino = tabuleiro.getCasa(3,0);
            return true;
        }
        else if(tipoRoque == 4){
            destino = tabuleiro.getCasa(3,7);
            return true;
        }
        return false;
    }    
    
    */
   
    public void mover(Casa destino){      
        if (podeMover(destino)) {
            primeiraJogadaTorre = false;
        }
        if(roque(destino) == true){
            roque(destino);
            casa = destino;
        }
        super.mover(destino);
        super.mover(destino);
    }
    
    public boolean primeiraJogadaTorre(){
       return primeiraJogadaTorre;
    }      
}
