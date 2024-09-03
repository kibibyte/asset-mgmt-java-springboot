--Asset
INSERT INTO asset (name, description, type) VALUES ('Asset 1', 'Video asset description', 'VIDEO');
INSERT INTO asset (name, description, type) VALUES ('Asset 2', 'Video asset description', 'VIDEO');
INSERT INTO asset (name, description, type) VALUES ('Asset 3', 'Image asset description', 'IMAGE');
INSERT INTO asset (name, description, type) VALUES ('Asset 4', 'Image asset description', 'IMAGE');
--Asset groups
INSERT INTO asset_group (name, description) VALUES ('Video Group', 'Video assets');
INSERT INTO asset_group (name, description) VALUES ('Image Group', 'Image assets');
INSERT INTO asset_group (name, description) VALUES ('Other Group', 'Other assets');
--Asset groups join table
INSERT INTO group_has_asset (group_id, asset_id) VALUES (1, 1);
INSERT INTO group_has_asset (group_id, asset_id) VALUES (1, 2);
INSERT INTO group_has_asset (group_id, asset_id) VALUES (2, 3);
INSERT INTO group_has_asset (group_id, asset_id) VALUES (2, 4);
