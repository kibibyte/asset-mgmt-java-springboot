package com.myapp.usecase;

import com.myapp.usecase.group.Group;

final public class GroupMapper {

  public static Group map(GroupEntity entity) {
    return Group.builder()
        .id(entity.getId())
        .name(entity.getName())
        .description(entity.getDescription())
        .build();
  }
}
