package com.myapp.usecase.asset.delete;

import com.myapp.DomainComponent;
import com.myapp.usecase.AssetRepository;
import com.myapp.usecase.asset.AssetExceptions;

import lombok.AllArgsConstructor;

@DomainComponent
@AllArgsConstructor
public class DeleteAssetService {

  private final AssetRepository assetRepository;
  private final DeleteAssetRepository deleteAssetRepository;

  void delete(Long assetId) {
    assetRepository.find(assetId)
        .orElseThrow(AssetExceptions::assetNotFound);

    deleteAssetRepository.delete(assetId);
  }
}
