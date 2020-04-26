/**
 * @author : Rishab Khosla
 * @Date : ${DATE}
 * @Description : This project is commited in intial version
 * to start the basic handson in spring boot.Project contains constructor
 * creation and the jbdc mysql connection.

 **/

import com.javadevelopersguide.springboot.example.EmpController;
import com.javadevelopersguide.springboot.example.SpringBootJdbcController;
import org.springframework.boot.SpringApplication;

public class SpringBootApplicationLuncher {


    public static void main(String[] args) {


//        SpringApplication.run(SpringBootJdbcController.class, args);
        SpringApplication.run(EmpController.class, args);

    }
}



