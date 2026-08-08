package com.authservice.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends ResponseDTO{
    Long id;
    String username;
    String role;
    boolean enabled;
}
