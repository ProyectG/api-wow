package cl.vk.api.wow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePasswordDTO {

    private String username;
    private String oldPassword;
    private String newPassword;
    private String rNewPassword;
}
