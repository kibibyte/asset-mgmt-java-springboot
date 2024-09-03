package com.myapp.usecase.group;

import com.myapp.exceptions.EntityNotFoundException;
import com.myapp.exceptions.InvalidArgumentException;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class GroupExceptions {

  public static EntityNotFoundException groupNotFound() {
    var assetNotFound = ErrorCodes.GROUP_NOT_FOUND;

    return new EntityNotFoundException(assetNotFound.name(), assetNotFound.getMessage());
  }

  public static InvalidArgumentException invalidArgument() {
    var assetNotFound = ErrorCodes.INVALID_ARGUMENT;

    return new InvalidArgumentException(assetNotFound.name(), assetNotFound.getMessage());
  }

  @AllArgsConstructor
  @Getter
  public enum ErrorCodes {
    GROUP_NOT_FOUND("Group not found"),
    INVALID_ARGUMENT("Invalid argument");

    private final String message;
  }
}
