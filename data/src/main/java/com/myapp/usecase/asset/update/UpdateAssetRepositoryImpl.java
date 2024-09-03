package com.myapp.usecase.asset.update;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.AssetEntity;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class UpdateAssetRepositoryImpl implements UpdateAssetRepository {

  private EntityManager entityManager;

  @Transactional
  public void update(Long assetId, UpdatedAsset updatedAsset) {
    Optional.ofNullable(entityManager.find(AssetEntity.class, assetId))
        .ifPresent(assetEntity -> {
          assetEntity.setName(updatedAsset.getName());
          updatedAsset.getDescription()
              .ifPresent(assetEntity::setDescription);
          entityManager.merge(assetEntity);
        });
  }
}
