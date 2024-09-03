package com.myapp.usecase.group.asset.add;

import com.myapp.DomainComponent;
import com.myapp.usecase.AssetRepository;
import com.myapp.usecase.GroupRepository;
import com.myapp.usecase.asset.AssetExceptions;
import com.myapp.usecase.group.GroupExceptions;

import lombok.AllArgsConstructor;

@DomainComponent
@AllArgsConstructor
public class AddAssetToGroupService {

  private final AssetRepository assetRepository;
  private final GroupRepository groupRepository;
  private final AddAssetToGroupRepository addAssetToGroupRepository;

  void add(Long groupId, Long assetId) {
    groupRepository.find(groupId)
        .orElseThrow(GroupExceptions::groupNotFound);

    assetRepository.find(assetId)
        .orElseThrow(AssetExceptions::assetNotFound);

    addAssetToGroupRepository.add(groupId, assetId);
  }
}
