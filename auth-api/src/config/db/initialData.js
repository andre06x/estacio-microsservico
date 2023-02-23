import bcrypt from "bcrypt";
import { randomUUID } from "crypto";
import Estudante from "../../modules/estudante/model/Estudante.js";

export async function createInitialData() {
  try {
    await Estudante.sync({ force: true });

    const password = await bcrypt.hash("123456", 10);

    await Estudante.create({
      id: randomUUID(),
      id_usuario: randomUUID(),
      email: "201908274417@alunos.estacio.br",
      matricula: "201908274417",
      curso: "Sistemas de Informação",
      validade: "20/07/2022",
      password,
    });
  } catch (err) {
    console.log("Err" + err.message);
  }
}
