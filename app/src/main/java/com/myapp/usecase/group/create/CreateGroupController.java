package com.myapp.usecase.group.create;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.usecase.group.browse.GroupResponse;
import com.myapp.usecase.group.browse.GroupResponse.GroupResponseBuilder;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class CreateGroupController {

  private final CreateGroupRepository repository;
  private final ModelMapper mapper;

  @PostMapping("/groups")
  @ResponseStatus(CREATED)
  GroupResponse createGroup(@RequestBody @Valid CreateGroupRequest request) {
    final var newlyCreateGroup = repository.create(new NewGroup(
        request.getName(),
        request.getDescription()
    ));

    return mapper.map(newlyCreateGroup, GroupResponseBuilder.class).build();
  }
}
