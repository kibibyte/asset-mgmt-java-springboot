package com.myapp.usecase.group.asset.browse;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.GroupEntity;
import com.myapp.usecase.asset.Asset;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class BrowseGroupAssetRepositoryImpl implements BrowseGroupAssetRepository {

  private EntityManager entityManager;

  @Override
  public List<Asset> findAll(Long groupId) {
    //TODO: handle not found entity
    return entityManager.find(GroupEntity.class, groupId)
        .getAssets()
        .stream()
        .map(assetEntity -> new Asset(
                assetEntity.getId(),
                assetEntity.getName(),
                assetEntity.getType(),
                assetEntity.getDescription()
            )
        ).collect(toList());
  }
}
