package com.myapp.usecase.asset.browse;

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

import com.myapp.usecase.Asset;
import com.myapp.usecase.AssetRepository;
import com.myapp.usecase.AssetResponse;
import com.myapp.usecase.AssetResponse.AssetResponseBuilder;
import com.myapp.usecase.asset.AssetExceptions;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class BrowseAssetController {

  private final AssetRepository repository;
  private final ModelMapper modelMapper;

  @GetMapping("/assets")
  @ResponseStatus(OK)
  List<AssetResponse> findAll() {
    final var assets = repository.findAll();

    return assets.stream()
        .map(this::toResponse)
        .collect(toList());
  }

  @GetMapping("/assets/{assetId}")
  @ResponseStatus(OK)
  AssetResponse find(@PathVariable Long assetId) {
    final var asset = repository.find(assetId)
        .orElseThrow(AssetExceptions::assetNotFound);

    return toResponse(asset);
  }

  private AssetResponse toResponse(Asset asset) {
    return modelMapper.map(asset, AssetResponseBuilder.class).build();
  }
}
