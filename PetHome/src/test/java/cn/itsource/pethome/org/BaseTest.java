package cn.itsource.pethome.org;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class BaseTest {
    @Test
    public void test(){
        System.out.println("/group1/M00/00/32/wKgABF8JWQyAa1spAAEwuZ9CYHo719.jpg");
        String file = "/group1/M00/00/32/wKgABF8JWQyAa1spAAEwuZ9CYHo719.jpg";
        String[] split = file.split("/");
        System.out.println(split[1]);
        System.out.println(split[2]+"/"+split[3]+"/"+split[4]+"/"+split[5]);
        System.out.println(split[3]);
        System.out.println(split[4]);
        System.out.println(split[5]);
    }

}
