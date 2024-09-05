package com.myapp.usecase.group.asset.delete;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.AssetEntity;
import com.myapp.usecase.GroupEntity;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class DeleteAssetFromGroupRepositoryImpl implements DeleteAssetFromGroupRepository {

  private EntityManager entityManager;

  @Override
  @Transactional
  public void delete(Long groupId, Long assetId) {
    findGroup(groupId).ifPresent(groupEntity -> {
      findAsset(assetId).ifPresent(assetEntity -> {
            groupEntity.getAssets().remove(assetEntity);
          }
      );
    });
  }

  public Optional<GroupEntity> findGroup(Long groupId) {
    return ofNullable(entityManager.find(GroupEntity.class, groupId));
  }

  public Optional<AssetEntity> findAsset(Long assetId) {
    return ofNullable(entityManager.find(AssetEntity.class, assetId));
  }
}
