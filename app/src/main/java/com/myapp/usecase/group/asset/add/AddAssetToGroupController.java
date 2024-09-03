package com.myapp.usecase.group.asset.add;

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
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class AddAssetToGroupController {

  private final AddAssetToGroupService service;

  @PutMapping("/groups/{groupId}/assets")
  @ResponseStatus(OK)
  void addAssetToGroup(@PathVariable Long groupId, @RequestBody @Valid AddAssetToGroupRequest request) {
    service.add(groupId, request.getAssetId());
  }
}
