package com.myapp.usecase.asset.create;

import com.myapp.usecase.asset.Asset;

interface CreateAssetRepository {

  Asset create(NewAsset createAsset);
}
