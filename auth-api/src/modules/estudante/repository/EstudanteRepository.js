import Estudante from "../model/Estudante.js";
import { randomUUID } from "crypto";
import bcrypt from "bcrypt";

class EstudanteRepository {
  async findById(id) {
    try {
      return await Estudante.findOne({ where: { id } });
    } catch (err) {
      console.error(err.message);
      return null;
    }
  }

  async findByEmail(email) {
    try {
      return await Estudante.findOne({ where: { email } });
    } catch (err) {
      console.error(err.message);
      return null;
    }
  }

  async createEstudante(
    email,
    password,
    id_usuario,
    matricula,
    curso,
    validade
  ) {
    try {
      const pass = await bcrypt.hash("123456", 10);

      let estudante = await Estudante.create({
        id: randomUUID(),
        id_usuario,
        email,
        password: pass,
        matricula,
        curso,
        validade,
      });

      console.log(estudante.dataValues);
      return estudante.dataValues;
    } catch (err) {
      console.error(err.message);
      return null;
    }
  }
}

export default new EstudanteRepository();
