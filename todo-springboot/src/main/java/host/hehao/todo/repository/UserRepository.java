package host.hehao.todo.repository;

import host.hehao.todo.entity.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HeHao on 2020/11/18 15:54
 */
public interface UserRepository extends JpaRepository<TbUser, Integer> {
}
