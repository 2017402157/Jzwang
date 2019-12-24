/*
Navicat MySQL Data Transfer

Source Server         : 120.79.42.237_3306
Source Server Version : 50727
Source Host           : 120.79.42.237:3306
Source Database       : jzwang

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-12-23 19:26:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `candidate`
-- ----------------------------
DROP TABLE IF EXISTS `candidate`;
CREATE TABLE `candidate` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `age` int(100) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `weixin` varchar(255) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `releasetime` varchar(255) DEFAULT NULL,
  `creattime` varchar(255) DEFAULT NULL,
  `jobmessage` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of candidate
-- ----------------------------
INSERT INTO `candidate` VALUES ('1573655882903', '李嘉诚', '0', '大学城', '1563165', '23', '1542', '1542', '0', null, null, null, '1255');
INSERT INTO `candidate` VALUES ('1576208365279', '御景城', '1', '凯里市经济开发区鸭塘', '15246987235', '21', '1523654789', '1523654789', '1', null, null, null, null);
INSERT INTO `candidate` VALUES ('1576210006240', '杨正旺', '0', '12', '12', '21', '21', '21', '点击选择', '0', null, null, null);
INSERT INTO `candidate` VALUES ('1576210130138', '龙小雯', '1', '贵州大学', '13885540XX', '20', '123', '465', '全职', null, null, null, null);
INSERT INTO `candidate` VALUES ('1576210268099', '13', '0', '23', '23', '13', '32', '23', '兼职', null, null, null, null);
INSERT INTO `candidate` VALUES ('1576210855051', '12', '0', '12', '12', '21', '12', '21', '0', null, null, null, null);
INSERT INTO `candidate` VALUES ('1576217200975', '恶趣味', '0', '12', '12', '12', '12', '12', '0', null, null, null, '2516');
INSERT INTO `candidate` VALUES ('1576217226161', '123', '0', '21', '312', '123', '123', '3', '0', null, null, null, null);
INSERT INTO `candidate` VALUES ('1576217256296', '122111', '1', '1', '11', '11', '1', '1', '1', null, null, null, null);
INSERT INTO `candidate` VALUES ('1576218178306', '1', '0', '1', '1', '1', '1', '1', '1', null, null, null, null);
INSERT INTO `candidate` VALUES ('1576218179518', '1', '0', '1', '1', '1', '1', '1', '1', null, null, null, null);
INSERT INTO `candidate` VALUES ('1576218199348', '1', '0', '1', '1', '1', '1', '1', '1', null, null, null, null);
INSERT INTO `candidate` VALUES ('1576218204521', '1', '0', '1', '1', '1', '1', '1', '1', null, null, null, null);
INSERT INTO `candidate` VALUES ('1576220284099', '1', '1', '1', '1', '1', '1', '1', '1', null, null, null, null);
INSERT INTO `candidate` VALUES ('1576220400942', '1', '0', '1', '1', '1', '1', '1', null, null, null, null, null);
INSERT INTO `candidate` VALUES ('1576243269583', '简单', '0', '贵阳学院', '15228794568', '20', '135165146', '15228794568', '0', '0', null, null, null);
INSERT INTO `candidate` VALUES ('1576385838783', '999', '0', '9', '9', '99', '9', '9', '0', '1', null, '2019-12-15 12:57:18.783', 'fgaf');
INSERT INTO `candidate` VALUES ('1576385991810', '945', '0', '4', '4', '4', '4', '4', '0', '1', null, '2019-12-15 12:59:51.81', '4');
INSERT INTO `candidate` VALUES ('1576389085083', '123', '0', '123', '123', '123', '123', '123', '0', '1', null, '2019-12-15 13:51:25.083', '1231242314123');
INSERT INTO `candidate` VALUES ('1576679618779', '一', '0', '一', '一', '1', '一', '一', '0', '1', null, '2019-12-18 22:33:38.779', '一');
INSERT INTO `candidate` VALUES ('1576683369779', 'ad', '1', '撒旦法', '双方都', '12', '撒旦法', '撒旦法 ', '1', '0', '2019-12-18 23:42:27.333', '2019-12-18 23:36:09.78', '阿道夫');

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `brief` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `datum` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `weixin` varchar(255) DEFAULT NULL,
  `linkman` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1576577213007', '大力科技', '软件开发', null, '18224552466', null, 'ceo', '', null, '15228794568', '李晓峰');
INSERT INTO `company` VALUES ('1576577859808', '议程科技', '高端科技', null, '1', null, '无', '', null, '1', '杨正旺');
INSERT INTO `company` VALUES ('1576578480918', '益禾堂', '卖饮料', null, '123', null, '无', '', null, '4', '杨正旺');
INSERT INTO `company` VALUES ('1576581698620', '五帝', '网吧', null, '15423578456', null, '老板', '/upload/1576581548228.jpg', null, 'ad154881526', '陆小凤');
INSERT INTO `company` VALUES ('1576679513251', '一 ', '一', null, '一', null, '一', '', null, '一', '一');

-- ----------------------------
-- Table structure for `contact`
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `addr` varchar(2000) DEFAULT NULL,
  `inteteraddr` varchar(255) DEFAULT NULL,
  `postcode` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('1573529061492', '凯里勤工俭学中心', '0855-2200293/15585388866', '凯里市经济开发区桂花苑', '凯里兼职网', '52262451', '1256120257@qq.com');

-- ----------------------------
-- Table structure for `invite`
-- ----------------------------
DROP TABLE IF EXISTS `invite`;
CREATE TABLE `invite` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(2000) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `workexp` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `worktime` varchar(255) DEFAULT NULL,
  `reward` varchar(255) DEFAULT NULL,
  `releasetime` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `pageview` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `label` int(11) DEFAULT NULL,
  `workpro` varchar(255) DEFAULT NULL,
  `settle` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `creattime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of invite
-- ----------------------------
INSERT INTO `invite` VALUES ('1576578481108', '操作员', '凯里学院', '12', '无', '大三', '10:00-18:00', '12元小时', '2019-12-17 18:32:30.415', '1576578480918', null, '全职', null, '饮料加工操作', null, '0', '2019-12-17 18:28:01.108');
INSERT INTO `invite` VALUES ('1576581698793', '网管', '凯里经济开发区', '1', null, '初中以上', '每天工作8小时', '3000', '2019-12-17 19:21:56.223', '1576581698620', null, null, null, '收钱', null, '0', '2019-12-17 19:21:38.793');
INSERT INTO `invite` VALUES ('1576679513476', '一', '一', '1', '一', '一', '一', '一', null, '1576679513251', null, '全职', null, '一', null, '1', '2019-12-18 22:31:53.476');
INSERT INTO `invite` VALUES ('1576684770519', '网站', '第三方', '12', '大', '第三方', '第三方', '发多少', '2019-12-18 23:59:42', '1576578480918', null, '1573567873106', null, '大富', null, '0', '2019-12-18 23:59:30.519');

-- ----------------------------
-- Table structure for `logs`
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `logintime` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logs
-- ----------------------------
INSERT INTO `logs` VALUES ('1576550448858', 'admin', '2019-12-17 10:40:48.859', '0');
INSERT INTO `logs` VALUES ('1576550605396', 'admin', '2019-12-17 10:43:25.396', '0');
INSERT INTO `logs` VALUES ('1576551155029', 'admin', '2019-12-17 10:52:35.029', '0');
INSERT INTO `logs` VALUES ('1576553115819', 'admin', '2019-12-17 11:25:15.819', '0');
INSERT INTO `logs` VALUES ('1576562723206', 'admin', '2019-12-17 14:05:23.206', '0');
INSERT INTO `logs` VALUES ('1576563036065', 'admin', '2019-12-17 14:10:36.065', '0');
INSERT INTO `logs` VALUES ('1576565894719', 'admin', '2019-12-17 14:58:14.719', '0');
INSERT INTO `logs` VALUES ('1576570602271', 'admin', '2019-12-17 16:16:42.271', '0');
INSERT INTO `logs` VALUES ('1576571412985', 'admin', '2019-12-17 16:30:12.985', '0');
INSERT INTO `logs` VALUES ('1576572004896', 'admin', '2019-12-17 16:40:04.896', '0');
INSERT INTO `logs` VALUES ('1576573656445', 'admin', '2019-12-17 17:07:36.445', '0');
INSERT INTO `logs` VALUES ('1576574085654', 'admin', '2019-12-17 17:14:45.654', '0');
INSERT INTO `logs` VALUES ('1576575778434', 'admin', '2019-12-17 17:42:58.434', '0');
INSERT INTO `logs` VALUES ('1576576096547', 'admin', '2019-12-17 17:48:16.547', '0');
INSERT INTO `logs` VALUES ('1576576307999', 'admin', '2019-12-17 17:51:47.999', '0');
INSERT INTO `logs` VALUES ('1576578750701', 'admin', '2019-12-17 18:32:30.701', '0');
INSERT INTO `logs` VALUES ('1576578798571', 'admin', '2019-12-17 18:33:18.571', '0');
INSERT INTO `logs` VALUES ('1576578816338', 'admin', '2019-12-17 18:33:36.338', '0');
INSERT INTO `logs` VALUES ('1576581300380', 'admin', '2019-12-17 19:15:00.38', '0');
INSERT INTO `logs` VALUES ('1576581342743', 'admin', '2019-12-17 19:15:42.743', '0');
INSERT INTO `logs` VALUES ('1576581848191', 'admin', '2019-12-17 19:24:08.191', '0');
INSERT INTO `logs` VALUES ('1576636367283', 'admin', '2019-12-18 10:32:47.283', '0');
INSERT INTO `logs` VALUES ('1576636677417', 'admin', '2019-12-18 10:37:57.417', '0');
INSERT INTO `logs` VALUES ('1576636719461', 'admin', '2019-12-18 10:38:39.461', '0');
INSERT INTO `logs` VALUES ('1576637347304', 'admin', '2019-12-18 10:49:07.304', '0');
INSERT INTO `logs` VALUES ('1576637479991', 'admin', '2019-12-18 10:51:19.991', '0');
INSERT INTO `logs` VALUES ('1576637573395', 'admin', '2019-12-18 10:52:53.395', '0');
INSERT INTO `logs` VALUES ('1576637608753', 'admin', '2019-12-18 10:53:28.753', '0');
INSERT INTO `logs` VALUES ('1576679976676', 'admin', '2019-12-18 22:39:36.676', '0');
INSERT INTO `logs` VALUES ('1576683186146', 'admin', '2019-12-18 23:33:06.146', '0');
INSERT INTO `logs` VALUES ('1576683740800', 'admin', '2019-12-18 23:42:20.8', '0');
INSERT INTO `logs` VALUES ('1576684661544', 'admin', '2019-12-18 23:57:41.544', '0');
INSERT INTO `logs` VALUES ('1576684740647', 'admin', '2019-12-18 23:59:00.647', '0');
INSERT INTO `logs` VALUES ('1576722354829', 'admin', '2019-12-19 10:25:54.829', '0');
INSERT INTO `logs` VALUES ('1577087591977', 'admin', '2019-12-23 15:53:11.977', '1');
INSERT INTO `logs` VALUES ('1577087597364', 'admin', '2019-12-23 15:53:17.364', '1');
INSERT INTO `logs` VALUES ('1577087602681', 'admin', '2019-12-23 15:53:22.681', '0');
INSERT INTO `logs` VALUES ('1577088513549', 'admin', '2019-12-23 16:08:33.549', '0');
INSERT INTO `logs` VALUES ('1577095002328', 'admin', '2019-12-23 17:56:42.328', '1');
INSERT INTO `logs` VALUES ('1577095012159', 'admin', '2019-12-23 17:56:52.159', '0');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `massage` varchar(2000) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1575470173813', null, '我想找工作', '李四', '2019-12-04', '18224552466', null);
INSERT INTO `message` VALUES ('1575470215098', null, '我的世界都是钱，太难了', '王健林', '2019-12-04', '15228794568', null);
INSERT INTO `message` VALUES ('1575471616304', null, '弄啥啊', '王亚一', '2019-12-04', '18722334568', null);
INSERT INTO `message` VALUES ('1575471976260', null, '卡拉发动机来看离开的房价来看', '余潇潇', '2019-12-04', '15478941234', null);
INSERT INTO `message` VALUES ('1575471998536', null, '都是发发第三方士大夫', '王一', '2019-12-04', '12389743652', null);
INSERT INTO `message` VALUES ('1575472060815', null, '大佛山大叔范围的发达', '余建相', '2019-12-04', '15453259635', null);
INSERT INTO `message` VALUES ('1575472130143', null, '的说法是的都是范德萨发生', '甘家鸥', '2019-12-04', '15432569874', null);
INSERT INTO `message` VALUES ('1575472150793', null, '的说法都是乏味而无法', '发顺丰', '2019-12-04', '12345678901', null);
INSERT INTO `message` VALUES ('1575472175567', null, '大飞洒发顺丰的权威机构', '浪淘沙', '2019-12-04', '18524796308', null);
INSERT INTO `message` VALUES ('1575600621376', null, '不知道为什么心情复杂', '李雨欣', '2019-12-06', '15746892356', null);
INSERT INTO `message` VALUES ('1576049280508', null, '', '', '2019-12-11', '', null);
INSERT INTO `message` VALUES ('1576049294168', null, '', '', '2019-12-11', '', null);
INSERT INTO `message` VALUES ('1576049315978', null, '', '', '2019-12-11', '', null);
INSERT INTO `message` VALUES ('1576125787549', null, null, null, '2019-12-12', null, null);
INSERT INTO `message` VALUES ('1576128867067', null, null, '', '2019-12-12', null, null);
INSERT INTO `message` VALUES ('1576133167169', null, null, '', '2019-12-12', null, null);
INSERT INTO `message` VALUES ('1576133358219', null, null, '', '2019-12-12', null, null);
INSERT INTO `message` VALUES ('1576205954314', null, '', '555', '2019-12-13', '', null);
INSERT INTO `message` VALUES ('1576205994640', null, '', '555', '2019-12-13', '', null);
INSERT INTO `message` VALUES ('1576211898236', null, '', '', '2019-12-13', '', null);
INSERT INTO `message` VALUES ('1576211971032', null, '', '', '2019-12-13', '', null);
INSERT INTO `message` VALUES ('1576212175316', null, '', '', '2019-12-13', '', null);
INSERT INTO `message` VALUES ('1576212311129', null, '', '', '2019-12-13', '', null);
INSERT INTO `message` VALUES ('1576212315337', null, '', '12', '2019-12-13', '', null);
INSERT INTO `message` VALUES ('1576216586847', null, '', '', '2019-12-13', '', null);
INSERT INTO `message` VALUES ('1576216651327', null, '', '', '2019-12-13', '', null);
INSERT INTO `message` VALUES ('1576216682734', null, '', '', '2019-12-13', '', null);
INSERT INTO `message` VALUES ('1576679700655', null, '', '', '2019-12-18', '', null);

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `massage` text,
  `userid` varchar(255) DEFAULT NULL,
  `creattime` varchar(255) DEFAULT NULL,
  `releastime` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `releasuser` varchar(255) DEFAULT NULL,
  `pageview` int(11) DEFAULT NULL,
  `likenum` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `label` int(11) DEFAULT NULL,
  `outline` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1575602385455', '1', '<p><img src=\"/upload/053578.png\" title=\"053578.png\" alt=\"凯里学院logo.png\"/></p>', '1', '2019-12-06 11:19:45.455', '2019-12-06 11:19:48.147', '0', null, null, null, '1573567287156', '0', '1');
INSERT INTO `news` VALUES ('1575602416753', '2', '<p><img src=\"/upload/030800.jpg\" title=\"030800.jpg\" alt=\"SessionPic.jpg\"/></p>', '2', '2019-12-06 11:20:16.753', '2019-12-06 11:20:20.948', '0', null, null, null, '1573567287156', '0', '2');
INSERT INTO `news` VALUES ('1575602442277', '3', '<p><img src=\"/upload/034202.jpg\" title=\"034202.jpg\" alt=\"26_a5_f3_8e_26a5f38eff16ac2975d381e7f556bfb8.jpg\"/></p>', '3', '2019-12-06 11:20:42.277', '2019-12-06 11:20:45.863', '0', null, null, null, '1573567287156', '0', '3');
INSERT INTO `news` VALUES ('1575602460743', '4', '<p><img src=\"/upload/078705.png\" title=\"078705.png\" alt=\"凯里学院logo.png\"/></p>', '4', '2019-12-06 11:21:00.743', '2019-12-06 11:21:35.553', '0', null, null, null, '1573567287156', '0', '4');
INSERT INTO `news` VALUES ('1575602509990', '5', '<p><img src=\"/upload/006582.png\" title=\"006582.png\" alt=\"凯里学院logo.png\"/></p>', '5', '2019-12-06 11:21:49.99', '2019-12-06 11:21:52.777', '0', null, null, null, '1573567287156', '0', '5');
INSERT INTO `news` VALUES ('1575609148243', '大学生', '<p><img src=\"/upload/065834.png\" title=\"065834.png\" alt=\"图片2.png\"/>士大夫撒发</p>', '撒旦法', '2019-12-06 13:12:28.243', '2019-12-06 13:12:32.364', '0', null, null, null, '1574831877717', '0', '大法师法撒旦');
INSERT INTO `news` VALUES ('1575637174658', '123', '<p><img src=\"/upload/071201.png\" title=\"071201.png\" alt=\"图片3.png\"/></p>', '456', '2019-12-06 20:59:34.658', '2019-12-06 20:59:38.765', '0', null, null, null, '1574831858067', '0', '456');
INSERT INTO `news` VALUES ('1575637232809', 'qwer', '<p><img src=\"/upload/021189.png\" title=\"021189.png\" alt=\"图片1.png\"/>大幅度师德师风</p>', '生栋覆屋', '2019-12-06 21:00:32.809', '2019-12-06 21:00:37.268', '0', null, null, null, '1574831858067', '0', 'wwww');
INSERT INTO `news` VALUES ('1575693287294', '1', '<p><img src=\"/upload/093284.jpg\" title=\"093284.jpg\" alt=\"1-160421150R70-L.jpg\"/></p>', '1', '2019-12-07 12:34:47.294', '2019-12-07 12:35:22.248', '0', null, null, null, '-1', '0', '1');
INSERT INTO `news` VALUES ('1575693311669', '1', '<p><img src=\"/upload/078183.jpg\" title=\"078183.jpg\" alt=\"1552101265.jpg\"/></p>', '1', '2019-12-09 23:41:58.509', '2019-12-07 12:35:23.212', '0', null, null, null, '-1', '0', '1');
INSERT INTO `news` VALUES ('1575693388736', '1', '<p><img src=\"/upload/068995.jpg\" title=\"068995.jpg\" alt=\"1552101240.jpg\"/></p>', '1', '2019-12-09 23:41:43.267', '2019-12-07 12:36:32.933', '0', null, null, null, '-1', '0', '1');
INSERT INTO `news` VALUES ('1575904199125', '让他', '<table align=\"center\"><tbody><tr class=\"firstRow\"><td align=\"center\" style=\"font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal;\"><p><img id=\"productpic\" class=\"productpic\" src=\"http://kljzw.net/product/pics/20190309/1552101225.jpg\"/></p></td></tr></tbody></table><p><br/></p>', '安抚', '2019-12-09 23:31:21.572', '2019-12-11 14:31:29.118', '-1', null, null, null, '1573567873106', '0', '发阿萨德');

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `describe` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('1573568132569', '总经理', '最高执行者');
INSERT INTO `position` VALUES ('1573568150859', '董事长', '公司最决策者');
INSERT INTO `position` VALUES ('1574831888639', '秘书', null);

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(255) NOT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1573313241315', 'shangke', '管理员');
INSERT INTO `role` VALUES ('1573478937497', 'asdfa', '普通用户');

-- ----------------------------
-- Table structure for `showactivity`
-- ----------------------------
DROP TABLE IF EXISTS `showactivity`;
CREATE TABLE `showactivity` (
  `id` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `photor` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `massage` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of showactivity
-- ----------------------------
INSERT INTO `showactivity` VALUES ('1575902823980', '学生兼职现场', '/upload/1575905642221.jpg', '2019-12-09 23:34:05.028', '学生发传单');
INSERT INTO `showactivity` VALUES ('1575902854021', '学生兼职现场', '/upload/1575905673741.jpg', '2019-12-09 23:34:35.766', '学生合理分工');
INSERT INTO `showactivity` VALUES ('1575902892883', '学生兼职现场', '/upload/1575905572779.jpg', '2019-12-09 23:32:57.115', '学生入厂培训');
INSERT INTO `showactivity` VALUES ('1575906202723', '学生兼职现场', '/upload/1575906196752.jpg', '2019-12-09 23:43:22.723', '哈哈');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1573567287156', '国内');
INSERT INTO `type` VALUES ('1573567873106', '国外');
INSERT INTO `type` VALUES ('1574831858067', '娱乐');
INSERT INTO `type` VALUES ('1574831877717', '社交');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roleid` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `posititoned` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1573220105087', 'admin', '123', '1573478937497', '15183214321', '1573568132569');
INSERT INTO `user` VALUES ('1573221886997', 'root', '123456', '1573313241315', '15424679465', '1574831888639');
INSERT INTO `user` VALUES ('1573787323034', 'user', 'nice123', '1573313241315', '1563132', '1574831888639');
