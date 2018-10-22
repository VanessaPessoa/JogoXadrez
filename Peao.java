import javax.swing.JOptionPane;
import javax.swing.*;
/**
 * Write a description of class Peao here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Peao extends Peca 
{
    // instance variables - replace the example below with your own
    private Tabuleiro tabuleiro;

    /**
     * Constructor for objects of class Peao
     */
    public Peao(Casa casa, int tipo)
    {
      super(casa, tipo);  
      tabuleiro = new Tabuleiro();
      
    }       
    
    public void mover(Casa destino){
        
        //movimentação dos peaos 
               
        if(podeMover(destino)==true){
                 destino.colocarPeca(this);
                 casa.removerPeca();
                 casa=destino;
                 troca(destino);
            }
        
    }
    
    public Boolean podeMover(Casa destino){
        // condições de movimento de peao branco
        //primeiro if se for o primeiro movimento pode andar duas casas em Y
        //segundo if condição de movimentar apenas uma casa 
        //terceiro if condição de captura        
        if( tipo==0  && destino.possuiPeca()==false && casa.getY()==1 && casa.getX() == destino.getX() && casa.getY()+2== destino.getY()){
            return true;
        }
        else if(tipo==0  && destino.possuiPeca()==false && casa.getX()== destino.getX() && casa.getY()+1== destino.getY()){
            return true;        
        }
        else if((tipo==0  && destino.possuiPeca()==true && capturar(destino)==true) &&
        ((casa.getX()+1== destino.getX()) ||(casa.getX()-1==destino.getX()))
        && (casa.getY()+1== destino.getY())){
            return true;
        }
        
        // condições de movimento do peão preto
        //mesmas condições que o branco, so muda o tipo
        if(tipo==1  && destino.possuiPeca()==false && casa.getY()==6 && casa.getX() == destino.getX() && casa.getY()-2== destino.getY()){
            return true;
        }
        else if(tipo==1  && destino.possuiPeca()==false && casa.getX()== destino.getX() && casa.getY()-1== destino.getY()){
            return true;
        }
        else if((tipo==1  && destino.possuiPeca()==true && capturar(destino)==true) &&
        ((casa.getX()+1== destino.getX()) || (casa.getX()-1==destino.getX())) && (casa.getY()-1== destino.getY())){
            return true;
        }
        
        return false;
    }
    
    public void troca(Casa destino){
        //faz a premiação do peao branco
        //quando ele chegar na posicao Y=7 ele pode escolher entre torre, cavalo, bispo e rainha para fazer a troca
        if(tipo==0 && destino.getY()==7){
            Object[] opcoes= {"Rainha", "Bispo", "Torre", "Cavalo"};
            int x;
            x=JOptionPane.showOptionDialog(null, "Escolha uma peça para troca:",
                    "O peão foi promovido",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
           do{
                if(x==0){
                   Rainha Rainha = new Rainha(destino, 8);
                 }
                else if(x==1){
                    Bispo Bispo= new Bispo(destino, 6);
                }
                else if(x==2){
                   Torre Torre= new Torre (destino,2);
                }
                else if(x==3){
                   Cavalo Cavalo= new Cavalo (destino, 4);
                } else{
                    x=JOptionPane.showOptionDialog(null, "Escolha uma peça para troca:",
                    "O peão foi promovido",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                        if(x==0){
                       Rainha Rainha = new Rainha(destino, 8);
                     }
                    else if(x==1){
                        Bispo Bispo= new Bispo(destino, 6);
                    }
                    else if(x==2){
                       Torre Torre= new Torre (destino,2);
                    }
                    else if(x==3){
                       Cavalo Cavalo= new Cavalo (destino, 4);
                    } 
                }
            } while(x==JOptionPane.CLOSED_OPTION);
            
        }
        //faz a premiação do peao preto
        //quando ele chegar na posicao Y=7 ele pode escolher entre torre, cavalo, bispo e rainha para fazer a troca
        if(tipo==1 && destino.getY()==0){
            Object[] opcoes= {"Rainha", "Bispo", "Torre", "Cavalo"};
            
            int x;
                x=JOptionPane.showOptionDialog(null, "Escolha uma peça para troca:",
                "O peão foi promovido",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            do{
                if(x==0){
                   Peca Rainha = new Rainha(destino, 9);
                }
                else if(x==1){
                    Peca Bispo= new Bispo(destino, 7);
                }
                else if(x==2){
                    Peca Torre= new Torre (destino,3);
                }
                else if(x==3){
                    Peca Cavalo= new Cavalo (destino, 5);
                } else{
                    x=JOptionPane.showOptionDialog(null, "Escolha uma peça para troca:",
                    "O peão foi promovido",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                        if(x==0){
                       Peca Rainha = new Rainha(destino, 9);
                    }
                    else if(x==1){
                        Peca Bispo= new Bispo(destino, 7);
                    }
                    else if(x==2){
                        Peca Torre= new Torre (destino,3);
                    }
                    else if(x==3){
                        Peca Cavalo= new Cavalo (destino, 5);
                    }
               }
            }while(x==JOptionPane.CLOSED_OPTION);  
         }    
            
        }
}
        
       
    
        
    
    

