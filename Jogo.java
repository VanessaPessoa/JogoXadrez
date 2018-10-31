import java.util.ArrayList;
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;
    private int turno; // 0 representa brancas e 1 representa pretas

    public Jogo() {
        tabuleiro= new Tabuleiro();
        turno = 0;
        criarPecas();
    }
    
    public int turno() {
        return turno;
    }
    
    public boolean suaVez(int tipoPeca) {
        return tipoPeca == turno;
    }
    
    public void mudarTurno() {
        if (turno == 0) { // brancas
            turno++;
        }
        else { // pretas
            turno--;
        }
    }
    
    public void vezInicial() {
        turno = 0; // brancas
    }
    
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
    protected void criarPecas() {
        for(int x=0; x<8; x++){
           //posicionar os peões 
           Peca peaoBranco = new Peao(tabuleiro.getCasa(x,1), Peca.PEAO_BRANCO, tabuleiro);
           Peca peaoPreto = new Peao(tabuleiro.getCasa(x,6), Peca.PEAO_PRETO, tabuleiro);
        }
        for(int x=0; x<8; x = x + 7){
            //posicionar as torres
            Peca torreBranca = new Torre(tabuleiro.getCasa(x,0),Peca.TORRE_BRANCA, tabuleiro);    
            Peca torrePreta= new Torre(tabuleiro.getCasa(x,7),Peca.TORRE_PRETA, tabuleiro);
        }
        for(int x=2; x<6; x = x + 3){
            //posicionar os bispos
            Peca bispoBranco= new Bispo(tabuleiro.getCasa(x,0),Peca.BISPO_BRANCO, tabuleiro); 
            Peca bispoPreto= new Bispo(tabuleiro.getCasa(x,7),Peca.BISPO_PRETO, tabuleiro);
        }        
        for(int x=1; x<7; x = x + 5){
            //posicionar os cavalos
            Peca cavaloBranco= new Cavalo(tabuleiro.getCasa(x,0),Peca.CAVALO_BRANCO, tabuleiro); 
            Peca cavaloPreto= new Cavalo(tabuleiro.getCasa(x,7),Peca.CAVALO_PRETO, tabuleiro);
        }
              
        //posicionar a rainha branca
        Peca rainhaBranca= new Rainha(tabuleiro.getCasa(3,0),Peca.RAINHA_BRANCA, tabuleiro);
              
        //posicionar a rainha preta
        Peca rainhaPreta= new Rainha(tabuleiro.getCasa(3,7),Peca.RAINHA_PRETA, tabuleiro);
        
        //posicionar o rei branco
        Peca reiBranco= new Rei(tabuleiro.getCasa(4,0),Peca.REI_BRANCO, tabuleiro);
        
        //posicionar o rei preto
        Peca reiPreto= new Rei(tabuleiro.getCasa(4,7),Peca.REI_PRETO, tabuleiro);
    }    
    
    /**
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public void moverPeca(CasaGUI casaOrigem, CasaGUI casaDestino) {
        //onde ocorrera as movimentações das peças
        Casa origem = tabuleiro.getCasa(casaOrigem.getPosicaoX(),casaOrigem.getPosicaoY());
        Casa destino = tabuleiro.getCasa(casaDestino.getPosicaoX(), casaDestino.getPosicaoY());
        Peca peca = origem.getPeca();
        peca.mover(destino);
        // se destino possui uma peça é porque a peça se moveu, então pode mudar de turno 
        
        if (destino.getPeca() != null && destino.getPeca().equals(peca)) {
            mudarTurno();  
        } 
       
    }   
   
    public ArrayList<Casa> movimentosPossiveis(CasaGUI casa) {
        int x = casa.getPosicaoX();
        int y = casa.getPosicaoY();
        Peca peca = tabuleiro.getCasa(x, y).getPeca();
        peca.movimentos(x, y);
        return peca.getCasasPossiveis();
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
