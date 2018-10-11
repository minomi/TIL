import dto.Student;
import org.springframework.context.support.GenericXmlApplicationContext;
import service.InsertService;
import service.SelectService;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 11..
 */
public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext("classpath:applicationContext.xml");
        SelectService selectService = context.getBean("selectService", SelectService.class);
        InsertService insertService = context.getBean("insertService", InsertService.class);

        insertService.insert(new Student("id1", "name1"));
        insertService.insert(new Student("id2", "name2"));
        insertService.insert(new Student("id3", "name3"));
        insertService.insert(new Student("id4", "name4"));

        System.out.println("id1 student : " + selectService.selectById("id1"));
        System.out.println("------------------------");
        System.out.println("All Students");
        selectService.selectAll().forEach(System.out::println);
    }
}
