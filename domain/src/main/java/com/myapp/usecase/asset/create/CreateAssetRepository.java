package com.myapp.usecase.asset.create;

import com.myapp.usecase.Asset;

interface CreateAssetRepository {

  Asset create(NewAsset newAsset);
}
