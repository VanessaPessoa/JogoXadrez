import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Peca extends Movimentacao{
    //peças brancas serao pares
    //peças pretas serao impares
    public static final int PEAO_BRANCO = 0;
    public static final int TORRE_BRANCA = 2;
    public static final int CAVALO_BRANCO = 4;
    public static final int BISPO_BRANCO = 6;
    public static final int RAINHA_BRANCA = 8;
    public static final int REI_BRANCO = 10;
    public static final int PEAO_PRETO = 1;
    public static final int TORRE_PRETA = 3;
    public static final int CAVALO_PRETO = 5;
    public static final int BISPO_PRETO = 7;
    public static final int RAINHA_PRETA = 9;
    public static final int REI_PRETO = 11;


    protected Casa casa;
    protected int tipo;
    protected Tabuleiro tabuleiro;
    protected ArrayList<Casa> casas;
    protected boolean moveuDuasCasas;   
    
    public Peca(Casa casa, int tipo, Tabuleiro tabuleiro) {
        this.casa = casa;    
        this.tipo = tipo;
        casa.colocarPeca(this);
        this.tabuleiro = tabuleiro;
        moveuDuasCasas = false;
        casas = new ArrayList<Casa>();
    }
    
    public void movimentos(int x, int y) {
    }
    
    public ArrayList<Casa> getCasasPossiveis() {
        return casas;
    }
    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino) {
        if (tipo %2 == 0 && podeMover(destino)) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino; 
            
        }
        if (tipo %2 != 0 && podeMover(destino) ) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino; 
            
        }
        proximoMovimento();
        casas.clear();
    }
   
    public boolean capturar(Casa destino){
        //nao pode matar o rei
        if ((casa.getTipoPeca()%2 != 0 && destino.getTipoPeca() == 10) || (casa.getTipoPeca()%2 == 0 && destino.getTipoPeca() == 11)){
            JOptionPane.showMessageDialog(null, " Xeque");
            return false;
        }
        
        //verifica os tipos das peças
        if (casa.getTipoPeca()%2 != destino.getTipoPeca()%2) {
            return true;
        }
        return false;
     }        
      
    public boolean podeMover(Casa destino){
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        casas.clear();
        movimentos(xOrigem, yOrigem);
        Iterator it = casas.iterator();
        while(it.hasNext()) {
            if (it.next().equals(destino)) {
                return true;
            }
        }
        return false;
    }
   
    public int getDistancia(int i){
        if(i < 0){
            return -i;
        }
        return i;
    }    
    
    public void proximoMovimento(){
        ////verificar em cada proxima possivel jogada  o rei adversario
    }
    
    public boolean proximaJogada(){
        //na proxima jogada o rei nao pode ficar ameaçado
        return false;
    }
    
    public boolean xequeBranco(){
        // verificar se o rei branco esta ameaçado
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                //verificar a posição do rei
                if((tabuleiro.getCasa(i,j) != null) && (tabuleiro.getCasa(i,j).possuiPeca()) && (tabuleiro.getCasa(i,j).getTipoPeca() == 10)){
                   // verificar se o rei esta ameaçado pelo peao adversario
                   if((tabuleiro.getCasa(i+1,j+1) != null) && (tabuleiro.getCasa(i+1, j+1).possuiPeca()) 
                   && (tabuleiro.getCasa(i+1, j+1).getTipoPeca() == 1)){
                       return true;
                   }
                   if((tabuleiro.getCasa(i-1,j+1) != null) && (tabuleiro.getCasa(i-1, j+1).possuiPeca()) 
                   && (tabuleiro.getCasa(i-1, j+1).getTipoPeca() == 1)){
                       return true;
                   }
                   
                   //verificar se o rei esta sendo ameaçado pelo rei adversario
                   if(tabuleiro.getCasa(i+1, j) != null && (tabuleiro.getCasa(i+1, j).possuiPeca()) && 
                   (tabuleiro.getCasa(i+1, j)).getTipoPeca() == 11) {
                        return true;
                   }
                   if(tabuleiro.getCasa(i-1, j) != null && (tabuleiro.getCasa(i-1, j).possuiPeca()) && 
                   (tabuleiro.getCasa(i-1, j)).getTipoPeca() == 11) {
                        return true;
                    }
                   if(tabuleiro.getCasa(i, j+1) != null && (tabuleiro.getCasa(i, j+1).possuiPeca()) && 
                    (tabuleiro.getCasa(i, j+1)).getTipoPeca() == 11) {
                        return true;
                   }
                   if(tabuleiro.getCasa(i, j-1) != null && (tabuleiro.getCasa(i, j-1).possuiPeca()) &&
                    (tabuleiro.getCasa(i, j-1)).getTipoPeca() == 11) {
                        return true;
                   }
                   if(tabuleiro.getCasa(i+1, i+1) != null && (tabuleiro.getCasa(j+1, i+1).possuiPeca()) &&
                    (tabuleiro.getCasa(j+1, i+1)).getTipoPeca() == 11) {
                        return true;
                   }
                   if(tabuleiro.getCasa(i+1, j-1) != null && (tabuleiro.getCasa(i+1, j-1).possuiPeca()) && 
                    (tabuleiro.getCasa(i+1, j-1)).getTipoPeca() == 11) {
                        return true;
                   }
                   if(tabuleiro.getCasa(i-1, j+1) != null && (tabuleiro.getCasa(i-1, j+1).possuiPeca()) &&
                   (tabuleiro.getCasa(i-1, j+1)).getTipoPeca() == 11) {
                        return true;
                   }        
                   if(tabuleiro.getCasa(i-1, j-1) != null && (tabuleiro.getCasa(i-1, j-1).possuiPeca()) &&  
                   (tabuleiro.getCasa(i-1, j-1)).getTipoPeca() == 11) {
                        return true;
                   }
                                      
                   //verificar se o rei esta sendo ameaçado pelo cavalo do adversario
                   if (tabuleiro.getCasa(i+2, j+1) != null && (tabuleiro.getCasa(i+2, j+1).possuiPeca()) &&
                      (tabuleiro.getCasa(i+2, j+1)).getTipoPeca() == 5) {
                        return true;
                    }
                   if (tabuleiro.getCasa(i+2, j-1) != null && (tabuleiro.getCasa(i+2, j-1).possuiPeca()) && 
                      (tabuleiro.getCasa(i+2, j-1)).getTipoPeca() == 5) {
                        return true;
                   }
                   if (tabuleiro.getCasa(i-2, j+1) != null && (tabuleiro.getCasa(i-2, j+1).possuiPeca()) && 
                      (tabuleiro.getCasa(i-2, j+1)).getTipoPeca() == 5) {
                       return true;
                   }
                   if (tabuleiro.getCasa(i-2, j-1) != null && (tabuleiro.getCasa(i-2, j-1).possuiPeca()) && 
                      (tabuleiro.getCasa(i-2, j-1)).getTipoPeca() == 5) {
                        return true;
                   }
                   if (tabuleiro.getCasa(i+1, j+2) != null && (tabuleiro.getCasa(i+1, j+2).possuiPeca()) &&
                       (tabuleiro.getCasa(i+1, j+2)).getTipoPeca() == 5) {
                        return true;
                    }
                   if (tabuleiro.getCasa(i-1, j+2) != null && (tabuleiro.getCasa(i-1, j+2).possuiPeca()) &&
                       (tabuleiro.getCasa(i-1, j+2)).getTipoPeca() == 5) {
                        return true;
                   }
                   if (tabuleiro.getCasa(i+1, j-2) != null && (tabuleiro.getCasa(i+1, j-2).possuiPeca()) &&
                      (tabuleiro.getCasa(i+1, j-2)).getTipoPeca() == 5) {
                        return true;
                   }
                   if (tabuleiro.getCasa(i-1, j-2) != null && (tabuleiro.getCasa(i-1, j-2).possuiPeca()) &&
                       (tabuleiro.getCasa(i-1, j-2)).getTipoPeca() == 5) {
                        return true;
                    
                   }
                   
                   
                   //verificar se o rei esta sendo ameaçado pela rainha adversaria                   
                   
                   
                   break;
                   
                   
                }
                               
                break;
            }
           
        }
        return false;
    }
    
    public boolean xequePreto(){
        // verificar se o rei branco esta ameaçado
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                //verificar a posição do rei
                if((tabuleiro.getCasa(i,j) != null) && (tabuleiro.getCasa(i,j).possuiPeca()) && (tabuleiro.getCasa(i,j).getTipoPeca() == 11)){
                   // verificar se o rei esta ameaçado pelo peao adversario
                   if((tabuleiro.getCasa(i+1,j+1) != null) && (tabuleiro.getCasa(i+1, j+1).possuiPeca()) 
                   && (tabuleiro.getCasa(i+1, j+1).getTipoPeca() == 2)){
                       return true;
                   }
                   if((tabuleiro.getCasa(i-1,j+1) != null) && (tabuleiro.getCasa(i-1, j+1).possuiPeca()) 
                   && (tabuleiro.getCasa(i-1, j+1).getTipoPeca() == 2)){
                       return true;
                   }
                   
                   //verificar se o rei esta sendo ameaçado pelo rei adversario
                   if(tabuleiro.getCasa(i+1, j) != null && (tabuleiro.getCasa(i+1, j).possuiPeca()) && 
                   (tabuleiro.getCasa(i+1, j)).getTipoPeca() == 10) {
                        return true;
                   }
                   if(tabuleiro.getCasa(i-1, j) != null && (tabuleiro.getCasa(i-1, j).possuiPeca()) && 
                   (tabuleiro.getCasa(i-1, j)).getTipoPeca() == 10) {
                        return true;
                    }
                   if(tabuleiro.getCasa(i, j+1) != null && (tabuleiro.getCasa(i, j+1).possuiPeca()) && 
                    (tabuleiro.getCasa(i, j+1)).getTipoPeca() == 10) {
                        return true;
                   }
                   if(tabuleiro.getCasa(i, j-1) != null && (tabuleiro.getCasa(i, j-1).possuiPeca()) &&
                    (tabuleiro.getCasa(i, j-1)).getTipoPeca() == 10) {
                        return true;
                   }
                   if(tabuleiro.getCasa(i+1, i+1) != null && (tabuleiro.getCasa(j+1, i+1).possuiPeca()) &&
                    (tabuleiro.getCasa(j+1, i+1)).getTipoPeca() == 10) {
                        return true;
                   }
                   if(tabuleiro.getCasa(i+1, j-1) != null && (tabuleiro.getCasa(i+1, j-1).possuiPeca()) && 
                    (tabuleiro.getCasa(i+1, j-1)).getTipoPeca() == 10) {
                        return true;
                   }
                   if(tabuleiro.getCasa(i-1, j+1) != null && (tabuleiro.getCasa(i-1, j+1).possuiPeca()) &&
                   (tabuleiro.getCasa(i-1, j+1)).getTipoPeca() == 10) {
                        return true;
                   }        
                   if(tabuleiro.getCasa(i-1, j-1) != null && (tabuleiro.getCasa(i-1, j-1).possuiPeca()) &&  
                   (tabuleiro.getCasa(i-1, j-1)).getTipoPeca() == 10) {
                        return true;
                   }
                                      
                   //verificar se o rei esta sendo ameaçado pelo cavalo do adversario
                   if (tabuleiro.getCasa(i+2, j+1) != null && (tabuleiro.getCasa(i+2, j+1).possuiPeca()) &&
                      (tabuleiro.getCasa(i+2, j+1)).getTipoPeca() == 4) {
                        return true;
                    }
                   if (tabuleiro.getCasa(i+2, j-1) != null && (tabuleiro.getCasa(i+2, j-1).possuiPeca()) && 
                      (tabuleiro.getCasa(i+2, j-1)).getTipoPeca() == 4) {
                        return true;
                   }
                   if (tabuleiro.getCasa(i-2, j+1) != null && (tabuleiro.getCasa(i-2, j+1).possuiPeca()) && 
                      (tabuleiro.getCasa(i-2, j+1)).getTipoPeca() == 4) {
                       return true;
                   }
                   if (tabuleiro.getCasa(i-2, j-1) != null && (tabuleiro.getCasa(i-2, j-1).possuiPeca()) && 
                      (tabuleiro.getCasa(i-2, j-1)).getTipoPeca() == 4) {
                        return true;
                   }
                   if (tabuleiro.getCasa(i+1, j+2) != null && (tabuleiro.getCasa(i+1, j+2).possuiPeca()) &&
                       (tabuleiro.getCasa(i+1, j+2)).getTipoPeca() == 4) {
                        return true;
                    }
                   if (tabuleiro.getCasa(i-1, j+2) != null && (tabuleiro.getCasa(i-1, j+2).possuiPeca()) &&
                       (tabuleiro.getCasa(i-1, j+2)).getTipoPeca() == 4) {
                        return true;
                   }
                   if (tabuleiro.getCasa(i+1, j-2) != null && (tabuleiro.getCasa(i+1, j-2).possuiPeca()) &&
                      (tabuleiro.getCasa(i+1, j-2)).getTipoPeca() == 4) {
                        return true;
                   }
                   if (tabuleiro.getCasa(i-1, j-2) != null && (tabuleiro.getCasa(i-1, j-2).possuiPeca()) &&
                       (tabuleiro.getCasa(i-1, j-2)).getTipoPeca() == 4) {
                        return true;
                    
                   }
                   
                   
                   //verificar se o rei esta sendo ameaçado pela rainha adversaria                   
                   
                   
                   break;
                   
                   
                }
                               
                break;
            }
           
        }
        return false;
    }
    
    public boolean xequeMate(Casa destino){
        if( tipo%2 == 0 && podeMover(destino) == false && xequeBranco() == true){
             JOptionPane.showMessageDialog(null, " Xeque");
               return true;
        }
        else if (tipo%2 != 0 && podeMover(destino) == false && xequePreto() == true){
               JOptionPane.showMessageDialog(null, " Xeque");
               return true;
        }
        
        return false;
    }
    
    /**
     * Valor    Tipo
     *   0   Branca (Peao)
     *   1   Preta (Peao)
     *   2   Branca (Torre)
     *   3   Preta (Torre)
     *   4   Branca (Cavalo)
     *   5   Preta (Cavalo)
     *   6   Branca (Bispo)
     *   7   Preta (Bispo)
     *   8   Branca (Dama)
     *   9   Preta (Dama)
     *   10  Branca (Rei)
     *   11  Preta (Rei)
     *   
     *   
     * @return o tipo da peca.
     */
    public int getTipo() {
        return tipo;
    }
}
