BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Itinerarios" (
	"idItinerario"	INTEGER NOT NULL UNIQUE,
	"idUsuario"	INTEGER NOT NULL UNIQUE,
	FOREIGN KEY("idUsuario") REFERENCES "Usuarios"("idUsuario"),
	PRIMARY KEY("idItinerario" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Usuarios" (
	"idUsuario"	INTEGER NOT NULL UNIQUE,
	"esAdmin"	INTEGER NOT NULL DEFAULT 0,
	"nombre"	TEXT NOT NULL UNIQUE,
	"presupuesto"	INTEGER,
	"tiempoDisponible"	REAL,
	"idTipoDeAtraccion"	INTEGER,
	"eliminado"	INTEGER NOT NULL DEFAULT 0,
	PRIMARY KEY("idUsuario" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Atracciones" (
	"idAtraccion"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL UNIQUE,
	"descripcion"	TEXT,
	"imagen"	TEXT,
	"costoVisita"	INTEGER,
	"tiempoParaRealizarla"	REAL,
	"cupoPersonas"	INTEGER,
	"visitantes"	INTEGER DEFAULT 0,
	"idTipoDeAtraccion"	INTEGER,
	"eliminado"	INTEGER NOT NULL DEFAULT 0,
	PRIMARY KEY("idAtraccion" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Promociones" (
	"idPromocion"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL UNIQUE,
	"descripcion"	TEXT,
	"imagen"	TEXT,
	"idTipoDeAtraccion"	INTEGER,
	"tipoDePromocion"	TEXT NOT NULL,
	"eliminado"	INTEGER NOT NULL DEFAULT 0,
	PRIMARY KEY("idPromocion" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "PromocionPorcentual" (
	"idPromocion"	INTEGER NOT NULL UNIQUE,
	"porcentaje"	REAL NOT NULL,
	FOREIGN KEY("idPromocion") REFERENCES "Promociones"("idPromocion"),
	PRIMARY KEY("idPromocion")
);
CREATE TABLE IF NOT EXISTS "PromocionAbsoluta" (
	"idPromocion"	INTEGER NOT NULL UNIQUE,
	"costoTotal"	INTEGER NOT NULL,
	FOREIGN KEY("idPromocion") REFERENCES "Promociones"("idPromocion"),
	PRIMARY KEY("idPromocion")
);
CREATE TABLE IF NOT EXISTS "AtraccionesDePromociones" (
	"idPromocion"	INTEGER NOT NULL,
	"idAtraccion"	INTEGER NOT NULL,
	"promocionNoGeneral"	INTEGER NOT NULL DEFAULT 0,
	FOREIGN KEY("idAtraccion") REFERENCES "Atracciones"("idAtraccion"),
	FOREIGN KEY("idPromocion") REFERENCES "Promociones"("idPromocion"),
	PRIMARY KEY("idAtraccion","idPromocion")
);
CREATE TABLE IF NOT EXISTS "AtraccionesDeItinerarios" (
	"idItinerario"	INTEGER NOT NULL UNIQUE,
	"idAtraccion"	INTEGER NOT NULL UNIQUE,
	FOREIGN KEY("idAtraccion") REFERENCES "Atracciones"("idAtraccion"),
	FOREIGN KEY("idItinerario") REFERENCES "Itinerarios"("idItinerario"),
	PRIMARY KEY("idItinerario","idAtraccion")
);
CREATE TABLE IF NOT EXISTS "PromocionesDeItinerarios" (
	"idItinerario"	INTEGER NOT NULL UNIQUE,
	"idPromocion"	INTEGER NOT NULL UNIQUE,
	FOREIGN KEY("idPromocion") REFERENCES "Promociones"("idPromocion"),
	FOREIGN KEY("idItinerario") REFERENCES "Itinerarios"("idItinerario"),
	PRIMARY KEY("idItinerario","idPromocion")
);
COMMIT;
