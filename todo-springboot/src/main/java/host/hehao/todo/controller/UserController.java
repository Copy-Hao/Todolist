package host.hehao.todo.controller;

import host.hehao.todo.entity.TbUser;
import host.hehao.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by HeHao on 2020/11/18 15:53
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/Login/findUser/{account}")
    public TbUser findUser(@PathVariable("account") Integer account) {
        return userRepository.findById(account).get();
    }

    @PostMapping("/Signin/addUser")
    public String addUser(@RequestBody TbUser tbUser) {
        TbUser save = userRepository.save(tbUser);
        if (save != null)
            return "success";
        return "error";
    }
}
