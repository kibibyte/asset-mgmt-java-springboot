package com.myapp.usecase.group.asset.browse;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.Asset;
import com.myapp.usecase.AssetMapper;
import com.myapp.usecase.GroupEntity;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class BrowseGroupAssetRepositoryImpl implements BrowseGroupAssetRepository {

  private EntityManager entityManager;

  @Override
  public List<Asset> findAll(Long groupId) {
    return findGroup(groupId)
        .map(GroupEntity::getAssets)
        .map(assets -> assets.stream().map(AssetMapper::map))
        .map(Stream::toList)
        .orElse(emptyList());
  }

  private Optional<GroupEntity> findGroup(Long groupId) {
    return ofNullable(entityManager.find(GroupEntity.class, groupId));
  }
}
