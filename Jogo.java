
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
        tabuleiro = new Tabuleiro();
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
        for(int linha=0; linha<8; linha++){
           //posicionar os peões brancos
           Peca peaoBranco = new Peao(tabuleiro.getCasa(linha,1), Peca.PEAO_BRANCO);
           //posicionar os peões pretos
           Peca peaoPreto = new Peao(tabuleiro.getCasa(linha,6), Peca.PEAO_PRETO);
        }
        
        //posicionar as torres brancas
        Peca torreBranca = new Torre(tabuleiro.getCasa(0,0),Peca.TORRE_BRANCA);
        Peca torreBranca1 = new Torre(tabuleiro.getCasa(7,0),Peca.TORRE_BRANCA);
                
        //posicionar as torres pretas
        Peca torrePreta= new Torre(tabuleiro.getCasa(0,7),Peca.TORRE_PRETA);
        Peca torrePreta1= new Torre(tabuleiro.getCasa(7,7),Peca.TORRE_PRETA);
        
        //posicionar os bispos brancos
        Peca bispoBranco= new Bispo(tabuleiro.getCasa(2,0),Peca.BISPO_BRANCO);        
        Peca bispoBranco1= new Bispo(tabuleiro.getCasa(5,0),Peca.BISPO_BRANCO);
                
        //posicionar os bispos pretos
        Peca bispoPreto= new Bispo(tabuleiro.getCasa(2,7),Peca.BISPO_PRETO);
        Peca bispoPreto1= new Bispo(tabuleiro.getCasa(5,7),Peca.BISPO_PRETO);
        
        //posicionar os cavalos brancos
        Peca cavaloBranco= new Cavalo(tabuleiro.getCasa(1,0),Peca.CAVALO_BRANCO);
        Peca cavaloBranco1= new Cavalo(tabuleiro.getCasa(6,0),Peca.CAVALO_BRANCO);
                
        //posicionar os cavalos pretos
        Peca cavaloPreto= new Cavalo(tabuleiro.getCasa(1,7),Peca.CAVALO_PRETO);
        Peca cavaloPreto1= new Cavalo(tabuleiro.getCasa(6,7),Peca.CAVALO_PRETO);
        
        //posicionar a rainha branca
        Peca rainhaBranca= new Rainha(tabuleiro.getCasa(3,0),Peca.RAINHA_BRANCA);
              
        //posicionar a rainha preta
        Peca rainhaPreta= new Rainha(tabuleiro.getCasa(3,7),Peca.RAINHA_PRETA);
        
        //posicionar o rei branco
        Peca reiBranco= new Rei(tabuleiro.getCasa(4,0),Peca.REI_BRANCO);
        
        //posicionar o rei preto
        Peca reiPreto= new Rei(tabuleiro.getCasa(4,7),Peca.REI_PRETO);
    }    
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        //onde ocorrera as movimentações das peças
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca= origem.getPeca();
        peca.mover(destino);
                       
    }   
   
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
