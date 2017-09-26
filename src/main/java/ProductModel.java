import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductModel {

    public List<Product> findAll(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Product> result = new ArrayList<Product>();

        result.add(new Product("p1" , "Name 1" , 1000 , 4 , new Date()));
        result.add(new Product("p2" , "Name 2" , 2000 , 1 , new Date()));
        result.add(new Product("p3" , "Name 3" , 3000 , 2 , new Date()));
        result.add(new Product("p4" , "Name 4" , 4000 , 3 , new Date()));
        result.add(new Product("p5" , "Name 5" , 5000 , 5 , new Date()));

        return result;

    }

}
