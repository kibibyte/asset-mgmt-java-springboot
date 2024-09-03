package com.myapp.usecase;

import java.util.List;
import java.util.Optional;

import com.myapp.usecase.asset.Asset;

public interface AssetRepository {

  Optional<Asset> find(Long assetId);

  List<Asset> findAll();
}
