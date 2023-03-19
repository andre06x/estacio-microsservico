import bcrypt from "bcrypt";
import { randomUUID } from "crypto";
import Estudante from "../../modules/estudante/model/Estudante.js";

export async function createInitialData() {
  try {
    // await Estudante.sync({ force: true });

    const password = await bcrypt.hash("123456", 10);

    await Estudante.create({
      id: "7708e029-f30d-40fa-8936-2467edbad6c1",
      id_usuario: "474d78b4-1797-4238-86e7-9afdd90ce2cc",
      email: "201908274417@alunos.estacio.br",
      matricula: "201908274417",
      campus: "NITEROI",
      curso: "Sistemas de Informação",
      validade: "20/07/2022",
      password,
    });
  } catch (err) {
    console.log("Err" + err.message);
  }
}
