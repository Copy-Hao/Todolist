package host.hehao.todo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by HeHao on 2020/11/18 15:50
 */
@Entity
@Table(name = "TbTodo")
@Data
public class TbUser {
    @Id
    @Column
    private Integer account;
    @Column
    private String username;
    @Column
    private String password;
}
