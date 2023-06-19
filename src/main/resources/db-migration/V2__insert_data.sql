INSERT INTO card_brand (name, created_at, updated_at)
VALUES
('MasterCard', NOW(), NOW()),
('Visa', NOW(), NOW()),
('Diners Club', NOW(), NOW()),
('Elo', NOW(), NOW()),
('American Express', NOW(), NOW()),
('Maestro', NOW(), NOW());

INSERT INTO transaction_type (name, created_at, updated_at)
VALUES
('Credit', NOW(), NOW()),
('Debit', NOW(), NOW()),
('Cryptocurrency', NOW(), NOW()),
('Cash', NOW(), NOW()),
('Bank Transfer', NOW(), NOW());