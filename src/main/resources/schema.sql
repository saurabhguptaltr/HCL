DROP TABLE IF EXISTS TBL_TICKET;
 
CREATE TABLE TBL_TICKET (
  ticket_id INT AUTO_INCREMENT  PRIMARY KEY,
  user_id VARCHAR(250) NOT NULL,
  train_id INT NOT NULL,
  status VARCHAR(25) NOT NULL,
  number_of_ticket DOUBLE NOT NULL,
  ticket_booking_date DATE NOT NULL,
  travelling_date DATE NOT NULL
);