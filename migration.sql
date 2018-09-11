drop DATABASE IF EXISTS v_blog_db;
create DATABASE IF NOT EXISTS v_blog_db;

USE v_blog_db;

DROP TABLE IF EXISTS post;

CREATE TABLE post (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(200) NOT NULL,
  body VARCHAR(2500) NOT NULL,
  PRIMARY KEY (id)
);