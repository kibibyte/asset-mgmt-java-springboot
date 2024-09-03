package com.myapp.usecase.asset.update;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class UpdateAssetController {

  private final UpdateAssetService service;

  @PutMapping("/assets/{assetId}")
  @ResponseStatus(OK)
  void updateAsset(@PathVariable Long assetId, @RequestBody @Valid UpdateAssetRequest request) {
    service.update(assetId, new UpdatedAsset(
        request.getName(),
        request.getDescription()
    ));
  }
}
