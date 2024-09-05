package com.myapp.usecase;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import com.myapp.usecase.asset.AssetType;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Asset {

  Long id;
  String name;
  String description;
  AssetType type;

  public Optional<String> getDescription() {
    return ofNullable(description);
  }
}
