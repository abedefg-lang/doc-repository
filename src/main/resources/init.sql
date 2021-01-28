create table document
(
    document_id      bigint auto_increment comment '主键id'
        primary key,
    folder_id        bigint            not null comment '文件夹id',
    title            varchar(128)      not null comment '文档标题',
    content          text              not null comment '文档内容',
    content_overview varchar(256)      null comment '文档概述',
    create_time      bigint            not null,
    create_by        varchar(64)       not null comment '创建人',
    update_by        varchar(64)       not null comment '修改人',
    update_time      bigint            not null comment '修改时间',
    deleted          tinyint default 0 not null
)
    comment '文档';

create table document_edit_log
(
    document_edit_log_id bigint auto_increment comment '主键id'
        primary key,
    operation_log_id     bigint            not null comment '操作日志id',
    document_id          bigint            not null comment '编辑的文档id',
    content              text              not null comment '文档内容',
    content_overview     varchar(256)      not null comment '文档概述',
    deleted              tinyint default 0 not null
)
    comment '文档编辑日志';

create table folder
(
    folder_id   bigint auto_increment comment '主键id'
        primary key,
    name        varchar(256)      not null comment '文件夹名称',
    create_by   varchar(64)       not null comment '创建人',
    create_time bigint            not null comment '创建时间',
    update_by   varchar(64)       not null comment '修改人',
    update_time bigint            not null comment '修改时间',
    deleted     tinyint default 0 not null,
    constraint folder_name_uindex
        unique (name)
)
    comment '文件夹';

create table operation_log
(
    operation_log_id bigint auto_increment comment '主键id'
        primary key,
    username         varchar(64)       not null comment '操作人员的用户名',
    info             varchar(256)      not null comment '操作信息',
    operation_time   bigint            not null comment '操作时间',
    deleted          tinyint default 0 not null
)
    comment '操作日志表';

create table user
(
    user_id  bigint auto_increment comment '主键id'
        primary key,
    username varchar(64)       not null comment '用户名',
    password varchar(64)       not null comment '密码',
    deleted  tinyint default 0 not null,
    constraint user_username_uindex
        unique (username)
)
    comment '用户信息表';

create table user_document_permissions
(
    user_document_permissions_id bigint auto_increment comment '主键id'
        primary key,
    username                     varchar(64)       not null comment '用户名',
    document_id                  bigint            not null comment '文档id',
    permission_type              int(1)            not null comment '权限类型 0只读 1可读可写',
    create_by                    varchar(64)       not null comment '创建人',
    create_time                  bigint            not null comment '创建时间',
    update_by                    varchar(64)       not null comment '修改人',
    update_time                  bigint            not null comment '修改时间',
    deleted                      tinyint default 0 not null
)
    comment '用户文档权限表';