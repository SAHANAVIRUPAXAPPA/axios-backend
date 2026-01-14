-- =========================
-- AXIOS : Initial Schema
-- =========================

-- =========================
-- USERS
-- =========================
CREATE TABLE users (
    id              UUID PRIMARY KEY,
    full_name       VARCHAR(100) NOT NULL,
    phone_number    VARCHAR(15)  NOT NULL UNIQUE,
    role            VARCHAR(20)  NOT NULL,
    created_at      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- TRANSACTIONS
-- =========================
CREATE TABLE transactions (
    id               UUID PRIMARY KEY,
    user_id          UUID NOT NULL,
    amount           NUMERIC(12,2) NOT NULL,
    transaction_type VARCHAR(20) NOT NULL,
    occurred_at      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_transaction_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);

-- =========================
-- CREDIT SCORES
-- =========================
CREATE TABLE credit_scores (
    id              UUID PRIMARY KEY,
    user_id         UUID NOT NULL,
    score           INTEGER NOT NULL,
    risk_level      VARCHAR(20) NOT NULL,
    generated_at    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_score_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);
