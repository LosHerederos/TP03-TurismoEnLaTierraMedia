BEGIN TRANSACTION;
CREATE TABLE "Atracciones" (
	"idAtraccion"	INTEGER NOT NULL UNIQUE,
	"eliminado"	INTEGER,
	"nombre"	TEXT,
	"descripcion"	TEXT,
	"imagen"	TEXT,
	"costoVisita"	INTEGER,
	"tiempoParaRealizarla"	REAL,
	"cupoPersonas"	INTEGER,
	"visitantes"	INTEGER DEFAULT 0,
	"idTipoDeAtraccion"	INTEGER,
	FOREIGN KEY("idTipoDeAtraccion") REFERENCES "TipoDeAtraccion"("idTipoDeAtraccion"),
	PRIMARY KEY("idAtraccion" AUTOINCREMENT)
);

CREATE TABLE "Promociones" (
	"idPromocion"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT,
	"descripcion"	TEXT,
	"imagen"	TEXT,
	"tipoDePromocion"	TEXT,
	"eliminado"	INTEGER,
	PRIMARY KEY("idPromocion" AUTOINCREMENT)
);


CREATE TABLE "Usuarios" (
	"idUsuario"	INTEGER NOT NULL UNIQUE,
	"esAdmin"	INTEGER NOT NULL DEFAULT 0,
	"eliminado"	INTEGER,
	"nombre"	TEXT,
	"presupuesto"	INTEGER,
	"tiempoDisponible"	REAL,
	"idTipoDeAtraccion"	INTEGER,
	FOREIGN KEY("idTipoDeAtraccion") REFERENCES "TipoDeAtraccion"("idTipoDeAtraccion"),
	PRIMARY KEY("idUsuario" AUTOINCREMENT)
);
COMMIT;
