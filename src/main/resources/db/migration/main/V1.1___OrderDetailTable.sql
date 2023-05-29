-- Create the OrderDetail table
CREATE TABLE OrderDetail (
  orderId SERIAL PRIMARY KEY,
  customerName VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  shippingAddress TEXT NOT NULL,
  totalAmount NUMERIC(10, 2) NOT NULL,
  orderDate DATE NOT NULL,
  status VARCHAR(20) NOT NULL
);

-- Create the OrderItem table
CREATE TABLE OrderItem (
  productId SERIAL PRIMARY KEY,
  orderId INT NOT NULL,
  productName VARCHAR(255) NOT NULL,
  unitPrice NUMERIC(10, 2) NOT NULL,
  quantity INT NOT NULL,
  subtotal NUMERIC(10, 2) NOT NULL,
  FOREIGN KEY (orderId) REFERENCES OrderDetail (orderId)
);

