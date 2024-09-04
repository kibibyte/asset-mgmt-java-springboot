package com.myapp.usecase;

final public class AssetMapper {

  public static Asset map(AssetEntity entity) {
    return Asset.builder()
        .id(entity.getId())
        .name(entity.getName())
        .description(entity.getDescription())
        .type(entity.getType())
        .build();
  }
}
