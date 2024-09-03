package com.myapp.usecase.group.browse;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GroupResponse {

  String name;
  String description;
}
