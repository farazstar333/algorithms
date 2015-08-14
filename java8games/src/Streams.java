import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
/**
 * Created by farazw808 on 6/27/15.
 * This example shows how to use streams
 */
public class Streams {


    public static void main(String args[]) {

        List<Dish> menuList = new ArrayList<>();
        menuList.add(new Dish("samosa", true));
        menuList.add(new Dish("chicken", false));
        menuList.add(new Dish("stake", false));
        menuList.add(new Dish("Veg-Briyani", true));
        menuList.add(new Dish("Chiken-Briyani", false));

        List<Dish> vegetableDish = menuList.stream().filter(Dish::isVegeterian).collect(toList());

        InputStream io = null;


        System.out.println(vegetableDish);
    }



    public static class Dish {

        String name;
        boolean isVegeterian ;

        public Dish(String name, boolean isVegeterian) {
            this.name = name;
            this.isVegeterian = isVegeterian;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isVegeterian() {
            return isVegeterian;
        }

        public void setVegeterian(boolean isVegeterian) {
            this.isVegeterian = isVegeterian;
        }
    }
}
