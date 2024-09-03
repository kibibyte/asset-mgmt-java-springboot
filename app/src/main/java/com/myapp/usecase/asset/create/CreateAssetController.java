package com.myapp.usecase.asset.create;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.usecase.AssetResponse;
import com.myapp.usecase.AssetResponse.AssetResponseBuilder;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class CreateAssetController {

  private final CreateAssetRepository repository;
  private final ModelMapper mapper;

  @PostMapping("/assets")
  @ResponseStatus(CREATED)
  AssetResponse createAsset(@RequestBody @Valid CreateAssetRequest request) {
    final var newAsset = repository.create(new NewAsset(
        request.getName(),
        request.getDescription(),
        request.getType()
    ));

    return mapper.map(newAsset, AssetResponseBuilder.class)
        .build();
  }
}
