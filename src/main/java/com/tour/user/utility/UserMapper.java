package com.tour.user.utility;

import com.tour.user.domain.entity.User;
import com.tour.user.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);

    @Mapping(target = "passwordHash", ignore = true)
    User userDTOToUser(UserDTO userDTO);
}
