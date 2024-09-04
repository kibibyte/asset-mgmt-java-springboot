package com.myapp.usecase;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.val;

@Repository
@AllArgsConstructor
public class AssetRepositoryImpl implements AssetRepository {

  private EntityManager entityManager;

  @Override
  public Optional<Asset> find(Long assetId) {
    return Optional.ofNullable(entityManager.find(AssetEntity.class, assetId))
        .map(AssetMapper::map);
  }

  public List<Asset> findAll() {
    val assetEntities = entityManager.createQuery("SELECT a FROM AssetEntity a", AssetEntity.class)
        .getResultList();

    return assetEntities.stream()
        .map(AssetMapper::map)
        .collect(toList());
  }
}
