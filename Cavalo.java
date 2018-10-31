import javax.swing.JOptionPane;
import javax.swing.*;
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
    
     public void proximoMovimento(){
        int x = casa.getX();
        int y = casa.getY();
        
        //verificar em cada proxima possivel jogada  o rei adversario
        if(tipo == 4){
            if (tabuleiro.getCasa(x+2, y+1) != null && (tabuleiro.getCasa(x+2, y+1).possuiPeca()) &&
                (tabuleiro.getCasa(x+2, y+1).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x+2, y-1) != null && (tabuleiro.getCasa(x+2, y-1).possuiPeca()) && 
                 (tabuleiro.getCasa(x+2, y-1).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x-2, y+1) != null && (tabuleiro.getCasa(x-2, y+1).possuiPeca()) && 
                 (tabuleiro.getCasa(x-2, y+1).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x-2, y-1) != null && (tabuleiro.getCasa(x-2, y-1).possuiPeca()) && 
                (tabuleiro.getCasa(x-2, y-1).getTipoPeca() == 11 )){
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x+1, y+2) != null && (tabuleiro.getCasa(x+1, y+2).possuiPeca()) &&
                 (tabuleiro.getCasa(x+1, y+2).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x-1, y+2) != null && (tabuleiro.getCasa(x-1, y+2).possuiPeca()) &&
                 (tabuleiro.getCasa(x-1, y+2).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x+1, y-2) != null && (tabuleiro.getCasa(x+1, y-2).possuiPeca()) &&
                 (tabuleiro.getCasa(x+1, y-2).getTipoPeca() == 11)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x-1, y-2) != null && (tabuleiro.getCasa(x-1, y-2).possuiPeca())&&
                (tabuleiro.getCasa(x-1, y-2)).getTipoPeca() == 11) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
        }
        if(tipo == 5){
            if (tabuleiro.getCasa(x+2, y+1) != null && (tabuleiro.getCasa(x+2, y+1).possuiPeca()) &&
                (tabuleiro.getCasa(x+2, y+1).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x+2, y-1) != null && (tabuleiro.getCasa(x+2, y-1).possuiPeca()) && 
                 (tabuleiro.getCasa(x+2, y-1).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x-2, y+1) != null && (tabuleiro.getCasa(x-2, y+1).possuiPeca()) && 
                 (tabuleiro.getCasa(x-2, y+1).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x-2, y-1) != null && (tabuleiro.getCasa(x-2, y-1).possuiPeca()) && 
                (tabuleiro.getCasa(x-2, y-1).getTipoPeca() == 10 )){
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x+1, y+2) != null && (tabuleiro.getCasa(x+1, y+2).possuiPeca()) &&
                 (tabuleiro.getCasa(x+1, y+2).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x-1, y+2) != null && (tabuleiro.getCasa(x-1, y+2).possuiPeca()) &&
                 (tabuleiro.getCasa(x-1, y+2).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x+1, y-2) != null && (tabuleiro.getCasa(x+1, y-2).possuiPeca()) &&
                 (tabuleiro.getCasa(x+1, y-2).getTipoPeca() == 10)) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }
            if (tabuleiro.getCasa(x-1, y-2) != null && (tabuleiro.getCasa(x-1, y-2).possuiPeca())&&
                (tabuleiro.getCasa(x-1, y-2)).getTipoPeca() == 10) {
                   JOptionPane.showMessageDialog(null, " Xeque");
            }        
        }
        
        
    }
    
    public void mover(Casa destino) {
        super.mover(destino);
    }
    /* 
    public boolean podeMover(Casa destino) {
        
        // dentro do if vai verificar se o destino possui peca e se possuir o movimento so sera valido se o tipo for diferente do tipo da casa
        if (((tipo == 4 || tipo == 5)  && (destino.possuiPeca() == false ||  capturar(destino) == true)) &&
            ((casa.getX()+2 == destino.getX() || casa.getX()-2 == destino.getX()) &&
                (casa.getY()+1 == destino.getY() || casa.getY()-1 == destino.getY()))){
                moveuDuasCasas = false;
                return true;
                
        } else if (((tipo == 4 || tipo == 5) && (destino.possuiPeca() == false ||  capturar(destino) == true)) &&
           ((casa.getX()+1 == destino.getX() || casa.getX()-1 == destino.getX()) && 
                (casa.getY()+2 == destino.getY() || casa.getY()-2 == destino.getY()))){
                moveuDuasCasas = false;
                return true;
        }
        
        return false;    
    }*/
}
