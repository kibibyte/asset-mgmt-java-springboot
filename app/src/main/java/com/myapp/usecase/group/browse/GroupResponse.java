package com.myapp.usecase.group.browse;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GroupResponse {

  Long id;
  String name;
  String description;
}
