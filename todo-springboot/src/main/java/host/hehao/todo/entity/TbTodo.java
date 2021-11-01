package host.hehao.todo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by HeHao on 2020/11/18 21:26
 */
@Entity
@Table(name = "TbTodo")
@Data
public class TbTodo {
    @Id
    //mysql
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //oracle
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRTBTODO")
    @SequenceGenerator(name = "TbTodo", initialValue = 1, allocationSize = 1, sequenceName = "SEQTODO")
    private Integer id;
    @Column
    private Integer account;
    @Column
    private String todoname;
    @Column
    private String status;
}
