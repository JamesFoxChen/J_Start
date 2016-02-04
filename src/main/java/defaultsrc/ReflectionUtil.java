package defaultsrc;
/**
 * Created by Administrator on 2015/5/6.
 */
import bean.*;
public class ReflectionUtil {

    public  void Entrance()
    {
        PrintClassName();
    }

    private  void PrintClassName()
    {
        System.out.println("胜多负少" + this.getClass().getName());

        Class<?> demo=null;
        try{
            demo=Class.forName("bean.Person");
        }catch (Exception e) {
            e.printStackTrace();
        }

        Person per=null;
        try {
            per=(Person)demo.newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        per.setName("Rollen");
        per.setAge(20);

        System.out.println("Person水电费");
        System.out.println(per);
    }
}
