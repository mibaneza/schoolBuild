package com.school.service.util.napper;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.school.dto.UserDto;
import com.school.entity.User;

@Component("usermapper")
public class UserMapper {
	/*public static List<UserDto> convertirList(List<User> users) {
		List<UserDto> userDto = new ArrayList<>();
		for (User user : users) {
			userDto.add(new UserDto(user));
		}
		return userDto;
	}
*/
}
