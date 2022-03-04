package com.microservice.user.userDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

        private String name;
        private Date DOB;
        private long voterId;

}
