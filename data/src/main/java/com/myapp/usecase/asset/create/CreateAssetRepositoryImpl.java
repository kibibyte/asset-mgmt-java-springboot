package com.myapp.usecase.asset.create;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.AssetEntity;
import com.myapp.usecase.asset.Asset;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class CreateAssetRepositoryImpl implements CreateAssetRepository {

  private EntityManager entityManager;

  @Transactional
  public Asset create(NewAsset newAsset) {
    final var assetEntity = new AssetEntity();
    assetEntity.setName(newAsset.getName());
    assetEntity.setDescription(newAsset.getDescription());
    assetEntity.setType(newAsset.getType());

    entityManager.persist(assetEntity);

    return new Asset(
        assetEntity.getId(),
        assetEntity.getName(),
        assetEntity.getType(),
        assetEntity.getDescription()
    );
  }
}
