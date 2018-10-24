
/**
 * Write a description of class Rainha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
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
    
    public void mover(Casa destino){

        if (podeMover(destino)){
            destino.colocarPeca(this);
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
        }
         
    }
     /*
    public boolean podeMover(Casa destino){
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
        
        if ((tipo == 8 || tipo == 9) && (destino.possuiPeca() == false || capturar(destino))) {
            // determina yOrigem como menor valor e yDestino com o maior valor
            // ajuda a percorrer o for do menor para o maior
            if (xOrigem > xDestino) {
                int valorMaior = xOrigem;
                xOrigem = xDestino;
                xDestino = valorMaior;
            }
            
            if (yOrigem > yDestino) {
                int valorMaior = yOrigem;
                yOrigem = yDestino;
                yDestino = valorMaior;
            }
            // movimento horizontal 
            if (xDestino == xOrigem){
                // determina yOrigem como menor valor e yDestino com o maior valor
                // ajuda a percorrer o for do menor para o maior
                
                // vasculhar as casas até o yDestino verificando se tem peca adversaria, se tiver, nao pode mover
                for (int i = yOrigem; i < yDestino; i++) {
                    if (tabuleiro.getCasa(xOrigem, i).possuiPeca() && tabuleiro.getCasa(xOrigem, i).getTipoPeca()%2 != casa.getTipoPeca()%2) {
                            return false;
                    }
                }
            }
            // movimento vertical
            else if (yDestino == yOrigem) {
                // vasculhar as casas até o xDestino verificando se tem peca adversaria, se tiver, nao pode mover
                for (int i = xOrigem; i < xDestino; i++) {
                    if (tabuleiro.getCasa(i, yOrigem).possuiPeca() && tabuleiro.getCasa(i, yOrigem).getTipoPeca()%2 != casa.getTipoPeca()%2) {
                            return false;
                    }
                }
            }
            // movimento diagonal
            else {                
                for (int i = xOrigem; i < xDestino; i++) {
                    for (int j = yOrigem; j < yDestino; j++) {
                        if ((tabuleiro.getCasa(i, yOrigem).possuiPeca() && tabuleiro.getCasa(i, yOrigem).getTipoPeca()%2 != casa.getTipoPeca()%2)
                             && (tabuleiro.getCasa(xOrigem, j).possuiPeca() && tabuleiro.getCasa(xOrigem, j).getTipoPeca()%2 != casa.getTipoPeca()%2)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }
     */
   
    public boolean podeMover(Casa destino){
       int xOrigem = casa.getX();
       int yOrigem = casa.getY();
       int xDestino = destino.getY();
       int yDestino = destino.getY();
       //verifica se esta andando na horizontal e vertical
       //ou se o movimento é na diagonal
       int x = xDestino - xOrigem;
       int moduloX = modulo(x);
       int y = yDestino - yOrigem;
       int moduloY = modulo(y);
       
       if((moduloX == moduloY) || ((xOrigem == xDestino && yOrigem != yDestino)|| (xOrigem != xDestino && yOrigem == yDestino))){
           if((destino.possuiPeca() == false) || (capturar(destino) == true)){
               return true;
           }
       }
       return false;
    }
    
    public int modulo(int i){
        if(i <0){
            return -i;
        }
        return i;
    }
}
