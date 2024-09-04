package com.myapp.usecase.group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {

  Optional<Group> find(Long groupId);

  List<Group> findAll();
}
