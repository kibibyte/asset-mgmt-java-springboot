package com.myapp.usecase.group.asset.delete;

interface DeleteAssetFromGroupRepository {

  void delete(Long groupId, Long assetId);
}
