package com.myapp.usecase.group.asset.browse;

import java.util.List;

import com.myapp.DomainComponent;
import com.myapp.usecase.Asset;
import com.myapp.usecase.group.GroupExceptions;
import com.myapp.usecase.group.GroupRepository;

import lombok.AllArgsConstructor;

@DomainComponent
@AllArgsConstructor
public class BrowseGroupAssetService {

  private final GroupRepository groupRepository;
  private final BrowseGroupAssetRepository browseGroupAssetRepository;

  List<Asset> findAll(Long groupId) {
    groupRepository.find(groupId)
        .orElseThrow(GroupExceptions::groupNotFound);

    return browseGroupAssetRepository.findAll(groupId);
  }
}
