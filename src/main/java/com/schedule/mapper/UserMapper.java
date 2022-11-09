package com.schedule.mapper;

import com.schedule.domain.User;
import com.schedule.requests.UserPostRequestBody;
import com.schedule.requests.UserPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract User toUser(UserPostRequestBody animePostRequestBody);

    public abstract User toUser(UserPutRequestBody animePostRequestBody);
}
