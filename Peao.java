import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.ArrayList;
/**
 * Write a description of class Peao here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Peao extends Peca 
{
    private boolean primeiraJogada;
    /**
     * Constructor for objects of class Peao
     */
    public Peao(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
        super(casa, tipo, tabuleiro); 
        primeiraJogada = true;

    }       
    
    public void movimentos(int x, int y) {
        // brancos
        if(tipo == 0) {
            // se está na posicão inicial, pode mover +1 ou +2
            if (y == 1 && tabuleiro.getCasa(x, y+1).possuiPeca() == false) {
                casas.add(tabuleiro.getCasa(x, y+1));
                casas.add(tabuleiro.getCasa(x, y+2));
            }
            else if (tabuleiro.getCasa(x, y+1).possuiPeca() == false) {
                casas.add(tabuleiro.getCasa(x, y+1));
            }
            // se puder capturar
            // pode mover na diagonal direita
            if (tabuleiro.getCasa(x+1, y+1) != null && tabuleiro.getCasa(x+1, y+1).possuiPeca() && capturar(tabuleiro.getCasa(x+1, y+1))) {                      
                casas.add(tabuleiro.getCasa(x+1, y+1));
            }
            // pode mover na diagonal esquerda
            if (tabuleiro.getCasa(x-1, y+1) != null && tabuleiro.getCasa(x-1, y+1).possuiPeca() && capturar(tabuleiro.getCasa(x-1, y+1))) {
                casas.add(tabuleiro.getCasa(x-1, x+1));
            }
        }
        // pretos
        else {
            if (y == 6 && tabuleiro.getCasa(x, y-1).possuiPeca() == false) {
                casas.add(tabuleiro.getCasa(x, y-1));
                casas.add(tabuleiro.getCasa(x, y-2));
            }
            else if (tabuleiro.getCasa(x, y-1).possuiPeca() == false){
                casas.add(tabuleiro.getCasa(x, y-1));
            }
            // se puder capturar
            // pode mover na diagonal direita
            if (tabuleiro.getCasa(x+1, y-1) != null && tabuleiro.getCasa(x+1, y-1).possuiPeca() && capturar(tabuleiro.getCasa(x+1, y-1))) {                      
                casas.add(tabuleiro.getCasa(x+1, y-1));
            }
            // pode mover na diagonal esquerda
            if (tabuleiro.getCasa(x-1, y-1) != null && tabuleiro.getCasa(x-1, y-1).possuiPeca() && capturar(tabuleiro.getCasa(x-1, y-1))) {
                casas.add(tabuleiro.getCasa(x-1, y-1));
            }
        }

    }
    
    public void proximoMovimento(){
        if(tipo == 0){
           if((tabuleiro.getCasa(casa.getX()+1, casa.getY()+1) != null) && tabuleiro.getCasa(casa.getX()+1, casa.getY()+1).possuiPeca() && 
           tabuleiro.getCasa(casa.getX()+1, casa.getY()+1).getTipoPeca() == 11){
               JOptionPane.showMessageDialog(null, " Xeque");
            }
            else if((tabuleiro.getCasa(casa.getX()-1, casa.getY()+1) != null )&& tabuleiro.getCasa(casa.getX()-1, casa.getY()+1).possuiPeca()
            && tabuleiro.getCasa(casa.getX()-1, casa.getY()+1).getTipoPeca() == 11){
               JOptionPane.showMessageDialog(null, " Xeque");
            }
        }
        else if(tipo == 1){
           if((tabuleiro.getCasa(casa.getX()+1, casa.getY()-1) != null) && tabuleiro.getCasa(casa.getX()+1, casa.getY()-1).possuiPeca() && 
           tabuleiro.getCasa(casa.getX()+1, casa.getY()-1).getTipoPeca() == 10){
               JOptionPane.showMessageDialog(null, " Xeque");
            }
            else if((tabuleiro.getCasa(casa.getX()-1, casa.getY()-1) != null) && tabuleiro.getCasa(casa.getX()-1, casa.getY()-1).possuiPeca()
            && tabuleiro.getCasa(casa.getX()-1, casa.getY()-1).getTipoPeca() == 10){
               JOptionPane.showMessageDialog(null, " Xeque");
            }
        } 

     }
    
    public void mover(Casa destino){
        if (podeMover(destino)) {
            super.mover(destino);
            troca(destino);
            troca(destino);
            primeiraJogada = false;
        } 
    }
    
    public void troca(Casa destino){
        //faz a premiação do peao branco
        //quando ele chegar na posicao Y=7 ele pode escolher entre torre, cavalo, bispo e rainha para fazer a troca
        if(tipo == 0 && destino.getY() == 7 ){
            Object[] opcoes = {"Rainha", "Bispo", "Torre", "Cavalo"};
            int x;
           
            do{
                x = JOptionPane.showOptionDialog(null, "Escolha uma peça para troca:",
                "O peão foi promovido",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                if(x == 0){
                    casa.removerPeca();
                    Rainha Rainha = new Rainha(destino, 8, tabuleiro);
                 }
                else if(x == 1){
                     casa.removerPeca();
                     Bispo Bispo = new Bispo(destino, 6, tabuleiro);
                }
                else if(x == 2){
                    casa.removerPeca();
                    Torre Torre = new Torre (destino,2, tabuleiro);
                }
                else if(x == 3){
                    casa.removerPeca();
                    Cavalo Cavalo = new Cavalo (destino, 4, tabuleiro);
                }                
            } while(x == JOptionPane.CLOSED_OPTION);
            
        }
        //faz a premiação do peao preto
        //quando ele chegar na posicao Y=7 ele pode escolher entre torre, cavalo, bispo e rainha para fazer a troca
        if(tipo == 1 && destino.getY() == 0){
            Object[] opcoes= {"Rainha", "Bispo", "Torre", "Cavalo"};
            int x;
               
            do{
                x = JOptionPane.showOptionDialog(null, "Escolha uma peça para troca:",
                "O peão foi promovido",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                if(x == 0){
                     casa.removerPeca();
                     Peca Rainha = new Rainha(destino, 9, tabuleiro);
                }
                else if(x == 1){
                     casa.removerPeca();
                     Peca Bispo= new Bispo(destino, 7, tabuleiro);
                }
                else if(x == 2){
                     casa.removerPeca();
                     Peca Torre= new Torre (destino,3, tabuleiro);
                }
                else if(x == 3){
                     casa.removerPeca();
                     Peca Cavalo = new Cavalo (destino, 5, tabuleiro);
                }
            }while(x == JOptionPane.CLOSED_OPTION);  
         }    
    }
    
  
}
        
       
    
        
    
    

