import java.util.ArrayList;
/**
 * Write a description of class Bispo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bispo extends Peca
{
    
    /**
     * Constructor for objects of class Bispo
     */
    public Bispo(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
        super(casa, tipo, tabuleiro);
    }
    
    public void movimentos(int x, int y) {
        int i = x;
        int j = y;;
        // pega a diagonal direita-acima
        while(i < 8 && j < 8) {
            ++i;
            ++j;
            if (tabuleiro.getCasa(i, j) != null && tabuleiro.getCasa(i, j).possuiPeca() && capturar(tabuleiro.getCasa(i, j))) {
                // se a casa conter peça adversaria, ela tambem é adicionada ao ArrayList
                if (tabuleiro.getCasa(i, j).getTipoPeca()%2 != tipo%2){
                    casas.add(tabuleiro.getCasa(i, j));
                }
                break;
            }
            else if (tabuleiro.getCasa(i, j) != null && tabuleiro.getCasa(i, j).possuiPeca() == false) {
                casas.add(tabuleiro.getCasa(i, j));                  
            }
            else {
                break;
            }
        }
        // reseta os valores das coordenadas de verificação para os valores das coordenadas da origem 
        i = x;
        j = y;
        // pega a diagonal esquerda-acima 
        while(i >= 0 && j < 8) {
            --i;
            ++j;
            if(tabuleiro.getCasa(i, j) != null && tabuleiro.getCasa(i, j).possuiPeca() &&  capturar(tabuleiro.getCasa(i, j))) {
                // se a casa conter peça adversaria, ela tambem é adicionada ao ArrayList
                if (tabuleiro.getCasa(i, j).getTipoPeca()%2 != tipo%2){
                    casas.add(tabuleiro.getCasa(i, j));
                }
                break;
            }
            else if (tabuleiro.getCasa(i, j) != null && tabuleiro.getCasa(i, j).possuiPeca() == false) {
                casas.add(tabuleiro.getCasa(i, j));                  
            }
            else {
                break;
            }
        }
        // reseta os valores das coordenadas de verificação para os valores das coordenadas da origem 
        i = x;
        j = y;
        // pega a diagonal direita-abaixo
        while(i < 8 && j >= 0) {
            ++i;
            --j;
            if (tabuleiro.getCasa(i, j) != null && tabuleiro.getCasa(i, j).possuiPeca() && capturar(tabuleiro.getCasa(i, j))) {
                // se a casa conter peça adversaria, ela tambem é adicionada ao ArrayList
                if (tabuleiro.getCasa(i, j).getTipoPeca()%2 != tipo%2){
                    casas.add(tabuleiro.getCasa(i, j));
                }
                break;
            }
            else if (tabuleiro.getCasa(i, j) != null && tabuleiro.getCasa(i, j).possuiPeca() == false) {
                casas.add(tabuleiro.getCasa(i, j));                  
            }
            else {
                break;
            }
        }
        // reseta os valores das coordenadas de verificação para os valores das coordenadas da origem 
        i = x;
        j = y;
        // pega a diagonal esquerda-abaixo
        while(i >= 0 && j >= 0) {
            --i;
            --j;
            if (tabuleiro.getCasa(i, j) != null && tabuleiro.getCasa(i, j).possuiPeca() &&  capturar(tabuleiro.getCasa(i, j))) {
                // se a casa conter peça adversaria, ela tambem é adicionada ao ArrayList
                if (tabuleiro.getCasa(i, j).getTipoPeca()%2 != tipo%2){
                    casas.add(tabuleiro.getCasa(i, j));
                } 
                break;
            }
            else if (tabuleiro.getCasa(i, j) != null && tabuleiro.getCasa(i, j).possuiPeca() == false) {
                casas.add(tabuleiro.getCasa(i, j));                  
            }
            else {
                break;
            }
        }
    }
    
    public void mover(Casa destino) {
        super.mover(destino);
    }
}


    

