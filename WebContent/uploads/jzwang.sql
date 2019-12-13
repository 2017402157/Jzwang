/*
Navicat MySQL Data Transfer

Source Server         : 120.79.42.237_3306
Source Server Version : 50727
Source Host           : 120.79.42.237:3306
Source Database       : jzwang

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-12-10 19:26:06
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of candidate
-- ----------------------------
INSERT INTO `candidate` VALUES ('1573655882903', '李嘉诚', '1', '大学城', '1563165');
INSERT INTO `candidate` VALUES ('1574262341993', '彭波', '0', '关岭沙云', '152654616316');

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1573654227191', '大鹏科技', '大型跨国公司', null, '0666-000-541', 'lkslaj@.com');
INSERT INTO `company` VALUES ('1574831954445', '阿里巴巴', '中国最大企业', null, '000-000-000', '326546@163.com');

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
INSERT INTO `contact` VALUES ('1573529061492', '勤工俭学中心', '1822465855/165456321/456465', '凯里市经济开发区桂花苑', '凯里兼职网', '52262451', '78461663@qq.com');

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of invite
-- ----------------------------
INSERT INTO `invite` VALUES ('1573636250639', '开发区 | 发传单', '凯里开发区凯里学院', '25', '0-6', '无', '12:00-18:00', '10元每小时', '2019-12-04 23:21:39.137', '1573654227191', null, '1574831858067', '0', '发传单李老师大法律框架aj');
INSERT INTO `invite` VALUES ('1574563357023', '家教', '凯里市开发区', '3', '教师', '本科', '每周一到周五', '3000、月', '2019-11-24', '1573654227191', null, '1573567873106', '0', '大丰收电风扇等服务的烦不烦发电房水电费好烦人东方闪电发传单');
INSERT INTO `invite` VALUES ('1574563893417', '凯里 | 清洁小时工', '凯里大十字', '36', '0-5年', '无', '12/24 08:00-18:00', '100人民币', '2019-11-24', '1573654227191', null, '1573567287156', '1', '你来了解了解哦凉快凉快地方呢');
INSERT INTO `invite` VALUES ('1574917773500', '按实际活动', '大健康', '50', '爱神的箭', '大厦', '564564234', '5000', '2019-12-01', '1574831954445', null, '1573567287156', '0', '阿抠脚大汉');
INSERT INTO `invite` VALUES ('1574917791167', '124231', '213', '13', '21', '231', '31', '12', '2019-11-28', '1573654227191', null, '1573567287156', '1', '32131');
INSERT INTO `invite` VALUES ('1575357609830', 'faas ', 'fdasa', '20', 'dsfa', 'fasd', 'dfsa', 'dsaf', '2019-12-03', '1573654227191', null, '1573567287156', null, 'asdf ');
INSERT INTO `invite` VALUES ('1575469159197', '旺旺', '1231231', '123123', '1231', '231', '1231', '500', '2019-12-04', '1573654227191', null, '1573567287156', null, '132');
INSERT INTO `invite` VALUES ('1575513883604', '议程', '1', '1', '1', '1', '1', '1', '2019-12-05 10:44:43.604', '1573654227191', null, '1573567287156', null, '1');
INSERT INTO `invite` VALUES ('1575600792166', '代写文档', '凯里开发区', '20', '要求精通office', '无', '时间不限', '120/每天', '2019-12-06 10:53:12.166', '1574831954445', null, '1574831858067', null, '做文档');
INSERT INTO `invite` VALUES ('2', '买蔬果', '菜市场', '10', '无', '无', '周六', '100每天', '2019-12-03', '1574831954445', null, '1573567873106', null, '刻录机拉可适当');

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
INSERT INTO `logs` VALUES ('1573983305196', 'admin', '2019-11-17', '0');
INSERT INTO `logs` VALUES ('1575462038935', 'admin', '2019-12-04', '0');
INSERT INTO `logs` VALUES ('1575462180354', 'admin', '2019-12-04', '0');
INSERT INTO `logs` VALUES ('1575462459422', 'admin', '2019-12-04 20:27:39.422', '0');
INSERT INTO `logs` VALUES ('1575462548079', 'admin', '2019-12-04 20:29:08.079', '0');
INSERT INTO `logs` VALUES ('1575463413793', 'root', '2019-12-04 20:43:33.793', '1');
INSERT INTO `logs` VALUES ('1575463420066', 'tea', '2019-12-04 20:43:40.066', '1');
INSERT INTO `logs` VALUES ('1575463434712', 'root', '2019-12-04 20:43:54.712', '1');
INSERT INTO `logs` VALUES ('1575463444233', 'root', '2019-12-04 20:44:04.233', '1');
INSERT INTO `logs` VALUES ('1575463472947', 'root', '2019-12-04 20:44:32.947', '0');
INSERT INTO `logs` VALUES ('1575463540991', 'user', '2019-12-04 20:45:40.991', '0');
INSERT INTO `logs` VALUES ('1575464160295', 'admin', '2019-12-04 20:56:00.295', '0');
INSERT INTO `logs` VALUES ('1575464546393', 'root', '2019-12-04 21:02:26.393', '1');
INSERT INTO `logs` VALUES ('1575464553514', 'root', '2019-12-04 21:02:33.514', '0');
INSERT INTO `logs` VALUES ('1575465368808', 'admin', '2019-12-04 21:16:08.808', '0');
INSERT INTO `logs` VALUES ('1575465519702', 'root', '2019-12-04 21:18:39.702', '0');
INSERT INTO `logs` VALUES ('1575465607922', 'user', '2019-12-04 21:20:07.922', '0');
INSERT INTO `logs` VALUES ('1575467049243', 'admin', '2019-12-04 21:44:09.243', '0');
INSERT INTO `logs` VALUES ('1575467138678', 'admin', '2019-12-04 21:45:38.678', '0');
INSERT INTO `logs` VALUES ('1575467312297', 'admin', '2019-12-04 21:48:32.297', '0');
INSERT INTO `logs` VALUES ('1575467460100', 'admin', '2019-12-04 21:51:00.1', '0');
INSERT INTO `logs` VALUES ('1575467547448', 'user', '2019-12-04 21:52:27.448', '0');
INSERT INTO `logs` VALUES ('1575468515716', 'admin', '2019-12-04 22:08:35.716', '0');
INSERT INTO `logs` VALUES ('1575469852889', 'admin', '2019-12-04 22:30:52.889', '0');
INSERT INTO `logs` VALUES ('1575470482288', 'admin', '2019-12-04 22:41:22.288', '0');
INSERT INTO `logs` VALUES ('1575472297080', 'admin', '2019-12-04 23:11:37.08', '0');
INSERT INTO `logs` VALUES ('1575472342698', 'admin', '2019-12-04 23:12:22.698', '0');
INSERT INTO `logs` VALUES ('1575472387742', 'admin', '2019-12-04 23:13:07.742', '0');
INSERT INTO `logs` VALUES ('1575473336528', 'admin', '2019-12-04 23:28:56.528', '0');
INSERT INTO `logs` VALUES ('1575512926202', 'root', '2019-12-05 10:28:46.202', '0');
INSERT INTO `logs` VALUES ('1575533680121', 'admin', '2019-12-05 16:14:40.121', '0');
INSERT INTO `logs` VALUES ('1575534809659', 'admin', '2019-12-05 16:33:29.659', '0');
INSERT INTO `logs` VALUES ('1575538338582', 'admin', '2019-12-05 17:32:18.582', '0');
INSERT INTO `logs` VALUES ('1575538448968', 'admin', '2019-12-05 17:34:08.968', '0');
INSERT INTO `logs` VALUES ('1575539296673', 'admin', '2019-12-05 17:48:16.673', '0');
INSERT INTO `logs` VALUES ('1575539578662', 'admin', '2019-12-05 17:52:58.662', '0');
INSERT INTO `logs` VALUES ('1575552237290', 'admin', '2019-12-05 21:23:57.29', '0');
INSERT INTO `logs` VALUES ('1575599270341', 'admin', '2019-12-06 10:27:50.341', '0');
INSERT INTO `logs` VALUES ('1575599566103', 'admin', '2019-12-06 10:32:46.103', '0');
INSERT INTO `logs` VALUES ('1575599728690', 'admin', '2019-12-06 10:35:28.69', '0');
INSERT INTO `logs` VALUES ('1575602358015', 'admin', '2019-12-06 11:19:18.015', '0');
INSERT INTO `logs` VALUES ('1575609000610', 'admin', '2019-12-06 13:10:00.61', '0');
INSERT INTO `logs` VALUES ('1575609230066', 'admin', '2019-12-06 13:13:50.066', '0');
INSERT INTO `logs` VALUES ('1575613430106', 'admin', '2019-12-06 14:23:50.106', '0');
INSERT INTO `logs` VALUES ('1575618527582', 'admin', '2019-12-06 15:48:47.582', '0');
INSERT INTO `logs` VALUES ('1575636707978', 'admin', '2019-12-06 20:51:47.978', '0');
INSERT INTO `logs` VALUES ('1575639862259', 'admin', '2019-12-06 21:44:22.26', '0');
INSERT INTO `logs` VALUES ('1575640687536', 'admin', '2019-12-06 21:58:07.536', '0');
INSERT INTO `logs` VALUES ('1575641379017', 'admin', '2019-12-06 22:09:39.017', '0');
INSERT INTO `logs` VALUES ('1575641993299', 'admin', '2019-12-06 22:19:53.299', '0');
INSERT INTO `logs` VALUES ('1575691281959', 'admin', '2019-12-07 12:01:21.959', '0');
INSERT INTO `logs` VALUES ('1575693219809', 'admin', '2019-12-07 12:33:39.809', '0');
INSERT INTO `logs` VALUES ('1575728601665', 'admin', '2019-12-07 22:23:21.665', '0');
INSERT INTO `logs` VALUES ('1575795780456', 'admin', '2019-12-08 17:03:00.456', '0');
INSERT INTO `logs` VALUES ('1575872323227', 'admin', '2019-12-09 14:18:43.227', '0');
INSERT INTO `logs` VALUES ('1575888976021', 'admin', '2019-12-09 18:56:16.021', '0');
INSERT INTO `logs` VALUES ('1575902588551', 'admin', '2019-12-09 22:43:08.551', '0');
INSERT INTO `logs` VALUES ('1575902981561', 'admin', '2019-12-09 22:49:41.561', '0');
INSERT INTO `logs` VALUES ('1575904986097', 'admin', '2019-12-09 23:23:06.098', '0');
INSERT INTO `logs` VALUES ('1575937438295', 'admin', '2019-12-10 08:23:58.295', '1');
INSERT INTO `logs` VALUES ('1575937452640', 'admin', '2019-12-10 08:24:12.64', '0');

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
INSERT INTO `news` VALUES ('1575904199125', '让他', '<table align=\"center\"><tbody><tr class=\"firstRow\"><td align=\"center\" style=\"font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: normal;\"><p><img id=\"productpic\" class=\"productpic\" src=\"http://kljzw.net/product/pics/20190309/1552101225.jpg\"/></p></td></tr></tbody></table><p><br/></p>', '安抚', '2019-12-09 23:31:21.572', '2019-12-09 23:10:40.308', '0', null, null, null, '1573567873106', '0', '发阿萨德');

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
