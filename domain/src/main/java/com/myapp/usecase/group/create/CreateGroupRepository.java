package com.myapp.usecase.group.create;

import com.myapp.usecase.group.Group;

interface CreateGroupRepository {

  Group create(NewGroup newGroup);
}
