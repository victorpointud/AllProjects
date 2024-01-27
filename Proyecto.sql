--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.0

-- Started on 2023-11-14 18:42:31 -04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: proyecto; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA proyecto;


ALTER SCHEMA proyecto OWNER TO pg_database_owner;

--
-- TOC entry 3722 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA proyecto; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA proyecto IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 16500)
-- Name: APLICACIÓN; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."APLICACIÓN" (
    id_producto integer NOT NULL,
    "versión_ios" character varying NOT NULL,
    nombre character varying NOT NULL,
    "temática" character varying NOT NULL,
    "tamaño_mb" integer NOT NULL,
    costo real NOT NULL,
    "puntuación" integer,
    "descripción" character varying,
    "versión" character varying NOT NULL,
    id integer NOT NULL
);


ALTER TABLE proyecto."APLICACIÓN" OWNER TO postgres;

--
-- TOC entry 3723 (class 0 OID 0)
-- Dependencies: 219
-- Name: TABLE "APLICACIÓN"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."APLICACIÓN" IS 'Tabla dónde se almacena la Información de la aplicación';


--
-- TOC entry 3724 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN "APLICACIÓN".id_producto; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."APLICACIÓN".id_producto IS 'Id de Producto';


--
-- TOC entry 3725 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN "APLICACIÓN"."versión_ios"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."APLICACIÓN"."versión_ios" IS 'IOS Mínimo de Aplicación';


--
-- TOC entry 3726 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN "APLICACIÓN".nombre; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."APLICACIÓN".nombre IS 'Nombre de la Aplicación';


--
-- TOC entry 3727 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN "APLICACIÓN"."temática"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."APLICACIÓN"."temática" IS 'Temática de Aplicación';


--
-- TOC entry 3728 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN "APLICACIÓN"."tamaño_mb"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."APLICACIÓN"."tamaño_mb" IS 'Tamaño de Aplicación';


--
-- TOC entry 3729 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN "APLICACIÓN".costo; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."APLICACIÓN".costo IS 'Costo de Aplicación';


--
-- TOC entry 3730 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN "APLICACIÓN"."puntuación"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."APLICACIÓN"."puntuación" IS 'Puntuación de Aplicación';


--
-- TOC entry 3731 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN "APLICACIÓN"."descripción"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."APLICACIÓN"."descripción" IS 'Descripción de Aplicación';


--
-- TOC entry 3732 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN "APLICACIÓN"."versión"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."APLICACIÓN"."versión" IS 'Versión de Aplicación';


--
-- TOC entry 3733 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN "APLICACIÓN".id; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."APLICACIÓN".id IS 'Id de Proveedor';


--
-- TOC entry 216 (class 1259 OID 16423)
-- Name: ARTISTA; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."ARTISTA" (
    id_artista integer NOT NULL,
    nom_artistico character varying NOT NULL,
    nombre character varying NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL
);


ALTER TABLE proyecto."ARTISTA" OWNER TO postgres;

--
-- TOC entry 3734 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE "ARTISTA"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."ARTISTA" IS 'Tabla dónde se almacena la Información del artista';


--
-- TOC entry 3735 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN "ARTISTA".id_artista; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."ARTISTA".id_artista IS 'Id del Artista';


--
-- TOC entry 3736 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN "ARTISTA".nom_artistico; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."ARTISTA".nom_artistico IS 'Nombre de Artista';


--
-- TOC entry 3737 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN "ARTISTA".nombre; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."ARTISTA".nombre IS 'Nombre de Casa Disquera';


--
-- TOC entry 3738 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN "ARTISTA".fecha_inicio; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."ARTISTA".fecha_inicio IS 'Fecha de Inicio de Artista';


--
-- TOC entry 3739 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN "ARTISTA".fecha_fin; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."ARTISTA".fecha_fin IS 'Fecha de Fin de Artista';


--
-- TOC entry 220 (class 1259 OID 16533)
-- Name: CANCIÓN; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."CANCIÓN" (
    id_producto integer NOT NULL,
    fecha_lanz date NOT NULL,
    nomb_disco character varying NOT NULL,
    und_vendidas integer NOT NULL,
    "duración" time without time zone NOT NULL,
    "género" character varying NOT NULL,
    costo real NOT NULL,
    "puntuación" integer,
    "nomb_canción" character varying NOT NULL,
    "id_canción" integer NOT NULL,
    id_artista integer NOT NULL
);


ALTER TABLE proyecto."CANCIÓN" OWNER TO postgres;

--
-- TOC entry 3740 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE "CANCIÓN"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."CANCIÓN" IS 'Tabla dónde se almacena la Información de la canción';


--
-- TOC entry 3741 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN "CANCIÓN".id_producto; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CANCIÓN".id_producto IS 'Id de Producto';


--
-- TOC entry 3742 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN "CANCIÓN".fecha_lanz; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CANCIÓN".fecha_lanz IS 'Fecha de Lanzamiento de Canción';


--
-- TOC entry 3743 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN "CANCIÓN".nomb_disco; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CANCIÓN".nomb_disco IS 'Nombre de Disco de Canción';


--
-- TOC entry 3744 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN "CANCIÓN".und_vendidas; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CANCIÓN".und_vendidas IS 'Unidades Vendidas de Canción';


--
-- TOC entry 3745 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN "CANCIÓN"."duración"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CANCIÓN"."duración" IS 'Duración de Canción';


--
-- TOC entry 3746 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN "CANCIÓN"."género"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CANCIÓN"."género" IS 'Género de Canción';


--
-- TOC entry 3747 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN "CANCIÓN".costo; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CANCIÓN".costo IS 'Costo de Canción';


--
-- TOC entry 3748 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN "CANCIÓN"."puntuación"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CANCIÓN"."puntuación" IS 'Puntuación de Canción';


--
-- TOC entry 3749 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN "CANCIÓN"."nomb_canción"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CANCIÓN"."nomb_canción" IS 'Nombre de Canción';


--
-- TOC entry 3750 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN "CANCIÓN"."id_canción"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CANCIÓN"."id_canción" IS 'Id de Canción';


--
-- TOC entry 3751 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN "CANCIÓN".id_artista; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CANCIÓN".id_artista IS 'Id de Artista';


--
-- TOC entry 215 (class 1259 OID 16390)
-- Name: CASA DISQUERA; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."CASA DISQUERA" (
    nombre character varying NOT NULL,
    id_ciudad_disq integer NOT NULL
);


ALTER TABLE proyecto."CASA DISQUERA" OWNER TO postgres;

--
-- TOC entry 3752 (class 0 OID 0)
-- Dependencies: 215
-- Name: TABLE "CASA DISQUERA"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."CASA DISQUERA" IS 'Tabla dónde se almacena la Información de la Casa Disquera';


--
-- TOC entry 3753 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN "CASA DISQUERA".nombre; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CASA DISQUERA".nombre IS 'Nombre de la Disquera';


--
-- TOC entry 3754 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN "CASA DISQUERA".id_ciudad_disq; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CASA DISQUERA".id_ciudad_disq IS 'Id de Ciudad Disquera';


--
-- TOC entry 227 (class 1259 OID 17087)
-- Name: CIUDAD CASA DISQUERA; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."CIUDAD CASA DISQUERA" (
    nombre character varying NOT NULL,
    id_ciudad_disq integer NOT NULL,
    municipio character varying NOT NULL,
    calle character varying NOT NULL,
    cod_postal integer NOT NULL,
    cod_viv integer NOT NULL
);


ALTER TABLE proyecto."CIUDAD CASA DISQUERA" OWNER TO postgres;

--
-- TOC entry 3755 (class 0 OID 0)
-- Dependencies: 227
-- Name: TABLE "CIUDAD CASA DISQUERA"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."CIUDAD CASA DISQUERA" IS 'Tabla dónde se almacena la Información de la ciudad casa disquera';


--
-- TOC entry 3756 (class 0 OID 0)
-- Dependencies: 227
-- Name: COLUMN "CIUDAD CASA DISQUERA".nombre; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD CASA DISQUERA".nombre IS 'Nombre de Disquera';


--
-- TOC entry 3757 (class 0 OID 0)
-- Dependencies: 227
-- Name: COLUMN "CIUDAD CASA DISQUERA".id_ciudad_disq; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD CASA DISQUERA".id_ciudad_disq IS 'Id de Ciudad Casa Disquera';


--
-- TOC entry 3758 (class 0 OID 0)
-- Dependencies: 227
-- Name: COLUMN "CIUDAD CASA DISQUERA".municipio; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD CASA DISQUERA".municipio IS 'Municipio de Ciudad Casa Disquera';


--
-- TOC entry 3759 (class 0 OID 0)
-- Dependencies: 227
-- Name: COLUMN "CIUDAD CASA DISQUERA".calle; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD CASA DISQUERA".calle IS 'Calle de Ciudad Casa Disquera';


--
-- TOC entry 3760 (class 0 OID 0)
-- Dependencies: 227
-- Name: COLUMN "CIUDAD CASA DISQUERA".cod_postal; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD CASA DISQUERA".cod_postal IS 'Código Postal de Ciudad Casa Disquera';


--
-- TOC entry 3761 (class 0 OID 0)
-- Dependencies: 227
-- Name: COLUMN "CIUDAD CASA DISQUERA".cod_viv; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD CASA DISQUERA".cod_viv IS 'Código de Vivienda de Ciudad Casa Disquera';


--
-- TOC entry 228 (class 1259 OID 17099)
-- Name: CIUDAD PROVEEDOR; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."CIUDAD PROVEEDOR" (
    id_ciudad_prov integer NOT NULL,
    municipio character varying NOT NULL,
    calle character varying NOT NULL,
    cod_postal integer NOT NULL,
    cod_viv integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE proyecto."CIUDAD PROVEEDOR" OWNER TO postgres;

--
-- TOC entry 3762 (class 0 OID 0)
-- Dependencies: 228
-- Name: TABLE "CIUDAD PROVEEDOR"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."CIUDAD PROVEEDOR" IS 'Tabla dónde se almacena la Información de la ciudad proveedor';


--
-- TOC entry 3763 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN "CIUDAD PROVEEDOR".id_ciudad_prov; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD PROVEEDOR".id_ciudad_prov IS 'Id de Ciudad Proveedor';


--
-- TOC entry 3764 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN "CIUDAD PROVEEDOR".municipio; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD PROVEEDOR".municipio IS 'Municipio de Ciudad Porvedoor';


--
-- TOC entry 3765 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN "CIUDAD PROVEEDOR".calle; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD PROVEEDOR".calle IS 'Calle de Ciudad Proveedor';


--
-- TOC entry 3766 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN "CIUDAD PROVEEDOR".cod_postal; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD PROVEEDOR".cod_postal IS 'Código Postal de Ciudad Proveedor';


--
-- TOC entry 3767 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN "CIUDAD PROVEEDOR".cod_viv; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD PROVEEDOR".cod_viv IS 'Código de Vivienda de Ciudad Proveedor';


--
-- TOC entry 3768 (class 0 OID 0)
-- Dependencies: 228
-- Name: COLUMN "CIUDAD PROVEEDOR".id; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD PROVEEDOR".id IS 'Id de Proveedor';


--
-- TOC entry 229 (class 1259 OID 17125)
-- Name: CIUDAD USUARIO; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."CIUDAD USUARIO" (
    id_ciudad_usu integer NOT NULL,
    municipio character varying NOT NULL,
    calle character varying NOT NULL,
    cod_postal integer NOT NULL,
    cod_viv integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE proyecto."CIUDAD USUARIO" OWNER TO postgres;

--
-- TOC entry 3769 (class 0 OID 0)
-- Dependencies: 229
-- Name: TABLE "CIUDAD USUARIO"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."CIUDAD USUARIO" IS 'Tabla dónde se almacena la Información de la ciudad usuario';


--
-- TOC entry 3770 (class 0 OID 0)
-- Dependencies: 229
-- Name: COLUMN "CIUDAD USUARIO".id_ciudad_usu; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD USUARIO".id_ciudad_usu IS 'Id de Ciudad Usuario';


--
-- TOC entry 3771 (class 0 OID 0)
-- Dependencies: 229
-- Name: COLUMN "CIUDAD USUARIO".municipio; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD USUARIO".municipio IS 'Municipio de Ciudad Usuario';


--
-- TOC entry 3772 (class 0 OID 0)
-- Dependencies: 229
-- Name: COLUMN "CIUDAD USUARIO".calle; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD USUARIO".calle IS 'Calle de Ciudad Usuario';


--
-- TOC entry 3773 (class 0 OID 0)
-- Dependencies: 229
-- Name: COLUMN "CIUDAD USUARIO".cod_postal; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD USUARIO".cod_postal IS 'Código Postal de Ciudad Usuario';


--
-- TOC entry 3774 (class 0 OID 0)
-- Dependencies: 229
-- Name: COLUMN "CIUDAD USUARIO".cod_viv; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD USUARIO".cod_viv IS 'Código de Vivienda de Ciudad Usuario';


--
-- TOC entry 3775 (class 0 OID 0)
-- Dependencies: 229
-- Name: COLUMN "CIUDAD USUARIO".id; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."CIUDAD USUARIO".id IS 'Id de Usuario';


--
-- TOC entry 225 (class 1259 OID 16854)
-- Name: COMPRA; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."COMPRA" (
    id_producto integer NOT NULL,
    fecha_compra date NOT NULL,
    id_promo integer NOT NULL,
    monto real NOT NULL,
    rating integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE proyecto."COMPRA" OWNER TO postgres;

--
-- TOC entry 3776 (class 0 OID 0)
-- Dependencies: 225
-- Name: TABLE "COMPRA"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."COMPRA" IS 'Tabla dónde se almacena la Información de Compra';


--
-- TOC entry 3777 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN "COMPRA".id_producto; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."COMPRA".id_producto IS 'Id de Producto';


--
-- TOC entry 3778 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN "COMPRA".fecha_compra; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."COMPRA".fecha_compra IS 'Fecha de Compra de Compra';


--
-- TOC entry 3779 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN "COMPRA".id_promo; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."COMPRA".id_promo IS 'Id de Promoción';


--
-- TOC entry 3780 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN "COMPRA".monto; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."COMPRA".monto IS 'Monto de Compra';


--
-- TOC entry 3781 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN "COMPRA".rating; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."COMPRA".rating IS 'Rating de Compra';


--
-- TOC entry 3782 (class 0 OID 0)
-- Dependencies: 225
-- Name: COLUMN "COMPRA".id; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."COMPRA".id IS 'Id de Usuario';


--
-- TOC entry 221 (class 1259 OID 16555)
-- Name: DISPOSITIVO; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."DISPOSITIVO" (
    id_producto integer NOT NULL,
    modelo character varying NOT NULL,
    "versión_ios" character varying NOT NULL,
    capacidad integer NOT NULL,
    costo real NOT NULL,
    "puntuación" integer NOT NULL,
    "generación" character varying NOT NULL
);


ALTER TABLE proyecto."DISPOSITIVO" OWNER TO postgres;

--
-- TOC entry 3783 (class 0 OID 0)
-- Dependencies: 221
-- Name: TABLE "DISPOSITIVO"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."DISPOSITIVO" IS 'Tabla dónde se almacena la Información del dispositivo';


--
-- TOC entry 3784 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN "DISPOSITIVO".id_producto; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."DISPOSITIVO".id_producto IS 'Id de Usuario';


--
-- TOC entry 3785 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN "DISPOSITIVO".modelo; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."DISPOSITIVO".modelo IS 'Modelo de Dispositivo';


--
-- TOC entry 3786 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN "DISPOSITIVO"."versión_ios"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."DISPOSITIVO"."versión_ios" IS 'IOS Mínimo de Dispositivo';


--
-- TOC entry 3787 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN "DISPOSITIVO".capacidad; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."DISPOSITIVO".capacidad IS 'Capacidad de Dispositivo';


--
-- TOC entry 3788 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN "DISPOSITIVO".costo; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."DISPOSITIVO".costo IS 'Costo de Dispositivo';


--
-- TOC entry 3789 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN "DISPOSITIVO"."puntuación"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."DISPOSITIVO"."puntuación" IS 'Puntuación de Dispositivo';


--
-- TOC entry 3790 (class 0 OID 0)
-- Dependencies: 221
-- Name: COLUMN "DISPOSITIVO"."generación"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."DISPOSITIVO"."generación" IS 'Generación de Dispositivo';


--
-- TOC entry 224 (class 1259 OID 16794)
-- Name: DISPOSITIVOS_COMP; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."DISPOSITIVOS_COMP" (
    id_producto integer NOT NULL,
    dispositivo character varying NOT NULL
);


ALTER TABLE proyecto."DISPOSITIVOS_COMP" OWNER TO postgres;

--
-- TOC entry 3791 (class 0 OID 0)
-- Dependencies: 224
-- Name: TABLE "DISPOSITIVOS_COMP"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."DISPOSITIVOS_COMP" IS 'Tabla dónde se almacena la Información de dispositivos compatibles';


--
-- TOC entry 3792 (class 0 OID 0)
-- Dependencies: 224
-- Name: COLUMN "DISPOSITIVOS_COMP".id_producto; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."DISPOSITIVOS_COMP".id_producto IS 'Id de Producto';


--
-- TOC entry 3793 (class 0 OID 0)
-- Dependencies: 224
-- Name: COLUMN "DISPOSITIVOS_COMP".dispositivo; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."DISPOSITIVOS_COMP".dispositivo IS 'Dispositivo de Dispositivos Comprados';


--
-- TOC entry 223 (class 1259 OID 16776)
-- Name: PAÍSES; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."PAÍSES" (
    "país" character varying NOT NULL,
    id_promo integer NOT NULL
);


ALTER TABLE proyecto."PAÍSES" OWNER TO postgres;

--
-- TOC entry 3794 (class 0 OID 0)
-- Dependencies: 223
-- Name: TABLE "PAÍSES"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."PAÍSES" IS 'Tabla dónde se almacena la Información de los países';


--
-- TOC entry 3795 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN "PAÍSES"."país"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PAÍSES"."país" IS 'País de Países';


--
-- TOC entry 3796 (class 0 OID 0)
-- Dependencies: 223
-- Name: COLUMN "PAÍSES".id_promo; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PAÍSES".id_promo IS 'Id de Promoción';


--
-- TOC entry 218 (class 1259 OID 16483)
-- Name: PRODUCTO; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."PRODUCTO" (
    id_producto integer NOT NULL,
    costo real NOT NULL,
    "puntuación" integer NOT NULL
);


ALTER TABLE proyecto."PRODUCTO" OWNER TO postgres;

--
-- TOC entry 3797 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE "PRODUCTO"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."PRODUCTO" IS 'Tabla dónde se almacena la Información del producto';


--
-- TOC entry 3798 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN "PRODUCTO".id_producto; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PRODUCTO".id_producto IS 'Id de Producto';


--
-- TOC entry 3799 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN "PRODUCTO".costo; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PRODUCTO".costo IS 'Costo de Producto';


--
-- TOC entry 3800 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN "PRODUCTO"."puntuación"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PRODUCTO"."puntuación" IS 'Puntuación de Producto';


--
-- TOC entry 217 (class 1259 OID 16476)
-- Name: PROMOCIÓN; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."PROMOCIÓN" (
    id_promo integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL,
    "duración" time without time zone NOT NULL,
    descuento real NOT NULL
);


ALTER TABLE proyecto."PROMOCIÓN" OWNER TO postgres;

--
-- TOC entry 3801 (class 0 OID 0)
-- Dependencies: 217
-- Name: TABLE "PROMOCIÓN"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."PROMOCIÓN" IS 'Tabla dónde se almacena la Información de la promoción';


--
-- TOC entry 3802 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN "PROMOCIÓN".id_promo; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROMOCIÓN".id_promo IS 'Código de Promoción';


--
-- TOC entry 3803 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN "PROMOCIÓN".fecha_inicio; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROMOCIÓN".fecha_inicio IS 'Fecha de Inicio de Promoción';


--
-- TOC entry 3804 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN "PROMOCIÓN".fecha_fin; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROMOCIÓN".fecha_fin IS 'Fecha de Culminación de Promoción';


--
-- TOC entry 3805 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN "PROMOCIÓN"."duración"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROMOCIÓN"."duración" IS 'Duración de Promoción';


--
-- TOC entry 3806 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN "PROMOCIÓN".descuento; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROMOCIÓN".descuento IS 'Descuento Aplicable de Promoción';


--
-- TOC entry 222 (class 1259 OID 16773)
-- Name: PROVEEDOR; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."PROVEEDOR" (
    id integer NOT NULL,
    id_ciudad_prov integer NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    correo character varying NOT NULL,
    fecha_afil date NOT NULL,
    tipo_proveedor character varying NOT NULL
);


ALTER TABLE proyecto."PROVEEDOR" OWNER TO postgres;

--
-- TOC entry 3807 (class 0 OID 0)
-- Dependencies: 222
-- Name: TABLE "PROVEEDOR"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."PROVEEDOR" IS 'Tabla dónde se almacena la Información del proveedor';


--
-- TOC entry 3808 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN "PROVEEDOR".id; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROVEEDOR".id IS 'Id de Proveedor';


--
-- TOC entry 3809 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN "PROVEEDOR".id_ciudad_prov; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROVEEDOR".id_ciudad_prov IS 'Id de Ciudad Proveedor';


--
-- TOC entry 3810 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN "PROVEEDOR".nombre; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROVEEDOR".nombre IS 'Nombre de Proveedor';


--
-- TOC entry 3811 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN "PROVEEDOR".apellido; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROVEEDOR".apellido IS 'Apellido de Proveedor';


--
-- TOC entry 3812 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN "PROVEEDOR".correo; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROVEEDOR".correo IS 'Correo de Proveedor';


--
-- TOC entry 3813 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN "PROVEEDOR".fecha_afil; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROVEEDOR".fecha_afil IS 'Fecha de Afiliciación de Proveedor';


--
-- TOC entry 3814 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN "PROVEEDOR".tipo_proveedor; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."PROVEEDOR".tipo_proveedor IS 'Tipo de Proveedor';


--
-- TOC entry 226 (class 1259 OID 17075)
-- Name: USUARIO; Type: TABLE; Schema: proyecto; Owner: postgres
--

CREATE TABLE proyecto."USUARIO" (
    id integer NOT NULL,
    fecha_venc date NOT NULL,
    num_trj integer NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    correo character varying NOT NULL,
    id_ciudad_usu integer NOT NULL
);


ALTER TABLE proyecto."USUARIO" OWNER TO postgres;

--
-- TOC entry 3815 (class 0 OID 0)
-- Dependencies: 226
-- Name: TABLE "USUARIO"; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON TABLE proyecto."USUARIO" IS 'Tabla dónde se almacena la Información de Usuario';


--
-- TOC entry 3816 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN "USUARIO".id; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."USUARIO".id IS 'Id de Usuario';


--
-- TOC entry 3817 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN "USUARIO".fecha_venc; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."USUARIO".fecha_venc IS 'Fecha de Vencimiento de Usuario';


--
-- TOC entry 3818 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN "USUARIO".num_trj; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."USUARIO".num_trj IS 'Número de Tarjeta de Usuario';


--
-- TOC entry 3819 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN "USUARIO".nombre; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."USUARIO".nombre IS 'Nombre de Usuario';


--
-- TOC entry 3820 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN "USUARIO".apellido; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."USUARIO".apellido IS 'Apellido de Usuario';


--
-- TOC entry 3821 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN "USUARIO".correo; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."USUARIO".correo IS 'Correo de Usuario';


--
-- TOC entry 3822 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN "USUARIO".id_ciudad_usu; Type: COMMENT; Schema: proyecto; Owner: postgres
--

COMMENT ON COLUMN proyecto."USUARIO".id_ciudad_usu IS 'Id de Ciudad Usuario';


--
-- TOC entry 3706 (class 0 OID 16500)
-- Dependencies: 219
-- Data for Name: APLICACIÓN; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."APLICACIÓN" (id_producto, "versión_ios", nombre, "temática", "tamaño_mb", costo, "puntuación", "descripción", "versión", id) FROM stdin;
\.


--
-- TOC entry 3703 (class 0 OID 16423)
-- Dependencies: 216
-- Data for Name: ARTISTA; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."ARTISTA" (id_artista, nom_artistico, nombre, fecha_inicio, fecha_fin) FROM stdin;
\.


--
-- TOC entry 3707 (class 0 OID 16533)
-- Dependencies: 220
-- Data for Name: CANCIÓN; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."CANCIÓN" (id_producto, fecha_lanz, nomb_disco, und_vendidas, "duración", "género", costo, "puntuación", "nomb_canción", "id_canción", id_artista) FROM stdin;
\.


--
-- TOC entry 3702 (class 0 OID 16390)
-- Dependencies: 215
-- Data for Name: CASA DISQUERA; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."CASA DISQUERA" (nombre, id_ciudad_disq) FROM stdin;
\.


--
-- TOC entry 3714 (class 0 OID 17087)
-- Dependencies: 227
-- Data for Name: CIUDAD CASA DISQUERA; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."CIUDAD CASA DISQUERA" (nombre, id_ciudad_disq, municipio, calle, cod_postal, cod_viv) FROM stdin;
\.


--
-- TOC entry 3715 (class 0 OID 17099)
-- Dependencies: 228
-- Data for Name: CIUDAD PROVEEDOR; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."CIUDAD PROVEEDOR" (id_ciudad_prov, municipio, calle, cod_postal, cod_viv, id) FROM stdin;
\.


--
-- TOC entry 3716 (class 0 OID 17125)
-- Dependencies: 229
-- Data for Name: CIUDAD USUARIO; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."CIUDAD USUARIO" (id_ciudad_usu, municipio, calle, cod_postal, cod_viv, id) FROM stdin;
\.


--
-- TOC entry 3712 (class 0 OID 16854)
-- Dependencies: 225
-- Data for Name: COMPRA; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."COMPRA" (id_producto, fecha_compra, id_promo, monto, rating, id) FROM stdin;
\.


--
-- TOC entry 3708 (class 0 OID 16555)
-- Dependencies: 221
-- Data for Name: DISPOSITIVO; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."DISPOSITIVO" (id_producto, modelo, "versión_ios", capacidad, costo, "puntuación", "generación") FROM stdin;
\.


--
-- TOC entry 3711 (class 0 OID 16794)
-- Dependencies: 224
-- Data for Name: DISPOSITIVOS_COMP; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."DISPOSITIVOS_COMP" (id_producto, dispositivo) FROM stdin;
\.


--
-- TOC entry 3710 (class 0 OID 16776)
-- Dependencies: 223
-- Data for Name: PAÍSES; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."PAÍSES" ("país", id_promo) FROM stdin;
\.


--
-- TOC entry 3705 (class 0 OID 16483)
-- Dependencies: 218
-- Data for Name: PRODUCTO; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."PRODUCTO" (id_producto, costo, "puntuación") FROM stdin;
\.


--
-- TOC entry 3704 (class 0 OID 16476)
-- Dependencies: 217
-- Data for Name: PROMOCIÓN; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."PROMOCIÓN" (id_promo, fecha_inicio, fecha_fin, "duración", descuento) FROM stdin;
\.


--
-- TOC entry 3709 (class 0 OID 16773)
-- Dependencies: 222
-- Data for Name: PROVEEDOR; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."PROVEEDOR" (id, id_ciudad_prov, nombre, apellido, correo, fecha_afil, tipo_proveedor) FROM stdin;
\.


--
-- TOC entry 3713 (class 0 OID 17075)
-- Dependencies: 226
-- Data for Name: USUARIO; Type: TABLE DATA; Schema: proyecto; Owner: postgres
--

COPY proyecto."USUARIO" (id, fecha_venc, num_trj, nombre, apellido, correo, id_ciudad_usu) FROM stdin;
\.


--
-- TOC entry 3523 (class 2606 OID 16429)
-- Name: ARTISTA artista_pk; Type: CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."ARTISTA"
    ADD CONSTRAINT artista_pk PRIMARY KEY (id_artista);


--
-- TOC entry 3529 (class 2606 OID 16895)
-- Name: CANCIÓN canción_pk; Type: CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."CANCIÓN"
    ADD CONSTRAINT "canción_pk" PRIMARY KEY ("id_canción");


--
-- TOC entry 3521 (class 2606 OID 16396)
-- Name: CASA DISQUERA casa_disquera_pk; Type: CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."CASA DISQUERA"
    ADD CONSTRAINT casa_disquera_pk PRIMARY KEY (nombre);


--
-- TOC entry 3537 (class 2606 OID 17114)
-- Name: CIUDAD CASA DISQUERA ciudad_casa_disquera_pk; Type: CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."CIUDAD CASA DISQUERA"
    ADD CONSTRAINT ciudad_casa_disquera_pk PRIMARY KEY (id_ciudad_disq);


--
-- TOC entry 3539 (class 2606 OID 17107)
-- Name: CIUDAD PROVEEDOR ciudad_proveedor_pk; Type: CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."CIUDAD PROVEEDOR"
    ADD CONSTRAINT ciudad_proveedor_pk PRIMARY KEY (id_ciudad_prov);


--
-- TOC entry 3541 (class 2606 OID 17133)
-- Name: CIUDAD USUARIO ciudad_usuario_pk; Type: CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."CIUDAD USUARIO"
    ADD CONSTRAINT ciudad_usuario_pk PRIMARY KEY (id_ciudad_usu);


--
-- TOC entry 3533 (class 2606 OID 17039)
-- Name: COMPRA compra_pk; Type: CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."COMPRA"
    ADD CONSTRAINT compra_pk PRIMARY KEY (fecha_compra);


--
-- TOC entry 3527 (class 2606 OID 16489)
-- Name: PRODUCTO producto_pk; Type: CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."PRODUCTO"
    ADD CONSTRAINT producto_pk PRIMARY KEY (id_producto);


--
-- TOC entry 3525 (class 2606 OID 16782)
-- Name: PROMOCIÓN promoción_pk; Type: CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."PROMOCIÓN"
    ADD CONSTRAINT "promoción_pk" PRIMARY KEY (id_promo);


--
-- TOC entry 3531 (class 2606 OID 16807)
-- Name: PROVEEDOR proveedor_pk; Type: CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."PROVEEDOR"
    ADD CONSTRAINT proveedor_pk PRIMARY KEY (id);


--
-- TOC entry 3535 (class 2606 OID 17079)
-- Name: USUARIO usuario_pk; Type: CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."USUARIO"
    ADD CONSTRAINT usuario_pk PRIMARY KEY (id);


--
-- TOC entry 3546 (class 2606 OID 17033)
-- Name: CANCIÓN artista_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."CANCIÓN"
    ADD CONSTRAINT artista_fk FOREIGN KEY (id_artista) REFERENCES proyecto."ARTISTA"(id_artista);


--
-- TOC entry 3543 (class 2606 OID 16992)
-- Name: ARTISTA casa_disquera_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."ARTISTA"
    ADD CONSTRAINT casa_disquera_fk FOREIGN KEY (nombre) REFERENCES proyecto."CASA DISQUERA"(nombre);


--
-- TOC entry 3556 (class 2606 OID 17094)
-- Name: CIUDAD CASA DISQUERA casa_disquera_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."CIUDAD CASA DISQUERA"
    ADD CONSTRAINT casa_disquera_fk FOREIGN KEY (nombre) REFERENCES proyecto."CASA DISQUERA"(nombre);


--
-- TOC entry 3542 (class 2606 OID 17139)
-- Name: CASA DISQUERA ciudad_casa_disquera_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."CASA DISQUERA"
    ADD CONSTRAINT ciudad_casa_disquera_fk FOREIGN KEY (id_ciudad_disq) REFERENCES proyecto."CIUDAD CASA DISQUERA"(id_ciudad_disq);


--
-- TOC entry 3549 (class 2606 OID 17144)
-- Name: PROVEEDOR ciudad_proveedor_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."PROVEEDOR"
    ADD CONSTRAINT ciudad_proveedor_fk FOREIGN KEY (id_ciudad_prov) REFERENCES proyecto."CIUDAD PROVEEDOR"(id_ciudad_prov);


--
-- TOC entry 3555 (class 2606 OID 17149)
-- Name: USUARIO ciudad_usuario_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."USUARIO"
    ADD CONSTRAINT ciudad_usuario_fk FOREIGN KEY (id_ciudad_usu) REFERENCES proyecto."CIUDAD USUARIO"(id_ciudad_usu);


--
-- TOC entry 3551 (class 2606 OID 16801)
-- Name: DISPOSITIVOS_COMP producto_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."DISPOSITIVOS_COMP"
    ADD CONSTRAINT producto_fk FOREIGN KEY (id_producto) REFERENCES proyecto."PRODUCTO"(id_producto);


--
-- TOC entry 3544 (class 2606 OID 16825)
-- Name: APLICACIÓN producto_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."APLICACIÓN"
    ADD CONSTRAINT producto_fk FOREIGN KEY (id_producto) REFERENCES proyecto."PRODUCTO"(id_producto);


--
-- TOC entry 3548 (class 2606 OID 16830)
-- Name: DISPOSITIVO producto_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."DISPOSITIVO"
    ADD CONSTRAINT producto_fk FOREIGN KEY (id_producto) REFERENCES proyecto."PRODUCTO"(id_producto);


--
-- TOC entry 3547 (class 2606 OID 16835)
-- Name: CANCIÓN producto_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."CANCIÓN"
    ADD CONSTRAINT producto_fk FOREIGN KEY (id_producto) REFERENCES proyecto."PRODUCTO"(id_producto);


--
-- TOC entry 3552 (class 2606 OID 16866)
-- Name: COMPRA producto_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."COMPRA"
    ADD CONSTRAINT producto_fk FOREIGN KEY (id_producto) REFERENCES proyecto."PRODUCTO"(id_producto);


--
-- TOC entry 3550 (class 2606 OID 16789)
-- Name: PAÍSES promoción_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."PAÍSES"
    ADD CONSTRAINT "promoción_fk" FOREIGN KEY (id_promo) REFERENCES proyecto."PROMOCIÓN"(id_promo);


--
-- TOC entry 3553 (class 2606 OID 16871)
-- Name: COMPRA promoción_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."COMPRA"
    ADD CONSTRAINT "promoción_fk" FOREIGN KEY (id_promo) REFERENCES proyecto."PROMOCIÓN"(id_promo);


--
-- TOC entry 3545 (class 2606 OID 16987)
-- Name: APLICACIÓN proveedor_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."APLICACIÓN"
    ADD CONSTRAINT proveedor_fk FOREIGN KEY (id) REFERENCES proyecto."PROVEEDOR"(id);


--
-- TOC entry 3557 (class 2606 OID 17108)
-- Name: CIUDAD PROVEEDOR proveedor_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."CIUDAD PROVEEDOR"
    ADD CONSTRAINT proveedor_fk FOREIGN KEY (id) REFERENCES proyecto."PROVEEDOR"(id);


--
-- TOC entry 3554 (class 2606 OID 17080)
-- Name: COMPRA usuario_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."COMPRA"
    ADD CONSTRAINT usuario_fk FOREIGN KEY (id) REFERENCES proyecto."USUARIO"(id);


--
-- TOC entry 3558 (class 2606 OID 17134)
-- Name: CIUDAD USUARIO usuario_fk; Type: FK CONSTRAINT; Schema: proyecto; Owner: postgres
--

ALTER TABLE ONLY proyecto."CIUDAD USUARIO"
    ADD CONSTRAINT usuario_fk FOREIGN KEY (id) REFERENCES proyecto."USUARIO"(id);


-- Completed on 2023-11-14 18:42:31 -04

--
-- PostgreSQL database dump complete
--

