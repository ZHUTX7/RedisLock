# RedisLock
 Redis分布式锁 - 布隆过滤器 Demo

1. 添加了两种分布式锁
（1）手动实现 - SimpleLock
   (2) Redission分布式锁
   解决问题： 业务没有执行完而锁过期 
   
2。 添加两种布隆过滤器实现方案
（1） google guava布隆过滤器 - BloomConfig类 - 适用于单机系统 - 布隆过滤器采用JVM内存实现
（2） Redission分布式布隆过滤器 - RedissionBloom类 - 适用于分布式系统 - 布隆过滤器放在Redis服务器上

-SQL-

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
`id` int NOT NULL,
`name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
`sum` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` (`id`, `name`, `sum`) VALUES (1, 'iphone', 913306);
INSERT INTO `product` (`id`, `name`, `sum`) VALUES (2, 'airpods', 100);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;