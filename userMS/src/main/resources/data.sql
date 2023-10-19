
-- Drop tables if they exist
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS account;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS user (
  id bigint(20) NOT NULL PRIMARY KEY,
  phone int(9) NOT NULL,
  email varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  surname varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  role varchar(255) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `account`
--

CREATE TABLE IF NOT EXISTS account (
  id bigint(20) NOT NULL PRIMARY KEY,
  money_balance int(20) NOT NULL,
  created_at date NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_accounts`
--

CREATE TABLE IF NOT EXISTS account (
  id_user bigint(20) NOT NULL PRIMARY KEY,
  id_account bigint(20) NOT NULL PRIMARY KEY

);
