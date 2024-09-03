package com.myapp.usecase.asset;

import com.myapp.exceptions.EntityNotFoundException;
import com.myapp.exceptions.InvalidArgumentException;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class AssetExceptions {

  public static EntityNotFoundException assetNotFound() {
    var assetNotFound = ErrorCodes.ASSET_NOT_FOUND;

    return new EntityNotFoundException(assetNotFound.name(), assetNotFound.getMessage());
  }

  public static InvalidArgumentException invalidArgument() {
    var assetNotFound = ErrorCodes.INVALID_ARGUMENT;

    return new InvalidArgumentException(assetNotFound.name(), assetNotFound.getMessage());
  }

  @AllArgsConstructor
  @Getter
  public enum ErrorCodes {
    ASSET_NOT_FOUND("Asset not found"),
    INVALID_ARGUMENT("Invalid argument");

    private final String message;
  }
}
