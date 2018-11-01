import java.util.ArrayList;

/**
 * Write a description of class Rei here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rei extends Peca
{
    private boolean primeiraJogadaRei;
    
    public Rei(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
       super(casa, tipo, tabuleiro);
       primeiraJogadaRei = true;
    }
      
    public void movimentos(int x, int y) {
        if(tabuleiro.getCasa(x+1, y) != null && (tabuleiro.getCasa(x+1, y).possuiPeca() == false || capturar(tabuleiro.getCasa(x+1, y)))) {
            casas.add(tabuleiro.getCasa(x+1, y));
        }
        if(tabuleiro.getCasa(x-1, y) != null && (tabuleiro.getCasa(x-1, y).possuiPeca() == false || capturar(tabuleiro.getCasa(x-1, y)))) {
            casas.add(tabuleiro.getCasa(x-1, y));
        }
        if(tabuleiro.getCasa(x, y+1) != null && (tabuleiro.getCasa(x, y+1).possuiPeca() == false || capturar(tabuleiro.getCasa(x, y+1)))) {
            casas.add(tabuleiro.getCasa(x, y+1));
        }
        if(tabuleiro.getCasa(x, y-1) != null && (tabuleiro.getCasa(x, y-1).possuiPeca() == false || capturar(tabuleiro.getCasa(x, y-1)))) {
            casas.add(tabuleiro.getCasa(x, y-1));
        }
        if(tabuleiro.getCasa(x+1, y+1) != null && (tabuleiro.getCasa(x+1, y+1).possuiPeca() == false || capturar(tabuleiro.getCasa(x+1, y+1)))) {
            casas.add(tabuleiro.getCasa(x+1, y+1));
        }
        if(tabuleiro.getCasa(x+1, y-1) != null && (tabuleiro.getCasa(x+1, y-1).possuiPeca() == false || capturar(tabuleiro.getCasa(x+1, y-1)))) {
            casas.add(tabuleiro.getCasa(x+1, y-1));
        }
        if(tabuleiro.getCasa(x-1, y+1) != null && (tabuleiro.getCasa(x-1, y+1).possuiPeca() == false || capturar(tabuleiro.getCasa(x-1, y+1)))) {
            casas.add(tabuleiro.getCasa(x-1, y+1));
        }
        if(tabuleiro.getCasa(x-1, y-1) != null && (tabuleiro.getCasa(x-1, y-1).possuiPeca() == false || capturar(tabuleiro.getCasa(x-1, y-1)))) {
            casas.add(tabuleiro.getCasa(x-1, y-1));
        }
    }
    
    public void mover(Casa destino) {
        if (primeiraJogadaRei && podeMover(destino)) {
            primeiraJogadaRei = false;
        }
        
        if (roque(destino)){
            roque(destino);
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
        }   
        
        super.mover(destino);
     }
    
    public boolean primeiraJogadaRei(){
        return primeiraJogadaRei;
    }
    
    public boolean roque(Casa destino){
       int xOrigem = casa.getX();
       int xDestino = destino.getX();
       int yOrigem = casa.getY();
       int yDestino = destino.getY();
       
       // roque pequeno
       if(primeiraJogadaRei){
            // roque pequeno
             if(xOrigem+2 == xDestino && yOrigem == yDestino){
              //peças brancas
               if(tipo == 10 && tabuleiro.getCasa(5,0).possuiPeca() == false && tabuleiro.getCasa(6,0).possuiPeca() == false &&
               tabuleiro.getCasa(7,0). getTipoPeca() == 2){
                       Peca peca = tabuleiro.getCasa(7,0).getPeca();
                       if(peca.getPrimeiraJogadaTorre()){
                           tabuleiro.getCasa(7,0).removerPeca();
                           Casa destinoT = tabuleiro.getCasa(5,0);
                           Peca torre = new Torre(destinoT, 2, tabuleiro);
                           return true;
                      }                      
              }
              //pecas pretas
              if(tipo == 11 && tabuleiro.getCasa(5,7).possuiPeca() == false && tabuleiro.getCasa(6,7).possuiPeca() == false &&
               tabuleiro.getCasa(7,7). getTipoPeca() == 3){
                      Peca peca = tabuleiro.getCasa(7,7).getPeca();
                      if(peca.getPrimeiraJogadaTorre()){
                          tabuleiro.getCasa(7,7).removerPeca();
                           Casa destinoT = tabuleiro.getCasa(5,7);
                           Peca torre = new Torre(destinoT, 3, tabuleiro);  
                           return true;
                        }
              }
          }
          //roque grande
          if(xOrigem-2 == xDestino && yOrigem == yDestino){
               //pecas brancas
               if((tipo == 10) && tabuleiro.getCasa(3,0).possuiPeca() == false && tabuleiro.getCasa(2,0).possuiPeca() == false
                 && tabuleiro.getCasa(1,0).possuiPeca() == false && tabuleiro.getCasa(0,0). getTipoPeca() == 2 ){
                   Peca peca = tabuleiro.getCasa(0,0).getPeca();
                   if(peca.getPrimeiraJogadaTorre()){
                       tabuleiro.getCasa(0,0).removerPeca();
                       Casa destinoT = tabuleiro.getCasa(3,0);
                       Peca torre = new Torre(destinoT, 2, tabuleiro);
                       return true;
                    }
                 }
               //pecas pretas
               if((tipo ==11) && tabuleiro.getCasa(3,7).possuiPeca() == false && tabuleiro.getCasa(2,7).possuiPeca() == false
                 && tabuleiro.getCasa(1,7).possuiPeca() == false && tabuleiro.getCasa(0,7). getTipoPeca() == 3){
                   Peca peca = tabuleiro.getCasa(0,7).getPeca();
                   if(peca.getPrimeiraJogadaTorre()){
                       tabuleiro.getCasa(0,7).removerPeca();
                       Casa destinoT = tabuleiro.getCasa(3,7);
                       Peca torre = new Torre(destinoT, 3, tabuleiro);
                       return true;
                }
               }  
          }
      }
      return false;
    }
   
}
    
