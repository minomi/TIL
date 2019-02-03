package me.minomi.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
//value = "port=8080",
properties = {"server.port=8080", "server.protocol=tcp"},  //value 랑 같이 쓰면 에러
webEnvironment = SpringBootTest.WebEnvironment.MOCK) // 애플리케이션이 실행될 때 웹 환경
public class DemoApplicationTests {

    @Value("${server.port}")
    Integer port;

    @Value("${server.protocol}")
    String protocol;

    @Test
    public void contextLoads() {
        assertThat(port, is(8080));
        assertThat(protocol, is("tcp"));
    }
}