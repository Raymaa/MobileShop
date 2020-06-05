-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2017-01-13 07:58:20
-- 服务器版本： 5.6.32
-- PHP Version: 5.6.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mobile_shop`
--

-- --------------------------------------------------------

--
-- 表的结构 `ms_admin`
--

CREATE TABLE `ms_admin` (
  `admin_id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `sex` smallint(6) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_admin`
--

INSERT INTO `ms_admin` (`admin_id`, `username`, `password`, `email`, `real_name`, `sex`, `mobile`, `role_id`, `creatime`, `modifytime`) VALUES
(3, 'ls2016', '4QrcOUm6Wau+VuBX8g+IPg==', 'ls@qq.com', '李四', 1, '13398765432', 2, '2016-12-01 00:54:07', '2016-12-01 08:33:41'),
(4, 'wangwu', '1B2M2Y8AsgTpgAmY7PhCfg==', 'www@qq.com', '王五五', 0, '18976544321', 3, '2016-12-01 06:59:43', '2016-12-20 02:49:38'),
(5, 'zs2016', '4QrcOUm6Wau+VuBX8g+IPg==', 'zs@qq.com', '张三', 0, '13323456789', 1, '2016-12-01 08:31:18', '2016-12-01 08:35:24'),
(39, '', 'lueSGJZetyySpUndWjMBEg==', '', 'zhangsansan', 0, '18909876543', 3, '2016-12-27 08:00:04', '2016-12-27 08:00:04'),
(40, '', 'lueSGJZetyySpUndWjMBEg==', '', '李思思', 0, '13365479876', 3, '2016-12-29 02:03:29', '2016-12-29 02:03:29'),
(41, '', 'lueSGJZetyySpUndWjMBEg==', '', 'åé', 0, '18923456633', 1, '2016-12-29 02:03:54', '2016-12-29 02:03:54'),
(42, '', 'lueSGJZetyySpUndWjMBEg==', '', 'å°ç', 0, '1232321122', 2, '2016-12-29 02:38:06', '2016-12-29 02:38:06'),
(43, '', 'lueSGJZetyySpUndWjMBEg==', '', '小张', 0, '12234553', 1, '2016-12-29 02:40:15', '2016-12-29 02:40:15'),
(44, '', 'lueSGJZetyySpUndWjMBEg==', '', 'å°æ¾', 0, '1829233122', 1, '2016-12-29 02:44:53', '2016-12-29 02:44:53'),
(45, '', 'lueSGJZetyySpUndWjMBEg==', '', '小张', 0, '12234554', 1, '2016-12-29 03:22:40', '2016-12-29 03:22:40'),
(46, '', 'lueSGJZetyySpUndWjMBEg==', '', '小红', 0, '1892733234', 2, '2016-12-29 07:00:02', '2016-12-29 07:00:02'),
(47, '', 'lueSGJZetyySpUndWjMBEg==', '', '华国锋度过', 0, '123333222', 1, '2016-12-29 07:36:31', '2016-12-29 07:36:31');

-- --------------------------------------------------------

--
-- 表的结构 `ms_brand`
--

CREATE TABLE `ms_brand` (
  `brand_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `keywords` text,
  `description` text,
  `url` varchar(255) DEFAULT NULL,
  `disabled` tinyint(4) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_brand`
--

INSERT INTO `ms_brand` (`brand_id`, `name`, `logo`, `keywords`, `description`, `url`, `disabled`, `creatime`, `modifytime`) VALUES
(2, '良品铺子', '', '休闲食品', '良品铺子是一家集休闲食品研发、加工分装、零售服务的专业品牌连锁运营公司', '', 0, '2016-09-07 07:02:05', '2016-09-07 07:02:05'),
(3, '三只松鼠', '', '坚果，零食', '三只松鼠成立于2012年,是中国当前最大的互联网食品品牌，其坚果系列位居全网销量第一', '', 0, '2016-09-07 07:04:35', '2016-09-07 07:04:35'),
(4, 'ochirly', '', '女装', 'ochirly欧时力设计主题:复古星魅、魅惑几何、迷人条纹。', '', 0, '2016-09-07 07:06:12', '2016-09-07 07:06:12'),
(5, '美之源', '', '果汁', '美汁源是第一家进入浓缩果汁市场的公司。由可口可乐公司所拥有，为世界最大的果汁饮料销售商。', '', 0, '2016-09-08 00:57:52', '2016-09-09 02:40:54'),
(6, '汇源', '', '果汁', '汇源果汁是由中国汇源果汁集团生产的一系列果汁产品,“汇源果汁”是中国果汁行业知名品牌。', '', 0, '2016-09-08 00:59:17', '2016-09-08 00:59:17'),
(7, '和其正', '', '凉茶', '和其正是福建达利园集团生产的一个凉茶的名称，是中国凉茶行业的一支劲旅，一匹黑马。', '', 0, '2016-09-08 01:00:48', '2016-09-08 01:00:48'),
(9, '康师傅', '', '饮料，方便面，糕饼', '康师傅控股有限公司（康师傅公司），总部设于天津市，主要在中国从事生产和销售方便面、饮品、糕饼以及相关配套产业的经营。', '', 0, '2016-09-08 01:21:42', '2016-09-08 01:21:42'),
(10, '迪奥', '', '女装、男装、首饰、香水、化妆品,童装', '迪奥公司由法国时装设计师克里斯汀·迪奥（Christian Dior）创立，总部设在巴黎。主要经营女装、男装、首饰、香水、化妆品,童装等高档消费品', 'http://www.dior.cn', 0, '2016-10-17 03:29:00', '2016-10-17 03:29:00'),
(11, '范思哲Versace', '', '女装、男装、香水', '该品牌创立于1978年，品牌标志是神话中的蛇妖美杜莎（Medusa），代表着致命的吸引力', 'http://www.versace.com', 0, '2016-10-17 03:59:37', '2016-10-17 08:49:50'),
(13, 'Armani', 'Armani', '女装、男装、香水', '国际服装品牌', 'Armani', 0, '2016-11-01 06:58:40', '2016-12-27 08:08:15'),
(20, '兰蔻', 'lancom', '法国', '兰蔻1935年诞生于法国，是由Armand Petitjean（阿曼达·珀蒂让）创办的品牌。作为全球知名的高端化妆品品牌，兰蔻涉足护肤、彩妆、香水等多个产品领域，主要面向教育程度、收入水平较高，年龄在25～40岁的成熟女性。', 'http://www.lancome.com.cn/', 0, '2017-01-13 01:18:56', '2017-01-13 01:18:56'),
(21, '佰草集', '佰草集', '中草药国产', '佰草集承袭古方经典，全新推出高端“御·五行焕肌系列”，以“五行焕肌方”融汇珍贵草本精华, 结合现代M³微囊技术，层层包裹活性物质，持久缓慢释放，深层焕活肌肤，使肌肤焕发年轻状态。', 'www.herborist.com.cn ', 0, '2017-01-13 01:23:49', '2017-01-13 01:23:49'),
(22, '雅诗兰黛', '雅诗兰黛', '美国抗衰修护', '雅诗兰黛是美国雅诗兰黛公司旗下的化妆品旗舰品牌，以抗衰修护护肤品闻名。雅诗兰黛公司是全球领先的大型生产商和销售商。', 'http://www.esteelauder.com.cn/', 0, '2017-01-13 01:26:44', '2017-01-13 01:26:44'),
(23, 'VS沙宣洗发水', 'VS沙宣洗发水', '护发', '破格的护发素新理念, 由沙宣每日焕发塑全新演绎。沙宣每日焕发塑,内含发型易控配方,为塑型打好基础,提升发丝塑型潜力。', 'www.vs.com.cn/ ', 0, '2017-01-13 01:28:52', '2017-01-13 01:28:52'),
(24, '施华蔻', 'Schwarzkopf', '护发', '施华蔻，世界三大美发品牌之一，受到众多国际专业发型师的认可和推崇。施华蔻，秉承德国尖端美发科技，专注发质问题，成就百年专业沙龙美发品牌!', 'http://www.schwarzkopf.cn/skcn/zh/home.html', 0, '2017-01-13 01:33:43', '2017-01-13 01:33:43'),
(25, '优衣库', 'UNIQLO', '服装', 'UNIQLO（日文假名发音：ユニクロ），日本服装品牌，由日本迅销公司建立于1963年，当年是一家销售西服的小服装店，现已成为国际知名服装品牌。', 'http://www.uniqlo.com', 0, '2017-01-13 01:38:22', '2017-01-13 01:38:22'),
(26, '李维斯', 'Levi\'s', '服装', 'Levi\'s（李维斯）是来自美国西部最闻名的名字之一。', 'http://www.levi.com.cn', 0, '2017-01-13 01:39:41', '2017-01-13 01:39:41'),
(27, '百家好', 'BASIC HOUSE', '服装', '百家好，韩国品牌BASIC HOUSE，1996年在韩国成立，它是目前韩国品牌中知名度和销量双第一的品牌，BASIC HOUSE在韩国已经成为最受大众欢迎的品牌。', 'http://www.baijiahao.com', 0, '2017-01-13 01:41:25', '2017-01-13 01:41:25'),
(28, '维尼熊', 'Teenie Weenie小熊', '服装', 'Teenie Weenie中文名“维尼熊”可不是英国的小熊维尼，它是韩国衣恋集团品牌持有人。韩国自创品牌“TEENIE WEENIE”的休闲装深受年轻一代的喜爱，除了卡通小熊顽皮多样的造型，它轻松自然的设计风格、舒适柔和的质地也深受年轻一代的喜爱。', 'http://www.teenieweenie.com.cn', 0, '2017-01-13 01:43:45', '2017-01-13 01:43:45'),
(29, '爱慕', '爱慕aimer', '内衣', '爱慕集团（以下简称“爱慕”）专业从事高端品牌内衣及服饰的设计、生产和营销，总部位于北京市朝阳区', 'www.aimer.com.cn', 0, '2017-01-13 01:46:06', '2017-01-13 01:46:06'),
(30, '百丽', 'Belle', '鞋', 'Belle百丽是百丽国际推出的一款品牌。BeLLE百丽追求不同的生活体验及生活经历；都市环境不断在变，时装潮流不断在变，生活内容不断在变，女人在一生中的角色不断在变。BeLLE百丽在变化中展现出内在与外在的完美气质。Belle皮件简单分成女用与男用，内容包括皮包、皮带、皮夹、名片夹、旅行箱、皮件保养品等。百丽国际旗下百丽、天美意、他她、思加图等均在国内女鞋销量市场名列前茅，森达男鞋也备受消费者欢迎。', 'www.belle.com.cn', 0, '2017-01-13 01:48:20', '2017-01-13 01:48:20'),
(31, '千百度', 'cbanner', '鞋', '品牌介绍cbanner千百度，一个富有文化和浪漫气息的时尚品牌，蕴含米兰时尚风潮，是美丽华实业公司旗下主打品牌之一。', 'www.c-banner.com', 0, '2017-01-13 01:49:35', '2017-01-13 01:49:35'),
(32, '雅士', 'achette', '鞋', '雅氏,英文名称：achette 。始创于1968年，专注于高端休闲时尚鞋履的设计与制作。', 'http://www.arche-shoes.com.cn/', 0, '2017-01-13 01:50:43', '2017-01-13 01:50:43'),
(33, '周大福', 'CHOW TAI FOOK', '珠宝', '周大福拥有广泛的零售网络,珠宝首饰与钟表零售点合共约2300 个。以下为附近的周大福旗舰店。 ', 'http://www.ctf.com.cn', 0, '2017-01-13 01:52:27', '2017-01-13 01:52:27'),
(34, '周生生', 'chowsangsang', '珠宝', '周生生立足经典,创意不断,糅合现代设计灵感,呈现恒久时尚魅力的新颖杰作.「周而复始 生生不息」', 'http://cn.chowsangsang.com/', 0, '2017-01-13 01:53:10', '2017-01-13 01:53:10'),
(35, '施华洛世奇', 'Swarovski', '珠宝', '1895年，来自波希米亚的发明家丹尼尔·施华洛世奇（Daniel Swarovski）以其远见卓识，携同他最新发明的仿水晶首饰石切割打磨机器，移居到奥地利泰利莱郡的华登斯市。自此，施华洛世奇开始在时尚世界中迸发火花', 'http://www.Swarovski.com/', 0, '2017-01-13 01:54:50', '2017-01-13 01:54:50'),
(36, '小米', 'mi', '手机', '北京小米科技有限责任公司成立2010年4月，是一家专注于智能硬件和电子产品研发的移动互联网公司。“为发烧而生”是小米的产品概念。', 'mi.com', 0, '2017-01-13 01:57:31', '2017-01-13 01:57:31'),
(37, '华为', 'HUAWEI', '电子信息', '华为手机隶属于华为消费者业务，作为华为三大核心业务之一，华为消费者业务始于2003年底，经过十余年的发展，在在中国、俄罗斯、德国、瑞典、印度及美国等地设立了16个研发中心', 'http://www.vmall.com/list-36', 0, '2017-01-13 02:04:11', '2017-01-13 02:04:11'),
(38, '酷派', 'Coolpad', '电子信息', '酷派（Coolpad）是宇龙计算机通信科技（深圳）有限公司的手机品牌，创立于1993 年4月，是酷派集团有限公司（香港主板上市公司，股票代码 2369）的全资附属子公司', 'www.coolpad.com/', 0, '2017-01-13 02:05:13', '2017-01-13 02:05:13'),
(39, '苹果', 'Apple', '电子信息', '苹果公司（Apple Inc. ）是美国的一家高科技公司。由史蒂夫·乔布斯、斯蒂夫·沃兹尼亚克和罗·韦恩(Ron Wayne)等人于1976年4月1日创立', 'www.apple.com/cn/', 0, '2017-01-13 02:05:53', '2017-01-13 02:05:53'),
(40, '旺旺', '旺旺', '绿色食品、牛奶、小孩最爱', '旺旺公司之业务可追溯至台湾宜兰食品工业股份有限公司。旺旺公司于1992年正式投资大陆市场，是台湾第一个在大陆注册商标并且拥有最多注册商标的公司', 'www.wangwang.com', 0, '2017-01-13 03:21:24', '2017-01-13 03:21:24'),
(41, '泸州老窖', '泸州老窖', '酒水', '泸州老窖(jiào)是中国最古老的四大名酒之一，“浓香鼻祖，酒中泰斗”，中国大型白酒上市公司（深交所股票代码000568）。其1573国宝窖池群1996年成为行业首家全国重点文物保护单位，传统酿制技艺2006年又入选首批国家级非物质文化遗产名录，世称“双国宝单位”', 'www.lzlj.com', 0, '2017-01-13 03:45:30', '2017-01-13 03:45:30'),
(42, '雅顿第五大道', '雅顿第五大道', '雅顿第五大道', '香水', '香水', 0, '2017-01-13 04:52:34', '2017-01-13 04:52:34'),
(43, '爱马仕', '爱马仕', '爱马仕', '香水', '香水', 0, '2017-01-13 04:53:46', '2017-01-13 04:53:46'),
(44, 'Burberry巴宝莉', 'Burberry巴宝莉', 'Burberry巴宝莉', '香水', '香水', 0, '2017-01-13 04:54:25', '2017-01-13 04:54:25'),
(45, 'Bvlgari Rose宝格丽', 'Bvlgari Rose宝格丽', 'Bvlgari Rose宝格丽', '香水', '香水', 0, '2017-01-13 04:55:10', '2017-01-13 04:55:10');

-- --------------------------------------------------------

--
-- 表的结构 `ms_cart`
--

CREATE TABLE `ms_cart` (
  `cart_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `goods_num` int(11) DEFAULT NULL,
  `choose` tinyint(4) DEFAULT NULL,
  `amount` decimal(20,2) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_cart`
--

INSERT INTO `ms_cart` (`cart_id`, `member_id`, `goods_id`, `goods_num`, `choose`, `amount`, `creatime`, `modifytime`) VALUES
(8, 5, 32, 2, 1, 19.80, '2016-11-22 06:22:50', '2016-12-06 02:40:38'),
(9, 16, 31, 2, 1, 39.80, '2016-11-23 01:58:23', '2016-12-27 08:22:00'),
(13, 16, 32, 2, 1, 19.80, '2016-12-29 03:44:47', '2016-12-29 03:45:51');

-- --------------------------------------------------------

--
-- 表的结构 `ms_goods`
--

CREATE TABLE `ms_goods` (
  `goods_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sn` varchar(50) NOT NULL,
  `brief` varchar(255) NOT NULL,
  `description` text,
  `price` decimal(20,2) NOT NULL,
  `cost` decimal(20,2) NOT NULL,
  `mktprice` decimal(20,2) NOT NULL,
  `mkt_enable` tinyint(4) NOT NULL,
  `cat_id` int(11) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `weight` decimal(20,2) NOT NULL,
  `intro` text,
  `params` text,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modify` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `view_count` int(11) DEFAULT NULL,
  `buy_count` int(11) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `big` varchar(255) DEFAULT NULL,
  `small` varchar(255) DEFAULT NULL,
  `original` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_goods`
--

INSERT INTO `ms_goods` (`goods_id`, `name`, `sn`, `brief`, `description`, `price`, `cost`, `mktprice`, `mkt_enable`, `cat_id`, `brand_id`, `weight`, `intro`, `params`, `creatime`, `last_modify`, `view_count`, `buy_count`, `thumbnail`, `big`, `small`, `original`) VALUES
(39, 'Burberry巴宝莉红粉恋歌女士香水', 'sp123456', 'Burberry出品的Brit Sheer（红粉恋歌）便如同一位高唱恋歌的少女。', '30/50/100ml气质优雅包邮', 280.00, 220.00, 300.00, 1, 23, 5, 200.00, '商品品牌	Hermes / 爱马仕', '{"产地":"","净含量":"","保质期":"","口味":""}', '2016-12-29 09:09:14', '2017-01-05 09:05:26', 1, 0, '', '', '', ''),
(43, '正品Davidoff 大卫杜夫冷水女士淡香水2', 'sp123457', 'Cool Water（冷水）女士香水可以说是男用香水的一款延伸之作', '30/50/100ml气质优雅包邮', 89.00, 80.00, 90.00, 1, 23, 5, 300.00, '商品品牌  Davidoff/大卫杜夫', '{"产地":"","净含量":"","保质期":"","口味":""}', '2017-01-05 01:43:23', '2017-01-05 09:05:23', 0, 0, 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_big.jpg', 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_small.jpg', 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_orig.jpg'),
(83, '旺旺 旺仔牛奶245ml*12罐 红罐8+绿罐4 新老包装交替', 'sn001', '旺旺 旺仔牛奶245ml*12罐 红罐8+绿罐4 新老包装交替', '旺旺 旺仔牛奶245ml*12罐 红罐8+绿罐4 新老包装交替', 38.00, 20.00, 40.00, 0, 62, 40, 2940.00, '<img src="/MobileShop/upload/kindeditor/image/96jz34UeExOINrY8Gg7lhQ==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/XNPsL+Rjx1mohoJ0Q7It8Q==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/0E15y6cphCLX5XKgeCECng==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/jlGl2dUtA2jQjS1h4jFJcw==.jpg" alt="" />', '{"产地":"","净含量":"","保质期":"","口味":""}', '2017-01-13 03:27:01', '2017-01-13 03:27:01', 2, 0, 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_big.jpg', 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_small.jpg', 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_orig.jpg'),
(84, '泸州老窖六年陈头曲52度 浓香型白酒 整箱500ml*6瓶', 'sn002', '泸州老窖六年陈头曲52度 浓香型白酒 整箱500ml*6瓶', '泸州老窖六年陈头曲52度 浓香型白酒 整箱500ml*6瓶', 349.00, 200.00, 400.00, 0, 6, 2, 9300.00, '<img src="/MobileShop/upload/kindeditor/image/XnDb7JeYaFGlzSC7kvDUUQ==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/cQvQKHlnK4YvxjXaAl21Ag==.jpg" alt="" />', '{"产地":"泸州","储存方法":"密闭","品种":"白酒","净含量":"9300","保质期":"十年","配料":""}', '2017-01-13 03:52:09', '2017-01-13 03:52:09', 2, 0, 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_thum.jpg', 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_big.jpg', 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_small.jpg', 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_orig.jpg'),
(85, '雅顿第五大道香水女士持久淡香125ml正品代购包邮', 'sn003', '雅顿第五大道', '第五大道表达女性自信、现代以及智慧优雅的一面，适合现代都市中自信、时尚又追求个人风格的女性。是女孩们最经典的入门香水！注：此商品为新版包装，喷头是塑料喷头不是金属喷头哦~', 199.00, 120.00, 266.00, 0, 63, 42, 1000.00, '<p>\n	<br />\n</p>\n<p>\n	<img src="/MobileShop/upload/kindeditor/image/qJxQb3Vq8gS8skjncQ3OCw==.jpg" alt="" />\n</p>\n<p>\n	<img src="/MobileShop/upload/kindeditor/image/nz8Q5bPWC31H1dvM62MyGQ==.jpg" alt="" />\n</p>\n<p>\n	<img src="/MobileShop/upload/kindeditor/image/ePiRQ0detuYhc7k80T+4uA==.jpg" alt="" />\n</p>', '{"产地":"美国","适用人群":"任何人群","香调":"花香调 东方香调","规格":"125mL","保质期":"3年"}', '2017-01-13 06:15:31', '2017-01-13 06:15:31', 0, 0, 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_big.jpg', 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_small.jpg', 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_orig.jpg'),
(86, '正品Hermes爱马仕尼罗河花园女士香水30/50/100ML超凡脱俗包邮', 'sn004', '正品Hermes爱马仕尼罗河花园女士香水30/50/100ML超凡脱俗包邮', '正品Hermes爱马仕尼罗河花园女士香水30/50/100ML超凡脱俗包邮', 265.00, 200.00, 300.00, 0, 63, 43, 300.00, '<img src="/MobileShop/upload/kindeditor/image/KIzQIb44OVjCaF8BQZYf+g==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/M0mNCEEXDrfcgvJHdV5BKA==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/XifuOStWPiQd40LSMadA2w==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/bd4b4kc9eLUA6MbJrKx1vg==.jpg" alt="" />', '{"产地":"法国","适用人群":"女士","香调":"花果香调","规格":"100mL","保质期":"5年"}', '2017-01-13 06:22:09', '2017-01-13 06:22:09', 1, 0, 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_big.jpg', 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_small.jpg', 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_orig.jpg'),
(87, '正品Bvlgari Omnia Amethyste 花舞轻盈女香65ML简装外盒包邮', 'sn005', '正品Bvlgari Omnia Amethyste 花舞轻盈女香65ML简装外盒包邮', '正品Bvlgari Omnia Amethyste 花舞轻盈女香65ML简装外盒包邮', 215.00, 130.00, 300.00, 0, 63, 45, 500.00, '<img src="/MobileShop/upload/kindeditor/image/pZ2ET+GkovAYo8uPooPkIw==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/DyWfOwn9JV0RfBRluVyrkw==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/kex57I7Al73JJjITKO14rw==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/XtKkP9TPWzYKaH3Av8E08g==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/4TuP840bD5ZlRPnq5DM5ag==.jpg" alt="" />', '{"产地":"意大利","适用人群":"女生","香调":"花香调 树木香调","规格":"65mL","保质期":"5年"}', '2017-01-13 06:29:09', '2017-01-13 06:29:09', 0, 0, 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_thum.jpg', 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_big.jpg', 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_small.jpg', 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_orig.jpg'),
(88, '正品Bvlgari man宝格丽当代绅士男淡香30ml/60ml/100ml/150ml包邮', 'sn006', '正品Bvlgari man宝格丽当代绅士男淡香30ml/60ml/100ml/150ml包邮', '为创造出一种崭新、珍贵且充满活力的嗅觉体验，BVLGARI MAN散发出东方的白木香味，诠译出全新的男性典范。强烈的木质香气，令一向在男性香水中扮演传统元素的成分因加入自然纯净的微妙光采，变得更加出色。', 225.00, 130.00, 280.00, 0, 63, 45, 400.00, '<img src="/MobileShop/upload/kindeditor/image/tKWU3ZhZqb3OnOnHpOnTag==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/M5oN7aGQyjl8jk3wzlXmwg==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/L3J7wNjNx+m0xBn1XAHZkw==.jpg" alt="" />', '{"产地":"意大利","适用人群":"男士","香调":"树木香调","规格":"150mL","保质期":"5年"}', '2017-01-13 06:38:06', '2017-01-13 06:38:06', 0, 0, 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_thum.jpg', 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_big.jpg', 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_small.jpg', 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_orig.jpg'),
(89, '正品Bvlgari Pour Homme宝格丽大吉岭茶中性香水30/50/100ML包邮', 'sn007', '正品Bvlgari Pour Homme宝格丽大吉岭茶中性香水30/50/100ML包邮', '在2006年，Bvlgari针对旗下的经典香水全面推出新改版，更加精緻的瓶身及外盒设计，更能显现出宝格丽的品牌精神！宝格丽大吉岭极緻中性香水，献给自然优雅、充满自信的你。无比魅力的秘密，就是沉稳而果决的风格与出人意表的性感。', 216.00, 180.00, 280.00, 0, 63, 45, 150.00, '<img src="/MobileShop/upload/kindeditor/image/V+JBV3kyZFlw6DRjjLMuNw==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/I9WsFDEeDKeXK7j4eoXBBw==.jpg" alt="" />', '{"产地":"意大利","适用人群":"男士","香调":"花香调 树木香调","规格":"65mL","保质期":"5年"}', '2017-01-13 06:43:56', '2017-01-13 06:43:56', 0, 0, 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_big.jpg', 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_small.jpg', 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_orig.jpg'),
(90, '周大福珠宝十二生肖猴足金黄金吊坠(工费:48计价)F189132', 'sn008', '周大福珠宝十二生肖猴足金黄金吊坠(工费:48计价)F189132', '周大福珠宝十二生肖猴足金黄金吊坠(工费:48计价)F189132', 1232.00, 1000.00, 1300.00, 0, 46, 33, 4.00, '<img src="/MobileShop/upload/kindeditor/image/PDC4hRdiZnbw2nwGiGPlqQ==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/cOkWV7xG2STFguc3igoGTg==.jpg" alt="" />', '{"产地":"周大福","重量":"4","贵重金属成分":"千足金","售后服务":"专柜联保 店铺保修","款式":"吊坠"}', '2017-01-13 06:48:52', '2017-01-13 06:48:52', 0, 0, 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_big.jpg', 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_small.jpg', 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_orig.jpg'),
(91, '周生生珠宝18K黄金钻石戒指钻戒女款首饰48926R', 'sn009', '周生生珠宝18K黄金钻石戒指钻戒女款首饰48926R', '周生生珠宝18K黄金钻石戒指钻戒女款首饰48926R', 1800.00, 1300.00, 2300.00, 0, 47, 34, 5.00, '<img src="/MobileShop/upload/kindeditor/image/a1zazmNRZTWiubdxEsrNjA==.jpg" alt="" /><img src="/MobileShop/upload/kindeditor/image/V+x9Hx25ZxuQxVf5LXF7Tw==.jpg" alt="" />', '{"产地":"香港","重量":"10分","贵重金属成分":"钻石 黄18K金","售后服务":"店铺保修","款式":"戒指/指环"}', '2017-01-13 06:54:22', '2017-01-13 06:54:22', 0, 0, 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_big.jpg', 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_small.jpg', 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_orig.jpg'),
(92, 'Belle/百丽专柜同款牛皮男豆豆鞋懒人鞋驾车鞋男鞋3LQ01AM5', 'sn010', 'Belle/百丽专柜同款牛皮男豆豆鞋懒人鞋驾车鞋男鞋3LQ01AM5', 'Belle/百丽专柜同款牛皮男豆豆鞋懒人鞋驾车鞋男鞋3LQ01AM5', 320.00, 190.00, 360.00, 0, 42, 30, 300.00, '<h1 style="font-size:16px;font-family:&quot;background-color:#FFFFFF;">\n	Belle/百丽专柜同款牛皮男豆豆鞋懒人鞋驾车鞋男鞋3LQ01AM5\n</h1>', '{"产地":"中国大陆","适合对象":"男士","材质":"牛皮","鞋跟":"无","款式":"男士"}', '2017-01-13 06:59:11', '2017-01-13 06:59:11', 0, 0, '', '', '', ''),
(93, 'ochirly欧时力2016新女冬装时尚纯色立领宽松棉衣外套', 'sn011', 'ochirly欧时力2016新女冬装时尚纯色立领宽松棉衣外套', 'ochirly欧时力2016新女冬装时尚纯色立领宽松棉衣外套', 221.00, 100.00, 399.00, 0, 10, 4, 300.00, '<span style="color:#666666;font-family:Arial, &quot;font-size:16px;font-weight:bold;background-color:#FFFFFF;">ochirly欧时力2016新女冬装时尚纯色立领宽松棉衣外套</span>', '{"袖长":"57","流行元素":"朋克","风格":"大衣","衣长":"60"}', '2017-01-13 07:02:28', '2017-01-13 07:02:28', 0, 0, '', '', '', '');

-- --------------------------------------------------------

--
-- 表的结构 `ms_goods_cat`
--

CREATE TABLE `ms_goods_cat` (
  `cat_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `cat_path` varchar(100) NOT NULL,
  `goods_count` int(8) DEFAULT NULL,
  `sort` int(5) DEFAULT NULL,
  `type_id` int(11) NOT NULL,
  `list_show` tinyint(4) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_goods_cat`
--

INSERT INTO `ms_goods_cat` (`cat_id`, `name`, `parent_id`, `cat_path`, `goods_count`, `sort`, `type_id`, `list_show`, `image`, `creatime`, `modifytime`) VALUES
(1, '饮料', 0, '0,1', 29, 5, 4, 0, '', '2016-09-08 03:48:15', '2016-09-08 03:48:15'),
(2, '果蔬饮料', 1, '0,1,1', 3, 0, 4, 0, 'http://192.168.8.7:8080/MobileShop/upload/tBclLnhwPWOuqnmTucAmEQ==_cat.jpg', '2016-09-08 03:50:27', '2016-09-08 03:50:27'),
(4, '茶饮料', 1, '0,1,2', 20, 1, 4, 0, 'http://192.168.8.7:8080/MobileShop/upload/vfqHtnnhfSumARZ7vNMn4A==_cat.jpg', '2016-09-08 03:55:00', '2016-09-09 07:12:21'),
(5, '酒水', 0, '0,2', 16, 0, 5, 0, '', '2016-10-25 01:07:25', '2016-10-25 01:07:25'),
(6, '白酒', 5, '0,2,1', 3, 0, 5, 0, 'http://192.168.8.7:8080/MobileShop/upload/5QKpME9Z1o4R3euWiuxZvw==_cat.jpg', '2016-10-25 03:06:51', '2016-10-25 03:06:51'),
(7, '啤酒', 5, '0,2,2', 13, 0, 5, 0, 'http://192.168.8.7:8080/MobileShop/upload/sK3TGZANyypRmQ+jhkznzw==_cat.jpg', '2016-10-25 03:07:35', '2016-10-25 03:07:35'),
(9, '服装', 0, '0,3', 2, 0, 7, 0, '', '2016-10-25 03:31:01', '2016-10-25 03:31:01'),
(10, '女装', 9, '0,3,1', 1, 0, 7, 0, 'http://192.168.8.7:8080/MobileShop/upload/GmQwVhdq96/K+D275zkCbg==.jpg', '2016-10-25 03:31:31', '2016-10-25 03:31:31'),
(11, '男装', 9, '0,3,2', 1, 0, 7, 0, 'http://192.168.8.7:8080/MobileShop/upload/3888-2015-12-09065352-1449687232329.jpg', '2016-10-25 03:31:58', '2016-10-25 03:31:58'),
(12, '童装', 9, '0,3,3', 0, 0, 7, 0, 'http://192.168.8.7:8080/MobileShop/upload/vRzPbCBoUk9mLXFJMQjmhg==_small.jpg', '2016-10-26 03:52:39', '2016-10-26 03:52:39'),
(28, '洗护用品', 0, '0,5', 0, 0, 27, 0, '', '2017-01-13 02:44:59', '2017-01-13 02:44:59'),
(29, '美妆', 0, '0,6', 5, 0, 22, 0, '', '2017-01-13 02:45:08', '2017-01-13 02:45:08'),
(35, '珠宝首饰', 0, '0,10', 2, 0, 23, 0, '', '2017-01-13 02:48:10', '2017-01-13 02:48:10'),
(36, '鞋', 0, '0,10', 1, 0, 24, 0, '', '2017-01-13 02:56:30', '2017-01-13 02:56:30'),
(37, '包', 0, '0,10', 0, 0, 28, 0, '', '2017-01-13 02:56:49', '2017-01-13 02:56:49'),
(38, '男包', 37, '0,10,1', 0, 0, 28, 0, '', '2017-01-13 02:58:58', '2017-01-13 02:58:58'),
(39, '女包', 37, '0,10,2', 0, 0, 28, 0, '', '2017-01-13 02:59:02', '2017-01-13 02:59:02'),
(40, '钱包', 37, '0,10,3', 0, 0, 28, 0, '', '2017-01-13 02:59:06', '2017-01-13 02:59:06'),
(41, '书包', 37, '0,10,4', 0, 0, 28, 0, '', '2017-01-13 02:59:13', '2017-01-13 02:59:13'),
(42, '男鞋', 36, '0,10,1', 1, 0, 24, 0, '', '2017-01-13 02:59:40', '2017-01-13 02:59:40'),
(43, '女鞋', 36, '0,10,2', 0, 0, 24, 0, '', '2017-01-13 02:59:46', '2017-01-13 02:59:46'),
(44, '童鞋', 36, '0,10,3', 0, 0, 24, 0, '', '2017-01-13 02:59:52', '2017-01-13 02:59:52'),
(45, '流行靴子', 36, '0,10,4', 0, 0, 24, 0, '', '2017-01-13 02:59:58', '2017-01-13 02:59:58'),
(46, '婚嫁黄金', 35, '0,10,1', 1, 0, 23, 0, '', '2017-01-13 03:00:38', '2017-01-13 03:00:38'),
(47, '钻石', 35, '0,10,2', 1, 0, 23, 0, '', '2017-01-13 03:00:59', '2017-01-13 03:00:59'),
(48, '时尚首饰', 35, '0,10,3', 0, 0, 23, 0, '', '2017-01-13 03:01:07', '2017-01-13 03:01:07'),
(49, '手表', 35, '0,10,4', 0, 0, 23, 0, '', '2017-01-13 03:01:12', '2017-01-13 03:01:12'),
(50, '电子产品', 0, '0,7', 0, 0, 25, 0, '', '2017-01-13 03:01:37', '2017-01-13 03:01:37'),
(51, '手机', 50, '0,7,1', 0, 0, 25, 0, '', '2017-01-13 03:01:53', '2017-01-13 03:01:53'),
(52, 'ipad', 50, '0,7,2', 0, 0, 25, 0, '', '2017-01-13 03:01:57', '2017-01-13 03:01:57'),
(53, '笔记本电脑', 50, '0,7,3', 0, 0, 25, 0, '', '2017-01-13 03:02:06', '2017-01-13 03:02:06'),
(54, '显示器', 50, '0,7,4', 0, 0, 25, 0, '', '2017-01-13 03:02:10', '2017-01-13 03:02:10'),
(55, '台式电脑', 50, '0,7,5', 0, 0, 25, 0, '', '2017-01-13 03:02:19', '2017-01-13 03:02:19'),
(56, '面膜', 29, '0,6,1', 0, 0, 22, 0, '', '2017-01-13 03:03:09', '2017-01-13 03:03:09'),
(57, '基础护理', 29, '0,6,2', 0, 0, 22, 0, '', '2017-01-13 03:03:15', '2017-01-13 03:03:15'),
(58, '彩妆', 29, '0,6,3', 0, 0, 22, 0, '', '2017-01-13 03:03:20', '2017-01-13 03:03:20'),
(59, '美发护发', 28, '0,5,1', 0, 0, 27, 0, '', '2017-01-13 03:05:02', '2017-01-13 03:05:02'),
(60, '沐浴身体护理', 28, '0,5,2', 0, 0, 27, 0, '', '2017-01-13 03:05:14', '2017-01-13 03:05:14'),
(61, '男士护理', 28, '0,5,3', 0, 0, 27, 0, '', '2017-01-13 03:05:20', '2017-01-13 03:05:20'),
(62, '牛奶', 1, '0,1,3', 1, 0, 4, 0, '', '2017-01-13 03:07:01', '2017-01-13 03:07:01'),
(63, '香水', 29, '0,6,4', 5, 0, 29, 0, '', '2017-01-13 04:57:12', '2017-01-13 04:57:12');

-- --------------------------------------------------------

--
-- 表的结构 `ms_goods_comment`
--

CREATE TABLE `ms_goods_comment` (
  `comment_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `score` tinyint(4) NOT NULL,
  `content` text,
  `isopen` tinyint(4) NOT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_goods_comment`
--

INSERT INTO `ms_goods_comment` (`comment_id`, `order_id`, `goods_id`, `member_id`, `score`, `content`, `isopen`, `creatime`) VALUES
(2, 3, 11, 16, 5, '非常好', 1, '2016-11-30 03:19:19'),
(3, 4, 29, 5, 5, '非常好', 1, '2016-11-30 03:20:37'),
(4, 5, 29, 16, 5, '很好', 1, '2016-11-30 03:48:09'),
(5, 7, 29, 16, 5, 'good', 1, '2016-11-30 03:48:43'),
(6, 3, 22, 16, 5, 'good', 1, '2016-12-27 09:02:04');

-- --------------------------------------------------------

--
-- 表的结构 `ms_goods_img`
--

CREATE TABLE `ms_goods_img` (
  `img_id` int(11) NOT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `thumbnail` varchar(225) DEFAULT NULL,
  `big` varchar(225) DEFAULT NULL,
  `small` varchar(225) DEFAULT NULL,
  `original` varchar(225) DEFAULT NULL,
  `isdefault` smallint(6) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_goods_img`
--

INSERT INTO `ms_goods_img` (`img_id`, `goods_id`, `thumbnail`, `big`, `small`, `original`, `isdefault`, `creatime`, `modifytime`) VALUES
(17, 2, 'http://192.168.8.2:8080/MobileShop/upload/Ke3jX+suNLmSuZsdFgoTWg==_thum.jpg', 'http://192.168.8.2:8080/MobileShop/upload/Ke3jX+suNLmSuZsdFgoTWg==_big.jpg', 'http://192.168.8.2:8080/MobileShop/upload/Ke3jX+suNLmSuZsdFgoTWg==_small.jpg', 'http://192.168.8.2:8080/MobileShop/upload/Ke3jX+suNLmSuZsdFgoTWg==_orig.jpg', 0, '2016-11-10 03:12:00', '2016-11-11 01:09:43'),
(18, 2, 'http://localhost:8080\\MobileShop\\upload\\L8SIT+XPu1iJA3XqXBE4Gg==_thum.jpg', 'http://localhost:8080\\MobileShop\\upload\\L8SIT+XPu1iJA3XqXBE4Gg==_big.jpg', 'http://localhost:8080\\MobileShop\\upload\\L8SIT+XPu1iJA3XqXBE4Gg==_small.jpg', 'http://localhost:8080\\MobileShop\\upload\\L8SIT+XPu1iJA3XqXBE4Gg==_orig.jpg', 1, '2016-11-10 03:12:44', '2016-11-10 03:12:44'),
(19, 8, 'http://192.168.8.2:8080/MobileShop/upload/GAW6mh7Wg7Kg58eE4VC3zg==_thum.jpg', 'http://192.168.8.2:8080/MobileShop/upload/GAW6mh7Wg7Kg58eE4VC3zg==_big.jpg', 'http://192.168.8.2:8080/MobileShop/upload/GAW6mh7Wg7Kg58eE4VC3zg==_small.jpg', 'http://192.168.8.2:8080/MobileShop/upload/GAW6mh7Wg7Kg58eE4VC3zg==_orig.jpg', 0, '2016-11-10 03:13:54', '2016-11-11 01:20:00'),
(20, 11, 'http://192.168.8.2:8080/MobileShop/upload/C9dC9XckO1M7td5FQK1cKw==_thum.jpg', 'http://192.168.8.2:8080/MobileShop/upload/C9dC9XckO1M7td5FQK1cKw==_big.jpg', 'http://192.168.8.2:8080/MobileShop/upload/C9dC9XckO1M7td5FQK1cKw==_small.jpg', 'http://192.168.8.2:8080/MobileShop/upload/C9dC9XckO1M7td5FQK1cKw==_orig.jpg', 0, '2016-11-10 03:14:14', '2016-11-11 01:26:11'),
(23, 21, 'http://localhost:8080/MobileShop/upload/MBJZgst2D/QcfuwhquZPHg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/MBJZgst2D/QcfuwhquZPHg==_big.jpg', 'http://localhost:8080/MobileShop/upload/MBJZgst2D/QcfuwhquZPHg==_small.jpg', 'http://localhost:8080/MobileShop/upload/MBJZgst2D/QcfuwhquZPHg==_orig.jpg', 0, '2016-11-10 03:15:31', '2016-11-11 02:05:06'),
(24, 22, 'http://localhost:8080\\MobileShop\\upload\\/+L7DTDoQSJgabPMxjfUAA==_thum.jpg', 'http://localhost:8080\\MobileShop\\upload\\/+L7DTDoQSJgabPMxjfUAA==_big.jpg', 'http://localhost:8080\\MobileShop\\upload\\/+L7DTDoQSJgabPMxjfUAA==_small.jpg', 'http://localhost:8080\\MobileShop\\upload\\/+L7DTDoQSJgabPMxjfUAA==_orig.jpg', 0, '2016-11-10 03:15:58', '2016-11-10 03:15:58'),
(25, 29, 'http://localhost:8080\\MobileShop\\upload\\82eFO96xDl/uO6Irf31Wtw==_thum.jpg', 'http://localhost:8080\\MobileShop\\upload\\82eFO96xDl/uO6Irf31Wtw==_big.jpg', 'http://localhost:8080\\MobileShop\\upload\\82eFO96xDl/uO6Irf31Wtw==_small.jpg', 'http://localhost:8080\\MobileShop\\upload\\82eFO96xDl/uO6Irf31Wtw==_orig.jpg', 0, '2016-11-10 03:16:24', '2016-11-10 03:16:24'),
(26, 11, 'http://localhost:8080\\MobileShop\\upload\\7CKzX42NvZjNOQzrhiOY4Q==_thum.jpg', 'http://localhost:8080\\MobileShop\\upload\\7CKzX42NvZjNOQzrhiOY4Q==_big.jpg', 'http://localhost:8080\\MobileShop\\upload\\7CKzX42NvZjNOQzrhiOY4Q==_small.jpg', 'http://localhost:8080\\MobileShop\\upload\\7CKzX42NvZjNOQzrhiOY4Q==_orig.jpg', 1, '2016-11-10 06:43:37', '2016-11-10 06:43:37'),
(27, 8, 'http://localhost:8080/MobileShop/upload/+vbDOHU0JvQ9USQzhrz6HA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/+vbDOHU0JvQ9USQzhrz6HA==_big.jpg', 'http://localhost:8080/MobileShop/upload/+vbDOHU0JvQ9USQzhrz6HA==_small.jpg', 'http://localhost:8080/MobileShop/upload/+vbDOHU0JvQ9USQzhrz6HA==_orig.jpg', 1, '2016-11-11 01:01:40', '2016-11-11 01:01:40'),
(29, 32, 'http://192.168.8.7:8080/MobileShop/upload/uv/z4/cG9BaXJBd1pBTfcw==_thum.jpg', 'http://192.168.8.7:8080/MobileShop/upload/uv/z4/cG9BaXJBd1pBTfcw==_big.jpg', 'http://192.168.8.7:8080/MobileShop/upload/uv/z4/cG9BaXJBd1pBTfcw==_small.jpg', 'http://192.168.8.7:8080/MobileShop/upload/uv/z4/cG9BaXJBd1pBTfcw==_orig.jpg', 0, '2016-11-18 03:54:15', '2016-11-18 03:54:15'),
(30, 32, 'http://192.168.8.7:8080/MobileShop/upload/G4WqbzEEHrwS2G9dr03sWg==_thum.jpg', 'http://192.168.8.7:8080/MobileShop/upload/G4WqbzEEHrwS2G9dr03sWg==_big.jpg', 'http://192.168.8.7:8080/MobileShop/upload/G4WqbzEEHrwS2G9dr03sWg==_small.jpg', 'http://192.168.8.7:8080/MobileShop/upload/G4WqbzEEHrwS2G9dr03sWg==_orig.jpg', 1, '2016-11-18 03:54:58', '2016-11-18 03:54:58'),
(32, 4, 'http://localhost:8080/0:0:0:0:0:0:0:1/upload/MobileShop/upload/StMvXIF+fAiWTsgKZLIpJw==_thum.jpg', 'http://localhost:8080/0:0:0:0:0:0:0:1/upload/MobileShop/upload/StMvXIF+fAiWTsgKZLIpJw==_big.jpg', 'http://localhost:8080/0:0:0:0:0:0:0:1/upload/MobileShop/upload/StMvXIF+fAiWTsgKZLIpJw==_small.jpg', 'http://localhost:8080/0:0:0:0:0:0:0:1/upload/MobileShop/upload/StMvXIF+fAiWTsgKZLIpJw==_orig.jpg', 0, '2017-01-09 07:03:48', '2017-01-09 07:03:48'),
(33, 43, 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_big.jpg', 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_small.jpg', 'http://localhost:8080/MobileShop/upload/W6Fifha8rqvg5chWf1hwiA==_orig.jpg', 0, '2017-01-10 02:51:01', '2017-01-10 02:51:01'),
(34, 45, 'http://192.168.8.11:8080/MobileShop/upload/fGZrcvagdKdNcG_thum.jWSJtFQ==.png', 'http://192.168.8.11:8080/MobileShop/upload/fGZrcvagdKdNcG_big.jWSJtFQ==.png', 'http://192.168.8.11:8080/MobileShop/upload/fGZrcvagdKdNcG_small.jWSJtFQ==.png', 'http://192.168.8.11:8080/MobileShop/upload/fGZrcvagdKdNcG_orig.jWSJtFQ==.png', 0, '2017-01-11 07:19:23', '2017-01-11 07:19:23'),
(35, 45, 'http://192.168.8.11:8080/MobileShop/upload/EZ9jP4t0554JxnQ/PWGcbg==_thum.jpg', 'http://192.168.8.11:8080/MobileShop/upload/EZ9jP4t0554JxnQ/PWGcbg==_big.jpg', 'http://192.168.8.11:8080/MobileShop/upload/EZ9jP4t0554JxnQ/PWGcbg==_small.jpg', 'http://192.168.8.11:8080/MobileShop/upload/EZ9jP4t0554JxnQ/PWGcbg==_orig.jpg', 1, '2017-01-11 07:20:29', '2017-01-11 07:20:29'),
(36, 80, 'http://localhost:8080/MobileShop/upload/Pg+3mUwS47BKSnfMPVWzgQ==_thum.jpg', 'http://localhost:8080/MobileShop/upload/Pg+3mUwS47BKSnfMPVWzgQ==_big.jpg', 'http://localhost:8080/MobileShop/upload/Pg+3mUwS47BKSnfMPVWzgQ==_small.jpg', 'http://localhost:8080/MobileShop/upload/Pg+3mUwS47BKSnfMPVWzgQ==_orig.jpg', 0, '2017-01-12 06:21:00', '2017-01-12 06:21:00'),
(37, 80, 'http://localhost:8080/MobileShop/upload/f2hDRCO2HYVrsQ71PImt2g==_thum.jpg', 'http://localhost:8080/MobileShop/upload/f2hDRCO2HYVrsQ71PImt2g==_big.jpg', 'http://localhost:8080/MobileShop/upload/f2hDRCO2HYVrsQ71PImt2g==_small.jpg', 'http://localhost:8080/MobileShop/upload/f2hDRCO2HYVrsQ71PImt2g==_orig.jpg', 1, '2017-01-12 06:21:05', '2017-01-12 06:21:05'),
(38, 80, 'http://localhost:8080/MobileShop/upload/K+0oWm9Qnri8mMroBYMvCg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/K+0oWm9Qnri8mMroBYMvCg==_big.jpg', 'http://localhost:8080/MobileShop/upload/K+0oWm9Qnri8mMroBYMvCg==_small.jpg', 'http://localhost:8080/MobileShop/upload/K+0oWm9Qnri8mMroBYMvCg==_orig.jpg', 1, '2017-01-12 06:21:09', '2017-01-12 06:21:09'),
(39, 80, 'http://localhost:8080/MobileShop/upload/l1iFIJK3qTV8O5S8MkP9tQ==_thum.jpg', 'http://localhost:8080/MobileShop/upload/l1iFIJK3qTV8O5S8MkP9tQ==_big.jpg', 'http://localhost:8080/MobileShop/upload/l1iFIJK3qTV8O5S8MkP9tQ==_small.jpg', 'http://localhost:8080/MobileShop/upload/l1iFIJK3qTV8O5S8MkP9tQ==_orig.jpg', 1, '2017-01-12 06:21:12', '2017-01-12 06:21:12'),
(40, 80, 'http://localhost:8080/MobileShop/upload/fHxKnbzURVkX4M8jP/JPvA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/fHxKnbzURVkX4M8jP/JPvA==_big.jpg', 'http://localhost:8080/MobileShop/upload/fHxKnbzURVkX4M8jP/JPvA==_small.jpg', 'http://localhost:8080/MobileShop/upload/fHxKnbzURVkX4M8jP/JPvA==_orig.jpg', 1, '2017-01-12 06:21:16', '2017-01-12 06:21:16'),
(41, 83, 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_big.jpg', 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_small.jpg', 'http://localhost:8080/MobileShop/upload/d2IHwqIJVSPIIIiorMU9kw==_orig.jpg', 0, '2017-01-13 03:27:06', '2017-01-13 03:27:06'),
(42, 83, 'http://localhost:8080/MobileShop/upload/AOa4MYXn/52hEHov4JdGbw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/AOa4MYXn/52hEHov4JdGbw==_big.jpg', 'http://localhost:8080/MobileShop/upload/AOa4MYXn/52hEHov4JdGbw==_small.jpg', 'http://localhost:8080/MobileShop/upload/AOa4MYXn/52hEHov4JdGbw==_orig.jpg', 1, '2017-01-13 03:27:10', '2017-01-13 03:27:10'),
(43, 83, 'http://localhost:8080/MobileShop/upload/tnzGrNIA53BRn2wnQ94DGA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/tnzGrNIA53BRn2wnQ94DGA==_big.jpg', 'http://localhost:8080/MobileShop/upload/tnzGrNIA53BRn2wnQ94DGA==_small.jpg', 'http://localhost:8080/MobileShop/upload/tnzGrNIA53BRn2wnQ94DGA==_orig.jpg', 1, '2017-01-13 03:27:13', '2017-01-13 03:27:13'),
(44, 83, 'http://localhost:8080/MobileShop/upload/P2+oKQPGFMAChyw4E2HcDg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/P2+oKQPGFMAChyw4E2HcDg==_big.jpg', 'http://localhost:8080/MobileShop/upload/P2+oKQPGFMAChyw4E2HcDg==_small.jpg', 'http://localhost:8080/MobileShop/upload/P2+oKQPGFMAChyw4E2HcDg==_orig.jpg', 1, '2017-01-13 03:27:17', '2017-01-13 03:27:17'),
(45, 83, 'http://localhost:8080/MobileShop/upload/YjGljDcBdlrJxso1stpO7g==_thum.jpg', 'http://localhost:8080/MobileShop/upload/YjGljDcBdlrJxso1stpO7g==_big.jpg', 'http://localhost:8080/MobileShop/upload/YjGljDcBdlrJxso1stpO7g==_small.jpg', 'http://localhost:8080/MobileShop/upload/YjGljDcBdlrJxso1stpO7g==_orig.jpg', 1, '2017-01-13 03:27:21', '2017-01-13 03:27:21'),
(46, 84, 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_thum.jpg', 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_big.jpg', 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_small.jpg', 'http://localhost:8080/MobileShop/upload/17Krl3Vuerot2HLIQe1S/w==_orig.jpg', 0, '2017-01-13 03:52:14', '2017-01-13 03:52:14'),
(47, 84, 'http://localhost:8080/MobileShop/upload/uYbrosvZDLb/TfYZmxfloA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/uYbrosvZDLb/TfYZmxfloA==_big.jpg', 'http://localhost:8080/MobileShop/upload/uYbrosvZDLb/TfYZmxfloA==_small.jpg', 'http://localhost:8080/MobileShop/upload/uYbrosvZDLb/TfYZmxfloA==_orig.jpg', 1, '2017-01-13 03:52:17', '2017-01-13 03:52:17'),
(48, 84, 'http://localhost:8080/MobileShop/upload/jKF8vIgd/DYMbHiGIRamSQ==_thum.jpg', 'http://localhost:8080/MobileShop/upload/jKF8vIgd/DYMbHiGIRamSQ==_big.jpg', 'http://localhost:8080/MobileShop/upload/jKF8vIgd/DYMbHiGIRamSQ==_small.jpg', 'http://localhost:8080/MobileShop/upload/jKF8vIgd/DYMbHiGIRamSQ==_orig.jpg', 1, '2017-01-13 03:52:40', '2017-01-13 03:52:40'),
(49, 84, 'http://localhost:8080/MobileShop/upload/8n8oOzRLUPcdmADZL3di0Q==_thum.jpg', 'http://localhost:8080/MobileShop/upload/8n8oOzRLUPcdmADZL3di0Q==_big.jpg', 'http://localhost:8080/MobileShop/upload/8n8oOzRLUPcdmADZL3di0Q==_small.jpg', 'http://localhost:8080/MobileShop/upload/8n8oOzRLUPcdmADZL3di0Q==_orig.jpg', 1, '2017-01-13 03:52:43', '2017-01-13 03:52:43'),
(50, 85, 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_big.jpg', 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_small.jpg', 'http://localhost:8080/MobileShop/upload/3u2BLnU1ELFP8dma02ANvA==_orig.jpg', 0, '2017-01-13 06:15:37', '2017-01-13 06:15:37'),
(51, 85, 'http://localhost:8080/MobileShop/upload/UdF1FqAuV+AqXL+bOtXJvg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/UdF1FqAuV+AqXL+bOtXJvg==_big.jpg', 'http://localhost:8080/MobileShop/upload/UdF1FqAuV+AqXL+bOtXJvg==_small.jpg', 'http://localhost:8080/MobileShop/upload/UdF1FqAuV+AqXL+bOtXJvg==_orig.jpg', 1, '2017-01-13 06:15:40', '2017-01-13 06:15:40'),
(52, 85, 'http://localhost:8080/MobileShop/upload/8x8vy2g9/IVXd4eUhxoDUw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/8x8vy2g9/IVXd4eUhxoDUw==_big.jpg', 'http://localhost:8080/MobileShop/upload/8x8vy2g9/IVXd4eUhxoDUw==_small.jpg', 'http://localhost:8080/MobileShop/upload/8x8vy2g9/IVXd4eUhxoDUw==_orig.jpg', 1, '2017-01-13 06:15:44', '2017-01-13 06:15:44'),
(53, 85, 'http://localhost:8080/MobileShop/upload/+v/0St9Gnvd4RTVeXaol9Q==_thum.jpg', 'http://localhost:8080/MobileShop/upload/+v/0St9Gnvd4RTVeXaol9Q==_big.jpg', 'http://localhost:8080/MobileShop/upload/+v/0St9Gnvd4RTVeXaol9Q==_small.jpg', 'http://localhost:8080/MobileShop/upload/+v/0St9Gnvd4RTVeXaol9Q==_orig.jpg', 1, '2017-01-13 06:15:47', '2017-01-13 06:15:47'),
(54, 86, 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_big.jpg', 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_small.jpg', 'http://localhost:8080/MobileShop/upload/ECissUVSmdTTiq3JfFRfxg==_orig.jpg', 0, '2017-01-13 06:22:15', '2017-01-13 06:22:15'),
(55, 86, 'http://localhost:8080/MobileShop/upload/n+Z5rzRb18O2HfKt/iGVcg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/n+Z5rzRb18O2HfKt/iGVcg==_big.jpg', 'http://localhost:8080/MobileShop/upload/n+Z5rzRb18O2HfKt/iGVcg==_small.jpg', 'http://localhost:8080/MobileShop/upload/n+Z5rzRb18O2HfKt/iGVcg==_orig.jpg', 1, '2017-01-13 06:22:18', '2017-01-13 06:22:18'),
(56, 86, 'http://localhost:8080/MobileShop/upload/q7h0acKIOPFP5lhlnReEQQ==_thum.jpg', 'http://localhost:8080/MobileShop/upload/q7h0acKIOPFP5lhlnReEQQ==_big.jpg', 'http://localhost:8080/MobileShop/upload/q7h0acKIOPFP5lhlnReEQQ==_small.jpg', 'http://localhost:8080/MobileShop/upload/q7h0acKIOPFP5lhlnReEQQ==_orig.jpg', 1, '2017-01-13 06:22:22', '2017-01-13 06:22:22'),
(57, 86, 'http://localhost:8080/MobileShop/upload//hsULfqA/QU2dMG3FhQ4xA==_thum.jpg', 'http://localhost:8080/MobileShop/upload//hsULfqA/QU2dMG3FhQ4xA==_big.jpg', 'http://localhost:8080/MobileShop/upload//hsULfqA/QU2dMG3FhQ4xA==_small.jpg', 'http://localhost:8080/MobileShop/upload//hsULfqA/QU2dMG3FhQ4xA==_orig.jpg', 1, '2017-01-13 06:22:25', '2017-01-13 06:22:25'),
(58, 86, 'http://localhost:8080/MobileShop/upload/qOkytxy44DmBXdRkdTJJ/A==_thum.jpg', 'http://localhost:8080/MobileShop/upload/qOkytxy44DmBXdRkdTJJ/A==_big.jpg', 'http://localhost:8080/MobileShop/upload/qOkytxy44DmBXdRkdTJJ/A==_small.jpg', 'http://localhost:8080/MobileShop/upload/qOkytxy44DmBXdRkdTJJ/A==_orig.jpg', 1, '2017-01-13 06:22:28', '2017-01-13 06:22:28'),
(59, 87, 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_thum.jpg', 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_big.jpg', 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_small.jpg', 'http://localhost:8080/MobileShop/upload/y8F1O3q0LJxTbg+YYSEzfQ==_orig.jpg', 0, '2017-01-13 06:29:14', '2017-01-13 06:29:14'),
(60, 87, 'http://localhost:8080/MobileShop/upload/uQoZGeDao19LHqf50n0F+Q==_thum.jpg', 'http://localhost:8080/MobileShop/upload/uQoZGeDao19LHqf50n0F+Q==_big.jpg', 'http://localhost:8080/MobileShop/upload/uQoZGeDao19LHqf50n0F+Q==_small.jpg', 'http://localhost:8080/MobileShop/upload/uQoZGeDao19LHqf50n0F+Q==_orig.jpg', 1, '2017-01-13 06:29:17', '2017-01-13 06:29:17'),
(61, 87, 'http://localhost:8080/MobileShop/upload/raAk8Eg0xrmVlu/uAbXq4w==_thum.jpg', 'http://localhost:8080/MobileShop/upload/raAk8Eg0xrmVlu/uAbXq4w==_big.jpg', 'http://localhost:8080/MobileShop/upload/raAk8Eg0xrmVlu/uAbXq4w==_small.jpg', 'http://localhost:8080/MobileShop/upload/raAk8Eg0xrmVlu/uAbXq4w==_orig.jpg', 1, '2017-01-13 06:29:20', '2017-01-13 06:29:20'),
(62, 88, 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_thum.jpg', 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_big.jpg', 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_small.jpg', 'http://localhost:8080/MobileShop/upload/o1ni2zrzO3x6TOblo2gZ5A==_orig.jpg', 0, '2017-01-13 06:38:11', '2017-01-13 06:38:11'),
(63, 88, 'http://localhost:8080/MobileShop/upload/MrTfeG0AzJ37ttfCUyoR4g==_thum.jpg', 'http://localhost:8080/MobileShop/upload/MrTfeG0AzJ37ttfCUyoR4g==_big.jpg', 'http://localhost:8080/MobileShop/upload/MrTfeG0AzJ37ttfCUyoR4g==_small.jpg', 'http://localhost:8080/MobileShop/upload/MrTfeG0AzJ37ttfCUyoR4g==_orig.jpg', 1, '2017-01-13 06:38:14', '2017-01-13 06:38:14'),
(64, 88, 'http://localhost:8080/MobileShop/upload/jPfxChziHkYg11yujrz9yw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/jPfxChziHkYg11yujrz9yw==_big.jpg', 'http://localhost:8080/MobileShop/upload/jPfxChziHkYg11yujrz9yw==_small.jpg', 'http://localhost:8080/MobileShop/upload/jPfxChziHkYg11yujrz9yw==_orig.jpg', 1, '2017-01-13 06:38:17', '2017-01-13 06:38:17'),
(65, 88, 'http://localhost:8080/MobileShop/upload/P/yoRS+EeKOGXEY1S9Gr3Q==_thum.jpg', 'http://localhost:8080/MobileShop/upload/P/yoRS+EeKOGXEY1S9Gr3Q==_big.jpg', 'http://localhost:8080/MobileShop/upload/P/yoRS+EeKOGXEY1S9Gr3Q==_small.jpg', 'http://localhost:8080/MobileShop/upload/P/yoRS+EeKOGXEY1S9Gr3Q==_orig.jpg', 1, '2017-01-13 06:38:20', '2017-01-13 06:38:20'),
(66, 88, 'http://localhost:8080/MobileShop/upload/WqxdsI36bTIhTon9M/VmcA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/WqxdsI36bTIhTon9M/VmcA==_big.jpg', 'http://localhost:8080/MobileShop/upload/WqxdsI36bTIhTon9M/VmcA==_small.jpg', 'http://localhost:8080/MobileShop/upload/WqxdsI36bTIhTon9M/VmcA==_orig.jpg', 1, '2017-01-13 06:38:24', '2017-01-13 06:38:24'),
(67, 89, 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_big.jpg', 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_small.jpg', 'http://localhost:8080/MobileShop/upload/PsXDju6PIuZhFWXZOXkASw==_orig.jpg', 0, '2017-01-13 06:44:01', '2017-01-13 06:44:01'),
(68, 89, 'http://localhost:8080/MobileShop/upload/xQ9HFO6mU36JUxkav2g+Xw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/xQ9HFO6mU36JUxkav2g+Xw==_big.jpg', 'http://localhost:8080/MobileShop/upload/xQ9HFO6mU36JUxkav2g+Xw==_small.jpg', 'http://localhost:8080/MobileShop/upload/xQ9HFO6mU36JUxkav2g+Xw==_orig.jpg', 1, '2017-01-13 06:44:04', '2017-01-13 06:44:04'),
(69, 89, 'http://localhost:8080/MobileShop/upload/IbYwj47uZBaNVwQpTKQVzg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/IbYwj47uZBaNVwQpTKQVzg==_big.jpg', 'http://localhost:8080/MobileShop/upload/IbYwj47uZBaNVwQpTKQVzg==_small.jpg', 'http://localhost:8080/MobileShop/upload/IbYwj47uZBaNVwQpTKQVzg==_orig.jpg', 1, '2017-01-13 06:44:08', '2017-01-13 06:44:08'),
(70, 89, 'http://localhost:8080/MobileShop/upload/gJNFEU2May+qX9Rb9GvYxQ==_thum.jpg', 'http://localhost:8080/MobileShop/upload/gJNFEU2May+qX9Rb9GvYxQ==_big.jpg', 'http://localhost:8080/MobileShop/upload/gJNFEU2May+qX9Rb9GvYxQ==_small.jpg', 'http://localhost:8080/MobileShop/upload/gJNFEU2May+qX9Rb9GvYxQ==_orig.jpg', 1, '2017-01-13 06:44:11', '2017-01-13 06:44:11'),
(71, 89, 'http://localhost:8080/MobileShop/upload/kPlGUYvuzkYsh0PFXJtt2w==_thum.jpg', 'http://localhost:8080/MobileShop/upload/kPlGUYvuzkYsh0PFXJtt2w==_big.jpg', 'http://localhost:8080/MobileShop/upload/kPlGUYvuzkYsh0PFXJtt2w==_small.jpg', 'http://localhost:8080/MobileShop/upload/kPlGUYvuzkYsh0PFXJtt2w==_orig.jpg', 1, '2017-01-13 06:44:13', '2017-01-13 06:44:13'),
(72, 90, 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_thum.jpg', 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_big.jpg', 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_small.jpg', 'http://localhost:8080/MobileShop/upload/56VOwzGuqb2U3ElVs1ckiA==_orig.jpg', 0, '2017-01-13 06:48:57', '2017-01-13 06:48:57'),
(73, 90, 'http://localhost:8080/MobileShop/upload/4TxfdvthGSrmMBK6M3RFMw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/4TxfdvthGSrmMBK6M3RFMw==_big.jpg', 'http://localhost:8080/MobileShop/upload/4TxfdvthGSrmMBK6M3RFMw==_small.jpg', 'http://localhost:8080/MobileShop/upload/4TxfdvthGSrmMBK6M3RFMw==_orig.jpg', 1, '2017-01-13 06:49:01', '2017-01-13 06:49:01'),
(74, 90, 'http://localhost:8080/MobileShop/upload/Xp/xVzpVXWQmUe9RKf+c6Q==_thum.jpg', 'http://localhost:8080/MobileShop/upload/Xp/xVzpVXWQmUe9RKf+c6Q==_big.jpg', 'http://localhost:8080/MobileShop/upload/Xp/xVzpVXWQmUe9RKf+c6Q==_small.jpg', 'http://localhost:8080/MobileShop/upload/Xp/xVzpVXWQmUe9RKf+c6Q==_orig.jpg', 1, '2017-01-13 06:49:04', '2017-01-13 06:49:04'),
(75, 90, 'http://localhost:8080/MobileShop/upload//nfHPjZjH3oREOeOupuccw==_thum.jpg', 'http://localhost:8080/MobileShop/upload//nfHPjZjH3oREOeOupuccw==_big.jpg', 'http://localhost:8080/MobileShop/upload//nfHPjZjH3oREOeOupuccw==_small.jpg', 'http://localhost:8080/MobileShop/upload//nfHPjZjH3oREOeOupuccw==_orig.jpg', 1, '2017-01-13 06:49:07', '2017-01-13 06:49:07'),
(76, 90, 'http://localhost:8080/MobileShop/upload/pMVmzPKkf5dQiQaEDDlWWQ==_thum.jpg', 'http://localhost:8080/MobileShop/upload/pMVmzPKkf5dQiQaEDDlWWQ==_big.jpg', 'http://localhost:8080/MobileShop/upload/pMVmzPKkf5dQiQaEDDlWWQ==_small.jpg', 'http://localhost:8080/MobileShop/upload/pMVmzPKkf5dQiQaEDDlWWQ==_orig.jpg', 1, '2017-01-13 06:49:13', '2017-01-13 06:49:13'),
(77, 91, 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_big.jpg', 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_small.jpg', 'http://localhost:8080/MobileShop/upload/+wUXuzCnO3Dp6FW0U+fxjg==_orig.jpg', 0, '2017-01-13 06:54:27', '2017-01-13 06:54:27'),
(78, 91, 'http://localhost:8080/MobileShop/upload/mpEFb61jMsOjWthV92kXKg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/mpEFb61jMsOjWthV92kXKg==_big.jpg', 'http://localhost:8080/MobileShop/upload/mpEFb61jMsOjWthV92kXKg==_small.jpg', 'http://localhost:8080/MobileShop/upload/mpEFb61jMsOjWthV92kXKg==_orig.jpg', 1, '2017-01-13 06:54:30', '2017-01-13 06:54:30'),
(79, 91, 'http://localhost:8080/MobileShop/upload/VKeNZvJRdQjsHI8yBNqOIw==_thum.jpg', 'http://localhost:8080/MobileShop/upload/VKeNZvJRdQjsHI8yBNqOIw==_big.jpg', 'http://localhost:8080/MobileShop/upload/VKeNZvJRdQjsHI8yBNqOIw==_small.jpg', 'http://localhost:8080/MobileShop/upload/VKeNZvJRdQjsHI8yBNqOIw==_orig.jpg', 1, '2017-01-13 06:54:33', '2017-01-13 06:54:33'),
(80, 91, 'http://localhost:8080/MobileShop/upload/RaUDuCu8fAkwcQj2wWJcKg==_thum.jpg', 'http://localhost:8080/MobileShop/upload/RaUDuCu8fAkwcQj2wWJcKg==_big.jpg', 'http://localhost:8080/MobileShop/upload/RaUDuCu8fAkwcQj2wWJcKg==_small.jpg', 'http://localhost:8080/MobileShop/upload/RaUDuCu8fAkwcQj2wWJcKg==_orig.jpg', 1, '2017-01-13 06:54:36', '2017-01-13 06:54:36'),
(81, 91, 'http://localhost:8080/MobileShop/upload/CEqz/Gm6sUvsD5wRM/aM6g==_thum.jpg', 'http://localhost:8080/MobileShop/upload/CEqz/Gm6sUvsD5wRM/aM6g==_big.jpg', 'http://localhost:8080/MobileShop/upload/CEqz/Gm6sUvsD5wRM/aM6g==_small.jpg', 'http://localhost:8080/MobileShop/upload/CEqz/Gm6sUvsD5wRM/aM6g==_orig.jpg', 1, '2017-01-13 06:54:40', '2017-01-13 06:54:40');

-- --------------------------------------------------------

--
-- 表的结构 `ms_goods_like`
--

CREATE TABLE `ms_goods_like` (
  `like_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_goods_like`
--

INSERT INTO `ms_goods_like` (`like_id`, `goods_id`, `member_id`, `creatime`, `modifytime`) VALUES
(7, 6, 5, '2016-11-07 07:56:23', '2016-11-07 07:56:23'),
(8, 4, 16, '2016-11-29 07:30:48', '2016-11-29 07:30:48');

-- --------------------------------------------------------

--
-- 表的结构 `ms_goods_store`
--

CREATE TABLE `ms_goods_store` (
  `store_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `store` int(8) NOT NULL,
  `enable_store` int(8) NOT NULL,
  `operate_type` tinyint(4) NOT NULL,
  `intime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `outime` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_goods_store`
--

INSERT INTO `ms_goods_store` (`store_id`, `goods_id`, `store`, `enable_store`, `operate_type`, `intime`, `outime`) VALUES
(2, 2, 98, 98, 1, '2016-09-09 09:10:10', '2016-09-09 09:18:00'),
(3, 4, 20, 19, 0, '2016-11-08 08:14:41', NULL),
(4, 5, 100, 95, 0, '2016-11-08 08:31:45', NULL),
(5, 20, 100, 100, 0, '2016-11-07 08:26:57', NULL),
(6, 32, 50, 50, 0, '2016-11-18 03:56:10', NULL),
(7, 11, 20, 20, 0, '2016-11-18 09:17:43', NULL),
(8, 31, 40, 40, 0, '2016-12-28 09:02:28', NULL),
(9, 47, 45, 45, 0, '2017-01-11 08:07:41', NULL),
(10, 48, 23, 23, 0, '2017-01-11 08:13:10', NULL),
(11, 49, 34, 34, 0, '2017-01-11 08:21:18', NULL),
(12, 50, 45, 45, 0, '2017-01-11 08:23:27', NULL),
(13, 51, 45, 45, 0, '2017-01-12 00:50:51', NULL),
(14, 52, 56, 56, 0, '2017-01-12 01:00:19', NULL),
(15, 53, 78, 78, 0, '2017-01-12 01:07:53', NULL),
(16, 54, 89, 89, 0, '2017-01-12 01:09:26', NULL),
(17, 55, 88, 88, 0, '2017-01-12 02:19:02', NULL),
(18, 56, 77, 77, 0, '2017-01-12 02:20:20', NULL),
(19, 57, 90, 90, 0, '2017-01-12 02:23:41', NULL),
(20, 58, 66, 66, 0, '2017-01-12 02:28:18', NULL),
(21, 59, 52, 52, 0, '2017-01-12 02:31:58', NULL),
(22, 60, 50, 50, 0, '2017-01-12 02:38:44', NULL),
(23, 61, 88, 88, 0, '2017-01-12 02:40:50', NULL),
(24, 62, 6, 6, 0, '2017-01-12 02:44:25', NULL),
(25, 63, 33, 33, 0, '2017-01-12 02:47:41', NULL),
(26, 64, 5, 5, 0, '2017-01-12 03:01:45', NULL),
(27, 65, 4, 4, 0, '2017-01-12 03:03:15', NULL),
(28, 66, 52, 52, 0, '2017-01-12 03:05:45', NULL),
(29, 67, 2, 2, 0, '2017-01-12 03:10:57', NULL),
(30, 68, 2121, 2121, 0, '2017-01-12 03:12:03', NULL),
(31, 69, 333, 333, 0, '2017-01-12 03:13:25', NULL),
(32, 70, 56, 56, 0, '2017-01-12 03:18:49', NULL),
(33, 71, 23, 23, 0, '2017-01-12 03:21:14', NULL),
(34, 74, 56, 56, 0, '2017-01-12 03:48:07', NULL),
(35, 75, 333, 333, 0, '2017-01-12 03:49:45', NULL),
(36, 76, 33, 33, 0, '2017-01-12 03:51:46', NULL),
(37, 77, 333, 333, 0, '2017-01-12 03:52:52', NULL),
(38, 78, 44, 44, 0, '2017-01-12 03:57:59', NULL),
(39, 79, 3322, 3322, 0, '2017-01-12 05:03:05', NULL),
(40, 80, 5000, 5000, 0, '2017-01-12 06:21:22', NULL),
(41, 81, 34, 34, 0, '2017-01-12 06:27:01', NULL),
(42, 82, 20, 20, 0, '2017-01-12 06:28:32', NULL),
(43, 83, 5000, 5000, 0, '2017-01-13 03:27:28', NULL),
(44, 84, 500, 500, 0, '2017-01-13 03:52:49', NULL),
(45, 85, 577, 577, 0, '2017-01-13 06:15:53', NULL),
(46, 86, 400, 400, 0, '2017-01-13 06:22:33', NULL),
(47, 87, 600, 600, 0, '2017-01-13 06:29:25', NULL),
(48, 88, 700, 700, 0, '2017-01-13 06:38:29', NULL),
(49, 89, 88, 88, 0, '2017-01-13 06:44:27', NULL),
(50, 90, 1000, 1000, 0, '2017-01-13 06:49:18', NULL),
(51, 91, 30, 30, 0, '2017-01-13 06:54:45', NULL),
(52, 92, 23, 23, 0, '2017-01-13 06:59:16', NULL),
(53, 93, 500, 500, 0, '2017-01-13 07:02:33', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `ms_goods_type`
--

CREATE TABLE `ms_goods_type` (
  `type_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `params` text,
  `disabled` tinyint(4) DEFAULT NULL,
  `is_physical` tinyint(4) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_goods_type`
--

INSERT INTO `ms_goods_type` (`type_id`, `name`, `params`, `disabled`, `is_physical`, `creatime`, `modifytime`) VALUES
(4, '饮料', '{"产地":"","净含量":"","保质期":"","口味":""}', 0, 0, '2016-09-07 09:23:20', '2016-10-17 08:15:28'),
(5, '酒水', '{"产地":"","储存方法":"","品种":"","净含量":"","保质期":"","配料":""}', 0, 0, '2016-09-07 09:25:26', '2016-09-07 09:25:26'),
(7, '女装', '{"袖长":"","流行元素":"","风格":"","衣长":""}', 0, 0, '2016-10-14 02:01:10', '2016-10-14 02:01:10'),
(14, '服装', '{"袖长":"","流行元素":"","风格":"","衣长":""}', 0, 0, '2016-11-11 07:24:09', '2016-11-11 07:25:01'),
(16, '饮料test2', '{"产地":"","净含量":"","保质期":"","口味":""}', 0, 0, '2016-11-18 01:25:11', '2016-11-18 01:25:11'),
(17, '饮料test3', '{"产地":"","净含量":"","保质期":"","口味":""}', 0, 0, '2016-11-18 01:56:31', '2016-11-18 01:56:31'),
(18, 'testfz', '{"袖长":"","流行元素":"","风格":"","衣长":""}', 0, 0, '2016-11-18 03:19:19', '2016-11-18 03:19:43'),
(21, '测试', '{"1":"","2":"","3":"","4":"","5":""}', 0, 0, '2016-12-28 09:22:15', '2016-12-28 09:22:15'),
(22, '化妆品', '{"产地":"","功效":"","保质期":"","适合肤质":"","规格类型":""}', 0, 0, '2017-01-13 02:17:43', '2017-01-13 02:17:43'),
(23, '珠宝', '{"产地":"","重量":"","贵重金属成分":"","售后服务":"","款式":""}', 0, 0, '2017-01-13 02:19:47', '2017-01-13 02:19:47'),
(24, '鞋', '{"产地":"","适合对象":"","材质":"","鞋跟":"","款式":""}', 0, 0, '2017-01-13 02:20:58', '2017-01-13 02:20:58'),
(25, '电子产品', '{"机身颜色":"","品牌":"","型号":"","规格":"","证书编号":""}', 0, 0, '2017-01-13 02:23:48', '2017-01-13 02:23:48'),
(26, ' 食品', '{"产地":"","配料表":"","食品口味":"","存储方式":"","净含量":""}', 0, 0, '2017-01-13 02:29:26', '2017-01-13 02:29:26'),
(27, ' 洗护用品', '{"产地":"","功效":"","适用人群":"","净含量":"","保质期":""}', 0, 0, '2017-01-13 02:34:39', '2017-01-13 02:34:39'),
(28, '包', '{"产地":"","颜色":"","材质":"","适用人群":"","款式":""}', 0, 0, '2017-01-13 02:47:30', '2017-01-13 02:47:30'),
(29, '香水', '{"产地":"","适用人群":"","香调":"","规格":"","保质期":""}', 0, 0, '2017-01-13 04:48:46', '2017-01-13 04:48:46');

-- --------------------------------------------------------

--
-- 表的结构 `ms_logi`
--

CREATE TABLE `ms_logi` (
  `logi_id` int(11) NOT NULL,
  `ship_id` int(11) NOT NULL,
  `sn` varchar(50) NOT NULL,
  `carriage` decimal(20,2) DEFAULT NULL,
  `sender` varchar(50) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_logi`
--

INSERT INTO `ms_logi` (`logi_id`, `ship_id`, `sn`, `carriage`, `sender`, `status`, `creatime`, `modifytime`) VALUES
(2, 2, '20161125001', 0.00, '张三', 2, '2016-11-25 03:25:57', '2016-11-25 03:26:36'),
(4, 3, 'yt20161202008', 8.00, '李四', 2, '2016-11-25 06:28:26', '2016-12-02 01:53:34'),
(5, 7, 'sf20161206008', 8.00, '赵柳柳', 1, '2016-12-06 02:03:51', '2016-12-06 02:08:40'),
(6, 0, '', 8.00, '', 0, '2016-12-06 02:04:15', '2016-12-06 02:04:15');

-- --------------------------------------------------------

--
-- 表的结构 `ms_member`
--

CREATE TABLE `ms_member` (
  `member_id` int(11) NOT NULL,
  `uname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sex` smallint(6) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastlogin` timestamp NULL DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_member`
--

INSERT INTO `ms_member` (`member_id`, `uname`, `password`, `email`, `sex`, `mobile`, `regtime`, `lastlogin`, `image`) VALUES
(3, 'ww', '123456', 'ww@qq.com', 1, '13643219876', '2016-09-07 06:32:50', NULL, ''),
(5, 'zs', 'gdyb21LQTcIANtvYMT7QVQ==', 'zs@qq.com', 1, '13345678765', '2016-10-09 07:41:56', NULL, 'http://192.168.8.7:8080/MobileShop/upload/YfmswqjQUrxbm2KqOHmN1A==_member.jpg'),
(6, '赵六', 'ICy5YqxZB1uWSwcVLSNLcA==', 'zl@qq.com', 0, '', '2016-10-09 07:42:53', NULL, ''),
(16, 'test', '4QrcOUm6Wau+VuBX8g+IPg==', 'test@qq.com', 0, '', '2016-10-10 03:21:28', '2016-12-29 03:45:18', 'http://192.168.8.7:8080/MobileShop/upload/RFR5X19/xA6DLGEhJF9v+A==_member.jpg'),
(19, 'test222', 'ICy5YqxZB1uWSwcVLSNLcA==', 'test1@qq.com', 1, '13245678765', '2016-10-10 07:14:23', '2016-10-10 09:09:13', ''),
(20, 'test2', 'ICy5YqxZB1uWSwcVLSNLcA==', 'test2@qq.com', 0, '', '2016-10-11 01:33:05', '2016-10-12 07:40:16', ''),
(21, 'zhang', 'xMpCOKC5I4INzFCab3WEmw==', '1', 0, '', '2016-10-12 03:25:44', NULL, ''),
(22, 'zhangsan', '4QrcOUm6Wau+VuBX8g+IPg==', 'aa@qq.com', 0, '', '2016-10-12 03:39:03', NULL, ''),
(23, 'lisi', '4QrcOUm6Wau+VuBX8g+IPg==', 'aaa@qq.com', 0, '', '2016-10-13 02:00:09', NULL, ''),
(24, 'test3', 'ICy5YqxZB1uWSwcVLSNLcA==', 'test3@qq.com', 0, '', '2016-10-13 02:16:24', NULL, ''),
(25, '李四', 'ICy5YqxZB1uWSwcVLSNLcA==', 'ls@qq.com', 0, '', '2016-10-27 08:48:02', NULL, ''),
(26, '李四2', 'ICy5YqxZB1uWSwcVLSNLcA==', 'ls2@qq.com', 0, '', '2016-10-27 08:57:17', NULL, ''),
(27, 'zhusheng', '4QrcOUm6Wau+VuBX8g+IPg==', 'zhusheng@123.com', 0, '', '2016-10-27 09:04:47', NULL, ''),
(30, '张思思', 'ICy5YqxZB1uWSwcVLSNLcA==', 'zsss@qq.com', 0, '', '2016-10-28 01:48:46', NULL, ''),
(31, '朱胜12134', '4QrcOUm6Wau+VuBX8g+IPg==', 'zhusheng@12134.com', 0, '', '2016-11-01 02:16:47', NULL, ''),
(33, 'testzry', 'WaiQjYYk5lhiw6h6xd/vhA==', '448966073@qq.com', 0, '', '2016-11-04 09:13:02', NULL, ''),
(34, 'test123', 'ICy5YqxZB1uWSwcVLSNLcA==', 'test123@qq.com', 0, '', '2016-11-23 00:33:10', NULL, '');

-- --------------------------------------------------------

--
-- 表的结构 `ms_member_address`
--

CREATE TABLE `ms_member_address` (
  `address_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `provice` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `addr` text,
  `mobile` varchar(50) NOT NULL,
  `receiver` varchar(50) NOT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_member_address`
--

INSERT INTO `ms_member_address` (`address_id`, `member_id`, `provice`, `city`, `region`, `addr`, `mobile`, `receiver`, `creatime`, `modifytime`) VALUES
(3, 16, '广东省', '深圳市', '南山区', '西丽', '13976543198', '李诗诗', '2016-09-07 06:36:21', '2016-09-07 06:36:21'),
(4, 16, '黑龙江省', '哈尔滨市', '南岗区', '南岗', '13576319854', '李思思', '2016-09-07 06:37:43', '2016-09-07 06:37:43'),
(5, 16, '广东省', '深圳市', '罗湖区', '罗湖体育馆', '13598763154', '张丽丽', '2016-09-07 06:39:01', '2016-09-07 06:39:01'),
(6, 16, '黑龙江省', '哈尔滨市', '道里区', '和平路', '13971986543', '李素素', '2016-09-07 06:40:18', '2016-09-07 06:40:18'),
(7, 16, '黑龙江省', '哈尔滨市', '道里区', '和平路', '13598763154', '张丽丽', '2016-09-07 06:40:57', '2016-09-07 06:40:57'),
(8, 16, '湖北省', '武汉市', '武昌区', '武昌', '13598763154', '张丹丹', '2016-09-07 06:41:45', '2016-09-07 06:41:45'),
(9, 3, '湖北省', '武汉市', '汉阳区', '汉阳', '13376315498', '王舞舞', '2016-09-07 06:43:06', '2016-09-07 06:43:06'),
(16, 3, '广东省', '深圳市', '龙岗区', '坂田', '13923456789', '王双双', '2016-10-12 08:59:22', '2016-10-12 09:09:55'),
(17, 3, '广东省', '深圳市', '罗湖区', '国贸', '13567892345', '王爽', '2016-10-12 09:22:49', '2016-10-12 09:22:49'),
(18, 16, '±±¾©ÊÐ', '±±¾©ÊÐ', 'º£µíÇø', 'ÒÃºÍÔ°Â·5ºÅ', '18575593069', 'ÖìÊ¤', '2016-10-27 07:34:52', '2016-10-27 07:34:52'),
(28, 3, 'é»é¾æ±ç', 'åå°æ»¨å¸', 'é¦ååº', '', '13489765432', 'jack', '2016-10-27 08:43:58', '2016-10-27 08:43:58'),
(29, 16, 'åäº¬å¸', 'åäº¬å¸', 'æµ·æ·åº', 'é¢åå­è·¯5å·', '18575593069', 'æ±è', '2016-10-27 08:47:37', '2016-10-27 08:47:37'),
(30, 16, 'åäº¬å¸', 'åäº¬å¸', 'æµ·æ·åº', 'é¢åå­è·¯5å·', '18575593069', 'æ±è', '2016-10-27 08:55:23', '2016-10-27 08:55:23'),
(31, 5, '广西省', '桂林市', '桂林', '', '19867894532', '张珊珊', '2016-11-24 00:49:16', '2016-11-24 00:49:16'),
(32, 5, '广东省', '深圳市', '龙岗区', '坂田', '18945368765', '张思思', '2016-12-29 01:28:40', '2016-12-29 01:28:40');

-- --------------------------------------------------------

--
-- 表的结构 `ms_order`
--

CREATE TABLE `ms_order` (
  `order_id` int(11) NOT NULL,
  `sn` varchar(255) NOT NULL,
  `member_id` int(11) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `logi_id` int(11) DEFAULT NULL,
  `total_amount` decimal(20,2) DEFAULT NULL,
  `address_id` char(10) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_order`
--

INSERT INTO `ms_order` (`order_id`, `sn`, `member_id`, `status`, `payment_id`, `logi_id`, `total_amount`, `address_id`, `creatime`, `modifytime`) VALUES
(3, '70dc236b89d940e69a3efe82fd21613a', 16, 3, 2, 2, 139.10, '3', '2016-11-24 00:39:03', '2016-11-24 00:39:03'),
(4, 'd98085536e044a209bf489d127043da0', 5, 4, 0, 0, 9.90, '31', '2016-11-24 00:50:24', '2016-11-24 00:50:24'),
(5, 'e86e292b639a458e864661b2a15eb978', 16, 4, 0, 0, 29.70, '3', '2016-11-24 08:19:22', '2016-11-24 08:19:22'),
(7, '7ef937daa5794191bc94f86fa68e0229', 16, 3, 4, 4, 27.80, '3', '2016-11-25 06:28:26', '2016-11-25 06:28:26'),
(8, '32458ba7edd0494ba08c00855d5d58b8', 16, 4, 0, 0, 57.50, '6', '2016-12-02 08:22:24', '2016-12-02 08:22:24'),
(9, '6aa7499f045845669ee65771d5901f16', 16, 3, 5, 5, 55.76, '4', '2016-12-06 02:03:51', '2016-12-06 02:03:51'),
(10, 'a1577b2052364d19acdbc56d220d05f4', 5, 0, 6, 6, 79.64, '31', '2016-12-06 02:04:15', '2016-12-06 02:04:15');

-- --------------------------------------------------------

--
-- 表的结构 `ms_order_goods`
--

CREATE TABLE `ms_order_goods` (
  `id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_num` int(11) NOT NULL,
  `price` decimal(20,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_order_goods`
--

INSERT INTO `ms_order_goods` (`id`, `order_id`, `goods_id`, `goods_num`, `price`) VALUES
(2, 3, 11, 4, 9.90),
(3, 3, 22, 5, 19.90),
(4, 4, 29, 1, 9.90),
(5, 5, 29, 3, 9.90),
(7, 7, 29, 2, 9.90),
(8, 8, 32, 5, 9.90),
(9, 9, 4, 2, 23.88),
(10, 10, 5, 3, 23.88);

-- --------------------------------------------------------

--
-- 表的结构 `ms_order_log`
--

CREATE TABLE `ms_order_log` (
  `log_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_order_log`
--

INSERT INTO `ms_order_log` (`log_id`, `order_id`, `status`, `time`) VALUES
(2, 3, 0, '2016-11-24 00:39:03'),
(3, 4, 0, '2016-11-24 00:50:24'),
(4, 5, 0, '2016-11-24 08:19:22'),
(6, 7, 0, '2016-11-25 06:28:26'),
(7, 7, 1, '2016-12-02 01:14:32'),
(8, 7, 2, '2016-12-02 01:53:34'),
(9, 7, 3, '2016-12-02 01:54:44'),
(10, 4, 4, '2016-12-02 06:33:11'),
(11, 5, 4, '2016-12-02 06:40:03'),
(12, 3, 3, '2016-12-02 08:08:29'),
(13, 8, 0, '2016-12-02 08:22:24'),
(14, 8, 4, '2016-12-02 08:23:32'),
(15, 9, 0, '2016-12-06 02:03:51'),
(16, 10, 0, '2016-12-06 02:04:15'),
(17, 9, 1, '2016-12-06 02:05:44'),
(18, 9, 2, '2016-12-06 02:08:40'),
(19, 9, 3, '2016-12-06 02:29:30');

-- --------------------------------------------------------

--
-- 表的结构 `ms_payment`
--

CREATE TABLE `ms_payment` (
  `payment_id` int(11) NOT NULL,
  `sn` varchar(50) DEFAULT NULL,
  `paytype_id` int(11) DEFAULT NULL,
  `amount` decimal(20,2) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `paytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `remark` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_payment`
--

INSERT INTO `ms_payment` (`payment_id`, `sn`, `paytype_id`, `amount`, `status`, `paytime`, `remark`) VALUES
(2, '16148004259122571', 1, 139.10, 1, '2016-11-25 02:56:31', ''),
(4, '16148005530634416', 1, 27.80, 1, '2016-12-02 01:14:32', ''),
(5, '1614809898313933', 1, 55.76, 1, '2016-12-06 02:05:44', ''),
(6, '5148098985525455', 1, 79.64, 0, '2016-12-06 02:04:15', '');

-- --------------------------------------------------------

--
-- 表的结构 `ms_paytype`
--

CREATE TABLE `ms_paytype` (
  `paytype_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `config` text,
  `description` text,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_paytype`
--

INSERT INTO `ms_paytype` (`paytype_id`, `name`, `config`, `description`, `creatime`, `modifytime`) VALUES
(1, '支付宝', '', '支付宝（中国）网络技术有限公司是国内领先的第三方支付平台，致力于提供“简单、安全、快速”的支付解决方案。', '2016-11-23 02:15:31', '2016-11-23 02:15:31'),
(2, '微信', '微信', '微信', '2016-11-23 02:16:06', '2017-01-06 03:46:05'),
(6, '快钱', '', '快钱', '2016-11-23 02:48:41', '2016-11-23 03:01:47');

-- --------------------------------------------------------

--
-- 表的结构 `ms_role`
--

CREATE TABLE `ms_role` (
  `role_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_role`
--

INSERT INTO `ms_role` (`role_id`, `name`, `description`, `creatime`, `modifytime`) VALUES
(1, '超级管理员', '拥有所有权限', '2016-11-30 07:37:32', '2017-01-06 03:47:54'),
(2, '商品管理员', '管理商品列表、类型列表、分类列表、品牌列表等', '2016-11-30 07:39:03', '2016-11-30 07:39:03'),
(3, '订单管理员', '管理订单列表、货运公司列表等', '2016-11-30 07:40:01', '2016-11-30 07:40:01');

-- --------------------------------------------------------

--
-- 表的结构 `ms_ship`
--

CREATE TABLE `ms_ship` (
  `ship_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_ship`
--

INSERT INTO `ms_ship` (`ship_id`, `name`, `code`, `creatime`, `modifytime`) VALUES
(2, '申通快递', 'shentong', '2016-11-22 07:13:39', '2016-11-22 07:50:00'),
(3, '圆通快递', 'yuantong', '2016-11-22 07:14:04', '2016-11-22 08:08:57'),
(6, '韵达快递', 'ydkd', '2016-11-22 07:35:05', '2016-11-22 07:35:05'),
(7, '顺丰速运', 'sfsy', '2016-11-22 07:36:09', '2016-11-22 07:36:09'),
(8, '跨越速运', 'kuayue', '2016-11-22 08:07:24', '2016-11-22 08:07:24'),
(9, '天天快递', 'ttkd', '2016-11-24 00:42:54', '2017-01-06 03:48:52');

-- --------------------------------------------------------

--
-- 表的结构 `ms_tag`
--

CREATE TABLE `ms_tag` (
  `tag_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `count` int(11) NOT NULL,
  `sort` smallint(6) DEFAULT NULL,
  `team` tinyint(4) NOT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_tag`
--

INSERT INTO `ms_tag` (`tag_id`, `name`, `type`, `count`, `sort`, `team`, `creatime`, `modifytime`) VALUES
(2, '本周热卖', 0, 5, 1, 1, '2016-09-08 06:30:59', '2016-09-08 06:30:59'),
(3, '商家推荐', 0, 5, 0, 1, '2016-09-08 06:31:29', '2016-09-08 06:31:29'),
(4, '品牌1', 1, 6, 0, 0, '2016-09-08 06:37:53', '2016-09-09 07:34:44'),
(6, '特别推荐', 0, 6, 0, 0, '2016-11-01 06:32:19', '2016-11-01 06:32:19'),
(7, '猜你喜欢', 0, 6, 0, 0, '2016-11-01 06:40:56', '2016-11-01 06:40:56'),
(8, '新品上市', 0, 6, 0, 0, '2016-11-01 07:04:37', '2016-11-01 07:04:37'),
(9, '疯狂抢购', 0, 6, 0, 0, '2016-11-01 07:04:56', '2016-11-01 07:04:56'),
(10, '销售热卖', 0, 6, 0, 0, '2016-11-01 07:05:15', '2016-11-01 07:05:15'),
(11, '休闲零食', 0, 8, 0, 1, '2016-11-01 07:07:10', '2016-11-01 07:07:10'),
(12, '饮料', 0, 8, 0, 1, '2016-11-01 07:07:43', '2016-11-01 07:07:43'),
(13, '酒水', 0, 8, 0, 1, '2016-11-01 07:07:54', '2016-11-01 07:07:54'),
(14, '糖果', 0, 8, 0, 1, '2016-11-01 07:08:29', '2016-11-01 07:08:29'),
(15, '品牌', 1, 18, 0, 1, '2016-11-03 07:01:04', '2016-11-03 07:01:04'),
(17, '品牌标签测试', 1, 18, 2, 2, '2016-11-03 07:59:55', '2017-01-06 03:53:04');

-- --------------------------------------------------------

--
-- 表的结构 `ms_tag_brand_ref`
--

CREATE TABLE `ms_tag_brand_ref` (
  `id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `sort` smallint(6) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_tag_brand_ref`
--

INSERT INTO `ms_tag_brand_ref` (`id`, `tag_id`, `brand_id`, `sort`, `creatime`, `modifytime`) VALUES
(1, 4, 3, 3, '2016-09-08 07:04:51', '2016-11-07 01:41:44'),
(2, 4, 6, 5, '2016-09-08 07:05:02', '2016-11-07 01:42:09'),
(3, 4, 2, 2, '2016-11-03 06:43:12', '2016-11-07 01:58:34'),
(4, 4, 4, 0, '2016-11-04 09:10:49', '2016-11-04 09:10:49'),
(5, 4, 5, 0, '2016-11-04 09:11:01', '2016-11-04 09:11:01');

-- --------------------------------------------------------

--
-- 表的结构 `ms_tag_goods_ref`
--

CREATE TABLE `ms_tag_goods_ref` (
  `id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `sort` smallint(6) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_tag_goods_ref`
--

INSERT INTO `ms_tag_goods_ref` (`id`, `tag_id`, `goods_id`, `sort`, `creatime`, `modifytime`) VALUES
(1, 2, 2, 1, '2016-09-08 06:50:39', '2016-11-07 01:14:19'),
(2, 2, 5, 2, '2016-09-08 06:51:32', '2016-11-07 01:14:40'),
(3, 3, 20, 3, '2016-11-03 02:49:31', '2016-11-07 01:19:43'),
(4, 3, 21, 8, '2016-11-03 02:49:44', '2016-11-07 01:19:59'),
(5, 6, 20, 0, '2016-11-04 06:04:16', '2016-11-04 06:04:16'),
(6, 6, 21, 0, '2016-11-04 06:04:50', '2016-11-04 06:04:50'),
(9, 7, 29, 0, '2016-11-04 07:05:31', '2016-11-04 07:05:31');

-- --------------------------------------------------------

--
-- 表的结构 `ms_type_brand`
--

CREATE TABLE `ms_type_brand` (
  `id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ms_type_brand`
--

INSERT INTO `ms_type_brand` (`id`, `type_id`, `brand_id`, `creatime`, `modifytime`) VALUES
(2, 4, 7, '2016-09-08 01:04:04', '2016-10-18 06:51:39'),
(4, 4, 5, '2016-09-08 01:22:14', '2016-09-09 02:50:31'),
(5, 29, 10, '2016-10-17 07:26:59', '2016-10-17 07:26:59'),
(6, 5, 5, '2016-10-18 03:29:17', '2016-10-18 03:29:17'),
(7, 4, 6, '2016-10-18 06:52:10', '2016-10-18 06:52:10'),
(9, 29, 11, '2016-10-18 08:56:24', '2016-10-18 08:56:24'),
(10, 26, 2, '2017-01-13 02:30:02', '2017-01-13 02:30:02'),
(11, 26, 3, '2017-01-13 02:30:19', '2017-01-13 02:30:19'),
(12, 7, 4, '2017-01-13 02:30:44', '2017-01-13 02:30:44'),
(13, 22, 10, '2017-01-13 02:31:33', '2017-01-13 02:31:33'),
(14, 22, 11, '2017-01-13 02:31:47', '2017-01-13 02:31:47'),
(15, 22, 13, '2017-01-13 02:31:54', '2017-01-13 02:31:54'),
(16, 22, 20, '2017-01-13 02:32:08', '2017-01-13 02:32:08'),
(17, 22, 21, '2017-01-13 02:32:14', '2017-01-13 02:32:14'),
(18, 22, 22, '2017-01-13 02:32:19', '2017-01-13 02:32:19'),
(19, 27, 22, '2017-01-13 02:34:54', '2017-01-13 02:34:54'),
(21, 27, 24, '2017-01-13 02:35:20', '2017-01-13 02:35:20'),
(22, 5, 41, '2017-01-13 03:46:39', '2017-01-13 03:46:39'),
(23, 29, 42, '2017-01-13 04:53:24', '2017-01-13 04:53:24'),
(24, 29, 43, '2017-01-13 04:53:59', '2017-01-13 04:53:59'),
(25, 29, 44, '2017-01-13 04:54:33', '2017-01-13 04:54:33'),
(26, 29, 45, '2017-01-13 04:55:19', '2017-01-13 04:55:19');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ms_admin`
--
ALTER TABLE `ms_admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `ms_brand`
--
ALTER TABLE `ms_brand`
  ADD PRIMARY KEY (`brand_id`);

--
-- Indexes for table `ms_cart`
--
ALTER TABLE `ms_cart`
  ADD PRIMARY KEY (`cart_id`);

--
-- Indexes for table `ms_goods`
--
ALTER TABLE `ms_goods`
  ADD PRIMARY KEY (`goods_id`);

--
-- Indexes for table `ms_goods_cat`
--
ALTER TABLE `ms_goods_cat`
  ADD PRIMARY KEY (`cat_id`);

--
-- Indexes for table `ms_goods_comment`
--
ALTER TABLE `ms_goods_comment`
  ADD PRIMARY KEY (`comment_id`);

--
-- Indexes for table `ms_goods_img`
--
ALTER TABLE `ms_goods_img`
  ADD PRIMARY KEY (`img_id`);

--
-- Indexes for table `ms_goods_like`
--
ALTER TABLE `ms_goods_like`
  ADD PRIMARY KEY (`like_id`);

--
-- Indexes for table `ms_goods_store`
--
ALTER TABLE `ms_goods_store`
  ADD PRIMARY KEY (`store_id`);

--
-- Indexes for table `ms_goods_type`
--
ALTER TABLE `ms_goods_type`
  ADD PRIMARY KEY (`type_id`);

--
-- Indexes for table `ms_logi`
--
ALTER TABLE `ms_logi`
  ADD PRIMARY KEY (`logi_id`);

--
-- Indexes for table `ms_member`
--
ALTER TABLE `ms_member`
  ADD PRIMARY KEY (`member_id`);

--
-- Indexes for table `ms_member_address`
--
ALTER TABLE `ms_member_address`
  ADD PRIMARY KEY (`address_id`);

--
-- Indexes for table `ms_order`
--
ALTER TABLE `ms_order`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `ms_order_goods`
--
ALTER TABLE `ms_order_goods`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ms_order_log`
--
ALTER TABLE `ms_order_log`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `ms_payment`
--
ALTER TABLE `ms_payment`
  ADD PRIMARY KEY (`payment_id`);

--
-- Indexes for table `ms_paytype`
--
ALTER TABLE `ms_paytype`
  ADD PRIMARY KEY (`paytype_id`);

--
-- Indexes for table `ms_role`
--
ALTER TABLE `ms_role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `ms_ship`
--
ALTER TABLE `ms_ship`
  ADD PRIMARY KEY (`ship_id`);

--
-- Indexes for table `ms_tag`
--
ALTER TABLE `ms_tag`
  ADD PRIMARY KEY (`tag_id`);

--
-- Indexes for table `ms_tag_brand_ref`
--
ALTER TABLE `ms_tag_brand_ref`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ms_tag_goods_ref`
--
ALTER TABLE `ms_tag_goods_ref`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ms_type_brand`
--
ALTER TABLE `ms_type_brand`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `ms_admin`
--
ALTER TABLE `ms_admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
--
-- 使用表AUTO_INCREMENT `ms_brand`
--
ALTER TABLE `ms_brand`
  MODIFY `brand_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
--
-- 使用表AUTO_INCREMENT `ms_cart`
--
ALTER TABLE `ms_cart`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- 使用表AUTO_INCREMENT `ms_goods`
--
ALTER TABLE `ms_goods`
  MODIFY `goods_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;
--
-- 使用表AUTO_INCREMENT `ms_goods_cat`
--
ALTER TABLE `ms_goods_cat`
  MODIFY `cat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
--
-- 使用表AUTO_INCREMENT `ms_goods_comment`
--
ALTER TABLE `ms_goods_comment`
  MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- 使用表AUTO_INCREMENT `ms_goods_img`
--
ALTER TABLE `ms_goods_img`
  MODIFY `img_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;
--
-- 使用表AUTO_INCREMENT `ms_goods_like`
--
ALTER TABLE `ms_goods_like`
  MODIFY `like_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- 使用表AUTO_INCREMENT `ms_goods_store`
--
ALTER TABLE `ms_goods_store`
  MODIFY `store_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;
--
-- 使用表AUTO_INCREMENT `ms_goods_type`
--
ALTER TABLE `ms_goods_type`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- 使用表AUTO_INCREMENT `ms_logi`
--
ALTER TABLE `ms_logi`
  MODIFY `logi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- 使用表AUTO_INCREMENT `ms_member`
--
ALTER TABLE `ms_member`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--
-- 使用表AUTO_INCREMENT `ms_member_address`
--
ALTER TABLE `ms_member_address`
  MODIFY `address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- 使用表AUTO_INCREMENT `ms_order`
--
ALTER TABLE `ms_order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- 使用表AUTO_INCREMENT `ms_order_goods`
--
ALTER TABLE `ms_order_goods`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- 使用表AUTO_INCREMENT `ms_order_log`
--
ALTER TABLE `ms_order_log`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- 使用表AUTO_INCREMENT `ms_payment`
--
ALTER TABLE `ms_payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- 使用表AUTO_INCREMENT `ms_paytype`
--
ALTER TABLE `ms_paytype`
  MODIFY `paytype_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- 使用表AUTO_INCREMENT `ms_role`
--
ALTER TABLE `ms_role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- 使用表AUTO_INCREMENT `ms_ship`
--
ALTER TABLE `ms_ship`
  MODIFY `ship_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- 使用表AUTO_INCREMENT `ms_tag`
--
ALTER TABLE `ms_tag`
  MODIFY `tag_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- 使用表AUTO_INCREMENT `ms_tag_brand_ref`
--
ALTER TABLE `ms_tag_brand_ref`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- 使用表AUTO_INCREMENT `ms_tag_goods_ref`
--
ALTER TABLE `ms_tag_goods_ref`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- 使用表AUTO_INCREMENT `ms_type_brand`
--
ALTER TABLE `ms_type_brand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
