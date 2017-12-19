create table Customer (
   customerId BIGINT AUTO_INCREMENT primary key,
   firstName VARCHAR(255),
   lastName VARCHAR(255),
   phoneNumber VARCHAR(25),
   homeAddress BIGINT,
   workAddress BIGINT,
   email VARCHAR(255),
)  ENGINE=InnoDB ;
