package com.myapp.usecase.asset;

import com.myapp.exceptions.EntityNotFoundException;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class AssetExceptions {

  public static EntityNotFoundException assetNotFound() {
    var assetNotFound = ErrorCodes.ASSET_NOT_FOUND;

    return new EntityNotFoundException(assetNotFound.name(), assetNotFound.getMessage());
  }

  @AllArgsConstructor
  @Getter
  public enum ErrorCodes {
    ASSET_NOT_FOUND("Asset not found");

    private final String message;
  }
}
