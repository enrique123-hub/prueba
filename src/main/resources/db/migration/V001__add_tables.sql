CREATE TABLE suppliers (
    supplierId VARCHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    details TEXT,
    RFC VARCHAR(50) UNIQUE NOT NULL,
    phone VARCHAR(20),
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_supplier_id PRIMARY KEY (supplierId)
);

CREATE INDEX idx_suppliers_name ON suppliers (name);
CREATE INDEX idx_suppliers_rfc ON suppliers (RFC);

CREATE TABLE trade (
    tradeId VARCHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    details TEXT,
    code VARCHAR(100) UNIQUE NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    supplierId VARCHAR(36) NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_tradeId PRIMARY KEY (tradeId),
    CONSTRAINT fk_supplier FOREIGN KEY (supplierId) REFERENCES suppliers (supplierId) ON DELETE CASCADE
);

CREATE INDEX idx_trade_name ON trade (name);
CREATE INDEX idx_trade_supplier_id ON trade (supplierId);
CREATE INDEX idx_trade_code ON trade (code);