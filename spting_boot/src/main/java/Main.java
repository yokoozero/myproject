import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.UnsupportedEncodingException;

/**
 * Created by wb.zhengcheng on 2017/8/14.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.boot")   //扫描该包路径下的所有spring组件
@EnableJpaRepositories("com.boot.dao")      //JPA扫描该包路径下的JpaRepository
@EntityScan("com.boot.entity")              //扫描实体类
@EnableScheduling                           //开启定时器
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(Main.class, args);
    }
}
