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
        /**
     * Constructor for objects of class Peao
     */
    public Peao(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
        super(casa, tipo, tabuleiro);  
    }       
    
    public void movimentos(int x, int y) {
        // brancos        
        if(tipo == 0) {
            // se está na posicão inicial, pode mover +1 ou +2
            if (y == 1 && tabuleiro.getCasa(x, y+1).possuiPeca() == false) {
                casas.add(tabuleiro.getCasa(x, y+1));
                casas.add(tabuleiro.getCasa(x, y+2));
                setAvancouDuasCasas(true);
            }
            else if (tabuleiro.getCasa(x, y+1).possuiPeca() == false) {
                casas.add(tabuleiro.getCasa(x, y+1));
                setAvancouDuasCasas(false);
            }
            // se puder capturar
            // pode mover na diagonal direita
            if (tabuleiro.getCasa(x+1, y+1) != null && tabuleiro.getCasa(x+1, y+1).possuiPeca() && (capturar(tabuleiro.getCasa(x+1, y+1)) == true)) {                      
                casas.add(tabuleiro.getCasa(x+1, y+1));
                setAvancouDuasCasas(false);
            }
            // pode mover na diagonal esquerda
            if (tabuleiro.getCasa(x-1, y+1) != null && tabuleiro.getCasa(x-1, y+1).possuiPeca() && (capturar(tabuleiro.getCasa(x-1, y+1))) == true)  {
                casas.add(tabuleiro.getCasa(x-1, y+1));
                setAvancouDuasCasas(false);
            }
            
        }
        // pretos
        else {
            if (y == 6 && tabuleiro.getCasa(x, y-1).possuiPeca() == false) {
                casas.add(tabuleiro.getCasa(x, y-1));
                casas.add(tabuleiro.getCasa(x, y-2));
                setAvancouDuasCasas(true);
            }
            else if (tabuleiro.getCasa(x, y-1).possuiPeca() == false){
                casas.add(tabuleiro.getCasa(x, y-1));
                setAvancouDuasCasas(false);
               }
            // se puder capturar
            // pode mover na diagonal direita
            if (tabuleiro.getCasa(x+1, y-1) != null && tabuleiro.getCasa(x+1, y-1).possuiPeca() && (capturar(tabuleiro.getCasa(x+1, y-1))) == true){                      
                casas.add(tabuleiro.getCasa(x+1, y-1));
                setAvancouDuasCasas(false);
            }
            // pode mover na diagonal esquerda
            if (tabuleiro.getCasa(x-1, y-1) != null && tabuleiro.getCasa(x-1, y-1).possuiPeca() && (capturar(tabuleiro.getCasa(x-1, y-1))) == true){
                casas.add(tabuleiro.getCasa(x-1, y-1));
                setAvancouDuasCasas(false);
            }            
        }
    }
    
    public void mover(Casa destino){
        if (podeMover(destino)) {
            super.mover(destino);
            troca(destino);
                    }
        enPassant(destino);
    }
    
    // verificar se pode comer por en passant
    public boolean passant(Casa destino){
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
         
        if(tipo == 0 && yOrigem == 4){
           if(xOrigem +1 == xDestino && yOrigem +1 == yDestino && destino != null){
              if((tabuleiro.getCasa(xOrigem+1, yOrigem) != null)  && (tabuleiro.getCasa(xOrigem+1, yOrigem).possuiPeca() 
                 && (tabuleiro.getCasa(xOrigem+1, yOrigem).getTipoPeca() == 1))){
                Peca peca = tabuleiro.getCasa(xOrigem+1, yOrigem).getPeca();
                if(peca.getAvancouDuasCasas()){
                    tabuleiro.getCasa(xOrigem+1, yOrigem).removerPeca();             
                    return true;
                }
              }              
           }  
           
           if(xOrigem -1 == xDestino && yOrigem +1 == yDestino  && destino != null){
              if((tabuleiro.getCasa(xOrigem-1, yOrigem) != null) && (tabuleiro.getCasa(xOrigem-1, yOrigem).possuiPeca() 
                  && (tabuleiro.getCasa(xOrigem-1, yOrigem).getTipoPeca() == 1))){
                   Peca peca = tabuleiro.getCasa(xOrigem-1, yOrigem).getPeca();
                   if(peca.getAvancouDuasCasas()){
                     tabuleiro.getCasa(xOrigem-1, yOrigem).removerPeca();
                     return true;
                   }                 
                }            
           }
           
        }
        else if(tipo == 1 && yOrigem == 3 && destino != null){
              if(xOrigem +1 == xDestino && yOrigem -1 == yDestino){
                 if((tabuleiro.getCasa(xOrigem+1, yOrigem) != null) && (tabuleiro.getCasa(xOrigem+1, yOrigem).possuiPeca() 
                      && (tabuleiro.getCasa(xOrigem+1, yOrigem).getTipoPeca() == 0))){
                     Peca peca = tabuleiro.getCasa(xOrigem+1, yOrigem).getPeca();
                     if(peca.getAvancouDuasCasas()){
                         tabuleiro.getCasa(xOrigem+1, yOrigem).removerPeca();
                         return true;
                     }
                 }
              } 
              
              if(xOrigem -1 == xDestino && yOrigem -1 == yDestino && destino != null){
                 if((tabuleiro.getCasa(xOrigem-1, yOrigem) != null) && (tabuleiro.getCasa(xOrigem-1, yOrigem).possuiPeca() 
                     && (tabuleiro.getCasa(xOrigem-1, yOrigem).getTipoPeca() == 0))){
                     Peca peca = tabuleiro.getCasa(xOrigem-1, yOrigem).getPeca();
                      if(peca.getAvancouDuasCasas()){
                          tabuleiro.getCasa(xOrigem-1, yOrigem).removerPeca();
                          return true;
                     }
                 }
                } 
                
           }
        
        return false;
    
    }  
    
    public void troca(Casa destino){
        //faz a premiação do peao branco
        //quando ele chegar na posicao Y=7 ele pode escolher entre torre, cavalo, bispo e rainha para fazer a troca
        if(tipo == 0 && destino.getY() == 7){
            Object[] opcoes = {"Rainha", "Bispo", "Torre", "Cavalo"};
            int x;
           
            do{
                x = JOptionPane.showOptionDialog(null, "Escolha uma peça para troca:",
                "O peão foi promovido",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                if(x == 0){
                   Rainha Rainha = new Rainha(destino, 8, tabuleiro);
                 }
                else if(x == 1){
                    Bispo Bispo = new Bispo(destino, 6, tabuleiro);
                }
                else if(x == 2){
                   Torre Torre = new Torre (destino,2, tabuleiro);
                }
                else if(x == 3){
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
                   Peca Rainha = new Rainha(destino, 9, tabuleiro);
                }
                else if(x == 1){
                    Peca Bispo= new Bispo(destino, 7, tabuleiro);
                }
                else if(x == 2){
                    Peca Torre= new Torre (destino,3, tabuleiro);
                }
                else if(x == 3){
                    Peca Cavalo = new Cavalo (destino, 5, tabuleiro);
                }
            }while(x == JOptionPane.CLOSED_OPTION);  
         }    
    }
    
    public void enPassant(Casa destino){
        if(passant(destino) == true){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
        }
    }
    
    public boolean podeTroca(Casa destino){
        if(tipo == 0 && destino.getY() == 7){
            return true;
        }
        else if(tipo == 1 && destino.getY() == 0){
            return true;
        }   
        return false;
    }       
}
        
       
    
        
    
    

