CREATE TABLE tbl_product(
	id INT(11) NOT NULL PRIMARY KEY auto_increment COMMENT '主键',
	goods_no VARCHAR(50) COMMENT '商品编号',
	goods_name VARCHAR(50) COMMENT '商品名称',
	goods_price BIGINT(10) COMMENT '商品价格',
	create_time datetime COMMENT '创建时间',
	modify_time datetime COMMENT '修改时间'
);
CREATE INDEX index_goodsNo on tbl_product(goods_no);

ALTER TABLE `Test`.`tbl_product`
ADD COLUMN `customer_no` varchar(50) NULL COMMENT '用户编号' AFTER `modify_time`;

CREATE TABLE tbl_customer(
 id INT(11) NOT NULL PRIMARY KEY auto_increment COMMENT '主键',
 customer_no VARCHAR(50) NOT NULL COMMENT '用户编号',
 mobile VARCHAR(50) COMMENT '手机号',
 create_time datetime COMMENT '创建时间',
 modify_time datetime COMMENT '修改时间'
);
CREATE INDEX index_customerNo ON tbl_customer(customer_no);


CREATE DATABASE mytest;

CREATE TABLE tbl_user(
  userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userName VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  phone VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


select id, goods_no, goods_name, goods_price, create_time, modify_time, customer_no from tbl_product;


CREATE TABLE tbl_order(
id INT(10) NOT NULL PRIMARY KEY auto_increment COMMENT '主键',
order_no VARCHAR(255) COMMENT '订单号',
money DECIMAL(9,2) COMMENT '价格',
channel VARCHAR(50) COMMENT '支付渠道(001:支付宝,002微信)',
create_time datetime COMMENT '创建时间',
modify_time datetime COMMENT '修改时间'
);
CREATE INDEX index_orderNo ON tbl_order(order_no);
CREATE INDEX index_customerNo ON tbl_order(customer_no);
ALTER TABLE tbl_order ADD COLUMN goods_no VARCHAR(255) COMMENT '商品编号' AFTER order_no;


ALTER TABLE `Test`.`tbl_order`
ADD COLUMN `customer_no` varchar(50) NULL COMMENT '用户编号' AFTER `goods_no`;