import { Sequelize } from "sequelize";
import {
  DB_HOST,
  API_SECRET,
  DB_NAME,
  DB_PASSWORD,
  DB_PORT,
  DB_USER,
} from "../constants/secrets.js";

const sequelize = new Sequelize(DB_NAME, DB_USER, DB_PASSWORD, {
  host: DB_HOST,
  port: DB_PORT,
  dialect: "postgres",
  quoteIdentifiers: false,
  define: {
    synOnAssociation: true,
    timestamps: false,
    underscored: true,
    underscoredAll: true,
    freezeTableName: true,
  },
  pool: {
    acquire: 180000,
  },
});

sequelize
  .authenticate()
  .then(() => {
    console.log("Conexão estabelecida com auth-db.");
  })
  .catch((err) => {
    console.log("Erro ao conenectar com auth db");
    console.error(err.message);
  });

export default sequelize;
