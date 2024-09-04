package com.myapp.usecase.group.create;

import javax.validation.constraints.NotEmpty;

import lombok.Value;

@Value
class CreateGroupRequest {

  @NotEmpty
  String name;
  String description;
}
