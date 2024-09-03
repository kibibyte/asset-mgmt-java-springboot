package com.myapp.usecase.group.browse;

import java.util.List;

import com.myapp.usecase.group.Group;

interface BrowseGroupRepository {

  List<Group> findAll();
}
