package com.myapp.usecase.group.browse;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.usecase.group.browse.GroupResponse.GroupResponseBuilder;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class BrowseGroupController {

  private final BrowseGroupRepository repository;
  private final ModelMapper modelMapper;

  @GetMapping("/groups")
  @ResponseStatus(OK)
  List<GroupResponse> findAll() {
    final var groups = repository.findAll();

    return groups.stream()
        .map(asset -> modelMapper.map(asset, GroupResponseBuilder.class).build())
        .collect(toList());
  }
}
