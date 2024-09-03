package com.myapp.usecase.asset;

import lombok.Value;

@Value
public class Asset {

  String name;
  AssetType type;
  String description;
}
