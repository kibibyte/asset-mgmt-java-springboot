package com.myapp.usecase;

import java.util.List;
import java.util.Optional;

import com.myapp.usecase.group.Group;

public interface GroupRepository {

  Optional<Group> find(Long groupId);

  List<Group> findAll();
}
