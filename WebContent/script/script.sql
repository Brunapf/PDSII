create database db_sb;
use db_sb;

show tables;

select * from tb_livro;
select * from TB_EDITORA;
select * from tb_categoria;


INSERT INTO TB_CATEGORIA(CD_CATEGORIA,DS_CATEGORIA,NM_CATEGORIA)
VALUES(1,'Livros de romance','ROMANCE'),
	  (2,'Livros de terror','TERROR'),
      (3,'Livros de drama','DRAMA'),
      (4,'Livros de suspense','SUSPENSE'),
      (5,'Livros de comédia','COMÉDIA'),
      (6,'Diversos documentários','DOCUMENTÁRIOS'),
      (7,'Livros de magia','MAGIA'),
      (8,'Livros infantis','INFANTIL');

INSERT INTO TB_EDITORA(CD_EDITORA,DS_CEP,DS_CIDADE,DS_EDITORA,DS_ENDERECO,NM_EDITORA,DS_PAIS,DS_TELEFONE)
VALUES(1,'38400-432','Uberlândia','Editora de grande porte','Rua Divino Cala 98','Editora Sucess','Brasil','(34)3423-4422'),
	  (2,'32400-987','São Gotardo','Editora de pequeno porte','Rua Aparecida 875','Carla Edições','Brasil','(34)3243-7952'),
	  (3,'31533-984','São Paulo','Editora excelente','Rua Jõao de Paula 7583','Editora Bruno','Brasil','(34)3465-8766'),
	  (4,'39875-113','Pará','Editora boa','Rua Canabara 4332','Editora Family','Brasil','(34)3345-1113');
      
INSERT INTO TB_LIVRO(CD_LIVRO,NM_LIVRO,QT_PAGINAS,CD_CATEGORIA,CD_EDITORA)
VALUES(1,'Harry Potter',568,7,3),
	  (2,'Cidade do sol',340,3,4),
      (3,'Não conte a ninguém',432,1,1),
      (4,'O menino de Minas',234,5,3),
      (5,'Muito mais que 5 minutos',216,5,2),
      (6,'Gil Bates',450,6,3),
      (7,'O pequeno príncipe',123,8,3);