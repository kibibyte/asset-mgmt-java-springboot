package com.myapp.usecase.group.create;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.GroupEntity;
import com.myapp.usecase.group.Group;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class CreateGroupRepositoryImpl implements CreateGroupRepository {

  private EntityManager entityManager;

  @Transactional
  public Group create(NewGroup newGroup) {
    final var newGroupEntity = new GroupEntity();
    newGroupEntity.setName(newGroup.getName());
    newGroupEntity.setDescription(newGroup.getDescription());

    entityManager.persist(newGroupEntity);

    return new Group(
        newGroupEntity.getId(),
        newGroupEntity.getName(),
        newGroupEntity.getDescription()
    );
  }
}
