package host.hehao.todo.controller;

import host.hehao.todo.entity.TbTodo;
import host.hehao.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by HeHao on 2020/11/18 21:26
 */
@RestController
public class TodolistController {
    @Autowired
    TodoRepository todoRepository;

    @GetMapping("Todo/findTodos/{account}")
    public List<TbTodo> findTodos(@PathVariable("account") Integer account) {
        return todoRepository.findAllByAccount(account);
    }

    @PostMapping("Todo/addItem")
    public TbTodo addItem(@RequestBody TbTodo tbTodo) {
        TbTodo save = todoRepository.save(tbTodo);
        if (save != null)
            return save;
        return null;
    }

    @DeleteMapping("Todo/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        todoRepository.deleteById(id);
    }

    @PutMapping("Todo/save")
    public String save(@RequestBody TbTodo tbTodo) {
        TbTodo save = todoRepository.save(tbTodo);
        if (save != null)
            return "success";
        return "error";
    }

}
