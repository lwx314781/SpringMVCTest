USE yongchen;

DROP TABLE IF EXISTS account_info ;
/*用户信息表*/
CREATE TABLE sys_user(
id INT(10) AUTO_INCREMENT PRIMARY KEY,
user_id VARCHAR(20) NOT NULL ,  -- 账号
user_pass VARCHAR(20) NOT NULL  -- 密码
)ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;


DROP TABLE IF EXISTS sys_role_info;
/*创建角色表*/
CREATE TABLE role_info(
id INT(10) AUTO_INCREMENT PRIMARY KEY,
role_id INT(1) NOT NULL,
role_name VARCHAR(10) NOT NULL,
)ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF exists sys_permission;
/*创建系统权限表*/ 
id INT(10) AUTO_INCREMENT PRIMARY KEY,
moudle_id varchar(10) NOT NULL,
moudle_name varchar(20) NOT NULL,
parent_id varchar(10) NOT NULL,





DROP TABLE IF exists user_permission;
/*创建用户权限*/


/*患者信息表*/
DROP TABLE IF EXISTS patient_info;

CREATE TABLE patient_info(
id INT(10) AUTO_INCREMENT PRIMARY KEY,
account_id VARCHAR(20) NOT NULL,  
user_name VARCHAR(20) NOT NULL,  -- 用户真实姓名
born_time date NOT NULL,  -- 出生日期
sex tinyint(2) NOT NULL,  -- 0：男  ，1：女
phone bigint(11) NOT NULL, -- 电话
register_time date not null,  -- 注册时间，具体到天
first_consult datetime,  -- 第一次就诊时间
status tinyint(2) DEFAULT 0, -- 状态信息，会员：1，非会员：0
head_portrait varchar(30) NOT NULL DEFAULT 'image/0.jpeg',  -- 头像
note varchar(1000),  -- 备注
CONSTRAINT 'user_accout_id' FOREIGN KEY (account_id) REFERENCES account_info(user_id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS manager_info;
/*后台管理人员信息表*/
CREATE TABLE manager_info(
id INT(10) AUTO_INCREMENT PRIMARY KEY, -- 主键id
user_name varchar(20) NOT NULL, -- 用户真实姓名
status VARCHAR(4) NOT NULL,  -- 当前账号状态
user_type int(2) NOT NULL, -- 用户类型pc和app
is_online int(2) NOT NULL DEFAULT 0, -- 是否在线，默认不在线，1是在线
role_id int(2) NOT NULL,-- 角色id 0是超级管理员 1客服经理 2客服 3财务
creator varchar(20) not null,
create_department int
)ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;


