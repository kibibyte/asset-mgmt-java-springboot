package com.myapp.usecase.group.browse;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.GroupEntity;
import com.myapp.usecase.group.Group;

import lombok.AllArgsConstructor;
import lombok.val;

@Repository
@AllArgsConstructor
class BrowseGroupRepositoryImpl implements BrowseGroupRepository {

  private EntityManager entityManager;

  public List<Group> findAll() {
    val groups = entityManager.createQuery("SELECT g FROM GroupEntity g", GroupEntity.class)
        .getResultList();

    return groups.stream().map(
        assetEntity -> new Group(
            assetEntity.getName(),
            assetEntity.getDescription())
    ).collect(toList());
  }
}
