create table document
(
    document_id      bigint auto_increment comment '主键id'
        primary key,
    module_id        bigint       not null comment '模块id',
    title            varchar(128) not null comment '文档标题',
    content          mediumtext   not null comment '文档内容',
    content_overview varchar(256) null comment '文档概述',
    create_by        varchar(64)  not null comment '创建人',
    create_time      datetime     not null,
    update_by        varchar(64)  not null comment '修改人',
    update_time      datetime     not null comment '修改时间'
)
    comment '文档';

create table document_version
(
    document_version_id bigint auto_increment comment '主键id'
        primary key,
    document_id         bigint       not null comment '文档id',
    module_id           bigint       not null comment '模块id',
    title               varchar(128) not null comment '文档标题',
    content             mediumtext   not null comment '文档内容',
    content_overview    varchar(256) not null comment '文档概述',
    submitter           varchar(64)  not null comment '提交人',
    submission_time     datetime     not null comment '提交时间'
)
    comment '文档版本记录每一次文档的修改
可以用来进行文档的回退';

create table module
(
    module_id   bigint auto_increment comment '主键id'
        primary key,
    name        varchar(256) not null comment '文件夹名称',
    create_by   varchar(64)  not null comment '创建人',
    create_time datetime     not null comment '创建时间',
    update_by   varchar(64)  not null comment '修改人',
    update_time datetime     not null comment '修改时间',
    constraint module_name_uq
        unique (name)
)
    comment '文件夹';

create table operation_log
(
    operation_log_id bigint auto_increment comment '主键id'
        primary key,
    operator         varchar(64)  not null comment '操作人员的用户名',
    info             varchar(256) not null comment '操作信息',
    operation_time   datetime     not null comment '操作时间'
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

create table user_document_permissions
(
    user_document_permissions_id bigint auto_increment comment '主键id
'
        primary key,
    username                     varchar(64) not null comment '用户名',
    document_id                  bigint      not null comment '文档id',
    permission_type              int(1)      not null comment '权限类型 0只读 1可读可写',
    create_by                    varchar(64) not null comment '创建人',
    create_time                  datetime    not null comment '创建时间',
    update_by                    varchar(64) not null comment '修改人',
    update_time                  datetime    not null comment '修改时间'
)
    comment '用户文档权限表';