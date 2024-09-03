package com.myapp.usecase.group.asset.delete;

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
    //TODO: handle not found asset/group entities
    final var groupEntity = entityManager.find(GroupEntity.class, groupId);
    final var assetEntity = entityManager.find(AssetEntity.class, assetId);

    groupEntity.getAssets().remove(assetEntity);
  }
}
