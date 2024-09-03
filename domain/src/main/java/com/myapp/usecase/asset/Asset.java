package com.myapp.usecase.asset;

import lombok.Value;

@Value
public class Asset {

  Long id;
  String name;
  AssetType type;
  String description;
}
