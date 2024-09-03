package com.myapp.usecase.asset.create;

import org.apache.commons.lang3.StringUtils;

import com.myapp.usecase.asset.AssetExceptions;
import com.myapp.usecase.asset.AssetType;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
class NewAsset {

  String name;
  String description;
  AssetType type;

  public NewAsset(String name, String description, AssetType type) {
    if (StringUtils.isBlank(name)) {
      throw AssetExceptions.invalidArgument();
    }
    if (type == null) {
      throw AssetExceptions.invalidArgument();
    }

    this.name = name;
    this.description = description;
    this.type = type;
  }
}
