CREATE TABLE product (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  description varchar(45) DEFAULT NULL,
  price float8 DEFAULT NULL,
  availability BOOL NULL,
  CONSTRAINT product_pkey PRIMARY KEY (id)
);


CREATE TABLE roles (
  user_id VARCHAR(50) NOT NULL,
  role VARCHAR(50) NOT NULL,
  UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES members (user_id)
);


CREATE TABLE members (
 user_id VARCHAR(50) NOT NULL,
 pw char(68) NOT NULL,
 active BOOLEAN NOT NULL,
 PRIMARY KEY (user_id)
);


