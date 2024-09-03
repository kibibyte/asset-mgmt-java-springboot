package com.myapp.usecase.asset.update;

interface UpdateAssetRepository {

  void update(Long assetId, UpdatedAsset updatedAsset);
}
