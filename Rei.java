import javax.swing.JOptionPane;
import javax.swing.*;
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
        super.mover(destino);  
        if(roque(destino) == true){
            roque(destino);
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
        }
        proximoMovimento();
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
       if(primeiraJogadaRei == true){
            // roque pequeno
             if(xOrigem+2 == xDestino && yOrigem == yDestino){
              //peças brancas
               if(tipo == 10 && tabuleiro.getCasa(5,0).possuiPeca() == false && tabuleiro.getCasa(6,0).possuiPeca() == false &&
               tabuleiro.getCasa(7,0). getTipoPeca() == 2){
                   tabuleiro.getCasa(7,0).removerPeca();
                   Casa destinoT = tabuleiro.getCasa(5,0);
                   Peca torre = new Torre(destinoT, 2, tabuleiro);
                   return true;  
              }
              //pecas pretas
              else if(tipo == 11 && tabuleiro.getCasa(5,7).possuiPeca() == false && tabuleiro.getCasa(6,7).possuiPeca() == false &&
               tabuleiro.getCasa(7,7). getTipoPeca() == 3){
                   tabuleiro.getCasa(7,7).removerPeca();
                   Casa destinoT = tabuleiro.getCasa(5,7);
                   Peca torre = new Torre(destinoT, 3, tabuleiro);
                   return true;            
            }
          }
          //roque grande
           else if(xOrigem-2 == xDestino && yOrigem == yDestino){
                 if((tipo == 10) && tabuleiro.getCasa(3,0).possuiPeca() == false && tabuleiro.getCasa(2,0).possuiPeca() == false
                 && tabuleiro.getCasa(1,0).possuiPeca() == false && tabuleiro.getCasa(0,0). getTipoPeca() == 2 ){
                   tabuleiro.getCasa(0,0).removerPeca();
                   Casa destinoT = tabuleiro.getCasa(3,0);
                   Peca torre = new Torre(destinoT, 2, tabuleiro);
                   return true;
                 }
                 else if((tipo ==11) && tabuleiro.getCasa(3,7).possuiPeca() == false && tabuleiro.getCasa(2,7).possuiPeca() == false
                 && tabuleiro.getCasa(1,7).possuiPeca() == false && tabuleiro.getCasa(0,7). getTipoPeca() == 3){
                   tabuleiro.getCasa(0,7).removerPeca();
                   Casa destinoT = tabuleiro.getCasa(3,7);
                   Peca torre = new Torre(destinoT, 3, tabuleiro);
                   return true;
                }  
          }
       }
       
       return false;
    }
    
    public void proximoMovimento(){
        int x = casa.getX();
        int y = casa.getY();
        if(tipo == 10){
                 if(tabuleiro.getCasa(x+1, y) != null && (tabuleiro.getCasa(x+1, y).possuiPeca())
                && (tabuleiro.getCasa(x+1, y).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x-1, y) != null && (tabuleiro.getCasa(x-1, y).possuiPeca())
                && (tabuleiro.getCasa(x-1, y).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x, y+1) != null && (tabuleiro.getCasa(x, y+1).possuiPeca())
                && (tabuleiro.getCasa(x, y+1).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x, y-1) != null && (tabuleiro.getCasa(x, y-1).possuiPeca())
                &&(tabuleiro.getCasa(x, y-1).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x+1, y+1) != null && (tabuleiro.getCasa(x+1, y+1).possuiPeca())
                && (tabuleiro.getCasa(x+1, y+1).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x+1, y-1) != null &&(tabuleiro.getCasa(x+1, y-1).possuiPeca())
                && (tabuleiro.getCasa(x+1, y-1).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x-1, y+1) != null && (tabuleiro.getCasa(x-1, y+1).possuiPeca())
                && (tabuleiro.getCasa(x-1, y+1).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }        
                if(tabuleiro.getCasa(x-1, y-1) != null && (tabuleiro.getCasa(x-1, y-1).possuiPeca())
                && (tabuleiro.getCasa(x-1, y-1).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
            }
        
        else if(tipo == 11){
                 if(tabuleiro.getCasa(x+1, y) != null && (tabuleiro.getCasa(x+1, y).possuiPeca())
                 && (tabuleiro.getCasa(x+1, y).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x-1, y) != null && (tabuleiro.getCasa(x-1, y).possuiPeca())
                && (tabuleiro.getCasa(x-1, y).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x, y+1) != null && (tabuleiro.getCasa(x, y+1).possuiPeca())
                && (tabuleiro.getCasa(x, y+1).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x, y-1) != null && (tabuleiro.getCasa(x, y-1).possuiPeca())
                &&(tabuleiro.getCasa(x, y-1).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x+1, y+1) != null && (tabuleiro.getCasa(x+1, y+1).possuiPeca())
                && (tabuleiro.getCasa(x+1, y+1).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x+1, y-1) != null &&(tabuleiro.getCasa(x+1, y-1).possuiPeca())
                && (tabuleiro.getCasa(x+1, y-1).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
                if(tabuleiro.getCasa(x-1, y+1) != null && (tabuleiro.getCasa(x-1, y+1).possuiPeca())
                && (tabuleiro.getCasa(x-1, y+1).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }        
                if(tabuleiro.getCasa(x-1, y-1) != null && (tabuleiro.getCasa(x-1, y-1).possuiPeca())
                && (tabuleiro.getCasa(x-1, y-1).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
                }
         }       
    }     
}
    
