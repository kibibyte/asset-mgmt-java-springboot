package com.myapp.usecase.group.create;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
class CreateGroupRequest {

  @NotEmpty
  String name;
  String description;
}
