-- ============================================================
-- RuoYi-Cloud database schema, derived from the upstream
-- yangzongzhuan/RuoYi-Cloud project (MIT licensed).
-- Apply with: mysql -uroot -p < ry-cloud.sql
-- ============================================================

DROP DATABASE IF EXISTS `ry-cloud`;
CREATE DATABASE `ry-cloud` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ry-cloud`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 1. sys_user / sys_role / sys_dept / sys_menu / sys_user_role / sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id`     bigint NOT NULL AUTO_INCREMENT COMMENT 'userId',
  `dept_id`     bigint DEFAULT NULL COMMENT 'deptId',
  `username`    varchar(30) NOT NULL COMMENT 'username',
  `nick_name`   varchar(30) NOT NULL COMMENT 'nick name',
  `password`    varchar(100) DEFAULT '' COMMENT 'password (bcrypt)',
  `phonenumber` varchar(11)  DEFAULT '' COMMENT 'phone',
  `email`       varchar(50)  DEFAULT '' COMMENT 'email',
  `avatar`      varchar(255) DEFAULT '' COMMENT 'avatar url',
  `status`      char(1)      DEFAULT '0' COMMENT 'status 0=normal 1=disabled',
  `login_ip`    varchar(128) DEFAULT '' COMMENT 'last login ip',
  `login_date`  datetime DEFAULT NULL COMMENT 'last login time',
  `create_by`   varchar(64)  DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by`   varchar(64)  DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark`      varchar(500) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='user';

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id`     bigint NOT NULL AUTO_INCREMENT COMMENT 'roleId',
  `role_name`   varchar(30) NOT NULL COMMENT 'role name',
  `role_key`    varchar(100) NOT NULL COMMENT 'role perm key',
  `role_sort`   int NOT NULL COMMENT 'display order',
  `data_scope`  char(1)     DEFAULT '1' COMMENT '1 all 2 custom 3 dept 4 self',
  `status`      char(1)     NOT NULL DEFAULT '0',
  `create_by`   varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by`   varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark`      varchar(500) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `uk_role_key` (`role_key`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='role';

DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id`   bigint NOT NULL AUTO_INCREMENT,
  `parent_id` bigint DEFAULT '0',
  `dept_name` varchar(30) DEFAULT '',
  `order_num` int DEFAULT '0',
  `leader`    varchar(20) DEFAULT NULL,
  `phone`     varchar(11) DEFAULT NULL,
  `email`     varchar(50) DEFAULT NULL,
  `status`    char(1)     DEFAULT '0',
  `create_by` varchar(64) DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COMMENT='dept';

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id`    bigint NOT NULL AUTO_INCREMENT,
  `menu_name`  varchar(50) NOT NULL,
  `parent_id`  bigint DEFAULT '0',
  `order_num`  int DEFAULT '0',
  `path`       varchar(200) DEFAULT '',
  `component`  varchar(255) DEFAULT NULL,
  `query`      varchar(255) DEFAULT NULL,
  `is_frame`   char(1)      DEFAULT '1',
  `is_cache`   char(1)      DEFAULT '0',
  `menu_type`  char(1)      DEFAULT '',
  `visible`    char(1)      DEFAULT '0',
  `status`     char(1)      DEFAULT '0',
  `perms`      varchar(100) DEFAULT NULL,
  `icon`       varchar(100) DEFAULT '#',
  `create_by`  varchar(64)  DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by`  varchar(64)  DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark`     varchar(500) DEFAULT '',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2000 DEFAULT CHARSET=utf8mb4 COMMENT='menu';

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- 2. sys_config / sys_dict_type / sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id`    int NOT NULL AUTO_INCREMENT,
  `config_name`  varchar(100) DEFAULT '',
  `config_key`   varchar(100) DEFAULT '',
  `config_value` varchar(500) DEFAULT '',
  `config_type`  char(1)      DEFAULT 'N',
  `create_by`    varchar(64)  DEFAULT '',
  `create_time`  datetime DEFAULT NULL,
  `update_by`    varchar(64)  DEFAULT '',
  `update_time`  datetime DEFAULT NULL,
  `remark`       varchar(500) DEFAULT NULL,
  PRIMARY KEY (`config_id`),
  UNIQUE KEY `uk_config_key` (`config_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id`     bigint NOT NULL AUTO_INCREMENT,
  `dict_name`   varchar(100) DEFAULT '',
  `dict_type`   varchar(100) DEFAULT '',
  `status`      char(1)      DEFAULT '0',
  `create_by`   varchar(64)  DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by`   varchar(64)  DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark`      varchar(500) DEFAULT NULL,
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `uk_dict_type` (`dict_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code`   bigint NOT NULL AUTO_INCREMENT,
  `dict_sort`   int DEFAULT '0',
  `dict_label`  varchar(100) DEFAULT '',
  `dict_value`  varchar(100) DEFAULT '',
  `dict_type`   varchar(100) DEFAULT '',
  `css_class`   varchar(100) DEFAULT NULL,
  `list_class`  varchar(100) DEFAULT NULL,
  `is_default`  char(1)      DEFAULT 'N',
  `status`      char(1)      DEFAULT '0',
  `create_by`   varchar(64)  DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_by`   varchar(64)  DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `remark`      varchar(500) DEFAULT NULL,
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- 3. sys_notice / sys_oper_log / sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id`      int NOT NULL AUTO_INCREMENT,
  `notice_title`   varchar(50)  NOT NULL,
  `notice_type`    char(1)      NOT NULL,
  `notice_content` longtext,
  `status`         char(1)      DEFAULT '0',
  `create_by`      varchar(64)  DEFAULT '',
  `create_time`    datetime DEFAULT NULL,
  `update_by`      varchar(64)  DEFAULT '',
  `update_time`    datetime DEFAULT NULL,
  `remark`         varchar(255) DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id`        bigint NOT NULL AUTO_INCREMENT,
  `title`          varchar(50)  DEFAULT '',
  `business_type`  int DEFAULT '0',
  `method`         varchar(200) DEFAULT '',
  `request_method` varchar(10)  DEFAULT '',
  `operator_type`  int DEFAULT '0',
  `oper_name`      varchar(50)  DEFAULT '',
  `dept_name`      varchar(50)  DEFAULT '',
  `oper_url`       varchar(255) DEFAULT '',
  `oper_ip`        varchar(128) DEFAULT '',
  `oper_param`     varchar(2000) DEFAULT '',
  `json_result`    varchar(2000) DEFAULT '',
  `status`         int DEFAULT '0',
  `error_msg`      varchar(2000) DEFAULT '',
  `oper_time`      datetime DEFAULT NULL,
  PRIMARY KEY (`oper_id`),
  KEY `idx_oper_time` (`oper_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `info_id`     bigint NOT NULL AUTO_INCREMENT,
  `user_name`   varchar(50)  DEFAULT '',
  `ipaddr`      varchar(128) DEFAULT '',
  `login_location` varchar(255) DEFAULT '',
  `browser`     varchar(50)  DEFAULT '',
  `os`          varchar(50)  DEFAULT '',
  `status`      char(1)      DEFAULT '0',
  `msg`         varchar(255) DEFAULT '',
  `login_time`  datetime DEFAULT NULL,
  PRIMARY KEY (`info_id`),
  KEY `idx_login_time` (`login_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- 4. Code generator
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table` (
  `table_id`        bigint NOT NULL AUTO_INCREMENT,
  `table_name`      varchar(200) DEFAULT '',
  `table_comment`   varchar(500) DEFAULT '',
  `sub_table_name`  varchar(64)  DEFAULT NULL,
  `sub_table_fk_name` varchar(64) DEFAULT NULL,
  `class_name`      varchar(100) DEFAULT '',
  `tpl_category`    varchar(200) DEFAULT 'crud',
  `package_name`    varchar(100) DEFAULT '',
  `module_name`     varchar(30)  DEFAULT '',
  `business_name`   varchar(30)  DEFAULT '',
  `function_name`   varchar(50)  DEFAULT '',
  `function_author` varchar(50)  DEFAULT '',
  `gen_type`        char(1)      DEFAULT '0',
  `gen_path`        varchar(200) DEFAULT '/',
  `options`         varchar(1000) DEFAULT NULL,
  `create_by`       varchar(64)  DEFAULT '',
  `create_time`     datetime DEFAULT NULL,
  `update_by`       varchar(64)  DEFAULT '',
  `update_time`     datetime DEFAULT NULL,
  `remark`          varchar(500) DEFAULT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column` (
  `column_id`     bigint NOT NULL AUTO_INCREMENT,
  `table_id`      bigint DEFAULT NULL,
  `column_name`   varchar(200) DEFAULT '',
  `column_comment` varchar(500) DEFAULT '',
  `column_type`   varchar(100) DEFAULT '',
  `java_type`     varchar(32)  DEFAULT '',
  `java_field`    varchar(100) DEFAULT '',
  `is_pk`         char(1)      DEFAULT '0',
  `is_increment`  char(1)      DEFAULT '0',
  `is_required`   char(1)      DEFAULT '0',
  `is_insert`     char(1)      DEFAULT '1',
  `is_edit`       char(1)      DEFAULT '1',
  `is_list`       char(1)      DEFAULT '1',
  `is_query`      char(1)      DEFAULT '1',
  `query_type`    varchar(200) DEFAULT 'EQ',
  `html_type`     varchar(200) DEFAULT 'input',
  `dict_type`     varchar(200) DEFAULT '',
  `sort`          int DEFAULT NULL,
  `create_by`     varchar(64)  DEFAULT '',
  `create_time`   datetime DEFAULT NULL,
  `update_by`     varchar(64)  DEFAULT '',
  `update_time`   datetime DEFAULT NULL,
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- 5. Seed: an admin user 'admin / admin123'
--    bcrypt hash of 'admin123' computed offline.
-- ----------------------------
INSERT INTO `sys_user` (`user_id`,`dept_id`,`username`,`nick_name`,`password`,`phonenumber`,`email`,`status`,`create_by`,`create_time`)
VALUES (1, 103, 'admin', 'administrator', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '15888888888', 'admin@ruoyi.com', '0', 'admin', NOW());

INSERT INTO `sys_role` (`role_id`,`role_name`,`role_key`,`role_sort`,`status`,`create_by`,`create_time`)
VALUES (1, 'super admin', 'admin', 1, '0', 'admin', NOW()),
       (2, 'common role', 'common', 2, '0', 'admin', NOW());

INSERT INTO `sys_user_role` (`user_id`,`role_id`) VALUES (1, 1);

INSERT INTO `sys_dept` (`dept_id`,`parent_id`,`dept_name`,`order_num`,`leader`,`phone`,`email`,`status`,`create_by`,`create_time`)
VALUES (103, 101, 'R&D department', 1, 'admin', '15888888888', 'admin@ruoyi.com', '0', 'admin', NOW());

INSERT INTO `sys_menu` (`menu_id`,`menu_name`,`parent_id`,`order_num`,`path`,`component`,`is_frame`,`is_cache`,`menu_type`,`visible`,`status`,`perms`,`icon`,`create_by`,`create_time`,`remark`)
VALUES (1, 'System',   0, 1, 'system',    null, '1', '0', 'M', '0', '0', '',     'system',  'admin', NOW(), 'sys catalog'),
       (2, 'Monitor',  0, 2, 'monitor',   null, '1', '0', 'M', '0', '0', '',     'monitor', 'admin', NOW(), 'monitor catalog'),
       (3, 'Tool',     0, 3, 'tool',      null, '1', '0', 'M', '0', '0', '',     'tool',    'admin', NOW(), 'tool catalog'),
       (100, 'User',   1, 1, 'user',      'system/user/index',     '1', '0', 'C', '0', '0', 'system:user:list',    'user',   'admin', NOW(), 'user menu'),
       (101, 'Role',   1, 2, 'role',      'system/role/index',     '1', '0', 'C', '0', '0', 'system:role:list',    'peoples','admin', NOW(), 'role menu'),
       (102, 'Menu',   1, 3, 'menu',      'system/menu/index',     '1', '0', 'C', '0', '0', 'system:menu:list',    'tree-table','admin', NOW(), 'menu menu');

INSERT INTO `sys_role_menu` (`role_id`,`menu_id`) VALUES (1, 1), (1, 2), (1, 3), (1, 100), (1, 101), (1, 102), (2, 1);

INSERT INTO `sys_config` (`config_name`,`config_key`,`config_value`,`config_type`,`create_by`,`create_time`,`remark`)
VALUES ('Captcha switch', 'sys.account.captchaEnabled', 'true', 'Y', 'admin', NOW(), 'captcha on/off'),
       ('User register switch', 'sys.account.registerUser', 'false', 'Y', 'admin', NOW(), 'allow self-register');

INSERT INTO `sys_dict_type` (`dict_name`,`dict_type`,`status`,`create_by`,`create_time`,`remark`)
VALUES ('User status', 'sys_user_status', '0', 'admin', NOW(), 'user status'),
       ('Yes/No',       'sys_yes_no',     '0', 'admin', NOW(), 'yes no');

INSERT INTO `sys_dict_data` (`dict_sort`,`dict_label`,`dict_value`,`dict_type`,`css_class`,`list_class`,`is_default`,`status`,`create_by`,`create_time`,`remark`)
VALUES (1, 'normal',   '0', 'sys_user_status', '', 'primary', 'Y', '0', 'admin', NOW(), 'normal'),
       (2, 'disabled', '1', 'sys_user_status', '', 'danger',  'N', '0', 'admin', NOW(), 'disabled'),
       (1, 'yes', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', NOW(), 'yes'),
       (2, 'no',  'N', 'sys_yes_no', '', 'danger',  'N', '0', 'admin', NOW(), 'no');

SET FOREIGN_KEY_CHECKS = 1;
