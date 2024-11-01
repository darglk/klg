CREATE TABLE client_logs (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    content TEXT NOT NULL,
    created_at TIMESTAMP(3) WITH TIME ZONE NOT NULL DEFAULT current_timestamp(3)
);

CREATE TABLE client_settings (
  auto_destroy BOOLEAN DEFAULT FALSE NOT NULL
);