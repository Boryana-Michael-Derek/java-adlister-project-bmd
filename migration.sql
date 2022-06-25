USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)

);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE TABLE categories (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    category VARCHAR(240) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads_categories (
    ads_id INTEGER UNSIGNED NOT NULL,
    categories_id INTEGER UNSIGNED NOT NULL,
    FOREIGN KEY (ads_id) REFERENCES ads(id),
    FOREIGN KEY (categories_id) REFERENCES categories(id)
);

INSERT INTO categories(category) VALUES
    ('cool'),
    ('weird'),
    ('boring'),
    ('random'),
    ('new'),
    ('old');

INSERT INTO ads_categories (ads_id, categories_id)
    VALUES (1, 3), (1,4), (1,6), (2, 3), (2, 6);