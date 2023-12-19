CREATE DATABASE `shoppe_db`;

-- shoppe_db.carousel definition

CREATE TABLE `carousel` (
  `carousel_id` int NOT NULL AUTO_INCREMENT COMMENT '轮播ID',
  `carousel_url` varchar(100) DEFAULT NULL COMMENT '轮播地址',
  PRIMARY KEY (`carousel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='首页轮播图表';

INSERT INTO shoppe_db.carousel (carousel_id, carousel_url) VALUES(1, '/pic/xmad_15627254995865_hbFzT.jpg');
INSERT INTO shoppe_db.carousel (carousel_id, carousel_url) VALUES(2, '/pic/xmad_15648327154491_VTHbl.jpg');
INSERT INTO shoppe_db.carousel (carousel_id, carousel_url) VALUES(3, '/pic/xmad_15648844793779_rCSmy.jpg');
INSERT INTO shoppe_db.carousel (carousel_id, carousel_url) VALUES(4, '/pic/xmad_15650061351615_PRHry.jpg');


-- shoppe_db.category definition

CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `category_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='类别表';


INSERT INTO shoppe_db.category (category_id, category_name) VALUES(1, '手机');
INSERT INTO shoppe_db.category (category_id, category_name) VALUES(2, '电视机');
INSERT INTO shoppe_db.category (category_id, category_name) VALUES(3, '空调');
INSERT INTO shoppe_db.category (category_id, category_name) VALUES(4, '洗衣机');
INSERT INTO shoppe_db.category (category_id, category_name) VALUES(5, '保护套');
INSERT INTO shoppe_db.category (category_id, category_name) VALUES(6, '保护膜');
INSERT INTO shoppe_db.category (category_id, category_name) VALUES(7, '充电器');
INSERT INTO shoppe_db.category (category_id, category_name) VALUES(8, '充电宝');


-- shoppe_db.orders definition

CREATE TABLE `orders` (
  `order_id` varchar(50) NOT NULL COMMENT '订单编号',
  `products` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '购买的商品',
  `user_id` int DEFAULT NULL COMMENT '用户编号',
  `total_price` varchar(255) DEFAULT NULL COMMENT '订单价格',
  `create_time` varchar(30) DEFAULT NULL COMMENT '下单时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='订单表';


-- shoppe_db.photo definition

CREATE TABLE `photo` (
  `photo_id` int NOT NULL AUTO_INCREMENT COMMENT '图片ID',
  `photo_url` varchar(100) DEFAULT NULL COMMENT '图片路径',
  `product_id` int DEFAULT NULL COMMENT '商品编号',
  PRIMARY KEY (`photo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='商品轮播图标';

INSERT INTO shoppe_db.photo (photo_id, photo_url, product_id) VALUES(1, '/pic/1.jpg', 7);
INSERT INTO shoppe_db.photo (photo_id, photo_url, product_id) VALUES(2, '/pic/5.jpg', 7);
INSERT INTO shoppe_db.photo (photo_id, photo_url, product_id) VALUES(3, '/pic/6.jpg', 7);
INSERT INTO shoppe_db.photo (photo_id, photo_url, product_id) VALUES(4, '/pic/7.jpg', 7);
INSERT INTO shoppe_db.photo (photo_id, photo_url, product_id) VALUES(5, '/pic/8.jpg', 7);


-- shoppe_db.product definition

CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `product_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '商品名称',
  `product_title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '商品简介',
  `product_intro` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '商品详细介绍',
  `product_price` decimal(24,6) DEFAULT NULL COMMENT '商品价格',
  `product_sell_price` decimal(24,6) DEFAULT NULL COMMENT '商品售价',
  `product_pic` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '商品图片',
  `category_id` int DEFAULT NULL COMMENT '商品类别',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='商品表';

INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(1, 'Redmi Note 13 Pro ', '8GB+128GB', '新 2 亿像素 更快更清晰｜旗舰直屏 超细四窄边', 1488.000000, 1399.000000, '/pic/top.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(2, 'Redmi Note 16 Pro', '8GB+128GB', '千元 5G ，明星机型
体验全面升级', 2100.000000, 2000.000000, '/pic/1.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(4, 'Redmi 12C', '高性能长续航', '高性能长续航，5000万像素超清双摄，全新多彩配色', 3210.000000, 2999.000000, '/pic/2.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(5, 'Redmi Note 11T Pro', '性能强悍的年度旗舰芯', '
天玑8100 真旗舰芯
144Hz 高配 LCD 屏幕
120W 神仙秒充 / 4400mAh / 澎湃 P1 自研科技
67W 旗舰闪充 / 5080mAh 大电量
6400 万像素超清大底相机', 3999.000000, 3000.000000, '/pic/3.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(6, 'Redmi Note 12T Pro', '天玑 8200-Ultra 旗舰芯', ' LCD 护眼屏｜ 12GB + 512GB 超大存储｜ 5080mAh 超大电量 + 67W 旗舰闪充｜ 6400万像素快拍相机｜ 潮流小立边设计｜ 小金刚品质 坚固耐用', 4321.000000, 3888.000000, '/pic/4.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(7, 'Redmi K60 至尊版', '重度性能用户', '天玑 9200+ & 独显芯片 X7
自研科技「狂暴引擎 2.0」
第二代 1.5K 高亮高刷屏
快拍相机 2.0、IP68 级防尘防水
旗舰体验全面超预期', 5999.000000, 5666.000000, '/pic/5.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(8, 'Xiaomi 13', '第二代骁龙8', '第二代骁龙8｜徕卡专业光学镜头', 4509.000000, 4399.000000, '/pic/6.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(9, 'Redmi 12C', '高性能长续航', '高性能长续航，5000万像素超清双摄，全新多彩配色', 3511.000000, 3400.000000, '/pic/7.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(10, 'Xiaomi 12 Pro', '高通全新一代芯片赋能，速度大幅提升', 'WiFi 6 增强版 + LPDDR5 满血版 + UFS 3.1
VC 液冷立体温控系统
4600mAh 大电量
小米澎湃P1 充电芯片
120W 小米澎湃秒充 / 50W 无线秒充 / 10W 反向充电', 3456.000000, 3200.000000, '/pic/8.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(11, 'Xiaomi 13', '徕卡专业光学镜头', '第二代骁龙8｜徕卡专业光学镜头｜徕卡原生双画质｜徕卡75mm长焦 | 超窄边屏幕｜67W澎湃秒充', 4999.000000, 4000.000000, '/pic/11.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(12, 'Xiaomi 13', '第二代骁龙8', '第二代骁龙8｜徕卡专业光学镜头', 4299.000000, 4199.000000, '/pic/12.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(13, 'Xiaomi 12', '全新一代骁龙8移动平台', '全新一代骁龙8
不论场面大小，皆掌控有度', 4399.000000, 4199.000000, '/pic/13.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(14, 'Xiaomi 13 Pro', '2K OLED 屏幕 |', '第二代骁龙8｜2K OLED 屏幕 | 徕卡专业光学镜头｜徕卡原生双画质｜徕卡75mm浮动长焦｜120W澎湃秒充', 4999.000000, 4899.000000, '/pic/14.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(15, 'Xiaomi 12 Pro', '好快,好稳,
好一次强上加强', '高通全新一代芯片赋能，速度大幅提升。
三大专业主摄影像加持，能力各有进化。', 5999.000000, 5800.000000, '/pic/15.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(16, 'Xiaomi 12S Pro', '致敬百年经典，致力感动人心', '历经徕卡专业认证，联合研发，给你原汁原味的徕卡影像', 4599.000000, 4599.000000, '/pic/16.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(17, 'Xiaomi 12 Pro 天玑版', '好戏连台的惊喜突破', '非凡旗舰芯
全球首发天玑9000+', 3899.000000, 3699.000000, '/pic/17.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(18, 'Xiaomi 13 Ultra', '徕卡光学全焦段四摄| 一英寸可变光圈', '徕卡专业街拍模式| 第二代骁龙8｜2K OLED 屏幕｜5000mAh大电量｜90W 小米澎湃有线秒充｜50W Pro 小米澎湃无线秒充', 6999.000000, 6799.000000, '/pic/18.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(19, 'Xiaomi MIX Fold 2', '以创新科技
打造一份「薄礼」', '打造纤薄机身设计，
探索折叠屏实用性的方向，
解决机身沉重痛点，
走完折叠屏步入实用时代的最后一公里。
送给想尝试折叠屏手机的你', 9999.000000, 9899.000000, '/pic/19.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(20, 'Xiaomi Civi 2', '前置仿生双主摄｜旗舰级后置相机', ' 第一代骁龙7移动平台｜不锈钢VC液冷散热｜4500mAh大电量｜AMOLED微曲屏', 2311.000000, 1289.000000, '/pic/20.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(22, 'Redmi Note 12T Pro', '天玑 8200-Ultra 旗舰芯', ' LCD 护眼屏｜ 12GB + 512GB 超大存储｜ 5080mAh 超大电量 + 67W 旗舰闪充｜ 6400万像素快拍相机｜ 潮流小立边设计｜ 小金刚品质 坚固耐用', 1699.000000, 1599.000000, '/pic/22.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(23, 'K50 电竞版', '开年大作，以电竞标准打造', '更强性能、更强散热、方方面面硬核配置
更与梅赛德斯-AMG F1 车队 梦幻联名', 1899.000000, 1699.000000, '/pic/23.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(24, 'Redmi K40 游戏增强版', '天玑1200｜年度旗舰处理器', '弹出式肩键｜航天立体散热｜JBL立体声双扬声器｜64MP旗舰三摄', 2899.000000, 2799.000000, '/pic/24.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(25, 'Xiaomi MIX Fold 2', '打造纤薄机身设计，
探索折叠屏实用性的方向', '走完折叠屏步入实用时代的最后一公里。
送给想尝试折叠屏手机的你', 13999.000000, 12999.000000, '/pic/25.png', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(26, '小米电视EA43 L43MA-E ', '金属全面屏、震撼音效', '金属全面屏、震撼音效、双频wifi', 1399.000000, 949.000000, '/pic/1d6082f2ce57389b9e56a273c2c1ec34.jpg', 2);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(27, '小米电视A75竞技版', '120Hz全面屏，疾速升级', '120Hz全面屏，疾速升级', 2399.000000, 1949.000000, '/pic/12q.png', 2);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(28, '小米电视EA43 L43MA-E', '金属全面屏、震撼音效、双频wifi', '金属全面屏、震撼音效、双频wifi', 2399.000000, 1949.000000, '/pic/f731afce.png', 2);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(29, 'Redmi MAX 100', '很有戏，也很有趣', '很有戏，也很有趣', 2399.000000, 1949.000000, '/pic/202210181435_781dbf16f8f3b640d2d13afd9b98425d.jpg', 2);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(30, '小米电视 EA75（L75MA-EA）75英寸', '金属全面屏 | 远场语音 | 双频WIFI', '金属全面屏 | 远场语音 | 双频WIFI', 3399.000000, 2949.000000, '/pic/202303201156_c95135c31082640c8f42f9a61966b635.png', 2);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(31, '小米电视EA32 32英寸', '金属全面屏,浩瀚观感扑面而来金属一体机身', '极窄边框，超高屏占比沉浸，突破视界', 899.000000, 699.000000, '/pic/202304171018_e836d88e3a9e73e68000936c4269165e.png', 2);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(32, '小米电视S85 85英寸', '144HZ超高刷 3+32G 多色温色彩还原技术', '144HZ超高刷 3+32G 多色温色彩还原技术', 6899.000000, 5999.000000, '/pic/202304280954_0bd534514ffd7111b26573c1769fcc34.png', 2);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(33, '巨省电 小米空调 1.5匹新1级能效', '强劲制冷 | 高效节能 | 智能互联', '强劲制冷 | 高效节能 | 智能互联', 2499.000000, 2099.000000, '/pic/3a1c150507e322c5be1ccace3b2515e4.png', 3);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(34, '巨省电 小米空调 立式3匹新1级能效', '高效节能 | 立体送风 | 智能互联', '高效节能 | 立体送风 | 智能互联', 2499.000000, 2099.000000, '/pic/pms_1605536123.55818348.jpg', 3);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(35, '米家洗烘一体机 12kg', '超大超值超护衣 健康洗烘全家桶', '双重除菌除螨，守护衣物健康', 2499.000000, 2099.000000, '/pic/202212131651_345483fe752c528f5ebafe8456174670.png', 4);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(36, '直驱|米家滚筒洗衣机 10kg', '直驱电机更安静|95℃高温除菌 除菌率99.9%', '直驱电机更安静|95℃高温除菌 除菌率99.9%|抗菌门封|23种洗涤模式|智能互联|电机10年质保', 1699.000000, 1299.000000, '/pic/202212131656_8a6a91b8736bbacdba582e6dbc4997ad.png', 4);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(37, 'Xiaomi 13/Xiaomi 13 Pro 旅行款素皮保护壳', '箱包质感｜时尚配色｜出色手感｜周全保护', '箱包质感｜时尚配色｜出色手感｜周全保护', 149.000000, 69.000000, '/pic/202211301633_869c4db7c6827c2c1dc09a1fb3dc5455.jpg', 5);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(38, 'Redmi K60 系列 液态硅胶保护壳', '简约设计｜亲肤舒适｜周全保护', '简约设计｜亲肤舒适｜周全保护', 69.000000, 29.000000, '/pic/202212081530_e1149fce94363a1def320c97ba9297c0.jpg', 5);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(39, 'Redmi Note 11T 系列 液态硅胶保护壳', 'Redmi Note 11T 系列 液态硅胶保护壳 静宇黑', 'Redmi Note 11T 系列 液态硅胶保护壳 静宇黑', 69.000000, 29.000000, '/pic/202212261501_70be4e2fc3258bfa9c5eae618a0d05e1.png', 5);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(40, 'Redmi Note 12 Turbo 哈利·波特定制保护壳', 'Redmi Note 12 Turbo 哈利·波特定制保护壳', 'Redmi Note 12 Turbo 哈利·波特定制保护壳', 99.000000, 89.000000, '/pic/202305301710_3640e2702271bd876ca146fffda37886.png', 5);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(41, 'Redmi Pad SE 双面保护壳', '稳定支撑 ｜ 翻盖唤醒 ｜ 精湛工艺', '稳定支撑 ｜ 翻盖唤醒 ｜ 精湛工艺', 89.000000, 89.000000, '/pic/202309201612_f7d1de6fdb67b33ed996430e12971f9c.png', 5);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(42, '小米平板5系列 磁吸双面保护壳 11英寸', '磁吸支撑 解放双手', '磁吸支撑 解放双手', 99.000000, 89.000000, '/pic/pms_1628598862.59259381.png', 5);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(43, 'Redmi Pad双面折叠保护壳', '稳定支撑 ｜ 翻盖唤醒 ｜ 精湛工艺', '稳定支撑 ｜ 翻盖唤醒 ｜ 精湛工艺', 99.000000, 89.000000, '/pic/pms_1640694474.97641886.jpg', 5);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(44, 'Xiaomi Pad 6系列 钢化保护膜', '清晰原色 ｜ 周全保护 ｜ 经久耐用', '清晰原色 ｜ 周全保护 ｜ 经久耐用', 69.000000, 69.000000, '/pic/333b7338accaa641ae0b774a6faedd9e.jpg', 6);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(45, 'Redmi K60至尊版 冰封散热钢化膜', '加速散热 ｜ 防刮防爆', '加速散热 ｜ 防刮防爆 ｜ 高清高透', 69.000000, 69.000000, '/pic/202308131204_f476642be7c21c9274a8a2b6acc35587.png', 6);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(46, '小米67W充电器套装 轻享版 ', '最高67w输出功率 ', '最高67w输出功率 ｜ Type-C接口数据线', 129.000000, 89.000000, '/pic/202211021836_421f8ed268ac156d28221cef42e5ba38.png', 7);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(47, '小米67W GaN 双口充电器套装 ', '大功率智能快充，两台设备同时搞定', '大功率智能快充，两台设备同时搞定', 129.000000, 99.000000, '/pic/202303151030_68900fccb6e03e736067bbf103b03dd4.jpg', 7);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(48, '小米移动电源3 20000mAh USB-C双向快充版', 'USB-C 18W双向快充', 'USB-C 18W双向快充 / 可为三台设备同时充电 / 高品质锂离子聚合物电池', 129.000000, 119.000000, '/pic/29ab6d26b2aa18c3f418d603ed6f1910.jpg', 8);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(49, '小米自带线充电宝10000mAh 迪士尼100周年限定版', '迪士尼100周年限定版，快乐无限，电量时刻在“线”', '迪士尼100周年限定版，快乐无限，电量时刻在“线”', 199.000000, 199.000000, '/pic/202306071124_4e21a7b66f2ee37a4f1c23c6480556ed.png', 8);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(110, 'Xiaomi 12 Pro', '高通全新一代芯片赋能，速度大幅提升', 'WiFi 6 增强版 + LPDDR5 满血版 + UFS 3.1
VC 液冷立体温控系统
4600mAh 大电量
小米澎湃P1 充电芯片
120W 小米澎湃秒充 / 50W 无线秒充 / 10W 反向充电', 3456.000000, 3200.000000, '/pic/8.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(111, 'Redmi Note 13 Pro ', '8GB+128GB', '新 2 亿像素 更快更清晰｜旗舰直屏 超细四窄边', 1488.000000, 1399.000000, '/pic/top.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(112, 'Redmi Note 16 Pro', '8GB+128GB', '千元 5G ，明星机型
体验全面升级', 2100.000000, 2000.000000, '/pic/1.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(114, 'Redmi 12C', '高性能长续航', '高性能长续航，5000万像素超清双摄，全新多彩配色', 3210.000000, 2999.000000, '/pic/2.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(115, 'Redmi Note 11T Pro', '性能强悍的年度旗舰芯', '
天玑8100 真旗舰芯
144Hz 高配 LCD 屏幕
120W 神仙秒充 / 4400mAh / 澎湃 P1 自研科技
67W 旗舰闪充 / 5080mAh 大电量
6400 万像素超清大底相机', 3999.000000, 3000.000000, '/pic/3.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(116, 'Redmi Note 12T Pro', '天玑 8200-Ultra 旗舰芯', ' LCD 护眼屏｜ 12GB + 512GB 超大存储｜ 5080mAh 超大电量 + 67W 旗舰闪充｜ 6400万像素快拍相机｜ 潮流小立边设计｜ 小金刚品质 坚固耐用', 4321.000000, 3888.000000, '/pic/4.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(117, 'Redmi K60 至尊版', '重度性能用户', '天玑 9200+ & 独显芯片 X7
自研科技「狂暴引擎 2.0」
第二代 1.5K 高亮高刷屏
快拍相机 2.0、IP68 级防尘防水
旗舰体验全面超预期', 5999.000000, 5666.000000, '/pic/5.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(118, 'Xiaomi 13', '第二代骁龙8', '第二代骁龙8｜徕卡专业光学镜头', 4509.000000, 4399.000000, '/pic/6.jpg', 1);
INSERT INTO shoppe_db.product (product_id, product_name, product_title, product_intro, product_price, product_sell_price, product_pic, category_id) VALUES(119, 'Redmi 12C', '高性能长续航', '高性能长续航，5000万像素超清双摄，全新多彩配色', 3511.000000, 3400.000000, '/pic/7.jpg', 1);


-- shoppe_db.shopcart definition

CREATE TABLE `shopcart` (
  `shopcart_id` int NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `product_id` int DEFAULT NULL COMMENT '商品ID',
  `user_id` int DEFAULT NULL COMMENT '用户编号',
  `num` int DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`shopcart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1916870659 DEFAULT CHARSET=utf8mb3 COMMENT='购物车表';


-- shoppe_db.`user` definition

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(20) DEFAULT NULL COMMENT '账号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1954656258 DEFAULT CHARSET=utf8mb3 COMMENT='用户表';