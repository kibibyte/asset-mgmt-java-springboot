package com.myapp.usecase.asset.create;

import static com.myapp.usecase.asset.AssetExceptions.invalidArgument;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.Optional;

import com.myapp.usecase.asset.AssetType;

import lombok.Value;

@Value
class NewAsset {

  String name;
  String description;
  AssetType type;

  public NewAsset(String name, String description, AssetType type) {
    if (isBlank(name)) {
      throw invalidArgument();
    }
    if (type == null) {
      throw invalidArgument();
    }

    this.name = name;
    this.description = description;
    this.type = type;
  }

  public Optional<String> getDescription() {
    return ofNullable(description);
  }
}
