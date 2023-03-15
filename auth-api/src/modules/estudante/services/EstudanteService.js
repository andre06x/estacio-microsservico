import bcrypt from "bcrypt";
import jwt from "jsonwebtoken";

import EstudanteRepository from "../repository/EstudanteRepository.js";
import EstudanteException from "../exception/EstudanteException.js";

import DadosUsuarios from "../model/client/Usuarios.js";

import * as httpStatus from "../../../config/constants/httpStatus.js";
import * as secrets from "../../../config/constants/secrets.js";

class EstudanteService {
  async findById(req) {
    try {
      // const { id } = req.params;
      const { authUser } = req;
      const { authorization } = req.headers;
      console.log(authUser);

      this.validateRequestData(authUser);

      let estudante = await EstudanteRepository.findById(authUser.id);
      console.log(estudante.id_usuario);
      let usuario = await DadosUsuarios.getDataUser(
        estudante.id_usuario,
        authorization
      );

      this.validateEstudanteNotFound(estudante);
      this.validateAuthenticatedEstudante(estudante, authUser);
      // console.log(estudante);
      return {
        status: httpStatus.SUCCESS,
        estudante: {
          id: estudante.id,
          email: estudante.email,
          campus: estudante.campus,
          curso: estudante.curso,
          validade: estudante.validade,
        },
        usuario,
      };
    } catch (err) {
      return {
        status: err.status ? err.status : httpStatus.INTERNAL_SERVER_ERROR,
        message: err.message,
      };
    }
  }

  async findByIdAdmin(req) {
    try {
      const { id } = req.params;
      const { authUser } = req;
      const { authorization } = req.headers;

      this.validateRequestData(authUser);

      let estudante = await EstudanteRepository.findById(id);
      this.validateEstudanteNotFound(estudante);

      let usuario = await DadosUsuarios.getDataUser(
        estudante.id_usuario,
        authorization
      );

      // console.log(estudante);
      return {
        status: httpStatus.SUCCESS,
        estudante: {
          id: estudante.id,
          email: estudante.email,
          campus: estudante.campus,
          curso: estudante.curso,
          validade: estudante.validade,
        },
        usuario,
      };
    } catch (err) {
      return {
        status: err.status ? err.status : httpStatus.INTERNAL_SERVER_ERROR,
        message: err.message,
      };
    }
  }

  validateRequestData(id) {
    if (!id) {
      throw new EstudanteException(
        httpStatus.BAD_REQUEST,
        "Email do estudante não foi informado."
      );
    }
  }

  validateEstudanteNotFound(estudante) {
    console.log(estudante);
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
      const { authorization } = req.headers;

      this.validateAccessTokenData(email, password);

      let estudante = await EstudanteRepository.findByEmail(email);
      this.validateEstudanteNotFound(estudante);

      let usuario = await DadosUsuarios.getDataUser(
        estudante.id_usuario,
        authorization
      );

      let authUser = {
        id: estudante.id,
        id_usuario: estudante.id_usuario,
        email: estudante.email,
        admin: usuario.admin,
      };
      console.log(authUser);

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

  async putEstudante(req) {
    try {
      const { id } = req.params;
      this.validateId(id);

      let estudante = await EstudanteRepository.findById(id);
      this.validateEstudanteNotFound(estudante);

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

      const atualizandoEstudante = await EstudanteRepository.putEstudante(
        id,
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
        atualizandoEstudante,
      };
    } catch (err) {
      return {
        status: err.status ? err.status : httpStatus.INTERNAL_SERVER_ERROR,
        message: err.message,
      };
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
      console.log(novoEstudante);
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

  async deleteById(req) {
    try {
      const { id } = req.params;
      this.validateId(id);

      let estudante = await EstudanteRepository.findById(id);
      this.validateEstudanteNotFound(estudante);

      const { message } = await EstudanteRepository.deleteById(id);
      return {
        status: httpStatus.SUCCESS,
        message,
      };
    } catch (err) {
      return {
        status: err.status ? err.status : httpStatus.INTERNAL_SERVER_ERROR,
        message: err.message,
      };
    }
  }

  async findAll(req) {
    try {
      const { authorization } = req.headers;

      let estudante = await EstudanteRepository.findAll();
      this.validateEstudantes(estudante);

      for (let i = 0; i < estudante.length; i++) {
        let usuario = await DadosUsuarios.getDataUser(
          estudante[i].id_usuario,
          authorization
        );
        estudante[i] = { ...estudante[i].dataValues, usuario };
      }

      return {
        status: httpStatus.SUCCESS,
        estudante,
      };
    } catch (err) {
      return {
        status: err.status ? err.status : httpStatus.INTERNAL_SERVER_ERROR,
        message: err.message,
      };
    }
  }

  validateId(id) {
    if (!id) {
      throw new EstudanteException(
        httpStatus.BAD_REQUEST,
        "Não foi definido ID"
      );
    }
  }

  validateEstudantes(estudantes) {
    if (!estudantes || estudantes.length === 0) {
      throw new EstudanteException(
        httpStatus.BAD_REQUEST,
        "Não foi encontrado nenhum estudante"
      );
    }
  }
}

export default new EstudanteService();
