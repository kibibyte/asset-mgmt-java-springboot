package com.myapp.usecase.asset.browse;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.AssetEntity;
import com.myapp.usecase.asset.Asset;

import lombok.AllArgsConstructor;
import lombok.val;

@Repository
@AllArgsConstructor
class BrowseAssetRepositoryImpl implements BrowseAssetRepository {

  private EntityManager entityManager;

  @Override
  public Optional<Asset> find(Long assetId) {
    return Optional.ofNullable(entityManager.find(AssetEntity.class, assetId))
        .map(this::toAsset);
  }

  public List<Asset> findAll() {
    val assetEntities = entityManager.createQuery("SELECT a FROM AssetEntity a", AssetEntity.class)
        .getResultList();

    return assetEntities.stream()
        .map(this::toAsset)
        .collect(toList());
  }

  private Asset toAsset(AssetEntity assetEntity) {
    return new Asset(
        assetEntity.getId(),
        assetEntity.getName(),
        assetEntity.getType(),
        assetEntity.getDescription()
    );
  }
}
