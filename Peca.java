import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    protected boolean primeiraJogada;
    
    private boolean avancouDuasCasas;// saber se os peoes andou duas casas
    private boolean primeiraJogadaTorre; //  se a torre branca se mexeu retorna false, se a torre nao mexeu retona true

    public Peca(Casa casa, int tipo, Tabuleiro tabuleiro) {
        this.casa = casa;    
        this.tipo = tipo;
        casa.colocarPeca(this);
        this.tabuleiro = tabuleiro;
        casas = new ArrayList<Casa>();
        avancouDuasCasas = false;
        primeiraJogadaTorre = true;
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
        if (podeMover(destino)) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino; 
        }
        casas.clear();
    }
   
    public boolean capturar(Casa destino){
        //nao pode matar o rei
        if ((casa.getTipoPeca()%2 != 0 && destino.getTipoPeca() == 10) || (casa.getTipoPeca()%2 == 0 && destino.getTipoPeca() == 11)){
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
      
    public boolean getAvancouDuasCasas(){
        return avancouDuasCasas;    
    }
    
    public void setAvancouDuasCasas(boolean avancouDuasCasas){
        this.avancouDuasCasas = avancouDuasCasas;
    }
    
    public boolean getPrimeiraJogadaTorre(){
        return primeiraJogadaTorre;    
    }
    
    public void setPrimeiraJogadaTorre(boolean primeiraJogadaTorre){
        this.primeiraJogadaTorre = primeiraJogadaTorre;
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
