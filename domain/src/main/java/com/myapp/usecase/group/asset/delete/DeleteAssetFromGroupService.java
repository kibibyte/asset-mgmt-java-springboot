package com.myapp.usecase.group.asset.delete;

import com.myapp.DomainComponent;
import com.myapp.usecase.AssetRepository;
import com.myapp.usecase.asset.AssetExceptions;
import com.myapp.usecase.group.GroupExceptions;
import com.myapp.usecase.group.GroupRepository;

import lombok.AllArgsConstructor;

@DomainComponent
@AllArgsConstructor
public class DeleteAssetFromGroupService {

  private final AssetRepository assetRepository;
  private final GroupRepository groupRepository;
  private final DeleteAssetFromGroupRepository deleteAssetFromGroupRepository;

  void delete(Long groupId, Long assetId) {
    groupRepository.find(groupId)
        .orElseThrow(GroupExceptions::groupNotFound);

    assetRepository.find(assetId)
        .orElseThrow(AssetExceptions::assetNotFound);

    deleteAssetFromGroupRepository.delete(groupId, assetId);
  }
}
