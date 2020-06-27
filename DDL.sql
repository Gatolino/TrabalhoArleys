-- =================> Criação de tabelas
CREATE TABLE Usuario (
	Id			int 			NOT NULL	PRIMARY KEY AUTO_INCREMENT,
	Nome		varchar(100)	NOT NULL,
	Login		varchar(100)	NOT NULL,
	Senha		varchar(16)		NOT NULL,
	IsArtista	bit				NOT NULL
);

CREATE TABLE Obra (
	Id			int 			NOT NULL	PRIMARY KEY AUTO_INCREMENT,
	Titulo		varchar(100)	NOT NULL,
	IdUsuario	int				NOT NULL,
	Tipo		int				NOT NULL, -- 0: Quadro, 1: Escultura, 2: Fotografia, 3: Graffiti
	Curtidas	int				NOT NULL
);

CREATE TABLE NovasObras (
	IdObra		int 			NOT NULL,
	IdUsuario	int				NOT NULL
);

CREATE TABLE TopObras (
	IdObra		int 			NOT NULL
	Curtidas	int				NOT NULL
);


-- =================> Trigger de Novas Obras
DROP TRIGGER IF EXISTS trg_NovaObra;

DELIMITER // -- Paleativo do MySQL para criação de StoreProcedures e Triggers

CREATE TRIGGER trg_NovaObra
AFTER INSERT
ON Obra

FOR EACH ROW
    
BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE id_usuario int;
	DECLARE cursor_Usuario CURSOR FOR SELECT ID FROM Usuario;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

	OPEN cursor_Usuario;
		myLoop: LOOP
			FETCH cursor_Usuario INTO id_usuario;
            
			IF done THEN
				LEAVE myLoop;
			END IF;
            
			INSERT INTO NovasObras
				VALUES (NEW.Id, id_usuario);
        
        END LOOP;
    
		
            
    CLOSE cursor_Usuario;
    
END;//
DELIMITER ;



-- =================> Trigger de Curtidas
DROP TRIGGER IF EXISTS trg_TopObras;

-- Paleativo do MySQL para criação de StoreProcedures e Triggers
DELIMITER //  

CREATE TRIGGER trg_TopObras
	AFTER UPDATE
	ON Obra
	FOR EACH ROW
    
BEGIN
	DECLARE topObrasTotal INT;
    DECLARE countAnterior INT;
    
    -- Dados sobre a [TopObra] com menos curtidas
    DECLARE menorId INT;
    DECLARE menorCurtida INT;
    
    SELECT COUNT(*)
		INTO topObrasTotal
        FROM TopObras;
        
	IF topObrasTotal < 2 THEN -- Enquanto houver menos que N [TopObras], novos registros são apenas adicionados
		DELETE 
			FROM TopObras
            WHERE IdObra = NEW.Id;
    
		INSERT INTO TopObras
			VALUES (NEW.Id, NEW.Curtidas);
    ELSE
		SELECT IdObra, Curtidas -- Procura a primeira [TopObras] com menor quantidade de curtidas
			INTO menorId, menorCurtida
			FROM TopObras
			ORDER BY Curtidas
			LIMIT 1;
		
		IF NEW.Curtidas > menorCurtida THEN
			SELECT COUNT(*) -- Procura se existe registro anterior daquela [Obra] no [TopObra]
				INTO countAnterior
				FROM TopObras
				WHERE IdObra = NEW.Id;
			
			IF countAnterior > 0 THEN -- Se houver, então deve apenas atualizar o registro da [TopObra]
				SET menorId = NEW.Id;
            END IF;     
            
            UPDATE TopObras
				SET
					IdObra = NEW.Id,
					Curtidas = NEW.Curtidas
				WHERE IdObra = menorId
				LIMIT 1;
				
		END IF;
	END IF;
    
END;//
DELIMITER ;