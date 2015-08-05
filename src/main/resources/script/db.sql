/*==============================================================*/
/* Table: AppToken                                              */
/*==============================================================*/
create table AppToken
(
   AppTokenID           int not null auto_increment,
   Name                 varchar(1024),
   Code                 varchar(1024),
   Description          longtext,
   State                bool,
   CreateDate           datetime,
   Creator              int,
   primary key (AppTokenID)
);

/*==============================================================*/
/* Table: AppUser                                               */
/*==============================================================*/
create table AppUser
(
   AppUserID            int not null auto_increment,
   AppToken             varchar(1024),
   AppVersion           varchar(1024),
   DeviceNum            varchar(1024) not null,
   DeviceModel          varchar(1024),
   DeviceResolution     varchar(128),
   JailBroken           bool,
   OSVersion            varchar(1024),
   CreateDate           datetime,
   primary key (AppUserID)
);

/*==============================================================*/
/* Table: AppVersion                                            */
/*==============================================================*/
create table AppVersion
(
   AppVersionID         int not null auto_increment,
   Name                 varchar(1024),
   ClientVersion        varchar(1024),
   AppToken             varchar(1024),
   Description          longtext,
   Type                 int,
   URL                  varchar(1024),
   CreateDate           datetime,
   Creator              int,
   primary key (AppVersionID)
);

/*==============================================================*/
/* Table: SysConfig                                             */
/*==============================================================*/
create table SysConfig
(
   SysConfigID          int not null auto_increment,
   ConfigType           int,
   ConfigKey            varchar(1024),
   ConfigValue          varchar(1024),
   Description          varchar(1024),
   primary key (SysConfigID)
);

