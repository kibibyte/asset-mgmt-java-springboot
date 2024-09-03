package com.myapp.usecase.asset.delete;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class DeleteAssetRepositoryImpl implements DeleteAssetRepository {

  private EntityManager entityManager;

  @Transactional
  public void delete(Long assetId) {
    entityManager.createQuery("DELETE FROM AssetEntity WHERE id = :assetId")
        .setParameter("assetId", assetId)
        .executeUpdate();
  }
}
