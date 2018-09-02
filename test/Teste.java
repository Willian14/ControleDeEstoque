
import br.com.willian.Dao.CategoriaDao;
import br.com.willian.entity.Categoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Willian
 */
public class Teste {
    public static void main(String[] args) {
          CategoriaDao catDao = new CategoriaDao();
          Categoria c = new Categoria(1, "Calça jeans masculinas");
          catDao.alterar(c);
        
        
       // System.out.println(build.length());
       // build.deleteCharAt(build.length() -3);
       // System.out.println(build.toString());
      
        
        
        /*
        if(posPonto > 0 && posVirgula > 0){
            builderStr.deleteCharAt(posPonto);
        }
        String novaStr = builderStr.toString();
        String preco = novaStr.replace(",", ".");
         System.out.println(str);
         System.out.println(builderStr);
        System.out.println(novaStr);
        System.out.println(preco);
       
        System.out.printf("%d %d", posPonto,posVirgula);
*/
    }
}
