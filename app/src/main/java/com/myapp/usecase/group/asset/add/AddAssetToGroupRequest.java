package com.myapp.usecase.group.asset.add;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
class AddAssetToGroupRequest {

  @NotNull
  Long assetId;
}
