package org.example.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDTO {

    @NotEmpty
    String username;

    @Min(5)
    String password;

    @NotEmpty
    String typeOfUser;

}
