package com.myapp.usecase.group.asset.browse;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.usecase.AssetResponse;
import com.myapp.usecase.AssetResponse.AssetResponseBuilder;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class BrowseGroupAssetController {

  private final BrowseGroupAssetRepository repository;
  private final ModelMapper modelMapper;

  @GetMapping("/groups/{groupId}/assets")
  @ResponseStatus(OK)
  List<AssetResponse> findAll(@PathVariable Long groupId) {
    final var assets = repository.findAll(groupId);

    return assets.stream()
        .map(asset -> modelMapper.map(asset, AssetResponseBuilder.class).build())
        .collect(toList());
  }
}
