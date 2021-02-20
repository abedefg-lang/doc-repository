create table category
(
    category_id bigint auto_increment comment '主键id'
        primary key,
    name        varchar(128) not null comment '文件夹名称',
    created_by  varchar(64)  not null comment '创建人',
    creator_id  bigint       not null comment '创建人uid',
    create_time datetime     not null comment '创建时间',
    updated_by  varchar(64)  not null comment '修改人',
    updater_id  bigint       not null comment '修改人uid',
    update_time datetime     not null comment '修改时间',
    constraint module_name_uq
        unique (name)
)
    comment '分类';

create table document
(
    document_id      bigint auto_increment comment '主键id'
        primary key,
    category_id      bigint       not null comment '分类id

',
    title            varchar(128) not null comment '文档标题',
    content          mediumtext   not null comment '文档内容',
    content_overview varchar(256) null comment '文档概述',
    created_by       varchar(64)  not null comment '创建人',
    creator_id       bigint       not null comment '创建人uid',
    create_time      datetime     not null comment '创建时间',
    updated_by       varchar(64)  not null comment '修改人',
    updater_id       bigint       not null comment '修改人uid',
    update_time      datetime     not null comment '修改时间'
)
    comment '文档';

create table operation_log
(
    operation_log_id bigint auto_increment comment '主键id'
        primary key,
    info             varchar(256) not null comment '操作信息',
    created_by       varchar(64)  not null comment '创建人',
    creator_id       bigint       not null comment '创建人uid',
    create_time      datetime     not null comment '创建时间'
)
    comment '操作日志表';

create table user
(
    user_id         bigint auto_increment comment '主键id'
        primary key,
    username        varchar(64) not null comment '用户名',
    password        varchar(64) not null comment '密码',
    last_login_time datetime    not null comment '最近登录时间',
    constraint user_username_uindex
        unique (username)
)
    comment '用户信息表';