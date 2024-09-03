package com.myapp.usecase.group.create;

import static com.myapp.usecase.asset.AssetExceptions.invalidArgument;
import static org.apache.commons.lang3.StringUtils.isBlank;

import lombok.Value;

@Value
class NewGroup {

  String name;
  String description;

  public NewGroup(String name, String description) {
    if (isBlank(name)) {
      throw invalidArgument();
    }

    this.name = name;
    this.description = description;
  }
}
