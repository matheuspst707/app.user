package com.sea.sistemy.app.user.DTO;

import com.sea.sistemy.app.user.model.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDTO {

    private String id;

    @NotBlank(message = "Username cannot be blank")
    private String loguin;

    public UserDTO() {}

    public UserDTO(String id, String loguin) {
        this.id = id;
        this.loguin = loguin;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.loguin = user.getUsername();
    }

    public static List<UserDTO> fromUsers(List<User> users) {
        return users.stream()
                    .map(UserDTO::new)
                    .collect(Collectors.toList());
    }
}
