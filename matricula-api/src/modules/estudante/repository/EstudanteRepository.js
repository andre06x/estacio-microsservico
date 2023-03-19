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
      const estudante = await Estudante.findOne({ where: { email } });

      return estudante;
    } catch (err) {
      console.error(err.message);
      return err.message;
    }
  }

  async putEstudante(
    id,
    email,
    password,
    id_usuario,
    matricula,
    curso,
    campus,
    validade
  ) {
    try {
      const pass = await bcrypt.hash(password, 10);

      let estudante = await Estudante.update(
        {
          email,
          password: pass,
          id_usuario,
          matricula,
          curso,
          campus,
          validade,
        },
        { where: { id } }
      );
      // console.log(estudante);
      return estudante;
    } catch (err) {
      return null;
    }
  }

  async createEstudante(
    email,
    password,
    id_usuario,
    matricula,
    curso,
    campus,
    validade
  ) {
    try {
      const pass = await bcrypt.hash(password, 10);

      let estudante = await Estudante.create({
        id: randomUUID(),
        id_usuario,
        email,
        password: pass,
        matricula,
        curso,
        campus,
        validade,
      });

      return estudante.dataValues;
    } catch (err) {
      console.error(err.message);
      return err.message;
    }
  }

  async deleteById(id) {
    try {
      await Estudante.destroy({ where: { id } });
      return {
        message: `Usuário ${id} deletado com sucesso`,
      };
    } catch (err) {
      return err.message;
    }
  }

  async findAll() {
    try {
      const estudantes = await Estudante.findAll();
      console.log(estudantes);
      return estudantes;
    } catch (err) {
      return err.message;
    }
  }
}

export default new EstudanteRepository();
