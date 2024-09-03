package com.myapp.usecase;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.myapp.usecase.asset.AssetType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "asset")
@NoArgsConstructor
@Getter
@Setter
public class AssetEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String name;

  String description;

  @Enumerated(EnumType.STRING)
  AssetType type;

  @ManyToMany(mappedBy = "assets")
  Set<GroupEntity> groups = new HashSet<>();
}
