package com.myapp.usecase;

import java.util.List;
import java.util.Optional;

public interface AssetRepository {

  Optional<Asset> find(Long assetId);

  List<Asset> findAll();
}
