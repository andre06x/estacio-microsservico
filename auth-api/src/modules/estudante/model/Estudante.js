import sequelize from "../../../config/db/dbConfig.js";
import Sequelize from "sequelize";

const Estudante = sequelize.define(
  "estudante",
  {
    id: {
      type: Sequelize.STRING,
      primaryKey: true,
    },
    id_usuario: {
      type: Sequelize.STRING,
      allowNull: false,
    },
    matricula: {
      type: Sequelize.STRING,
      allowNull: false,
    },
    curso: {
      type: Sequelize.STRING,
      allowNull: false,
    },
    validade: {
      type: Sequelize.STRING,
      allowNull: false,
    },
    email: {
      type: Sequelize.STRING,
      allowNull: false,
      unique: true,
      validate: {
        isEmail: true,
      },
    },
    password: {
      type: Sequelize.STRING,
      allowNull: false,
    },
  },
  {}
);

export default Estudante;
