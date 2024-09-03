package com.myapp.usecase.group.asset.delete;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class DeleteAssetFromGroupController {

  private final DeleteAssetFromGroupService service;

  @DeleteMapping("/groups/{groupId}/assets/{assetId}")
  @ResponseStatus(OK)
  void deleteAssetFromGroup(@PathVariable Long groupId, @PathVariable Long assetId) {
    service.delete(groupId, assetId);
  }
}
