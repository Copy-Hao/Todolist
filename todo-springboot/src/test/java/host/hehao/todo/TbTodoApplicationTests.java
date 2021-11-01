package host.hehao.todo;

import host.hehao.todo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TbTodoApplicationTests {
    @Autowired
    UserRepository userRepository;
    @Test
    void contextLoads() {
        System.out.println(userRepository);
    }

}
