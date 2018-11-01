
/**
 * Write a description of class Rainha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rainha extends Peca

{
    
        /**
     * Constructor for objects of class Rainha
     */
    public Rainha(Casa casa, int tipo, Tabuleiro tabuleiro)
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
        
        // movimentos laterais e verticais
        // vasculhar as casas a esquerda
        for (int k = x-1; k >= 0; k--) {
            if (tabuleiro.getCasa(k, y) != null) {
                if (tabuleiro.getCasa(k, y).possuiPeca() && capturar(tabuleiro.getCasa(k, y))) {
                    casas.add(tabuleiro.getCasa(k, y));  
                    break;
                }
                else if (tabuleiro.getCasa(k, y).possuiPeca() && capturar(tabuleiro.getCasa(k, y)) == false){
                    break;
                }
                casas.add(tabuleiro.getCasa(k, y));
            }
        }
        // vasculhar as casas a direita
        for (int k = x+1; k < 8; k++) {
            if(tabuleiro.getCasa(k, y) != null) {
                if (tabuleiro.getCasa(k, y).possuiPeca() && capturar(tabuleiro.getCasa(k, y))) {
                    casas.add(tabuleiro.getCasa(k, y));  
                    break;
                }
                else if (tabuleiro.getCasa(k, y).possuiPeca() && capturar(tabuleiro.getCasa(k, y)) == false){
                    break;
                }
                casas.add(tabuleiro.getCasa(k, y));
            }
        }
        // vasculhar as casas acima 
        for (int k = y-1; k >= 0; k--) {
            if (tabuleiro.getCasa(x, k) != null) {
                if  (tabuleiro.getCasa(x, k).possuiPeca() && capturar(tabuleiro.getCasa(x, k))) {
                    casas.add(tabuleiro.getCasa(x, k));  
                    break;
                }
                else if (tabuleiro.getCasa(x, k).possuiPeca() && capturar(tabuleiro.getCasa(x, k)) == false){
                    break;
                }
                casas.add(tabuleiro.getCasa(x, k));  
            }
        }
        // vasculhar as casas abaixo
        for (int k = y+1; k < 8; k++) {
            if (tabuleiro.getCasa(x, k) != null) {
                if (tabuleiro.getCasa(x, k).possuiPeca() && capturar(tabuleiro.getCasa(x, k))) {
                    casas.add(tabuleiro.getCasa(x, k));  
                    break;
                }
                else if (tabuleiro.getCasa(x, k).possuiPeca() && capturar(tabuleiro.getCasa(x, k)) == false){
                    break;
                }
                casas.add(tabuleiro.getCasa(x, k));
            }
        }
    }
    
    public void mover(Casa destino){
        super.mover(destino);
    }
}

