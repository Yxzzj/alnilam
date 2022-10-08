package pres.jeremy.alnilam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@TableName("t_user")
public class User {

    private Integer id;

    private String userName;

    private String password;

    private String name;

    private String permission;

    private String role;
}
