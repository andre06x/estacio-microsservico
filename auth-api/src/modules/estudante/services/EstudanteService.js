import bcrypt from "bcrypt";
import jwt from "jsonwebtoken";

import EstudanteRepository from "../repository/EstudanteRepository.js";
import EstudanteException from "../exception/EstudanteException.js";

import * as httpStatus from "../../../config/constants/httpStatus.js";
import * as secrets from "../../../config/constants/secrets.js";

class EstudanteService {
  async findByEmail(req) {
    try {
      const { email } = req.params;
      const { authUser } = req;

      this.validateRequestData(email);

      let estudante = await EstudanteRepository.findByEmail(email);
      this.validateEstudanteNotFound(estudante);
      this.validateAuthenticatedEstudante(estudante, authUser);
      console.log(estudante);
      return {
        status: httpStatus.SUCCESS,
        estudante: {
          id: estudante.id,
          id_usuario: estudante.id_usuario,
          email: estudante.email,
        },
      };
    } catch (err) {
      return {
        status: err.status ? err.status : httpStatus.INTERNAL_SERVER_ERROR,
        message: err.message,
      };
    }
  }

  validateRequestData(email) {
    if (!email) {
      throw new EstudanteException(
        httpStatus.BAD_REQUEST,
        "Email do estudante não foi informado."
      );
    }
  }

  validateEstudanteNotFound(estudante) {
    if (!estudante) {
      throw new EstudanteException(
        httpStatus.BAD_REQUEST,
        "Estudante não encontrado."
      );
    }
  }

  validateEstudanteFound(estudante) {
    if (estudante) {
      throw new EstudanteException(
        httpStatus.BAD_REQUEST,
        "Estudante já existe."
      );
    }
  }

  validateAuthenticatedEstudante(estudante, authUser) {
    if (!authUser || estudante.id !== authUser.id) {
      throw new EstudanteException(
        httpStatus.FORBIDDEN,
        "Você não pode ver esse dados."
      );
    }
  }

  async getAccessToken(req) {
    try {
      const { email, password } = req.body;

      this.validateAccessTokenData(email, password);
      let estudante = await EstudanteRepository.findByEmail(email);

      this.validateEstudanteNotFound(estudante);

      let authUser = {
        id: estudante.id,
        usuario_id: estudante.id,
        email: estudante.password,
      };

      const accessToken = jwt.sign({ authUser }, secrets.API_SECRET, {
        expiresIn: "1d",
      });

      return {
        status: httpStatus.SUCCESS,
        accessToken,
      };
    } catch (err) {
      return {
        status: err.status ? err.status : httpStatus.INTERNAL_SERVER_ERROR,
        message: err.message,
      };
    }
  }

  validateAccessTokenData(email, password) {
    if (!email || !password) {
      throw new EstudanteException(
        httpStatus.UNAUTHORIZED,
        "Email e senha não informados"
      );
    }
  }

  validateCreateEstudante(
    email,
    password,
    id_usuario,
    matricula,
    curso,
    campus,
    validade
  ) {
    if (
      !email ||
      !password ||
      !id_usuario ||
      !matricula ||
      !curso ||
      !campus ||
      !validade
    ) {
      throw new EstudanteException(
        httpStatus.UNAUTHORIZED,
        "Email / senha / id_usuario / matricula / curso / validade"
      );
    }
  }

  async validadePassword(password, hashPassword) {
    if (!(await bcrypt.compare(password, hashPassword))) {
      throw new UserException(httpStatus.UNAUTHORIZED, "Password não confere");
    }
  }

  async createEstudante(req) {
    try {
      const {
        email,
        password,
        id_usuario,
        matricula,
        curso,
        campus,
        validade,
      } = req.body;

      this.validateCreateEstudante(
        email,
        password,
        id_usuario,
        matricula,
        curso,
        campus,
        validade
      );

      let estudante = await EstudanteRepository.findByEmail(email);
      this.validateEstudanteFound(estudante);

      const novoEstudante = await EstudanteRepository.createEstudante(
        email,
        password,
        id_usuario,
        matricula,
        curso,
        campus,
        validade
      );

      return {
        status: httpStatus.SUCCESS,
        novoEstudante,
      };
    } catch (err) {
      return {
        status: err.status ? err.status : httpStatus.INTERNAL_SERVER_ERROR,
        message: err.message,
      };
    }
  }
}

export default new EstudanteService();
