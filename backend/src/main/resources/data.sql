

INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'TEST', 'User', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'user');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'TEST', 'Admin', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);
 


INSERT INTO  `status_master` (`id`, `status_code`, `status_description`) VALUES ('1', 'NEW', 'New');
INSERT INTO `status_master` (`id`, `status_code`, `status_description`) VALUES ('2', 'STARTED', 'Started');
INSERT INTO `status_master` (`id`, `status_code`, `status_description`) VALUES ('3', 'COMPLETED', 'Completed');



