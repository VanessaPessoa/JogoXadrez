
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
    
    public void mover(Casa destino) {
        if (podeMover(destino)) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
        }
    }
   
    /*
    public boolean podeMover(Casa destino) {
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
        
        if (xDestino != xOrigem && yDestino != yOrigem) {
            for (int i = xOrigem; i < xDestino; i++) {
                for (int j = yOrigem; j < yDestino; j++) {
                    if ((tabuleiro.getCasa(i, yOrigem).possuiPeca() && tabuleiro.getCasa(i, yOrigem).getTipoPeca()%2 != casa.getTipoPeca()%2)
                        && (tabuleiro.getCasa(xOrigem, j).possuiPeca() && tabuleiro.getCasa(xOrigem, j).getTipoPeca()%2 != casa.getTipoPeca()%2)) {
                            return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    */
   
   public boolean podeMover(Casa destino){
       int xOrigem = casa.getX();
       int xDestino =  destino.getX();
       int yOrigem = casa.getY();
       int yDestino = destino.getY();
       // calcula o modulo da direção de x e y
       int x = xDestino - xOrigem;
       int moduloX = modulo(x);
       int y = yDestino - yOrigem;
       int moduloY = modulo(y);
       // se o modulo da direção de x for igual o modulo da direção de y entao o movimento é valido
       if(tipo == 6 || tipo == 7){    
           if(moduloX == moduloY){
               if((destino.possuiPeca() == false) || (capturar(destino) == true)){
                   return true;
               }
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
    

