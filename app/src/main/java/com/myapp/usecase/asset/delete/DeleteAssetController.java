package com.myapp.usecase.asset.delete;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class DeleteAssetController {

  private final DeleteAssetService deleteAssetService;

  @DeleteMapping("/assets/{assetId}")
  @ResponseStatus(OK)
  void deleteAsset(@PathVariable Long assetId) {
    deleteAssetService.delete(assetId);
  }
}
