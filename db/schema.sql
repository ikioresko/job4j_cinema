create TABLE account (
  id SERIAL PRIMARY KEY,
  username VARCHAR NOT NULL,
  email VARCHAR NOT NULL UNIQUE,
  phone VARCHAR NOT NULL UNIQUE
);

create TABLE ticket (
    id SERIAL PRIMARY KEY,
    session_id INT NOT NULL,
    row INT NOT NULL,
    cell INT NOT NULL,
    account_id INT NOT NULL REFERENCES account(id),
    CONSTRAINT place UNIQUE(session_id, row, cell)
);

create TABLE hall (
    id SERIAL PRIMARY KEY,
    row INT NOT NULL,
    cell INT NOT NULL,
    itsfree boolean NOT NULL,
);