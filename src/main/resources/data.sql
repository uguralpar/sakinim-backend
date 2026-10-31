INSERT INTO messages (id, content)
VALUES (1, 'Hello, World!')
ON CONFLICT (id) DO NOTHING;
