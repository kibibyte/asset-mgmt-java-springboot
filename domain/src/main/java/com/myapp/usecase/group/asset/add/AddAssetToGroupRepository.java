package com.myapp.usecase.group.asset.add;

interface AddAssetToGroupRepository {

  void add(Long groupId, Long assetId);
}
