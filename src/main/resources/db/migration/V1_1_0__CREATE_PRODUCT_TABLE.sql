CREATE TABLE IF NOT EXISTS `tb_01_product` (
                                 `id` binary(16) NOT NULL,
                                 `description` varchar(255) DEFAULT NULL,
                                 `active` bit(1) DEFAULT NULL,
                                 `name` varchar(255) DEFAULT NULL,
                                 `quantity_in_stock` int DEFAULT NULL,
                                 `sale_unit` smallint DEFAULT NULL,
                                 `unit_price` double DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;