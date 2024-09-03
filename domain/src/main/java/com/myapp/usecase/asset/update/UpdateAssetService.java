package com.myapp.usecase.asset.update;

import com.myapp.DomainComponent;
import com.myapp.usecase.AssetRepository;
import com.myapp.usecase.asset.AssetExceptions;

import lombok.AllArgsConstructor;

@DomainComponent
@AllArgsConstructor
public class UpdateAssetService {

  private final AssetRepository assetRepository;
  private final UpdateAssetRepository updateAssetRepository;

  void update(Long assetId, UpdatedAsset updatedAsset) {
    assetRepository.find(assetId)
        .orElseThrow(AssetExceptions::assetNotFound);

    updateAssetRepository.update(assetId, updatedAsset);
  }
}
