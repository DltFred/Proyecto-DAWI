DROP DATABASE IF EXISTS BD_VENTASPRODUCTOS2;
CREATE DATABASE BD_VENTASPRODUCTOS2;
USE BD_VENTASPRODUCTOS2;

-- TABLAS--
-- ¡TABLAS RELACIONADAS A LOS PRODUCTOS! --

-- (1) LA TABLA CATEGORIAS ==> PARA LOS PRODUCTOS--
CREATE TABLE tb_categoria(
id_cat INT NOT NULL,
nom_cat VARCHAR(60) NOT NULL,
PRIMARY KEY (id_cat)
);

-- ¡TABLAS DE PERSONAS SOLAMENTE!--
-- (2) LA TABLA PROVEEDOR --
CREATE TABLE tb_tienda(
id_tien CHAR(5) NOT NULL,
nom_tien VARCHAR(50) NOT NULL,
ruc_tien CHAR(11) NOT NULL,
dir_tien VARCHAR(50) NOT NULL,
telf_tien CHAR(15) NOT NULL,
ubi_tien varchar(200) not null,
PRIMARY KEY (id_tien)
);

-- (3) LA TABLA PRODUCTOS--
CREATE TABLE tb_producto(
id_prod CHAR(5) NOT NULL,
nom_prod VARCHAR(60) NOT NULL,
desc_prod VARCHAR(60) NOT NULL,
id_cat INT NOT NULL,
marc_prod VARCHAR(60) NOT NULL,
con_net_prod VARCHAR(20) NOT NULL,
pre_prod DECIMAL(8,2) NOT NULL,
id_tien CHAR(5) NULL,
stk_prod INT,
PRIMARY KEY (id_prod),
FOREIGN KEY (id_cat) REFERENCES tb_categoria(id_cat),
FOREIGN KEY (id_tien) REFERENCES tb_tienda(id_tien)
);

-- (4)LA TABLA USUARIOS--
CREATE TABLE tb_usuario(
id_usu INT AUTO_INCREMENT NOT NULL,
nom_usu VARCHAR(40) NOT NULL,
ape_usu VARCHAR(40) NOT NULL,
email_usu VARCHAR(60) NOT NULL UNIQUE,
cont_usu VARCHAR(20) NOT NULL,
loca_usu varchar(200) not null,
tipo_usu varchar(50) not null,
PRIMARY KEY (id_usu)
);

-- (6) NOTA DE BOLETA ==> PARA CONOCER SU ESTADO --
CREATE TABLE tb_nota_boleta(
id_es_bol INT NOT NULL,
des_es_bol VARCHAR(20) NOT NULL,
PRIMARY KEY(id_es_bol)
);

-- (7) LA TABLA BOLETA ==> PARA LOS PRODUCTOS --
CREATE TABLE tb_boleta(
id_bol CHAR(5) NOT NULL,
id_es_bol INT NOT NULL DEFAULT 1,
fec_ped CHAR(10),
id_usu int not null,
PRIMARY KEY (id_bol),
FOREIGN KEY (id_es_bol) REFERENCES tb_nota_boleta(id_es_bol),
FOREIGN KEY (id_usu) REFERENCES tb_usuario(id_usu)
);


-- (8) LA TABLA DETALLE DE BOLETA ==> PARA LA PRODUCTOS SOLICITADOS --
CREATE TABLE tb_detalle_boleta(
id_bol CHAR(5) NOT NULL,
id_prod CHAR(5) NOT NULL,
can_ped INT NOT NULL,
PRIMARY KEY(id_bol,id_prod),
FOREIGN KEY (id_bol) REFERENCES tb_boleta(id_bol),
FOREIGN KEY (id_prod) REFERENCES tb_producto(id_prod)
);
