## 菜单信息表
CREATE TABLE `tb_info_menu`
(
    `id`               int(11)      NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `menu_name`        varchar(32)  NOT NULL COMMENT '菜单名',
    `parent_menu_id`   int(11)      NOT NULL COMMENT '父级菜单ID',
    `menu_icon_path`   varchar(64)  NOT NULL DEFAULT '' COMMENT 'icon路径',
    `menu_link_path`   varchar(128) NOT NULL DEFAULT '' COMMENT '菜单链接地址',
    `create_time`      timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_update_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间 ',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_m` (`menu_name`, `parent_menu_id`, `menu_link_path`) USING BTREE COMMENT '菜单配置表'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='菜单信息表';

## 角色信息表
CREATE TABLE `tb_info_role`
(
    `id`               int(11)     NOT NULL AUTO_INCREMENT COMMENT '自增编号',
    `role_name`        varchar(32) NOT NULL COMMENT '角色名称',
    `create_time`      timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_mrn` (`role_name`) USING BTREE COMMENT '角色名称唯一'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='角色信息表';

## 角色菜单关联关系表
CREATE TABLE `tb_relation_menu_role`
(
    `id`               int(11)   NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `role_id`          int(10)   NOT NULL COMMENT '管理角色编号',
    `menu_id`          int(10)   NOT NULL COMMENT '配置菜单编号(最低级菜单id)',
    `relation_up`      int(11)   NOT NULL DEFAULT '1' COMMENT '关系状态是否启用(1,启用；0，禁用)',
    `create_time`      timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间 ',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_mri_cmi` (`role_id`, `menu_id`) USING BTREE COMMENT '角色ID和菜单关系唯一'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='角色菜单关联关系表';

## 管理员信息表
CREATE TABLE `tb_info_manager`
(
    `id`               int(11)      NOT NULL AUTO_INCREMENT COMMENT '自增编号',
    `login_name`       varchar(32)  NOT NULL COMMENT '登录账号',
    `login_password`   varchar(128) NOT NULL COMMENT '登录密码',
    `role_id`          int(11)      NOT NULL COMMENT '角色编号',
    `create_time`      timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_update_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `login_name` (`login_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='管理员信息表';    