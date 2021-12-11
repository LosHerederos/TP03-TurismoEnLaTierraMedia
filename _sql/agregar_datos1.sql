-- Carga de datos 1

-- Carga de Usuario Administrador
INSERT INTO "Usuarios" (
	"esAdmin",
	"nombre",
	"presupuesto",
	"tiempoDisponible",
	"idTipoDeAtraccion"
)
VALUES
-- esAdmin: integer, nombre: text, presupuesto: integer, tiempoDisponible: real, idTipoDeAtraccion: integer
	(1, 'Admin', 1000, 12.0, 1)

;

-- Carga de Usuarios
INSERT INTO "Usuarios" (
	"nombre",
	"presupuesto",
	"tiempoDisponible",
	"idTipoDeAtraccion"
)
VALUES
-- nombre: text, presupuesto: integer, tiempoDisponible: real, idTipoDeAtraccion: integer
	('Eowyn', 10, 8.0, 1),
	('Gandalf', 100, 5.0, 2),
	('Sam', 36, 8.0, 3),
	('Galadriel', 120, 3.0, 2)
;

-- Carga de Itinerarios
INSERT INTO "Itinerarios" (
	"idUsuario"
)
VALUES
-- idUsuario: integer
	(1),
	(2),
	(3),
	(4),
	(5)
;

-- Carga de Atracciones
INSERT INTO "Atracciones" (
	"nombre",
	"descripcion",
	"imagen",
	"costoVisita",
	"tiempoParaRealizarla",
	"cupoPersonas",
	"idTipoDeAtraccion"
)
VALUES
-- nombre: text, descripcion: text, imagen: text, costoVisita: integer, tiempoParaRealizarla: real, cupoPersonas: integer, idTipoDeAtraccion: integer
	('Moria', 'Moria. Lorem ipsum dolor sit amet.', 'atraccion.jpg', 10, 2.0, 6, 1),
	('Minas Tirith', 'Minas Tirith. Lorem ipsum dolor sit amet.', 'atraccion.jpg', 5, 2.5, 25, 2),
	('La Comarca', 'La Comarca. Lorem ipsum dolor sit amet.', 'atraccion.jpg', 3, 6.5, 150, 3),
	('Mordor', 'Mordor. Lorem ipsum dolor sit amet.', 'atraccion.jpg', 25, 3.0, 4, 1),
	('Abismo del Helm', 'Abismo del Helm. Lorem ipsum dolor sit amet.', 'atraccion.jpg', 5, 2.0, 15, 2),
	('Lothlórien', 'Lothlórien. Lorem ipsum dolor sit amet.', 'atraccion.jpg', 35, 1.0, 30, 3),
	('Erebor', 'Erebor. Lorem ipsum dolor sit amet.', 'atraccion.jpg', 12, 3.0, 32, 2),
	('Bosque Negro', 'Bosque Negro. Lorem ipsum dolor sit amet.', 'atraccion.jpg', 3, 4.0, 12, 1)
;

-- Carga de Promociones base
INSERT INTO "Promociones" (
	"nombre",
	"descripcion",
	"imagen",
	"idTipoDeAtraccion",
	"tipoDePromocion"
)
VALUES
-- nombre: text, descripcion: text, imagen: text, idTipoDeAtraccion: integer, tipoDePromocion: text
	('Pack aventura', 'Pack aventura. Lorem ipsum dolor sit amet.', 'promocion.jpg', 1, 'PromocionPorcentual'),
	('Pack degustación', 'Pack degustación. Lorem ipsum dolor sit amet.', 'promocion.jpg', 3, 'PromocionAbsoluta'),
	('Pack paisajes', 'Pack paisajes. Lorem ipsum dolor sit amet.', 'promocion.jpg', 2, 'PromocionAXB') 
;

-- Carga de Atracciones de Promociones
INSERT INTO "AtraccionesDePromociones" (
	"idPromocion",
	"idAtraccion"
)
VALUES
-- idPromocion: integer, idAtraccion: integer, promocionNoGeneral: integer
	(1, 8),
	(1, 4),
	(2, 6),
	(2, 3),
	(3, 7)
;

-- Carga de Promociones absolutas
INSERT INTO "PromocionAbsoluta" (
	"idPromocion",
	"costoTotal"
)
VALUES
-- idPromocion: integer, costoTotal: integer
	(2, 36)
;

-- Carga de Promociones Porcentuales
INSERT INTO "PromocionPorcentual" (
	"idPromocion",
	"porcentaje"
)
VALUES
-- idPromocion: integer, porcentaje: real
	(1, 0.2)
;

-- Carga de Atracciones de Promociones AxB
INSERT INTO "AtraccionesDePromociones" (
	"idPromocion",
	"idAtraccion",
	"promocionNoGeneral"
)
VALUES
	(3, 2, 1),
	(3, 5, 1)
;