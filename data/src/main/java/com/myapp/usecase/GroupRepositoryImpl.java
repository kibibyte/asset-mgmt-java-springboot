package com.myapp.usecase;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.group.Group;
import com.myapp.usecase.group.GroupRepository;

import lombok.AllArgsConstructor;
import lombok.val;

@Repository
@AllArgsConstructor
class GroupRepositoryImpl implements GroupRepository {

  private EntityManager entityManager;

  @Override
  public Optional<Group> find(Long groupId) {
    return ofNullable(entityManager.find(GroupEntity.class, groupId))
        .map(GroupMapper::map);
  }

  public List<Group> findAll() {
    val groups = entityManager.createQuery("SELECT g FROM GroupEntity g", GroupEntity.class)
        .getResultList();

    return groups.stream()
        .map(GroupMapper::map)
        .collect(toList());
  }
}

