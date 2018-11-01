import java.util.ArrayList;
/**
 * Classe abstrata Movimentacao - escreva a descrição da classe aqui
 * 
 * @author (seu nome aqui)
 * @version (versão ou data)
 */
public abstract class Movimentacao 
{
    private TabuleiroGUI tabuleiro;
    //private ArrayList<CasaGUI> casasGUI = new ArrayList<CasaGUI>();
    
    abstract public void movimentos(int x, int y);
    
    /*public void destacarCasas(ArrayList<Casa> casas) {
        for (Casa casa: casas) {
            int x = casa.getX();
            int y = casa.getY();
            
            casasGUI.add(tabuleiro.getCasaGUI(x, y));
        }
        
        for(CasaGUI casa: casasGUI) {
            casa.destacar();
        }
    }
    
    public void atenuarCasas() {
        for(CasaGUI casa: casasGUI) {
            casa.atenuar();
        }
    }
    
    public void xeque() {
    
    }
    */
}
