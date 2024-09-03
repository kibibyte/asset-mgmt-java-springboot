package com.myapp.usecase.asset.browse;

import com.myapp.usecase.asset.Asset;

import java.util.List;
import java.util.Optional;

interface BrowseAssetRepository {

  Optional<Asset> find(Long assetId);

  List<Asset> findAll();
}
