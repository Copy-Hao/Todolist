package host.hehao.todo.repository;

import host.hehao.todo.entity.TbTodo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by HeHao on 2020/11/18 21:29
 */
public interface TodoRepository extends JpaRepository<TbTodo, Integer> {
    List<TbTodo> findAllByAccount(Integer account);
    void deleteTodoByTodonameAndAccount(String todoname,Integer account);
}
