drop table if exists reservation_user_comment_image;
drop table if exists reservation_user_comment;
drop table if exists reservation_info_price;
drop table if exists reservation_info;
drop table if exists promotion;
drop table if exists product_price;
drop table if exists product_image;
drop table if exists display_info_image;
drop table if exists display_info;
drop table if exists product;
drop table if exists file_info;
drop table if exists category;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
CREATE TABLE `category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '카테고리 id',
  `name` VARCHAR(50) NOT NULL COMMENT '카테고리 이름',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `fileinfo`
-- -----------------------------------------------------
CREATE TABLE `file_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '파일id',
  `file_name` VARCHAR(255) NOT NULL COMMENT '원본 파일명',
  `save_file_name` VARCHAR(4000) NOT NULL COMMENT 'save파일 명',
  `content_type` VARCHAR(255) NOT NULL COMMENT '파일 mime type',
  `delete_flag` INT(1) NOT NULL COMMENT '삭제유무 삭제:1, 삭제안됨 : 0',
  `create_date` DATETIME NULL DEFAULT NULL COMMENT '등록일',
  `modify_date` DATETIME NULL DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
CREATE TABLE `product` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '상품id',
  `category_id` INT(11) NOT NULL COMMENT '카테고리id',
  `description` VARCHAR(100) NULL DEFAULT NULL COMMENT '상품 간단 설명',
  `content` TEXT NULL DEFAULT NULL COMMENT '상품 상세 설명',
  `event` VARCHAR(4000) NULL DEFAULT NULL COMMENT '이벤트 정보',
  `create_date` DATETIME NULL DEFAULT NULL COMMENT '생성시간',
  `modify_date` DATETIME NULL DEFAULT NULL COMMENT '수정시간',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`category_id`)
  REFERENCES `category` (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `display_info`
-- -----------------------------------------------------
CREATE TABLE `display_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '전시정보id',
  `product_id` INT(11) NOT NULL COMMENT 'product id',
  `opening_hours` VARCHAR(400) COMMENT '전시 시간',
  `place_name` VARCHAR(50) NOT NULL COMMENT '장소 명 ex>세종문화회관',
  `place_lot` VARCHAR(100) NULL DEFAULT NULL COMMENT '지번 주소',
  `place_street` VARCHAR(100) NULL DEFAULT NULL COMMENT '도로명 주소',
  `tel` VARCHAR(20) NULL DEFAULT NULL COMMENT '문의전화번호',
  `homepage` VARCHAR(255) NULL DEFAULT NULL COMMENT '홈페이지',
  `email` VARCHAR(255) NULL DEFAULT NULL COMMENT '문의email',
  `create_date` DATETIME NULL DEFAULT NULL COMMENT '생성시간',
  `modify_date` DATETIME NULL DEFAULT NULL COMMENT '수정시간',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`)
  REFERENCES `product` (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `product_image`
-- -----------------------------------------------------
CREATE TABLE `product_image` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '상품 이미지 id',
  `product_id` INT(11) NOT NULL COMMENT '상품 id',
  `type` VARCHAR(2) NOT NULL COMMENT '이미지 type, th: 썸네일, ma: 메인, et: 기타 (etc)',
  `file_id` INT(11) NOT NULL COMMENT 'file id',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`)
  REFERENCES `product` (`id`),
  FOREIGN KEY (`file_id`)
  REFERENCES `file_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `display_info_image`
-- -----------------------------------------------------
CREATE TABLE `display_info_image` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '전시정보 이미지 id',
  `display_info_id` INT(11) NOT NULL COMMENT '전시정보 id',
  `file_id` INT(11) NOT NULL COMMENT 'file id',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`display_info_id`)
  REFERENCES `display_info` (`id`),
  FOREIGN KEY (`file_id`)
  REFERENCES `file_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `product_price`
-- -----------------------------------------------------
CREATE TABLE `product_price` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '상품 가격 id',
  `product_id` INT(11) NOT NULL COMMENT '상품 id',
  `price_type_name` VARCHAR(25) NOT NULL COMMENT '성인(A), 청소년(Y), 유아(B), 셋트(S), 장애인(D), 지역주민(C), 어얼리버드(E) 기타 다른 유형이 있다면 위와 겹치지 않게 1자로 정의하여 기입, VIP(V), R석(R), B석(B), S석(S), 평일(D)',
  `price` INT(11) NOT NULL COMMENT '상품 가격',
  `discount_rate` DECIMAL(5,2) NOT NULL COMMENT '할인율',
  `create_date` DATETIME NULL DEFAULT NULL COMMENT '등록일',
  `modify_date` DATETIME NULL DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`)
  REFERENCES `product` (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `promotion`
-- -----------------------------------------------------
CREATE TABLE `promotion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '프로모션 id',
  `product_id` INT(11) NOT NULL COMMENT '프로모션id',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`)
  REFERENCES `product` (`id`))
  ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `reservation_info`
-- -----------------------------------------------------
CREATE TABLE `reservation_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '예매 id',
  `product_id` INT(11) NOT NULL COMMENT '상품 id',
  `display_info_id` INT(11) NOT NULL COMMENT '전시상품 id',
  `reservation_name` VARCHAR(50) NOT NULL COMMENT '예매자 이름',
  `reservation_tel` VARCHAR(255) NOT NULL COMMENT '예매자 전화번호',
  `reservation_email` VARCHAR(255) NOT NULL COMMENT '예매자 email',
  `reservation_date` DATETIME NOT NULL COMMENT '예매일',
  `cancel_flag` INT(1) NOT NULL DEFAULT '0' COMMENT '취소 : 1, 예약 : 0',
  `create_date` DATETIME DEFAULT NULL COMMENT '등록일',
  `modify_date` DATETIME DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  FOREIGN KEY (`display_info_id`) REFERENCES `display_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- -----------------------------------------------------
-- Table `reservation_info_price`
-- -----------------------------------------------------
CREATE TABLE `reservation_info_price` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '예매 가격 id',
  `reservation_info_id` INT(11) NOT NULL COMMENT '예매 정보 id',
  `product_price_id` INT(11) NOT NULL COMMENT '상품 가격 id',
  `count` INT(11) NOT NULL COMMENT '예매수',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`reservation_info_id`)
  REFERENCES `reservation_info` (`id`),
  FOREIGN KEY (`product_price_id`)
  REFERENCES `product_price` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `reservation_user_comment`
-- -----------------------------------------------------
CREATE TABLE `reservation_user_comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '한줄평 id',
  `product_id` INT(11) NOT NULL COMMENT '상품 id',
  `reservation_info_id` INT(11) NOT NULL COMMENT '예매 id',
  `score` DECIMAL(2,1) NOT NULL COMMENT '별점',
  `comment` TEXT NOT NULL COMMENT '한줄평',
  `create_date` DATETIME NULL DEFAULT NULL COMMENT '등록일',
  `modify_date` DATETIME NULL DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`)
  REFERENCES `product` (`id`),
  FOREIGN KEY (`reservation_info_id`)
  REFERENCES `reservation_info` (`id`))  ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `reservation_user_comment_image`
-- -----------------------------------------------------
CREATE TABLE `reservation_user_comment_image` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '상품 커맨트 이미지 id',
  `reservation_info_id` INT(11) NOT NULL COMMENT '예매 id',
  `reservation_user_comment_id` INT(11) NOT NULL COMMENT '한줄평 id',
  `file_id` INT(11) NOT NULL COMMENT '파일 id',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`reservation_info_id`)
  REFERENCES `reservation_info` (`id`),
  FOREIGN KEY (`reservation_user_comment_id`)
  REFERENCES `reservation_user_comment` (`id`),
  FOREIGN KEY (`file_id`)
  REFERENCES `file_info` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;