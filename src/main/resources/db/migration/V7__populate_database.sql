INSERT INTO categories (id, name)
VALUES (1, 'Fruits & Vegetables'),
       (2, 'Dairy'),
       (3, 'Bakery'),
       (4, 'Meat & Seafood'),
       (5, 'Frozen Foods'),
       (6, 'Pantry'),
       (7, 'Snacks'),
       (8, 'Beverages');

INSERT INTO products (name, price, description, category_id)
VALUES
('Bananas Cavendish', 3.49, 'Fresh Cavendish bananas, perfect for snacking or smoothies. Sold per kg.', 1),
('Cherry Tomatoes 250g', 2.99, 'Sweet cherry tomatoes packed with flavour. Great for salads and cooking.', 1),

('Western Star Salted Butter 250g', 5.50, 'Premium Australian salted butter made from real cream.', 2),
('Devondale Full Cream Milk 2L', 3.40, 'Rich and creamy full cream milk sourced from Australian dairy farms.', 2),

('Tip Top Multigrain Bread 700g', 4.20, 'Soft and nutritious multigrain loaf packed with seeds and whole grains.', 3),

('Chicken Breast Fillets 1kg', 11.99, 'Lean Australian chicken breast fillets perfect for grilling or stir-fry.', 4),
('Fresh Atlantic Salmon Portions 400g', 14.50, 'Premium salmon portions sourced from Tasmanian waters.', 4),

('McCain Straight Cut Fries 1kg', 4.80, 'Crispy straight cut fries made from Australian potatoes.', 5),

('Barilla Spaghetti No.5 500g', 2.50, 'Authentic Italian spaghetti made from premium durum wheat.', 6),

('Smith’s Original Chips 170g', 3.70, 'Classic Aussie favourite potato chips with a perfectly salted crunch.', 7);

