CREATE DATABASE Hectareas
GO 

USE Hectareas
GO

CREATE TABLE Hectarea
(
	IdHectarea INT NOT NULL,
	Comunidad NVARCHAR(100),
	Renta INT,
	Ubicacion NVARCHAR(150)
)
GO


ALTER TABLE Hectarea 
ADD CONSTRAINT PK_Hectarea PRIMARY KEY (IdHectarea)
GO