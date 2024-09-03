package com.myapp.usecase.asset.create;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.myapp.usecase.asset.AssetType;

import lombok.Value;

@Value
class CreateAssetRequest {

  @NotEmpty
  String name;
  String description;
  @NotNull
  AssetType type;
}
