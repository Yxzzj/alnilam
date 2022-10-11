package pres.jeremy.alnilam.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class LoginParam {

    private String userName;

    private String password;
}
