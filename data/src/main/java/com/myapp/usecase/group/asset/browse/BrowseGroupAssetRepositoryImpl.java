package com.myapp.usecase.group.asset.browse;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.Asset;
import com.myapp.usecase.GroupEntity;

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
        .map(assetEntity -> {
              return Asset.builder()
                  .id(assetEntity.getId())
                  .name(assetEntity.getName())
                  .description(assetEntity.getDescription())
                  .type(assetEntity.getType())
                  .build();
            }
        ).collect(toList());
  }
}
