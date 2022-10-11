package pres.jeremy.alnilam.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class UserDTO {

    private Integer id;

    private String userName;

    private String name;

    private String permission;

    private String role;
}
