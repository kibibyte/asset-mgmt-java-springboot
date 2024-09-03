package com.myapp.usecase.asset.update;

import javax.validation.constraints.NotEmpty;

import lombok.Value;

@Value
class UpdateAssetRequest {

  @NotEmpty
  String name;
  String description;
}
