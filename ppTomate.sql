CREATE TABLE produtos (
  idProduto INT AUTO_INCREMENT PRIMARY KEY,
  codigo VARCHAR(5) NOT NULL UNIQUE default '0000',
  marca VARCHAR(60) NOT NULL default '',
  modelo VARCHAR(100) NOT NULL default '',
  descricao VARCHAR(800) default '',
  estoque INT DEFAULT 0,
  preco_custo DOUBLE(10,2) NOT NULL default 0.00,
  preco_venda DOUBLE(10,2) NOT NULL default 38.00,
  imagem_url VARCHAR(500) default '',
  ativo BOOLEAN DEFAULT TRUE,
  shopee_item_id INT,
  shopee_variation_id INT,
  data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE shopee_auth (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  shop_id BIGINT,
  access_token TEXT NOT NULL,
  refresh_token TEXT NOT NULL,
  expires_at DATETIME
);
