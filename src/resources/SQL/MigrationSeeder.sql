DROP DATABASE IF EXISTS `calouseif`;
CREATE DATABASE `calouseif`;
USE `calouseif`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `User_id` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Phone_Number` varchar(255) NOT NULL,
  `Address` text NOT NULL,
  `Role` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
);

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `Item_id` varchar(255) NOT NULL,
  `Item_seller_id` varchar(255) NOT NULL,
  `Item_name` varchar(255) NOT NULL,
  `Item_size` varchar(255) NOT NULL,
  `Item_price` varchar(255) NOT NULL,
  `Item_category` varchar(255) NOT NULL,
  `Item_status` varchar(255) NOT NULL,
  `Item_wishlist` varchar(255) NOT NULL,
  `Item_offer_status` varchar(255) NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FK_item_user_idx` (`Item_seller_id`),
  CONSTRAINT `FK_item_user`FOREIGN KEY (`Item_seller_id`) REFERENCES `user` (`User_id`)
);

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `User_id` varchar(255) NOT NULL,
  `Item_id` varchar(255) NOT NULL,
  `transaction_id` varchar(255) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FK_transaction_user_idx` (`user_id`),
  KEY `FK_transaction_item_idx` (`item_id`),
  CONSTRAINT `FK_transaction_item` FOREIGN KEY (`Item_id`) REFERENCES `item` (`Item_id`),
  CONSTRAINT `FK_transaction_user` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`)
);

DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE `wishlist` (
  `Wishlist_id` varchar(255) NOT NULL,
  `Item_id` varchar(255) NOT NULL,
  `User_id` varchar(255) NOT NULL,
  PRIMARY KEY (`wishlist_id`),
  KEY `FK_wishlist_user_idx` (`User_id`),
  KEY `FK_wishlist_item_idx` (`Item_id`),
  CONSTRAINT `FK_wishlist_item` FOREIGN KEY (`Item_id`) REFERENCES `item` (`Item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_wishlist_user` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

USE calouseif;

INSERT INTO `user` (`User_id`, `Username`, `Password`, `Phone_Number`, `Address`, `Role`) VALUES
('55923e3a-5781-42a4-858c-309605badaf3', 'Buyer', 'y0Sc9AK35Fck9ZMv022erg==', '+62123456789', 'Binus', 'buyer'),
('68406ea2-f7ad-4808-bf68-6573629be257', 'admin', 'qLRywyE0xJuJn1MzXynPug==', '+62123456789', 'Binus', 'admin'),
('b4e480c9-e689-4b45-91b7-b737063f312b', 'Seller', 'y0Sc9AK35Fck9ZMv022erg==', '+62123456789', 'Binus', 'seller');

INSERT INTO item (Item_id, Item_seller_id, Item_name, Item_size, Item_price, Item_category, Item_status, Item_wishlist, Item_offer_status)
VALUES
    ('9c7cfc05-07c5-4470-a3e5-00f03cd5d879', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Blue T-shirt', 'M', 100000, 'Tops', 'approved', '0', 'no_offer'),
    ('34147457-04ad-456d-8467-df11fedb3800', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Black Jeans', 'L', 150000, 'Bottoms', 'approved', '0', 'no_offer'),
    ('e8678043-341a-4e56-a08e-22a9cd694b12', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'White Shirt', 'S', 120000, 'Tops', 'waiting', '0', 'no_offer'),
    ('6dfaf584-e90e-4e86-8d2e-8268dfc21637', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Red Dress', 'M', 250000, 'Dresses', 'approved', '0', 'offer,200000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('1886a115-7ae9-456a-a6fd-b7c3cebad445', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Green Shorts', 'XL', 80000, 'Bottoms', 'declined,Size issue', '0', 'no_offer'),
    ('5b7be490-f755-46f1-bc72-bc7ef53f8747', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Yellow Sweater', 'M', 180000, 'Outerwear', 'approved', '0', 'no_offer'),
    ('95652419-8dcb-4c11-a862-d0ccdf0eddcf', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Brown Jacket', 'L', 300000, 'Outerwear', 'approved', '0', 'offer,280000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('831af440-8bdf-4380-a58b-3fcfce03ffb6', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Pink Skirt', 'S', 140000, 'Bottoms', 'waiting', '0', 'no_offer'),
    ('6c68a1ea-f75e-4865-980f-1356274bce78', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Blue Hoodie', 'M', 220000, 'Outerwear', 'approved', '0', 'no_offer'),
    ('4e18e77f-f133-45ec-9a05-566de9540a97', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Gray Pants', 'L', 160000, 'Bottoms', 'declined,Fabric issue', '0', 'no_offer'),
    ('99dd5f20-9c6c-4375-936c-782c1055167b', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Black T-shirt', 'S', 110000, 'Tops', 'approved', '0', 'offer,100000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('c919e458-0e08-480e-8cca-51fc5c117e5d', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Purple Blouse', 'M', 130000, 'Tops', 'approved', '0', 'no_offer'),
    ('0d5b85e8-51ea-4696-9f89-f6c28585daed', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Orange Tank Top', 'L', 90000, 'Tops', 'approved', '0', 'no_offer'),
    ('08580d28-9a4b-47d3-b8e3-fe14705c541e', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'White Shorts', 'M', 85000, 'Bottoms', 'approved', '0', 'no_offer'),
    ('6f93cac5-2f04-4c0a-ae96-5569a1942ce5', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Black Skirt', 'S', 145000, 'Bottoms', 'waiting', '0', 'no_offer'),
    ('8ab21c0d-8bfb-4d8d-b59a-da804c8168b1', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Red Jacket', 'XL', 310000, 'Outerwear', 'approved', '0', 'offer,290000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('67a3b3b9-e8f6-4f9c-959f-89923d3b9501', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Blue Jeans', 'L', 170000, 'Bottoms', 'approved', '0', 'no_offer'),
    ('fbd0c186-d375-42d1-854d-894b4717d058', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Green T-shirt', 'M', 105000, 'Tops', 'approved', '0', 'no_offer'),
    ('5517761a-1a61-4bcc-9ce9-55be050c9f51', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Yellow Shirt', 'S', 125000, 'Tops', 'declined,Color mismatch', '0', 'no_offer'),
    ('324ac9c2-f586-4e20-8bff-706c1fa57de4', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Gray Sweater', 'L', 185000, 'Outerwear', 'approved', '0', 'offer,175000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('5a75a88c-b061-4aac-8f34-77e979013256', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Black Dress', 'M', 260000, 'Dresses', 'waiting', '0', 'no_offer'),
    ('2225cbc2-d679-4a08-8306-891f0711937c', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Pink Tank Top', 'S', 95000, 'Tops', 'bought', '0', 'no_offer'),
    ('08f0cf81-edb1-4528-a661-6c09f64d96cb', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'White Blouse', 'M', 135000, 'Tops', 'approved', '0', 'no_offer'),
    ('227d523b-ff15-4634-bb4a-7e3b0ff15c1b', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Brown Pants', 'L', 155000, 'Bottoms', 'approved', '0', 'offer,150000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('bb589a9b-2ef4-4063-bd2a-75deed66526e', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Green Skirt', 'S', 148000, 'Bottoms', 'waiting', '0', 'no_offer'),
    ('91574199-716f-47e1-a43a-b9c8da4e92cc', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Yellow Jacket', 'XL', 320000, 'Outerwear', 'approved', '0', 'offer,300000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('501c03f8-195b-4ce3-a9ca-6a4bbe00ad18', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Blue Hoodie', 'M', 230000, 'Outerwear', 'approved', '0', 'no_offer'),
    ('4b43ea7e-070b-4080-9749-6a3604dd9e11', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Orange Jeans', 'L', 165000, 'Bottoms', 'declined,Fit issue', '0', 'no_offer'),
    ('043847a8-8816-4379-af44-8a68dae8a802', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Purple Dress', 'S', 255000, 'Dresses', 'approved', '0', 'offer,245000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('6608ef6d-eb6c-4d84-bb40-8ec429b8db3f', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'White Pants', 'M', 150000, 'Bottoms', 'approved', '0', 'no_offer'),
    ('607d069c-0fd8-4fba-9c4c-9abddc01f979', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Black Sweater', 'L', 190000, 'Outerwear', 'approved', '0', 'no_offer,55923e3a-5781-42a4-858c-309605badaf3'),
    ('3dbd8f3e-8ede-4aee-9ed8-d5f14f4d416f', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Red Blouse', 'S', 132000, 'Tops', 'waiting', '0', 'no_offer'),
    ('9cbc3460-82a0-47d3-9d9e-d4c3d706d619', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Yellow Tank Top', 'M', 97000, 'Tops', 'approved', '0', 'no_offer'),
    ('ee3efe3d-7dae-48cd-8c59-200d282202ab', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Gray Shorts', 'L', 86000, 'Bottoms', 'approved', '0', 'no_offer'),
    ('147137be-e660-4070-9873-105215ccf88d', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Black Jacket', 'XL', 330000, 'Outerwear', 'approved', '0', 'offer,310000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('1e510dbe-0fd5-45bb-8945-5af69a559db2', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'White Hoodie', 'M', 240000, 'Outerwear', 'approved', '0', 'no_offer'),
    ('a2dd142d-3fa2-44c0-8f49-6f8175a53bb3', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Pink Dress', 'S', 270000, 'Dresses', 'approved', '0', 'offer,260000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('825ae865-3ad2-4060-87e9-990c43142f81', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Blue Blouse', 'L', 137000, 'Tops', 'declined,Fabric issue', '0', 'no_offer'),
    ('d662587b-c33c-40e3-b384-f520de8f50fa', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Orange T-shirt', 'M', 107000, 'Tops', 'bought', '0', 'no_offer'),
    ('d0e9cfbc-e241-441a-8ecc-6ba25902fe95', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Green Pants', 'L', 159000, 'Bottoms', 'approved', '0', 'no_offer'),
    ('9844c4ee-8695-4fa6-8935-c893ff569571', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Yellow Dress', 'S', 265000, 'Dresses', 'waiting', '0', 'no_offer'),
    ('193a0953-c600-4ca0-a54b-d236d81fc4cc', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Black Shorts', 'M', 87000, 'Bottoms', 'approved', '0', 'no_offer'),
    ('4d05f57e-69d4-418f-9bb9-52aba7b73aa7', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Red Tank Top', 'L', 92000, 'Tops', 'approved', '0', 'no_offer'),
    ('d0e4392f-62fd-4b65-bf19-deb43815485f', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Blue Skirt', 'S', 142000, 'Bottoms', 'approved', '0', 'no_offer'),
    ('c4d03078-aaae-480a-9abb-79aed9da8481', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Gray Jacket', 'XL', 340000, 'Outerwear', 'approved', '0', 'offer,320000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('aa5a5209-bdad-41fd-a3b7-89fa37882df5', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'White Sweater', 'M', 195000, 'Outerwear', 'approved', '0', 'no_offer'),
    ('9e0099e7-8b0f-43a1-9b9d-42b386b29d20', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Pink Blouse', 'L', 138000, 'Tops', 'approved', '0', 'no_offer'),
    ('d57bbfbe-c189-4f3e-b020-671cb2abb5bb', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Brown Dress', 'S', 275000, 'Dresses', 'approved', '0', 'offer,265000,55923e3a-5781-42a4-858c-309605badaf3'),
    ('22d3e50c-2e6e-46ab-ac9e-dded1b9681fb', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Green Hoodie', 'M', 250000, 'Outerwear', 'approved', '0', 'no_offer'),
    ('bef59b49-bb95-458f-958e-b8a9fb7d569b', 'b4e480c9-e689-4b45-91b7-b737063f312b', 'Yellow Jeans', 'L', 170000, 'Bottoms', 'bought', '0', 'no_offer');

INSERT INTO transaction (User_id, Item_id, transaction_id)
VALUES
('55923e3a-5781-42a4-858c-309605badaf3', '2225cbc2-d679-4a08-8306-891f0711937c', '6c317993-e100-446c-8e6f-383ef68d1f54'),
('55923e3a-5781-42a4-858c-309605badaf3', 'bef59b49-bb95-458f-958e-b8a9fb7d569b', '98296f43-58cc-4977-84f7-5196e3d1a900'),
('55923e3a-5781-42a4-858c-309605badaf3', 'd662587b-c33c-40e3-b384-f520de8f50fa', '12113913-dec5-4391-94d7-7b8753e39d6b');

INSERT INTO wishlist(Wishlist_id, Item_id, User_id)
VALUES
('ce3016c6-c718-4e5b-9171-36ccc3bfa939', '67a3b3b9-e8f6-4f9c-959f-89923d3b9501', '55923e3a-5781-42a4-858c-309605badaf3'),
('238a30aa-1921-4700-880a-5af7eb46f489', '9e0099e7-8b0f-43a1-9b9d-42b386b29d20', '55923e3a-5781-42a4-858c-309605badaf3'),
('4b354b9a-000d-48a9-8d9b-8e62e03c4874', '043847a8-8816-4379-af44-8a68dae8a802', '55923e3a-5781-42a4-858c-309605badaf3');