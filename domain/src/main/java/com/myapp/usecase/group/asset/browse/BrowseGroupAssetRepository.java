package com.myapp.usecase.group.asset.browse;

import java.util.List;

import com.myapp.usecase.Asset;

interface BrowseGroupAssetRepository {

  List<Asset> findAll(Long groupId);
}
